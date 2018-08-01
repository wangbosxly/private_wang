/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonUpdate.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 人员信息修改Service
 *
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings({"unchecked", "rawtypes"})
public class SyAc01UpdateService {

    public Page<PM_AC01View> findPage(Page<PM_AC01View> page, JSONObject jsonObject) {
        JSONObject json = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, jsonObject.toString());
        try {

            JSONObject jsonObj = PostHelperUtils.toParseJSONObject(json);
            JSONArray jsonArray;
            //避免接口调用成功时  数据为空导致页面提醒联系管理员
            if (PostHelperUtils.hasInfo(jsonObj)) {
                jsonArray = JSONArray.parseArray(jsonObj.getString("LIST"));
                List<PM_AC01View> list = JSONObject.parseArray(jsonArray.toString(), PM_AC01View.class);
                if (list.size() > 0) {
                    page.setCount(Integer.parseInt(list.get(0).getAAC002_1()));
                } else {
                    page.setCount(0);
                }
                page.setList(list);
            }
            return page;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 个人信息修改保存
     *
     * @return
     */
    @Transactional(readOnly = false)
    public JSONObject saveInfo(JSONObject json) {
        try {
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INFO_UPDATE, json.toString());
            return PostHelperUtils.toParseJSONObject(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据身份证
     * 查询个人基本信息
     */
    public PM_AC01View findInfo(String jsonStr) {
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_BASIC_INFO_QUERY, jsonStr);
        try {
            //获取 result 层
            JSONObject jsonObj = PostHelperUtils.toParseJSONObject(jsonObject);
            JSONArray jsonArray;
            if (PostHelperUtils.hasInfo(jsonObj)) {
                //获取list
                jsonArray = JSONArray.parseArray(jsonObj.getString("LIST"));
                JSONObject jsons = (JSONObject) jsonArray.get(0);
                // json 转javabean
                PM_AC01View pm_ac01View = JSON.parseObject(jsons.toString(),new TypeReference<PM_AC01View>() {});
                return  pm_ac01View;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}