package com.thinkgem.jeesite.modules.sys.handle;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.sys.entity.Token;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsLocator;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class YBTokenHandler  implements TokenHandler {
    private Token token;
    private Nw_wsPort ybPort;
    private JSONObject jsonObject;

    public YBTokenHandler(Token token) {
        this.token = token;
        Nw_wsLocator nw_wsLocator = new Nw_wsLocator();
        try {
            ybPort = nw_wsLocator.getnw_wsPort();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public JSONObject validateInfo() {
        if (token == null) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("AAE170", token.getTokenName());//用户编号
        json.put("BKB026", token.getPassword());//密码
        jsonArray.add(json);
        String s = null;
        try {
            s = ybPort.nwws0001(jsonArray.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        json = JSONObject.parseObject(s);
        //去掉外层包裹
        jsonArray = PostHelperUtils.toJSONArray(json, "RETLIST");
        if (jsonArray != null) {
            jsonObject = (JSONObject) jsonArray.get(0);
        }
        if (jsonObject == null) {
            jsonObject = json;
        }else {
            //此处没有正确标记，手动添加
            jsonObject.put("code", "0");
        }
        return jsonObject;
    }

    @Override
    public String getState() {
        if(jsonObject==null){
            validateInfo();
        }
        if("-1".equals(jsonObject.getString("code"))){
            return "1";
        }else{
            if(!"T".equals(jsonObject.getString("AAE180"))){
                return "2";
            }else{
                return "0";
            }
        }
    }

    @Override
    public void prepareUser(User user) {
        user.setYbAAB001(jsonObject.getString("AAB001"));
        user.setYbAAE174(jsonObject.getString("AAE174"));
        user.setYbAAE036(jsonObject.getString("AAE036"));
        user.setYbAAE011(jsonObject.getString("AAE011"));
        user.setYbAAE179(jsonObject.getString("AAB001"));
        user.setYbAAC002(jsonObject.getString("AAC002"));
        user.setYbAAE170(jsonObject.getString("AAE170"));
        user.setYbAAE182(jsonObject.getString("AAE182"));
        user.setYbAAE172(jsonObject.getString("AAE172"));
        user.setYbAAE180(jsonObject.getString("AAE180"));
        user.setYbAAC003(jsonObject.getString("AAC003"));
        user.setYbBAA001(jsonObject.getString("BAA001"));
        user.setYbBKB026(jsonObject.getString("BKB026"));
        user.setYbAAB004(jsonObject.getString("AAB004"));
        user.setYbAAB034(jsonObject.getString("AAB034"));
        user.setYbBAE703(jsonObject.getString("BAE703"));
    }
}
