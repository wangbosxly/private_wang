package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.modules.gsbx.entity.GsScheduleQuery;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

@Service
public class GsScheduleQueryService {

    @Autowired
    private Nw_wsPort gsPort;

    public JSONObject findSchedule(GsScheduleQuery gsScheduleQuery) throws RemoteException {
        //获取系统信息
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Action","1");	//同步数据标志
        jsonObject.put("StartDate",gsScheduleQuery.getStartDate());	//开始时间
        jsonObject.put("EndDate",gsScheduleQuery.getEndDate());	//截止时间
        jsonObject.put("BAA001",user.getGsBAA001());	//数据分区
//        jsonObject.put("SAA037","");	//申请人
        jsonObject.put("SAA015",gsScheduleQuery.getSAA015());	//功能id
//        jsonObject.put("BAE702","");	//主体类型
        jsonObject.put("BAE703",user.getGsAAB001());	//主体编号
        jsonObject.put("SAA043",gsScheduleQuery.getSAA043());	//业务状态
//        jsonObject.put("SAA080",scheduleQuery.getSAA080());	//服务机构ID
        String s = gsPort.nwws0401(jsonObject.toString());
        return JSONObject.parseObject(s);
    }

    public JSONObject findScheduleDetails(GsScheduleQuery gsScheduleQuery) throws RemoteException {
        //获取系统信息
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BAA001", user.getGsBAA001());
        jsonObject.put("AAE170", user.getGsAAE170());
        jsonObject.put("BAE703", user.getGsAAB001());
        jsonObject.put("SAA036", gsScheduleQuery.getSAA036());
        jsonObject.put("TAA103", gsScheduleQuery.getTAA103());
        String s = gsPort.nwws0403(jsonObject.toString());
        return JSONObject.parseObject(s);
    }
}
