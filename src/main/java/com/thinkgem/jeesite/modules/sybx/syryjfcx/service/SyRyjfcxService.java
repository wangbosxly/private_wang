package com.thinkgem.jeesite.modules.sybx.syryjfcx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC88View;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.alibaba.fastjson.JSON.parseArray;

/**
 * 失业人员缴费查询服务
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SyRyjfcxService {
	/**
	 * 查询人员缴费信息
	 * @return 返回分页对象
	 */
	public Page<PM_AC88View> getPageList(Page<PM_AC88View> page, JSONObject json){
        List<PM_AC88View> list = getList(json);
        if(list!=null) {
            int count = list.size();
            List<PM_AC88View>  sublist = CommonUtility.subPage(page.getPageNo(), count, 20, page.getLast(), list);
            page.setCount(count);
            page.setList(sublist);
        }
        return page;
	}

    /**
     * 查询人员缴费信息返回所有对象
     * @return 返回查询的所有对象
     */
    public List<PM_AC88View> getList(JSONObject json){
        User user = UserUtils.getUser();
        //封装参数
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        //接口调用
        json = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_PAY_INFO_QUERY, json.toJSONString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(json);
        return jsonArray==null?null:parseArray(jsonArray.toString(), PM_AC88View.class);
    }

}
