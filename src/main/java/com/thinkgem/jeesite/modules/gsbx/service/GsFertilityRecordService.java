package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsFertilityRecord;
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

/**
 * 工伤生育备案
 * @author sl_su
 */
@Service
@Transactional
public class GsFertilityRecordService {

    @Autowired
    Nw_wsPort gsPort;

    /**
     * 根据个人编号查询人员生育备案信息
     * @param AAC001 个人编号
     */
    public JSONObject findByAAC001(String AAC001) throws RemoteException {
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        jsonObject.put("AAC001",AAC001);
        return JSONObject.parseObject(gsPort.nwws2151(jsonObject.toString()));
    }
    /**
     * 用于人员工伤备案信息查询
     * 由于参数限定数据唯一
     * 故pageNo pageSize必传值设为固定值
     */
    public JSONObject findPersonInfo(GsFertilityRecord gsFertilityRecord) throws RemoteException {
        String str = JSON.toJSONString(gsFertilityRecord, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("AAC031", "1");
        jsonObject.put("pageNo","1");
        jsonObject.put("pageSize", "20");
        return JSONObject.parseObject(gsPort.nwws2102(jsonObject.toString()));
    }

    public JSONObject save(GsFertilityRecord gsBirthRegistration) throws RemoteException {
        // 获取用户信息
        User user = UserUtils.getUser();
        JSONObject json = PostHelperUtils.buildGsJSON();
        json.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo());	// 受理单号
        json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
        json.put("AAC001",gsBirthRegistration.getAAC001());	// 个人编号
        json.put("AMC087",gsBirthRegistration.getAMC087());	// 怀孕日期 页面传值 非必填
        json.put("AMC032",gsBirthRegistration.getAMC032());	// 胎次 页面传值
//        json.put("AMC091","张三");	// 配偶姓名
//        json.put("AMC092","610404610923201");	// 配偶身份证号
//        json.put("AMC093","陕西省西咸新区秦汉中学");	// 配偶单位名称
//        json.put("AMC094","0");	// 配偶胎次
        json.put("TAA101",CommonUtility.get19BitCurTimeAPP());	// 申报时间
//        json.put("AAE003",CommonUtility.get6BitCurTimeAPP());	// 对应费款所属期
        json.put("AAE011",user.getGsAAE170());	// 经办人
        json.put("AAE036",CommonUtility.get19BitCurTimeAPP());	// 经办时间
        json.put("SAA037",user.getGsAAE170());	// 申请人
        json.put("SAA038",CommonUtility.get19BitCurTimeAPP());	// 申请时间
        json.put("SAA015","M4019");	// 功能id
//        json.put("BUS_ID"," ");	// 业务ID
//        json.put("SAA031"," ");	// 表单模板id
        json.put("SAA004"," ");	// 事项id
        json.put("BAE702",CodeConstant.BAE702_BAE702_1);	// 主体类型
        json.put("BAE703",user.getGsAAB001());	// 主体编号
        json.put("SAA043",CodeConstant.SAA043_SAA043_3);	// 业务状态
        json.put("SZZ003"," ");	// 服务机构ID
        json.put("TAA103",CodeConstant.TAA103_TAA103_0);	// 审核结果
        json.put("TAA105",CodeConstant.TAA105_TAA105_1);	// 申报来源 1 网上大厅
        return JSONObject.parseObject(gsPort.nwws2351(json.toString()));
    }
}
