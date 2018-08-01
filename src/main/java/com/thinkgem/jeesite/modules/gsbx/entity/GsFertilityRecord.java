package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 人员生育信息备案
 * @author sl_su
 */
public class GsFertilityRecord implements Serializable {

    private static final long serialVersionUID = 6980607092891253065L;
    /**	操作人 */
    private String AAE170;
    /** 登记流水号 */
    private String BAA005;
    /** 个人编号 */
    private String AAC001;
    /** 身份证号 */
    private String AAC002;
    /** 姓名 */
    private String AAC003;
    /** 生效日期 */
    private String AMC033;
    /** 截至日期 */
    private String AMC030;
    /** 个人生育缴费基数 */
    private String AMC060;
    /** 个人参加生育标志 */
    private String AMC061;
    /** 是否定点医疗机构 */
    private String AMC062;
    /** 医疗机构编号 */
    private String AKB020;
    /** 单位编号 */
    private String AAB001;
    /** 待遇发放方式 */
    private String AAE145;
    /** 生育保险类别 */
    private String AMC078;
    /** 怀孕日期 */
    private String AMC087;
    /** 生育发生日期 */
    private String AMC020;
    /** 生育证号准生证号 */
    private String AMC021;
    /** 出生证号 */
    private String AMC022;
    /** 是否独生子女 */
    private String AMC079;
    /** 独生子女证号 */
    private String AMC023;
    /** 医保IC卡号 */
    private String AKC020;
    /** 生育类别 */
    private String AMC026;
    /** 产假流产级别 */
    private String AMC024;
    /** 医疗费流产级别 */
    private String AMC080;
    /** 计划生育手术类别 */
    private String AMC029;
    /** 正常产假 */
    private String AMC081;
    /** 多胎增加产假 */
    private String AMC082;
    /** 晚育增加产假 */
    private String AMC083;
    /** 独生证增加产假 */
    private String AMC084;
    /** 难产增加产假 */
    private String AMC085;
    /** 产假总天数 */
    private String AMC031;
    /** 护理假天数 */
    private String AMC067;
    /** 晚育标志 */
    private String AMC027;
    /** 胎儿数 */
    private String AMC028;
    /** 胎次 */
    private String AMC032;
    /** 生育证号 */
    private String AMC088;
    /** 医疗费农合医保是否已报销 */
    private String AMC089;
    /** 预产期 */
    private String AMC090;
    /** 配偶姓名 */
    private String AMC091;
    /** 配偶身份证号 */
    private String AMC092;
    /** 配偶单位名称 */
    private String AMC093;
    /** 配偶胎次 */
    private String AMC094;
    /** 备注 */
    private String AMC095;
    /** 保留7 */
    private String AMC096;
    /** 银行类别 */
    private String BAD001;
    /** 代收代发机构编号 */
    private String BAD002;
    /** 银行行号 */
    private String AAE008;
    /** 银行帐号 */
    private String AAE010;
    /** 开户户名 */
    private String AIC331;
    /** 生育登记时间 */
    private String AMC086;
    /** 经办机构编码 */
    private String AAB034;
    /** 数据分区编号 */
    private String BAA001;
    /** 审核编号 */
    private String BAA006;
    /** 经办人 */
    private String AAE011;
    /** 经办时间 */
    private String AAE036;
    /** 是否异地居住 */
    private String AMC097;
    /** 是否孕前检查 */
    private String AMC100;
    /** 孕检增加产假 */
    private String AMC101;
    /** 险种 */
    private String AAE140;
    /** 民族 */
    private String AAC005;
    /** 性别 */
    private String AAC004;

    @Override
    public String toString() {
        return "GsFertilityRecord{" +
                "AAE170='" + AAE170 + '\'' +
                ", BAA005='" + BAA005 + '\'' +
                ", AAC001='" + AAC001 + '\'' +
                ", AAC002='" + AAC002 + '\'' +
                ", AAC003='" + AAC003 + '\'' +
                ", AMC033='" + AMC033 + '\'' +
                ", AMC030='" + AMC030 + '\'' +
                ", AMC060='" + AMC060 + '\'' +
                ", AMC061='" + AMC061 + '\'' +
                ", AMC062='" + AMC062 + '\'' +
                ", AKB020='" + AKB020 + '\'' +
                ", AAB001='" + AAB001 + '\'' +
                ", AAE145='" + AAE145 + '\'' +
                ", AMC078='" + AMC078 + '\'' +
                ", AMC087='" + AMC087 + '\'' +
                ", AMC020='" + AMC020 + '\'' +
                ", AMC021='" + AMC021 + '\'' +
                ", AMC022='" + AMC022 + '\'' +
                ", AMC079='" + AMC079 + '\'' +
                ", AMC023='" + AMC023 + '\'' +
                ", AKC020='" + AKC020 + '\'' +
                ", AMC026='" + AMC026 + '\'' +
                ", AMC024='" + AMC024 + '\'' +
                ", AMC080='" + AMC080 + '\'' +
                ", AMC029='" + AMC029 + '\'' +
                ", AMC081='" + AMC081 + '\'' +
                ", AMC082='" + AMC082 + '\'' +
                ", AMC083='" + AMC083 + '\'' +
                ", AMC084='" + AMC084 + '\'' +
                ", AMC085='" + AMC085 + '\'' +
                ", AMC031='" + AMC031 + '\'' +
                ", AMC067='" + AMC067 + '\'' +
                ", AMC027='" + AMC027 + '\'' +
                ", AMC028='" + AMC028 + '\'' +
                ", AMC032='" + AMC032 + '\'' +
                ", AMC088='" + AMC088 + '\'' +
                ", AMC089='" + AMC089 + '\'' +
                ", AMC090='" + AMC090 + '\'' +
                ", AMC091='" + AMC091 + '\'' +
                ", AMC092='" + AMC092 + '\'' +
                ", AMC093='" + AMC093 + '\'' +
                ", AMC094='" + AMC094 + '\'' +
                ", AMC095='" + AMC095 + '\'' +
                ", AMC096='" + AMC096 + '\'' +
                ", BAD001='" + BAD001 + '\'' +
                ", BAD002='" + BAD002 + '\'' +
                ", AAE008='" + AAE008 + '\'' +
                ", AAE010='" + AAE010 + '\'' +
                ", AIC331='" + AIC331 + '\'' +
                ", AMC086='" + AMC086 + '\'' +
                ", AAB034='" + AAB034 + '\'' +
                ", BAA001='" + BAA001 + '\'' +
                ", BAA006='" + BAA006 + '\'' +
                ", AAE011='" + AAE011 + '\'' +
                ", AAE036='" + AAE036 + '\'' +
                ", AMC097='" + AMC097 + '\'' +
                ", AMC100='" + AMC100 + '\'' +
                ", AMC101='" + AMC101 + '\'' +
                ", AAE140='" + AAE140 + '\'' +
                ", AAC005='" + AAC005 + '\'' +
                ", AAC004='" + AAC004 + '\'' +
                '}';
    }

    public String getAAC005() {
        return AAC005;
    }

    public void setAAC005(String AAC005) {
        this.AAC005 = AAC005;
    }

    public String getAAC004() {
        return AAC004;
    }

    public void setAAC004(String AAC004) {
        this.AAC004 = AAC004;
    }

    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }

    public String getAAC002() {
        return AAC002;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }

    public String getAAC003() {
        return AAC003;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }

    public String getAAE170() {
        return AAE170;
    }

    public void setAAE170(String AAE170) {
        this.AAE170 = AAE170;
    }

    public String getBAA005() {
        return BAA005;
    }

    public void setBAA005(String BAA005) {
        this.BAA005 = BAA005;
    }

    public String getAAC001() {
        return AAC001;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }

    public String getAMC033() {
        return AMC033;
    }

    public void setAMC033(String AMC033) {
        this.AMC033 = AMC033;
    }

    public String getAMC030() {
        return AMC030;
    }

    public void setAMC030(String AMC030) {
        this.AMC030 = AMC030;
    }

    public String getAMC060() {
        return AMC060;
    }

    public void setAMC060(String AMC060) {
        this.AMC060 = AMC060;
    }

    public String getAMC061() {
        return AMC061;
    }

    public void setAMC061(String AMC061) {
        this.AMC061 = AMC061;
    }

    public String getAMC062() {
        return AMC062;
    }

    public void setAMC062(String AMC062) {
        this.AMC062 = AMC062;
    }

    public String getAKB020() {
        return AKB020;
    }

    public void setAKB020(String AKB020) {
        this.AKB020 = AKB020;
    }

    public String getAAB001() {
        return AAB001;
    }

    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }

    public String getAAE145() {
        return AAE145;
    }

    public void setAAE145(String AAE145) {
        this.AAE145 = AAE145;
    }

    public String getAMC078() {
        return AMC078;
    }

    public void setAMC078(String AMC078) {
        this.AMC078 = AMC078;
    }

    public String getAMC087() {
        return AMC087;
    }

    public void setAMC087(String AMC087) {
        this.AMC087 = AMC087;
    }

    public String getAMC020() {
        return AMC020;
    }

    public void setAMC020(String AMC020) {
        this.AMC020 = AMC020;
    }

    public String getAMC021() {
        return AMC021;
    }

    public void setAMC021(String AMC021) {
        this.AMC021 = AMC021;
    }

    public String getAMC022() {
        return AMC022;
    }

    public void setAMC022(String AMC022) {
        this.AMC022 = AMC022;
    }

    public String getAMC079() {
        return AMC079;
    }

    public void setAMC079(String AMC079) {
        this.AMC079 = AMC079;
    }

    public String getAMC023() {
        return AMC023;
    }

    public void setAMC023(String AMC023) {
        this.AMC023 = AMC023;
    }

    public String getAKC020() {
        return AKC020;
    }

    public void setAKC020(String AKC020) {
        this.AKC020 = AKC020;
    }

    public String getAMC026() {
        return AMC026;
    }

    public void setAMC026(String AMC026) {
        this.AMC026 = AMC026;
    }

    public String getAMC024() {
        return AMC024;
    }

    public void setAMC024(String AMC024) {
        this.AMC024 = AMC024;
    }

    public String getAMC080() {
        return AMC080;
    }

    public void setAMC080(String AMC080) {
        this.AMC080 = AMC080;
    }

    public String getAMC029() {
        return AMC029;
    }

    public void setAMC029(String AMC029) {
        this.AMC029 = AMC029;
    }

    public String getAMC081() {
        return AMC081;
    }

    public void setAMC081(String AMC081) {
        this.AMC081 = AMC081;
    }

    public String getAMC082() {
        return AMC082;
    }

    public void setAMC082(String AMC082) {
        this.AMC082 = AMC082;
    }

    public String getAMC083() {
        return AMC083;
    }

    public void setAMC083(String AMC083) {
        this.AMC083 = AMC083;
    }

    public String getAMC084() {
        return AMC084;
    }

    public void setAMC084(String AMC084) {
        this.AMC084 = AMC084;
    }

    public String getAMC085() {
        return AMC085;
    }

    public void setAMC085(String AMC085) {
        this.AMC085 = AMC085;
    }

    public String getAMC031() {
        return AMC031;
    }

    public void setAMC031(String AMC031) {
        this.AMC031 = AMC031;
    }

    public String getAMC067() {
        return AMC067;
    }

    public void setAMC067(String AMC067) {
        this.AMC067 = AMC067;
    }

    public String getAMC027() {
        return AMC027;
    }

    public void setAMC027(String AMC027) {
        this.AMC027 = AMC027;
    }

    public String getAMC028() {
        return AMC028;
    }

    public void setAMC028(String AMC028) {
        this.AMC028 = AMC028;
    }

    public String getAMC032() {
        return AMC032;
    }

    public void setAMC032(String AMC032) {
        this.AMC032 = AMC032;
    }

    public String getAMC088() {
        return AMC088;
    }

    public void setAMC088(String AMC088) {
        this.AMC088 = AMC088;
    }

    public String getAMC089() {
        return AMC089;
    }

    public void setAMC089(String AMC089) {
        this.AMC089 = AMC089;
    }

    public String getAMC090() {
        return AMC090;
    }

    public void setAMC090(String AMC090) {
        this.AMC090 = AMC090;
    }

    public String getAMC091() {
        return AMC091;
    }

    public void setAMC091(String AMC091) {
        this.AMC091 = AMC091;
    }

    public String getAMC092() {
        return AMC092;
    }

    public void setAMC092(String AMC092) {
        this.AMC092 = AMC092;
    }

    public String getAMC093() {
        return AMC093;
    }

    public void setAMC093(String AMC093) {
        this.AMC093 = AMC093;
    }

    public String getAMC094() {
        return AMC094;
    }

    public void setAMC094(String AMC094) {
        this.AMC094 = AMC094;
    }

    public String getAMC095() {
        return AMC095;
    }

    public void setAMC095(String AMC095) {
        this.AMC095 = AMC095;
    }

    public String getAMC096() {
        return AMC096;
    }

    public void setAMC096(String AMC096) {
        this.AMC096 = AMC096;
    }

    public String getBAD001() {
        return BAD001;
    }

    public void setBAD001(String BAD001) {
        this.BAD001 = BAD001;
    }

    public String getBAD002() {
        return BAD002;
    }

    public void setBAD002(String BAD002) {
        this.BAD002 = BAD002;
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

    public String getAIC331() {
        return AIC331;
    }

    public void setAIC331(String AIC331) {
        this.AIC331 = AIC331;
    }

    public String getAMC086() {
        return AMC086;
    }

    public void setAMC086(String AMC086) {
        this.AMC086 = AMC086;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getBAA001() {
        return BAA001;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public String getBAA006() {
        return BAA006;
    }

    public void setBAA006(String BAA006) {
        this.BAA006 = BAA006;
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

    public String getAMC097() {
        return AMC097;
    }

    public void setAMC097(String AMC097) {
        this.AMC097 = AMC097;
    }

    public String getAMC100() {
        return AMC100;
    }

    public void setAMC100(String AMC100) {
        this.AMC100 = AMC100;
    }

    public String getAMC101() {
        return AMC101;
    }

    public void setAMC101(String AMC101) {
        this.AMC101 = AMC101;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GsFertilityRecord that = (GsFertilityRecord) o;
        return Objects.equals(AAE170, that.AAE170) &&
                Objects.equals(BAA005, that.BAA005) &&
                Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
                Objects.equals(AMC033, that.AMC033) &&
                Objects.equals(AMC030, that.AMC030) &&
                Objects.equals(AMC060, that.AMC060) &&
                Objects.equals(AMC061, that.AMC061) &&
                Objects.equals(AMC062, that.AMC062) &&
                Objects.equals(AKB020, that.AKB020) &&
                Objects.equals(AAB001, that.AAB001) &&
                Objects.equals(AAE145, that.AAE145) &&
                Objects.equals(AMC078, that.AMC078) &&
                Objects.equals(AMC087, that.AMC087) &&
                Objects.equals(AMC020, that.AMC020) &&
                Objects.equals(AMC021, that.AMC021) &&
                Objects.equals(AMC022, that.AMC022) &&
                Objects.equals(AMC079, that.AMC079) &&
                Objects.equals(AMC023, that.AMC023) &&
                Objects.equals(AKC020, that.AKC020) &&
                Objects.equals(AMC026, that.AMC026) &&
                Objects.equals(AMC024, that.AMC024) &&
                Objects.equals(AMC080, that.AMC080) &&
                Objects.equals(AMC029, that.AMC029) &&
                Objects.equals(AMC081, that.AMC081) &&
                Objects.equals(AMC082, that.AMC082) &&
                Objects.equals(AMC083, that.AMC083) &&
                Objects.equals(AMC084, that.AMC084) &&
                Objects.equals(AMC085, that.AMC085) &&
                Objects.equals(AMC031, that.AMC031) &&
                Objects.equals(AMC067, that.AMC067) &&
                Objects.equals(AMC027, that.AMC027) &&
                Objects.equals(AMC028, that.AMC028) &&
                Objects.equals(AMC032, that.AMC032) &&
                Objects.equals(AMC088, that.AMC088) &&
                Objects.equals(AMC089, that.AMC089) &&
                Objects.equals(AMC090, that.AMC090) &&
                Objects.equals(AMC091, that.AMC091) &&
                Objects.equals(AMC092, that.AMC092) &&
                Objects.equals(AMC093, that.AMC093) &&
                Objects.equals(AMC094, that.AMC094) &&
                Objects.equals(AMC095, that.AMC095) &&
                Objects.equals(AMC096, that.AMC096) &&
                Objects.equals(BAD001, that.BAD001) &&
                Objects.equals(BAD002, that.BAD002) &&
                Objects.equals(AAE008, that.AAE008) &&
                Objects.equals(AAE010, that.AAE010) &&
                Objects.equals(AIC331, that.AIC331) &&
                Objects.equals(AMC086, that.AMC086) &&
                Objects.equals(AAB034, that.AAB034) &&
                Objects.equals(BAA001, that.BAA001) &&
                Objects.equals(BAA006, that.BAA006) &&
                Objects.equals(AAE011, that.AAE011) &&
                Objects.equals(AAE036, that.AAE036) &&
                Objects.equals(AMC097, that.AMC097) &&
                Objects.equals(AMC100, that.AMC100) &&
                Objects.equals(AMC101, that.AMC101);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAE170, BAA005, AAC001, AAC002, AAC003, AMC033, AMC030, AMC060, AMC061, AMC062, AKB020, AAB001, AAE145, AMC078, AMC087, AMC020, AMC021, AMC022, AMC079, AMC023, AKC020, AMC026, AMC024, AMC080, AMC029, AMC081, AMC082, AMC083, AMC084, AMC085, AMC031, AMC067, AMC027, AMC028, AMC032, AMC088, AMC089, AMC090, AMC091, AMC092, AMC093, AMC094, AMC095, AMC096, BAD001, BAD002, AAE008, AAE010, AIC331, AMC086, AAB034, BAA001, BAA006, AAE011, AAE036, AMC097, AMC100, AMC101);
    }
}
