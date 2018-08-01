package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.modules.ylbx.entity.SpecialBusiness;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

/**
 * 门诊特殊病人员登记
 * @author sl_su
 */
@Service
public class YbSpecialPatientService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject save(SpecialBusiness specialBusiness) throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        String str = JSONObject.toJSONString(specialBusiness, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        jsonArray.add(jsonObject);
        String s = ybPort.nwws1303(jsonArray.toString());
        return JSONObject.parseObject(s);
    }

}
