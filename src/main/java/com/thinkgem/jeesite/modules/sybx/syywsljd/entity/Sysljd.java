package com.thinkgem.jeesite.modules.sybx.syywsljd.entity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;

/**
 * @author svnlei
 * @date 2018/4/23
 * 导出失业受理进度
 */
public class Sysljd implements Serializable {

    private static final long serialVersionUID = 1L;

    private String SAA036;//受理单号
    private String AAC001;//个人编号
    private String AAC003;//姓名
    private String AAC002;//身份证
    private String AAE003;//费款所属期
    private String TAA101;//申报时间
    private String TAA103;//申报结果
    private String TAA104;//未通过原因

    @ExcelField(title="受理单号", sort=1)
    public String getSAA036() {
        return SAA036;
    }

    @ExcelField(title="个人编号", sort=2)
    public String getAAC001() {
        return AAC001;
    }

    @ExcelField(title="姓名", sort=3)
    public String getAAC003() {
        return AAC003;
    }

    @ExcelField(title="身份证号", sort=4)
    public String getAAC002() {
        return AAC002;
    }

    @ExcelField(title="费款所属期", sort=5)
    public String getAAE003() {
        return AAE003;
    }

    @ExcelField(title="申报时间", sort=6)
    public String getTAA101() {
        return TAA101;
    }

    public String getTAA103() {
        return TAA103;
    }

    @ExcelField(title="未通过原因", sort=7)
    public String getTAA104() {
        return TAA104;
    }

    public void setSAA036(String SAA036) {
        this.SAA036 = SAA036;
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

    public void setAAE003(String AAE003) {
        this.AAE003 = AAE003;
    }

    public void setTAA101(String TAA101) {
        this.TAA101 = TAA101;
    }

    public void setTAA103(String TAA103) {
        this.TAA103 = TAA103;
    }

    public void setTAA104(String TAA104) {
        this.TAA104 = TAA104;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sysljd sysljd = (Sysljd) o;

        if (SAA036 != null ? !SAA036.equals(sysljd.SAA036) : sysljd.SAA036 != null) return false;
        if (AAC001 != null ? !AAC001.equals(sysljd.AAC001) : sysljd.AAC001 != null) return false;
        if (AAC003 != null ? !AAC003.equals(sysljd.AAC003) : sysljd.AAC003 != null) return false;
        if (AAC002 != null ? !AAC002.equals(sysljd.AAC002) : sysljd.AAC002 != null) return false;
        if (AAE003 != null ? !AAE003.equals(sysljd.AAE003) : sysljd.AAE003 != null) return false;
        if (TAA101 != null ? !TAA101.equals(sysljd.TAA101) : sysljd.TAA101 != null) return false;
        if (TAA103 != null ? !TAA103.equals(sysljd.TAA103) : sysljd.TAA103 != null) return false;
        return TAA104 != null ? TAA104.equals(sysljd.TAA104) : sysljd.TAA104 == null;
    }

    @Override
    public int hashCode() {
        int result = SAA036 != null ? SAA036.hashCode() : 0;
        result = 31 * result + (AAC001 != null ? AAC001.hashCode() : 0);
        result = 31 * result + (AAC003 != null ? AAC003.hashCode() : 0);
        result = 31 * result + (AAC002 != null ? AAC002.hashCode() : 0);
        result = 31 * result + (AAE003 != null ? AAE003.hashCode() : 0);
        result = 31 * result + (TAA101 != null ? TAA101.hashCode() : 0);
        result = 31 * result + (TAA103 != null ? TAA103.hashCode() : 0);
        result = 31 * result + (TAA104 != null ? TAA104.hashCode() : 0);
        return result;
    }
}


