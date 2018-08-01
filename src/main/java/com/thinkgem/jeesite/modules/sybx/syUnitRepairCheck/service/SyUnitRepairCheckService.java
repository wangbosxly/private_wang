package com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.entity.SyUnitRepairCheck;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:
 * 单位补缴基数核定service
 *
 * @author X_P
 * @create 2018-04-04 15:01
 */
@Service
@Transactional
public class SyUnitRepairCheckService {


    public List<PM_AB88View> getCheckInfo(JSONObject json) {
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_SENDERS_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonInfo);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), PM_AB88View.class);
    }

    public List<SyUnitRepairCheck> export(JSONObject json) {
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_PAY_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonInfo);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), SyUnitRepairCheck.class);
    }

    public String submit(JSONObject jsonObject) {
        String message = null;
        JSONObject info = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_SENDERS_CHECK, jsonObject.toString());
        JSONObject json = PostHelperUtils.toParseJSONObject(info);
        if(PostHelperUtils.hasInfo(json)){
            message = "单位补基数核定提交成功";
        }else{
            message = json.getString("msg");
        }
        return message;
    }
}