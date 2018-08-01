package com.thinkgem.jeesite.modules.ylbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 所有特殊业务
 */
public class SpecialBusiness implements Serializable {

    private static final long serialVersionUID = 5391723529233025540L;
    private String AAC001; //	个人编号
    private String AAC002; //	身份证号
    private String AAC003; //	姓名
    private String AKA120; //	病种编码
    private String AKA121; //	病种名称
    private String AAE011; //	经办人
    private String ISYD; //	是否异地安置人员（0 否 1 是）
    private String BKE003; //	有效开始日期
    private String BKE004; //	有效截止日期
    private String AAB001; //  单位编号
    private String AAB004; //  单位名称
    private String AAB005; //  单位电话
    private String AAE171; //  经办人
    private String AAE006; //	常驻外地详细地址
    private String BKC022; //	所在省（静态代码AA26_10）
    private String AKC040; //	所在市（静态代码AA26_10_482）
    private String BKB045; //	所在县/区（静态代码AA26_10_482_quxian）
    private String BKC021; //  常住外地原因
    private String AAE004; //  联系人
    private String AAE005; //  联系电话
    private String BKC020; //  门诊专用病历号
    private String AKB020; //  第一家医疗机构编号
    private String AKB021; //  第一家医院名称
    private String AKA101; //  第一家医院等级
    private String BKB011; //  第一家联系人
    private String BKB003; //  第一家联系电话
    private String BKB013; //  第一家地址
    private String BKB001; //  第二家医疗机构编号
    private String BKB002; //  第二家医院名称
    private String BKB005; //  第二家医院等级
    private String BKB006; //  第二家联系人
    private String BKB012; //  第二家联系电话
    private String BKB024; //  第二家地址
    private String BKB040; //  第三家医疗机构编号
    private String BKB041; //  第三家医院名称
    private String BKB042; //  第三家医院等级
    private String BKB044; //  第三家联系人
    private String BKB043; //  第三家联系电话
    private String BKB007; //  住地医保机构名称
    private String BKB008; //  住地医保机构联系电话
    private String BKB010; //  住地医保机构邮编
    private String BKB009; //  住地医保机构地址
    private String BAA001; //  行政区划
    private String BAC809; //  每页记录数

    public String getBAC809() {
        return BAC809;
    }

    public void setBAC809(String BAC809) {
        this.BAC809 = BAC809;
    }

    public String getBAA001() {
        return BAA001;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public String getAKB020() {
        return AKB020;
    }

    public void setAKB020(String AKB020) {
        this.AKB020 = AKB020;
    }

    public String getAKB021() {
        return AKB021;
    }

    public void setAKB021(String AKB021) {
        this.AKB021 = AKB021;
    }

    public String getAKA101() {
        return AKA101;
    }

    public void setAKA101(String AKA101) {
        this.AKA101 = AKA101;
    }

    public String getBKB011() {
        return BKB011;
    }

    public void setBKB011(String BKB011) {
        this.BKB011 = BKB011;
    }

    public String getBKB003() {
        return BKB003;
    }

    public void setBKB003(String BKB003) {
        this.BKB003 = BKB003;
    }

    public String getBKB013() {
        return BKB013;
    }

    public void setBKB013(String BKB013) {
        this.BKB013 = BKB013;
    }

    public String getBKB001() {
        return BKB001;
    }

    public void setBKB001(String BKB001) {
        this.BKB001 = BKB001;
    }

    public String getBKB002() {
        return BKB002;
    }

    public void setBKB002(String BKB002) {
        this.BKB002 = BKB002;
    }

    public String getBKB005() {
        return BKB005;
    }

    public void setBKB005(String BKB005) {
        this.BKB005 = BKB005;
    }

    public String getBKB006() {
        return BKB006;
    }

    public void setBKB006(String BKB006) {
        this.BKB006 = BKB006;
    }

    public String getBKB012() {
        return BKB012;
    }

    public void setBKB012(String BKB012) {
        this.BKB012 = BKB012;
    }

    public String getBKB024() {
        return BKB024;
    }

    public void setBKB024(String BKB024) {
        this.BKB024 = BKB024;
    }

    public String getBKB040() {
        return BKB040;
    }

    public void setBKB040(String BKB040) {
        this.BKB040 = BKB040;
    }

    public String getBKB041() {
        return BKB041;
    }

    public void setBKB041(String BKB041) {
        this.BKB041 = BKB041;
    }

    public String getBKB042() {
        return BKB042;
    }

    public void setBKB042(String BKB042) {
        this.BKB042 = BKB042;
    }

    public String getBKB044() {
        return BKB044;
    }

    public void setBKB044(String BKB044) {
        this.BKB044 = BKB044;
    }

    public String getBKB043() {
        return BKB043;
    }

    public void setBKB043(String BKB043) {
        this.BKB043 = BKB043;
    }

    public String getBKB007() {
        return BKB007;
    }

    public void setBKB007(String BKB007) {
        this.BKB007 = BKB007;
    }

    public String getBKB008() {
        return BKB008;
    }

    public void setBKB008(String BKB008) {
        this.BKB008 = BKB008;
    }

    public String getBKB010() {
        return BKB010;
    }

    public void setBKB010(String BKB010) {
        this.BKB010 = BKB010;
    }

    public String getBKB009() {
        return BKB009;
    }

    public void setBKB009(String BKB009) {
        this.BKB009 = BKB009;
    }

    public String getAAE004() {
        return AAE004;
    }

    public void setAAE004(String AAE004) {
        this.AAE004 = AAE004;
    }

    public String getAAE005() {
        return AAE005;
    }

    public void setAAE005(String AAE005) {
        this.AAE005 = AAE005;
    }

    public String getBKC020() {
        return BKC020;
    }

    public void setBKC020(String BKC020) {
        this.BKC020 = BKC020;
    }

    public String getBKC021() {
        return BKC021;
    }

    public void setBKC021(String BKC021) {
        this.BKC021 = BKC021;
    }

    public String getAAE006() {
        return AAE006;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public String getBKC022() {
        return BKC022;
    }

    public void setBKC022(String BKC022) {
        this.BKC022 = BKC022;
    }

    public String getAKC040() {
        return AKC040;
    }

    public void setAKC040(String AKC040) {
        this.AKC040 = AKC040;
    }

    public String getBKB045() {
        return BKB045;
    }

    public void setBKB045(String BKB045) {
        this.BKB045 = BKB045;
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

    public String getAKA120() {
        return AKA120;
    }

    public void setAKA120(String AKA120) {
        this.AKA120 = AKA120;
    }

    public String getAKA121() {
        return AKA121;
    }

    public void setAKA121(String AKA121) {
        this.AKA121 = AKA121;
    }

    public String getAAE011() {
        return AAE011;
    }

    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    public String getISYD() {
        return ISYD;
    }

    public void setISYD(String ISYD) {
        this.ISYD = ISYD;
    }

    public String getBKE003() {
        return BKE003;
    }

    public void setBKE003(String BKE003) {
        this.BKE003 = BKE003;
    }

    public String getBKE004() {
        return BKE004;
    }

    public void setBKE004(String BKE004) {
        this.BKE004 = BKE004;
    }

    public String getAAB005() {
        return AAB005;
    }

    public void setAAB005(String AAB005) {
        this.AAB005 = AAB005;
    }

    public String getAAE171() {
        return AAE171;
    }

    public void setAAE171(String AAE171) {
        this.AAE171 = AAE171;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialBusiness that = (SpecialBusiness) o;
        return Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
                Objects.equals(AKA120, that.AKA120) &&
                Objects.equals(AKA121, that.AKA121) &&
                Objects.equals(AAE011, that.AAE011) &&
                Objects.equals(ISYD, that.ISYD) &&
                Objects.equals(BKE003, that.BKE003) &&
                Objects.equals(BKE004, that.BKE004) &&
                Objects.equals(AAB005, that.AAB005) &&
                Objects.equals(AAE171, that.AAE171);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAC001, AAC002, AAC003, AKA120, AKA121, AAE011, ISYD, BKE003, BKE004, AAB005, AAE171);
    }
}
