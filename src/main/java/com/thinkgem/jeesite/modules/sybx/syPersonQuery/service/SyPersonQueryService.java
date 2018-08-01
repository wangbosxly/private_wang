/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonQuery.service;

//import java.util.ArrayList;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.syPersonQuery.entity.SyPersonQuery;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 人员信息管理Service
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings( { "unchecked", "rawtypes" })
public class SyPersonQueryService {
	
	public Page<PM_AC01View> findPage(Page<PM_AC01View> page, JSONObject jsonObject) {
        if (StringUtils.isNotEmpty(jsonObject.getString("aAC003"))){

        }
        JSONObject json = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, jsonObject.toString());
        //解析list
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(json);
        if(jsonArray!=null) {
            List<PM_AC01View> list = JSONObject.parseArray(jsonArray.toString(), PM_AC01View.class);
            if(list==null||page==null){
                return null;
            }
            long count = Integer.parseInt(list.get(0).getAAC002_1());
            if (StringUtils.isNotEmpty(jsonObject.getString("aAC003"))){
                count = list.size();
            }
            page.setCount(count);
            page.setList(list);
        }
		return page;

	}

    /**
     * 打印时查询所有数据
     * @param json
     * @return
     */
    public List<SyPersonQuery> getExportList(JSONObject json) {
        Long bac808 = (Long)json.get("BAC808");
        json.put("BAC808",7000);
        //查询数量 BAC808上限阈值为7000，超过部分需循环查取
        long i = bac808/7000+1;
        List<SyPersonQuery> list = new ArrayList<SyPersonQuery>();
        for (int j = 0; j < i; j++) {
            json.put("BAC809",j+1);
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
            //解析list
            JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
            for (Object o : jsonArray) {
                JSONObject  jsonSAA036= (JSONObject) o;
                List<SyPersonQuery> saa036 = JSONObject.parseArray(jsonSAA036.getString("SAA036"), SyPersonQuery.class);
                list.addAll(saa036);
            }
        }
        return list;
    }
}