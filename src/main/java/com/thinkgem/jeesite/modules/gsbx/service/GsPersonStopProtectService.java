package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonContinue;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author X_P
 * @create 2018-06-08 9:57
 */
@Service
@Transactional
public class GsPersonStopProtectService {

    @Autowired
    private Nw_wsPort gsPort;


    /**
     * 执行停保操作
     * @param aac001S
     * @return
     */
    public JSONObject executeStop(String[] aac001S,String cdate,String AAE160) throws RemoteException {
        JSONArray array = new JSONArray();
        String saa036 = "XY"+ GenerateSequenceUtil.generateSequenceNo();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        for (String str : aac001S) {
            String[] strs = str.split("&");
            JSONObject json = new JSONObject();
            json.putAll(jsonObject);//必传参数
            json.put("BKB026", user.getGsBKB026());//密匙密码
            json.put("AAC001", strs[0]);//个人编号
            json.put("AAE140", strs[1]);//险种 工伤，生育
            json.put("BAC510", cdate);//bAC510:2018-06-05, 续保时间
            json.put("AAE160", AAE160);//aAE160:121,停保原因
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
            json.put("SAA036",saa036);	// 订单号
            json.put("SAA015", "M4004");//SAA015:M4004,功能id
            json.put("BAE702", CodeConstant.BAE702_BAE702_1);//BAE702:1,z主体类型，单位
            json.put("BAE703", user.getGsBAE703());//主体编号 单位编号
            json.put("SAA043", CodeConstant.SAA043_SAA043_3);//SAA043:1,业务状态3 预审
            json.put("SAA037", user.getGsAAE170());//SAA037:ch,申请人
            json.put("SZZ003", user.getGsBAA001());//SZZ003:服务机构id(这里记录了数据分区)
            json.put("SAA038", DateUtils.formatDateTime(new Date())); //申请时间
            json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
            json.put("TAA103", CodeConstant.TAA103_TAA103_0);	// 审核结果
            json.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
            array.add(json);
        }
        String s = gsPort.nwws2702(array.toString());
        return JSONObject.parseObject(s);
    }

    /**
     * 批量提交停保
     * @param dataList
     * @return
     */
    public JSONObject executeStop(List<GsPersonContinue> dataList,String cdate,String AAE160) throws RemoteException {
        JSONArray array = new JSONArray();
        String saa036 = "XY"+ GenerateSequenceUtil.generateSequenceNo();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        for (GsPersonContinue gsPersonContinue : dataList) {
            String str = JSONObject.toJSONString(gsPersonContinue, new PascalNameFilter());
            JSONObject json = JSONObject.parseObject(str);
            if(StringUtils.isEmpty(json.getString("AAC001"))){
                continue;
            }
            json.putAll(jsonObject);
            json.put("BAC510", cdate);//bAC510:2018-06-05, 续保时间
            json.put("AAE160", AAE160);//aAE160:121,停保原因
            json.put("BKB026", user.getGsBKB026());//密匙密码
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
            json.put("SAA036",saa036);	// 订单号
            json.put("SAA015", "M4004");//SAA015:M4004,功能id
            json.put("BAE702", "1");//BAE702:1,z主体类型，单位
            json.put("BAE703", user.getGsBAE703());//主体编号 单位编号
            json.put("SAA043", "3");//SAA043:1,业务状态3 预审
            json.put("SAA037", user.getGsAAE170());//SAA037:ch,申请人
            json.put("SZZ003", user.getGsBAA001());//SZZ003:服务机构id(这里记录了数据分区)
            json.put("SAA038", DateUtils.formatDateTime(new Date())); //申请时间
            json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
            json.put("TAA103", CodeConstant.TAA103_TAA103_0);	// 审核结果
            json.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
            array.add(json);
        }
        String s = gsPort.nwws2702(array.toString());
        return JSONObject.parseObject(s);
    }
}