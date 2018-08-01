package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsDeathSubsidy;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;

/**
 * 一次性工亡补助金
 * @author sl_su
 */
@Service
public class GsDeathSubsidyService {

    @Autowired
    Nw_wsPort gsPort;

    public JSONObject findPersonInfo(GsDeathSubsidy gsDeathSubsidy) throws RemoteException {
        String str = JSON.toJSONString(gsDeathSubsidy, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("pageNo","1");
        jsonObject.put("pageSize", "20");
        return JSONObject.parseObject(gsPort.nwws2102(jsonObject.toString()));
    }

    public JSONObject findDeathSubsidy(GsDeathSubsidy gsDeathSubsidy) throws RemoteException {
        String str = JSON.toJSONString(gsDeathSubsidy, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        return JSONObject.parseObject(gsPort.nwws2904(jsonObject.toString()));
    }

    public JSONObject save(GsDeathSubsidy gsDeathSubsidy) throws RemoteException {
        // 获取用户信息
        User user = UserUtils.getUser();
        String str = JSON.toJSONString(gsDeathSubsidy, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo()); //	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
        jsonObject.put("AAC001",gsDeathSubsidy.getAAC001()); //	个人编号
        jsonObject.put("ALC070",gsDeathSubsidy.getALC115_1()); //	一次性待遇金额 AAC013
        jsonObject.put("AAE002",CommonUtility.get6BitCurTimeAPP()); //	费款所属期
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP()); //	申报时间
        jsonObject.put("AAE003",CommonUtility.get6BitCurTimeAPP()); //	对应费款所属期
        jsonObject.put("AAE011",user.getGsAAE170()); //	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP()); //	经办时间
        jsonObject.put("SAA037",user.getGsAAE170()); //	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP()); //	申请时间
        jsonObject.put("SAA015","M4022"); //	功能id
        jsonObject.put("SAA004"," "); //	事项id
        jsonObject.put("BAE702",CodeConstant.BAE702_BAE702_1); //	主体类型
        jsonObject.put("BAE703",user.getGsAAB001()); //	主体编号
        jsonObject.put("SAA043",CodeConstant.SAA043_SAA043_3); //	业务状态
        jsonObject.put("SZZ003"," "); //	服务机构ID
        jsonObject.put("TAA103",CodeConstant.TAA103_TAA103_0);	// 审核结果
        jsonObject.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
        return JSONObject.parseObject(gsPort.nwws2905(jsonObject.toString()));
    }
}
