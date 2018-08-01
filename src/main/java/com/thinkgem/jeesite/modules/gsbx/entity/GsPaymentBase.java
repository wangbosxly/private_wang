package com.thinkgem.jeesite.modules.gsbx.entity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author sl_su
 */
public class GsPaymentBase implements Serializable {

    private static final long serialVersionUID = -1232854802400033028L;
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
    /** 险种 */
    private String AAE140;
    /** 开始年月 */
    private String AAE030;
    /** 工资 */
    private String AAC040;
    /** 个人缴费基数 */
    private String BAC504;
    /** 身份证 */
    private String AAC002;
    /** 姓名 */
    private String AAC003;
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
    /** 参保时间 */
    private String AAC030;
    @ExcelField(title="参保时间",sort = 4)
    public String getAAC030() {
        return AAC030;
    }

    public void setAAC030(String AAC030) {
        this.AAC030 = AAC030;
    }

    public String getAAE170() {
        return AAE170;
    }

    public void setAAE170(String AAE170) {
        this.AAE170 = AAE170;
    }
    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }

    public String getAAB001() {
        return AAB001;
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
    @ExcelField(title="个人编号")
    public String getAAC001() {
        return AAC001;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }
    @ExcelField(title="险种类型(4 工伤,5 生育)",sort = 6)
    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }
    @ExcelField(title="申报时间",sort = 3)
    public String getAAE030() {
        return AAE030;
    }

    public void setAAE030(String AAE030) {
        this.AAE030 = AAE030;
    }

    public String getAAC040() {
        return AAC040;
    }

    public void setAAC040(String AAC040) {
        this.AAC040 = AAC040;
    }
    @ExcelField(title="缴费基数",sort = 5)
    public String getBAC504() {
        return BAC504;
    }

    public void setBAC504(String BAC504) {
        this.BAC504 = BAC504;
    }
    @ExcelField(title="身份证号",sort = 2)
    public String getAAC002() {
        return AAC002;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }
    @ExcelField(title="姓名",sort = 1)
    public String getAAC003() {
        return AAC003;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
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
        GsPaymentBase that = (GsPaymentBase) o;
        return Objects.equals(AAE170, that.AAE170) &&
                Objects.equals(AAB001, that.AAB001) &&
                Objects.equals(BAA001, that.BAA001) &&
                Objects.equals(SAA036, that.SAA036) &&
                Objects.equals(BAE941, that.BAE941) &&
                Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAE140, that.AAE140) &&
                Objects.equals(AAE030, that.AAE030) &&
                Objects.equals(AAC040, that.AAC040) &&
                Objects.equals(BAC504, that.BAC504) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
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

        return Objects.hash(AAE170, AAB001, BAA001, SAA036, BAE941, AAC001, AAE140, AAE030, AAC040, BAC504, AAC002, AAC003, TAA101, AAE003, AAE011, AAE036, SAA037, SAA038, SAA015, BUS_ID, SAA031, SAA004, BAE702, BAE703, SAA043, SZZ003, TAA103, TAA105);
    }
}
