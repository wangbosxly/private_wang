package com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheckByYear.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.util.Objects;

/**
 * 描述:
 * 单位年审实体类
 *
 * @author X_P
 * @create 2018-04-23 12:10
 */
public class SyUnitPaymentCheckByYear extends DataEntity<SyUnitPaymentCheckByYear> {

    private static final long serialVersionUID = -7225058046774305716L;
    /**
     * 单位编号
     */
    private String AAB001;
    /**
     * 单位名称
     */
    private String AAB004;

    /**
     * 审核年份
     */
    private String year;

    /**
     * 单位类型
     */
    private String AAB019;
    /**
     * 经济类型
     */
    private String AAB020;
    /**
     * 行业类型
     */
    private String AAB022;
    /**
     * 参保时间
     */
    private String AAB050;

    /**
     * 单位年审申请 1为上年已经做过  0为上年未做年审
     */
    private String BAA008;

    @Override
    public String toString() {
        return "SyUnitPaymentCheckByYear{" +
                "AAB001='" + AAB001 + '\'' +
                ", AAB004='" + AAB004 + '\'' +
                ", year='" + year + '\'' +
                ", AAB019='" + AAB019 + '\'' +
                ", AAB020='" + AAB020 + '\'' +
                ", AAB022='" + AAB022 + '\'' +
                ", AAB050='" + AAB050 + '\'' +
                '}';
    }

    public String getBAA008() {
        return BAA008;
    }

    public void setBAA008(String BAA008) {
        this.BAA008 = BAA008;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SyUnitPaymentCheckByYear that = (SyUnitPaymentCheckByYear) o;
        return Objects.equals(AAB001, that.AAB001) &&
                Objects.equals(AAB004, that.AAB004) &&
                Objects.equals(year, that.year) &&
                Objects.equals(AAB019, that.AAB019) &&
                Objects.equals(AAB020, that.AAB020) &&
                Objects.equals(AAB022, that.AAB022) &&
                Objects.equals(AAB050, that.AAB050);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAB001, AAB004, year, AAB019, AAB020, AAB022, AAB050);
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

    public String getAAB022() {
        return AAB022;
    }

    public void setAAB022(String AAB022) {
        this.AAB022 = AAB022;
    }

    public String getAAB050() {
        return AAB050;
    }

    public void setAAB050(String AAB050) {
        this.AAB050 = AAB050;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}