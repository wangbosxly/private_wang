package com.thinkgem.jeesite.modules.sys.handle;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.Token;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 描述:
 * 失业密匙执行器
 *
 * @author X_P
 * @create 2018-06-05 10:55
 */
public class SyTokenHandler implements TokenHandler {
    private Token token;
    private JSONObject jsonObject;

    public SyTokenHandler(Token token) {
        this.token = token;
    }

    @Override
    public JSONObject validateInfo() {
        if (token == null) {
            return null;
        }
        JSONObject json = new JSONObject();
        json.put("AAE170", token.getTokenName());
        json.put("BKB026", md5PasswordEncoder.encodePassword(token.getPassword(), null));
        //调用密匙对应的接口
        json = PostHelperUtils.getJSONInfo(token.getRemarks(), json.toString());
        //去掉外层包裹
        jsonObject = PostHelperUtils.toParseJSONObject(json);
        return jsonObject;
    }

    @Override
    public String getState() {
        //判断返回值是否有信息
        if (PostHelperUtils.hasInfo(jsonObject)) {
            //查询单位基本信息验证是否账号被锁定
            if ("T".equals(jsonObject.getString("AAE180"))) {
                //用户被锁定
                return "2";
            } else {
                //正常
                return "0";
            }

        } else {
            //失效，密码错误等
            return "1";
        }
    }

    @Override
    public void prepareUser(User user) {
        user.getCompany().setId(jsonObject.getString("BAA001"));
        user.getCompany().setName(jsonObject.getString("AAB004"));
        user.setAac003(jsonObject.getString("AAC003"));
        user.setAac002(jsonObject.getString("AAC002"));
        user.setAab001(jsonObject.getString("AAB001"));
        user.setAab004(jsonObject.getString("AAB004"));
        user.setBkb026(jsonObject.getString("BKB026"));//获取密码
        user.setAae170(jsonObject.getString("AAE170"));//当前登录用户名
        user.setAae005(jsonObject.getString("AAE005"));
        user.setAae171(jsonObject.getString("AAE171"));
        user.setAae036(jsonObject.getString("AAE036"));
        user.setBaa001(jsonObject.getString("BAA001"));
        user.setAab034(jsonObject.getString("AAB034"));
        user.setAae011(jsonObject.getString("AAE011"));
        user.setBac501(jsonObject.getString("BAC501"));
        user.setAae180(jsonObject.getString("AAE180"));

    }

    /**
     * 获取单位基本信息
     *
     * @param jsonObject 密匙绑定获取的信息
     * @return
     */
    private JSONObject getUnit(JSONObject jsonObject) {
        JSONObject json = new JSONObject();
        json.put("AAE170", jsonObject.getString("AAE170"));
        json.put("AAB001", jsonObject.getString("AAB001"));
        json.put("BAA001", jsonObject.getString("BAA001"));
        JSONObject unit = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        unit = PostHelperUtils.toParseJSONObject(unit);
        return unit;
    }
}