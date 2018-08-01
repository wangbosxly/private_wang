package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbScheduleQuery;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class YbScheduleQueryService {

    @Autowired
    private Nw_wsPort ybPort;

    public JSONObject findSchedule(YbScheduleQuery ybScheduleQuery) throws RemoteException {
        //获取系统信息
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("SAA037","");	//申请人
        jsonObject.put("SAA015",ybScheduleQuery.getSAA015());	//功能id
        jsonObject.put("SAA024",ybScheduleQuery.getSAA024());	//第几页
        jsonObject.put("BAE703",user.getYbAAB001());	//主体编号
        jsonObject.put("SAA042",ybScheduleQuery.getSAA042());	//业务状态
        jsonObject.put("SAA018",ybScheduleQuery.getSAA018());	//每页记录数
        JSONArray array = new JSONArray();
        array.add(jsonObject);
        String s = ybPort.nwws1105(array.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject findScheduleDetails(YbScheduleQuery ybScheduleQuery) throws RemoteException {
        //获取系统信息
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("SAA015", ybScheduleQuery.getSAA015());
        jsonObject.put("SAA036", ybScheduleQuery.getSAA036());
        jsonObject.put("TAA103", ybScheduleQuery.getTAA103());
        array.add(jsonObject);
        String s = ybPort.nwws1106(array.toString());
        return JSONObject.parseObject(s);
    }
}
