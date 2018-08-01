package com.thinkgem.jeesite.modules.sybx.sywgbt.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.sybx.sywgbt.entity.SyWgbt;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;

/**
 * @author svnlei
 * @date 2018/4/3
 */
@Service
@Transactional(readOnly = true)
public class SyWgbtService {

    public List<SyWgbt> downloadExcelFile(String jsonStr) {
        try {
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_SUBSIDIESINFOQUERY,jsonStr);
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if (jsonObject != null) {
                return JSON.parseArray(jsonObject.getString("RETLIST"), SyWgbt.class);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    public JSONArray findList(String jsonStr) {
        try {
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_SUBSIDIESINFOQUERY,jsonStr);
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if (jsonObject != null) {
                return JSONArray.parseArray(jsonObject.getString("RETLIST"));
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    public HashMap examineFile(JSONArray jsonArray, Model model) {
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_SUBSIDIESINFOQUERY,jsonArray.toJSONString());
        jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
        if (jsonObject != null) {
            if ("0".equals(jsonObject.getString("code"))) {
                jsonObject = JSONObject.parseObject(jsonObject.getString("RETLIST"));
            } else {
                model.addAttribute("message",jsonObject.getString("msg"));
                return null;
            }
        }
        /*HashMap resultmap = new HashMap();*/
        HashMap<?, ?> m = new HashMap<Object, Object>();
        HashMap<?, ?> resultmap = JSON.parseObject(jsonObject.toString(), m.getClass());
        String map_json = JSON.toJSONString(resultmap.get("examineVO"));//审核信息
        String err_json = JSON.toJSONString(resultmap.get("JC20ERR"));//不合格信息
        String unit_json = JSON.toJSONString(resultmap.get("unitInfoBack"));//单位信息
        unit_json=unit_json.replace("[]", "''");
        JSONObject jobj = JSONObject.parseObject(map_json);//审核信息
        JSONArray errorArr = JSONArray.parseArray(err_json);//不合格信息
        JSONObject	unitArray = JSONObject.parseObject(unit_json);//单位信息
        //errorArrw 为Page对象
        Page page = new Page(1,20, errorArr.size());
        if (errorArr.size() > 0) {
            page.setList(errorArr);
        }
        HashMap trimap = new HashMap();
        trimap.put("examineVO", jobj);
        trimap.put("JC20ERR", page);
        trimap.put("unitInfoBack", unitArray);
        return trimap;
    }

    public JSONObject submit(String jsonStr) {
        // 调用更新受理单接口
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UPDATE_ACCEPT_INFO,jsonStr);
        jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
        if (jsonObject != null) {
            return jsonObject;
        } else {
            return null;
        }
    }
}
