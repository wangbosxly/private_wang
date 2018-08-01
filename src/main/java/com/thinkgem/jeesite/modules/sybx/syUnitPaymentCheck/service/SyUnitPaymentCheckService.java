package com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheck.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.entity.PM_AC01;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 单位缴费核定service
 *
 * @author X_P
 * @create 2018-03-27 11:38
 */
@Service
@Transactional
public class SyUnitPaymentCheckService {

    @Autowired
    SyUnitPaymentQueryService syUnitPaymentQueryService;

    /**
     * 查询近半年缴费记录
     * @return
     */
    public List<PM_AB88View> getList(){
        //封装参数
        JSONObject json = new JSONObject();
        //获取半年前的月份
        Date date = DateUtils.addMonths(new Date(),-6);
        json.put("StartYM", DateUtils.formatDate(date,"yyyyMM"));
        //本月
        json.put("EndYM", DateUtils.formatDate(new Date(),"yyyyMM"));
        //正常查询缴费记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        return syUnitPaymentQueryService.findList(json);
    }

    /**
     * 人员异动列表查询
     * @param json
     * @return
     */
    public List<PM_AC01> getPersonChangeList(JSONObject json) {
        //封装内部参数
        User user = UserUtils.getUser();
        //AAE170	操作人
        json.put("AAE170",user.getAae170());
        //AAB001	单位编号
        json.put("AAB001",user.getAab001());
        //BAA001数据分区
        json.put("BAA001",user.getBaa001());
        //险种 失业
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //每页数据量
        json.put("BAC808","20");
        //json.put("AAC031","1"); //参保状态
        //页码
        json.put("BAC809","1");
        //异动类型，查询增减信息
        json.put("AAC050","-1");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), PM_AC01.class);
    }

    /**
     * 获取异动人员相信信息
     * @param json
     * @return
     */
    public List<PM_AC01> getPersonChangeInfo(JSONObject json){
        //封装内部参数
        User user = UserUtils.getUser();
        //AAE170	操作人
        json.put("AAE170",user.getAae170());
        //AAB001	单位编号
        json.put("AAB001",user.getAab001());
        //险种 失业
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //BAA001	数据分区
        json.put("BAA001",user.getBaa001());
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonInfo);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), PM_AC01.class);
    }

    /**
     * 提交单位缴费审核
     * @param jsonObject
     */
    public String submit(JSONObject jsonObject) {
        String message = null;
        JSONObject info = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_PAY_CHECK, jsonObject.toString());
        JSONObject json = PostHelperUtils.toParseJSONObject(info);
        if(PostHelperUtils.hasInfo(json)){
            message = "缴费核定提交成功";
        }else{
            message = json.getString("msg");
        }
        return message;
    }
}