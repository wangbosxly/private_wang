package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;

@Service
public class YbPersonStopAndContinueService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject getPersonList(YbPerson ybPerson) throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(ybPerson, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2102(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject save(String[] AAC001S, YbPerson ybPerson) throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();
        for (String str : AAC001S) {
            String[] strs = str.split("&");
            JSONObject jsonObject = getCommonJson(ybPerson);
            jsonObject.put("SAA036", saa036); // 	受理单ID
            jsonObject.put("AAC001", strs[0].trim()); // 	个人编号
            jsonObject.put("BAC510", strs[1]); // 	最新参保时间
            jsonArray.add(jsonObject);
        }
        return sendJson(jsonArray, ybPerson);
    }

    public JSONObject executeStopAndContinue(List<YbPerson> dataList, YbPerson ybPerson) throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();
        for (YbPerson person : dataList) {
            JSONObject jsonObject = getCommonJson(ybPerson);
            jsonObject.put("SAA036", saa036); // 	受理单ID
            jsonObject.put("AAC001", person.getAAC001().trim()); //   个人编号
            jsonObject.put("AAC002", person.getAAC002().trim()); //   身份证
            jsonObject.put("AAC003", person.getAAC003()); //   姓名
            jsonObject.put("BAC510", ybPerson.getAAE035()); // 	最新参保时间
            jsonArray.add(jsonObject);
        }
        return sendJson(jsonArray, ybPerson);
    }

    /**
     * 接口调用
     */
    private JSONObject sendJson (JSONArray jsonArray, YbPerson ybPerson) throws RemoteException {
        String s;
        if (ybPerson.getSAA015().equals("M3004")) {
            // 人员停保
            s = ybPort.nwws2702(jsonArray.toString());
        } else {
            // 人员续保
            s = ybPort.nwws2703(jsonArray.toString());
        }
        return JSONObject.parseObject(s);
    }

    /**
     * 获取公共的jsonObject
     */
    private JSONObject getCommonJson (YbPerson ybPerson) {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("SAA004", " "); // 	事项ID
        jsonObject.put("BAE702", "1"); // 	主体类型（1 单位) 固定为1
        jsonObject.put("BAE703", user.getYbAAB001()); // 	主体编号
        jsonObject.put("SAA043", "3"); // 	业务状态（3 未受理，6已受理） 固定为3
        jsonObject.put("SAA037", user.getYbAAE170()); // 	申请人
        jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP()); // 申请时间
        jsonObject.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo()); // 申报流水号
        jsonObject.put("AAE011", user.getYbAAE170()); // 经办人
        jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP()); // 经办时间
        jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP()); // 申报时间
        jsonObject.put("TAA103", "0"); // 	审核结果（0 待审核） 固定为0
        jsonObject.put("TAA105", "1"); // 	申报来源（1 网上大厅） 固定为1
        jsonObject.put("AAE140", "3"); // 	险种
        jsonObject.put("AAB001", user.getYbAAB001()); //单位编号
        jsonObject.put("AAE102", "1"); // 	办理状态（1 接收） 固定为1
        jsonObject.put("AAE160", ybPerson.getAAE160()); //变更原因
        jsonObject.put("AAE035", ybPerson.getAAE035()); //变更日期
        if (ybPerson.getSAA015().equals("M3004")) {
            // 人员停保
            jsonObject.put("SAA015", "M3004");// 功能ID 固定为M3004*****
            jsonObject.put("AAC031", "2");// 个人参保状态（2暂停参保） 固定为2*****
            jsonObject.put("AAC050", "22");// 在职人员变更类型（22 停保） 固定为22
        } else {
            // 人员续保
            jsonObject.put("SAA015", "M3005");// 功能ID	固定为M3005*****
            jsonObject.put("AAC031", "1");// 个人参保状态（1正常参保）	VARCHAR2(3)	固定为1*****
            jsonObject.put("AAC050", "12");// 在职人员变更类型（12 续保）    	VARCHAR2(3)	固定为12
        }
        return jsonObject;
    }
}
