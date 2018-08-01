/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.supcan.annotation.treelist.cols.SupCol;
import com.thinkgem.jeesite.common.utils.Collections3;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.common.utils.excel.fieldtype.RoleListType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 用户Entity
 * @author ThinkGem
 * @version 2013-12-05
 */
public class User extends DataEntity<User> {

	private static final long serialVersionUID = 1L;
	private Office company;	// 归属公司
	private Office office;	// 归属部门
	private String loginName;// 登录名
	private String password;// 密码
	private String no;		// 工号
	private String name;	// 姓名
	private String email;	// 邮箱
	private String phone;	// 电话
	private String mobile;	// 手机
	private String userType;// 用户类型
	private String loginIp;	// 最后登陆IP
	private Date loginDate;	// 最后登陆日期
	private String loginFlag;	// 是否允许登陆
	private String photo;	// 头像
	
	private String BAB501;
	private String AAE140;

	private String oldLoginName;// 原登录名
	private String newPassword;	// 新密码
	
	private String oldLoginIp;	// 上次登陆IP
	private Date oldLoginDate;	// 上次登陆日期
	
	private Role role;	// 根据角色查询用户条件
	
	//pm11表
	private String  aae170;
	private String  aac003;
	private String  aae179;
	private String  bkb026;
	private String  aac002;
	private String  bae703;
	private String  aae005;
	private String  aae171;
	private String  bac501;
	private String  aab001;
	private String  aab004;
	private String  aae172;
	private String  aae173;
	private String  aae174;
	private String  aae182;
	private String  aae180;
	private String  aae011;
	private String  aae036;
	private String  baa001;
	private String  aab034;
	private String  aab060;


    private String gsAAE174;//时间
    private String gsAAE036;//注册时间
    private String gsAAE011;//经办人
    private String gsAAB001;//单位编号
    private String gsAAE179;
    private String gsAAC002;
    private String gsAAE170;//密匙账号
    private String gsAAE182;
    private String gsAAE172;
    private String gsAAE180;//锁定状态 F正常，T锁定
    private String gsAAC003;
    private String gsBAA001;
    private String gsBKB026;
    private String gsAAB004;
    private String gsAAB034;
    private String gsBAE703;//主体编号


	private String ybAAB001;
	private String ybAAE174;
	private String ybAAE036;
	private String ybAAE011;
	private String ybAAE179;
	private String ybAAC002;
	private String ybAAE170;
	private String ybAAE182;
	private String ybAAE172;
	private String ybAAE180;
	private String ybAAC003;
	private String ybBAA001;
	private String ybBKB026;
	private String ybAAB004;
	private String ybAAB034;
	private String ybBAE703;

	public String getYbAAB001() {
		return ybAAB001;
	}

	public void setYbAAB001(String ybAAB001) {
		this.ybAAB001 = ybAAB001;
	}

	public String getYbAAE174() {
		return ybAAE174;
	}

	public void setYbAAE174(String ybAAE174) {
		this.ybAAE174 = ybAAE174;
	}

	public String getYbAAE036() {
		return ybAAE036;
	}

	public void setYbAAE036(String ybAAE036) {
		this.ybAAE036 = ybAAE036;
	}

	public String getYbAAE011() {
		return ybAAE011;
	}

	public void setYbAAE011(String ybAAE011) {
		this.ybAAE011 = ybAAE011;
	}

	public String getYbAAE179() {
		return ybAAE179;
	}

	public void setYbAAE179(String ybAAE179) {
		this.ybAAE179 = ybAAE179;
	}

	public String getYbAAC002() {
		return ybAAC002;
	}

	public void setYbAAC002(String ybAAC002) {
		this.ybAAC002 = ybAAC002;
	}

	public String getYbAAE170() {
		return ybAAE170;
	}

	public void setYbAAE170(String ybAAE170) {
		this.ybAAE170 = ybAAE170;
	}

	public String getYbAAE182() {
		return ybAAE182;
	}

	public void setYbAAE182(String ybAAE182) {
		this.ybAAE182 = ybAAE182;
	}

	public String getYbAAE172() {
		return ybAAE172;
	}

	public void setYbAAE172(String ybAAE172) {
		this.ybAAE172 = ybAAE172;
	}

	public String getYbAAE180() {
		return ybAAE180;
	}

	public void setYbAAE180(String ybAAE180) {
		this.ybAAE180 = ybAAE180;
	}

	public String getYbAAC003() {
		return ybAAC003;
	}

	public void setYbAAC003(String ybAAC003) {
		this.ybAAC003 = ybAAC003;
	}

	public String getYbBAA001() {
		return ybBAA001;
	}

	public void setYbBAA001(String ybBAA001) {
		this.ybBAA001 = ybBAA001;
	}

	public String getYbBKB026() {
		return ybBKB026;
	}

	public void setYbBKB026(String ybBKB026) {
		this.ybBKB026 = ybBKB026;
	}

	public String getYbAAB004() {
		return ybAAB004;
	}

	public void setYbAAB004(String ybAAB004) {
		this.ybAAB004 = ybAAB004;
	}

	public String getYbAAB034() {
		return ybAAB034;
	}

	public void setYbAAB034(String ybAAB034) {
		this.ybAAB034 = ybAAB034;
	}

	public String getYbBAE703() {
		return ybBAE703;
	}

	public void setYbBAE703(String ybBAE703) {
		this.ybBAE703 = ybBAE703;
	}

	public String getGsAAE174() {
        return gsAAE174;
    }

    public void setGsAAE174(String gsAAE174) {
        this.gsAAE174 = gsAAE174;
    }

    public String getGsAAE036() {
        return gsAAE036;
    }

    public void setGsAAE036(String gsAAE036) {
        this.gsAAE036 = gsAAE036;
    }

    public String getGsAAE011() {
        return gsAAE011;
    }

    public void setGsAAE011(String gsAAE011) {
        this.gsAAE011 = gsAAE011;
    }

    public String getGsAAB001() {
        return gsAAB001;
    }

    public void setGsAAB001(String gsAAB001) {
        this.gsAAB001 = gsAAB001;
    }

    public String getGsAAE179() {
        return gsAAE179;
    }

    public void setGsAAE179(String gsAAE179) {
        this.gsAAE179 = gsAAE179;
    }

    public String getGsAAC002() {
        return gsAAC002;
    }

    public void setGsAAC002(String gsAAC002) {
        this.gsAAC002 = gsAAC002;
    }

    public String getGsAAE170() {
        return gsAAE170;
    }

    public void setGsAAE170(String gsAAE170) {
        this.gsAAE170 = gsAAE170;
    }

    public String getGsAAE182() {
        return gsAAE182;
    }

    public void setGsAAE182(String gsAAE182) {
        this.gsAAE182 = gsAAE182;
    }

    public String getGsAAE172() {
        return gsAAE172;
    }

    public void setGsAAE172(String gsAAE172) {
        this.gsAAE172 = gsAAE172;
    }

    public String getGsAAE180() {
        return gsAAE180;
    }

    public void setGsAAE180(String gsAAE180) {
        this.gsAAE180 = gsAAE180;
    }

    public String getGsAAC003() {
        return gsAAC003;
    }

    public void setGsAAC003(String gsAAC003) {
        this.gsAAC003 = gsAAC003;
    }

    public String getGsBAA001() {
        return gsBAA001;
    }

    public void setGsBAA001(String gsBAA001) {
        this.gsBAA001 = gsBAA001;
    }

    public String getGsBKB026() {
        return gsBKB026;
    }

    public void setGsBKB026(String gsBKB026) {
        this.gsBKB026 = gsBKB026;
    }

    public String getGsAAB004() {
        return gsAAB004;
    }

    public void setGsAAB004(String gsAAB004) {
        this.gsAAB004 = gsAAB004;
    }

    public String getGsAAB034() {
        return gsAAB034;
    }

    public void setGsAAB034(String gsAAB034) {
        this.gsAAB034 = gsAAB034;
    }

    public String getGsBAE703() {
        return gsBAE703;
    }

    public void setGsBAE703(String gsBAE703) {
        this.gsBAE703 = gsBAE703;
    }

    public String getAae170() {
		return aae170;
	}

	public void setAae170(String aae170) {
		this.aae170 = aae170;
	}

	public String getAac003() {
		return aac003;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public String getAae179() {
		return aae179;
	}

	public void setAae179(String aae179) {
		this.aae179 = aae179;
	}

	public String getBkb026() {
		return bkb026;
	}

	public void setBkb026(String bkb026) {
		this.bkb026 = bkb026;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public String getBae703() {
		return bae703;
	}

	public void setBae703(String bae703) {
		this.bae703 = bae703;
	}

	public String getAae005() {
		return aae005;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}

	public String getAae171() {
		return aae171;
	}

	public void setAae171(String aae171) {
		this.aae171 = aae171;
	}

	public String getBac501() {
		return bac501;
	}

	public void setBac501(String bac501) {
		this.bac501 = bac501;
	}

	public String getAab001() {
		return aab001;
	}

	public void setAab001(String aab001) {
		this.aab001 = aab001;
	}

	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	public String getAae172() {
		return aae172;
	}

	public void setAae172(String aae172) {
		this.aae172 = aae172;
	}

	public String getAae173() {
		return aae173;
	}

	public void setAae173(String aae173) {
		this.aae173 = aae173;
	}

	public String getAae174() {
		return aae174;
	}

	public void setAae174(String aae174) {
		this.aae174 = aae174;
	}

	public String getAae182() {
		return aae182;
	}

	public void setAae182(String aae182) {
		this.aae182 = aae182;
	}

	public String getAae180() {
		return aae180;
	}

	public void setAae180(String aae180) {
		this.aae180 = aae180;
	}

	public String getAae011() {
		return aae011;
	}

	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}

	public String getAae036() {
		return aae036;
	}

	public void setAae036(String aae036) {
		this.aae036 = aae036;
	}

	public String getBaa001() {
		return baa001;
	}

	public void setBaa001(String baa001) {
		this.baa001 = baa001;
	}

	public String getAab034() {
		return aab034;
	}

	public void setAab034(String aab034) {
		this.aab034 = aab034;
	}

	public String getAab060() {
		return aab060;
	}

	public void setAab060(String aab060) {
		this.aab060 = aab060;
	}

	public String getBAB501() {
		return BAB501;
	}

	public void setBAB501(String bAB501) {
		BAB501 = bAB501;
	}

	public String getAAE140() {
		return AAE140;
	}

	public void setAAE140(String aAE140) {
		AAE140 = aAE140;
	}

	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表

	public User() {
		super();
		this.loginFlag = Global.YES;
	}
	
	public User(String id){
		super(id);
	}

	public User(String id, String loginName){
		super(id);
		this.loginName = loginName;
	}

	public User(Role role){
		super();
		this.role = role;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	@SupCol(isUnique="true", isHide="true")
	@ExcelField(title="ID", type=1, align=2, sort=1)
	public String getId() {
		return id;
	}

	@JsonIgnore
	@NotNull(message="归属公司不能为空")
	@ExcelField(title="归属公司", align=2, sort=20)
	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}
	
	@JsonIgnore
	@NotNull(message="归属部门不能为空")
	@ExcelField(title="归属部门", align=2, sort=25)
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@Length(min=1, max=100, message="登录名长度必须介于 1 和 100 之间")
	@ExcelField(title="登录名", align=2, sort=30)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@JsonIgnore
	@Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Length(min=1, max=100, message="姓名长度必须介于 1 和 100 之间")
	@ExcelField(title="姓名", align=2, sort=40)
	public String getName() {
		return name;
	}
	
	@Length(min=1, max=100, message="工号长度必须介于 1 和 100 之间")
	@ExcelField(title="工号", align=2, sort=45)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Email(message="邮箱格式不正确")
	@Length(min=0, max=200, message="邮箱长度必须介于 1 和 200 之间")
	@ExcelField(title="邮箱", align=1, sort=50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 1 和 200 之间")
	@ExcelField(title="电话", align=2, sort=60)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min=0, max=200, message="手机长度必须介于 1 和 200 之间")
	@ExcelField(title="手机", align=2, sort=70)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ExcelField(title="备注", align=1, sort=900)
	public String getRemarks() {
		return remarks;
	}
	
	@Length(min=0, max=100, message="用户类型长度必须介于 1 和 100 之间")
	@ExcelField(title="用户类型", align=2, sort=80, dictType="sys_user_type")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@ExcelField(title="创建时间", type=0, align=1, sort=90)
	public Date getCreateDate() {
		return createDate;
	}

	@ExcelField(title="最后登录IP", type=1, align=1, sort=100)
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="最后登录日期", type=1, align=1, sort=110)
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldLoginIp() {
		if (oldLoginIp == null){
			return loginIp;
		}
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOldLoginDate() {
		if (oldLoginDate == null){
			return loginDate;
		}
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	@ExcelField(title="拥有角色", align=1, sort=800, fieldType=RoleListType.class)
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@JsonIgnore
	public List<String> getRoleIdList() {
		List<String> roleIdList = Lists.newArrayList();
		for (Role role : roleList) {
			roleIdList.add(role.getId());
		}
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		roleList = Lists.newArrayList();
		for (String roleId : roleIdList) {
			Role role = new Role();
			role.setId(roleId);
			roleList.add(role);
		}
	}
	
	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ",");
	}
	
	public boolean isAdmin(){
		return isAdmin(this.id);
	}
	
	public static boolean isAdmin(String id){
		return id != null && "1".equals(id);
	}
	
	@Override
	public String toString() {
		return id;
	}
}