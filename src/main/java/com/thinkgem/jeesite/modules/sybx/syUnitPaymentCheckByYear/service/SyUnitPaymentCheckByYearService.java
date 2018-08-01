package com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheckByYear.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述:
 *
 * @author X_P
 * @create 2018-05-09 10:53
 */
@Service
public class SyUnitPaymentCheckByYearService {

    public  Double findFund() {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        //获取当前的月份
        String date = DateUtils.formatDate(new Date(), "yyyyMM");
        //费款所属期
        jsonObject.put("startYM",date);
        //费款所属期
        jsonObject.put("endYM",date);
        jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.MONEY_TO_TURN, jsonObject.toString());
        JSONArray retlist = PostHelperUtils.toParseJSONArray(jsonObject, "RETLIST");
        return retlist==null?0:Double.parseDouble((String) retlist.getJSONObject(0).get("BAE715"));
    }
}