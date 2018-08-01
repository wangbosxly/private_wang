package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.SpecialBusiness;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class YbRelocatedRecordService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject queryRelocatedRecord(SpecialBusiness specialBusiness) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(specialBusiness, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("AAB001",user.getYbAAB001());
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2363(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject save(SpecialBusiness specialBusiness) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(specialBusiness, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("AAE011", user.getYbAAE170());
        jsonArray.add(jsonObject);
        String s = ybPort.nwws2362(jsonArray.toString());
        return JSONObject.parseObject(s);
    }
}
