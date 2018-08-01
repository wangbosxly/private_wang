package com.thinkgem.jeesite.modules.ylbx.entity;


import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

import java.io.Serializable;
import java.util.Objects;

/**
 * 医疗保险人员信息
 * 实体类
 * @author sl_su
 */
public class YbPerson implements Serializable {

    private static final long serialVersionUID = 836509218767000678L;
    private String AAB001; //	单位编号
    private String AAC001; //	个人编号
    private String AAB004; //  单位名称
    private String AAC002; //	身份证
    private String AAC003; //	姓名
    private String BAC808; //	个人企业自编号
    private String AAC004; //	性别
    private String AAC006; //	出生日期
    private String AAC007; //	参加工作日期
    private String AAE005; //	联系电话
    private String AAC009; //	户口性质
    private String AAC011; //	文化程度
    private String AAC013; //	用工形式
    private String BAC521; //	高级技术职务类型
    private String AAC019; //	特殊工种标识
    private String AAE011; //	经办人
    private String BAA008; //	复核标志
    private String BAA010; //	复核时间
    private String AAB025; //	缴费银行户名
    private String AAC017; //	婚姻状况
    private String BAC515; //	公务员类别
    private String BAC801; //	个人荣誉标志
    private String BAC803; //	是否曾在部队服役
    private String AAB060; //	分支机构代码
    private String BAC501; //	邮件地址
    private String BAC511; //	首次缴费时间
    private String AAC058; //	证件类型
    private String BKC276; //	账户余额
    private String BAA001; //	数据分区
    private String AAC005; //	名族
    private String BIC701; //	档案出生日期
    private String AAE006; //	地址
    private String AAE007; //	邮编
    private String AAC010; //	户口所在地
    private String AAC012; //	个人身份
    private String AAC014; //	专业技术职务
    private String AAC015; //	工人技术等级
    private String AAC020; //	行政职务
    private String AAE036; //	经办时间
    private String BAA009; //	复核人
    private String AAB024; //	缴费开户银行行号
    private String AAB026; //	缴费银行基本账号
    private String BAC503; //	劳模等级
    private String BAC508; //	是否独生子女
    private String BAC802; //	艰苦地区
    private String BIC802; //	建账日期
    private String AAE013; //	备注
    private String BAC502; //	公务员批准文号
    private String AAE020; //	国籍/地区
    private String AAE140; //	险种
    private String AAC030; //	个人参保日期
    private String AAC031; //	个人参保状态
    private String AAC008; //	人员状态
    private String BAC510; //	最近参保时间
    private String AAA040; //	缴费比例类别
    private String SAA004; //	事项ID
    private String BAE702; //	主体类型（1 单位)
    private String BAE703; //	主体编号
    private String SAA043; //	业务状态（3 未受理，6已受理）
    private String SAA037; //	申请人
    private String SAA038; //	申请时间
    private String BAE941; //	申报流水号
    private String AAC040; //	工资
    private String BKC281; //	非公务员参加公务员统筹
    private String AKC021; //	医疗人员类别
    private String AKC401; //	医疗照顾人员类别
    private String SAA036; //	受理单ID
    private String SAA015; //	功能ID
    private String TAA101; //	申报时间
    private String TAA103; //	审核结果（0 待审核）
    private String TAA105; //	申报来源（1 网上大厅）
    private String AAE102; //	办理状态（1 接收）
    private String AAE035; //	变更日期
    private String AAC050; //	在职人员变更类型（22 停保 12 续保）
    private String AAE030; //	开始年月
    private String BAC504; //	个人缴费基数
    private String AAE100; //	有效标志
    private String StartYM; //	开始费款所属期
    private String EndYM; //	截止费款所属期
    private String AAE143; //	缴费类型
    private String BAA005; //	审核编号
    private String AAE003; //	对应费款所属期
    private String BAB706; //	应收核定类别
    private String AAA041; //	个人缴费比例
    private String BAC720; //	账户划入定额比例标志
    private String AAC123; //	个人缴费金额
    private String BAC713; //	应补缴个人跨年利息
    private String AAC125; //	单位缴费划账户金额
    private String BAC716; //	应补缴单位划入部分本年利息
    private String BAC717; //	应补缴单位划入统筹跨年利息
    private String BAE742; //	应缴滞纳金金额
    private String AAE114; //	缴费标志
    private String BAE747; //	滞纳金征收标志
    private String AAE063; //	征集通知流水号
    private String AAE002; //	费款所属期
    private String BAE704; //	缴费月数
    private String BAB519; //	行业企业代码
    private String BAC719; //	缴费定额比例标志
    private String AAA042; //	单位缴费比例
    private String BAC721; //	划入账户比例
    private String BAC702; //	个人缴费划账户金额
    private String BAC714; //	应补缴个人本年利息
    private String BAC715; //	应补缴单位划入部分跨年利息
    private String AAC127; //	单位缴费划入统筹金额
    private String BAC718; //	应补缴单位划入统筹本年利息
    private String BAC722; //	缴费年龄
    private String BAE746; //	补息标志
    private String BAC708; //	本期个人账户做实金额
    private String BAE707; //	基金配置流水号
    private String AAB034; //	社保经办机构编码
    private String BAE706; //	到账日期
    private String AAE160; //  变更原因
    private String BAC809; //	页数
    private String BKC289; //	每页记录数

    public String getBKC289() {
        return BKC289;
    }

    public void setBKC289(String BKC289) {
        this.BKC289 = BKC289;
    }

    public String getAAE160() {
        return AAE160;
    }

    public void setAAE160(String AAE160) {
        this.AAE160 = AAE160;
    }

    public String getAAB004() {
        return AAB004;
    }

    public void setAAB004(String AAB004) {
        this.AAB004 = AAB004;
    }

    public String getStartYM() {
        return StartYM;
    }

    public void setStartYM(String startYM) {
        StartYM = startYM;
    }

    public String getEndYM() {
        return EndYM;
    }

    public void setEndYM(String endYM) {
        EndYM = endYM;
    }

    public String getAAE143() {
        return AAE143;
    }

    public void setAAE143(String AAE143) {
        this.AAE143 = AAE143;
    }

    public String getBAA005() {
        return BAA005;
    }

    public void setBAA005(String BAA005) {
        this.BAA005 = BAA005;
    }

    public String getAAE003() {
        return AAE003;
    }

    public void setAAE003(String AAE003) {
        this.AAE003 = AAE003;
    }

    public String getBAB706() {
        return BAB706;
    }

    public void setBAB706(String BAB706) {
        this.BAB706 = BAB706;
    }

    public String getAAA041() {
        return AAA041;
    }

    public void setAAA041(String AAA041) {
        this.AAA041 = AAA041;
    }

    public String getBAC720() {
        return BAC720;
    }

    public void setBAC720(String BAC720) {
        this.BAC720 = BAC720;
    }

    public String getAAC123() {
        return AAC123;
    }

    public void setAAC123(String AAC123) {
        this.AAC123 = AAC123;
    }

    public String getBAC713() {
        return BAC713;
    }

    public void setBAC713(String BAC713) {
        this.BAC713 = BAC713;
    }

    public String getAAC125() {
        return AAC125;
    }

    public void setAAC125(String AAC125) {
        this.AAC125 = AAC125;
    }

    public String getBAC716() {
        return BAC716;
    }

    public void setBAC716(String BAC716) {
        this.BAC716 = BAC716;
    }

    public String getBAC717() {
        return BAC717;
    }

    public void setBAC717(String BAC717) {
        this.BAC717 = BAC717;
    }

    public String getBAE742() {
        return BAE742;
    }

    public void setBAE742(String BAE742) {
        this.BAE742 = BAE742;
    }

    public String getAAE114() {
        return AAE114;
    }

    public void setAAE114(String AAE114) {
        this.AAE114 = AAE114;
    }

    public String getBAE747() {
        return BAE747;
    }

    public void setBAE747(String BAE747) {
        this.BAE747 = BAE747;
    }

    public String getAAE063() {
        return AAE063;
    }

    public void setAAE063(String AAE063) {
        this.AAE063 = AAE063;
    }

    public String getAAE002() {
        return AAE002;
    }

    public void setAAE002(String AAE002) {
        this.AAE002 = AAE002;
    }

    public String getBAE704() {
        return BAE704;
    }

    public void setBAE704(String BAE704) {
        this.BAE704 = BAE704;
    }

    public String getBAB519() {
        return BAB519;
    }

    public void setBAB519(String BAB519) {
        this.BAB519 = BAB519;
    }

    public String getBAC719() {
        return BAC719;
    }

    public void setBAC719(String BAC719) {
        this.BAC719 = BAC719;
    }

    public String getAAA042() {
        return AAA042;
    }

    public void setAAA042(String AAA042) {
        this.AAA042 = AAA042;
    }

    public String getBAC721() {
        return BAC721;
    }

    public void setBAC721(String BAC721) {
        this.BAC721 = BAC721;
    }

    public String getBAC702() {
        return BAC702;
    }

    public void setBAC702(String BAC702) {
        this.BAC702 = BAC702;
    }

    public String getBAC714() {
        return BAC714;
    }

    public void setBAC714(String BAC714) {
        this.BAC714 = BAC714;
    }

    public String getBAC715() {
        return BAC715;
    }

    public void setBAC715(String BAC715) {
        this.BAC715 = BAC715;
    }

    public String getAAC127() {
        return AAC127;
    }

    public void setAAC127(String AAC127) {
        this.AAC127 = AAC127;
    }

    public String getBAC718() {
        return BAC718;
    }

    public void setBAC718(String BAC718) {
        this.BAC718 = BAC718;
    }

    public String getBAC722() {
        return BAC722;
    }

    public void setBAC722(String BAC722) {
        this.BAC722 = BAC722;
    }

    public String getBAE746() {
        return BAE746;
    }

    public void setBAE746(String BAE746) {
        this.BAE746 = BAE746;
    }

    public String getBAC708() {
        return BAC708;
    }

    public void setBAC708(String BAC708) {
        this.BAC708 = BAC708;
    }

    public String getBAE707() {
        return BAE707;
    }

    public void setBAE707(String BAE707) {
        this.BAE707 = BAE707;
    }

    public String getAAB034() {
        return AAB034;
    }

    public void setAAB034(String AAB034) {
        this.AAB034 = AAB034;
    }

    public String getBAE706() {
        return BAE706;
    }

    public void setBAE706(String BAE706) {
        this.BAE706 = BAE706;
    }

    public String getAAE030() {
        return AAE030;
    }

    public void setAAE030(String AAE030) {
        this.AAE030 = AAE030;
    }

    public String getBAC504() {
        return BAC504;
    }

    public void setBAC504(String BAC504) {
        this.BAC504 = BAC504;
    }

    public String getAAE100() {
        return AAE100;
    }

    public void setAAE100(String AAE100) {
        this.AAE100 = AAE100;
    }

    public String getAAE102() {
        return AAE102;
    }

    public void setAAE102(String AAE102) {
        this.AAE102 = AAE102;
    }

    public String getAAE035() {
        return AAE035;
    }

    public void setAAE035(String AAE035) {
        this.AAE035 = AAE035;
    }

    public String getAAC050() {
        return AAC050;
    }

    public void setAAC050(String AAC050) {
        this.AAC050 = AAC050;
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

    public String getBAE941() {
        return BAE941;
    }

    public void setBAE941(String BAE941) {
        this.BAE941 = BAE941;
    }
    @ExcelField(title = "工资" ,sort = 3, groups = {2})
    public String getAAC040() {
        return AAC040;
    }

    public void setAAC040(String AAC040) {
        this.AAC040 = AAC040;
    }

    public String getBKC281() {
        return BKC281;
    }

    public void setBKC281(String BKC281) {
        this.BKC281 = BKC281;
    }

    public String getAKC021() {
        return AKC021;
    }

    public void setAKC021(String AKC021) {
        this.AKC021 = AKC021;
    }

    public String getAKC401() {
        return AKC401;
    }

    public void setAKC401(String AKC401) {
        this.AKC401 = AKC401;
    }

    public String getSAA036() {
        return SAA036;
    }

    public void setSAA036(String SAA036) {
        this.SAA036 = SAA036;
    }

    public String getSAA015() {
        return SAA015;
    }

    public void setSAA015(String SAA015) {
        this.SAA015 = SAA015;
    }

    public String getTAA101() {
        return TAA101;
    }

    public void setTAA101(String TAA101) {
        this.TAA101 = TAA101;
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

    public String getAAE140() {
        return AAE140;
    }

    public void setAAE140(String AAE140) {
        this.AAE140 = AAE140;
    }

    public String getAAC030() {
        return AAC030;
    }

    public void setAAC030(String AAC030) {
        this.AAC030 = AAC030;
    }

    public String getAAC031() {
        return AAC031;
    }

    public void setAAC031(String AAC031) {
        this.AAC031 = AAC031;
    }

    public String getAAC008() {
        return AAC008;
    }

    public void setAAC008(String AAC008) {
        this.AAC008 = AAC008;
    }

    public String getBAC510() {
        return BAC510;
    }

    public void setBAC510(String BAC510) {
        this.BAC510 = BAC510;
    }

    public String getAAA040() {
        return AAA040;
    }

    public void setAAA040(String AAA040) {
        this.AAA040 = AAA040;
    }

    public String getAAB001() {
        return AAB001;
    }

    public void setAAB001(String AAB001) {
        this.AAB001 = AAB001;
    }
    @ExcelField(title = "个人编号", groups = {1,2})
    public String getAAC001() {
        return AAC001;
    }

    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }
    @ExcelField(title = "身份证号" ,sort = 2, groups = {1,2})
    public String getAAC002() {
        return AAC002;
    }

    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }
    @ExcelField(title = "姓名" ,sort = 1, groups = {1,2})
    public String getAAC003() {
        return AAC003;
    }

    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }

    public String getBAC808() {
        return BAC808;
    }

    public void setBAC808(String BAC808) {
        this.BAC808 = BAC808;
    }

    public String getAAC004() {
        return AAC004;
    }

    public void setAAC004(String AAC004) {
        this.AAC004 = AAC004;
    }

    public String getAAC006() {
        return AAC006;
    }

    public void setAAC006(String AAC006) {
        this.AAC006 = AAC006;
    }

    public String getAAC007() {
        return AAC007;
    }

    public void setAAC007(String AAC007) {
        this.AAC007 = AAC007;
    }

    public String getAAE005() {
        return AAE005;
    }

    public void setAAE005(String AAE005) {
        this.AAE005 = AAE005;
    }

    public String getAAC009() {
        return AAC009;
    }

    public void setAAC009(String AAC009) {
        this.AAC009 = AAC009;
    }

    public String getAAC011() {
        return AAC011;
    }

    public void setAAC011(String AAC011) {
        this.AAC011 = AAC011;
    }

    public String getAAC013() {
        return AAC013;
    }

    public void setAAC013(String AAC013) {
        this.AAC013 = AAC013;
    }

    public String getBAC521() {
        return BAC521;
    }

    public void setBAC521(String BAC521) {
        this.BAC521 = BAC521;
    }

    public String getAAC019() {
        return AAC019;
    }

    public void setAAC019(String AAC019) {
        this.AAC019 = AAC019;
    }

    public String getAAE011() {
        return AAE011;
    }

    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    public String getBAA008() {
        return BAA008;
    }

    public void setBAA008(String BAA008) {
        this.BAA008 = BAA008;
    }

    public String getBAA010() {
        return BAA010;
    }

    public void setBAA010(String BAA010) {
        this.BAA010 = BAA010;
    }

    public String getAAB025() {
        return AAB025;
    }

    public void setAAB025(String AAB025) {
        this.AAB025 = AAB025;
    }

    public String getAAC017() {
        return AAC017;
    }

    public void setAAC017(String AAC017) {
        this.AAC017 = AAC017;
    }

    public String getBAC515() {
        return BAC515;
    }

    public void setBAC515(String BAC515) {
        this.BAC515 = BAC515;
    }

    public String getBAC801() {
        return BAC801;
    }

    public void setBAC801(String BAC801) {
        this.BAC801 = BAC801;
    }

    public String getBAC803() {
        return BAC803;
    }

    public void setBAC803(String BAC803) {
        this.BAC803 = BAC803;
    }

    public String getAAB060() {
        return AAB060;
    }

    public void setAAB060(String AAB060) {
        this.AAB060 = AAB060;
    }

    public String getBAC501() {
        return BAC501;
    }

    public void setBAC501(String BAC501) {
        this.BAC501 = BAC501;
    }

    public String getBAC511() {
        return BAC511;
    }

    public void setBAC511(String BAC511) {
        this.BAC511 = BAC511;
    }

    public String getAAC058() {
        return AAC058;
    }

    public void setAAC058(String AAC058) {
        this.AAC058 = AAC058;
    }

    public String getBKC276() {
        return BKC276;
    }

    public void setBKC276(String BKC276) {
        this.BKC276 = BKC276;
    }

    public String getBAA001() {
        return BAA001;
    }

    public void setBAA001(String BAA001) {
        this.BAA001 = BAA001;
    }

    public String getAAC005() {
        return AAC005;
    }

    public void setAAC005(String AAC005) {
        this.AAC005 = AAC005;
    }

    public String getBIC701() {
        return BIC701;
    }

    public void setBIC701(String BIC701) {
        this.BIC701 = BIC701;
    }

    public String getAAE006() {
        return AAE006;
    }

    public void setAAE006(String AAE006) {
        this.AAE006 = AAE006;
    }

    public String getAAE007() {
        return AAE007;
    }

    public void setAAE007(String AAE007) {
        this.AAE007 = AAE007;
    }

    public String getAAC010() {
        return AAC010;
    }

    public void setAAC010(String AAC010) {
        this.AAC010 = AAC010;
    }

    public String getAAC012() {
        return AAC012;
    }

    public void setAAC012(String AAC012) {
        this.AAC012 = AAC012;
    }

    public String getAAC014() {
        return AAC014;
    }

    public void setAAC014(String AAC014) {
        this.AAC014 = AAC014;
    }

    public String getAAC015() {
        return AAC015;
    }

    public void setAAC015(String AAC015) {
        this.AAC015 = AAC015;
    }

    public String getAAC020() {
        return AAC020;
    }

    public void setAAC020(String AAC020) {
        this.AAC020 = AAC020;
    }

    public String getAAE036() {
        return AAE036;
    }

    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
    }

    public String getBAA009() {
        return BAA009;
    }

    public void setBAA009(String BAA009) {
        this.BAA009 = BAA009;
    }

    public String getAAB024() {
        return AAB024;
    }

    public void setAAB024(String AAB024) {
        this.AAB024 = AAB024;
    }

    public String getAAB026() {
        return AAB026;
    }

    public void setAAB026(String AAB026) {
        this.AAB026 = AAB026;
    }

    public String getBAC503() {
        return BAC503;
    }

    public void setBAC503(String BAC503) {
        this.BAC503 = BAC503;
    }

    public String getBAC508() {
        return BAC508;
    }

    public void setBAC508(String BAC508) {
        this.BAC508 = BAC508;
    }

    public String getBAC802() {
        return BAC802;
    }

    public void setBAC802(String BAC802) {
        this.BAC802 = BAC802;
    }

    public String getBIC802() {
        return BIC802;
    }

    public void setBIC802(String BIC802) {
        this.BIC802 = BIC802;
    }

    public String getAAE013() {
        return AAE013;
    }

    public void setAAE013(String AAE013) {
        this.AAE013 = AAE013;
    }

    public String getBAC502() {
        return BAC502;
    }

    public void setBAC502(String BAC502) {
        this.BAC502 = BAC502;
    }

    public String getBAC809() {
        return BAC809;
    }

    public void setBAC809(String BAC809) {
        this.BAC809 = BAC809;
    }

    public String getAAE020() {
        return AAE020;
    }

    public void setAAE020(String AAE020) {
        this.AAE020 = AAE020;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YbPerson ybPerson = (YbPerson) o;
        return Objects.equals(AAB001, ybPerson.AAB001) &&
                Objects.equals(AAC001, ybPerson.AAC001) &&
                Objects.equals(AAC002, ybPerson.AAC002) &&
                Objects.equals(AAC003, ybPerson.AAC003) &&
                Objects.equals(BAC808, ybPerson.BAC808) &&
                Objects.equals(AAC004, ybPerson.AAC004) &&
                Objects.equals(AAC006, ybPerson.AAC006) &&
                Objects.equals(AAC007, ybPerson.AAC007) &&
                Objects.equals(AAE005, ybPerson.AAE005) &&
                Objects.equals(AAC009, ybPerson.AAC009) &&
                Objects.equals(AAC011, ybPerson.AAC011) &&
                Objects.equals(AAC013, ybPerson.AAC013) &&
                Objects.equals(BAC521, ybPerson.BAC521) &&
                Objects.equals(AAC019, ybPerson.AAC019) &&
                Objects.equals(AAE011, ybPerson.AAE011) &&
                Objects.equals(BAA008, ybPerson.BAA008) &&
                Objects.equals(BAA010, ybPerson.BAA010) &&
                Objects.equals(AAB025, ybPerson.AAB025) &&
                Objects.equals(AAC017, ybPerson.AAC017) &&
                Objects.equals(BAC515, ybPerson.BAC515) &&
                Objects.equals(BAC801, ybPerson.BAC801) &&
                Objects.equals(BAC803, ybPerson.BAC803) &&
                Objects.equals(AAB060, ybPerson.AAB060) &&
                Objects.equals(BAC501, ybPerson.BAC501) &&
                Objects.equals(BAC511, ybPerson.BAC511) &&
                Objects.equals(AAC058, ybPerson.AAC058) &&
                Objects.equals(BKC276, ybPerson.BKC276) &&
                Objects.equals(BAA001, ybPerson.BAA001) &&
                Objects.equals(AAC005, ybPerson.AAC005) &&
                Objects.equals(BIC701, ybPerson.BIC701) &&
                Objects.equals(AAE006, ybPerson.AAE006) &&
                Objects.equals(AAE007, ybPerson.AAE007) &&
                Objects.equals(AAC010, ybPerson.AAC010) &&
                Objects.equals(AAC012, ybPerson.AAC012) &&
                Objects.equals(AAC014, ybPerson.AAC014) &&
                Objects.equals(AAC015, ybPerson.AAC015) &&
                Objects.equals(AAC020, ybPerson.AAC020) &&
                Objects.equals(AAE036, ybPerson.AAE036) &&
                Objects.equals(BAA009, ybPerson.BAA009) &&
                Objects.equals(AAB024, ybPerson.AAB024) &&
                Objects.equals(AAB026, ybPerson.AAB026) &&
                Objects.equals(BAC503, ybPerson.BAC503) &&
                Objects.equals(BAC508, ybPerson.BAC508) &&
                Objects.equals(BAC802, ybPerson.BAC802) &&
                Objects.equals(BIC802, ybPerson.BIC802) &&
                Objects.equals(AAE013, ybPerson.AAE013) &&
                Objects.equals(BAC502, ybPerson.BAC502) &&
                Objects.equals(BAC809, ybPerson.BAC809) &&
                Objects.equals(AAE020, ybPerson.AAE020) &&
                Objects.equals(AAE140, ybPerson.AAE140) &&
                Objects.equals(AAC030, ybPerson.AAC030) &&
                Objects.equals(AAC031, ybPerson.AAC031) &&
                Objects.equals(AAC008, ybPerson.AAC008) &&
                Objects.equals(BAC510, ybPerson.BAC510) &&
                Objects.equals(AAA040, ybPerson.AAA040) &&
                Objects.equals(SAA004, ybPerson.SAA004) &&
                Objects.equals(BAE702, ybPerson.BAE702) &&
                Objects.equals(BAE703, ybPerson.BAE703) &&
                Objects.equals(SAA043, ybPerson.SAA043) &&
                Objects.equals(SAA037, ybPerson.SAA037) &&
                Objects.equals(SAA038, ybPerson.SAA038) &&
                Objects.equals(BAE941, ybPerson.BAE941) &&
                Objects.equals(AAC040, ybPerson.AAC040) &&
                Objects.equals(BKC281, ybPerson.BKC281) &&
                Objects.equals(AKC021, ybPerson.AKC021) &&
                Objects.equals(AKC401, ybPerson.AKC401) &&
                Objects.equals(SAA036, ybPerson.SAA036) &&
                Objects.equals(SAA015, ybPerson.SAA015) &&
                Objects.equals(TAA101, ybPerson.TAA101) &&
                Objects.equals(TAA103, ybPerson.TAA103) &&
                Objects.equals(TAA105, ybPerson.TAA105) &&
                Objects.equals(AAE102, ybPerson.AAE102) &&
                Objects.equals(AAE035, ybPerson.AAE035) &&
                Objects.equals(AAC050, ybPerson.AAC050) &&
                Objects.equals(AAE030, ybPerson.AAE030) &&
                Objects.equals(BAC504, ybPerson.BAC504) &&
                Objects.equals(AAE100, ybPerson.AAE100) &&
                Objects.equals(StartYM, ybPerson.StartYM) &&
                Objects.equals(EndYM, ybPerson.EndYM) &&
                Objects.equals(AAE143, ybPerson.AAE143) &&
                Objects.equals(BAA005, ybPerson.BAA005) &&
                Objects.equals(AAE003, ybPerson.AAE003) &&
                Objects.equals(BAB706, ybPerson.BAB706) &&
                Objects.equals(AAA041, ybPerson.AAA041) &&
                Objects.equals(BAC720, ybPerson.BAC720) &&
                Objects.equals(AAC123, ybPerson.AAC123) &&
                Objects.equals(BAC713, ybPerson.BAC713) &&
                Objects.equals(AAC125, ybPerson.AAC125) &&
                Objects.equals(BAC716, ybPerson.BAC716) &&
                Objects.equals(BAC717, ybPerson.BAC717) &&
                Objects.equals(BAE742, ybPerson.BAE742) &&
                Objects.equals(AAE114, ybPerson.AAE114) &&
                Objects.equals(BAE747, ybPerson.BAE747) &&
                Objects.equals(AAE063, ybPerson.AAE063) &&
                Objects.equals(AAE002, ybPerson.AAE002) &&
                Objects.equals(BAE704, ybPerson.BAE704) &&
                Objects.equals(BAB519, ybPerson.BAB519) &&
                Objects.equals(BAC719, ybPerson.BAC719) &&
                Objects.equals(AAA042, ybPerson.AAA042) &&
                Objects.equals(BAC721, ybPerson.BAC721) &&
                Objects.equals(BAC702, ybPerson.BAC702) &&
                Objects.equals(BAC714, ybPerson.BAC714) &&
                Objects.equals(BAC715, ybPerson.BAC715) &&
                Objects.equals(AAC127, ybPerson.AAC127) &&
                Objects.equals(BAC718, ybPerson.BAC718) &&
                Objects.equals(BAC722, ybPerson.BAC722) &&
                Objects.equals(BAE746, ybPerson.BAE746) &&
                Objects.equals(BAC708, ybPerson.BAC708) &&
                Objects.equals(BAE707, ybPerson.BAE707) &&
                Objects.equals(AAB034, ybPerson.AAB034) &&
                Objects.equals(BAE706, ybPerson.BAE706);
    }

    @Override
    public int hashCode() {

        return Objects.hash(AAB001, AAC001, AAC002, AAC003, BAC808, AAC004, AAC006, AAC007, AAE005, AAC009, AAC011, AAC013, BAC521, AAC019, AAE011, BAA008, BAA010, AAB025, AAC017, BAC515, BAC801, BAC803, AAB060, BAC501, BAC511, AAC058, BKC276, BAA001, AAC005, BIC701, AAE006, AAE007, AAC010, AAC012, AAC014, AAC015, AAC020, AAE036, BAA009, AAB024, AAB026, BAC503, BAC508, BAC802, BIC802, AAE013, BAC502, BAC809, AAE020, AAE140, AAC030, AAC031, AAC008, BAC510, AAA040, SAA004, BAE702, BAE703, SAA043, SAA037, SAA038, BAE941, AAC040, BKC281, AKC021, AKC401, SAA036, SAA015, TAA101, TAA103, TAA105, AAE102, AAE035, AAC050, AAE030, BAC504, AAE100, StartYM, EndYM, AAE143, BAA005, AAE003, BAB706, AAA041, BAC720, AAC123, BAC713, AAC125, BAC716, BAC717, BAE742, AAE114, BAE747, AAE063, AAE002, BAE704, BAB519, BAC719, AAA042, BAC721, BAC702, BAC714, BAC715, AAC127, BAC718, BAC722, BAE746, BAC708, BAE707, AAB034, BAE706);
    }
}
