package com.thinkgem.jeesite.modules.gsbx.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 描述:
 * 人员停保实体类
 *
 * @author X_P
 * @create 2018-06-07 9:18
 */
public class GsPersonStopProtect implements Serializable {

    private static final long serialVersionUID = -581807502811612250L;

    @JSONField(name = "aAC001") //个人编号
    private String AAC001;
    @JSONField(name = "aAC002")//身份证号
    private String AAC002;
    @JSONField(name = "aAC003")//姓名
    private String AAC003;
    @JSONField(name = "aAE160")//停保原因
    private String AAE160;
    @JSONField(name = "Cdate")//批量停保日期
    private String cdate;

    public String getAAC001() {
        return AAC001;
    }

    public String getAAC002() {
        return AAC002;
    }

    public String getAAC003() {
        return AAC003;
    }

    public String getAAE160() {
        return AAE160;
    }

    public String getCdate() {
        return cdate;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }

    public void setAAE160(String AAE160) {
        this.AAE160 = AAE160;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}