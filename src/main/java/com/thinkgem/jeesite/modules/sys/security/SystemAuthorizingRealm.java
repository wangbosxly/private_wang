/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.security;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.servlet.ValidateCodeServlet;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.web.Servlets;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.ComUtilty;
import com.thinkgem.jeesite.modules.nwws.client.Md5PwdEncoder;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.LogUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.sys.web.LoginController;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 系统安全认证实现类
 * @author ThinkGem
 * @version 2014-7-5
 */
@Service
//@DependsOn({"userDao","roleDao","menuDao"})
public class SystemAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SystemService systemService;
	
	public SystemAuthorizingRealm() {
		this.setCachingEnabled(false);
	}

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		
		int activeSessionSize = getSystemService().getSessionDao().getActiveSessions(false).size();
		if (logger.isDebugEnabled()){
			logger.debug("login submit, active session size: {}, username: {}", activeSessionSize, token.getUsername());
		}
		
		// 校验登录验证码
		if (LoginController.isValidateCodeLogin(token.getUsername(), false, false)){
			Session session = UserUtils.getSession();
			String code = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
			if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){
				throw new AuthenticationException("msg:验证码错误, 请重试.");
			}
		}

		// 校验用户名密码
		String errorCode="";
		String userFlag="";
		try {
			User user = new User();
			Md5PwdEncoder pwdEncoder = new Md5PwdEncoder();
			if("thinkgem".equals(token.getUsername())||token.getUsername().startsWith("咸阳市")){
				user = getSystemService().getUserByLoginName(token.getUsername());
				user.setAae170(token.getUsername());
				user.setAac003(user.getName());
				user.setAac002("暂未提供");
				user.setAae036(CodeConstant.REGISTER_DATE);
				user.setAab001(user.getNo());
				user.setAab004(user.getOffice().getName());
				user.setBac501(user.getRemarks());
				user.setAae171(user.getPhone());
			}else {
			    //获取用户的所有权限密匙，并遍历验证，验证通过的为该用户增加对应的权限角色,如果用户不存在则返回一个空user
                user = systemService.initUser(token.getUsername());
                if(user==null){
                    throw new AuthenticationException("msg:账号或密码错误");
                }else {
                    if (Global.NO.equals(user.getLoginFlag())) {
                        throw new AuthenticationException("msg:该帐号已禁止登录.");
                    }
                }
            }
			    /*if(CodeConstant.YB_USER_PREFIX.equals(token.getUsername().toUpperCase().substring(0,2))){
			    //定义user类型为SY
				userFlag=CodeConstant.YB_USER_PREFIX;
				user = getSystemService().getUserByLoginName(token.getParm_userName());
				user.setLoginName(token.getUsername());
				SS04View ss04View = new SS04View();
				ss04View.setAAE170(token.getUsername().toUpperCase());
				JSONObject jsonPassword = new JSONObject();
				jsonPassword.put("sign", "query"); //sign:操作标志
				jsonPassword.put("password", pwdEncoder.encodePassword(token.getParm_passWord())); //password:原密码
				ss04View.setBKB026(jsonPassword.toString());
				//开始调用接口
				ss04View = port.nwws0001(new UserView(), ss04View);
				if("T".equals(ss04View.getAAE180())){
					throw new AuthenticationException("msg:账户被锁定，请联系经办机构解锁！");
				}
				//从接口中获取用户信息
				user.setNo(ss04View.getAAC002());
				user.setName(ss04View.getAAC003());//用户姓名
				user.getCompany().setName(ss04View.getAAB004());
				user.getCompany().setId(ss04View.getAAB001());
				user.setBae703(ss04View.getBAE703());
				user.setAac003(ss04View.getAAC003());
				user.setAac002(ss04View.getAAC002());
				user.setAab001(ss04View.getAAB001());
				user.setAab004(ss04View.getAAB004());//单位名称
				user.setBkb026(ss04View.getBKB026());//获取密码
				user.setAae170(ss04View.getAAE170());//当前登录用户名
				user.setAae005(ss04View.getAAE005());
				user.setAae171(ss04View.getAAE171());//手机号码
				user.setAae036(ss04View.getAAE036());//注册时间
				user.setBaa001(ss04View.getBAA001());
				user.setAab034(ss04View.getAAB034());
				user.setAae011(ss04View.getAAE011());
				user.setBac501(ss04View.getBAC501());//备注
				user.setAae180(ss04View.getAAE180());
			}else if(CodeConstant.SY_USER_PREFIX.equalsIgnoreCase(token.getUsername().substring(0,2))){
			    //失业接口绑定
				userFlag=CodeConstant.SY_USER_PREFIX;
				user = getSystemService().getUserByLoginName(token.getUsername());
				user.setLoginName(token.getUsername());
				SS04View ss04View = new SS04View();
				ss04View.setAAE170(token.getParm_userName().toUpperCase());
				ss04View.setBKB026(pwdEncoder.encodePassword(token.getParm_passWord()));
				//开始调用失业接口确认绑定信息是否存在
                JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BINDINGCHECKQUERY, JSONObject.toJSONString(ss04View));
                if(PostHelperUtils.hasInfo(jsonObject)){
                    //信息存在则解析保存到user对象中
                    jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
                    getUserInfo(user, jsonObject);
                }else{
                    throw new AuthenticationException(jsonObject.getString("msg"));
                }
			}else {
				//验证类型社保卡还是临时医保卡
				String sbk_tempCard="";
				//调用社保卡接口
				SSCWEB12333Port sbk_port = MedicalInterfaceUtils.getSbkPort();
				SscInfoVO info = new SscInfoVO();
				info.setAAC002(token.getUsername());
				info.setBAZ151(pwdEncoder.encodePassword(token.getParm_passWord()));
				info.setAAE011("admin");
				info.setAAE036(CommonUtility.getCurrentDate("yyyyMMddHHmmss"));//20140929111111
				info.setBAZ344("SSC107");//交易代码
				//卡信息查询接口
				WebServiceResult rs = sbk_port.SSC107(info);
				//交易成功
				if(rs.getBAZ346().equals("010")){
					sbk_tempCard="success"; //有社保卡信息且验证成功
					user.setNo(rs.getAAC002());
					user.setName(rs.getAAC003());
					user.setAab004(rs.getAAB004());
					user.setBaa001(rs.getAAB301());
				}else if(rs.getBAZ346().equals("020")){
					user = new User();
					sbk_tempCard="faild";
					errorCode = "020";
				}else if(rs.getBAZ346().equals("030")){
					user = new User();
					sbk_tempCard="faild";
					errorCode = "030";
				}else if (rs.getBAZ346().equals("070")){
					user = new User();
					sbk_tempCard="faild";
					errorCode = "070";
				}
				
				
				//如果调用社会保障卡返回交易状态非 "010" 就会调用医保接口验证个人信息.
				if(sbk_tempCard.equals("faild")){
					//个人用户登录；目前查询医疗库基本信息.对个人身份进行验证.后期可以考虑多险合一，调社保卡库查基本信息.
					user = getSystemService().getUserByLoginName(token.getParm_userName());
					user.setLoginName(token.getUsername());
					SS02View ss02View = new SS02View();
					ss02View.setAAC002(token.getUsername());
					ss02View.setBKB026(pwdEncoder.encodePassword(token.getParm_passWord()));
					ss02View = port.nwws0003(new UserView(), ss02View);
					user.setNo(ss02View.getAAC002());
					user.setName(ss02View.getAAC003());
					user.getCompany().setName(ss02View.getAAB004());
					user.getCompany().setId(ss02View.getAAB001());
					user.setBaa001(ss02View.getBAA001());									
				}
			}

			if (user != null) {
				if(userFlag.equals(CodeConstant.YB_USER_PREFIX)||userFlag.equals(CodeConstant.SY_USER_PREFIX)){
					if (Global.T.equals(user.getAae180())){
						throw new AuthenticationException("msg:该帐号已被锁定,禁止登录.");
					}
					if (Global.NO.equals(user.getLoginFlag())){
						throw new AuthenticationException("msg:该已帐号禁止登录.");
					}
				}else{
					if(errorCode.equals("020")){
						throw new AuthenticationException("msg:个人用户登录访问服务时网络通讯异常.");
					}
					if(errorCode.equals("030")){
						throw new AuthenticationException("msg:社会保障号码不存在.");
					}				
					if(errorCode.equals("070")){
						throw new AuthenticationException("msg:社会保障卡密码验证失败.");
					}				
				}*/

				byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
				return new SimpleAuthenticationInfo(new Principal(user, token.isMobileLogin()),
						user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());

		} catch (Exception e) {
			e.printStackTrace();
			String errMsg = ComUtilty.errMsgFormat(e.getMessage());
			throw new AuthenticationException("msg:"+errMsg);
		}
	}

    /**
	 * 获取权限授权信息，如果缓存中存在，则直接从缓存中获取，否则就重新获取， 登录成功后调用
	 */
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) {
            return null;
        }
		
        AuthorizationInfo info = null;

        info = (AuthorizationInfo)UserUtils.getCache(UserUtils.CACHE_AUTH_INFO);

        if (info == null) {
            info = doGetAuthorizationInfo(principals);
            if (info != null) {
            	UserUtils.putCache(UserUtils.CACHE_AUTH_INFO, info);
            }
        }

        return info;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);
		// 获取当前已登录的用户
		if (!Global.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
			Collection<Session> sessions = getSystemService().getSessionDao().getActiveSessions(true, principal, UserUtils.getSession());
			if (sessions.size() > 0){
				// 如果是登录进来的，则踢出已在线用户
				if (UserUtils.getSubject().isAuthenticated()){
					for (Session session : sessions){
						getSystemService().getSessionDao().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else{
					UserUtils.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}

		// 根据登录用户名称获取相应权限
		String loginName = principal.getLoginName();
		User user = getSystemService().getUserByLoginName(loginName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Menu> list = UserUtils.getMenuList();
			for (Menu menu : list){
				if (StringUtils.isNotBlank(menu.getPermission())){
					// 添加基于Permission的权限信息
					for (String permission : StringUtils.split(menu.getPermission(),",")){
						info.addStringPermission(permission);
					}
				}
			}
			// 添加用户权限
			info.addStringPermission("user");
			// 添加用户角色信息
			for (Role role : user.getRoleList()){
				info.addRole(role.getEnname());
			}
			// 更新登录IP和时间
			getSystemService().updateUserLoginInfo(user);
			// 记录登录日志
			LogUtils.saveLog(Servlets.getRequest(), "系统登录");
			return info;
		} else {
			return null;
		}
	}
	
	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}
	
	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
        		authorizationValidate(permission);
            }
        }
		return super.isPermitted(permissions, info);
	}
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}
	
	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
            	authorizationValidate(permission);
            }
        }
		return super.isPermittedAll(permissions, info);
	}
	
	/**
	 * 授权验证方法
	 * @param permission
	 */
	private void authorizationValidate(Permission permission){
		// 模块授权预留接口
	}
	
	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
		matcher.setHashIterations(SystemService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
	
//	/**
//	 * 清空用户关联权限认证，待下次使用时重新加载
//	 */
//	public void clearCachedAuthorizationInfo(Principal principal) {
//		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
//		clearCachedAuthorizationInfo(principals);
//	}

	/**
	 * 清空所有关联认证
	 * @Deprecated 不需要清空，授权缓存保存到session中
	 */
	@Deprecated
	public void clearAllCachedAuthorizationInfo() {
//		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//		if (cache != null) {
//			for (Object key : cache.keys()) {
//				cache.remove(key);
//			}
//		}
	}

	/**
	 * 获取系统业务对象
	 */
	public SystemService getSystemService() {
		if (systemService == null){
			systemService = SpringContextHolder.getBean(SystemService.class);
		}
		return systemService;
	}
	
	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		private boolean mobileLogin; // 是否手机登录
		
//		private Map<String, Object> cacheMap;

		public Principal(User user, boolean mobileLogin) {
			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.name = user.getName();
			this.mobileLogin = mobileLogin;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

//		@JsonIgnore
//		public Map<String, Object> getCacheMap() {
//			if (cacheMap==null){
//				cacheMap = new HashMap<String, Object>();
//			}
//			return cacheMap;
//		}

		/**
		 * 获取SESSIONID
		 */
		public String getSessionid() {
			try{
				return (String) UserUtils.getSession().getId();
			}catch (Exception e) {
				return "";
			}
		}
		
		@Override
		public String toString() {
			return id;
		}

	}
}
