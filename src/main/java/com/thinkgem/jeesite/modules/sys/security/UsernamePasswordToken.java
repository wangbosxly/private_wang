/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.security;

/**
 * 用户和密码（包含验证码）令牌类
 * @author ThinkGem
 * @version 2013-5-19
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	private String parm_userName;
	private String parm_passWord;
	private boolean mobileLogin;
	
	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, char[] password,
			boolean rememberMe, String host, String captcha, boolean mobileLogin) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.mobileLogin = mobileLogin;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public boolean isMobileLogin() {
		return mobileLogin;
	}

	public String getParm_userName() {
		return parm_userName;
	}

	public void setParm_userName(String parm_userName) {
		this.parm_userName = parm_userName;
	}

	public String getParm_passWord() {
		return parm_passWord;
	}

	public void setParm_passWord(String parm_passWord) {
		this.parm_passWord = parm_passWord;
	}
}