package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonInfoModify;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;

/**
 * 描述:
 * 失业人员信息修改
 *
 * @author X_P
 * @create 2018-06-07 15:42
 */
@Service
@Transactional
public class GsPersonInfoModifyService {

    @Autowired
    Nw_wsPort gsPort;

    /**
     * 通过姓名、个人编号等查询人员基本信息
     * @param gsPersonInfoModify
     * @return
     * @throws RemoteException
     */
    public JSONObject getPerson(GsPersonInfoModify gsPersonInfoModify,Page page) throws RemoteException {
        String str = JSON.toJSONString(gsPersonInfoModify, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("pageNo",page.getPageNo() );
        jsonObject.put("pageSize", page.getPageSize());
        String s = gsPort.nwws2101(jsonObject.toString());
        json = JSONObject.parseObject(s);
        return json;
    }

    /**
     * 保存人员基本信息
     * @param gsPersonInfoModify
     * @return
     */
    public JSONObject savePersonInfo(GsPersonInfoModify gsPersonInfoModify) throws RemoteException {
        String str = JSON.toJSONString(gsPersonInfoModify, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        jsonObject.putAll(json);
        jsonObject.put("BAE941", "XY" + CommonUtility.getBAE941());//★申报流水号.
        jsonObject.put("AAE011", user.getGsAAE170());//经办人.
        jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP());//经办时间.
        jsonObject.put("BAA008", CodeConstant.BAA008_BAA008_3);//复核标志.
        jsonObject.put("SAA036", "XY" + CommonUtility.getSAA036());//★受理单ID.
        jsonObject.put("AAE140", CodeConstant.AAE140_AAE140_2);// 险种类型
        jsonObject.put("TAE100", "2");//基本信息类别
        jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP());//★申报时间
        jsonObject.put("TAA102", CodeConstant.TAA102_TAA102_2);//★处理标志:已上传
        jsonObject.put("TAA103", CodeConstant.TAA103_TAA103_1);//★ 审核结果,0待审核,1审核通过,2审核不通过.
        jsonObject.put("TAA105", CodeConstant.TAA105_TAA105_1);//★申报来源,1网上大厅.
        jsonObject.put("SAA015", CodeConstant.SAA015_SAA015_M4003);// 功能id.
        jsonObject.put("SAA004", " ");// 事项id.
        jsonObject.put("SZZ003", " ");// 服务机构ID.
        jsonObject.put("BAE702", "1");// 主体类别(0个人,1单位).
        jsonObject.put("BAE703", user.getGsAAB001());// 主体编号.
        jsonObject.put("SAA037", user.getGsAAE170());// 申请人.
        jsonObject.put("SAA043", CodeConstant.SAA043_SAA043_3);// 业务状态:预审.
        jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP());// 申请时间.
        jsonObject.put("SAA031", "");
        jsonObject.put("BUS_ID", "");
        String s = gsPort.nwws2701(jsonObject.toString());
        json = JSONObject.parseObject(s);
        return json;
    }
}