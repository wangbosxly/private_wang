package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.Objects;
/**
 * 受理进度查询
 * @author sl_su
 */
public class GsScheduleQuery implements Serializable {

    private static final long serialVersionUID = -8414685744818554358L;
    private String Action;//	同步数据标志
    private String StartDate;//	开始时间
    private String EndDate;//	截止时间
    private String BAA001;//	数据分区
    private String SAA037;//	申请人
    private String SAA015;//	功能id
    private String BAE702;//	主体类型
    private String BAE703;//	主体编号
    private String SAA043;//	业务状态
    private String SAA080;//	服务机构ID
    private String SAA036;//	受理单id
    private String SAA004;//	事项id
    private String SAA031;//	表单模板id
    private String SAA024;//	法定期限
    private String SAA018;//	承诺时限
    private String SAA055;//	处理时间
    private String SAA041;//	受理时间
    private String SAA040;//	办结时间
    private String BUS_ID;//	业务id
    private String SZZ003;//	服务机构id
    private String SAA038;//	申请时间
    private String SAA017;//	申报名称
    private String AAB004;//	单位名称
    private String SAA042;//	受理状态
    private String AAB034;//	受理机构
    private String TAA103;//   审核结果

    public String getTAA103() {
        return TAA103;
    }

    public void setTAA103(String TAA103) {
        this.TAA103 = TAA103;
    }

    public String getSAA036() {
        return SAA036;
    }

    public void setSAA036(String SAA036) {
        this.SAA036 = SAA036;
    }

    public String getSAA004() {
        return SAA004;
    }

    public void setSAA004(String SAA004) {
        this.SAA004 = SAA004;
    }

    public String getSAA031() {
        return SAA031;
    }

    public void setSAA031(String SAA031) {
        this.SAA031 = SAA031;
    }

    public String getSAA024() {
        return SAA024;
    }

    public void setSAA024(String SAA024) {
        this.SAA024 = SAA024;
    }

    public String getSAA018() {
        return SAA018;
    }

    public void setSAA018(String SAA018) {
        this.SAA018 = SAA018;
    }

    public String getSAA055() {
        return SAA055;
    }

    public void setSAA055(String SAA055) {
        this.SAA055 = SAA055;
    }

    public String getSAA041() {
        return SAA041;
    }

    public void setSAA041(String SAA041) {
        this.SAA041 = SAA041;
    }

    public String getSAA040() {
        return SAA040;
    }

    public void setSAA040(String SAA040) {
        this.SAA040 = SAA040;
    }

    public String getBUS_ID() {
        return BUS_ID;
    }

    public void setBUS_ID(String BUS_ID) {
        this.BUS_ID = BUS_ID;
    }

    public String getSZZ003() {
        return SZZ003;
    }

    public void setSZZ003(String SZZ003) {
        this.SZZ003 = SZZ003;
    }

    public String getSAA038() {
        return SAA038;
    }

    public void setSAA038(String SAA038) {
        this.SAA038 = SAA038;
    }

    public String getSAA017() {
        return SAA017;
    }

    public void setSAA017(String SAA017) {
        this.SAA017 = SAA017;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getSAA042() {
        return SAA042;
    }

    public void setSAA042(String SAA042) {
        this.SAA042 = SAA042;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getBAA001() {
        return BAA001;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public String getSAA037() {
        return SAA037;
    }

    public void setSAA037(String SAA037) {
        this.SAA037 = SAA037;
    }

    public String getSAA015() {
        return SAA015;
    }

    public void setSAA015(String SAA015) {
        this.SAA015 = SAA015;
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

    public String getSAA080() {
        return SAA080;
    }

    public void setSAA080(String SAA080) {
        this.SAA080 = SAA080;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GsScheduleQuery that = (GsScheduleQuery) o;
        return Objects.equals(Action, that.Action) &&
                Objects.equals(StartDate, that.StartDate) &&
                Objects.equals(EndDate, that.EndDate) &&
                Objects.equals(BAA001, that.BAA001) &&
                Objects.equals(SAA037, that.SAA037) &&
                Objects.equals(SAA015, that.SAA015) &&
                Objects.equals(BAE702, that.BAE702) &&
                Objects.equals(BAE703, that.BAE703) &&
                Objects.equals(SAA043, that.SAA043) &&
                Objects.equals(SAA080, that.SAA080) &&
                Objects.equals(SAA036, that.SAA036) &&
                Objects.equals(SAA004, that.SAA004) &&
                Objects.equals(SAA031, that.SAA031) &&
                Objects.equals(SAA024, that.SAA024) &&
                Objects.equals(SAA018, that.SAA018) &&
                Objects.equals(SAA055, that.SAA055) &&
                Objects.equals(SAA041, that.SAA041) &&
                Objects.equals(SAA040, that.SAA040) &&
                Objects.equals(BUS_ID, that.BUS_ID) &&
                Objects.equals(SZZ003, that.SZZ003) &&
                Objects.equals(SAA038, that.SAA038) &&
                Objects.equals(SAA017, that.SAA017) &&
                Objects.equals(AAB004, that.AAB004) &&
                Objects.equals(SAA042, that.SAA042) &&
                Objects.equals(AAB034, that.AAB034);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Action, StartDate, EndDate, BAA001, SAA037, SAA015, BAE702, BAE703, SAA043, SAA080, SAA036, SAA004, SAA031, SAA024, SAA018, SAA055, SAA041, SAA040, BUS_ID, SZZ003, SAA038, SAA017, AAB004, SAA042, AAB034);
    }
}
