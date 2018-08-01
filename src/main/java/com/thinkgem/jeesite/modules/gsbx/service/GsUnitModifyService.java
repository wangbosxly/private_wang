package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsUnitModify;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * 描述:
 *
 * @author X_P
 * @create 2018-06-11 10:54
 */
@Service
@Transactional
public class GsUnitModifyService {

    @Autowired
    private Nw_wsPort gsPort;
    /**
     * 查询单位基本信息
     */
    public JSONObject queryUnitInfo() throws RemoteException {
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        String s = gsPort.nwws1101(jsonObject.toString());
        return JSONObject.parseObject(s);
    }

    /**
     * 修改单位基本信息
     */
    public JSONObject updateUnitInfo(GsUnitModify gsUnitModify) throws RemoteException {
        User user = UserUtils.getUser();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        String str = JSON.toJSONString(gsUnitModify, new PascalNameFilter());
        JSONObject json = JSONObject.parseObject(str);
        json.putAll(jsonObject);
        json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//流水号
        json.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());//订单号
        json.put("SAA015", "M4001");//功能id
        json.put("BAE702", "1");//主体类别 单位1 个人0
        json.put("BAE703", user.getGsBAE703());//主体编号
        json.put("SAA043", CodeConstant.SAA043_SAA043_3);//审核状态
        json.put("SAA037", user.getGsAAE170());//申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        //bae941 saa036 saa015 bae702 bae703 saa043 saa037 saa038
        String s = gsPort.nwws1701(json.toString());
        return JSONObject.parseObject(s);
    }
}