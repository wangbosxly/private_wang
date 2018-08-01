package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 单位缴费
 * @author sl_su
 */
public class GsUnitPay implements Serializable {

    private static final long serialVersionUID = 1667758958109108295L;
    private String BAA005;//审核编号
    private String AAE140;//险种类型
    private String AAE002;//费款所属期
    private String AAB121;//单位缴费基数总额
    private String BAB701;//单位应缴
    private String BAE742;//滞纳金金额
    private String AAB137;//应缴合计
    private String AAE170;//操作人
    private String AAB001;//单位编号
    private String BAA001;//数据分区
    private String AAE041;//开始费款所属期
    private String AAE042;//结束费款所属期
    private String BAE746;//是否计算利息
    private String BAE747;//是否计算滞纳金
    private String PersonCount	;//人数
    private String BAB501;//	双基数标志
    private String AAB050;//	参保日期
    private String AAB051;//	参保状态
    private String BAB510;//	最近参保时间
    private String AAA040;//	缴费比例类别
    private String AAB004;//	单位名称
    private String BAB519;//	行业企业代码
    private String AAB019;//	单位类型
    private String AAB020;//	经济类型
    private String AAB021;//	隶属关系
    private String AAB022;//	行业代码
    private String BAE703;//主体编号
    private String AAE003;//对应费款所属期
    private String BAE702;//主体类型
    private String AAE143;//缴费类型
    private String BAB706;//应收核定类别
    private String AAB083;//在职职工人次
    private String AAB082;//离退休（职）人次
    private String AAB120;//个人缴费基数总额
    private String AAB122;//本期个人应缴金额
    private String BAC701;//本期个人应缴划入统筹金额
    private String BAC702;//本期个人应缴划入帐户金额
    private String BAC703;//审核时个人缴费部分应补帐户利息
    private String BAC704;//审核时个人缴费部分应补统筹利息
    private String AAB123;//本期单位缴费应划入个人帐户金额
    private String AAB124;//本期单位缴费应划入统筹金额
    private String BAB702;//审核时单位缴费应划入个人帐户部分应补利息
    private String BAB703;//审核时单位缴费划入统筹金利息
    private String BAC705;//核销个人应缴划入帐户金额
    private String BAC706;//核销个人应缴划入统筹金额
    private String AAD003;//核销单位欠缴应划入帐户金额
    private String AAD004;//核销单位欠缴统筹金额
    private String BAC707;//核销个人帐户做实金额
    private String BAC708;//本期个人帐户做实金额
    private String BAC709;//核销在职人数
    private String BAC710;//核销离退休（职）人数
    private String BAC711;//征集时个人缴费部分应补帐户利息
    private String BAC712;//征集时个人缴费部分应补统筹利息
    private String BAB704;//征集时单位缴费应划入个人帐户部分应补利息
    private String BAB705;//征集时单位缴费划入统筹金利息
    private String BAE740;//审核时利息计算截止月份
    private String BAE741;//审核时滞纳金计算截止日期
    private String BAE743;//审核时减免滞纳金金额
    private String BAE744;//征集时滞纳金计算截止日期
    private String BAE749;//征集时滞纳金金额
    private String BAE745;//征集时减免滞纳金金额
    private String BAE748;//核销小计
    private String AAB033;//缴费方式
    private String BAE750;//缓缴截止日期
    private String AAE063;//征集通知流水号
    private String BAE707;//基金配置流水号
    private String AAB034;//社会保险经办机构编码
    private String AAE011;//经办人
    private String AAE036;//经办时间
    private String BAB812;//煤炭企业年设计产量(万吨)
    private String AAE013;//备注
    private String BAE706;//到账日期
    private String AAB121_1;//	财政缴费基数总额
    private String BAB701_1;//	本期财政应缴金额

    private String startAAE002;  //startAAE002	开始费款所属期	否
    private String endAAE002;  //endAAE002	结束费款所属期	否



    @Override
    public String toString() {
        return "GsUnitPay{" +
                "BAA005='" + BAA005 + '\'' +
                ", AAE140='" + AAE140 + '\'' +
                ", AAE002='" + AAE002 + '\'' +
                ", AAB121='" + AAB121 + '\'' +
                ", BAB701='" + BAB701 + '\'' +
                ", BAE742='" + BAE742 + '\'' +
                ", AAB137='" + AAB137 + '\'' +
                ", AAE170='" + AAE170 + '\'' +
                ", AAB001='" + AAB001 + '\'' +
                ", BAA001='" + BAA001 + '\'' +
                ", AAE041='" + AAE041 + '\'' +
                ", AAE042='" + AAE042 + '\'' +
                ", BAE746='" + BAE746 + '\'' +
                ", BAE747='" + BAE747 + '\'' +
                ", PersonCount='" + PersonCount + '\'' +
                ", BAB501='" + BAB501 + '\'' +
                ", AAB050='" + AAB050 + '\'' +
                ", AAB051='" + AAB051 + '\'' +
                ", BAB510='" + BAB510 + '\'' +
                ", AAA040='" + AAA040 + '\'' +
                ", AAB004='" + AAB004 + '\'' +
                ", BAB519='" + BAB519 + '\'' +
                ", AAB019='" + AAB019 + '\'' +
                ", AAB020='" + AAB020 + '\'' +
                ", AAB021='" + AAB021 + '\'' +
                ", AAB022='" + AAB022 + '\'' +
                ", BAE703='" + BAE703 + '\'' +
                ", AAE003='" + AAE003 + '\'' +
                ", BAE702='" + BAE702 + '\'' +
                ", AAE143='" + AAE143 + '\'' +
                ", BAB706='" + BAB706 + '\'' +
                ", AAB083='" + AAB083 + '\'' +
                ", AAB082='" + AAB082 + '\'' +
                ", AAB120='" + AAB120 + '\'' +
                ", AAB122='" + AAB122 + '\'' +
                ", BAC701='" + BAC701 + '\'' +
                ", BAC702='" + BAC702 + '\'' +
                ", BAC703='" + BAC703 + '\'' +
                ", BAC704='" + BAC704 + '\'' +
                ", AAB123='" + AAB123 + '\'' +
                ", AAB124='" + AAB124 + '\'' +
                ", BAB702='" + BAB702 + '\'' +
                ", BAB703='" + BAB703 + '\'' +
                ", BAC705='" + BAC705 + '\'' +
                ", BAC706='" + BAC706 + '\'' +
                ", AAD003='" + AAD003 + '\'' +
                ", AAD004='" + AAD004 + '\'' +
                ", BAC707='" + BAC707 + '\'' +
                ", BAC708='" + BAC708 + '\'' +
                ", BAC709='" + BAC709 + '\'' +
                ", BAC710='" + BAC710 + '\'' +
                ", BAC711='" + BAC711 + '\'' +
                ", BAC712='" + BAC712 + '\'' +
                ", BAB704='" + BAB704 + '\'' +
                ", BAB705='" + BAB705 + '\'' +
                ", BAE740='" + BAE740 + '\'' +
                ", BAE741='" + BAE741 + '\'' +
                ", BAE743='" + BAE743 + '\'' +
                ", BAE744='" + BAE744 + '\'' +
                ", BAE749='" + BAE749 + '\'' +
                ", BAE745='" + BAE745 + '\'' +
                ", BAE748='" + BAE748 + '\'' +
                ", AAB033='" + AAB033 + '\'' +
                ", BAE750='" + BAE750 + '\'' +
                ", AAE063='" + AAE063 + '\'' +
                ", BAE707='" + BAE707 + '\'' +
                ", AAB034='" + AAB034 + '\'' +
                ", AAE011='" + AAE011 + '\'' +
                ", AAE036='" + AAE036 + '\'' +
                ", BAB812='" + BAB812 + '\'' +
                ", AAE013='" + AAE013 + '\'' +
                ", BAE706='" + BAE706 + '\'' +
                ", AAB121_1='" + AAB121_1 + '\'' +
                ", BAB701_1='" + BAB701_1 + '\'' +
                ", startAAE002='" + startAAE002 + '\'' +
                ", endAAE002='" + endAAE002 + '\'' +
                '}';
    }

    public String getStartAAE002() {
        return startAAE002;
    }

    public void setStartAAE002(String startAAE002) {
        this.startAAE002 = startAAE002;
    }

    public String getEndAAE002() {
        return endAAE002;
    }

    public void setEndAAE002(String endAAE002) {
        this.endAAE002 = endAAE002;
    }

    public String getBAE703() {
        return BAE703;
    }

    public void setBAE703(String BAE703) {
        this.BAE703 = BAE703;
    }

    public String getAAE003() {
        return AAE003;
    }

    public void setAAE003(String AAE003) {
        this.AAE003 = AAE003;
    }

    public String getBAE702() {
        return BAE702;
    }

    public void setBAE702(String BAE702) {
        this.BAE702 = BAE702;
    }

    public String getAAE143() {
        return AAE143;
    }

    public void setAAE143(String AAE143) {
        this.AAE143 = AAE143;
    }

    public String getBAB706() {
        return BAB706;
    }

    public void setBAB706(String BAB706) {
        this.BAB706 = BAB706;
    }

    public String getAAB083() {
        return AAB083;
    }

    public void setAAB083(String AAB083) {
        this.AAB083 = AAB083;
    }

    public String getAAB082() {
        return AAB082;
    }

    public void setAAB082(String AAB082) {
        this.AAB082 = AAB082;
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

    public String getBAC701() {
        return BAC701;
    }

    public void setBAC701(String BAC701) {
        this.BAC701 = BAC701;
    }

    public String getBAC702() {
        return BAC702;
    }

    public void setBAC702(String BAC702) {
        this.BAC702 = BAC702;
    }

    public String getBAC703() {
        return BAC703;
    }

    public void setBAC703(String BAC703) {
        this.BAC703 = BAC703;
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

    public String getAAB124() {
        return AAB124;
    }

    public void setAAB124(String AAB124) {
        this.AAB124 = AAB124;
    }

    public String getBAB702() {
        return BAB702;
    }

    public void setBAB702(String BAB702) {
        this.BAB702 = BAB702;
    }

    public String getBAB703() {
        return BAB703;
    }

    public void setBAB703(String BAB703) {
        this.BAB703 = BAB703;
    }

    public String getBAC705() {
        return BAC705;
    }

    public void setBAC705(String BAC705) {
        this.BAC705 = BAC705;
    }

    public String getBAC706() {
        return BAC706;
    }

    public void setBAC706(String BAC706) {
        this.BAC706 = BAC706;
    }

    public String getAAD003() {
        return AAD003;
    }

    public void setAAD003(String AAD003) {
        this.AAD003 = AAD003;
    }

    public String getAAD004() {
        return AAD004;
    }

    public void setAAD004(String AAD004) {
        this.AAD004 = AAD004;
    }

    public String getBAC707() {
        return BAC707;
    }

    public void setBAC707(String BAC707) {
        this.BAC707 = BAC707;
    }

    public String getBAC708() {
        return BAC708;
    }

    public void setBAC708(String BAC708) {
        this.BAC708 = BAC708;
    }

    public String getBAC709() {
        return BAC709;
    }

    public void setBAC709(String BAC709) {
        this.BAC709 = BAC709;
    }

    public String getBAC710() {
        return BAC710;
    }

    public void setBAC710(String BAC710) {
        this.BAC710 = BAC710;
    }

    public String getBAC711() {
        return BAC711;
    }

    public void setBAC711(String BAC711) {
        this.BAC711 = BAC711;
    }

    public String getBAC712() {
        return BAC712;
    }

    public void setBAC712(String BAC712) {
        this.BAC712 = BAC712;
    }

    public String getBAB704() {
        return BAB704;
    }

    public void setBAB704(String BAB704) {
        this.BAB704 = BAB704;
    }

    public String getBAB705() {
        return BAB705;
    }

    public void setBAB705(String BAB705) {
        this.BAB705 = BAB705;
    }

    public String getBAE740() {
        return BAE740;
    }

    public void setBAE740(String BAE740) {
        this.BAE740 = BAE740;
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

    public String getBAE744() {
        return BAE744;
    }

    public void setBAE744(String BAE744) {
        this.BAE744 = BAE744;
    }

    public String getBAE749() {
        return BAE749;
    }

    public void setBAE749(String BAE749) {
        this.BAE749 = BAE749;
    }

    public String getBAE745() {
        return BAE745;
    }

    public void setBAE745(String BAE745) {
        this.BAE745 = BAE745;
    }

    public String getBAE748() {
        return BAE748;
    }

    public void setBAE748(String BAE748) {
        this.BAE748 = BAE748;
    }

    public String getAAB033() {
        return AAB033;
    }

    public void setAAB033(String AAB033) {
        this.AAB033 = AAB033;
    }

    public String getBAE750() {
        return BAE750;
    }

    public void setBAE750(String BAE750) {
        this.BAE750 = BAE750;
    }

    public String getAAE063() {
        return AAE063;
    }

    public void setAAE063(String AAE063) {
        this.AAE063 = AAE063;
    }

    public String getBAE707() {
        return BAE707;
    }

    public void setBAE707(String BAE707) {
        this.BAE707 = BAE707;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
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

    public String getBAB812() {
        return BAB812;
    }

    public void setBAB812(String BAB812) {
        this.BAB812 = BAB812;
    }

    public String getAAE013() {
        return AAE013;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }

    public String getBAE706() {
        return BAE706;
    }

    public void setBAE706(String BAE706) {
        this.BAE706 = BAE706;
    }

    public String getAAB121_1() {
        return AAB121_1;
    }

    public void setAAB121_1(String AAB121_1) {
        this.AAB121_1 = AAB121_1;
    }

    public String getBAB701_1() {
        return BAB701_1;
    }

    public void setBAB701_1(String BAB701_1) {
        this.BAB701_1 = BAB701_1;
    }

    public String getBAB501() {
        return BAB501;
    }

    public void setBAB501(String BAB501) {
        this.BAB501 = BAB501;
    }

    public String getAAB050() {
        return AAB050;
    }

    public void setAAB050(String AAB050) {
        this.AAB050 = AAB050;
    }

    public String getAAB051() {
        return AAB051;
    }

    public void setAAB051(String AAB051) {
        this.AAB051 = AAB051;
    }

    public String getBAB510() {
        return BAB510;
    }

    public void setBAB510(String BAB510) {
        this.BAB510 = BAB510;
    }

    public String getAAA040() {
        return AAA040;
    }

    public void setAAA040(String AAA040) {
        this.AAA040 = AAA040;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getBAB519() {
        return BAB519;
    }

    public void setBAB519(String BAB519) {
        this.BAB519 = BAB519;
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

    public String getBAA005() {
        return BAA005;
    }

    public void setBAA005(String BAA005) {
        this.BAA005 = BAA005;
    }

    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }

    public String getAAE002() {
        return AAE002;
    }

    public void setAAE002(String AAE002) {
        this.AAE002 = AAE002;
    }

    public String getAAB121() {
        return AAB121;
    }

    public void setAAB121(String AAB121) {
        this.AAB121 = AAB121;
    }

    public String getBAB701() {
        return BAB701;
    }

    public void setBAB701(String BAB701) {
        this.BAB701 = BAB701;
    }

    public String getBAE742() {
        return BAE742;
    }

    public void setBAE742(String BAE742) {
        this.BAE742 = BAE742;
    }

    public String getAAB137() {
        return AAB137;
    }

    public void setAAB137(String AAB137) {
        this.AAB137 = AAB137;
    }

    public String getAAE170() {
        return AAE170;
    }

    public void setAAE170(String AAE170) {
        this.AAE170 = AAE170;
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

    public String getAAE041() {
        return AAE041;
    }

    public void setAAE041(String AAE041) {
        this.AAE041 = AAE041;
    }

    public String getAAE042() {
        return AAE042;
    }

    public void setAAE042(String AAE042) {
        this.AAE042 = AAE042;
    }

    public String getBAE746() {
        return BAE746;
    }

    public void setBAE746(String BAE746) {
        this.BAE746 = BAE746;
    }

    public String getBAE747() {
        return BAE747;
    }

    public void setBAE747(String BAE747) {
        this.BAE747 = BAE747;
    }

    public String getPersonCount() {
        return PersonCount;
    }

    public void setPersonCount(String personCount) {
        PersonCount = personCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GsUnitPay gsUnitPay = (GsUnitPay) o;
        return Objects.equals(BAA005, gsUnitPay.BAA005) &&
                Objects.equals(AAE140, gsUnitPay.AAE140) &&
                Objects.equals(AAE002, gsUnitPay.AAE002) &&
                Objects.equals(AAB121, gsUnitPay.AAB121) &&
                Objects.equals(BAB701, gsUnitPay.BAB701) &&
                Objects.equals(BAE742, gsUnitPay.BAE742) &&
                Objects.equals(AAB137, gsUnitPay.AAB137) &&
                Objects.equals(AAE170, gsUnitPay.AAE170) &&
                Objects.equals(AAB001, gsUnitPay.AAB001) &&
                Objects.equals(BAA001, gsUnitPay.BAA001) &&
                Objects.equals(AAE041, gsUnitPay.AAE041) &&
                Objects.equals(AAE042, gsUnitPay.AAE042) &&
                Objects.equals(BAE746, gsUnitPay.BAE746) &&
                Objects.equals(BAE747, gsUnitPay.BAE747) &&
                Objects.equals(PersonCount, gsUnitPay.PersonCount) &&
                Objects.equals(BAB501, gsUnitPay.BAB501) &&
                Objects.equals(AAB050, gsUnitPay.AAB050) &&
                Objects.equals(AAB051, gsUnitPay.AAB051) &&
                Objects.equals(BAB510, gsUnitPay.BAB510) &&
                Objects.equals(AAA040, gsUnitPay.AAA040) &&
                Objects.equals(AAB004, gsUnitPay.AAB004) &&
                Objects.equals(BAB519, gsUnitPay.BAB519) &&
                Objects.equals(AAB019, gsUnitPay.AAB019) &&
                Objects.equals(AAB020, gsUnitPay.AAB020) &&
                Objects.equals(AAB021, gsUnitPay.AAB021) &&
                Objects.equals(AAB022, gsUnitPay.AAB022) &&
                Objects.equals(BAE703, gsUnitPay.BAE703) &&
                Objects.equals(AAE003, gsUnitPay.AAE003) &&
                Objects.equals(BAE702, gsUnitPay.BAE702) &&
                Objects.equals(AAE143, gsUnitPay.AAE143) &&
                Objects.equals(BAB706, gsUnitPay.BAB706) &&
                Objects.equals(AAB083, gsUnitPay.AAB083) &&
                Objects.equals(AAB082, gsUnitPay.AAB082) &&
                Objects.equals(AAB120, gsUnitPay.AAB120) &&
                Objects.equals(AAB122, gsUnitPay.AAB122) &&
                Objects.equals(BAC701, gsUnitPay.BAC701) &&
                Objects.equals(BAC702, gsUnitPay.BAC702) &&
                Objects.equals(BAC703, gsUnitPay.BAC703) &&
                Objects.equals(BAC704, gsUnitPay.BAC704) &&
                Objects.equals(AAB123, gsUnitPay.AAB123) &&
                Objects.equals(AAB124, gsUnitPay.AAB124) &&
                Objects.equals(BAB702, gsUnitPay.BAB702) &&
                Objects.equals(BAB703, gsUnitPay.BAB703) &&
                Objects.equals(BAC705, gsUnitPay.BAC705) &&
                Objects.equals(BAC706, gsUnitPay.BAC706) &&
                Objects.equals(AAD003, gsUnitPay.AAD003) &&
                Objects.equals(AAD004, gsUnitPay.AAD004) &&
                Objects.equals(BAC707, gsUnitPay.BAC707) &&
                Objects.equals(BAC708, gsUnitPay.BAC708) &&
                Objects.equals(BAC709, gsUnitPay.BAC709) &&
                Objects.equals(BAC710, gsUnitPay.BAC710) &&
                Objects.equals(BAC711, gsUnitPay.BAC711) &&
                Objects.equals(BAC712, gsUnitPay.BAC712) &&
                Objects.equals(BAB704, gsUnitPay.BAB704) &&
                Objects.equals(BAB705, gsUnitPay.BAB705) &&
                Objects.equals(BAE740, gsUnitPay.BAE740) &&
                Objects.equals(BAE741, gsUnitPay.BAE741) &&
                Objects.equals(BAE743, gsUnitPay.BAE743) &&
                Objects.equals(BAE744, gsUnitPay.BAE744) &&
                Objects.equals(BAE749, gsUnitPay.BAE749) &&
                Objects.equals(BAE745, gsUnitPay.BAE745) &&
                Objects.equals(BAE748, gsUnitPay.BAE748) &&
                Objects.equals(AAB033, gsUnitPay.AAB033) &&
                Objects.equals(BAE750, gsUnitPay.BAE750) &&
                Objects.equals(AAE063, gsUnitPay.AAE063) &&
                Objects.equals(BAE707, gsUnitPay.BAE707) &&
                Objects.equals(AAB034, gsUnitPay.AAB034) &&
                Objects.equals(AAE011, gsUnitPay.AAE011) &&
                Objects.equals(AAE036, gsUnitPay.AAE036) &&
                Objects.equals(BAB812, gsUnitPay.BAB812) &&
                Objects.equals(AAE013, gsUnitPay.AAE013) &&
                Objects.equals(BAE706, gsUnitPay.BAE706) &&
                Objects.equals(AAB121_1, gsUnitPay.AAB121_1) &&
                Objects.equals(BAB701_1, gsUnitPay.BAB701_1);
    }

    @Override
    public int hashCode() {

        return Objects.hash(BAA005, AAE140, AAE002, AAB121, BAB701, BAE742, AAB137, AAE170, AAB001, BAA001, AAE041, AAE042, BAE746, BAE747, PersonCount, BAB501, AAB050, AAB051, BAB510, AAA040, AAB004, BAB519, AAB019, AAB020, AAB021, AAB022, BAE703, AAE003, BAE702, AAE143, BAB706, AAB083, AAB082, AAB120, AAB122, BAC701, BAC702, BAC703, BAC704, AAB123, AAB124, BAB702, BAB703, BAC705, BAC706, AAD003, AAD004, BAC707, BAC708, BAC709, BAC710, BAC711, BAC712, BAB704, BAB705, BAE740, BAE741, BAE743, BAE744, BAE749, BAE745, BAE748, AAB033, BAE750, AAE063, BAE707, AAB034, AAE011, AAE036, BAB812, AAE013, BAE706, AAB121_1, BAB701_1);
    }
}
