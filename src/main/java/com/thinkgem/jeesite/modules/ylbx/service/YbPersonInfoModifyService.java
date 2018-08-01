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

@Service
public class YbPersonInfoModifyService {

    @Autowired
    private Nw_wsPort ybPort;

    /**
     * 通过姓名、个人编号等查询人员基本信息
     */
    public JSONObject getPersonList(YbPerson ybPerson) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(ybPerson, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("AAB001", user.getYbAAB001());
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2101(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject save(YbPerson ybPerson) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(ybPerson, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo()); //受理单ID
        jsonObject.put("SAA004", " "); //事项ID
        jsonObject.put("SAA015", "M3003"); //功能ID
        jsonObject.put("BAE702", "1"); //主体类型（1 单位)
        jsonObject.put("BAE703", user.getYbAAB001()); //主体编号
        jsonObject.put("SAA043", "3"); //业务状态（3 未受理，6已受理）
        jsonObject.put("SAA037", user.getYbAAE170()); //	申请人
        jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP()); //	申请时间
        jsonObject.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
        jsonObject.put("AAE011", user.getYbAAE170()); //	经办人
        jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP()); //	经办时间
        jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP()); //	申报时间
        jsonObject.put("TAA103", "0"); //	审核结果（0 待审核）
        jsonObject.put("TAA105", "1"); //	申报来源（1 网上大厅）
        jsonObject.put("AAE140", "3"); //	险种
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2701(jsonArray.toString());
        return JSONObject.parseObject(s);
    }
}
