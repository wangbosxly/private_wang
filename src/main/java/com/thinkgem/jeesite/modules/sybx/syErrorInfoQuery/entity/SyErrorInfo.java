package com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.entity;

import java.util.Objects;

/**
 * 描述:
 * 错误信息核查的实体类
 *
 * @author X_P
 * @create 2018-03-16 15:41
 */
public class SyErrorInfo {

    /**
     * 个人编号
     */
    private String AAC001;

    /**
     * 身份证号
     */
    private String AAC002;
    /**
     * 姓名
     */
    private String AAC003;

    /**
     * 错误原因
     */
    private String AAE013;

    /**
     * 错误类型（0表示全部 1-5表示5种状态）
     */
    private String CODE_TYPE;

    @Override
    public String toString() {
        return "SyErrorInfo{" +
                "AAC001='" + AAC001 + '\'' +
                ", AAC002='" + AAC002 + '\'' +
                ", AAC003='" + AAC003 + '\'' +
                ", AAE013='" + AAE013 + '\'' +
                ", CODE_TYPE='" + CODE_TYPE + '\'' +
                '}';
    }

    public String getCODE_TYPE() {
        return CODE_TYPE;
    }

    public void setCODE_TYPE(String CODE_TYPE) {
        this.CODE_TYPE = CODE_TYPE;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SyErrorInfo that = (SyErrorInfo) o;
        return Objects.equals(AAC001, that.AAC001) &&
                Objects.equals(AAC002, that.AAC002) &&
                Objects.equals(AAC003, that.AAC003) &&
                Objects.equals(AAE013, that.AAE013);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAC001, AAC002, AAC003, AAE013);
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

    public String getAAE013() {
        return AAE013;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }

}