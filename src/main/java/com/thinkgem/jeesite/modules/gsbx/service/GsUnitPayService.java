package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsUnitPay;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Service
public class GsUnitPayService {
    @Autowired
    Nw_wsPort gsPort;

    public JSONObject fingUnitInfo() throws RemoteException {
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        return JSONObject.parseObject(gsPort.nwws1102(jsonObject.toString()));
    }

    public JSONObject fingInfo(GsUnitPay gsUnitPay) throws RemoteException {
        String str = JSON.toJSONString(gsUnitPay, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("AAE140","4,5");
        return JSONObject.parseObject(gsPort.nwws1104(jsonObject.toString()));
    }

    public JSONObject save(List<GsUnitPay> gsUnitPays) throws RemoteException {
        // 获取用户信息
        JSONArray array = new JSONArray();
        String saa036 = "XY"+ GenerateSequenceUtil.generateSequenceNo();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        for (GsUnitPay gsUnitPay : gsUnitPays) {
            String str = JSON.toJSONString(gsUnitPay, new PascalNameFilter());
            JSONObject json = JSONObject.parseObject(str);
            json.putAll(jsonObject);
            array.add(json);
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
            json.put("SAA036",saa036);	// 订单号
            json.put("SAA015", "M4023");//SAA015:M4004,功能id
            json.put("BAE702", "1");//BAE702:1,z主体类型，单位
            json.put("BAE703", user.getGsBAE703());//主体编号 单位编号
            json.put("SAA043", "3");//SAA043:1,业务状态3 预审
            json.put("SAA037", user.getGsAAE170());//SAA037:ch,申请人
            json.put("SZZ003", user.getGsBAA001());//SZZ003:服务机构id(这里记录了数据分区)
            json.put("SAA038", DateUtils.formatDateTime(new Date())); //申请时间
            json.put("TAA103", CodeConstant.TAA103_TAA103_0);	// 审核结果
            json.put("TAA105", CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
        }
        return JSONObject.parseObject(gsPort.nwws1105(array.toString()));
    }

    /**
     * 查询单位缴费记录
     */
    public JSONObject getPaymentRecords(GsUnitPay gsUnitPay) throws RemoteException {
        String str = JSON.toJSONString(gsUnitPay);
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        //jsonObject.put("isSJ", "F");  //isSJ	是否实缴（T/F）	否
        return JSONObject.parseObject(gsPort.nwws1107(jsonObject.toString()));
    }

    /**
     * 获取打印报表信息
     * @param gsUnitPay
     * @return
     */
    public JSONObject getPrintInfo(GsUnitPay gsUnitPay) throws RemoteException {
        String str = JSON.toJSONString(gsUnitPay, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        return JSONObject.parseObject(gsPort.nwws1106(jsonObject.toString()));
    }
}
