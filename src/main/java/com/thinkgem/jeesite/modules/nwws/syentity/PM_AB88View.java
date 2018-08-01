/**
 * PM_AB88View.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.syentity;

import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

public class PM_AB88View  extends BaseView  implements java.io.Serializable {
    private java.lang.String AAB001;

    private java.lang.String AAB004;

    private java.lang.String AAB019;

    private java.lang.String AAB020;

    private java.lang.String AAB021;

    private java.lang.String AAB021_1;

    private java.lang.String AAB021_2;

    private java.lang.String AAB021_4;

    private java.lang.String AAB021_5;

    private java.lang.String AAB021_6;

    private java.lang.String AAB022;

    private java.lang.String AAB033;

    private java.lang.String AAB034;

    private java.lang.String AAB037_1;

    private java.lang.String AAB082;

    private java.lang.String AAB083;

    private java.lang.String AAB120;

    private java.lang.String AAB121;

    private java.lang.String AAB122;

    private java.lang.String AAB123;

    private java.lang.String AAB124;

    private java.lang.String AAB137;

    private java.lang.String AAD003;

    private java.lang.String AAD004;

    private java.lang.String AAE002;

    private java.lang.String AAE003;

    private java.lang.String AAE008;

    private java.lang.String AAE009;

    private java.lang.String AAE010;

    private java.lang.String AAE011;

    private java.lang.String AAE013;

    private java.lang.String AAE036;

    private java.lang.String AAE063;

    private java.lang.String AAE064;

    private java.lang.String AAE100;

    private java.lang.String AAE140;

    private java.lang.String AAE143;

    private PM_AC88View[] AC88ViewList;

    private java.lang.String BAA001;

    private java.lang.String BAA005;

    private java.lang.String BAB701;

    private java.lang.String BAB702;

    private java.lang.String BAB703;

    private java.lang.String BAB704;

    private java.lang.String BAB705;

    private java.lang.String BAB706;

    private java.lang.String BAB811;

    private java.lang.String BAC701;

    private java.lang.String BAC702;

    private java.lang.String BAC703;

    private java.lang.String BAC704;

    private java.lang.String BAC705;

    private java.lang.String BAC706;

    private java.lang.String BAC707;

    private java.lang.String BAC708;

    private java.lang.String BAC709;

    private java.lang.String BAC710;

    private java.lang.String BAC711;

    private java.lang.String BAC712;

    private java.lang.String BAE702;

    private java.lang.String BAE703;

    private java.lang.String BAE707;

    private java.lang.String BAE708;

    private java.lang.String BAE709;

    private java.lang.String BAE711;

    private java.lang.String BAE712;

    private java.lang.String BAE713;

    private java.lang.String BAE714;

    private java.lang.String BAE715;

    private java.lang.String BAE716;

    private java.lang.String BAE717;

    private java.lang.String BAE740;

    private java.lang.String BAE741;

    private java.lang.String BAE742;

    private java.lang.String BAE743;

    private java.lang.String BAE744;

    private java.lang.String BAE745;

    private java.lang.String BAE746;

    private java.lang.String BAE747;

    private java.lang.String BAE748;

    private java.lang.String BAE749;

    private java.lang.String BAE750;

    private java.lang.String BAE850;

    private java.lang.String BAE941;

    private java.lang.String SAA015;

    private java.lang.String SAA036;

    private java.lang.String TAA101;

    private java.lang.String TAA102;

    private java.lang.String TAA103;

    private java.lang.String TAA104;

    private java.lang.String TAA105;

    private java.lang.String endYM;

    private java.lang.String startYM;

    public PM_AB88View() {
    }

    public PM_AB88View(
           java.lang.String modelName,
           java.lang.String AAB001,
           java.lang.String AAB004,
           java.lang.String AAB019,
           java.lang.String AAB020,
           java.lang.String AAB021,
           java.lang.String AAB021_1,
           java.lang.String AAB021_2,
           java.lang.String AAB021_4,
           java.lang.String AAB021_5,
           java.lang.String AAB021_6,
           java.lang.String AAB022,
           java.lang.String AAB033,
           java.lang.String AAB034,
           java.lang.String AAB037_1,
           java.lang.String AAB082,
           java.lang.String AAB083,
           java.lang.String AAB120,
           java.lang.String AAB121,
           java.lang.String AAB122,
           java.lang.String AAB123,
           java.lang.String AAB124,
           java.lang.String AAB137,
           java.lang.String AAD003,
           java.lang.String AAD004,
           java.lang.String AAE002,
           java.lang.String AAE003,
           java.lang.String AAE008,
           java.lang.String AAE009,
           java.lang.String AAE010,
           java.lang.String AAE011,
           java.lang.String AAE013,
           java.lang.String AAE036,
           java.lang.String AAE063,
           java.lang.String AAE064,
           java.lang.String AAE100,
           java.lang.String AAE140,
           java.lang.String AAE143,
           PM_AC88View[] AC88ViewList,
           java.lang.String BAA001,
           java.lang.String BAA005,
           java.lang.String BAB701,
           java.lang.String BAB702,
           java.lang.String BAB703,
           java.lang.String BAB704,
           java.lang.String BAB705,
           java.lang.String BAB706,
           java.lang.String BAB811,
           java.lang.String BAC701,
           java.lang.String BAC702,
           java.lang.String BAC703,
           java.lang.String BAC704,
           java.lang.String BAC705,
           java.lang.String BAC706,
           java.lang.String BAC707,
           java.lang.String BAC708,
           java.lang.String BAC709,
           java.lang.String BAC710,
           java.lang.String BAC711,
           java.lang.String BAC712,
           java.lang.String BAE702,
           java.lang.String BAE703,
           java.lang.String BAE707,
           java.lang.String BAE708,
           java.lang.String BAE709,
           java.lang.String BAE711,
           java.lang.String BAE712,
           java.lang.String BAE713,
           java.lang.String BAE714,
           java.lang.String BAE715,
           java.lang.String BAE716,
           java.lang.String BAE717,
           java.lang.String BAE740,
           java.lang.String BAE741,
           java.lang.String BAE742,
           java.lang.String BAE743,
           java.lang.String BAE744,
           java.lang.String BAE745,
           java.lang.String BAE746,
           java.lang.String BAE747,
           java.lang.String BAE748,
           java.lang.String BAE749,
           java.lang.String BAE750,
           java.lang.String BAE850,
           java.lang.String BAE941,
           java.lang.String SAA015,
           java.lang.String SAA036,
           java.lang.String TAA101,
           java.lang.String TAA102,
           java.lang.String TAA103,
           java.lang.String TAA104,
           java.lang.String TAA105,
           java.lang.String endYM,
           java.lang.String startYM) {
        super(
            modelName);
        this.AAB001 = AAB001;
        this.AAB004 = AAB004;
        this.AAB019 = AAB019;
        this.AAB020 = AAB020;
        this.AAB021 = AAB021;
        this.AAB021_1 = AAB021_1;
        this.AAB021_2 = AAB021_2;
        this.AAB021_4 = AAB021_4;
        this.AAB021_5 = AAB021_5;
        this.AAB021_6 = AAB021_6;
        this.AAB022 = AAB022;
        this.AAB033 = AAB033;
        this.AAB034 = AAB034;
        this.AAB037_1 = AAB037_1;
        this.AAB082 = AAB082;
        this.AAB083 = AAB083;
        this.AAB120 = AAB120;
        this.AAB121 = AAB121;
        this.AAB122 = AAB122;
        this.AAB123 = AAB123;
        this.AAB124 = AAB124;
        this.AAB137 = AAB137;
        this.AAD003 = AAD003;
        this.AAD004 = AAD004;
        this.AAE002 = AAE002;
        this.AAE003 = AAE003;
        this.AAE008 = AAE008;
        this.AAE009 = AAE009;
        this.AAE010 = AAE010;
        this.AAE011 = AAE011;
        this.AAE013 = AAE013;
        this.AAE036 = AAE036;
        this.AAE063 = AAE063;
        this.AAE064 = AAE064;
        this.AAE100 = AAE100;
        this.AAE140 = AAE140;
        this.AAE143 = AAE143;
        this.AC88ViewList = AC88ViewList;
        this.BAA001 = BAA001;
        this.BAA005 = BAA005;
        this.BAB701 = BAB701;
        this.BAB702 = BAB702;
        this.BAB703 = BAB703;
        this.BAB704 = BAB704;
        this.BAB705 = BAB705;
        this.BAB706 = BAB706;
        this.BAB811 = BAB811;
        this.BAC701 = BAC701;
        this.BAC702 = BAC702;
        this.BAC703 = BAC703;
        this.BAC704 = BAC704;
        this.BAC705 = BAC705;
        this.BAC706 = BAC706;
        this.BAC707 = BAC707;
        this.BAC708 = BAC708;
        this.BAC709 = BAC709;
        this.BAC710 = BAC710;
        this.BAC711 = BAC711;
        this.BAC712 = BAC712;
        this.BAE702 = BAE702;
        this.BAE703 = BAE703;
        this.BAE707 = BAE707;
        this.BAE708 = BAE708;
        this.BAE709 = BAE709;
        this.BAE711 = BAE711;
        this.BAE712 = BAE712;
        this.BAE713 = BAE713;
        this.BAE714 = BAE714;
        this.BAE715 = BAE715;
        this.BAE716 = BAE716;
        this.BAE717 = BAE717;
        this.BAE740 = BAE740;
        this.BAE741 = BAE741;
        this.BAE742 = BAE742;
        this.BAE743 = BAE743;
        this.BAE744 = BAE744;
        this.BAE745 = BAE745;
        this.BAE746 = BAE746;
        this.BAE747 = BAE747;
        this.BAE748 = BAE748;
        this.BAE749 = BAE749;
        this.BAE750 = BAE750;
        this.BAE850 = BAE850;
        this.BAE941 = BAE941;
        this.SAA015 = SAA015;
        this.SAA036 = SAA036;
        this.TAA101 = TAA101;
        this.TAA102 = TAA102;
        this.TAA103 = TAA103;
        this.TAA104 = TAA104;
        this.TAA105 = TAA105;
        this.endYM = endYM;
        this.startYM = startYM;
    }


    /**
     * Gets the AAB001 value for this PM_AB88View.
     * 
     * @return AAB001
     */
    @ExcelField(title="单位编号")
    public java.lang.String getAAB001() {
        return AAB001;
    }


    /**
     * Sets the AAB001 value for this PM_AB88View.
     * 
     * @param AAB001
     */
    public void setAAB001(java.lang.String AAB001) {
        this.AAB001 = AAB001;
    }


    /**
     * Gets the AAB004 value for this PM_AB88View.
     * 
     * @return AAB004
     */
    @ExcelField(title="单位名称")
    public java.lang.String getAAB004() {
        return AAB004;
    }


    /**
     * Sets the AAB004 value for this PM_AB88View.
     * 
     * @param AAB004
     */
    public void setAAB004(java.lang.String AAB004) {
        this.AAB004 = AAB004;
    }


    /**
     * Gets the AAB019 value for this PM_AB88View.
     * 
     * @return AAB019
     */
    public java.lang.String getAAB019() {
        return AAB019;
    }


    /**
     * Sets the AAB019 value for this PM_AB88View.
     * 
     * @param AAB019
     */
    public void setAAB019(java.lang.String AAB019) {
        this.AAB019 = AAB019;
    }


    /**
     * Gets the AAB020 value for this PM_AB88View.
     * 
     * @return AAB020
     */
    public java.lang.String getAAB020() {
        return AAB020;
    }


    /**
     * Sets the AAB020 value for this PM_AB88View.
     * 
     * @param AAB020
     */
    public void setAAB020(java.lang.String AAB020) {
        this.AAB020 = AAB020;
    }


    /**
     * Gets the AAB021 value for this PM_AB88View.
     * 
     * @return AAB021
     */
    public java.lang.String getAAB021() {
        return AAB021;
    }


    /**
     * Sets the AAB021 value for this PM_AB88View.
     * 
     * @param AAB021
     */
    public void setAAB021(java.lang.String AAB021) {
        this.AAB021 = AAB021;
    }


    /**
     * Gets the AAB021_1 value for this PM_AB88View.
     * 
     * @return AAB021_1
     */
    public java.lang.String getAAB021_1() {
        return AAB021_1;
    }


    /**
     * Sets the AAB021_1 value for this PM_AB88View.
     * 
     * @param AAB021_1
     */
    public void setAAB021_1(java.lang.String AAB021_1) {
        this.AAB021_1 = AAB021_1;
    }


    /**
     * Gets the AAB021_2 value for this PM_AB88View.
     * 
     * @return AAB021_2
     */
    public java.lang.String getAAB021_2() {
        return AAB021_2;
    }


    /**
     * Sets the AAB021_2 value for this PM_AB88View.
     * 
     * @param AAB021_2
     */
    public void setAAB021_2(java.lang.String AAB021_2) {
        this.AAB021_2 = AAB021_2;
    }


    /**
     * Gets the AAB021_4 value for this PM_AB88View.
     * 
     * @return AAB021_4
     */
    public java.lang.String getAAB021_4() {
        return AAB021_4;
    }


    /**
     * Sets the AAB021_4 value for this PM_AB88View.
     * 
     * @param AAB021_4
     */
    public void setAAB021_4(java.lang.String AAB021_4) {
        this.AAB021_4 = AAB021_4;
    }


    /**
     * Gets the AAB021_5 value for this PM_AB88View.
     * 
     * @return AAB021_5
     */
    public java.lang.String getAAB021_5() {
        return AAB021_5;
    }


    /**
     * Sets the AAB021_5 value for this PM_AB88View.
     * 
     * @param AAB021_5
     */
    public void setAAB021_5(java.lang.String AAB021_5) {
        this.AAB021_5 = AAB021_5;
    }


    /**
     * Gets the AAB021_6 value for this PM_AB88View.
     * 
     * @return AAB021_6
     */
    public java.lang.String getAAB021_6() {
        return AAB021_6;
    }


    /**
     * Sets the AAB021_6 value for this PM_AB88View.
     * 
     * @param AAB021_6
     */
    public void setAAB021_6(java.lang.String AAB021_6) {
        this.AAB021_6 = AAB021_6;
    }


    /**
     * Gets the AAB022 value for this PM_AB88View.
     * 
     * @return AAB022
     */
    public java.lang.String getAAB022() {
        return AAB022;
    }


    /**
     * Sets the AAB022 value for this PM_AB88View.
     * 
     * @param AAB022
     */
    public void setAAB022(java.lang.String AAB022) {
        this.AAB022 = AAB022;
    }


    /**
     * Gets the AAB033 value for this PM_AB88View.
     * 
     * @return AAB033
     */
    public java.lang.String getAAB033() {
        return AAB033;
    }


    /**
     * Sets the AAB033 value for this PM_AB88View.
     * 
     * @param AAB033
     */
    public void setAAB033(java.lang.String AAB033) {
        this.AAB033 = AAB033;
    }


    /**
     * Gets the AAB034 value for this PM_AB88View.
     * 
     * @return AAB034
     */
    public java.lang.String getAAB034() {
        return AAB034;
    }


    /**
     * Sets the AAB034 value for this PM_AB88View.
     * 
     * @param AAB034
     */
    public void setAAB034(java.lang.String AAB034) {
        this.AAB034 = AAB034;
    }


    /**
     * Gets the AAB037_1 value for this PM_AB88View.
     * 
     * @return AAB037_1
     */
    public java.lang.String getAAB037_1() {
        return AAB037_1;
    }


    /**
     * Sets the AAB037_1 value for this PM_AB88View.
     * 
     * @param AAB037_1
     */
    public void setAAB037_1(java.lang.String AAB037_1) {
        this.AAB037_1 = AAB037_1;
    }


    /**
     * Gets the AAB082 value for this PM_AB88View.
     * 
     * @return AAB082
     */
    public java.lang.String getAAB082() {
        return AAB082;
    }


    /**
     * Sets the AAB082 value for this PM_AB88View.
     * 
     * @param AAB082
     */
    public void setAAB082(java.lang.String AAB082) {
        this.AAB082 = AAB082;
    }


    /**
     * Gets the AAB083 value for this PM_AB88View.
     * 
     * @return AAB083
     */
    @ExcelField(title="缴费人数")
    public java.lang.String getAAB083() {
        return AAB083;
    }


    /**
     * Sets the AAB083 value for this PM_AB88View.
     * 
     * @param AAB083
     */
    public void setAAB083(java.lang.String AAB083) {
        this.AAB083 = AAB083;
    }


    /**
     * Gets the AAB120 value for this PM_AB88View.
     * 
     * @return AAB120
     */
    public java.lang.String getAAB120() {
        return AAB120;
    }


    /**
     * Sets the AAB120 value for this PM_AB88View.
     * 
     * @param AAB120
     */
    public void setAAB120(java.lang.String AAB120) {
        this.AAB120 = AAB120;
    }


    /**
     * Gets the AAB121 value for this PM_AB88View.
     * 
     * @return AAB121
     */
    @ExcelField(title="缴费基数总额")
    public java.lang.String getAAB121() {
        return AAB121;
    }


    /**
     * Sets the AAB121 value for this PM_AB88View.
     * 
     * @param AAB121
     */
    public void setAAB121(java.lang.String AAB121) {
        this.AAB121 = AAB121;
    }


    /**
     * Gets the AAB122 value for this PM_AB88View.
     * 
     * @return AAB122
     */
    @ExcelField(title="个人应缴金额")
    public java.lang.String getAAB122() {
        return AAB122;
    }


    /**
     * Sets the AAB122 value for this PM_AB88View.
     * 
     * @param AAB122
     */
    public void setAAB122(java.lang.String AAB122) {
        this.AAB122 = AAB122;
    }


    /**
     * Gets the AAB123 value for this PM_AB88View.
     * 
     * @return AAB123
     */
    public java.lang.String getAAB123() {
        return AAB123;
    }


    /**
     * Sets the AAB123 value for this PM_AB88View.
     * 
     * @param AAB123
     */
    public void setAAB123(java.lang.String AAB123) {
        this.AAB123 = AAB123;
    }


    /**
     * Gets the AAB124 value for this PM_AB88View.
     * 
     * @return AAB124
     */
    public java.lang.String getAAB124() {
        return AAB124;
    }


    /**
     * Sets the AAB124 value for this PM_AB88View.
     * 
     * @param AAB124
     */
    public void setAAB124(java.lang.String AAB124) {
        this.AAB124 = AAB124;
    }


    /**
     * Gets the AAB137 value for this PM_AB88View.
     * 
     * @return AAB137
     */
    @ExcelField(title="应缴合计")
    public java.lang.String getAAB137() {
        return AAB137;
    }


    /**
     * Sets the AAB137 value for this PM_AB88View.
     * 
     * @param AAB137
     */
    public void setAAB137(java.lang.String AAB137) {
        this.AAB137 = AAB137;
    }


    /**
     * Gets the AAD003 value for this PM_AB88View.
     * 
     * @return AAD003
     */
    public java.lang.String getAAD003() {
        return AAD003;
    }


    /**
     * Sets the AAD003 value for this PM_AB88View.
     * 
     * @param AAD003
     */
    public void setAAD003(java.lang.String AAD003) {
        this.AAD003 = AAD003;
    }


    /**
     * Gets the AAD004 value for this PM_AB88View.
     * 
     * @return AAD004
     */
    public java.lang.String getAAD004() {
        return AAD004;
    }


    /**
     * Sets the AAD004 value for this PM_AB88View.
     * 
     * @param AAD004
     */
    public void setAAD004(java.lang.String AAD004) {
        this.AAD004 = AAD004;
    }


    /**
     * Gets the AAE002 value for this PM_AB88View.
     * 
     * @return AAE002
     */
    @ExcelField(title="费款所属期")
    public java.lang.String getAAE002() {
        return AAE002;
    }


    /**
     * Sets the AAE002 value for this PM_AB88View.
     * 
     * @param AAE002
     */
    public void setAAE002(java.lang.String AAE002) {
        this.AAE002 = AAE002;
    }


    /**
     * Gets the AAE003 value for this PM_AB88View.
     * 
     * @return AAE003
     */
    public java.lang.String getAAE003() {
        return AAE003;
    }


    /**
     * Sets the AAE003 value for this PM_AB88View.
     * 
     * @param AAE003
     */
    public void setAAE003(java.lang.String AAE003) {
        this.AAE003 = AAE003;
    }


    /**
     * Gets the AAE008 value for this PM_AB88View.
     * 
     * @return AAE008
     */
    public java.lang.String getAAE008() {
        return AAE008;
    }


    /**
     * Sets the AAE008 value for this PM_AB88View.
     * 
     * @param AAE008
     */
    public void setAAE008(java.lang.String AAE008) {
        this.AAE008 = AAE008;
    }


    /**
     * Gets the AAE009 value for this PM_AB88View.
     * 
     * @return AAE009
     */
    public java.lang.String getAAE009() {
        return AAE009;
    }


    /**
     * Sets the AAE009 value for this PM_AB88View.
     * 
     * @param AAE009
     */
    public void setAAE009(java.lang.String AAE009) {
        this.AAE009 = AAE009;
    }


    /**
     * Gets the AAE010 value for this PM_AB88View.
     * 
     * @return AAE010
     */
    public java.lang.String getAAE010() {
        return AAE010;
    }


    /**
     * Sets the AAE010 value for this PM_AB88View.
     * 
     * @param AAE010
     */
    public void setAAE010(java.lang.String AAE010) {
        this.AAE010 = AAE010;
    }


    /**
     * Gets the AAE011 value for this PM_AB88View.
     * 
     * @return AAE011
     */
    public java.lang.String getAAE011() {
        return AAE011;
    }


    /**
     * Sets the AAE011 value for this PM_AB88View.
     * 
     * @param AAE011
     */
    public void setAAE011(java.lang.String AAE011) {
        this.AAE011 = AAE011;
    }


    /**
     * Gets the AAE013 value for this PM_AB88View.
     * 
     * @return AAE013
     */
    public java.lang.String getAAE013() {
        return AAE013;
    }


    /**
     * Sets the AAE013 value for this PM_AB88View.
     * 
     * @param AAE013
     */
    public void setAAE013(java.lang.String AAE013) {
        this.AAE013 = AAE013;
    }


    /**
     * Gets the AAE036 value for this PM_AB88View.
     * 
     * @return AAE036
     */
    public java.lang.String getAAE036() {
        return AAE036;
    }


    /**
     * Sets the AAE036 value for this PM_AB88View.
     * 
     * @param AAE036
     */
    public void setAAE036(java.lang.String AAE036) {
        this.AAE036 = AAE036;
    }


    /**
     * Gets the AAE063 value for this PM_AB88View.
     * 
     * @return AAE063
     */
    public java.lang.String getAAE063() {
        return AAE063;
    }


    /**
     * Sets the AAE063 value for this PM_AB88View.
     * 
     * @param AAE063
     */
    public void setAAE063(java.lang.String AAE063) {
        this.AAE063 = AAE063;
    }


    /**
     * Gets the AAE064 value for this PM_AB88View.
     * 
     * @return AAE064
     */
    public java.lang.String getAAE064() {
        return AAE064;
    }


    /**
     * Sets the AAE064 value for this PM_AB88View.
     * 
     * @param AAE064
     */
    public void setAAE064(java.lang.String AAE064) {
        this.AAE064 = AAE064;
    }


    /**
     * Gets the AAE100 value for this PM_AB88View.
     * 
     * @return AAE100
     */
    public java.lang.String getAAE100() {
        return AAE100;
    }


    /**
     * Sets the AAE100 value for this PM_AB88View.
     * 
     * @param AAE100
     */
    public void setAAE100(java.lang.String AAE100) {
        this.AAE100 = AAE100;
    }


    /**
     * Gets the AAE140 value for this PM_AB88View.
     * 
     * @return AAE140
     */
    public java.lang.String getAAE140() {
        return AAE140;
    }


    /**
     * Sets the AAE140 value for this PM_AB88View.
     * 
     * @param AAE140
     */
    public void setAAE140(java.lang.String AAE140) {
        this.AAE140 = AAE140;
    }


    /**
     * Gets the AAE143 value for this PM_AB88View.
     * 
     * @return AAE143
     */
    public java.lang.String getAAE143() {
        return AAE143;
    }


    /**
     * Sets the AAE143 value for this PM_AB88View.
     * 
     * @param AAE143
     */
    public void setAAE143(java.lang.String AAE143) {
        this.AAE143 = AAE143;
    }


    /**
     * Gets the AC88ViewList value for this PM_AB88View.
     * 
     * @return AC88ViewList
     */
    public PM_AC88View[] getAC88ViewList() {
        return AC88ViewList;
    }


    /**
     * Sets the AC88ViewList value for this PM_AB88View.
     * 
     * @param AC88ViewList
     */
    public void setAC88ViewList(PM_AC88View[] AC88ViewList) {
        this.AC88ViewList = AC88ViewList;
    }


    /**
     * Gets the BAA001 value for this PM_AB88View.
     * 
     * @return BAA001
     */
    public java.lang.String getBAA001() {
        return BAA001;
    }


    /**
     * Sets the BAA001 value for this PM_AB88View.
     * 
     * @param BAA001
     */
    public void setBAA001(java.lang.String BAA001) {
        this.BAA001 = BAA001;
    }


    /**
     * Gets the BAA005 value for this PM_AB88View.
     * 
     * @return BAA005
     */
    public java.lang.String getBAA005() {
        return BAA005;
    }


    /**
     * Sets the BAA005 value for this PM_AB88View.
     * 
     * @param BAA005
     */
    public void setBAA005(java.lang.String BAA005) {
        this.BAA005 = BAA005;
    }


    /**
     * Gets the BAB701 value for this PM_AB88View.
     * 
     * @return BAB701
     */
    @ExcelField(title="单位应缴金额")
    public java.lang.String getBAB701() {
        return BAB701;
    }


    /**
     * Sets the BAB701 value for this PM_AB88View.
     * 
     * @param BAB701
     */
    public void setBAB701(java.lang.String BAB701) {
        this.BAB701 = BAB701;
    }


    /**
     * Gets the BAB702 value for this PM_AB88View.
     * 
     * @return BAB702
     */
    public java.lang.String getBAB702() {
        return BAB702;
    }


    /**
     * Sets the BAB702 value for this PM_AB88View.
     * 
     * @param BAB702
     */
    public void setBAB702(java.lang.String BAB702) {
        this.BAB702 = BAB702;
    }


    /**
     * Gets the BAB703 value for this PM_AB88View.
     * 
     * @return BAB703
     */
    public java.lang.String getBAB703() {
        return BAB703;
    }


    /**
     * Sets the BAB703 value for this PM_AB88View.
     * 
     * @param BAB703
     */
    public void setBAB703(java.lang.String BAB703) {
        this.BAB703 = BAB703;
    }


    /**
     * Gets the BAB704 value for this PM_AB88View.
     * 
     * @return BAB704
     */
    public java.lang.String getBAB704() {
        return BAB704;
    }


    /**
     * Sets the BAB704 value for this PM_AB88View.
     * 
     * @param BAB704
     */
    public void setBAB704(java.lang.String BAB704) {
        this.BAB704 = BAB704;
    }


    /**
     * Gets the BAB705 value for this PM_AB88View.
     * 
     * @return BAB705
     */
    public java.lang.String getBAB705() {
        return BAB705;
    }


    /**
     * Sets the BAB705 value for this PM_AB88View.
     * 
     * @param BAB705
     */
    public void setBAB705(java.lang.String BAB705) {
        this.BAB705 = BAB705;
    }


    /**
     * Gets the BAB706 value for this PM_AB88View.
     * 
     * @return BAB706
     */
    public java.lang.String getBAB706() {
        return BAB706;
    }


    /**
     * Sets the BAB706 value for this PM_AB88View.
     * 
     * @param BAB706
     */
    public void setBAB706(java.lang.String BAB706) {
        this.BAB706 = BAB706;
    }


    /**
     * Gets the BAB811 value for this PM_AB88View.
     * 
     * @return BAB811
     */
    public java.lang.String getBAB811() {
        return BAB811;
    }


    /**
     * Sets the BAB811 value for this PM_AB88View.
     * 
     * @param BAB811
     */
    public void setBAB811(java.lang.String BAB811) {
        this.BAB811 = BAB811;
    }


    /**
     * Gets the BAC701 value for this PM_AB88View.
     * 
     * @return BAC701
     */
    public java.lang.String getBAC701() {
        return BAC701;
    }


    /**
     * Sets the BAC701 value for this PM_AB88View.
     * 
     * @param BAC701
     */
    public void setBAC701(java.lang.String BAC701) {
        this.BAC701 = BAC701;
    }


    /**
     * Gets the BAC702 value for this PM_AB88View.
     * 
     * @return BAC702
     */
    public java.lang.String getBAC702() {
        return BAC702;
    }


    /**
     * Sets the BAC702 value for this PM_AB88View.
     * 
     * @param BAC702
     */
    public void setBAC702(java.lang.String BAC702) {
        this.BAC702 = BAC702;
    }


    /**
     * Gets the BAC703 value for this PM_AB88View.
     * 
     * @return BAC703
     */
    public java.lang.String getBAC703() {
        return BAC703;
    }


    /**
     * Sets the BAC703 value for this PM_AB88View.
     * 
     * @param BAC703
     */
    public void setBAC703(java.lang.String BAC703) {
        this.BAC703 = BAC703;
    }


    /**
     * Gets the BAC704 value for this PM_AB88View.
     * 
     * @return BAC704
     */
    public java.lang.String getBAC704() {
        return BAC704;
    }


    /**
     * Sets the BAC704 value for this PM_AB88View.
     * 
     * @param BAC704
     */
    public void setBAC704(java.lang.String BAC704) {
        this.BAC704 = BAC704;
    }


    /**
     * Gets the BAC705 value for this PM_AB88View.
     * 
     * @return BAC705
     */
    public java.lang.String getBAC705() {
        return BAC705;
    }


    /**
     * Sets the BAC705 value for this PM_AB88View.
     * 
     * @param BAC705
     */
    public void setBAC705(java.lang.String BAC705) {
        this.BAC705 = BAC705;
    }


    /**
     * Gets the BAC706 value for this PM_AB88View.
     * 
     * @return BAC706
     */
    public java.lang.String getBAC706() {
        return BAC706;
    }


    /**
     * Sets the BAC706 value for this PM_AB88View.
     * 
     * @param BAC706
     */
    public void setBAC706(java.lang.String BAC706) {
        this.BAC706 = BAC706;
    }


    /**
     * Gets the BAC707 value for this PM_AB88View.
     * 
     * @return BAC707
     */
    public java.lang.String getBAC707() {
        return BAC707;
    }


    /**
     * Sets the BAC707 value for this PM_AB88View.
     * 
     * @param BAC707
     */
    public void setBAC707(java.lang.String BAC707) {
        this.BAC707 = BAC707;
    }


    /**
     * Gets the BAC708 value for this PM_AB88View.
     * 
     * @return BAC708
     */
    public java.lang.String getBAC708() {
        return BAC708;
    }


    /**
     * Sets the BAC708 value for this PM_AB88View.
     * 
     * @param BAC708
     */
    public void setBAC708(java.lang.String BAC708) {
        this.BAC708 = BAC708;
    }


    /**
     * Gets the BAC709 value for this PM_AB88View.
     * 
     * @return BAC709
     */
    public java.lang.String getBAC709() {
        return BAC709;
    }


    /**
     * Sets the BAC709 value for this PM_AB88View.
     * 
     * @param BAC709
     */
    public void setBAC709(java.lang.String BAC709) {
        this.BAC709 = BAC709;
    }


    /**
     * Gets the BAC710 value for this PM_AB88View.
     * 
     * @return BAC710
     */
    public java.lang.String getBAC710() {
        return BAC710;
    }


    /**
     * Sets the BAC710 value for this PM_AB88View.
     * 
     * @param BAC710
     */
    public void setBAC710(java.lang.String BAC710) {
        this.BAC710 = BAC710;
    }


    /**
     * Gets the BAC711 value for this PM_AB88View.
     * 
     * @return BAC711
     */
    public java.lang.String getBAC711() {
        return BAC711;
    }


    /**
     * Sets the BAC711 value for this PM_AB88View.
     * 
     * @param BAC711
     */
    public void setBAC711(java.lang.String BAC711) {
        this.BAC711 = BAC711;
    }


    /**
     * Gets the BAC712 value for this PM_AB88View.
     * 
     * @return BAC712
     */
    public java.lang.String getBAC712() {
        return BAC712;
    }


    /**
     * Sets the BAC712 value for this PM_AB88View.
     * 
     * @param BAC712
     */
    public void setBAC712(java.lang.String BAC712) {
        this.BAC712 = BAC712;
    }


    /**
     * Gets the BAE702 value for this PM_AB88View.
     * 
     * @return BAE702
     */
    public java.lang.String getBAE702() {
        return BAE702;
    }


    /**
     * Sets the BAE702 value for this PM_AB88View.
     * 
     * @param BAE702
     */
    public void setBAE702(java.lang.String BAE702) {
        this.BAE702 = BAE702;
    }


    /**
     * Gets the BAE703 value for this PM_AB88View.
     * 
     * @return BAE703
     */
    public java.lang.String getBAE703() {
        return BAE703;
    }


    /**
     * Sets the BAE703 value for this PM_AB88View.
     * 
     * @param BAE703
     */
    public void setBAE703(java.lang.String BAE703) {
        this.BAE703 = BAE703;
    }


    /**
     * Gets the BAE707 value for this PM_AB88View.
     * 
     * @return BAE707
     */
    @ExcelField(title="缴费标志")
    public java.lang.String getBAE707() {
        return BAE707;
    }


    /**
     * Sets the BAE707 value for this PM_AB88View.
     * 
     * @param BAE707
     */
    public void setBAE707(java.lang.String BAE707) {
        this.BAE707 = BAE707;
    }


    /**
     * Gets the BAE708 value for this PM_AB88View.
     * 
     * @return BAE708
     */
    public java.lang.String getBAE708() {
        return BAE708;
    }


    /**
     * Sets the BAE708 value for this PM_AB88View.
     * 
     * @param BAE708
     */
    public void setBAE708(java.lang.String BAE708) {
        this.BAE708 = BAE708;
    }


    /**
     * Gets the BAE709 value for this PM_AB88View.
     * 
     * @return BAE709
     */
    public java.lang.String getBAE709() {
        return BAE709;
    }


    /**
     * Sets the BAE709 value for this PM_AB88View.
     * 
     * @param BAE709
     */
    public void setBAE709(java.lang.String BAE709) {
        this.BAE709 = BAE709;
    }


    /**
     * Gets the BAE711 value for this PM_AB88View.
     * 
     * @return BAE711
     */
    public java.lang.String getBAE711() {
        return BAE711;
    }


    /**
     * Sets the BAE711 value for this PM_AB88View.
     * 
     * @param BAE711
     */
    public void setBAE711(java.lang.String BAE711) {
        this.BAE711 = BAE711;
    }


    /**
     * Gets the BAE712 value for this PM_AB88View.
     * 
     * @return BAE712
     */
    public java.lang.String getBAE712() {
        return BAE712;
    }


    /**
     * Sets the BAE712 value for this PM_AB88View.
     * 
     * @param BAE712
     */
    public void setBAE712(java.lang.String BAE712) {
        this.BAE712 = BAE712;
    }


    /**
     * Gets the BAE713 value for this PM_AB88View.
     * 
     * @return BAE713
     */
    public java.lang.String getBAE713() {
        return BAE713;
    }


    /**
     * Sets the BAE713 value for this PM_AB88View.
     * 
     * @param BAE713
     */
    public void setBAE713(java.lang.String BAE713) {
        this.BAE713 = BAE713;
    }


    /**
     * Gets the BAE714 value for this PM_AB88View.
     * 
     * @return BAE714
     */
    public java.lang.String getBAE714() {
        return BAE714;
    }


    /**
     * Sets the BAE714 value for this PM_AB88View.
     * 
     * @param BAE714
     */
    public void setBAE714(java.lang.String BAE714) {
        this.BAE714 = BAE714;
    }


    /**
     * Gets the BAE715 value for this PM_AB88View.
     * 
     * @return BAE715
     */
    public java.lang.String getBAE715() {
        return BAE715;
    }


    /**
     * Sets the BAE715 value for this PM_AB88View.
     * 
     * @param BAE715
     */
    public void setBAE715(java.lang.String BAE715) {
        this.BAE715 = BAE715;
    }


    /**
     * Gets the BAE716 value for this PM_AB88View.
     * 
     * @return BAE716
     */
    public java.lang.String getBAE716() {
        return BAE716;
    }


    /**
     * Sets the BAE716 value for this PM_AB88View.
     * 
     * @param BAE716
     */
    public void setBAE716(java.lang.String BAE716) {
        this.BAE716 = BAE716;
    }


    /**
     * Gets the BAE717 value for this PM_AB88View.
     * 
     * @return BAE717
     */
    public java.lang.String getBAE717() {
        return BAE717;
    }


    /**
     * Sets the BAE717 value for this PM_AB88View.
     * 
     * @param BAE717
     */
    public void setBAE717(java.lang.String BAE717) {
        this.BAE717 = BAE717;
    }


    /**
     * Gets the BAE740 value for this PM_AB88View.
     * 
     * @return BAE740
     */
    public java.lang.String getBAE740() {
        return BAE740;
    }


    /**
     * Sets the BAE740 value for this PM_AB88View.
     * 
     * @param BAE740
     */
    public void setBAE740(java.lang.String BAE740) {
        this.BAE740 = BAE740;
    }


    /**
     * Gets the BAE741 value for this PM_AB88View.
     * 
     * @return BAE741
     */
    public java.lang.String getBAE741() {
        return BAE741;
    }


    /**
     * Sets the BAE741 value for this PM_AB88View.
     * 
     * @param BAE741
     */
    public void setBAE741(java.lang.String BAE741) {
        this.BAE741 = BAE741;
    }


    /**
     * Gets the BAE742 value for this PM_AB88View.
     * 
     * @return BAE742
     */
    public java.lang.String getBAE742() {
        return BAE742;
    }


    /**
     * Sets the BAE742 value for this PM_AB88View.
     * 
     * @param BAE742
     */
    public void setBAE742(java.lang.String BAE742) {
        this.BAE742 = BAE742;
    }


    /**
     * Gets the BAE743 value for this PM_AB88View.
     * 
     * @return BAE743
     */
    public java.lang.String getBAE743() {
        return BAE743;
    }


    /**
     * Sets the BAE743 value for this PM_AB88View.
     * 
     * @param BAE743
     */
    public void setBAE743(java.lang.String BAE743) {
        this.BAE743 = BAE743;
    }


    /**
     * Gets the BAE744 value for this PM_AB88View.
     * 
     * @return BAE744
     */
    public java.lang.String getBAE744() {
        return BAE744;
    }


    /**
     * Sets the BAE744 value for this PM_AB88View.
     * 
     * @param BAE744
     */
    public void setBAE744(java.lang.String BAE744) {
        this.BAE744 = BAE744;
    }


    /**
     * Gets the BAE745 value for this PM_AB88View.
     * 
     * @return BAE745
     */
    public java.lang.String getBAE745() {
        return BAE745;
    }


    /**
     * Sets the BAE745 value for this PM_AB88View.
     * 
     * @param BAE745
     */
    public void setBAE745(java.lang.String BAE745) {
        this.BAE745 = BAE745;
    }


    /**
     * Gets the BAE746 value for this PM_AB88View.
     * 
     * @return BAE746
     */
    public java.lang.String getBAE746() {
        return BAE746;
    }


    /**
     * Sets the BAE746 value for this PM_AB88View.
     * 
     * @param BAE746
     */
    public void setBAE746(java.lang.String BAE746) {
        this.BAE746 = BAE746;
    }


    /**
     * Gets the BAE747 value for this PM_AB88View.
     * 
     * @return BAE747
     */
    public java.lang.String getBAE747() {
        return BAE747;
    }


    /**
     * Sets the BAE747 value for this PM_AB88View.
     * 
     * @param BAE747
     */
    public void setBAE747(java.lang.String BAE747) {
        this.BAE747 = BAE747;
    }


    /**
     * Gets the BAE748 value for this PM_AB88View.
     * 
     * @return BAE748
     */
    public java.lang.String getBAE748() {
        return BAE748;
    }


    /**
     * Sets the BAE748 value for this PM_AB88View.
     * 
     * @param BAE748
     */
    public void setBAE748(java.lang.String BAE748) {
        this.BAE748 = BAE748;
    }


    /**
     * Gets the BAE749 value for this PM_AB88View.
     * 
     * @return BAE749
     */
    public java.lang.String getBAE749() {
        return BAE749;
    }


    /**
     * Sets the BAE749 value for this PM_AB88View.
     * 
     * @param BAE749
     */
    public void setBAE749(java.lang.String BAE749) {
        this.BAE749 = BAE749;
    }


    /**
     * Gets the BAE750 value for this PM_AB88View.
     * 
     * @return BAE750
     */
    public java.lang.String getBAE750() {
        return BAE750;
    }


    /**
     * Sets the BAE750 value for this PM_AB88View.
     * 
     * @param BAE750
     */
    public void setBAE750(java.lang.String BAE750) {
        this.BAE750 = BAE750;
    }


    /**
     * Gets the BAE850 value for this PM_AB88View.
     * 
     * @return BAE850
     */
    public java.lang.String getBAE850() {
        return BAE850;
    }


    /**
     * Sets the BAE850 value for this PM_AB88View.
     * 
     * @param BAE850
     */
    public void setBAE850(java.lang.String BAE850) {
        this.BAE850 = BAE850;
    }


    /**
     * Gets the BAE941 value for this PM_AB88View.
     * 
     * @return BAE941
     */
    public java.lang.String getBAE941() {
        return BAE941;
    }


    /**
     * Sets the BAE941 value for this PM_AB88View.
     * 
     * @param BAE941
     */
    public void setBAE941(java.lang.String BAE941) {
        this.BAE941 = BAE941;
    }


    /**
     * Gets the SAA015 value for this PM_AB88View.
     * 
     * @return SAA015
     */
    public java.lang.String getSAA015() {
        return SAA015;
    }


    /**
     * Sets the SAA015 value for this PM_AB88View.
     * 
     * @param SAA015
     */
    public void setSAA015(java.lang.String SAA015) {
        this.SAA015 = SAA015;
    }


    /**
     * Gets the SAA036 value for this PM_AB88View.
     * 
     * @return SAA036
     */
    public java.lang.String getSAA036() {
        return SAA036;
    }


    /**
     * Sets the SAA036 value for this PM_AB88View.
     * 
     * @param SAA036
     */
    public void setSAA036(java.lang.String SAA036) {
        this.SAA036 = SAA036;
    }


    /**
     * Gets the TAA101 value for this PM_AB88View.
     * 
     * @return TAA101
     */
    public java.lang.String getTAA101() {
        return TAA101;
    }


    /**
     * Sets the TAA101 value for this PM_AB88View.
     * 
     * @param TAA101
     */
    public void setTAA101(java.lang.String TAA101) {
        this.TAA101 = TAA101;
    }


    /**
     * Gets the TAA102 value for this PM_AB88View.
     * 
     * @return TAA102
     */
    public java.lang.String getTAA102() {
        return TAA102;
    }


    /**
     * Sets the TAA102 value for this PM_AB88View.
     * 
     * @param TAA102
     */
    public void setTAA102(java.lang.String TAA102) {
        this.TAA102 = TAA102;
    }


    /**
     * Gets the TAA103 value for this PM_AB88View.
     * 
     * @return TAA103
     */
    public java.lang.String getTAA103() {
        return TAA103;
    }


    /**
     * Sets the TAA103 value for this PM_AB88View.
     * 
     * @param TAA103
     */
    public void setTAA103(java.lang.String TAA103) {
        this.TAA103 = TAA103;
    }


    /**
     * Gets the TAA104 value for this PM_AB88View.
     * 
     * @return TAA104
     */
    public java.lang.String getTAA104() {
        return TAA104;
    }


    /**
     * Sets the TAA104 value for this PM_AB88View.
     * 
     * @param TAA104
     */
    public void setTAA104(java.lang.String TAA104) {
        this.TAA104 = TAA104;
    }


    /**
     * Gets the TAA105 value for this PM_AB88View.
     * 
     * @return TAA105
     */
    public java.lang.String getTAA105() {
        return TAA105;
    }


    /**
     * Sets the TAA105 value for this PM_AB88View.
     * 
     * @param TAA105
     */
    public void setTAA105(java.lang.String TAA105) {
        this.TAA105 = TAA105;
    }


    /**
     * Gets the endYM value for this PM_AB88View.
     * 
     * @return endYM
     */
    public java.lang.String getEndYM() {
        return endYM;
    }


    /**
     * Sets the endYM value for this PM_AB88View.
     * 
     * @param endYM
     */
    public void setEndYM(java.lang.String endYM) {
        this.endYM = endYM;
    }


    /**
     * Gets the startYM value for this PM_AB88View.
     * 
     * @return startYM
     */
    public java.lang.String getStartYM() {
        return startYM;
    }


    /**
     * Sets the startYM value for this PM_AB88View.
     * 
     * @param startYM
     */
    public void setStartYM(java.lang.String startYM) {
        this.startYM = startYM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PM_AB88View)) return false;
        PM_AB88View other = (PM_AB88View) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAB001==null && other.getAAB001()==null) || 
             (this.AAB001!=null &&
              this.AAB001.equals(other.getAAB001()))) &&
            ((this.AAB004==null && other.getAAB004()==null) || 
             (this.AAB004!=null &&
              this.AAB004.equals(other.getAAB004()))) &&
            ((this.AAB019==null && other.getAAB019()==null) || 
             (this.AAB019!=null &&
              this.AAB019.equals(other.getAAB019()))) &&
            ((this.AAB020==null && other.getAAB020()==null) || 
             (this.AAB020!=null &&
              this.AAB020.equals(other.getAAB020()))) &&
            ((this.AAB021==null && other.getAAB021()==null) || 
             (this.AAB021!=null &&
              this.AAB021.equals(other.getAAB021()))) &&
            ((this.AAB021_1==null && other.getAAB021_1()==null) || 
             (this.AAB021_1!=null &&
              this.AAB021_1.equals(other.getAAB021_1()))) &&
            ((this.AAB021_2==null && other.getAAB021_2()==null) || 
             (this.AAB021_2!=null &&
              this.AAB021_2.equals(other.getAAB021_2()))) &&
            ((this.AAB021_4==null && other.getAAB021_4()==null) || 
             (this.AAB021_4!=null &&
              this.AAB021_4.equals(other.getAAB021_4()))) &&
            ((this.AAB021_5==null && other.getAAB021_5()==null) || 
             (this.AAB021_5!=null &&
              this.AAB021_5.equals(other.getAAB021_5()))) &&
            ((this.AAB021_6==null && other.getAAB021_6()==null) || 
             (this.AAB021_6!=null &&
              this.AAB021_6.equals(other.getAAB021_6()))) &&
            ((this.AAB022==null && other.getAAB022()==null) || 
             (this.AAB022!=null &&
              this.AAB022.equals(other.getAAB022()))) &&
            ((this.AAB033==null && other.getAAB033()==null) || 
             (this.AAB033!=null &&
              this.AAB033.equals(other.getAAB033()))) &&
            ((this.AAB034==null && other.getAAB034()==null) || 
             (this.AAB034!=null &&
              this.AAB034.equals(other.getAAB034()))) &&
            ((this.AAB037_1==null && other.getAAB037_1()==null) || 
             (this.AAB037_1!=null &&
              this.AAB037_1.equals(other.getAAB037_1()))) &&
            ((this.AAB082==null && other.getAAB082()==null) || 
             (this.AAB082!=null &&
              this.AAB082.equals(other.getAAB082()))) &&
            ((this.AAB083==null && other.getAAB083()==null) || 
             (this.AAB083!=null &&
              this.AAB083.equals(other.getAAB083()))) &&
            ((this.AAB120==null && other.getAAB120()==null) || 
             (this.AAB120!=null &&
              this.AAB120.equals(other.getAAB120()))) &&
            ((this.AAB121==null && other.getAAB121()==null) || 
             (this.AAB121!=null &&
              this.AAB121.equals(other.getAAB121()))) &&
            ((this.AAB122==null && other.getAAB122()==null) || 
             (this.AAB122!=null &&
              this.AAB122.equals(other.getAAB122()))) &&
            ((this.AAB123==null && other.getAAB123()==null) || 
             (this.AAB123!=null &&
              this.AAB123.equals(other.getAAB123()))) &&
            ((this.AAB124==null && other.getAAB124()==null) || 
             (this.AAB124!=null &&
              this.AAB124.equals(other.getAAB124()))) &&
            ((this.AAB137==null && other.getAAB137()==null) || 
             (this.AAB137!=null &&
              this.AAB137.equals(other.getAAB137()))) &&
            ((this.AAD003==null && other.getAAD003()==null) || 
             (this.AAD003!=null &&
              this.AAD003.equals(other.getAAD003()))) &&
            ((this.AAD004==null && other.getAAD004()==null) || 
             (this.AAD004!=null &&
              this.AAD004.equals(other.getAAD004()))) &&
            ((this.AAE002==null && other.getAAE002()==null) || 
             (this.AAE002!=null &&
              this.AAE002.equals(other.getAAE002()))) &&
            ((this.AAE003==null && other.getAAE003()==null) || 
             (this.AAE003!=null &&
              this.AAE003.equals(other.getAAE003()))) &&
            ((this.AAE008==null && other.getAAE008()==null) || 
             (this.AAE008!=null &&
              this.AAE008.equals(other.getAAE008()))) &&
            ((this.AAE009==null && other.getAAE009()==null) || 
             (this.AAE009!=null &&
              this.AAE009.equals(other.getAAE009()))) &&
            ((this.AAE010==null && other.getAAE010()==null) || 
             (this.AAE010!=null &&
              this.AAE010.equals(other.getAAE010()))) &&
            ((this.AAE011==null && other.getAAE011()==null) || 
             (this.AAE011!=null &&
              this.AAE011.equals(other.getAAE011()))) &&
            ((this.AAE013==null && other.getAAE013()==null) || 
             (this.AAE013!=null &&
              this.AAE013.equals(other.getAAE013()))) &&
            ((this.AAE036==null && other.getAAE036()==null) || 
             (this.AAE036!=null &&
              this.AAE036.equals(other.getAAE036()))) &&
            ((this.AAE063==null && other.getAAE063()==null) || 
             (this.AAE063!=null &&
              this.AAE063.equals(other.getAAE063()))) &&
            ((this.AAE064==null && other.getAAE064()==null) || 
             (this.AAE064!=null &&
              this.AAE064.equals(other.getAAE064()))) &&
            ((this.AAE100==null && other.getAAE100()==null) || 
             (this.AAE100!=null &&
              this.AAE100.equals(other.getAAE100()))) &&
            ((this.AAE140==null && other.getAAE140()==null) || 
             (this.AAE140!=null &&
              this.AAE140.equals(other.getAAE140()))) &&
            ((this.AAE143==null && other.getAAE143()==null) || 
             (this.AAE143!=null &&
              this.AAE143.equals(other.getAAE143()))) &&
            ((this.AC88ViewList==null && other.getAC88ViewList()==null) || 
             (this.AC88ViewList!=null &&
              java.util.Arrays.equals(this.AC88ViewList, other.getAC88ViewList()))) &&
            ((this.BAA001==null && other.getBAA001()==null) || 
             (this.BAA001!=null &&
              this.BAA001.equals(other.getBAA001()))) &&
            ((this.BAA005==null && other.getBAA005()==null) || 
             (this.BAA005!=null &&
              this.BAA005.equals(other.getBAA005()))) &&
            ((this.BAB701==null && other.getBAB701()==null) || 
             (this.BAB701!=null &&
              this.BAB701.equals(other.getBAB701()))) &&
            ((this.BAB702==null && other.getBAB702()==null) || 
             (this.BAB702!=null &&
              this.BAB702.equals(other.getBAB702()))) &&
            ((this.BAB703==null && other.getBAB703()==null) || 
             (this.BAB703!=null &&
              this.BAB703.equals(other.getBAB703()))) &&
            ((this.BAB704==null && other.getBAB704()==null) || 
             (this.BAB704!=null &&
              this.BAB704.equals(other.getBAB704()))) &&
            ((this.BAB705==null && other.getBAB705()==null) || 
             (this.BAB705!=null &&
              this.BAB705.equals(other.getBAB705()))) &&
            ((this.BAB706==null && other.getBAB706()==null) || 
             (this.BAB706!=null &&
              this.BAB706.equals(other.getBAB706()))) &&
            ((this.BAB811==null && other.getBAB811()==null) || 
             (this.BAB811!=null &&
              this.BAB811.equals(other.getBAB811()))) &&
            ((this.BAC701==null && other.getBAC701()==null) || 
             (this.BAC701!=null &&
              this.BAC701.equals(other.getBAC701()))) &&
            ((this.BAC702==null && other.getBAC702()==null) || 
             (this.BAC702!=null &&
              this.BAC702.equals(other.getBAC702()))) &&
            ((this.BAC703==null && other.getBAC703()==null) || 
             (this.BAC703!=null &&
              this.BAC703.equals(other.getBAC703()))) &&
            ((this.BAC704==null && other.getBAC704()==null) || 
             (this.BAC704!=null &&
              this.BAC704.equals(other.getBAC704()))) &&
            ((this.BAC705==null && other.getBAC705()==null) || 
             (this.BAC705!=null &&
              this.BAC705.equals(other.getBAC705()))) &&
            ((this.BAC706==null && other.getBAC706()==null) || 
             (this.BAC706!=null &&
              this.BAC706.equals(other.getBAC706()))) &&
            ((this.BAC707==null && other.getBAC707()==null) || 
             (this.BAC707!=null &&
              this.BAC707.equals(other.getBAC707()))) &&
            ((this.BAC708==null && other.getBAC708()==null) || 
             (this.BAC708!=null &&
              this.BAC708.equals(other.getBAC708()))) &&
            ((this.BAC709==null && other.getBAC709()==null) || 
             (this.BAC709!=null &&
              this.BAC709.equals(other.getBAC709()))) &&
            ((this.BAC710==null && other.getBAC710()==null) || 
             (this.BAC710!=null &&
              this.BAC710.equals(other.getBAC710()))) &&
            ((this.BAC711==null && other.getBAC711()==null) || 
             (this.BAC711!=null &&
              this.BAC711.equals(other.getBAC711()))) &&
            ((this.BAC712==null && other.getBAC712()==null) || 
             (this.BAC712!=null &&
              this.BAC712.equals(other.getBAC712()))) &&
            ((this.BAE702==null && other.getBAE702()==null) || 
             (this.BAE702!=null &&
              this.BAE702.equals(other.getBAE702()))) &&
            ((this.BAE703==null && other.getBAE703()==null) || 
             (this.BAE703!=null &&
              this.BAE703.equals(other.getBAE703()))) &&
            ((this.BAE707==null && other.getBAE707()==null) || 
             (this.BAE707!=null &&
              this.BAE707.equals(other.getBAE707()))) &&
            ((this.BAE708==null && other.getBAE708()==null) || 
             (this.BAE708!=null &&
              this.BAE708.equals(other.getBAE708()))) &&
            ((this.BAE709==null && other.getBAE709()==null) || 
             (this.BAE709!=null &&
              this.BAE709.equals(other.getBAE709()))) &&
            ((this.BAE711==null && other.getBAE711()==null) || 
             (this.BAE711!=null &&
              this.BAE711.equals(other.getBAE711()))) &&
            ((this.BAE712==null && other.getBAE712()==null) || 
             (this.BAE712!=null &&
              this.BAE712.equals(other.getBAE712()))) &&
            ((this.BAE713==null && other.getBAE713()==null) || 
             (this.BAE713!=null &&
              this.BAE713.equals(other.getBAE713()))) &&
            ((this.BAE714==null && other.getBAE714()==null) || 
             (this.BAE714!=null &&
              this.BAE714.equals(other.getBAE714()))) &&
            ((this.BAE715==null && other.getBAE715()==null) || 
             (this.BAE715!=null &&
              this.BAE715.equals(other.getBAE715()))) &&
            ((this.BAE716==null && other.getBAE716()==null) || 
             (this.BAE716!=null &&
              this.BAE716.equals(other.getBAE716()))) &&
            ((this.BAE717==null && other.getBAE717()==null) || 
             (this.BAE717!=null &&
              this.BAE717.equals(other.getBAE717()))) &&
            ((this.BAE740==null && other.getBAE740()==null) || 
             (this.BAE740!=null &&
              this.BAE740.equals(other.getBAE740()))) &&
            ((this.BAE741==null && other.getBAE741()==null) || 
             (this.BAE741!=null &&
              this.BAE741.equals(other.getBAE741()))) &&
            ((this.BAE742==null && other.getBAE742()==null) || 
             (this.BAE742!=null &&
              this.BAE742.equals(other.getBAE742()))) &&
            ((this.BAE743==null && other.getBAE743()==null) || 
             (this.BAE743!=null &&
              this.BAE743.equals(other.getBAE743()))) &&
            ((this.BAE744==null && other.getBAE744()==null) || 
             (this.BAE744!=null &&
              this.BAE744.equals(other.getBAE744()))) &&
            ((this.BAE745==null && other.getBAE745()==null) || 
             (this.BAE745!=null &&
              this.BAE745.equals(other.getBAE745()))) &&
            ((this.BAE746==null && other.getBAE746()==null) || 
             (this.BAE746!=null &&
              this.BAE746.equals(other.getBAE746()))) &&
            ((this.BAE747==null && other.getBAE747()==null) || 
             (this.BAE747!=null &&
              this.BAE747.equals(other.getBAE747()))) &&
            ((this.BAE748==null && other.getBAE748()==null) || 
             (this.BAE748!=null &&
              this.BAE748.equals(other.getBAE748()))) &&
            ((this.BAE749==null && other.getBAE749()==null) || 
             (this.BAE749!=null &&
              this.BAE749.equals(other.getBAE749()))) &&
            ((this.BAE750==null && other.getBAE750()==null) || 
             (this.BAE750!=null &&
              this.BAE750.equals(other.getBAE750()))) &&
            ((this.BAE850==null && other.getBAE850()==null) || 
             (this.BAE850!=null &&
              this.BAE850.equals(other.getBAE850()))) &&
            ((this.BAE941==null && other.getBAE941()==null) || 
             (this.BAE941!=null &&
              this.BAE941.equals(other.getBAE941()))) &&
            ((this.SAA015==null && other.getSAA015()==null) || 
             (this.SAA015!=null &&
              this.SAA015.equals(other.getSAA015()))) &&
            ((this.SAA036==null && other.getSAA036()==null) || 
             (this.SAA036!=null &&
              this.SAA036.equals(other.getSAA036()))) &&
            ((this.TAA101==null && other.getTAA101()==null) || 
             (this.TAA101!=null &&
              this.TAA101.equals(other.getTAA101()))) &&
            ((this.TAA102==null && other.getTAA102()==null) || 
             (this.TAA102!=null &&
              this.TAA102.equals(other.getTAA102()))) &&
            ((this.TAA103==null && other.getTAA103()==null) || 
             (this.TAA103!=null &&
              this.TAA103.equals(other.getTAA103()))) &&
            ((this.TAA104==null && other.getTAA104()==null) || 
             (this.TAA104!=null &&
              this.TAA104.equals(other.getTAA104()))) &&
            ((this.TAA105==null && other.getTAA105()==null) || 
             (this.TAA105!=null &&
              this.TAA105.equals(other.getTAA105()))) &&
            ((this.endYM==null && other.getEndYM()==null) || 
             (this.endYM!=null &&
              this.endYM.equals(other.getEndYM()))) &&
            ((this.startYM==null && other.getStartYM()==null) || 
             (this.startYM!=null &&
              this.startYM.equals(other.getStartYM())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAAB001() != null) {
            _hashCode += getAAB001().hashCode();
        }
        if (getAAB004() != null) {
            _hashCode += getAAB004().hashCode();
        }
        if (getAAB019() != null) {
            _hashCode += getAAB019().hashCode();
        }
        if (getAAB020() != null) {
            _hashCode += getAAB020().hashCode();
        }
        if (getAAB021() != null) {
            _hashCode += getAAB021().hashCode();
        }
        if (getAAB021_1() != null) {
            _hashCode += getAAB021_1().hashCode();
        }
        if (getAAB021_2() != null) {
            _hashCode += getAAB021_2().hashCode();
        }
        if (getAAB021_4() != null) {
            _hashCode += getAAB021_4().hashCode();
        }
        if (getAAB021_5() != null) {
            _hashCode += getAAB021_5().hashCode();
        }
        if (getAAB021_6() != null) {
            _hashCode += getAAB021_6().hashCode();
        }
        if (getAAB022() != null) {
            _hashCode += getAAB022().hashCode();
        }
        if (getAAB033() != null) {
            _hashCode += getAAB033().hashCode();
        }
        if (getAAB034() != null) {
            _hashCode += getAAB034().hashCode();
        }
        if (getAAB037_1() != null) {
            _hashCode += getAAB037_1().hashCode();
        }
        if (getAAB082() != null) {
            _hashCode += getAAB082().hashCode();
        }
        if (getAAB083() != null) {
            _hashCode += getAAB083().hashCode();
        }
        if (getAAB120() != null) {
            _hashCode += getAAB120().hashCode();
        }
        if (getAAB121() != null) {
            _hashCode += getAAB121().hashCode();
        }
        if (getAAB122() != null) {
            _hashCode += getAAB122().hashCode();
        }
        if (getAAB123() != null) {
            _hashCode += getAAB123().hashCode();
        }
        if (getAAB124() != null) {
            _hashCode += getAAB124().hashCode();
        }
        if (getAAB137() != null) {
            _hashCode += getAAB137().hashCode();
        }
        if (getAAD003() != null) {
            _hashCode += getAAD003().hashCode();
        }
        if (getAAD004() != null) {
            _hashCode += getAAD004().hashCode();
        }
        if (getAAE002() != null) {
            _hashCode += getAAE002().hashCode();
        }
        if (getAAE003() != null) {
            _hashCode += getAAE003().hashCode();
        }
        if (getAAE008() != null) {
            _hashCode += getAAE008().hashCode();
        }
        if (getAAE009() != null) {
            _hashCode += getAAE009().hashCode();
        }
        if (getAAE010() != null) {
            _hashCode += getAAE010().hashCode();
        }
        if (getAAE011() != null) {
            _hashCode += getAAE011().hashCode();
        }
        if (getAAE013() != null) {
            _hashCode += getAAE013().hashCode();
        }
        if (getAAE036() != null) {
            _hashCode += getAAE036().hashCode();
        }
        if (getAAE063() != null) {
            _hashCode += getAAE063().hashCode();
        }
        if (getAAE064() != null) {
            _hashCode += getAAE064().hashCode();
        }
        if (getAAE100() != null) {
            _hashCode += getAAE100().hashCode();
        }
        if (getAAE140() != null) {
            _hashCode += getAAE140().hashCode();
        }
        if (getAAE143() != null) {
            _hashCode += getAAE143().hashCode();
        }
        if (getAC88ViewList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAC88ViewList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAC88ViewList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBAA001() != null) {
            _hashCode += getBAA001().hashCode();
        }
        if (getBAA005() != null) {
            _hashCode += getBAA005().hashCode();
        }
        if (getBAB701() != null) {
            _hashCode += getBAB701().hashCode();
        }
        if (getBAB702() != null) {
            _hashCode += getBAB702().hashCode();
        }
        if (getBAB703() != null) {
            _hashCode += getBAB703().hashCode();
        }
        if (getBAB704() != null) {
            _hashCode += getBAB704().hashCode();
        }
        if (getBAB705() != null) {
            _hashCode += getBAB705().hashCode();
        }
        if (getBAB706() != null) {
            _hashCode += getBAB706().hashCode();
        }
        if (getBAB811() != null) {
            _hashCode += getBAB811().hashCode();
        }
        if (getBAC701() != null) {
            _hashCode += getBAC701().hashCode();
        }
        if (getBAC702() != null) {
            _hashCode += getBAC702().hashCode();
        }
        if (getBAC703() != null) {
            _hashCode += getBAC703().hashCode();
        }
        if (getBAC704() != null) {
            _hashCode += getBAC704().hashCode();
        }
        if (getBAC705() != null) {
            _hashCode += getBAC705().hashCode();
        }
        if (getBAC706() != null) {
            _hashCode += getBAC706().hashCode();
        }
        if (getBAC707() != null) {
            _hashCode += getBAC707().hashCode();
        }
        if (getBAC708() != null) {
            _hashCode += getBAC708().hashCode();
        }
        if (getBAC709() != null) {
            _hashCode += getBAC709().hashCode();
        }
        if (getBAC710() != null) {
            _hashCode += getBAC710().hashCode();
        }
        if (getBAC711() != null) {
            _hashCode += getBAC711().hashCode();
        }
        if (getBAC712() != null) {
            _hashCode += getBAC712().hashCode();
        }
        if (getBAE702() != null) {
            _hashCode += getBAE702().hashCode();
        }
        if (getBAE703() != null) {
            _hashCode += getBAE703().hashCode();
        }
        if (getBAE707() != null) {
            _hashCode += getBAE707().hashCode();
        }
        if (getBAE708() != null) {
            _hashCode += getBAE708().hashCode();
        }
        if (getBAE709() != null) {
            _hashCode += getBAE709().hashCode();
        }
        if (getBAE711() != null) {
            _hashCode += getBAE711().hashCode();
        }
        if (getBAE712() != null) {
            _hashCode += getBAE712().hashCode();
        }
        if (getBAE713() != null) {
            _hashCode += getBAE713().hashCode();
        }
        if (getBAE714() != null) {
            _hashCode += getBAE714().hashCode();
        }
        if (getBAE715() != null) {
            _hashCode += getBAE715().hashCode();
        }
        if (getBAE716() != null) {
            _hashCode += getBAE716().hashCode();
        }
        if (getBAE717() != null) {
            _hashCode += getBAE717().hashCode();
        }
        if (getBAE740() != null) {
            _hashCode += getBAE740().hashCode();
        }
        if (getBAE741() != null) {
            _hashCode += getBAE741().hashCode();
        }
        if (getBAE742() != null) {
            _hashCode += getBAE742().hashCode();
        }
        if (getBAE743() != null) {
            _hashCode += getBAE743().hashCode();
        }
        if (getBAE744() != null) {
            _hashCode += getBAE744().hashCode();
        }
        if (getBAE745() != null) {
            _hashCode += getBAE745().hashCode();
        }
        if (getBAE746() != null) {
            _hashCode += getBAE746().hashCode();
        }
        if (getBAE747() != null) {
            _hashCode += getBAE747().hashCode();
        }
        if (getBAE748() != null) {
            _hashCode += getBAE748().hashCode();
        }
        if (getBAE749() != null) {
            _hashCode += getBAE749().hashCode();
        }
        if (getBAE750() != null) {
            _hashCode += getBAE750().hashCode();
        }
        if (getBAE850() != null) {
            _hashCode += getBAE850().hashCode();
        }
        if (getBAE941() != null) {
            _hashCode += getBAE941().hashCode();
        }
        if (getSAA015() != null) {
            _hashCode += getSAA015().hashCode();
        }
        if (getSAA036() != null) {
            _hashCode += getSAA036().hashCode();
        }
        if (getTAA101() != null) {
            _hashCode += getTAA101().hashCode();
        }
        if (getTAA102() != null) {
            _hashCode += getTAA102().hashCode();
        }
        if (getTAA103() != null) {
            _hashCode += getTAA103().hashCode();
        }
        if (getTAA104() != null) {
            _hashCode += getTAA104().hashCode();
        }
        if (getTAA105() != null) {
            _hashCode += getTAA105().hashCode();
        }
        if (getEndYM() != null) {
            _hashCode += getEndYM().hashCode();
        }
        if (getStartYM() != null) {
            _hashCode += getStartYM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PM_AB88View.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB001");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB001"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB004");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB004"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB019");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB019"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB020");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB020"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021_1");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021_2");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021_4");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021_4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021_5");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021_5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB021_6");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB021_6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB022");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB022"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB033");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB033"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB034");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB034"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB037_1");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB037_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB082");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB082"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB083");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB083"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB120");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB120"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB121");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB121"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB122");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB122"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB123");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB123"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB124");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB124"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB137");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB137"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAD003");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAD003"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAD004");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAD004"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE002");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE002"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE003");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE003"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE008");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE008"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE009");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE009"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE010");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE010"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE011");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE011"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE013");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE013"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE036");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE036"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE063");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE063"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE064");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE064"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE100");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE100"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE140");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE140"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE143");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE143"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AC88ViewList");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AC88ViewList"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAA001");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAA001"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAA005");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAA005"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB701");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB701"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB702");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB702"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB703");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB703"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB704");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB704"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB705");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB705"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB706");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB706"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAB811");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAB811"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC701");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC701"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC702");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC702"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC703");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC703"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC704");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC704"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC705");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC705"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC706");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC706"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC707");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC707"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC708");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC708"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC709");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC709"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC710");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC710"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC711");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC711"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAC712");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAC712"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE702");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE702"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE703");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE703"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE707");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE707"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE708");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE708"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE709");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE709"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE711");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE711"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE712");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE712"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE713");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE713"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE714");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE714"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE715");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE715"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE716");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE716"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE717");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE717"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE740");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE740"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE741");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE741"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE742");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE742"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE743");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE743"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE744");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE744"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE745");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE745"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE746");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE746"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE747");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE747"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE748");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE748"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE749");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE749"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE750");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE750"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE850");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE850"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAE941");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BAE941"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAA015");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SAA015"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SAA036");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SAA036"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAA101");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "TAA101"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAA102");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "TAA102"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAA103");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "TAA103"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAA104");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "TAA104"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TAA105");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "TAA105"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endYM");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "endYM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startYM");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "startYM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
