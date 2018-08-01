package com.thinkgem.jeesite.modules.sybx.sywgbt.entity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

/**
 * 导出Excel 模板
 *
 * @author svnlei
 * @date 2018/4/3
 */
public class SyWgbt implements Serializable {
    private static final long serialVersionUID = 1L;

    private String AAC001;// 组织人员编号
    private String AAC003;//姓名
    private String AAC002;//身份证
    private String BJC408;//养老保险补贴
    private String BJC409;//医疗保险补贴
    private String BJC410;//失业保险补贴
    private String BJC411;//生活补贴/岗位补贴
    private String BJC400;//转岗培训补贴
    private String BJC403;//技能提升培训补贴
    private String AAE030;//培训/申报日期
    private String TAA104;//错误原因
    private String BJB003;//补贴类别

    @Override
    public String toString() {
        return "SyWgbt{" +
                "AAC001='" + AAC001 + '\'' +
                ", AAC003='" + AAC003 + '\'' +
                ", AAC002='" + AAC002 + '\'' +
                ", BJC408='" + BJC408 + '\'' +
                ", BJC409='" + BJC409 + '\'' +
                ", BJC410='" + BJC410 + '\'' +
                ", BJC411='" + BJC411 + '\'' +
                ", BJC400='" + BJC400 + '\'' +
                ", BJC403='" + BJC403 + '\'' +
                ", AAE030='" + AAE030 + '\'' +
                ", TAA104='" + TAA104 + '\'' +
                ", BJB003='" + BJB003 + '\'' +
                '}';
    }

    public String getBJB003() {
        return BJB003;
    }

    public void setBJB003(String BJB003) {
        this.BJB003 = BJB003;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }

    public void setBJC408(String BJC408) {
        this.BJC408 = BJC408;
    }

    public void setBJC409(String BJC409) {
        this.BJC409 = BJC409;
    }

    public void setBJC410(String BJC410) {
        this.BJC410 = BJC410;
    }

    public void setBJC411(String BJC411) {
        this.BJC411 = BJC411;
    }

    public void setBJC400(String BJC400) {
        this.BJC400 = BJC400;
    }

    public void setBJC403(String BJC403) {
        this.BJC403 = BJC403;
    }

    public void setAAE030(String AAE030) {
        this.AAE030 = AAE030;
    }

    public void setTAA104(String TAA104) {
        this.TAA104 = TAA104;
    }

    @ExcelField(title="个人编号", sort=1, groups = {1, 2})
    public String getAAC001() {
        return AAC001;
    }
    @ExcelField(title="姓名", sort=2, groups = {1, 2})
    public String getAAC003() {
        return AAC003;
    }
    @ExcelField(title="身份证号码", sort=3, groups = {1, 2})
    public String getAAC002() {
        return AAC002;
    }
    @ExcelField(title="培训/申报日期", sort=4, groups = {1, 2})
    public String getAAE030() {
        return AAE030;
    }
    @ExcelField(title="养老保险补贴", sort=5, groups = {1, 2})
    public String getBJC408() {
        return BJC408;
    }
    @ExcelField(title="医疗保险补贴", sort=6, groups = {1, 2})
    public String getBJC409() {
        return BJC409;
    }
    @ExcelField(title="失业保险补贴", sort=7, groups = {1, 2})
    public String getBJC410() {
        return BJC410;
    }
    @ExcelField(title="生活补贴/岗位补贴", sort=8, groups = {1, 2})
    public String getBJC411() {
        return BJC411;
    }
    @ExcelField(title="转岗培训补贴", sort=9, groups = {1, 2})
    public String getBJC400() {
        return BJC400;
    }
    @ExcelField(title="技能提升培训补贴", sort=10, groups = {1, 2})
    public String getBJC403() {
        return BJC403;
    }
    @ExcelField(title="错误原因", sort=11, groups = 2)
    public String getTAA104() {
        return TAA104;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SyWgbt syWgbt = (SyWgbt) o;

        if (!AAC001.equals(syWgbt.AAC001)) return false;
        if (!AAC003.equals(syWgbt.AAC003)) return false;
        if (!AAC002.equals(syWgbt.AAC002)) return false;
        if (!BJC408.equals(syWgbt.BJC408)) return false;
        if (!BJC409.equals(syWgbt.BJC409)) return false;
        if (!BJC410.equals(syWgbt.BJC410)) return false;
        if (!BJC411.equals(syWgbt.BJC411)) return false;
        if (!BJC400.equals(syWgbt.BJC400)) return false;
        if (!BJC403.equals(syWgbt.BJC403)) return false;
        return AAE030.equals(syWgbt.AAE030);
    }

    @Override
    public int hashCode() {
        int result = AAC001.hashCode();
        result = 31 * result + AAC003.hashCode();
        result = 31 * result + AAC002.hashCode();
        result = 31 * result + BJC408.hashCode();
        result = 31 * result + BJC409.hashCode();
        result = 31 * result + BJC410.hashCode();
        result = 31 * result + BJC411.hashCode();
        result = 31 * result + BJC400.hashCode();
        result = 31 * result + BJC403.hashCode();
        result = 31 * result + AAE030.hashCode();
        return result;
    }
}
