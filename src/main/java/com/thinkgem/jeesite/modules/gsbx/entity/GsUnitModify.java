package com.thinkgem.jeesite.modules.gsbx.entity;


import java.io.Serializable;

/**
 * 描述:
 * 单位基本信息实体类
 *
 * @author X_P
 * @create 2018-06-07 10:22
 */
public class GsUnitModify implements Serializable{

    private static final long serialVersionUID = 8042627403543600771L;
    private String AAB001;	//单位编号	否
    private String BAA001;	//数据分区编号	否
    private String BAB801;	//单位内码	是
    private String BAB802;	//单位助记码	是
    private String BAB808;	//单位企业自编号	否
    private String AAB002;	//社会保险登记证编码	否
    private String AAB003;	//组织机构代码	否
    private String AAB004;	//单位名称	否
    private String AAB005;	//单位电话	是
    private String AAB006;	//工商登记执照种类	否
    private String AAB007;	//工商登记执照号码	否
    private String AAB008;	//工商登记发照日期	否
    private String AAB009;	//工商登记有效期限	否
    private String AAB010;	//批准成立单位	否
    private String AAB011;	//批准日期	否
    private String AAB012;	//批准文号	否
    private String AAB013;	//法定代表人姓名	否
    private String AAB014;	//法定代表人公民身份号码	否
    private String AAB015;	//法定代表人电话	否
    private String AAB016;	//缴费单位专管员姓名	是
    private String AAB017;	//缴费单位专管员所在部门	是
    private String AAB018;	//缴费单位专管员电话	是
    private String AAB019;	//单位类型	否
    private String AAB020;	//经济类型	否
    private String AAB021;	//隶属关系	否
    private String AAB022;	//行业代码	否
    private String BAB519;	//行业企业代码	否
    private String AAB023;	//主管部门或总机构	是
    private String BAB502;	//缴费银行类别	是
    private String AAB024;	//缴费开户银行行号	是
    private String AAB025;	//缴费银行户名	是
    private String AAB026;	//缴费银行基本帐号	是
    private String BAB503;	//支付银行类别	否
    private String AAB027;	//支付开户银行行号	否
    private String AAB028;	//支付银行户名	否
    private String AAB029;	//支付银行基本帐号	否
    private String AAB030;	//税号	否
    private String AAB031;	//税务机构编号	否
    private String AAB032;	//税务机构名称	否
    private String AAB033;	//缴费方式	否
    private String AAB034;	//社会保险经办机构编码	否
    private String AAB035;	//登记机构	否
    private String AAB036;	//登记证发证日期	否
    private String AAE119;	//单位状态	否
    private String BAB512;	//传真	是
    private String BAB513;	//单位网址	是
    private String BAB514;	//公务员批准文号	否
    private String BAB515;	//工伤标准	否
    private String BAB516;	//大额代扣标志	否
    private String BAB803;	//立户时在职人数	否
    private String BAB804;	//立户时退休人数	否
    private String BAB805;	//立户时月缴费基数	否
    private String BAB806;	//立户时月退休费用	否
    private String BAB807;	//参保原因	否
    private String AAE013;	//备注	是
    private String BAA008;	//复核标志	否
    private String BAA009;	//复核人	否
    private String BAA010;	//复核时间	否
    private String AAE011;	//经办人	否
    private String AAE036;	//经办时间	否
    private String AAE006;	//地址	是
    private String AAE007;	//邮政编码	是
    private String BAB506;	//法人代码证	否
    private String BAB810;	//单位性质	否
    private String BAB811;	//单位离退休人员低保所在地	否
    private String BAB812;	//煤炭企业年设计产量(万吨) 	否
    private String AAA149;	//行业分险类别	否
    private String AAE141;	//是否参加补充工伤	否



    @Override
    public String toString() {
        return "GsUnitModify{" +
                "AAB001='" + AAB001 + '\'' +
                ", BAA001='" + BAA001 + '\'' +
                ", BAB801='" + BAB801 + '\'' +
                ", BAB802='" + BAB802 + '\'' +
                ", BAB808='" + BAB808 + '\'' +
                ", AAB002='" + AAB002 + '\'' +
                ", AAB003='" + AAB003 + '\'' +
                ", AAB004='" + AAB004 + '\'' +
                ", AAB005='" + AAB005 + '\'' +
                ", AAB006='" + AAB006 + '\'' +
                ", AAB007='" + AAB007 + '\'' +
                ", AAB008='" + AAB008 + '\'' +
                ", AAB009='" + AAB009 + '\'' +
                ", AAB010='" + AAB010 + '\'' +
                ", AAB011='" + AAB011 + '\'' +
                ", AAB012='" + AAB012 + '\'' +
                ", AAB013='" + AAB013 + '\'' +
                ", AAB014='" + AAB014 + '\'' +
                ", AAB015='" + AAB015 + '\'' +
                ", AAB016='" + AAB016 + '\'' +
                ", AAB017='" + AAB017 + '\'' +
                ", AAB018='" + AAB018 + '\'' +
                ", AAB019='" + AAB019 + '\'' +
                ", AAB020='" + AAB020 + '\'' +
                ", AAB021='" + AAB021 + '\'' +
                ", AAB022='" + AAB022 + '\'' +
                ", BAB519='" + BAB519 + '\'' +
                ", AAB023='" + AAB023 + '\'' +
                ", BAB502='" + BAB502 + '\'' +
                ", AAB024='" + AAB024 + '\'' +
                ", AAB025='" + AAB025 + '\'' +
                ", AAB026='" + AAB026 + '\'' +
                ", BAB503='" + BAB503 + '\'' +
                ", AAB027='" + AAB027 + '\'' +
                ", AAB028='" + AAB028 + '\'' +
                ", AAB029='" + AAB029 + '\'' +
                ", AAB030='" + AAB030 + '\'' +
                ", AAB031='" + AAB031 + '\'' +
                ", AAB032='" + AAB032 + '\'' +
                ", AAB033='" + AAB033 + '\'' +
                ", AAB034='" + AAB034 + '\'' +
                ", AAB035='" + AAB035 + '\'' +
                ", AAB036='" + AAB036 + '\'' +
                ", AAE119='" + AAE119 + '\'' +
                ", BAB512='" + BAB512 + '\'' +
                ", BAB513='" + BAB513 + '\'' +
                ", BAB514='" + BAB514 + '\'' +
                ", BAB515='" + BAB515 + '\'' +
                ", BAB516='" + BAB516 + '\'' +
                ", BAB803='" + BAB803 + '\'' +
                ", BAB804='" + BAB804 + '\'' +
                ", BAB805='" + BAB805 + '\'' +
                ", BAB806='" + BAB806 + '\'' +
                ", BAB807='" + BAB807 + '\'' +
                ", AAE013='" + AAE013 + '\'' +
                ", BAA008='" + BAA008 + '\'' +
                ", BAA009='" + BAA009 + '\'' +
                ", BAA010='" + BAA010 + '\'' +
                ", AAE011='" + AAE011 + '\'' +
                ", AAE036='" + AAE036 + '\'' +
                ", AAE006='" + AAE006 + '\'' +
                ", AAE007='" + AAE007 + '\'' +
                ", BAB506='" + BAB506 + '\'' +
                ", BAB810='" + BAB810 + '\'' +
                ", BAB811='" + BAB811 + '\'' +
                ", BAB812='" + BAB812 + '\'' +
                ", AAA149='" + AAA149 + '\'' +
                ", AAE141='" + AAE141 + '\'' +
                '}';
    }

    public String getAAB001() {
        return AAB001;
    }

    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }

    public String getBAA001() {
        return BAA001;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public String getBAB801() {
        return BAB801;
    }

    public void setBAB801(String BAB801) {
        this.BAB801 = BAB801;
    }

    public String getBAB802() {
        return BAB802;
    }

    public void setBAB802(String BAB802) {
        this.BAB802 = BAB802;
    }

    public String getBAB808() {
        return BAB808;
    }

    public void setBAB808(String BAB808) {
        this.BAB808 = BAB808;
    }

    public String getAAB002() {
        return AAB002;
    }

    public void setAAB002(String AAB002) {
        this.AAB002 = AAB002;
    }

    public String getAAB003() {
        return AAB003;
    }

    public void setAAB003(String AAB003) {
        this.AAB003 = AAB003;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getAAB005() {
        return AAB005;
    }

    public void setAAB005(String AAB005) {
        this.AAB005 = AAB005;
    }

    public String getAAB006() {
        return AAB006;
    }

    public void setAAB006(String AAB006) {
        this.AAB006 = AAB006;
    }

    public String getAAB007() {
        return AAB007;
    }

    public void setAAB007(String AAB007) {
        this.AAB007 = AAB007;
    }

    public String getAAB008() {
        return AAB008;
    }

    public void setAAB008(String AAB008) {
        this.AAB008 = AAB008;
    }

    public String getAAB009() {
        return AAB009;
    }

    public void setAAB009(String AAB009) {
        this.AAB009 = AAB009;
    }

    public String getAAB010() {
        return AAB010;
    }

    public void setAAB010(String AAB010) {
        this.AAB010 = AAB010;
    }

    public String getAAB011() {
        return AAB011;
    }

    public void setAAB011(String AAB011) {
        this.AAB011 = AAB011;
    }

    public String getAAB012() {
        return AAB012;
    }

    public void setAAB012(String AAB012) {
        this.AAB012 = AAB012;
    }

    public String getAAB013() {
        return AAB013;
    }

    public void setAAB013(String AAB013) {
        this.AAB013 = AAB013;
    }

    public String getAAB014() {
        return AAB014;
    }

    public void setAAB014(String AAB014) {
        this.AAB014 = AAB014;
    }

    public String getAAB015() {
        return AAB015;
    }

    public void setAAB015(String AAB015) {
        this.AAB015 = AAB015;
    }

    public String getAAB016() {
        return AAB016;
    }

    public void setAAB016(String AAB016) {
        this.AAB016 = AAB016;
    }

    public String getAAB017() {
        return AAB017;
    }

    public void setAAB017(String AAB017) {
        this.AAB017 = AAB017;
    }

    public String getAAB018() {
        return AAB018;
    }

    public void setAAB018(String AAB018) {
        this.AAB018 = AAB018;
    }

    public String getAAB019() {
        return AAB019;
    }

    public void setAAB019(String AAB019) {
        this.AAB019 = AAB019;
    }

    public String getAAB020() {
        return AAB020;
    }

    public void setAAB020(String AAB020) {
        this.AAB020 = AAB020;
    }

    public String getAAB021() {
        return AAB021;
    }

    public void setAAB021(String AAB021) {
        this.AAB021 = AAB021;
    }

    public String getAAB022() {
        return AAB022;
    }

    public void setAAB022(String AAB022) {
        this.AAB022 = AAB022;
    }

    public String getBAB519() {
        return BAB519;
    }

    public void setBAB519(String BAB519) {
        this.BAB519 = BAB519;
    }

    public String getAAB023() {
        return AAB023;
    }

    public void setAAB023(String AAB023) {
        this.AAB023 = AAB023;
    }

    public String getBAB502() {
        return BAB502;
    }

    public void setBAB502(String BAB502) {
        this.BAB502 = BAB502;
    }

    public String getAAB024() {
        return AAB024;
    }

    public void setAAB024(String AAB024) {
        this.AAB024 = AAB024;
    }

    public String getAAB025() {
        return AAB025;
    }

    public void setAAB025(String AAB025) {
        this.AAB025 = AAB025;
    }

    public String getAAB026() {
        return AAB026;
    }

    public void setAAB026(String AAB026) {
        this.AAB026 = AAB026;
    }

    public String getBAB503() {
        return BAB503;
    }

    public void setBAB503(String BAB503) {
        this.BAB503 = BAB503;
    }

    public String getAAB027() {
        return AAB027;
    }

    public void setAAB027(String AAB027) {
        this.AAB027 = AAB027;
    }

    public String getAAB028() {
        return AAB028;
    }

    public void setAAB028(String AAB028) {
        this.AAB028 = AAB028;
    }

    public String getAAB029() {
        return AAB029;
    }

    public void setAAB029(String AAB029) {
        this.AAB029 = AAB029;
    }

    public String getAAB030() {
        return AAB030;
    }

    public void setAAB030(String AAB030) {
        this.AAB030 = AAB030;
    }

    public String getAAB031() {
        return AAB031;
    }

    public void setAAB031(String AAB031) {
        this.AAB031 = AAB031;
    }

    public String getAAB032() {
        return AAB032;
    }

    public void setAAB032(String AAB032) {
        this.AAB032 = AAB032;
    }

    public String getAAB033() {
        return AAB033;
    }

    public void setAAB033(String AAB033) {
        this.AAB033 = AAB033;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getAAB035() {
        return AAB035;
    }

    public void setAAB035(String AAB035) {
        this.AAB035 = AAB035;
    }

    public String getAAB036() {
        return AAB036;
    }

    public void setAAB036(String AAB036) {
        this.AAB036 = AAB036;
    }

    public String getAAE119() {
        return AAE119;
    }

    public void setAAE119(String AAE119) {
        this.AAE119 = AAE119;
    }

    public String getBAB512() {
        return BAB512;
    }

    public void setBAB512(String BAB512) {
        this.BAB512 = BAB512;
    }

    public String getBAB513() {
        return BAB513;
    }

    public void setBAB513(String BAB513) {
        this.BAB513 = BAB513;
    }

    public String getBAB514() {
        return BAB514;
    }

    public void setBAB514(String BAB514) {
        this.BAB514 = BAB514;
    }

    public String getBAB515() {
        return BAB515;
    }

    public void setBAB515(String BAB515) {
        this.BAB515 = BAB515;
    }

    public String getBAB516() {
        return BAB516;
    }

    public void setBAB516(String BAB516) {
        this.BAB516 = BAB516;
    }

    public String getBAB803() {
        return BAB803;
    }

    public void setBAB803(String BAB803) {
        this.BAB803 = BAB803;
    }

    public String getBAB804() {
        return BAB804;
    }

    public void setBAB804(String BAB804) {
        this.BAB804 = BAB804;
    }

    public String getBAB805() {
        return BAB805;
    }

    public void setBAB805(String BAB805) {
        this.BAB805 = BAB805;
    }

    public String getBAB806() {
        return BAB806;
    }

    public void setBAB806(String BAB806) {
        this.BAB806 = BAB806;
    }

    public String getBAB807() {
        return BAB807;
    }

    public void setBAB807(String BAB807) {
        this.BAB807 = BAB807;
    }

    public String getAAE013() {
        return AAE013;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }

    public String getBAA008() {
        return BAA008;
    }

    public void setBAA008(String BAA008) {
        this.BAA008 = BAA008;
    }

    public String getBAA009() {
        return BAA009;
    }

    public void setBAA009(String BAA009) {
        this.BAA009 = BAA009;
    }

    public String getBAA010() {
        return BAA010;
    }

    public void setBAA010(String BAA010) {
        this.BAA010 = BAA010;
    }

    public String getAAE011() {
        return AAE011;
    }

    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    public String getAAE036() {
        return AAE036;
    }

    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
    }

    public String getAAE006() {
        return AAE006;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public String getAAE007() {
        return AAE007;
    }

    public void setAAE007(String AAE007) {
        this.AAE007 = AAE007;
    }

    public String getBAB506() {
        return BAB506;
    }

    public void setBAB506(String BAB506) {
        this.BAB506 = BAB506;
    }

    public String getBAB810() {
        return BAB810;
    }

    public void setBAB810(String BAB810) {
        this.BAB810 = BAB810;
    }

    public String getBAB811() {
        return BAB811;
    }

    public void setBAB811(String BAB811) {
        this.BAB811 = BAB811;
    }

    public String getBAB812() {
        return BAB812;
    }

    public void setBAB812(String BAB812) {
        this.BAB812 = BAB812;
    }

    public String getAAA149() {
        return AAA149;
    }

    public void setAAA149(String AAA149) {
        this.AAA149 = AAA149;
    }

    public String getAAE141() {
        return AAE141;
    }

    public void setAAE141(String AAE141) {
        this.AAE141 = AAE141;
    }
}