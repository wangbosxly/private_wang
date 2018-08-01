package com.thinkgem.jeesite.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.RemoteException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class YBTest {

    @Autowired
    Nw_wsPort ybPort;

    @Test
    public void 数据字典信息查询() throws RemoteException {
        JSONObject json = new JSONObject();
        json.put("CODE_TYPE", "AAE140");//数据类型
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(json);
        String s = ybPort.nwws0010(jsonArray.toString());
        System.out.println(s);
    }

    @Test
    public void 单位绑定校验查询() throws RemoteException {

        JSONObject json = new JSONObject();
        json.put("AAE170", "00001556");//用户编号
        json.put("BKB026", "888888");     //密码
//        json.put("AAB001", "10400101019");     //单位编号
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(json);
        System.out.println("入参"+jsonArray.toString());
        String s = ybPort.nwws0001(jsonArray.toString());
        System.out.println(s);
    }

    @Test
    public void 单位基本信息查询() throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAB001", "10400101019");
        jsonObject.put("BAA001", "610400");
        jsonArray.add(jsonObject);
        String s = ybPort.nwws1101(jsonArray.toString());
        System.out.println(s);
    }
    @Test
    public void 人员参保信息查询() throws RemoteException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("AAB001", "10400101019");
//        jsonObject.put("AAC002", "610402196809021275");
        jsonObject.put("AAC001", "040000028171");
//        jsonObject.put("AAC003", "边磊");
        jsonArray.add(jsonObject);
        System.out.println(jsonArray.toString());
        String s = ybPort.nwws2102(jsonArray.toString());
        System.out.println(s);
    }

}
