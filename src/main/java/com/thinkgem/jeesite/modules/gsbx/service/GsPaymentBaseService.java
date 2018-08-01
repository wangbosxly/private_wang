package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPaymentBase;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

@Service
public class GsPaymentBaseService {

    @Autowired
    Nw_wsPort gsPort;

    /**
     * 查询人员缴费基数
     */
    public JSONObject findPaymentBase(GsPaymentBase gsPaymentBase, Page page) throws RemoteException {
        String str = JSON.toJSONString(gsPaymentBase, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("pageNo", page.getPageNo());
        jsonObject.put("pageSize", page.getPageSize());
        return JSONObject.parseObject(gsPort.nwws2103(jsonObject.toString()));
    }
    /**
     * 人员缴费基数申报保存
     */
    public JSONObject save(List<GsPaymentBase> gsPaymentBases) throws RemoteException {
        String str = JSONObject.toJSONString(gsPaymentBases,new PascalNameFilter());
        JSONArray array = JSONObject.parseArray(str);
        JSONArray jsonArray = new JSONArray();
        User user = UserUtils.getUser();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();
        for (Object o : array) {
            JSONObject json = (JSONObject) o;
            if(StringUtils.isEmpty(json.getString("AAC001"))){
                continue;
            }
            json.putAll(jsonObject);
            // 获取用户信息
            json.put("SAA036",saa036); //	受理单号
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
            json.put("AAE030", String.valueOf(Calendar.getInstance().getWeekYear())); //	开始年
            json.put("AAC040", json.getString("BAC504"));
//        jsonObject.put("AAC002","AAC002"); //	身份证
//        jsonObject.put("AAC003","AAC003"); //	姓名
            json.put("TAA101",CommonUtility.get19BitCurTimeAPP()); //	申报时间
//        jsonObject.put("AAE003","AAE003"); //	对应费款所属期
            json.put("AAE011",user.getGsAAE170()); //	经办人
            json.put("AAE036",CommonUtility.get19BitCurTimeAPP()); //	经办时间
            json.put("SAA037",user.getGsAAE170()); //	申请人
            json.put("SAA038",CommonUtility.get19BitCurTimeAPP()); //	申请时间
            json.put("SAA015","M4006"); //	功能id
//        jsonObject.put("BUS_ID","BUS_ID"); //	业务ID
//        jsonObject.put("SAA031","SAA031"); //	表单模板id
            json.put("SAA004"," "); //	事项id
            json.put("BAE702","1"); //	主体类型
            json.put("BAE703",user.getGsBAE703()); //	主体编号
            json.put("SAA043","3"); //	业务状态
            json.put("SZZ003"," "); //	服务机构ID
            json.put("TAA103","0"); //	审核结果
            json.put("TAA105","1"); //	申报来源
            jsonArray.add(json);
        }
        return JSONObject.parseObject(gsPort.nwws2302(jsonArray.toString()));
    }


}
