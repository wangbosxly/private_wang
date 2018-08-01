/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonNew.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;

/**
 * 人员信息管理Entity
 * @author wh
 * @version 2017-06-14
 */
public class SyAc01New extends DataEntity<SyAc01New> {
	
	private static final long serialVersionUID = 1L;
	private String aac001;		// 个人编号
	private String baa001;		// 数据分区编号
	private String bac808;		// 个人企业自编号
	private String aab001;		// 单位编号
	private String aac002;		// 公民身份号码
	private String aac003;		// 姓名
	private String aac004;		// 性别
	private String aac005;		// 民族
	private String aac006;		// 出生日期
	private String bic701;		// 档案出生日期
	private String aac007;		// 参加工作日期
	private String aae006;		// 地址
	private String aae005;		// 联系电话
	private String aae007;		// 邮政编码
	private String aac009;		// 户口性质
	private String aac010;		// 户口所在地
	private String aac011;		// 文化程度
	private String aac012;		// 个人身份
	private String aac013;		// 用工形式
	private String aac014;		// 专业技术职务
	private String bac521;		// 高级技术职务类型
	private String aac015;		// 工人技术等级
	private String aac019;		// 特殊工种标识
	private String aac020;		// 行政职务
	private String aae011;		// 经办人
	private String aae036;		// 经办时间
	private String baa008;		// 复核标志
	private String baa009;		// 复核人
	private String baa010;		// 复核时间
	private String aab024;		// 缴费开户银行行号
	private String aab025;		// 缴费银行户名
	private String aab026;		// 缴费银行基本帐号
	private String aac017;		// 婚姻状况
	private String bac503;		// 劳模等级
	private String bac515;		// 公务员类别
	private String bac508;		// 是否独生子女
	private String bac801;		// 个人荣誉标志
	private String bac802;		// 艰苦地区
	private String bac803;		// 是否曾在部队服役
	private String bic802;		// 建帐日期
	private String aab060;		// 分支机构代码
	private String aae013;		// 备注
	private String bac501;		// 邮件地址
	private String bac502;		// 公务员批准文号
	private String bac511;		// 首次缴费时间
	private String bac809;		// 旧系统个人编号
	private Long bac811;		// 生育并发症标志
	
	private String aab004;  //单位名称
	private String aac008;  //人员状态
	private String akc021;  //参保人员类别
	private String aae140_3; //是否参加医疗保险
	private String aae140_4; //是否参加工伤保险
	private String aae140_5; //是否参加生育保险
	private String aae140_8; //是否参加补充医疗保险
	private String aae140_9; //是否参加公务员医疗保险
	private String aae140_10; //是否参加大病医疗保险
	
	private String show3_flag; //是否显示医疗保险
	private String show4_flag; //是否显示工伤保险
	
	private String aac030_3;//医疗保险参保时间
	private String aac030_4;//工伤保险参保时间
	private String aac030_5; //生育保险参保时间
	private String aac030_8; //补充医疗保险参保时间
	private String aac030_9; //公务员医疗保险参保时间
	private String aac030_10; //大病医疗保险参保时间
	
	private String bac504_3;//医疗保险申报工资
	private String bac504_4;//工伤保险申报工资
	
	private String aac031; //参保状态
	
	private String akc401;//医疗照顾人员标志
	
	
	public SyAc01New() {
		super();
	}

	public SyAc01New(String id){
		super(id);
	}

	@Length(min=1, max=15, message="个人编号长度必须介于 1 和 15 之间")
	public String getAac001() {
		return aac001;
	}

	public void setAac001(String aac001) {
		this.aac001 = aac001;
	}
	
	@Length(min=1, max=10, message="数据分区编号长度必须介于 1 和 10 之间")
	public String getBaa001() {
		return baa001;
	}

	public void setBaa001(String baa001) {
		this.baa001 = baa001;
	}
	
	@Length(min=0, max=12, message="个人企业自编号长度必须介于 0 和 12 之间")
	public String getBac808() {
		return bac808;
	}

	public void setBac808(String bac808) {
		this.bac808 = bac808;
	}
	
	@Length(min=1, max=15, message="单位编号长度必须介于 1 和 15 之间")
	public String getAab001() {
		return aab001;
	}

	public void setAab001(String aab001) {
		this.aab001 = aab001;
	}
	
	@Length(min=0, max=18, message="公民身份号码长度必须介于 0 和 18 之间")
	@ExcelField(title="身份证号", align=2, sort=30)
	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}
	
	@Length(min=1, max=20, message="姓名长度必须介于 1 和 20 之间")
	@ExcelField(title="姓名", align=2, sort=10)
	public String getAac003() {
		return aac003;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}
	
	@Length(min=1, max=3, message="性别长度必须介于 1 和 3 之间")
	@ExcelField(title="性别", align=2, sort=20)
	public String getAac004() {
		return aac004;
	}

	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}
	
	@Length(min=1, max=3, message="民族长度必须介于 1 和 3 之间")
	@ExcelField(title="民族", align=2, sort=80)
	public String getAac005() {
		return aac005;
	}

	public void setAac005(String aac005) {
		this.aac005 = aac005;
	}
	
	@Length(min=1, max=10, message="出生日期长度必须介于 1 和 10 之间")
	public String getAac006() {
		return aac006;
	}

	public void setAac006(String aac006) {
		this.aac006 = aac006;
	}
	
	@Length(min=0, max=10, message="档案出生日期长度必须介于 0 和 10 之间")
	public String getBic701() {
		return bic701;
	}

	public void setBic701(String bic701) {
		this.bic701 = bic701;
	}
	
	@Length(min=1, max=10, message="参加工作日期长度必须介于 1 和 10 之间")
	@ExcelField(title="参加工作时间", align=2, sort=100)
	public String getAac007() {
		return aac007;
	}

	public void setAac007(String aac007) {
		this.aac007 = aac007;
	}
	
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getAae006() {
		return aae006;
	}

	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}
	
	@Length(min=0, max=20, message="联系电话长度必须介于 0 和 20 之间")
	public String getAae005() {
		return aae005;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	
	@Length(min=0, max=6, message="邮政编码长度必须介于 0 和 6 之间")
	public String getAae007() {
		return aae007;
	}

	public void setAae007(String aae007) {
		this.aae007 = aae007;
	}
	
	@Length(min=1, max=3, message="户口性质长度必须介于 1 和 3 之间")
	@ExcelField(title="户口性质", align=2, sort=90)
	public String getAac009() {
		return aac009;
	}

	public void setAac009(String aac009) {
		this.aac009 = aac009;
	}
	
	@Length(min=0, max=100, message="户口所在地长度必须介于 0 和 100 之间")
	public String getAac010() {
		return aac010;
	}

	public void setAac010(String aac010) {
		this.aac010 = aac010;
	}
	
	@Length(min=0, max=3, message="文化程度长度必须介于 0 和 3 之间")
	public String getAac011() {
		return aac011;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}
	
	@Length(min=1, max=3, message="个人身份长度必须介于 1 和 3 之间")
	public String getAac012() {
		return aac012;
	}

	public void setAac012(String aac012) {
		this.aac012 = aac012;
	}
	
	@Length(min=1, max=3, message="用工形式长度必须介于 1 和 3 之间")
	public String getAac013() {
		return aac013;
	}

	public void setAac013(String aac013) {
		this.aac013 = aac013;
	}
	
	@Length(min=1, max=3, message="专业技术职务长度必须介于 1 和 3 之间")
	public String getAac014() {
		return aac014;
	}

	public void setAac014(String aac014) {
		this.aac014 = aac014;
	}
	
	@Length(min=0, max=3, message="高级技术职务类型长度必须介于 0 和 3 之间")
	public String getBac521() {
		return bac521;
	}

	public void setBac521(String bac521) {
		this.bac521 = bac521;
	}
	
	@Length(min=1, max=3, message="工人技术等级长度必须介于 1 和 3 之间")
	public String getAac015() {
		return aac015;
	}

	public void setAac015(String aac015) {
		this.aac015 = aac015;
	}
	
	@Length(min=1, max=3, message="特殊工种标识长度必须介于 1 和 3 之间")
	public String getAac019() {
		return aac019;
	}

	public void setAac019(String aac019) {
		this.aac019 = aac019;
	}
	
	@Length(min=1, max=3, message="行政职务长度必须介于 1 和 3 之间")
	public String getAac020() {
		return aac020;
	}

	public void setAac020(String aac020) {
		this.aac020 = aac020;
	}
	
	@Length(min=1, max=10, message="经办人长度必须介于 1 和 10 之间")
	public String getAae011() {
		return aae011;
	}

	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}
	
	@Length(min=1, max=19, message="经办时间长度必须介于 1 和 19 之间")
	public String getAae036() {
		return aae036;
	}

	public void setAae036(String aae036) {
		this.aae036 = aae036;
	}
	
	@Length(min=1, max=3, message="复核标志长度必须介于 1 和 3 之间")
	public String getBaa008() {
		return baa008;
	}

	public void setBaa008(String baa008) {
		this.baa008 = baa008;
	}
	
	@Length(min=0, max=10, message="复核人长度必须介于 0 和 10 之间")
	public String getBaa009() {
		return baa009;
	}

	public void setBaa009(String baa009) {
		this.baa009 = baa009;
	}
	
	@Length(min=0, max=19, message="复核时间长度必须介于 0 和 19 之间")
	public String getBaa010() {
		return baa010;
	}

	public void setBaa010(String baa010) {
		this.baa010 = baa010;
	}
	
	@Length(min=0, max=40, message="缴费开户银行行号长度必须介于 0 和 40 之间")
	public String getAab024() {
		return aab024;
	}

	public void setAab024(String aab024) {
		this.aab024 = aab024;
	}
	
	@Length(min=0, max=100, message="缴费银行户名长度必须介于 0 和 100 之间")
	public String getAab025() {
		return aab025;
	}

	public void setAab025(String aab025) {
		this.aab025 = aab025;
	}
	
	@Length(min=0, max=40, message="缴费银行基本帐号长度必须介于 0 和 40 之间")
	public String getAab026() {
		return aab026;
	}

	public void setAab026(String aab026) {
		this.aab026 = aab026;
	}
	
	@Length(min=0, max=3, message="婚姻状况长度必须介于 0 和 3 之间")
	public String getAac017() {
		return aac017;
	}

	public void setAac017(String aac017) {
		this.aac017 = aac017;
	}
	
	@Length(min=0, max=3, message="劳模等级长度必须介于 0 和 3 之间")
	public String getBac503() {
		return bac503;
	}

	public void setBac503(String bac503) {
		this.bac503 = bac503;
	}
	
	@Length(min=0, max=3, message="公务员类别长度必须介于 0 和 3 之间")
	public String getBac515() {
		return bac515;
	}

	public void setBac515(String bac515) {
		this.bac515 = bac515;
	}
	
	@Length(min=0, max=3, message="是否独生子女长度必须介于 0 和 3 之间")
	public String getBac508() {
		return bac508;
	}

	public void setBac508(String bac508) {
		this.bac508 = bac508;
	}
	
	@Length(min=0, max=3, message="个人荣誉标志长度必须介于 0 和 3 之间")
	public String getBac801() {
		return bac801;
	}

	public void setBac801(String bac801) {
		this.bac801 = bac801;
	}
	
	@Length(min=0, max=3, message="艰苦地区长度必须介于 0 和 3 之间")
	public String getBac802() {
		return bac802;
	}

	public void setBac802(String bac802) {
		this.bac802 = bac802;
	}
	
	@Length(min=0, max=3, message="是否曾在部队服役长度必须介于 0 和 3 之间")
	public String getBac803() {
		return bac803;
	}

	public void setBac803(String bac803) {
		this.bac803 = bac803;
	}
	
	@Length(min=0, max=10, message="建帐日期长度必须介于 0 和 10 之间")
	public String getBic802() {
		return bic802;
	}

	public void setBic802(String bic802) {
		this.bic802 = bic802;
	}
	
	@Length(min=0, max=8, message="分支机构代码长度必须介于 0 和 8 之间")
	public String getAab060() {
		return aab060;
	}

	public void setAab060(String aab060) {
		this.aab060 = aab060;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getAae013() {
		return aae013;
	}

	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}
	
	@Length(min=0, max=32, message="邮件地址长度必须介于 0 和 32 之间")
	public String getBac501() {
		return bac501;
	}

	public void setBac501(String bac501) {
		this.bac501 = bac501;
	}
	
	@Length(min=0, max=100, message="公务员批准文号长度必须介于 0 和 100 之间")
	public String getBac502() {
		return bac502;
	}

	public void setBac502(String bac502) {
		this.bac502 = bac502;
	}
	
	@Length(min=0, max=10, message="首次缴费时间长度必须介于 0 和 10 之间")
	public String getBac511() {
		return bac511;
	}

	public void setBac511(String bac511) {
		this.bac511 = bac511;
	}
	
	@Length(min=0, max=20, message="旧系统个人编号长度必须介于 0 和 20 之间")
	public String getBac809() {
		return bac809;
	}

	public void setBac809(String bac809) {
		this.bac809 = bac809;
	}
	
	public Long getBac811() {
		return bac811;
	}

	public void setBac811(Long bac811) {
		this.bac811 = bac811;
	}

	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	@ExcelField(title="人员状态", align=2, sort=60)
	public String getAac008() {
		return aac008;
	}

	public void setAac008(String aac008) {
		this.aac008 = aac008;
	}

	@ExcelField(title="人员类别", align=2, sort=70)
	public String getAkc021() {
		return akc021;
	}

	public void setAkc021(String akc021) {
		this.akc021 = akc021;
	}


	@ExcelField(title="医疗申报工资", align=2, sort=40)
	public String getBac504_3() {
		return bac504_3;
	}

	public void setBac504_3(String bac504_3) {
		this.bac504_3 = bac504_3;
	}

	@ExcelField(title="工伤申报工资", align=2, sort=50)
	public String getBac504_4() {
		return bac504_4;
	}

	public void setBac504_4(String bac504_4) {
		this.bac504_4 = bac504_4;
	}

	public String getAac031() {
		return aac031;
	}

	public void setAac031(String aac031) {
		this.aac031 = aac031;
	}

	public String getAkc401() {
		return akc401;
	}

	public void setAkc401(String akc401) {
		this.akc401 = akc401;
	}

	@ExcelField(title="医疗保险", align=2, sort=110)
	public String getAae140_3() {
		return aae140_3;
	}

	public void setAae140_3(String aae140_3) {
		this.aae140_3 = aae140_3;
	}

	@ExcelField(title="工伤保险", align=2, sort=130)
	public String getAae140_4() {
		return aae140_4;
	}

	public void setAae140_4(String aae140_4) {
		this.aae140_4 = aae140_4;
	}

	@ExcelField(title="生育保险", align=2, sort=150)
	public String getAae140_5() {
		return aae140_5;
	}

	public void setAae140_5(String aae140_5) {
		this.aae140_5 = aae140_5;
	}

	@ExcelField(title="补充医疗", align=2, sort=170)
	public String getAae140_8() {
		return aae140_8;
	}

	public void setAae140_8(String aae140_8) {
		this.aae140_8 = aae140_8;
	}

	@ExcelField(title="公务员医疗", align=2, sort=190)
	public String getAae140_9() {
		return aae140_9;
	}

	public void setAae140_9(String aae140_9) {
		this.aae140_9 = aae140_9;
	}

	@ExcelField(title="大病医疗保险", align=2, sort=210)
	public String getAae140_10() {
		return aae140_10;
	}

	public void setAae140_10(String aae140_10) {
		this.aae140_10 = aae140_10;
	}

	@ExcelField(title="参保时间", align=2, sort=120)
	public String getAac030_3() {
		return aac030_3;
	}

	public void setAac030_3(String aac030_3) {
		this.aac030_3 = aac030_3;
	}

	@ExcelField(title="参保时间", align=2, sort=140)
	public String getAac030_4() {
		return aac030_4;
	}

	public void setAac030_4(String aac030_4) {
		this.aac030_4 = aac030_4;
	}
	
	@ExcelField(title="参保时间", align=2, sort=160)
	public String getAac030_5() {
		return aac030_5;
	}

	public void setAac030_5(String aac030_5) {
		this.aac030_5 = aac030_5;
	}

	@ExcelField(title="参保时间", align=2, sort=180)
	public String getAac030_8() {
		return aac030_8;
	}

	public void setAac030_8(String aac030_8) {
		this.aac030_8 = aac030_8;
	}

	@ExcelField(title="参保时间", align=2, sort=200)
	public String getAac030_9() {
		return aac030_9;
	}

	public void setAac030_9(String aac030_9) {
		this.aac030_9 = aac030_9;
	}

	@ExcelField(title="参保时间", align=2, sort=220)
	public String getAac030_10() {
		return aac030_10;
	}

	public void setAac030_10(String aac030_10) {
		this.aac030_10 = aac030_10;
	}

	public String getShow3_flag() {
		return show3_flag;
	}

	public void setShow3_flag(String show3_flag) {
		this.show3_flag = show3_flag;
	}

	public String getShow4_flag() {
		return show4_flag;
	}

	public void setShow4_flag(String show4_flag) {
		this.show4_flag = show4_flag;
	}
	
}