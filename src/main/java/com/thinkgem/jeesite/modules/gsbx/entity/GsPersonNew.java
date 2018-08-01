package com.thinkgem.jeesite.modules.gsbx.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 描述:
 * 人员新参保实体类
 *
 * @author X_P
 * @create 2018-06-05 17:33
 */
public class GsPersonNew  implements Serializable{

    private static final long serialVersionUID = -3598495781639341606L;

    @JSONField(name = "bAA001")
    private String BAA001;//数据分区
    @JSONField(name = "aAB001")
    private String AAB001;//单位编号
    @JSONField(name = "aAB004")
    private String AAB004;//单位名称
    @JSONField(name = "aAC002")
    private String AAC002;//身份证号
    @JSONField(name = "aAC003")
    private String AAC003;//姓名
    @JSONField(name = "bIC701")
    private String BIC701;//档案出生日期
    @JSONField(name = "aAC006")
    private String AAC006;//出生日期
    @JSONField(name = "aAC004")
    private String AAC004;//性别
    @JSONField(name = "aAC005")
    private String AAC005;//民族
    @JSONField(name = "aAC007")
    private String AAC007;//参加工作日期
    @JSONField(name = "aAC009")
    private String AAC009;//户口性质
    @JSONField(name = "aAC019")
    private String AAC019;//是否特殊工种
    @JSONField(name = "aAC020")
    private String AAC020;//行政职务
    @JSONField(name = "aAC015")
    private String AAC015;//工人技术等级
    @JSONField(name = "bAC521")
    private String BAC521;//高级技术职务类型
    @JSONField(name = "aAC017")
    private String AAC017;//婚姻状况
    @JSONField(name = "aAC013")
    private String AAC013;//用工形式
    @JSONField(name = "aAC012")
    private String AAC012;//个人身份
    @JSONField(name = "aAC011")
    private String AAC011;//文化程度
    @JSONField(name = "aAE005")
    private String AAE005;//联系电话
    @JSONField(name = "aAE007")
    private String AAE007;//邮政编码
    @JSONField(name = "aAC040")
    private String AAC040;//缴费工资
    @JSONField(name = "aAC010")
    private String AAC010;//户口所在地
    @JSONField(name = "bAC501")
    private String BAC501;//邮件地址
    @JSONField(name = "aAC030")
    private String AAC030;//参保时间
    @JSONField(name = "aAA040")
    private String AAA040;//缴费比例类别
    @JSONField(name = "aAE006")
    private String AAE006;//地址
    @JSONField(name = "aAE013")
    private String AAE013;//备注
    @JSONField(name = "aAC014")
    private String AAC014;//专业技术职务

    public String getAAC017() {
        return AAC017;
    }

    public String getAAC014() {
        return AAC014;
    }
    public String getBAA001() {
        return BAA001;
    }

    @NotNull(message = "单位编号不能为空")
    public String getAAB001() {
        return AAB001;
    }

    @NotNull(message = "单位名称不能为空")
    public String getAAB004() {
        return AAB004;
    }

    @Length(min = 18,max = 18,message = "请输入18位身份证号码")
    public String getAAC002() {
        return AAC002;
    }

    public String getAAC003() {
        return AAC003;
    }

    public String getBIC701() {
        return BIC701;
    }

    public String getAAC006() {
        return AAC006;
    }

    public String getAAC004() {
        return AAC004;
    }

    public String getAAC005() {
        return AAC005;
    }

    public String getAAC007() {
        return AAC007;
    }

    public String getAAC009() {
        return AAC009;
    }

    public String getAAC019() {
        return AAC019;
    }

    public String getAAC020() {
        return AAC020;
    }

    public String getAAC015() {
        return AAC015;
    }

    public String getBAC521() {
        return BAC521;
    }

    public String getAAC013() {
        return AAC013;
    }

    public String getAAC012() {
        return AAC012;
    }

    public String getAAC011() {
        return AAC011;
    }

    public String getAAE005() {
        return AAE005;
    }

    public String getAAE007() {
        return AAE007;
    }

    public String getAAC040() {
        return AAC040;
    }

    public String getAAC010() {
        return AAC010;
    }

    public String getBAC501() {
        return BAC501;
    }

    public String getAAC030() {
        return AAC030;
    }

    public String getAAA040() {
        return AAA040;
    }

    public String getAAE006() {
        return AAE006;
    }

    public String getAAE013() {
        return AAE013;
    }

    public void setAAC017(String AAC017) {
        this.AAC017 = AAC017;
    }

    public void setAAC014(String AAC014) {
        this.AAC014 = AAC014;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }

    public void setBIC701(String BIC701) {
        this.BIC701 = BIC701;
    }

    public void setAAC006(String AAC006) {
        this.AAC006 = AAC006;
    }

    public void setAAC004(String AAC004) {
        this.AAC004 = AAC004;
    }

    public void setAAC005(String AAC005) {
        this.AAC005 = AAC005;
    }

    public void setAAC007(String AAC007) {
        this.AAC007 = AAC007;
    }

    public void setAAC009(String AAC009) {
        this.AAC009 = AAC009;
    }

    public void setAAC019(String AAC019) {
        this.AAC019 = AAC019;
    }

    public void setAAC020(String AAC020) {
        this.AAC020 = AAC020;
    }

    public void setAAC015(String AAC015) {
        this.AAC015 = AAC015;
    }

    public void setBAC521(String BAC521) {
        this.BAC521 = BAC521;
    }

    public void setAAC013(String AAC013) {
        this.AAC013 = AAC013;
    }

    public void setAAC012(String AAC012) {
        this.AAC012 = AAC012;
    }

    public void setAAC011(String AAC011) {
        this.AAC011 = AAC011;
    }

    public void setAAE005(String AAE005) {
        this.AAE005 = AAE005;
    }

    public void setAAE007(String AAE007) {
        this.AAE007 = AAE007;
    }

    public void setAAC040(String AAC040) {
        this.AAC040 = AAC040;
    }

    public void setAAC010(String AAC010) {
        this.AAC010 = AAC010;
    }

    public void setBAC501(String BAC501) {
        this.BAC501 = BAC501;
    }

    public void setAAC030(String AAC030) {
        this.AAC030 = AAC030;
    }

    public void setAAA040(String AAA040) {
        this.AAA040 = AAA040;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }
}