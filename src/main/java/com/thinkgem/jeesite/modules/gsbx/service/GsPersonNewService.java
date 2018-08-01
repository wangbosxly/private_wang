package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonNew;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.Date;

/**
 * 描述:
 * 人员新参保service
 *
 * @author X_P
 * @create 2018-06-06 10:16
 */
@Service
@Transactional
public class GsPersonNewService {

    @Autowired
    Nw_wsPort gsPort;


    /**
     * 通过身份证号判断是否存在人员参保信息，后期需要重构的方法
     * @param aac002
     * @return
     */
    public boolean findInfoByAAC002(String aac002) throws RemoteException {
        //TODO 未添加分页条件
        JSONObject json = PostHelperUtils.buildGsJSON();
        json.put("pageNo","1"); //页码
        json.put("pageSize","20"); //每页数据量*/
        json.put("AAC002",aac002);
        String str = gsPort.nwws2102(json.toString());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONArray array = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
        if(array==null||array.size()==0){
            return false;
        }
        return true;
    }

    /**
     * 保存新人员，成功返回0.失败返回-1
     * @param gsPersonNew
     * @return
     * @throws RemoteException
     */
    public JSONObject save(GsPersonNew gsPersonNew) throws RemoteException {
        String str = JSONObject.toJSONString(gsPersonNew, new PascalNameFilter());
        JSONObject jsonObject =  JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        User user = UserUtils.getUser();
        //个人编号新参保为空
        jsonObject.put("AAC001"," ");
        //受理单号
        jsonObject.put("SAA036","XY"+ CommonUtility.getSAA036());
        //申报流水号
        jsonObject.put("BAE941","XY"+CommonUtility.getBAE941());
        //经办人
        jsonObject.put("AAE011",user.getGsAAE170());
        //	经办时间
        jsonObject.put("AAE036", DateUtils.formatDateTime(new Date()));
        //SAA037	申请人
        jsonObject.put("SAA037",user.getGsAAE170());
        //SAA038	申请时间
        jsonObject.put("SAA038", DateUtils.formatDateTime(new Date()));
        //功能id
        jsonObject.put("SAA015","M4002");//人员新参保
        jsonObject.put("SAA004", "");
        //单位1，个人0  BAE702	主体类型
        jsonObject.put("BAE702","1");
        //BAE703	主体编号  应该是单位编号了，猜的。
        jsonObject.put("BAE703",user.getGsAAB001());
        //SAA043	业务状态 1填写资料  2提交审核  3预审  4 受理  5 审核  6办结
        jsonObject.put("SAA043","3");
        //SZZ003	服务机构ID 宝鸡的是这个，咸阳的不清楚 00000201 ？？？？？？？？？？？？？？？
        jsonObject.put("SZZ003"," ");
        // 审核结果,0待审核,1审核通过,2审核不通过
        jsonObject.put("TAA103", "0");
        // 申报来源,1网上大厅,2微信        TAA105	申报来源
        jsonObject.put("TAA105","1");
        jsonObject.put("BAA008"," ");
        jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP()); //	申报时间
        String s = gsPort.nwws2301(jsonObject.toString());
        json = JSONObject.parseObject(s);
        return json;
    }

    /**
     * 查询社平工资
     * @return
     * @throws RemoteException
     */
    public JSONObject getSalary() throws RemoteException {
        JSONObject json = PostHelperUtils.buildGsJSON();
        String s = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
        json.put("AAE030", s);
        String ss = gsPort.nwws0004(json.toString());
        json = JSONObject.parseObject(ss);
        return json;
    }
}