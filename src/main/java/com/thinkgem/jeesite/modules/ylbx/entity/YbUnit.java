package com.thinkgem.jeesite.modules.ylbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 医疗保险单位信息
 * 实体类
 * @author sl_su
 */
public class YbUnit implements Serializable {

    private static final long serialVersionUID = -1617225087402893723L;

    private String AAB001; //	单位编号
    private String BAA001; //	数据分区
    private String BAB801; //	单位内码
    private String AAB002; //	社保登记编码
    private String AAB004; //	单位名称
    private String AAB006; //	工商执照种类
    private String AAB008; //	工商发照日期
    private String AAB010; //	批准成立单位
    private String AAB012; //	批准文号
    private String AAB014; //	法人身份证号
    private String AAB016; //	缴费单位专管员姓名
    private String AAB018; //	缴费单位专管员电话
    private String AAB020; //	经济类型
    private String AAB022; //	行业代码
    private String AAB023; //	主管部门或总机构
    private String AAB024; //	缴费开户银行行号
    private String AAB026; //	缴费银行基本账号
    private String AAB027; //	支付开户银行行号
    private String AAB029; //	支付银行基本账号
    private String AAB031; //	税务机构编号
    private String AAB033; //	缴费方式
    private String AAB035; //	登记机构
    private String AAE119; //	单位状态
    private String BAB513; //	单位网址
    private String BAB515; //	工伤标准
    private String BAB803; //	立户时在职人数
    private String BAB805; //	立户时月缴费基数
    private String BAB807; //	参保原因
    private String BAA008; //	复核标志
    private String BAA010; //	复核时间
    private String AAE036; //	经办时间
    private String AAE007; //	邮政编码
    private String BAB811; //	统筹类别
    private String AAB100; //	三证合一代码
    private String BAB802; //	单位助记码
    private String AAB003; //	组织机构代码
    private String AAB005; //	单位电话
    private String AAB007; //	工商执照号码
    private String AAB009; //	工商登记期限
    private String AAB011; //	批准日期
    private String AAB013; //	法人姓名
    private String AAB015; //	法人电话
    private String AAB017; //	缴费单位专管员部门
    private String AAB019; //	单位类型
    private String AAB021; //	隶属关系
    private String BAB519; //	行业企业代码
    private String BAB502; //	缴费银行类别
    private String AAB025; //	缴费银行户名
    private String BAB503; //	支付银行类别
    private String AAB028; //	支付银行户名
    private String AAB030; //	税号
    private String AAB032; //	税务机构名称
    private String AAB034; //	社保经办机构编码
    private String AAB036; //	登记证发证日期
    private String BAB512; //	传真
    private String BAB514; //	公务员批准文号
    private String BAB516; //	大额代扣标志
    private String BAB804; //	立户时退休人数
    private String BAB806; //	立户时月退休费用
    private String AAE013; //	备注
    private String BAA009; //	复核人
    private String AAE011; //	经办人
    private String AAE006; //	地址
    private String BAB506; //	法人代码证
    private String AAC058; //	证件类型
    private String AAE140; //	险种类型
    private String AAB050; //	参保日期
    private String BAB510; //	最近参保时间
    private String BAB501; //	双基数标志
    private String AAB051; //	参保状态
    private String AAA040; //	缴费比例类别
    private String BAB808; //	单位企业自编号
    private String StartYM; //	开始费款所属期
    private String EndYM; //	截止费款所属期
    private String AAE143; //	缴费类型
    private String BAA005; //	审核编号
    private String AAE003; //	对应费款所属期
    private String BAB706; //	应收核定类别
    private String AAB082; //	离退休人次
    private String AAB121; //	单位缴费基数总额
    private String BAC701; //	个人应缴划统筹金额
    private String BAC703; //	个人应补账户利息
    private String BAB701; //	本期单位缴费金额
    private String AAB124; //	单位缴费划统筹金额
    private String BAB703; //	单位缴费划统筹利息
    private String BAC706; //	核销个人应缴划统筹金额
    private String AAD004; //	核销单位欠缴统筹金额
    private String BAC708; //	本期个人账户做实金额
    private String BAC710; //	核销离退休人数
    private String BAC712; //	征集时个人应补统筹利息
    private String BAB705; //	征集时单位划统筹利息
    private String BAE741; //	审核时滞纳金计算截止日期
    private String BAE743; //	审核时减免滞纳金金额
    private String BAE749; //	征集时滞纳金金额
    private String BAE746; //	补息标志
    private String BAE748; //	核销小计
    private String AAE063; //	征集通知流水号
    private String BAE703; //	主体编号
    private String AAE002; //	费款所属期
    private String BAE702; //	主体类型
    private String AAB083; //	在职职工人次
    private String AAB120; //	个人缴费基数总额
    private String AAB122; //	本期个人应缴金额
    private String BAC702; //	个人应缴划账户金额
    private String BAC704; //	个人应补统筹利息
    private String AAB123; //	单位缴费划账户金额
    private String BAB702; //	单位缴费划账户应补利息
    private String BAC705; //	核销个人应缴划账户金额
    private String AAD003; //	核销单位欠缴划账户金额
    private String BAC707; //	核销个人账户做实金额
    private String BAC709; //	核销在职人数
    private String BAC711; //	征集时个人应补账户利息
    private String BAB704; //	征集时单位划个人账户部分应补利息
    private String BAE740; //	审核时利息计算截止月份
    private String BAE742; //	审核时应缴滞纳金金额
    private String BAE744; //	征集时滞纳金计算截止日期
    private String BAE745; //	征集时减免滞纳金金额
    private String BAE747; //	滞纳金征收标志
    private String AAB137; //	应缴合计
    private String BAE750; //	缓交截止日期
    private String BAE707; //	基金配置流水号

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

    public String getAAB002() {
        return AAB002;
    }

    public void setAAB002(String AAB002) {
        this.AAB002 = AAB002;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getAAB006() {
        return AAB006;
    }

    public void setAAB006(String AAB006) {
        this.AAB006 = AAB006;
    }

    public String getAAB008() {
        return AAB008;
    }

    public void setAAB008(String AAB008) {
        this.AAB008 = AAB008;
    }

    public String getAAB010() {
        return AAB010;
    }

    public void setAAB010(String AAB010) {
        this.AAB010 = AAB010;
    }

    public String getAAB012() {
        return AAB012;
    }

    public void setAAB012(String AAB012) {
        this.AAB012 = AAB012;
    }

    public String getAAB014() {
        return AAB014;
    }

    public void setAAB014(String AAB014) {
        this.AAB014 = AAB014;
    }

    public String getAAB016() {
        return AAB016;
    }

    public void setAAB016(String AAB016) {
        this.AAB016 = AAB016;
    }

    public String getAAB018() {
        return AAB018;
    }

    public void setAAB018(String AAB018) {
        this.AAB018 = AAB018;
    }

    public String getAAB020() {
        return AAB020;
    }

    public void setAAB020(String AAB020) {
        this.AAB020 = AAB020;
    }

    public String getAAB022() {
        return AAB022;
    }

    public void setAAB022(String AAB022) {
        this.AAB022 = AAB022;
    }

    public String getAAB023() {
        return AAB023;
    }

    public void setAAB023(String AAB023) {
        this.AAB023 = AAB023;
    }

    public String getAAB024() {
        return AAB024;
    }

    public void setAAB024(String AAB024) {
        this.AAB024 = AAB024;
    }

    public String getAAB026() {
        return AAB026;
    }

    public void setAAB026(String AAB026) {
        this.AAB026 = AAB026;
    }

    public String getAAB027() {
        return AAB027;
    }

    public void setAAB027(String AAB027) {
        this.AAB027 = AAB027;
    }

    public String getAAB029() {
        return AAB029;
    }

    public void setAAB029(String AAB029) {
        this.AAB029 = AAB029;
    }

    public String getAAB031() {
        return AAB031;
    }

    public void setAAB031(String AAB031) {
        this.AAB031 = AAB031;
    }

    public String getAAB033() {
        return AAB033;
    }

    public void setAAB033(String AAB033) {
        this.AAB033 = AAB033;
    }

    public String getAAB035() {
        return AAB035;
    }

    public void setAAB035(String AAB035) {
        this.AAB035 = AAB035;
    }

    public String getAAE119() {
        return AAE119;
    }

    public void setAAE119(String AAE119) {
        this.AAE119 = AAE119;
    }

    public String getBAB513() {
        return BAB513;
    }

    public void setBAB513(String BAB513) {
        this.BAB513 = BAB513;
    }

    public String getBAB515() {
        return BAB515;
    }

    public void setBAB515(String BAB515) {
        this.BAB515 = BAB515;
    }

    public String getBAB803() {
        return BAB803;
    }

    public void setBAB803(String BAB803) {
        this.BAB803 = BAB803;
    }

    public String getBAB805() {
        return BAB805;
    }

    public void setBAB805(String BAB805) {
        this.BAB805 = BAB805;
    }

    public String getBAB807() {
        return BAB807;
    }

    public void setBAB807(String BAB807) {
        this.BAB807 = BAB807;
    }

    public String getBAA008() {
        return BAA008;
    }

    public void setBAA008(String BAA008) {
        this.BAA008 = BAA008;
    }

    public String getBAA010() {
        return BAA010;
    }

    public void setBAA010(String BAA010) {
        this.BAA010 = BAA010;
    }

    public String getAAE036() {
        return AAE036;
    }

    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
    }

    public String getAAE007() {
        return AAE007;
    }

    public void setAAE007(String AAE007) {
        this.AAE007 = AAE007;
    }

    public String getBAB811() {
        return BAB811;
    }

    public void setBAB811(String BAB811) {
        this.BAB811 = BAB811;
    }

    public String getAAB100() {
        return AAB100;
    }

    public void setAAB100(String AAB100) {
        this.AAB100 = AAB100;
    }

    public String getBAB802() {
        return BAB802;
    }

    public void setBAB802(String BAB802) {
        this.BAB802 = BAB802;
    }

    public String getAAB003() {
        return AAB003;
    }

    public void setAAB003(String AAB003) {
        this.AAB003 = AAB003;
    }

    public String getAAB005() {
        return AAB005;
    }

    public void setAAB005(String AAB005) {
        this.AAB005 = AAB005;
    }

    public String getAAB007() {
        return AAB007;
    }

    public void setAAB007(String AAB007) {
        this.AAB007 = AAB007;
    }

    public String getAAB009() {
        return AAB009;
    }

    public void setAAB009(String AAB009) {
        this.AAB009 = AAB009;
    }

    public String getAAB011() {
        return AAB011;
    }

    public void setAAB011(String AAB011) {
        this.AAB011 = AAB011;
    }

    public String getAAB013() {
        return AAB013;
    }

    public void setAAB013(String AAB013) {
        this.AAB013 = AAB013;
    }

    public String getAAB015() {
        return AAB015;
    }

    public void setAAB015(String AAB015) {
        this.AAB015 = AAB015;
    }

    public String getAAB017() {
        return AAB017;
    }

    public void setAAB017(String AAB017) {
        this.AAB017 = AAB017;
    }

    public String getAAB019() {
        return AAB019;
    }

    public void setAAB019(String AAB019) {
        this.AAB019 = AAB019;
    }

    public String getAAB021() {
        return AAB021;
    }

    public void setAAB021(String AAB021) {
        this.AAB021 = AAB021;
    }

    public String getBAB519() {
        return BAB519;
    }

    public void setBAB519(String BAB519) {
        this.BAB519 = BAB519;
    }

    public String getBAB502() {
        return BAB502;
    }

    public void setBAB502(String BAB502) {
        this.BAB502 = BAB502;
    }

    public String getAAB025() {
        return AAB025;
    }

    public void setAAB025(String AAB025) {
        this.AAB025 = AAB025;
    }

    public String getBAB503() {
        return BAB503;
    }

    public void setBAB503(String BAB503) {
        this.BAB503 = BAB503;
    }

    public String getAAB028() {
        return AAB028;
    }

    public void setAAB028(String AAB028) {
        this.AAB028 = AAB028;
    }

    public String getAAB030() {
        return AAB030;
    }

    public void setAAB030(String AAB030) {
        this.AAB030 = AAB030;
    }

    public String getAAB032() {
        return AAB032;
    }

    public void setAAB032(String AAB032) {
        this.AAB032 = AAB032;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getAAB036() {
        return AAB036;
    }

    public void setAAB036(String AAB036) {
        this.AAB036 = AAB036;
    }

    public String getBAB512() {
        return BAB512;
    }

    public void setBAB512(String BAB512) {
        this.BAB512 = BAB512;
    }

    public String getBAB514() {
        return BAB514;
    }

    public void setBAB514(String BAB514) {
        this.BAB514 = BAB514;
    }

    public String getBAB516() {
        return BAB516;
    }

    public void setBAB516(String BAB516) {
        this.BAB516 = BAB516;
    }

    public String getBAB804() {
        return BAB804;
    }

    public void setBAB804(String BAB804) {
        this.BAB804 = BAB804;
    }

    public String getBAB806() {
        return BAB806;
    }

    public void setBAB806(String BAB806) {
        this.BAB806 = BAB806;
    }

    public String getAAE013() {
        return AAE013;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }

    public String getBAA009() {
        return BAA009;
    }

    public void setBAA009(String BAA009) {
        this.BAA009 = BAA009;
    }

    public String getAAE011() {
        return AAE011;
    }

    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    public String getAAE006() {
        return AAE006;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public String getBAB506() {
        return BAB506;
    }

    public void setBAB506(String BAB506) {
        this.BAB506 = BAB506;
    }

    public String getAAC058() {
        return AAC058;
    }

    public void setAAC058(String AAC058) {
        this.AAC058 = AAC058;
    }

    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }

    public String getAAB050() {
        return AAB050;
    }

    public void setAAB050(String AAB050) {
        this.AAB050 = AAB050;
    }

    public String getBAB510() {
        return BAB510;
    }

    public void setBAB510(String BAB510) {
        this.BAB510 = BAB510;
    }

    public String getBAB501() {
        return BAB501;
    }

    public void setBAB501(String BAB501) {
        this.BAB501 = BAB501;
    }

    public String getAAB051() {
        return AAB051;
    }

    public void setAAB051(String AAB051) {
        this.AAB051 = AAB051;
    }

    public String getAAA040() {
        return AAA040;
    }

    public void setAAA040(String AAA040) {
        this.AAA040 = AAA040;
    }

    public String getBAB808() {
        return BAB808;
    }

    public void setBAB808(String BAB808) {
        this.BAB808 = BAB808;
    }

    public String getStartYM() {
        return StartYM;
    }

    public void setStartYM(String startYM) {
        StartYM = startYM;
    }

    public String getEndYM() {
        return EndYM;
    }

    public void setEndYM(String endYM) {
        EndYM = endYM;
    }

    public String getAAE143() {
        return AAE143;
    }

    public void setAAE143(String AAE143) {
        this.AAE143 = AAE143;
    }

    public String getBAA005() {
        return BAA005;
    }

    public void setBAA005(String BAA005) {
        this.BAA005 = BAA005;
    }

    public String getAAE003() {
        return AAE003;
    }

    public void setAAE003(String AAE003) {
        this.AAE003 = AAE003;
    }

    public String getBAB706() {
        return BAB706;
    }

    public void setBAB706(String BAB706) {
        this.BAB706 = BAB706;
    }

    public String getAAB082() {
        return AAB082;
    }

    public void setAAB082(String AAB082) {
        this.AAB082 = AAB082;
    }

    public String getAAB121() {
        return AAB121;
    }

    public void setAAB121(String AAB121) {
        this.AAB121 = AAB121;
    }

    public String getBAC701() {
        return BAC701;
    }

    public void setBAC701(String BAC701) {
        this.BAC701 = BAC701;
    }

    public String getBAC703() {
        return BAC703;
    }

    public void setBAC703(String BAC703) {
        this.BAC703 = BAC703;
    }

    public String getBAB701() {
        return BAB701;
    }

    public void setBAB701(String BAB701) {
        this.BAB701 = BAB701;
    }

    public String getAAB124() {
        return AAB124;
    }

    public void setAAB124(String AAB124) {
        this.AAB124 = AAB124;
    }

    public String getBAB703() {
        return BAB703;
    }

    public void setBAB703(String BAB703) {
        this.BAB703 = BAB703;
    }

    public String getBAC706() {
        return BAC706;
    }

    public void setBAC706(String BAC706) {
        this.BAC706 = BAC706;
    }

    public String getAAD004() {
        return AAD004;
    }

    public void setAAD004(String AAD004) {
        this.AAD004 = AAD004;
    }

    public String getBAC708() {
        return BAC708;
    }

    public void setBAC708(String BAC708) {
        this.BAC708 = BAC708;
    }

    public String getBAC710() {
        return BAC710;
    }

    public void setBAC710(String BAC710) {
        this.BAC710 = BAC710;
    }

    public String getBAC712() {
        return BAC712;
    }

    public void setBAC712(String BAC712) {
        this.BAC712 = BAC712;
    }

    public String getBAB705() {
        return BAB705;
    }

    public void setBAB705(String BAB705) {
        this.BAB705 = BAB705;
    }

    public String getBAE741() {
        return BAE741;
    }

    public void setBAE741(String BAE741) {
        this.BAE741 = BAE741;
    }

    public String getBAE743() {
        return BAE743;
    }

    public void setBAE743(String BAE743) {
        this.BAE743 = BAE743;
    }

    public String getBAE749() {
        return BAE749;
    }

    public void setBAE749(String BAE749) {
        this.BAE749 = BAE749;
    }

    public String getBAE746() {
        return BAE746;
    }

    public void setBAE746(String BAE746) {
        this.BAE746 = BAE746;
    }

    public String getBAE748() {
        return BAE748;
    }

    public void setBAE748(String BAE748) {
        this.BAE748 = BAE748;
    }

    public String getAAE063() {
        return AAE063;
    }

    public void setAAE063(String AAE063) {
        this.AAE063 = AAE063;
    }

    public String getBAE703() {
        return BAE703;
    }

    public void setBAE703(String BAE703) {
        this.BAE703 = BAE703;
    }

    public String getAAE002() {
        return AAE002;
    }

    public void setAAE002(String AAE002) {
        this.AAE002 = AAE002;
    }

    public String getBAE702() {
        return BAE702;
    }

    public void setBAE702(String BAE702) {
        this.BAE702 = BAE702;
    }

    public String getAAB083() {
        return AAB083;
    }

    public void setAAB083(String AAB083) {
        this.AAB083 = AAB083;
    }

    public String getAAB120() {
        return AAB120;
    }

    public void setAAB120(String AAB120) {
        this.AAB120 = AAB120;
    }

    public String getAAB122() {
        return AAB122;
    }

    public void setAAB122(String AAB122) {
        this.AAB122 = AAB122;
    }

    public String getBAC702() {
        return BAC702;
    }

    public void setBAC702(String BAC702) {
        this.BAC702 = BAC702;
    }

    public String getBAC704() {
        return BAC704;
    }

    public void setBAC704(String BAC704) {
        this.BAC704 = BAC704;
    }

    public String getAAB123() {
        return AAB123;
    }

    public void setAAB123(String AAB123) {
        this.AAB123 = AAB123;
    }

    public String getBAB702() {
        return BAB702;
    }

    public void setBAB702(String BAB702) {
        this.BAB702 = BAB702;
    }

    public String getBAC705() {
        return BAC705;
    }

    public void setBAC705(String BAC705) {
        this.BAC705 = BAC705;
    }

    public String getAAD003() {
        return AAD003;
    }

    public void setAAD003(String AAD003) {
        this.AAD003 = AAD003;
    }

    public String getBAC707() {
        return BAC707;
    }

    public void setBAC707(String BAC707) {
        this.BAC707 = BAC707;
    }

    public String getBAC709() {
        return BAC709;
    }

    public void setBAC709(String BAC709) {
        this.BAC709 = BAC709;
    }

    public String getBAC711() {
        return BAC711;
    }

    public void setBAC711(String BAC711) {
        this.BAC711 = BAC711;
    }

    public String getBAB704() {
        return BAB704;
    }

    public void setBAB704(String BAB704) {
        this.BAB704 = BAB704;
    }

    public String getBAE740() {
        return BAE740;
    }

    public void setBAE740(String BAE740) {
        this.BAE740 = BAE740;
    }

    public String getBAE742() {
        return BAE742;
    }

    public void setBAE742(String BAE742) {
        this.BAE742 = BAE742;
    }

    public String getBAE744() {
        return BAE744;
    }

    public void setBAE744(String BAE744) {
        this.BAE744 = BAE744;
    }

    public String getBAE745() {
        return BAE745;
    }

    public void setBAE745(String BAE745) {
        this.BAE745 = BAE745;
    }

    public String getBAE747() {
        return BAE747;
    }

    public void setBAE747(String BAE747) {
        this.BAE747 = BAE747;
    }

    public String getAAB137() {
        return AAB137;
    }

    public void setAAB137(String AAB137) {
        this.AAB137 = AAB137;
    }

    public String getBAE750() {
        return BAE750;
    }

    public void setBAE750(String BAE750) {
        this.BAE750 = BAE750;
    }

    public String getBAE707() {
        return BAE707;
    }

    public void setBAE707(String BAE707) {
        this.BAE707 = BAE707;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YbUnit ybUnit = (YbUnit) o;
        return Objects.equals(AAB001, ybUnit.AAB001) &&
                Objects.equals(BAA001, ybUnit.BAA001) &&
                Objects.equals(BAB801, ybUnit.BAB801) &&
                Objects.equals(AAB002, ybUnit.AAB002) &&
                Objects.equals(AAB004, ybUnit.AAB004) &&
                Objects.equals(AAB006, ybUnit.AAB006) &&
                Objects.equals(AAB008, ybUnit.AAB008) &&
                Objects.equals(AAB010, ybUnit.AAB010) &&
                Objects.equals(AAB012, ybUnit.AAB012) &&
                Objects.equals(AAB014, ybUnit.AAB014) &&
                Objects.equals(AAB016, ybUnit.AAB016) &&
                Objects.equals(AAB018, ybUnit.AAB018) &&
                Objects.equals(AAB020, ybUnit.AAB020) &&
                Objects.equals(AAB022, ybUnit.AAB022) &&
                Objects.equals(AAB023, ybUnit.AAB023) &&
                Objects.equals(AAB024, ybUnit.AAB024) &&
                Objects.equals(AAB026, ybUnit.AAB026) &&
                Objects.equals(AAB027, ybUnit.AAB027) &&
                Objects.equals(AAB029, ybUnit.AAB029) &&
                Objects.equals(AAB031, ybUnit.AAB031) &&
                Objects.equals(AAB033, ybUnit.AAB033) &&
                Objects.equals(AAB035, ybUnit.AAB035) &&
                Objects.equals(AAE119, ybUnit.AAE119) &&
                Objects.equals(BAB513, ybUnit.BAB513) &&
                Objects.equals(BAB515, ybUnit.BAB515) &&
                Objects.equals(BAB803, ybUnit.BAB803) &&
                Objects.equals(BAB805, ybUnit.BAB805) &&
                Objects.equals(BAB807, ybUnit.BAB807) &&
                Objects.equals(BAA008, ybUnit.BAA008) &&
                Objects.equals(BAA010, ybUnit.BAA010) &&
                Objects.equals(AAE036, ybUnit.AAE036) &&
                Objects.equals(AAE007, ybUnit.AAE007) &&
                Objects.equals(BAB811, ybUnit.BAB811) &&
                Objects.equals(AAB100, ybUnit.AAB100) &&
                Objects.equals(BAB802, ybUnit.BAB802) &&
                Objects.equals(AAB003, ybUnit.AAB003) &&
                Objects.equals(AAB005, ybUnit.AAB005) &&
                Objects.equals(AAB007, ybUnit.AAB007) &&
                Objects.equals(AAB009, ybUnit.AAB009) &&
                Objects.equals(AAB011, ybUnit.AAB011) &&
                Objects.equals(AAB013, ybUnit.AAB013) &&
                Objects.equals(AAB015, ybUnit.AAB015) &&
                Objects.equals(AAB017, ybUnit.AAB017) &&
                Objects.equals(AAB019, ybUnit.AAB019) &&
                Objects.equals(AAB021, ybUnit.AAB021) &&
                Objects.equals(BAB519, ybUnit.BAB519) &&
                Objects.equals(BAB502, ybUnit.BAB502) &&
                Objects.equals(AAB025, ybUnit.AAB025) &&
                Objects.equals(BAB503, ybUnit.BAB503) &&
                Objects.equals(AAB028, ybUnit.AAB028) &&
                Objects.equals(AAB030, ybUnit.AAB030) &&
                Objects.equals(AAB032, ybUnit.AAB032) &&
                Objects.equals(AAB034, ybUnit.AAB034) &&
                Objects.equals(AAB036, ybUnit.AAB036) &&
                Objects.equals(BAB512, ybUnit.BAB512) &&
                Objects.equals(BAB514, ybUnit.BAB514) &&
                Objects.equals(BAB516, ybUnit.BAB516) &&
                Objects.equals(BAB804, ybUnit.BAB804) &&
                Objects.equals(BAB806, ybUnit.BAB806) &&
                Objects.equals(AAE013, ybUnit.AAE013) &&
                Objects.equals(BAA009, ybUnit.BAA009) &&
                Objects.equals(AAE011, ybUnit.AAE011) &&
                Objects.equals(AAE006, ybUnit.AAE006) &&
                Objects.equals(BAB506, ybUnit.BAB506) &&
                Objects.equals(AAC058, ybUnit.AAC058) &&
                Objects.equals(AAE140, ybUnit.AAE140) &&
                Objects.equals(AAB050, ybUnit.AAB050) &&
                Objects.equals(BAB510, ybUnit.BAB510) &&
                Objects.equals(BAB501, ybUnit.BAB501) &&
                Objects.equals(AAB051, ybUnit.AAB051) &&
                Objects.equals(AAA040, ybUnit.AAA040) &&
                Objects.equals(BAB808, ybUnit.BAB808) &&
                Objects.equals(StartYM, ybUnit.StartYM) &&
                Objects.equals(EndYM, ybUnit.EndYM) &&
                Objects.equals(AAE143, ybUnit.AAE143) &&
                Objects.equals(BAA005, ybUnit.BAA005) &&
                Objects.equals(AAE003, ybUnit.AAE003) &&
                Objects.equals(BAB706, ybUnit.BAB706) &&
                Objects.equals(AAB082, ybUnit.AAB082) &&
                Objects.equals(AAB121, ybUnit.AAB121) &&
                Objects.equals(BAC701, ybUnit.BAC701) &&
                Objects.equals(BAC703, ybUnit.BAC703) &&
                Objects.equals(BAB701, ybUnit.BAB701) &&
                Objects.equals(AAB124, ybUnit.AAB124) &&
                Objects.equals(BAB703, ybUnit.BAB703) &&
                Objects.equals(BAC706, ybUnit.BAC706) &&
                Objects.equals(AAD004, ybUnit.AAD004) &&
                Objects.equals(BAC708, ybUnit.BAC708) &&
                Objects.equals(BAC710, ybUnit.BAC710) &&
                Objects.equals(BAC712, ybUnit.BAC712) &&
                Objects.equals(BAB705, ybUnit.BAB705) &&
                Objects.equals(BAE741, ybUnit.BAE741) &&
                Objects.equals(BAE743, ybUnit.BAE743) &&
                Objects.equals(BAE749, ybUnit.BAE749) &&
                Objects.equals(BAE746, ybUnit.BAE746) &&
                Objects.equals(BAE748, ybUnit.BAE748) &&
                Objects.equals(AAE063, ybUnit.AAE063) &&
                Objects.equals(BAE703, ybUnit.BAE703) &&
                Objects.equals(AAE002, ybUnit.AAE002) &&
                Objects.equals(BAE702, ybUnit.BAE702) &&
                Objects.equals(AAB083, ybUnit.AAB083) &&
                Objects.equals(AAB120, ybUnit.AAB120) &&
                Objects.equals(AAB122, ybUnit.AAB122) &&
                Objects.equals(BAC702, ybUnit.BAC702) &&
                Objects.equals(BAC704, ybUnit.BAC704) &&
                Objects.equals(AAB123, ybUnit.AAB123) &&
                Objects.equals(BAB702, ybUnit.BAB702) &&
                Objects.equals(BAC705, ybUnit.BAC705) &&
                Objects.equals(AAD003, ybUnit.AAD003) &&
                Objects.equals(BAC707, ybUnit.BAC707) &&
                Objects.equals(BAC709, ybUnit.BAC709) &&
                Objects.equals(BAC711, ybUnit.BAC711) &&
                Objects.equals(BAB704, ybUnit.BAB704) &&
                Objects.equals(BAE740, ybUnit.BAE740) &&
                Objects.equals(BAE742, ybUnit.BAE742) &&
                Objects.equals(BAE744, ybUnit.BAE744) &&
                Objects.equals(BAE745, ybUnit.BAE745) &&
                Objects.equals(BAE747, ybUnit.BAE747) &&
                Objects.equals(AAB137, ybUnit.AAB137) &&
                Objects.equals(BAE750, ybUnit.BAE750) &&
                Objects.equals(BAE707, ybUnit.BAE707);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAB001, BAA001, BAB801, AAB002, AAB004, AAB006, AAB008, AAB010, AAB012, AAB014, AAB016, AAB018, AAB020, AAB022, AAB023, AAB024, AAB026, AAB027, AAB029, AAB031, AAB033, AAB035, AAE119, BAB513, BAB515, BAB803, BAB805, BAB807, BAA008, BAA010, AAE036, AAE007, BAB811, AAB100, BAB802, AAB003, AAB005, AAB007, AAB009, AAB011, AAB013, AAB015, AAB017, AAB019, AAB021, BAB519, BAB502, AAB025, BAB503, AAB028, AAB030, AAB032, AAB034, AAB036, BAB512, BAB514, BAB516, BAB804, BAB806, AAE013, BAA009, AAE011, AAE006, BAB506, AAC058, AAE140, AAB050, BAB510, BAB501, AAB051, AAA040, BAB808, StartYM, EndYM, AAE143, BAA005, AAE003, BAB706, AAB082, AAB121, BAC701, BAC703, BAB701, AAB124, BAB703, BAC706, AAD004, BAC708, BAC710, BAC712, BAB705, BAE741, BAE743, BAE749, BAE746, BAE748, AAE063, BAE703, AAE002, BAE702, AAB083, AAB120, AAB122, BAC702, BAC704, AAB123, BAB702, BAC705, AAD003, BAC707, BAC709, BAC711, BAB704, BAE740, BAE742, BAE744, BAE745, BAE747, AAB137, BAE750, BAE707);
    }
}
