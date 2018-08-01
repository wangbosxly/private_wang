package com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.entity.SyErrorInfo;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 失业单位基础信息错误核查service
 *
 * @author X_P
 * @create 2018-03-16 12:02
 */
@Transactional
@Service
public class SyErrorInfoQueryService {

    /**
     * 调用接口获取错误的基础信息
     * @param jsonObject    AAE170	操作人
                            AAB001	单位编号
                            BAA001	数据分区
                            CODE_TYPE	勘误代码(0,1,2,3,4,5)
     * @return 返回list<JSONobject>
     */
    public List<SyErrorInfo> getJSONArray(JSONObject jsonObject){
        jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_ERRORINFOQUERY, jsonObject.toString());
        JSONArray array = PostHelperUtils.toParseJSONArray(jsonObject);
        if(array==null){
            return null;
        }
        List<SyErrorInfo> list = new ArrayList<SyErrorInfo>();
        for (Object json : array) {
            SyErrorInfo syErrorInfo = JSONObject.parseObject(((JSONObject) json).toString(), SyErrorInfo.class);
            list.add(syErrorInfo);
        }
        return list;
    }


    /**
     * 调用接口分页查询错误的基础信息
     * @param page  分页对象（空）
     * @param jsonObject 查询参数    AAE170	操作人
                                    AAB001	单位编号
                                    BAA001	数据分区
                                    CODE_TYPE	勘误代码(0,1,2,3,4,5)
     * @return 分页对象（已存储）
     */
    public Page<SyErrorInfo> getJSONPage(Page<SyErrorInfo> page,JSONObject jsonObject){
        List<SyErrorInfo> list = getJSONArray(jsonObject);
        return PostHelperUtils.getPage(page, list, 20);
    }

}
