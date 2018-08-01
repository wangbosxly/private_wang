package com.thinkgem.jeesite.modules.sys.handle;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 描述:
 * 密匙执行接口
 *
 * @author X_P
 * @create 2018-06-05 10:40
 */
public interface TokenHandler {

    Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
    /**
     * 获取密匙验证的信息,去除封装外层的信息
     * @return
     */
    JSONObject validateInfo();

    /**
     * 获取密匙的状态信息，判断是否被锁定
     */
    String getState();

    /**
     * 给User中绑定数据
     */
    void prepareUser(User user);
}
