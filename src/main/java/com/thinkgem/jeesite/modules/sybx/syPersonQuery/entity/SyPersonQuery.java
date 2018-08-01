package com.thinkgem.jeesite.modules.sybx.syPersonQuery.entity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:
 * 单位人员参保信息实体类
 *
 * @author X_P
 * @create 2018-04-09 15:32
 */
public class SyPersonQuery implements Serializable {

    private static final long serialVersionUID = -7657835406567286642L;
    /**
     * 缴费比例类别
     */
    private String aaa040;
    /**
     * 单位编号
     */
    private String aab001;
    /**
     * 单位名称
     */
    private String aab004;
    /**
     * 数据分区
     */
    private String aab034;
    /**
     * 个人编号
     */
    private String aac001;
    /**
     * 身份证号
     */
    private String aac002;
    /**
     * 姓名
     */
    private String aac003;
    /**
     * 性别
     */
    private String aac004;
    /**
     * 民族
     */
    private String aac005;
    /**
     * 出生日期
     */
    private String aac006;
    /**
     * 参加工作日期
     */
    private String aac007;
    /**
     * 户口性质
     */
    private String aac009;
    /**
     * 个人身份
     */
    private String aac012;
    /**
     * 用工形式
     */
    private String aac013;
    /**
     * 专业技术职务
     */
    private String aac014;
    /**
     * 工人技术等级
     */
    private String aac015;
    /**
     * 特殊工种标识
     */
    private String aac019;
    /**
     * 行政职务
     */
    private String aac020;
    /**
     * 参加保险时间
     */
    private String aac030;
    /**
     * 参保状态
     */
    private String aac031;
    /**
     * 缴费基数
     */
    private String aac040;
    /**
     * 经办人
     */
    private String aae011;
    /**
     * 经办时间
     */
    private String aae036;
    /**
     * 险种
     */
    private String aae140;
    /**
     * 数据分区
     */
    private String baa001;
    /**
     * 个人缴费基数
     */
    private String bac504;
    /**
     * 最近参保时间
     */
    private String bac510;
    /**
     * 档案出生日期
     */
    private String bic701;

    @Override
    public String toString() {
        return "SyPersonQuery{" +
                "aaa040='" + aaa040 + '\'' +
                ", aab001='" + aab001 + '\'' +
                ", aab004='" + aab004 + '\'' +
                ", aab034='" + aab034 + '\'' +
                ", aac001='" + aac001 + '\'' +
                ", aac002='" + aac002 + '\'' +
                ", aac003='" + aac003 + '\'' +
                ", aac004='" + aac004 + '\'' +
                ", aac005='" + aac005 + '\'' +
                ", aac006='" + aac006 + '\'' +
                ", aac007='" + aac007 + '\'' +
                ", aac009='" + aac009 + '\'' +
                ", aac012='" + aac012 + '\'' +
                ", aac013='" + aac013 + '\'' +
                ", aac014='" + aac014 + '\'' +
                ", aac015='" + aac015 + '\'' +
                ", aac019='" + aac019 + '\'' +
                ", aac020='" + aac020 + '\'' +
                ", aac030='" + aac030 + '\'' +
                ", aac031='" + aac031 + '\'' +
                ", aac040='" + aac040 + '\'' +
                ", aae011='" + aae011 + '\'' +
                ", aae036='" + aae036 + '\'' +
                ", aae140='" + aae140 + '\'' +
                ", baa001='" + baa001 + '\'' +
                ", bac504='" + bac504 + '\'' +
                ", bac510='" + bac510 + '\'' +
                ", bic701='" + bic701 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyPersonQuery that = (SyPersonQuery) o;
        return Objects.equals(aaa040, that.aaa040) &&
                Objects.equals(aab001, that.aab001) &&
                Objects.equals(aab004, that.aab004) &&
                Objects.equals(aab034, that.aab034) &&
                Objects.equals(aac001, that.aac001) &&
                Objects.equals(aac002, that.aac002) &&
                Objects.equals(aac003, that.aac003) &&
                Objects.equals(aac004, that.aac004) &&
                Objects.equals(aac005, that.aac005) &&
                Objects.equals(aac006, that.aac006) &&
                Objects.equals(aac007, that.aac007) &&
                Objects.equals(aac009, that.aac009) &&
                Objects.equals(aac012, that.aac012) &&
                Objects.equals(aac013, that.aac013) &&
                Objects.equals(aac014, that.aac014) &&
                Objects.equals(aac015, that.aac015) &&
                Objects.equals(aac019, that.aac019) &&
                Objects.equals(aac020, that.aac020) &&
                Objects.equals(aac030, that.aac030) &&
                Objects.equals(aac031, that.aac031) &&
                Objects.equals(aac040, that.aac040) &&
                Objects.equals(aae011, that.aae011) &&
                Objects.equals(aae036, that.aae036) &&
                Objects.equals(aae140, that.aae140) &&
                Objects.equals(baa001, that.baa001) &&
                Objects.equals(bac504, that.bac504) &&
                Objects.equals(bac510, that.bac510) &&
                Objects.equals(bic701, that.bic701);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aaa040, aab001, aab004, aab034, aac001, aac002, aac003, aac004, aac005, aac006, aac007, aac009, aac012, aac013, aac014, aac015, aac019, aac020, aac030, aac031, aac040, aae011, aae036, aae140, baa001, bac504, bac510, bic701);
    }
    @ExcelField(title="缴费比例类别",sort = 7)
    public String getAaa040() {
        return DictUtils.getDictLabel(aaa040,"AAA040_5","");
    }

    public void setAaa040(String aaa040) {
        this.aaa040 = aaa040;
    }

    public String getAab001() {
        return aab001;
    }

    public void setAab001(String aab001) {
        this.aab001 = aab001;
    }

    public String getAab004() {
        return aab004;
    }

    public void setAab004(String aab004) {
        this.aab004 = aab004;
    }

    public String getAab034() {
        return aab034;
    }

    public void setAab034(String aab034) {
        this.aab034 = aab034;
    }
    @ExcelField(title="个人编号",sort = 1)
    public String getAac001() {
        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }
    @ExcelField(title="身份证号",sort = 3)
    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }
    @ExcelField(title="姓名",sort = 2)
    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getAac004() {
        return aac004;
    }

    public void setAac004(String aac004) {
        this.aac004 = aac004;
    }

    public String getAac005() {
        return aac005;
    }

    public void setAac005(String aac005) {
        this.aac005 = aac005;
    }

    public String getAac006() {
        return aac006;
    }

    public void setAac006(String aac006) {
        this.aac006 = aac006;
    }

    public String getAac007() {
        return aac007;
    }

    public void setAac007(String aac007) {
        this.aac007 = aac007;
    }

    public String getAac009() {
        return aac009;
    }

    public void setAac009(String aac009) {
        this.aac009 = aac009;
    }

    public String getAac012() {
        return aac012;
    }

    public void setAac012(String aac012) {
        this.aac012 = aac012;
    }

    public String getAac013() {
        return aac013;
    }

    public void setAac013(String aac013) {
        this.aac013 = aac013;
    }

    public String getAac014() {
        return aac014;
    }

    public void setAac014(String aac014) {
        this.aac014 = aac014;
    }

    public String getAac015() {
        return aac015;
    }

    public void setAac015(String aac015) {
        this.aac015 = aac015;
    }

    public String getAac019() {
        return aac019;
    }

    public void setAac019(String aac019) {
        this.aac019 = aac019;
    }

    public String getAac020() {
        return aac020;
    }

    public void setAac020(String aac020) {
        this.aac020 = aac020;
    }
    @ExcelField(title="参加失业保险时间",sort = 4)
    public String getAac030() {
        return aac030;
    }

    public void setAac030(String aac030) {
        this.aac030 = aac030;
    }
    @ExcelField(title="参保状态",sort = 5)
    public String getAac031() {
        return DictUtils.getDictLabel(aac031,"AAC031_5","");
    }

    public void setAac031(String aac031) {
        this.aac031 = aac031;
    }
    @ExcelField(title="缴费基数",sort = 6)
    public String getAac040() {
        return aac040;
    }

    public void setAac040(String aac040) {
        this.aac040 = aac040;
    }

    public String getAae011() {
        return aae011;
    }

    public void setAae011(String aae011) {
        this.aae011 = aae011;
    }

    public String getAae036() {
        return aae036;
    }

    public void setAae036(String aae036) {
        this.aae036 = aae036;
    }

    public String getAae140() {
        return aae140;
    }

    public void setAae140(String aae140) {
        this.aae140 = aae140;
    }

    public String getBaa001() {
        return baa001;
    }

    public void setBaa001(String baa001) {
        this.baa001 = baa001;
    }

    public String getBac504() {
        return bac504;
    }

    public void setBac504(String bac504) {
        this.bac504 = bac504;
    }

    public String getBac510() {
        return bac510;
    }

    public void setBac510(String bac510) {
        this.bac510 = bac510;
    }

    public String getBic701() {
        return bic701;
    }

    public void setBic701(String bic701) {
        this.bic701 = bic701;
    }
}