package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbUnit;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class YbUnitModifyService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject queryUnitInfo() throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAB001", user.getYbAAB001());
        jsonObject.put("BAA001", user.getYbBAA001());
        jsonArray.add(jsonObject);
        String s = ybPort.nwws1101(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject updateUnitInfo(YbUnit ybUnit) throws RemoteException {
        User user = UserUtils.getUser();
        JSONArray jsonArray = new JSONArray();
        String str = JSON.toJSONString(ybUnit, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonObject.put("AAE011", user.getYbAAE170());
        jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP());
        jsonArray.add(jsonObject);
        String s = ybPort.nwws1701(jsonArray.toString());
        return JSONObject.parseObject(s);
    }
}
