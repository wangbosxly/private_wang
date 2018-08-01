package com.thinkgem.jeesite.modules.gsbx.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.entity.GsInductrialRecord;
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
 * 人员工伤信息备案
 * @author sl_su
 */
@Service
@Transactional
public class GsInductrialRecordService {

    @Autowired
    Nw_wsPort gsPort;

    /**
     * 用于人员工伤备案信息查询
     * 由于参数限定数据唯一
     * 故pageNo pageSize必传值设为固定值
     */
    public JSONObject findPersonInfo(GsInductrialRecord gsInductrialRecord) throws RemoteException {
        String str = JSON.toJSONString(gsInductrialRecord, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject json = PostHelperUtils.buildGsJSON();
        jsonObject.putAll(json);
        jsonObject.put("AAC031", "1");
        jsonObject.put("pageNo","1");
        jsonObject.put("pageSize", "20");
        return JSONObject.parseObject(gsPort.nwws2102(jsonObject.toString()));
    }

    public JSONObject save(GsInductrialRecord gsInductrialRecord) throws RemoteException {
        // 获取用户信息
        User user = UserUtils.getUser();
        JSONObject jsonObject = PostHelperUtils.buildGsJSON();
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo());//	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());//	申报流水号
        jsonObject.put("AAC001",gsInductrialRecord.getAAC001());//	个人编号
        jsonObject.put("ALC020",gsInductrialRecord.getALC020());//	工伤发生日期
        jsonObject.put("ALC203",gsInductrialRecord.getALC203());//	工伤报告日期
        jsonObject.put("ALC021",gsInductrialRecord.getALC021());//	伤害程度
        jsonObject.put("ALC025",gsInductrialRecord.getALC025());//	报告方式
        jsonObject.put("ALC027",gsInductrialRecord.getALC027());//	工伤类别
        jsonObject.put("ALC207",gsInductrialRecord.getALC207());//	事故类别
        jsonObject.put("ALC023",gsInductrialRecord.getALC023());//	事故地点
        jsonObject.put("ALC022",gsInductrialRecord.getALC022());//	伤害部位
        jsonObject.put("ALC024",gsInductrialRecord.getALC024());//	报告人姓名
        jsonObject.put("ALC605",gsInductrialRecord.getALC605());//	报告人联系电话
        jsonObject.put("ALC800",gsInductrialRecord.getALC800());//	事故摘要
        jsonObject.put("ALC626",gsInductrialRecord.getALC626());//	是否定点医疗机构(默认非定点，0)
        jsonObject.put("AKB021",gsInductrialRecord.getAKB021());//	医疗机构名称
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP());//	申报时间
//        jsonObject.put("AAE003","AAE003");//	对应费款所属期
        jsonObject.put("AAE011",user.getGsAAE170());//	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP());//	经办时间
        jsonObject.put("SAA037",user.getGsAAE170());//	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP());//	申请时间
        jsonObject.put("SAA015","M4020");//	功能id
//        jsonObject.put("BUS_ID","BUS_ID");//	业务ID
//        jsonObject.put("SAA031","SAA031");//	表单模板id
        jsonObject.put("SAA004"," ");//	事项id
        jsonObject.put("BAE702"," ");//	主体类型
        jsonObject.put("BAE703",user.getGsAAB001());//	主体编号
        jsonObject.put("SAA043",CodeConstant.SAA043_SAA043_3);//	业务状态
        jsonObject.put("SZZ003"," ");//	服务机构ID
        jsonObject.put("TAA103",CodeConstant.TAA103_TAA103_0);//	审核结果
        jsonObject.put("TAA105",CodeConstant.TAA105_TAA105_1);//	申报来源
        return JSONObject.parseObject(gsPort.nwws2901(jsonObject.toString()));
    }
}
