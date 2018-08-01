package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonContinue;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author X_P
 * @create 2018-06-06 18:44
 */
@Service
@Transactional
public class GsPersonContinueService {

    @Autowired
    Nw_wsPort gsPort;


    /**
     * 查询符合当前单位参保信息的人员参保信息
     */

    public JSONObject findUnitPersonInfo(GsPersonContinue gsPersonContinue,Page page) throws RemoteException {
        JSONObject personInfo = findPersonInfo(gsPersonContinue, page);
        //如果查询人员参保信息不正常，直接将对象返回
        if(!PostHelperUtils.hasInfo(personInfo)){
            return personInfo;
        }
        //如果获取到人员参保信息，则查询单位参保信息进行比较
        JSONObject unitInfo = findUnitInfo();
        //判断单位信息是否获取到，如果没有获取到，则将单位错误信息返回
        if(!PostHelperUtils.hasInfo(unitInfo)){
            return unitInfo;
        }
        JSONArray personInfos = personInfo.getJSONArray("RETLIST");
        JSONArray unitInfos = unitInfo.getJSONArray("RETLIST");
        JSONArray array = new JSONArray();
        for (Object info : unitInfos) {
            JSONObject json = (JSONObject) info;
            for (Object o : personInfos) {
                JSONObject jsonObject = (JSONObject) o;
                if(json.getString("AAE140").equals(jsonObject.getString("AAE140"))){
                    array.add(jsonObject);
                }
            }
        }
        personInfo.put("RETLIST",array);
        return personInfo;
    }



    /**
     * 查询单位参保信息
     * @return
     */
    public JSONObject findUnitInfo() throws RemoteException {
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        String s = gsPort.nwws1102(jsonObject.toString());
        jsonObject = JSONObject.parseObject(s);
        return jsonObject;
    }

    /**
     * 查询人员参保信息
     * @param gsPersonContinue
     * @param page
     * @return
     * @throws RemoteException
     */
    public JSONObject findPersonInfo(GsPersonContinue gsPersonContinue,Page page) throws RemoteException {
        String str = JSON.toJSONString(gsPersonContinue, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("pageNo",page.getPageNo());
        jsonObject.put("pageSize", page.getPageSize());
        String s = gsPort.nwws2102(jsonObject.toString());
        json = JSONObject.parseObject(s);
        return json;
    }

    /**
     * 执行停续保操作
     * @param aac001S 个人编号数组
     * @return
     */
    public JSONObject executeContinue(String[] aac001S,String AAE160) throws RemoteException {
        JSONArray array = new JSONArray();
        String saa036 = "XY"+ GenerateSequenceUtil.generateSequenceNo();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        for (String str : aac001S) {
            String[] strs = str.split("&");
            JSONObject json = new JSONObject();
            json.putAll(jsonObject);//必传参数
            json.put("BKB026", user.getGsBKB026());//密匙密码
            json.put("AAC001", strs[0]);//个人编号
            json.put("AAE140", strs[1]);//险种 工伤，生育
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            String cdate = DateUtils.formatDate(c.getTime(), "yyyy-MM-dd");
            json.put("BAC510", cdate);//bAC510:2018-06-05, 续保时间
            json.put("AAE160", AAE160);//aAE160:121,停保原因
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
            json.put("SAA036",saa036);	// 订单号
            json.put("SAA015", "M4005");//SAA015:M4004,功能id
            json.put("BAE702", "1");//BAE702:1,z主体类型，单位
            json.put("BAE703", user.getGsBAE703());//主体编号 单位编号
            json.put("SAA043", "3");//SAA043:1,业务状态3 预审
            json.put("SAA037", user.getGsAAE170());//SAA037:ch,申请人
            json.put("SZZ003", user.getGsBAA001());//SZZ003:服务机构id(这里记录了数据分区)
            json.put("SAA038", DateUtils.formatDateTime(new Date())); //申请时间
            json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
            json.put("TAA103", CodeConstant.TAA103_TAA103_0);	// 审核结果
            json.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
            array.add(json);
        }
        String s = gsPort.nwws2703(array.toString());
        return JSONObject.parseObject(s);
    }

    /**
     * 批量续保操作
     * @param dataList
     * @param AAE160
     * @return
     */
    public JSONObject executeStop(List<GsPersonContinue> dataList, String AAE160) throws RemoteException {
        //todo 后期将停续保合一
        JSONArray array = new JSONArray();
        String saa036 = "XY"+ GenerateSequenceUtil.generateSequenceNo();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        User user = UserUtils.getUser();
        for (GsPersonContinue gsPersonContinue : dataList) {
            String str = JSONObject.toJSONString(gsPersonContinue, new PascalNameFilter());
            JSONObject json = JSONObject.parseObject(str);
            if(StringUtils.isEmpty(json.getString("AAC001"))){
                continue;
            }
            json.putAll(jsonObject);
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            String cdate = DateUtils.formatDate(c.getTime(), "yyyy-MM-dd");
            json.put("BAC510", cdate);//bAC510:2018-06-05, 续保时间
            json.put("AAE160", AAE160);//aAE160:121,续保原因
            json.put("BKB026", user.getGsBKB026());//密匙密码
            json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
            json.put("SAA036",saa036);	// 订单号
            json.put("SAA015", "M4004");//SAA015:M4004,功能id
            json.put("BAE702", "1");//BAE702:1,z主体类型，单位
            json.put("BAE703", user.getGsBAE703());//主体编号 单位编号
            json.put("SAA043", "3");//SAA043:1,业务状态3 预审
            json.put("SAA037", user.getGsAAE170());//SAA037:ch,申请人
            json.put("SZZ003", user.getGsBAA001());//SZZ003:服务机构id(这里记录了数据分区)
            json.put("SAA038", DateUtils.formatDateTime(new Date())); //申请时间
            json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
            json.put("TAA103", CodeConstant.TAA103_TAA103_0);	// 审核结果
            json.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
            array.add(json);
        }
        String s = gsPort.nwws2703(array.toString());
        return JSONObject.parseObject(s);
    }
}