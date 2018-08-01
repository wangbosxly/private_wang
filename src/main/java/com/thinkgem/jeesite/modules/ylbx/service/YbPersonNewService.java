package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

@Service
public class YbPersonNewService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject getSalary() throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        String AAE030 = DateUtils.formatDate(new Date(), "yyyy");
        jsonObject.put("AAE030", AAE030);
        jsonArray.add(jsonObject);
        String s = ybPort.nwws0004(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject save(YbPerson ybPerson) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSONObject.toJSONString(ybPerson, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("SAA036", "XY" + CommonUtility.getSAA036()); // 	受理单ID
        jsonObject.put("SAA004", " "); // 	事项ID
        jsonObject.put("SAA015", "M3002"); // 	功能ID	固定为M3002
        jsonObject.put("BAE702", "1"); // 	主体类型（1 单位)	固定为1
        jsonObject.put("BAE703", user.getYbAAB001()); // 	主体编号
        jsonObject.put("SAA043", "3"); // 	业务状态（3 未受理，6已受理）	固定为3
        jsonObject.put("SAA037", user.getYbAAE170()); // 	申请人
        jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP()); // 	申请时间
        jsonObject.put("BAE941", "XY" + CommonUtility.getSAA036()); // 	申报流水号
        jsonObject.put("AAC040", ybPerson.getAAC040()); // 	工资
        jsonObject.put("AAE011", user.getYbAAE170()); // 	经办人
        jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP()); // 	经办时间
        jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP()); // 	申报时间
        jsonObject.put("TAA103", "0"); // 	审核结果（0 待审核）	固定为0
        jsonObject.put("TAA105", "1"); // 	申报来源（1 网上大厅）	固定为1
        jsonObject.put("AAE140", "3"); // 	险种	固定为3
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2301(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject executeUpload(List<YbPerson> dataList) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String saa036 = "XY" + CommonUtility.getSAA036();
        for (YbPerson person : dataList) {
            String str = JSONObject.toJSONString(person, new PascalNameFilter());
            JSONObject jsonObject = JSONObject.parseObject(str);
            jsonObject.put("SAA036", saa036); // 	受理单ID
            jsonObject.put("BAE941", "XY" + CommonUtility.getSAA036()); // 	申报流水号
            jsonObject.put("SAA004", " "); // 	事项ID
            jsonObject.put("SAA015", "M3002"); // 	功能ID	固定为M3002
            jsonObject.put("BAE702", "1"); // 	主体类型（1 单位)	固定为1
            jsonObject.put("BAE703", user.getYbAAB001()); // 	主体编号
            jsonObject.put("SAA043", "3"); // 	业务状态（3 未受理，6已受理）	固定为3
            jsonObject.put("SAA037", user.getYbAAE170()); // 	申请人
            jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP()); // 	申请时间
            jsonObject.put("AAE011", user.getYbAAE170()); // 	经办人
            jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP()); // 	经办时间
            jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP()); // 	申报时间
            jsonObject.put("TAA103", "0"); // 	审核结果（0 待审核）	固定为0
            jsonObject.put("TAA105", "1"); // 	申报来源（1 网上大厅）	固定为1
            jsonObject.put("AAE140", "3"); // 	险种	固定为3
            jsonArray.add(jsonObject);
        }
        String s = ybPort.nwws2301(jsonArray.toString());
        return JSONObject.parseObject(s);
    }
}
