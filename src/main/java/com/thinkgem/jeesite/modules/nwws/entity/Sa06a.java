/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nwws.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 受理单查询Entity
 * @author xp
 * @version 2016-11-01
 */
public class Sa06a extends DataEntity<Sa06a> {
	
	private static final long serialVersionUID = 1L;
	private String saa004;		// 事项id
	private String saa015;		// 功能id
	private String bae702;		// 主体类别(0个人,1单位)
	private String bae703;		// 主体编号
	private String saa031;		// 表单模板ID
	private String saa039;		// 业务表单内容
	private String saa043;		// 业务状态
	private String saa024;		// 法定期限
	private String saa018;		// 承诺时限
	private String saa055;		// 处理时间
	private String saa041;		// 受理时间
	private String saa040;		// 办结时间
	private String busId;		// 业务ID
	private String szz003;		// 服务机构ID
	private String saa080;		// 受理人
	private String saa037;		// 申请人
	private String saa038;		// 申请时间
	private String saa017;		// 申报名称
	private String aab004;		// 单位名称
	private String aab034;		// 受理机构
	private String saa042;		// 受理状态
	
	public Sa06a() {
		super();
	}

	public Sa06a(String id){
		super(id);
	}

	@Length(min=1, max=20, message="事项id长度必须介于 1 和 20 之间")
	public String getSaa004() {
		return saa004;
	}

	public void setSaa004(String saa004) {
		this.saa004 = saa004;
	}
	
	@Length(min=1, max=5, message="功能id长度必须介于 1 和 5 之间")
	public String getSaa015() {
		return saa015;
	}

	public void setSaa015(String saa015) {
		this.saa015 = saa015;
	}
	
	@Length(min=1, max=3, message="主体类别(0个人,1单位)长度必须介于 1 和 3 之间")
	public String getBae702() {
		return bae702;
	}

	public void setBae702(String bae702) {
		this.bae702 = bae702;
	}
	
	@Length(min=1, max=20, message="主体编号长度必须介于 1 和 20 之间")
	public String getBae703() {
		return bae703;
	}

	public void setBae703(String bae703) {
		this.bae703 = bae703;
	}
	
	@Length(min=0, max=20, message="表单模板ID长度必须介于 0 和 20 之间")
	public String getSaa031() {
		return saa031;
	}

	public void setSaa031(String saa031) {
		this.saa031 = saa031;
	}
	
	public String getSaa039() {
		return saa039;
	}

	public void setSaa039(String saa039) {
		this.saa039 = saa039;
	}
	
	@Length(min=1, max=3, message="业务状态长度必须介于 1 和 3 之间")
	public String getSaa043() {
		return saa043;
	}

	public void setSaa043(String saa043) {
		this.saa043 = saa043;
	}
	
	@Length(min=0, max=20, message="法定期限长度必须介于 0 和 20 之间")
	public String getSaa024() {
		return saa024;
	}

	public void setSaa024(String saa024) {
		this.saa024 = saa024;
	}
	
	@Length(min=0, max=20, message="承诺时限长度必须介于 0 和 20 之间")
	public String getSaa018() {
		return saa018;
	}

	public void setSaa018(String saa018) {
		this.saa018 = saa018;
	}
	
	@Length(min=0, max=20, message="处理时间长度必须介于 0 和 20 之间")
	public String getSaa055() {
		return saa055;
	}

	public void setSaa055(String saa055) {
		this.saa055 = saa055;
	}
	
	@Length(min=0, max=20, message="受理时间长度必须介于 0 和 20 之间")
	public String getSaa041() {
		return saa041;
	}

	public void setSaa041(String saa041) {
		this.saa041 = saa041;
	}
	
	@Length(min=0, max=20, message="办结时间长度必须介于 0 和 20 之间")
	public String getSaa040() {
		return saa040;
	}

	public void setSaa040(String saa040) {
		this.saa040 = saa040;
	}
	
	@Length(min=0, max=20, message="业务ID长度必须介于 0 和 20 之间")
	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}
	
	@Length(min=0, max=20, message="服务机构ID长度必须介于 0 和 20 之间")
	public String getSzz003() {
		return szz003;
	}

	public void setSzz003(String szz003) {
		this.szz003 = szz003;
	}
	
	@Length(min=0, max=20, message="受理人长度必须介于 0 和 20 之间")
	public String getSaa080() {
		return saa080;
	}

	public void setSaa080(String saa080) {
		this.saa080 = saa080;
	}
	
	@Length(min=1, max=20, message="申请人长度必须介于 1 和 20 之间")
	public String getSaa037() {
		return saa037;
	}

	public void setSaa037(String saa037) {
		this.saa037 = saa037;
	}
	
	@Length(min=1, max=19, message="申请时间长度必须介于 1 和 19 之间")
	public String getSaa038() {
		return saa038;
	}

	public void setSaa038(String saa038) {
		this.saa038 = saa038;
	}
	
	@Length(min=0, max=255, message="申报名称长度必须介于 0 和 255 之间")
	public String getSaa017() {
		return saa017;
	}

	public void setSaa017(String saa017) {
		this.saa017 = saa017;
	}
	
	@Length(min=0, max=100, message="单位名称长度必须介于 0 和 100 之间")
	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	
	@Length(min=0, max=255, message="受理机构长度必须介于 0 和 255 之间")
	public String getAab034() {
		return aab034;
	}

	public void setAab034(String aab034) {
		this.aab034 = aab034;
	}
	
	@Length(min=0, max=100, message="受理状态长度必须介于 0 和 100 之间")
	public String getSaa042() {
		return saa042;
	}

	public void setSaa042(String saa042) {
		this.saa042 = saa042;
	}
	
}