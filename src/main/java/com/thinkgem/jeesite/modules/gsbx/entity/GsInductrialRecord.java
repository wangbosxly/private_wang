package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 人员工伤信息备案
 * @author sl_su
 */
public class GsInductrialRecord implements Serializable {

    private static final long serialVersionUID = 5864756855636171823L;
    /** 操作人 */
    private String AAE170;
    /** 单位编号 */
    private String AAB001;
    /** 数据分区 */
    private String BAA001;
    /** 受理单号 */
    private String SAA036;
    /** 申报流水号 */
    private String BAE941;
    /** 个人编号 */
    private String AAC001;
    /** 身份证号 */
    private String AAC002;
    /** 姓名 */
    private String AAC003;
    /** 工伤发生日期 */
    private String ALC020;
    /** 工伤报告日期 */
    private String ALC203;
    /** 伤害程度 */
    private String ALC021;
    /** 报告方式 */
    private String ALC025;
    /** 工伤类别 */
    private String ALC027;
    /** 事故类别 */
    private String ALC207;
    /** 事故地点 */
    private String ALC023;
    /** 伤害部位 */
    private String ALC022;
    /** 报告人姓名 */
    private String ALC024;
    /** 报告人联系电话 */
    private String ALC605;
    /** 事故摘要 */
    private String ALC800;
    /** 是否定点医疗机构(默认非定点，0) */
    private String ALC626;
    /** 医疗机构名称 */
    private String AKB021;
    /** 申报时间 */
    private String TAA101;
    /** 对应费款所属期 */
    private String AAE003;
    /** 经办人 */
    private String AAE011;
    /** 经办时间 */
    private String AAE036;
    /** 申请人 */
    private String SAA037;
    /** 申请时间 */
    private String SAA038;
    /** 功能id */
    private String SAA015;
    /** 业务ID */
    private String BUS_ID;
    /** 表单模板id */
    private String SAA031;
    /** 事项id */
    private String SAA004;
    /** 主体类型 */
    private String BAE702;
    /** 主体编号 */
    private String BAE703;
    /** 业务状态 */
    private String SAA043;
    /** 服务机构ID */
    private String SZZ003;
    /** 审核结果 */
    private String TAA103;
    /** 申报来源 */
    private String TAA105;

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

    public String getAAC001() {
        return AAC001;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }

    public String getALC020() {
        return ALC020;
    }

    public void setALC020(String ALC020) {
        this.ALC020 = ALC020;
    }

    public String getALC203() {
        return ALC203;
    }

    public void setALC203(String ALC203) {
        this.ALC203 = ALC203;
    }

    public String getALC021() {
        return ALC021;
    }

    public void setALC021(String ALC021) {
        this.ALC021 = ALC021;
    }

    public String getALC025() {
        return ALC025;
    }

    public void setALC025(String ALC025) {
        this.ALC025 = ALC025;
    }

    public String getALC027() {
        return ALC027;
    }

    public void setALC027(String ALC027) {
        this.ALC027 = ALC027;
    }

    public String getALC207() {
        return ALC207;
    }

    public void setALC207(String ALC207) {
        this.ALC207 = ALC207;
    }

    public String getALC023() {
        return ALC023;
    }

    public void setALC023(String ALC023) {
        this.ALC023 = ALC023;
    }

    public String getALC022() {
        return ALC022;
    }

    public void setALC022(String ALC022) {
        this.ALC022 = ALC022;
    }

    public String getALC024() {
        return ALC024;
    }

    public void setALC024(String ALC024) {
        this.ALC024 = ALC024;
    }

    public String getALC605() {
        return ALC605;
    }

    public void setALC605(String ALC605) {
        this.ALC605 = ALC605;
    }

    public String getALC800() {
        return ALC800;
    }

    public void setALC800(String ALC800) {
        this.ALC800 = ALC800;
    }

    public String getALC626() {
        return ALC626;
    }

    public void setALC626(String ALC626) {
        this.ALC626 = ALC626;
    }

    public String getAKB021() {
        return AKB021;
    }

    public void setAKB021(String AKB021) {
        this.AKB021 = AKB021;
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
        GsInductrialRecord that = (GsInductrialRecord) o;
        return Objects.equals(AAE170, that.AAE170) &&
                Objects.equals(AAB001, that.AAB001) &&
                Objects.equals(BAA001, that.BAA001) &&
                Objects.equals(SAA036, that.SAA036) &&
                Objects.equals(BAE941, that.BAE941) &&
                Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
                Objects.equals(ALC020, that.ALC020) &&
                Objects.equals(ALC203, that.ALC203) &&
                Objects.equals(ALC021, that.ALC021) &&
                Objects.equals(ALC025, that.ALC025) &&
                Objects.equals(ALC027, that.ALC027) &&
                Objects.equals(ALC207, that.ALC207) &&
                Objects.equals(ALC023, that.ALC023) &&
                Objects.equals(ALC022, that.ALC022) &&
                Objects.equals(ALC024, that.ALC024) &&
                Objects.equals(ALC605, that.ALC605) &&
                Objects.equals(ALC800, that.ALC800) &&
                Objects.equals(ALC626, that.ALC626) &&
                Objects.equals(AKB021, that.AKB021) &&
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

        return Objects.hash(AAE170, AAB001, BAA001, SAA036, BAE941, AAC001, AAC002, AAC003, ALC020, ALC203, ALC021, ALC025, ALC027, ALC207, ALC023, ALC022, ALC024, ALC605, ALC800, ALC626, AKB021, TAA101, AAE003, AAE011, AAE036, SAA037, SAA038, SAA015, BUS_ID, SAA031, SAA004, BAE702, BAE703, SAA043, SZZ003, TAA103, TAA105);
    }
}
