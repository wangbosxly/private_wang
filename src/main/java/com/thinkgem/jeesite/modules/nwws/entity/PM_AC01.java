/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nwws.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 社保人员基本信息查询Entity
 * @author xp
 * @version 2016-10-14
 */
public class PM_AC01 extends DataEntity<PM_AC01> {
	
	private static final long serialVersionUID = 1L;
	private String AAA040;

    private String AAB001;

    private String AAB004;

    private String AAB024;

    private String AAB025;

    private String AAB026;

    private String AAB034;

    private String AAB060;

    private String AAC001;

    private String AAC002;

    private String AAC002_1;

    private String AAC003;

    private String AAC004;

    private String AAC005;

    private String AAC006;

    private String AAC007;

    private String AAC008;

    private String AAC009;

    private String AAC010;

    private String AAC011;

    private String AAC012;

    private String AAC013;

    private String AAC014;

    private String AAC015;

    private String AAC017;

    private String AAC019;

    private String AAC020;

    private String AAC030;

    private String AAC031;

    private String AAC040;

    private String AAC050;

    private String AAC058;

    private String AAC121;

    private String AAC122;

    private String AAE002;

    private String AAE003;

    private String AAE005;

    private String AAE006;

    private String AAE007;

    private String AAE008;

    private String AAE010;

    private String AAE011;

    private String AAE013;

    private String AAE030;

    private String AAE035;

    private String AAE036;

    private String AAE100;

    private String AAE102;

    private String AAE140;

    private String AAE160;

    private String AIC162;

    private String AIC331;

    private String AKC020;

    private String AKC021;

    private String AKC023;

    private String AKC024;

    private String AKC320;

    private String AKC321;

    private String AKC401;

    private String BAA001;

    private String BAA008;

    private String BAA009;

    private String BAA010;

    private String BAB706;

    private String BAC501;

    private String BAC502;

    private String BAC503;

    private String BAC504;

    private String BAC508;

    private String BAC510;

    private String BAC511;

    private String BAC515;

    private String BAC521;

    private String BAC801;

    private String BAC802;

    private String BAC803;

    private String BAC808;

    private String BAC809;

    private String BAD001;

    private String BAE601;

    private String BAE603;

    private String BAE608;

    private String BAE941;

    private String BIC701;

    private String BIC802;

    private String BKC280;

    private String BKC281;

    private String BKC288;

    private String BKC289;

    private String BKC290;

    private String BKC291;

    private String SAA015;

    private String SAA036;

    private String TAA101;

    private String TAA102;

    private String TAA103;

    private String TAA104;

    private String TAA105;

    private String TAE100;
    
    private String AAB003;
    
    private String REMARK;
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	public PM_AC01() {
		super();
	}

	public PM_AC01(String id){
		super(id);
	}

	public String getAAA040() {
		return AAA040;
	}

	public void setAAA040(String AAA040) {
		this.AAA040 = AAA040;
	}

	public String getAAB001() {
		return AAB001;
	}

	public void setAAB001(String AAB001) {
		this.AAB001 = AAB001;
	}

	public String getAAB004() {
		return AAB004;
	}

	public void setAAB004(String AAB004) {
		this.AAB004 = AAB004;
	}

	public String getAAC001() {
		return AAC001;
	}

	public void setAAC001(String AAC001) {
		this.AAC001 = AAC001;
	}

	public String getAAC002_1() {
		return AAC002_1;
	}

	public void setAAC002_1(String AAC002_1) {
		this.AAC002_1 = AAC002_1;
	}

	public String getAAC008() {
		return AAC008;
	}

	public void setAAC008(String AAC008) {
		this.AAC008 = AAC008;
	}

	public String getAAC030() {
		return AAC030;
	}

	public void setAAC030(String AAC030) {
		this.AAC030 = AAC030;
	}

	public String getAAC031() {
		return AAC031;
	}

	public void setAAC031(String AAC031) {
		this.AAC031 = AAC031;
	}

	public String getAAC040() {
		return AAC040;
	}

	public void setAAC040(String AAC040) {
		this.AAC040 = AAC040;
	}

	public String getAAC050() {
		return AAC050;
	}

	public void setAAC050(String AAC050) {
		this.AAC050 = AAC050;
	}

	public String getAAE002() {
		return AAE002;
	}

	public void setAAE002(String AAE002) {
		this.AAE002 = AAE002;
	}

	public String getAAE003() {
		return AAE003;
	}

	public void setAAE003(String AAE003) {
		this.AAE003 = AAE003;
	}

	public String getAAE008() {
		return AAE008;
	}

	public void setAAE008(String AAE008) {
		this.AAE008 = AAE008;
	}

	public String getAAE010() {
		return AAE010;
	}

	public void setAAE010(String AAE010) {
		this.AAE010 = AAE010;
	}

	public String getAAE030() {
		return AAE030;
	}

	public void setAAE030(String AAE030) {
		this.AAE030 = AAE030;
	}

	public String getAAE035() {
		return AAE035;
	}

	public void setAAE035(String AAE035) {
		this.AAE035 = AAE035;
	}

	public String getAAE100() {
		return AAE100;
	}

	public void setAAE100(String AAE100) {
		this.AAE100 = AAE100;
	}

	public String getAAE102() {
		return AAE102;
	}

	public void setAAE102(String AAE102) {
		this.AAE102 = AAE102;
	}

	public String getAAE140() {
		return AAE140;
	}

	public void setAAE140(String AAE140) {
		this.AAE140 = AAE140;
	}

	public String getAAE160() {
		return AAE160;
	}

	public void setAAE160(String AAE160) {
		this.AAE160 = AAE160;
	}

	public String getAIC162() {
		return AIC162;
	}

	public void setAIC162(String AIC162) {
		this.AIC162 = AIC162;
	}

	public String getAIC331() {
		return AIC331;
	}

	public void setAIC331(String AIC331) {
		this.AIC331 = AIC331;
	}

	public String getAKC020() {
		return AKC020;
	}

	public void setAKC020(String AKC020) {
		this.AKC020 = AKC020;
	}

	public String getAKC021() {
		return AKC021;
	}

	public void setAKC021(String AKC021) {
		this.AKC021 = AKC021;
	}

	public String getAKC023() {
		return AKC023;
	}

	public void setAKC023(String AKC023) {
		this.AKC023 = AKC023;
	}

	public String getAKC024() {
		return AKC024;
	}

	public void setAKC024(String AKC024) {
		this.AKC024 = AKC024;
	}

	public String getAKC320() {
		return AKC320;
	}

	public void setAKC320(String AKC320) {
		this.AKC320 = AKC320;
	}

	public String getAKC321() {
		return AKC321;
	}

	public void setAKC321(String AKC321) {
		this.AKC321 = AKC321;
	}

	public String getAKC401() {
		return AKC401;
	}

	public void setAKC401(String AKC401) {
		this.AKC401 = AKC401;
	}

	public String getBAB706() {
		return BAB706;
	}

	public void setBAB706(String BAB706) {
		this.BAB706 = BAB706;
	}

	public String getBAC504() {
		return BAC504;
	}

	public void setBAC504(String BAC504) {
		this.BAC504 = BAC504;
	}

	public String getBAC510() {
		return BAC510;
	}

	public void setBAC510(String BAC510) {
		this.BAC510 = BAC510;
	}

	public String getBAD001() {
		return BAD001;
	}

	public void setBAD001(String BAD001) {
		this.BAD001 = BAD001;
	}

	public String getBAE601() {
		return BAE601;
	}

	public void setBAE601(String BAE601) {
		this.BAE601 = BAE601;
	}

	public String getBAE603() {
		return BAE603;
	}

	public void setBAE603(String BAE603) {
		this.BAE603 = BAE603;
	}

	public String getBAE608() {
		return BAE608;
	}

	public void setBAE608(String BAE608) {
		this.BAE608 = BAE608;
	}

	public String getBAE941() {
		return BAE941;
	}

	public void setBAE941(String BAE941) {
		this.BAE941 = BAE941;
	}

	public String getBKC280() {
		return BKC280;
	}

	public void setBKC280(String BKC280) {
		this.BKC280 = BKC280;
	}

	public String getBKC281() {
		return BKC281;
	}

	public void setBKC281(String BKC281) {
		this.BKC281 = BKC281;
	}

	public String getBKC288() {
		return BKC288;
	}

	public void setBKC288(String BKC288) {
		this.BKC288 = BKC288;
	}

	public String getBKC289() {
		return BKC289;
	}

	public void setBKC289(String BKC289) {
		this.BKC289 = BKC289;
	}

	public String getBKC290() {
		return BKC290;
	}

	public void setBKC290(String BKC290) {
		this.BKC290 = BKC290;
	}

	public String getBKC291() {
		return BKC291;
	}

	public void setBKC291(String BKC291) {
		this.BKC291 = BKC291;
	}

	public String getSAA015() {
		return SAA015;
	}

	public void setSAA015(String SAA015) {
		this.SAA015 = SAA015;
	}

	public String getSAA036() {
		return SAA036;
	}

	public void setSAA036(String SAA036) {
		this.SAA036 = SAA036;
	}

	public String getTAA101() {
		return TAA101;
	}

	public void setTAA101(String TAA101) {
		this.TAA101 = TAA101;
	}

	public String getTAA102() {
		return TAA102;
	}

	public void setTAA102(String TAA102) {
		this.TAA102 = TAA102;
	}

	public String getTAA103() {
		return TAA103;
	}

	public void setTAA103(String TAA103) {
		this.TAA103 = TAA103;
	}

	public String getTAA104() {
		return TAA104;
	}

	public void setTAA104(String TAA104) {
		this.TAA104 = TAA104;
	}

	public String getTAA105() {
		return TAA105;
	}

	public void setTAA105(String TAA105) {
		this.TAA105 = TAA105;
	}

	@Length(min=1, max=10, message="数据分区编号长度必须介于 1 和 10 之间")
	public String getBAA001() {
		return BAA001;
	}

	public void setBAA001(String BAA001) {
		this.BAA001 = BAA001;
	}
	
	@Length(min=0, max=30, message="个人企业自编号长度必须介于 0 和 30 之间")
	public String getBAC808() {
		return BAC808;
	}

	public void setBAC808(String BAC808) {
		this.BAC808 = BAC808;
	}
	
	@Length(min=1, max=18, message="组织机构代码长度必须介于 1 和 18 之间")
	public String getAAB003() {
		return AAB003;
	}

	public void setAAB003(String AAB003) {
		this.AAB003 = AAB003;
	}
	
	@Length(min=1, max=18, message="公民身份号码长度必须介于 1 和 18 之间")
	public String getAAC002() {
		return AAC002;
	}

	public void setAAC002(String AAC002) {
		this.AAC002 = AAC002;
	}
	
	@Length(min=1, max=20, message="姓名长度必须介于 1 和 20 之间")
	public String getAAC003() {
		return AAC003;
	}

	public void setAAC003(String AAC003) {
		this.AAC003 = AAC003;
	}
	
	@Length(min=1, max=3, message="性别长度必须介于 1 和 3 之间")
	public String getAAC004() {
		return AAC004;
	}

	public void setAAC004(String AAC004) {
		this.AAC004 = AAC004;
	}
	
	@Length(min=1, max=3, message="民族长度必须介于 1 和 3 之间")
	public String getAAC005() {
		return AAC005;
	}

	public void setAAC005(String AAC005) {
		this.AAC005 = AAC005;
	}
	
	@Length(min=1, max=10, message="出生日期长度必须介于 1 和 10 之间")
	public String getAAC006() {
		return AAC006;
	}

	public void setAAC006(String AAC006) {
		this.AAC006 = AAC006;
	}
	
	@Length(min=0, max=10, message="档案出生日期长度必须介于 0 和 10 之间")
	public String getBIC701() {
		return BIC701;
	}

	public void setBIC701(String BIC701) {
		this.BIC701 = BIC701;
	}
	
	@Length(min=1, max=10, message="参加工作日期长度必须介于 1 和 10 之间")
	public String getAAC007() {
		return AAC007;
	}

	public void setAAC007(String AAC007) {
		this.AAC007 = AAC007;
	}
	
	@Length(min=0, max=100, message="地址长度必须介于 0 和 100 之间")
	public String getAAE006() {
		return AAE006;
	}

	public void setAAE006(String AAE006) {
		this.AAE006 = AAE006;
	}
	
	@Length(min=0, max=20, message="联系电话长度必须介于 0 和 20 之间")
	public String getAAE005() {
		return AAE005;
	}

	public void setAAE005(String AAE005) {
		this.AAE005 = AAE005;
	}
	
	@Length(min=0, max=6, message="邮政编码长度必须介于 0 和 6 之间")
	public String getAAE007() {
		return AAE007;
	}

	public void setAAE007(String AAE007) {
		this.AAE007 = AAE007;
	}
	
	@Length(min=1, max=3, message="户口性质长度必须介于 1 和 3 之间")
	public String getAAC009() {
		return AAC009;
	}

	public void setAAC009(String AAC009) {
		this.AAC009 = AAC009;
	}
	
	@Length(min=0, max=100, message="户口所在地长度必须介于 0 和 100 之间")
	public String getAAC010() {
		return AAC010;
	}

	public void setAAC010(String AAC010) {
		this.AAC010 = AAC010;
	}
	
	@Length(min=0, max=3, message="文化程度长度必须介于 0 和 3 之间")
	public String getAAC011() {
		return AAC011;
	}

	public void setAAC011(String AAC011) {
		this.AAC011 = AAC011;
	}
	
	@Length(min=1, max=3, message="个人身份长度必须介于 1 和 3 之间")
	public String getAAC012() {
		return AAC012;
	}

	public void setAAC012(String AAC012) {
		this.AAC012 = AAC012;
	}
	
	@Length(min=1, max=3, message="用工形式长度必须介于 1 和 3 之间")
	public String getAAC013() {
		return AAC013;
	}

	public void setAAC013(String AAC013) {
		this.AAC013 = AAC013;
	}
	
	@Length(min=1, max=3, message="专业技术职务长度必须介于 1 和 3 之间")
	public String getAAC014() {
		return AAC014;
	}

	public void setAAC014(String AAC014) {
		this.AAC014 = AAC014;
	}
	
	@Length(min=0, max=3, message="高级技术职务类型长度必须介于 0 和 3 之间")
	public String getBAC521() {
		return BAC521;
	}

	public void setBAC521(String BAC521) {
		this.BAC521 = BAC521;
	}
	
	@Length(min=1, max=3, message="工人技术等级长度必须介于 1 和 3 之间")
	public String getAAC015() {
		return AAC015;
	}

	public void setAAC015(String AAC015) {
		this.AAC015 = AAC015;
	}
	
	@Length(min=1, max=3, message="特殊工种标识长度必须介于 1 和 3 之间")
	public String getAAC019() {
		return AAC019;
	}

	public void setAAC019(String AAC019) {
		this.AAC019 = AAC019;
	}
	
	@Length(min=1, max=3, message="行政职务长度必须介于 1 和 3 之间")
	public String getAAC020() {
		return AAC020;
	}

	public void setAAC020(String AAC020) {
		this.AAC020 = AAC020;
	}
	
	@Length(min=1, max=10, message="经办人长度必须介于 1 和 10 之间")
	public String getAAE011() {
		return AAE011;
	}

	public void setAAE011(String AAE011) {
		this.AAE011 = AAE011;
	}
	
	@Length(min=1, max=19, message="经办时间长度必须介于 1 和 19 之间")
	public String getAAE036() {
		return AAE036;
	}

	public void setAAE036(String AAE036) {
		this.AAE036 = AAE036;
	}
	
	@Length(min=1, max=3, message="复核标志长度必须介于 1 和 3 之间")
	public String getBAA008() {
		return BAA008;
	}

	public void setBAA008(String BAA008) {
		this.BAA008 = BAA008;
	}
	
	@Length(min=0, max=10, message="复核人长度必须介于 0 和 10 之间")
	public String getBAA009() {
		return BAA009;
	}

	public void setBAA009(String BAA009) {
		this.BAA009 = BAA009;
	}
	
	@Length(min=0, max=19, message="复核时间长度必须介于 0 和 19 之间")
	public String getBAA010() {
		return BAA010;
	}

	public void setBAA010(String BAA010) {
		this.BAA010 = BAA010;
	}
	
	@Length(min=0, max=100, message="缴费开户银行行号长度必须介于 0 和 100 之间")
	public String getAAB024() {
		return AAB024;
	}

	public void setAAB024(String AAB024) {
		this.AAB024 = AAB024;
	}
	
	@Length(min=0, max=100, message="缴费银行户名长度必须介于 0 和 100 之间")
	public String getAAB025() {
		return AAB025;
	}

	public void setAAB025(String AAB025) {
		this.AAB025 = AAB025;
	}
	
	@Length(min=0, max=40, message="缴费银行基本帐号长度必须介于 0 和 40 之间")
	public String getAAB026() {
		return AAB026;
	}

	public void setAAB026(String AAB026) {
		this.AAB026 = AAB026;
	}
	
	@Length(min=0, max=3, message="婚姻状况长度必须介于 0 和 3 之间")
	public String getAAC017() {
		return AAC017;
	}

	public void setAAC017(String AAC017) {
		this.AAC017 = AAC017;
	}
	
	@Length(min=0, max=3, message="劳模等级长度必须介于 0 和 3 之间")
	public String getBAC503() {
		return BAC503;
	}

	public void setBAC503(String BAC503) {
		this.BAC503 = BAC503;
	}
	
	@Length(min=0, max=3, message="公务员类别长度必须介于 0 和 3 之间")
	public String getBAC515() {
		return BAC515;
	}

	public void setBAC515(String BAC515) {
		this.BAC515 = BAC515;
	}
	
	@Length(min=0, max=3, message="是否独生子女长度必须介于 0 和 3 之间")
	public String getBAC508() {
		return BAC508;
	}

	public void setBAC508(String BAC508) {
		this.BAC508 = BAC508;
	}
	
	@Length(min=0, max=3, message="个人荣誉标志长度必须介于 0 和 3 之间")
	public String getBAC801() {
		return BAC801;
	}

	public void setBAC801(String BAC801) {
		this.BAC801 = BAC801;
	}
	
	@Length(min=0, max=3, message="艰苦地区长度必须介于 0 和 3 之间")
	public String getBAC802() {
		return BAC802;
	}

	public void setBAC802(String BAC802) {
		this.BAC802 = BAC802;
	}
	
	@Length(min=0, max=3, message="是否曾在部队服役长度必须介于 0 和 3 之间")
	public String getBAC803() {
		return BAC803;
	}

	public void setBAC803(String BAC803) {
		this.BAC803 = BAC803;
	}
	
	@Length(min=0, max=10, message="建帐日期长度必须介于 0 和 10 之间")
	public String getBIC802() {
		return BIC802;
	}

	public void setBIC802(String BIC802) {
		this.BIC802 = BIC802;
	}
	
	@Length(min=0, max=8, message="分支机构代码长度必须介于 0 和 8 之间")
	public String getAAB060() {
		return AAB060;
	}

	public void setAAB060(String AAB060) {
		this.AAB060 = AAB060;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getAAE013() {
		return AAE013;
	}

	public void setAAE013(String AAE013) {
		this.AAE013 = AAE013;
	}
	
	@Length(min=0, max=32, message="邮件地址长度必须介于 0 和 32 之间")
	public String getBAC501() {
		return BAC501;
	}

	public void setBAC501(String BAC501) {
		this.BAC501 = BAC501;
	}
	
	@Length(min=0, max=100, message="公务员批准文号长度必须介于 0 和 100 之间")
	public String getBAC502() {
		return BAC502;
	}

	public void setBAC502(String BAC502) {
		this.BAC502 = BAC502;
	}
	
	@Length(min=0, max=10, message="首次缴费时间长度必须介于 0 和 10 之间")
	public String getBAC511() {
		return BAC511;
	}

	public void setBAC511(String BAC511) {
		this.BAC511 = BAC511;
	}
	
	@Length(min=0, max=20, message="旧系统个人编号长度必须介于 0 和 20 之间")
	public String getBAC809() {
		return BAC809;
	}

	public void setBAC809(String BAC809) {
		this.BAC809 = BAC809;
	}
	
	@Length(min=0, max=10, message="社会保险经办机构编码长度必须介于 0 和 10 之间")
	public String getAAB034() {
		return AAB034;
	}

	public void setAAB034(String AAB034) {
		this.AAB034 = AAB034;
	}
	
	@Length(min=0, max=3, message="证件类型长度必须介于 0 和 3 之间")
	public String getAAC058() {
		return AAC058;
	}

	public void setAAC058(String AAC058) {
		this.AAC058 = AAC058;
	}
	
	@Length(min=0, max=20, message="工种/身份认定信息长度必须介于 0 和 20 之间")
	public String getAAC121() {
		return AAC121;
	}

	public void setAAC121(String AAC121) {
		this.AAC121 = AAC121;
	}
	
	@Length(min=0, max=20, message="工作车间长度必须介于 0 和 20 之间")
	public String getAAC122() {
		return AAC122;
	}

	public void setAAC122(String AAC122) {
		this.AAC122 = AAC122;
	}
	
	@Length(min=0, max=3, message="工伤标志长度必须介于 0 和 3 之间")
	public String getTAE100() {
		return TAE100;
	}

	public void setTAE100(String TAE100) {
		this.TAE100 = TAE100;
	}
	
}