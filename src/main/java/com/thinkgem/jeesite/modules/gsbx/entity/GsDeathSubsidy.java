package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 一次性工亡补助金
 * @author sl_su
 */
public class GsDeathSubsidy implements Serializable {

    private static final long serialVersionUID = 5518389939482425272L;

    /** 操作人*/
    private String AAE170;
    /** 单位编号*/
    private String AAB001;
    /** 数据分区*/
    private String BAA001;
    /** 个人编号*/
    private String AAC001;
    /** 身份证号*/
    private String AAC002;
    /** 姓名*/
    private String AAC003;
    /** 工伤伤申号*/
    private String ALC150;
    /** 单位名称*/
    private String AAB004;
    /** 工伤发生日期*/
    private String ALC020;
    /** 因工死亡时间*/
    private String ALC040;
    /** 死亡原因*/
    private String BAA021;
    /** 1-4级死亡标志*/
    private String ALC456;
    /** 工伤类别*/
    private String ALC027;
    /** 伤害程度*/
    private String ALC021;
    /** 上年全国城镇居民人均可支配收入*/
    private String AAA011;
    /** 一次性工亡补助金月*/
    private String BLC005;
    /**	一次性工亡补助金*/
    private String ALC115_1;
    /**	丧葬补助金*/
    private String ALC115_0;
    /** 上年社平工资*/
    private String AAA010;
    /** 丧葬补助金支付月*/
    private String BLC004;
    /** 受理单号*/
    private String SAA036;
    /** 申报流水号*/
    private String BAE941;
    /** 一次性待遇金额*/
    private String ALC070;
    /** 工伤待遇类别*/
    private String ALC601;
    /** 费款所属期*/
    private String AAE002;
    /** 申报时间*/
    private String TAA101;
    /** 对应费款所属期*/
    private String AAE003;
    /** 经办人*/
    private String AAE011;
    /** 经办时间*/
    private String AAE036;
    /** 申请人*/
    private String SAA037;
    /** 申请时间*/
    private String SAA038;
    /** 功能id*/
    private String SAA015;
    /** 业务ID*/
    private String BUS_ID;
    /** 表单模板id*/
    private String SAA031;
    /** 事项id*/
    private String SAA004;
    /** 主体类型*/
    private String BAE702;
    /** 主体编号*/
    private String BAE703;
    /** 业务状态*/
    private String SAA043;
    /** 服务机构ID*/
    private String SZZ003;
    /** 审核结果*/
    private String TAA103;
    /** 申报来源*/
    private String TAA105;
    /** 工伤认定时间*/
    private String ALC031;

    public String getALC031() {
        return ALC031;
    }

    public void setALC031(String ALC031) {
        this.ALC031 = ALC031;
    }
    public String getALC115_0() {
        return ALC115_0;
    }

    public void setALC115_0(String ALC115_0) {
        this.ALC115_0 = ALC115_0;
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

    public String getALC150() {
        return ALC150;
    }

    public void setALC150(String ALC150) {
        this.ALC150 = ALC150;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getALC020() {
        return ALC020;
    }

    public void setALC020(String ALC020) {
        this.ALC020 = ALC020;
    }

    public String getALC040() {
        return ALC040;
    }

    public void setALC040(String ALC040) {
        this.ALC040 = ALC040;
    }

    public String getBAA021() {
        return BAA021;
    }

    public void setBAA021(String BAA021) {
        this.BAA021 = BAA021;
    }

    public String getALC456() {
        return ALC456;
    }

    public void setALC456(String ALC456) {
        this.ALC456 = ALC456;
    }

    public String getALC027() {
        return ALC027;
    }

    public void setALC027(String ALC027) {
        this.ALC027 = ALC027;
    }

    public String getALC021() {
        return ALC021;
    }

    public void setALC021(String ALC021) {
        this.ALC021 = ALC021;
    }

    public String getAAA011() {
        return AAA011;
    }

    public void setAAA011(String AAA011) {
        this.AAA011 = AAA011;
    }

    public String getBLC005() {
        return BLC005;
    }

    public void setBLC005(String BLC005) {
        this.BLC005 = BLC005;
    }

    public String getALC115_1() {
        return ALC115_1;
    }

    public void setALC115_1(String ALC115_1) {
        this.ALC115_1 = ALC115_1;
    }

    public String getAAA010() {
        return AAA010;
    }

    public void setAAA010(String AAA010) {
        this.AAA010 = AAA010;
    }

    public String getBLC004() {
        return BLC004;
    }

    public void setBLC004(String BLC004) {
        this.BLC004 = BLC004;
    }

    public String getSAA036() {
        return SAA036;
    }

    public void setSAA036(String SAA036) {
        this.SAA036 = SAA036;
    }

    public String getBAE941() {
        return BAE941;
    }

    public void setBAE941(String BAE941) {
        this.BAE941 = BAE941;
    }

    public String getALC070() {
        return ALC070;
    }

    public void setALC070(String ALC070) {
        this.ALC070 = ALC070;
    }

    public String getALC601() {
        return ALC601;
    }

    public void setALC601(String ALC601) {
        this.ALC601 = ALC601;
    }

    public String getAAE002() {
        return AAE002;
    }

    public void setAAE002(String AAE002) {
        this.AAE002 = AAE002;
    }

    public String getTAA101() {
        return TAA101;
    }

    public void setTAA101(String TAA101) {
        this.TAA101 = TAA101;
    }

    public String getAAE003() {
        return AAE003;
    }

    public void setAAE003(String AAE003) {
        this.AAE003 = AAE003;
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

    public String getSAA037() {
        return SAA037;
    }

    public void setSAA037(String SAA037) {
        this.SAA037 = SAA037;
    }

    public String getSAA038() {
        return SAA038;
    }

    public void setSAA038(String SAA038) {
        this.SAA038 = SAA038;
    }

    public String getSAA015() {
        return SAA015;
    }

    public void setSAA015(String SAA015) {
        this.SAA015 = SAA015;
    }

    public String getBUS_ID() {
        return BUS_ID;
    }

    public void setBUS_ID(String BUS_ID) {
        this.BUS_ID = BUS_ID;
    }

    public String getSAA031() {
        return SAA031;
    }

    public void setSAA031(String SAA031) {
        this.SAA031 = SAA031;
    }

    public String getSAA004() {
        return SAA004;
    }

    public void setSAA004(String SAA004) {
        this.SAA004 = SAA004;
    }

    public String getBAE702() {
        return BAE702;
    }

    public void setBAE702(String BAE702) {
        this.BAE702 = BAE702;
    }

    public String getBAE703() {
        return BAE703;
    }

    public void setBAE703(String BAE703) {
        this.BAE703 = BAE703;
    }

    public String getSAA043() {
        return SAA043;
    }

    public void setSAA043(String SAA043) {
        this.SAA043 = SAA043;
    }

    public String getSZZ003() {
        return SZZ003;
    }

    public void setSZZ003(String SZZ003) {
        this.SZZ003 = SZZ003;
    }

    public String getTAA103() {
        return TAA103;
    }

    public void setTAA103(String TAA103) {
        this.TAA103 = TAA103;
    }

    public String getTAA105() {
        return TAA105;
    }

    public void setTAA105(String TAA105) {
        this.TAA105 = TAA105;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GsDeathSubsidy that = (GsDeathSubsidy) o;
        return Objects.equals(AAE170, that.AAE170) &&
                Objects.equals(AAB001, that.AAB001) &&
                Objects.equals(BAA001, that.BAA001) &&
                Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
                Objects.equals(ALC150, that.ALC150) &&
                Objects.equals(AAB004, that.AAB004) &&
                Objects.equals(ALC020, that.ALC020) &&
                Objects.equals(ALC040, that.ALC040) &&
                Objects.equals(BAA021, that.BAA021) &&
                Objects.equals(ALC456, that.ALC456) &&
                Objects.equals(ALC027, that.ALC027) &&
                Objects.equals(ALC021, that.ALC021) &&
                Objects.equals(AAA011, that.AAA011) &&
                Objects.equals(BLC005, that.BLC005) &&
                Objects.equals(ALC115_1, that.ALC115_1) &&
                Objects.equals(AAA010, that.AAA010) &&
                Objects.equals(BLC004, that.BLC004) &&
                Objects.equals(SAA036, that.SAA036) &&
                Objects.equals(BAE941, that.BAE941) &&
                Objects.equals(ALC070, that.ALC070) &&
                Objects.equals(ALC601, that.ALC601) &&
                Objects.equals(AAE002, that.AAE002) &&
                Objects.equals(TAA101, that.TAA101) &&
                Objects.equals(AAE003, that.AAE003) &&
                Objects.equals(AAE011, that.AAE011) &&
                Objects.equals(AAE036, that.AAE036) &&
                Objects.equals(SAA037, that.SAA037) &&
                Objects.equals(SAA038, that.SAA038) &&
                Objects.equals(SAA015, that.SAA015) &&
                Objects.equals(BUS_ID, that.BUS_ID) &&
                Objects.equals(SAA031, that.SAA031) &&
                Objects.equals(SAA004, that.SAA004) &&
                Objects.equals(BAE702, that.BAE702) &&
                Objects.equals(BAE703, that.BAE703) &&
                Objects.equals(SAA043, that.SAA043) &&
                Objects.equals(SZZ003, that.SZZ003) &&
                Objects.equals(TAA103, that.TAA103) &&
                Objects.equals(TAA105, that.TAA105);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAE170, AAB001, BAA001, AAC001, AAC002, AAC003, ALC150, AAB004, ALC020, ALC040, BAA021, ALC456, ALC027, ALC021, AAA011, BLC005, ALC115_1, AAA010, BLC004, SAA036, BAE941, ALC070, ALC601, AAE002, TAA101, AAE003, AAE011, AAE036, SAA037, SAA038, SAA015, BUS_ID, SAA031, SAA004, BAE702, BAE703, SAA043, SZZ003, TAA103, TAA105);
    }
}
