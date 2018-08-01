package com.thinkgem.jeesite.modules.sybx.syywsljd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sybx.syywsljd.entity.Sysljd;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author svnlei
 * @date 2018/4/9
 */
@Service
public class SyywsljdService {

    public Page findListDetails(Page page, String jsonStr, Model model) {
        try {
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_ACCEPTANCESINGLE_DETAILS_QUERY, jsonStr);
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if ("0".equals(jsonObject.getString("code"))) {
                JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("LIST"));
                List sublist = CommonUtility.subPage(page.getPageNo(), jsonArray.size(), 20, page.getLast(), jsonArray);
                page.setCount(jsonArray.size());
                page.setList(sublist);
                return page;
            } else {
                model.addAttribute("message", jsonObject.getString("msg"));
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Page findList(Page page, String jsonStr) {
        try {
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_QUERY_ACCEPT_INFO_REALTIME, jsonStr);
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if (jsonObject != null) {
                JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("Results"));
                List sublist = CommonUtility.subPage(page.getPageNo(), jsonArray.size(), 20, page.getLast(), jsonArray);
                page.setCount(jsonArray.size());
                page.setList(sublist);
                return page;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过功能id查询所有的进度
     * @param SAA015
     * @return
     */
    public List<JSONObject> getListBySAA015(String SAA015){
        try {
            User user = UserUtils.getUser();
            JSONObject json = new JSONObject();
            json.put("SAA015", SAA015);
            //必传字段
            json.put("Action", "3");
            json.put("BAA001", user.getBaa001());
            //AAE170	操作人
            json.put("AAE170", user.getAae170());
            //AAB001	单位编号
            json.put("BAE703", user.getAab001());
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_QUERY_ACCEPT_INFO_REALTIME, json.toString());
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if (jsonObject != null) {
                JSONArray jsonArray = JSONArray.parseArray(jsonObject.getString("Results"));
               return  jsonArray==null?null: JSON.parseArray(jsonArray.toString(), JSONObject.class);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 导出不合格人员
     */
    public List<Sysljd> downloadExcelFile(String jsonStr) {
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_ACCEPTANCESINGLE_DETAILS_QUERY, jsonStr);
        try {
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            if ("0".equals(jsonObject.getString("code"))) {
                return JSON.parseArray(jsonObject.getString("LIST"), Sysljd.class);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
