package com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.entity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:
 * 应缴补基数信息实体
 *
 * @author X_P
 * @create 2018-04-08 12:02
 */
public class SyUnitRepairCheck implements Serializable {

    private static final long serialVersionUID = 183217326385026211L;

    /**
     * 个人编号
     */
    private String aac001;
    /**
     * 姓名
     */
    private String aac003;
    /**
     * 身份证号
     */
    private String aac002;
    /**
     * 费款所属期
     */
    private String aae002;
    /**
     * 缴费基数
     */
    private String bac504;
    /**
     * 单位缴费
     */
    private String aac127;
    /**
     * 个人缴费
     */
    private String aac123;
    /**
     * 缴费标志
     */
    private String aae114;
    /**
     * 缴费类别
     */
    private String aae143;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SyUnitRepairCheck that = (SyUnitRepairCheck) o;
        return Objects.equals(aac001, that.aac001) &&
                Objects.equals(aac003, that.aac003) &&
                Objects.equals(aac002, that.aac002) &&
                Objects.equals(aae002, that.aae002) &&
                Objects.equals(bac504, that.bac504) &&
                Objects.equals(aac127, that.aac127) &&
                Objects.equals(aac123, that.aac123) &&
                Objects.equals(aae114, that.aae114) &&
                Objects.equals(aae143, that.aae143);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aac001, aac003, aac002, aae002, bac504, aac127, aac123, aae114, aae143);
    }

    @Override
    public String toString() {
        return "SyUnitRepairCheck{" +
                "aac001='" + aac001 + '\'' +
                ", aac003='" + aac003 + '\'' +
                ", aac002='" + aac002 + '\'' +
                ", aae002='" + aae002 + '\'' +
                ", bac504='" + bac504 + '\'' +
                ", aac127='" + aac127 + '\'' +
                ", aac123='" + aac123 + '\'' +
                ", aae114='" + aae114 + '\'' +
                ", aae143='" + aae143 + '\'' +
                '}';
    }

    @ExcelField(title="个人编号",sort = 1)
    public String getAac001() {

        return aac001;
    }

    public void setAac001(String aac001) {
        this.aac001 = aac001;
    }

    @ExcelField(title="姓名",sort = 2)
    public String getAac003() {
        return aac003;
    }
    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    @ExcelField(title="身份证号码",align = 2,sort = 3)
    public String getAac002() {
        return aac002;
    }
    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    @ExcelField(title="缴费类别",sort = 4)
    public String getAae143() {
        return  DictUtils.getDictLabel(aae143, "AAE143_5", "");
    }

    public void setAae143(String aae143) {
        this.aae143 = aae143;
    }
    @ExcelField(title="费款所属期",sort = 5)
    public String getAae002() {
        return aae002;
    }

    public void setAae002(String aae002) {
        this.aae002 = aae002;
    }
    @ExcelField(title="缴费基数",sort = 6)
    public String getBac504() {
        return bac504;
    }

    public void setBac504(String bac504) {
        this.bac504 = bac504;
    }
    @ExcelField(title="单位缴费",sort = 7)
    public String getAac127() {
        return aac127;
    }

    public void setAac127(String aac127) {
        this.aac127 = aac127;
    }
    @ExcelField(title="个人缴费",sort = 8)
    public String getAac123() {
        return aac123;
    }

    public void setAac123(String aac123) {
        this.aac123 = aac123;
    }
    @ExcelField(title="缴费标志",sort = 9)
    public String getAae114() {
        return  DictUtils.getDictLabel(aae114, "AAE114_5", "");
    }

    public void setAae114(String aae114) {
        this.aae114 = aae114;
    }

}