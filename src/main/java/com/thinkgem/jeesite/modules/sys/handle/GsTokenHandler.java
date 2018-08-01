package com.thinkgem.jeesite.modules.sys.handle;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsLocator;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.sys.entity.Token;
import com.thinkgem.jeesite.modules.sys.entity.User;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * 描述:
 *
 * @author X_P
 * @create 2018-06-05 11:29
 */
public class GsTokenHandler implements TokenHandler {

    private Token token;
    private Nw_wsPort gsPort;
    private JSONObject jsonObject;

    public GsTokenHandler(Token token) {
        this.token = token;
        Nw_wsLocator nw_wsLocator = new Nw_wsLocator();
        try {
            gsPort = nw_wsLocator.getnw_wsPort();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject validateInfo() {
        if (token == null) {
            return null;
        }
        JSONObject json = new JSONObject();
        json.put("AAE170",token.getTokenName());
        json.put("BKB026", md5PasswordEncoder.encodePassword(token.getPassword(),null));
        String s = null;
        try {
            s = gsPort.nwws0001(json.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        json = JSONObject.parseObject(s);
        //去掉外层包裹
        jsonObject = PostHelperUtils.toParseJSONObject(json, "RETLIST");
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
            if("T".equals(jsonObject.getString("AAE180"))){
              return "2";
            }else{
                return "0";
            }
        }
    }

    @Override
    public void prepareUser(User user) {
        user.setGsAAB001(jsonObject.getString("AAB001"));
        user.setGsAAE174(jsonObject.getString("AAE174"));
        user.setGsAAE036(jsonObject.getString("AAE036"));
        user.setGsAAE011(jsonObject.getString("AAE011"));
        user.setGsAAB001(jsonObject.getString("AAB001"));
        user.setGsAAE179(jsonObject.getString("AAB001"));
        user.setGsAAE179(jsonObject.getString("AAE179"));
        user.setGsAAC002(jsonObject.getString("AAC002"));
        user.setGsAAE170(jsonObject.getString("AAE170"));
        user.setGsAAE182(jsonObject.getString("AAE182"));
        user.setGsAAE172(jsonObject.getString("AAE172"));
        user.setGsAAE180(jsonObject.getString("AAE180"));
        user.setGsAAC003(jsonObject.getString("AAC003"));
        user.setGsBAA001(jsonObject.getString("BAA001"));
        user.setGsBKB026(jsonObject.getString("BKB026"));
        user.setGsAAB004(jsonObject.getString("AAB004"));
        user.setGsAAB034(jsonObject.getString("AAB034"));
        user.setGsBAE703(jsonObject.getString("BAE703"));
    }
}