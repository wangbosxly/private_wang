/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.alibaba.fastjson.JSONObject.parseArray;

/**
 * 单位缴费信息查询Service
 *
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings({"unchecked", "rawtypes"})
public class SyUnitPaymentQueryService {

    /**
     * 查询分页对象
     * @param page
     * @param jsonObject
     * @return
     */
    public Page<PM_AB88View> findPageList(Page<PM_AB88View> page,JSONObject jsonObject){
        List<PM_AB88View> list = findList(jsonObject);
        return PostHelperUtils.getPage(page,list,20);
    }


    /**
     * json中需要包含  "StartYM","EndYM",
     *
     * @param jsonObject
     * @return
     */
    public List<PM_AB88View> findList(JSONObject jsonObject) {
        User user = UserUtils.getUser();
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("BAB811", "1");
        //TODO 此处险种类型 AAE140写死为2失业,需要修改前台页面保证参数传递正常
        jsonObject.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //缴费方式(2税务征收,3经办机构自收)
        jsonObject.put("AAB033", "2");
        jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_PAYINFOQUERY, jsonObject.toJSONString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        return jsonArray==null?null: parseArray(jsonArray.toString(), PM_AB88View.class);

    }

    /**
     * 单位缴费核定审核信息获取
     * @param json
     */
    public List<PM_AB88View> getCheckInfo(JSONObject json) {
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_PAY_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonInfo);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), PM_AB88View.class);
    }

    /**
     * 征缴计划确认
     * @param json
     * @return
     */
    public List<PM_AB88View> formSubmit(JSONObject json) {
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_COLLECTION_CHECK, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonInfo);
        return jsonArray==null?null:JSONObject.parseArray(jsonArray.toString(), PM_AB88View.class);
    }
}