package com.thinkgem.jeesite.modules.nwws.client;

/*
 生成静态代码常量

 全部常量数据SQL：
 select ' 	//'|| REPLACE(     CODE_TYPE||'_'||NAME , chr(10) ,'')             ||chr(13)||chr(10)||'	  public static final String '
 ||CODE_TYPE||'_'||VALUEID||' = "' || VALUE || '" ; '
 from JWHAT_DD_STATIC_CODE
 where CODE_TYPE IN (select code_type from JWHAT_DD_CODE_DECLARE WHERE CAT_ID IN ('A','I','J','K','L','M') ) OR CODE_TYPE='Boolean'
 order by CODE_TYPE,VALUEID;

 指定代码类型SQL：
 select ' 	//'|| REPLACE(     CODE_TYPE||'_'||NAME , chr(10) ,'')             ||chr(13)||chr(10)||'	  public static final String '
 ||CODE_TYPE||'_'||VALUEID||' = "' || VALUE || '" ; '
 from JWHAT_DD_STATIC_CODE where CODE_TYPE='ParameterType'
 */
public interface CodeConstant {

    //失业单位缴费核定超限月份上限
    public static final Integer SY_MAXMONTH = 3;
    //单位缴费状态
    public static final String BAE707_BAE707_1 = "1";//已结算
    public static final String BAE707_BAE707_2 = "2";//未结算

    public static final String YB_USER_PREFIX = "YB";//医保用户前缀
	public static final String SY_USER_PREFIX = "SY";//失业用户前缀
	public static final String REGISTER_DATE = "2017-05-04 08:08:08";//注册时间
	public static final String BKC288_1 = "1"; //查询所有
	public static final String BKC288_2 = "2"; //根据输入的转移信息返回.
	
	public static final int SY_PAGE_SIZE = 20;
	public static final int SY_DEFAULT_PAGENO = 1;
	public static final int SY_DEFAULT_PAGE_SIZE = 0;
	public static final int SY_DEFAULT_LIST_SIZE = 0;
	public static final String SY_SSA004_0 = "0";
	public static final String SY_SSA004_1 = "1";
	
	//失业保险业务ID
	public static final String SY_BUS_ID_0 = "0";
	public static final String SY_BUS_ID_1 = "1";//失业保险续保批量操作.

	 //医疗基数申报选择修改
	 public static final String YB_BUS_ID_0 = "0";
	 //医疗基数申报批量导入
	 public static final String YB_BUS_ID_1 = "1";
	
	// 社保卡审核
	public static final String BAZ344_BAZ344_50 = "50";
	public static final String BAZ344_BAZ344_51 = "51";
	public static final String BAZ344_BAZ344_52 = "52";
	public static final String BAZ344_BAZ344_58 = "58";
	// BAZ344_社保卡信息查询无需密码
	public static final String BAZ344_BAZ344_59 = "59";
	// BAZ344_个人制卡进度查询SSC109
	public static final String BAZ344_BAZ344_61 = "61";
	// BAZ344_个人信息查询并且返回个人照片信息
	public static final String BAZ344_BAZ344_62 = "62";
	public static final String BAZ417_BAZ417_10 = "10";
	public static final String BAZ417_BAZ417_20 = "20";
	public static final String BAZ417_BAZ417_30 = "30";
	// 数据来源类型(1:省厅统一采集,2:业务系统采集)
	public static final String BAZ415_BAZ415_1 = "1";
	public static final String BAZ415_BAZ415_2 = "2";
	// 险种个数
	public static final int AAE140_AAE140_SUM = 12;

	// AAB110_AAB110_05社区列表默认值
	public static final String BAA103_BAA103_005 = "21";
	// AAB110_AAB110_06乡镇列表默认值
	public static final String BAA103_BAA103_006 = "11";
	// AAB110_AAB110_09中小学列表默认值
	public static final String BAA103_BAA103_009 = "24";
	// AAB110_AAB110_10大学列表默认值
	public static final String BAA103_BAA103_010 = "22";

	public static final String CAC011_CAC011_DZ103 = "DZ103"; // 农行柜面缴费
	public static final String CAC011_CAC011_DZ105 = "DZ105"; // 建行柜面缴费
	public static final String CAC011_CAC011_DZ999 = "DZ999"; // 建行网上缴费

	// 主体类型-家庭
	public static final String MAIN_TYPE_001 = "001";
	// 主体类型-学校（班级）
	public static final String MAIN_TYPE_002 = "002";
	// 主体类型-个人
	public static final String MAIN_TYPE_003 = "003";

	// 交易状态-查询交易成功
	public static final String TRADE_STATE_01_100 = "100";

	// 交易状态-对应的家庭/学校号码不存在
	public static final String TRADE_STATE_01_101 = "101";

	// 交易状态-无交费申报记录
	public static final String TRADE_STATE_01_102 = "102";

	// 交易状态-主体不唯一
	public static final String TRADE_STATE_01_103 = "103";

	// 交易状态-有特殊人员需至社区认定交费
	public static final String TRADE_STATE_01_104 = "104";

	// 交易状态-交费成功
	public static final String TRADE_STATE_02_200 = "200";

	// 交易状态-交费数据保存失败
	public static final String TRADE_STATE_02_201 = "201";

	// 交易状态-交费数据于实际应缴纳费用不符
	public static final String TRADE_STATE_02_202 = "202";

	// 交易状态-此社保户正处于锁定状态，无法交费
	public static final String TRADE_STATE_02_203 = "203";

	// 交易状态-已交费
	public static final String TRADE_STATE_02_204 = "204";

	// 居民缴费类别
	// 普通居民
	public static final String BAA103_BAA103_011 = "11";
	// 成人低保
	public static final String BAA103_BAA103_012 = "12";
	// 重残
	public static final String BAA103_BAA103_013 = "13";
	// 完全重残
	public static final String BAA103_BAA103_014 = "14";
	// 老人
	public static final String BAA103_BAA103_015 = "15";
	// 三无
	public static final String BAA103_BAA103_016 = "16";
	// 学生
	public static final String BAA103_BAA103_021 = "21";
	// 低保学生儿童
	public static final String BAA103_BAA103_022 = "22";
	// 重残学生儿童
	public static final String BAA103_BAA103_023 = "23";
	// 少年儿童
	public static final String BAA103_BAA103_024 = "24";
	// 低收入家庭未成年人
	public static final String BAA103_BAA103_025 = "25";
	// 普通大学生
	public static final String BAA103_BAA103_031 = "31";
	// 低保大学生
	public static final String BAA103_BAA103_032 = "32";
	// 重残大学生
	public static final String BAA103_BAA103_033 = "33";

	// AAB110_AAB110_01社区
	public static final String AAB110_AAB110_01 = "01";
	// AAB110_AAB110_02乡镇
	public static final String AAB110_AAB110_02 = "02";

	// AAE179_AAE179_5社区
	public static final String AAE179_AAE179_05 = "05";
	// AAE179_AAE179_06乡镇
	public static final String AAE179_AAE179_06 = "06";
	// AAE179_AAE179_09中小学校
	public static final String AAE179_AAE179_09 = "09";
	// AAE179_AAE179_10大学
	public static final String AAE179_AAE179_10 = "10";
	// AAC900_AAC900_01职工
	public static final String AAC900_AAC900_01 = "01";
	// AAC900_AAC900_02居民
	public static final String AAC900_AAC900_02 = "02";
	// AAC900_AAC900_03学生
	public static final String AAC900_AAC900_03 = "03";

	// AAA030_活期利率
	public static final String AAA030_AAA030_11 = "11";
	// AAA030_三个月定期利率
	public static final String AAA030_AAA030_21 = "21";
	// AAA030_六个月定期利率
	public static final String AAA030_AAA030_22 = "22";
	// AAA030_九个月定期利率
	public static final String AAA030_AAA030_23 = "23";
	// AAA030_一年期定期利率
	public static final String AAA030_AAA030_24 = "24";
	// AAA030_二年期定期利率
	public static final String AAA030_AAA030_25 = "25";
	// AAA030_三年期定期利率
	public static final String AAA030_AAA030_26 = "26";
	// AAA030_五年期定期利率
	public static final String AAA030_AAA030_27 = "27";
	// AAA030_十年期定期利率
	public static final String AAA030_AAA030_28 = "28";
	// AAA030_三个月零存整取利率
	public static final String AAA030_AAA030_31 = "31";
	// AAA030_六个月零存整取利率
	public static final String AAA030_AAA030_32 = "32";
	// AAA030_九个月零存整取利率
	public static final String AAA030_AAA030_33 = "33";
	// AAA030_一年期零存整取利率
	public static final String AAA030_AAA030_34 = "34";
	// AAA030_二年期零存整取利率
	public static final String AAA030_AAA030_35 = "35";
	// AAA030_三年期零存整取利率
	public static final String AAA030_AAA030_36 = "36";
	// AAA030_五年期零存整取利率
	public static final String AAA030_AAA030_37 = "37";
	// AAA030_十年期零存整取利率
	public static final String AAA030_AAA030_38 = "38";
	// AAA030_三个月整存整取利率
	public static final String AAA030_AAA030_81 = "81";

	// AAA040_企业缴费比例
	public static final String AAA040_AAA040_1 = "1";
	// AAA040_事业单位缴费比例
	public static final String AAA040_AAA040_2 = "2";
	// AAA040_机关缴费比例
	public static final String AAA040_AAA040_3 = "3";
	// AAA040_私营企业缴费比例
	public static final String AAA040_AAA040_4 = "4";
	// AAA040_个体工商户缴费比例
	public static final String AAA040_AAA040_5 = "5";
	// AAA040
	public static final String AAA040_AAA040_31 = "31";
	// AAA104_不可维护
	public static final String AAA104_AAA104_0 = "0";
	// AAA104_可维护
	public static final String AAA104_AAA104_1 = "1";
	// AAB006_无
	public static final String AAB006_AAB006_00 = "00";
	// AAB006_企业法人营业执照
	public static final String AAB006_AAB006_01 = "01";
	// AAB006_企业营业执照
	public static final String AAB006_AAB006_02 = "02";
	// AAB006_中华人民共和国企业法人营业执照
	public static final String AAB006_AAB006_03 = "03";
	// AAB006_中华人民共和国企业营业执照
	public static final String AAB006_AAB006_04 = "04";
	// AAB006_个人独资企业营业执照
	public static final String AAB006_AAB006_05 = "05";
	// AAB006_合伙企业营业执照
	public static final String AAB006_AAB006_06 = "06";
	// AAB006_个体工商户营业执照
	public static final String AAB006_AAB006_07 = "07";
	// AAB019_企业
	public static final String AAB019_AAB019_10 = "10";
	// AAB019_其他事业单位
	public static final String AAB019_AAB019_20 = "20";
	// AAB019_全额拨款事业单位
	public static final String AAB019_AAB019_21 = "21";
	// AAB019_差额拨款事业单位
	public static final String AAB019_AAB019_22 = "22";
	// AAB019_自收自支事业单位
	public static final String AAB019_AAB019_23 = "23";
	// AAB019_机关
	public static final String AAB019_AAB019_30 = "30";
	// AAB019_社会团体
	public static final String AAB019_AAB019_40 = "40";
	// AAB019_民办非企业单位
	public static final String AAB019_AAB019_50 = "50";
	// AAB019_城镇个体工商户
	public static final String AAB019_AAB019_60 = "60";
	// AAB019_再就业服务中心
	public static final String AAB019_AAB019_70 = "70";
	// AAB019_代缴单位
	public static final String AAB019_AAB019_80 = "80";
	// AAB019_社区服务组织
	public static final String AAB019_AAB019_90 = "90";
	// AAB020_内资
	public static final String AAB020_AAB020_100 = "100";
	// AAB020_国有全资
	public static final String AAB020_AAB020_110 = "110";
	// AAB020_集体全资
	public static final String AAB020_AAB020_120 = "120";
	// AAB020_股份合作
	public static final String AAB020_AAB020_130 = "130";
	// AAB020_联营
	public static final String AAB020_AAB020_140 = "140";
	// AAB020_国有联营
	public static final String AAB020_AAB020_141 = "141";
	// AAB020_集体联营
	public static final String AAB020_AAB020_142 = "142";
	// AAB020_国有与集体联营
	public static final String AAB020_AAB020_143 = "143";
	// AAB020_其他联营
	public static final String AAB020_AAB020_149 = "149";
	// AAB020_有限责任（公司）
	public static final String AAB020_AAB020_150 = "150";
	// AAB020_国有独资（公司）
	public static final String AAB020_AAB020_151 = "151";
	// AAB020_其他有限责任（公司）
	public static final String AAB020_AAB020_159 = "159";
	// AAB020_股份有限（公司）
	public static final String AAB020_AAB020_160 = "160";
	// AAB020_私有
	public static final String AAB020_AAB020_170 = "170";
	// AAB020_私有独资
	public static final String AAB020_AAB020_171 = "171";
	// AAB020_私有合伙
	public static final String AAB020_AAB020_172 = "172";
	// AAB020_私营有限责任（公司）
	public static final String AAB020_AAB020_173 = "173";
	// AAB020_私营股份有限（公司）
	public static final String AAB020_AAB020_174 = "174";
	// AAB020_个体经营
	public static final String AAB020_AAB020_175 = "175";
	// AAB020_其他私有
	public static final String AAB020_AAB020_179 = "179";
	// AAB020_其他内资
	public static final String AAB020_AAB020_190 = "190";
	// AAB020_港、澳、台投资
	public static final String AAB020_AAB020_200 = "200";
	// AAB020_内地和港、澳、台合资
	public static final String AAB020_AAB020_210 = "210";
	// AAB020_内地和港、澳、台合作
	public static final String AAB020_AAB020_220 = "220";
	// AAB020_港、澳、台独资
	public static final String AAB020_AAB020_230 = "230";
	// AAB020_港、澳、台投资股份有限（公司）
	public static final String AAB020_AAB020_240 = "240";
	// AAB020_其他港、澳、台投资
	public static final String AAB020_AAB020_290 = "290";
	// AAB020_国外投资
	public static final String AAB020_AAB020_300 = "300";
	// AAB020_中外合资
	public static final String AAB020_AAB020_310 = "310";
	// AAB020_中外合作
	public static final String AAB020_AAB020_320 = "320";
	// AAB020_外资
	public static final String AAB020_AAB020_330 = "330";
	// AAB020_国外投资股份有限（公司）
	public static final String AAB020_AAB020_340 = "340";
	// AAB020_其他国外投资
	public static final String AAB020_AAB020_390 = "390";
	// AAB020_其他
	public static final String AAB020_AAB020_900 = "900";
	// AAB021_无
	public static final String AAB021_AAB021_0 = "0";
	// AAB021_中央
	public static final String AAB021_AAB021_1 = "1";
	// AAB021_省
	public static final String AAB021_AAB021_2 = "2";
	// AAB021_计划单列市
	public static final String AAB021_AAB021_3 = "3";
	// AAB021_市、地区
	public static final String AAB021_AAB021_4 = "4";
	// AAB021_县
	public static final String AAB021_AAB021_5 = "5";
	// AAB021_乡镇
	public static final String AAB021_AAB021_6 = "6";
	// AAB021_部队
	public static final String AAB021_AAB021_7 = "7";
	// AAB021_其他
	public static final String AAB021_AAB021_9 = "9";
	// AAB022_无
	public static final String AAB022_AAB022_00 = "00";
	// AAB022_农、林、牧、渔业
	public static final String AAB022_AAB022_01 = "01";
	// AAB022_采矿业
	public static final String AAB022_AAB022_02 = "02";
	// AAB022_制造业
	public static final String AAB022_AAB022_03 = "03";
	// AAB022_电力、煤气及水的生产和供应业
	public static final String AAB022_AAB022_04 = "04";
	// AAB022_建筑业
	public static final String AAB022_AAB022_05 = "05";
	// AAB022_交通运输、仓储和邮政业
	public static final String AAB022_AAB022_06 = "06";
	// AAB022_信息传输、计算机服务和软件
	public static final String AAB022_AAB022_07 = "07";
	// AAB022_批发和零售贸易
	public static final String AAB022_AAB022_08 = "08";
	// AAB022_住宿和餐饮业
	public static final String AAB022_AAB022_09 = "09";
	// AAB022_金融业
	public static final String AAB022_AAB022_10 = "10";
	// AAB022_房地产业
	public static final String AAB022_AAB022_11 = "11";
	// AAB022_租赁和商务服务业
	public static final String AAB022_AAB022_12 = "12";
	// AAB022_科学研究、技术服务和地质勘查业
	public static final String AAB022_AAB022_13 = "13";
	// AAB022_水利、环境和公共设施管理业
	public static final String AAB022_AAB022_14 = "14";
	// AAB022_居民服务和其他服务业
	public static final String AAB022_AAB022_15 = "15";
	// AAB022_教育
	public static final String AAB022_AAB022_16 = "16";
	// AAB022_卫生、社会保障和社会福利业
	public static final String AAB022_AAB022_17 = "17";
	// AAB022_文化、体育和娱乐业
	public static final String AAB022_AAB022_18 = "18";
	// AAB022_公共管理和社会组织
	public static final String AAB022_AAB022_19 = "19";
	// AAB022_国际组织
	public static final String AAB022_AAB022_20 = "20";
	// AAB033_银行托收
	public static final String AAB033_AAB033_1 = "1";
	// AAB033_税务征收
	public static final String AAB033_AAB033_2 = "2";
	// AAB033_经办机构自收
	public static final String AAB033_AAB033_3 = "3";
	// AAB033_代理机构征收
	public static final String AAB033_AAB033_4 = "4";
	// AAB033_其他方式
	public static final String AAB033_AAB033_9 = "9";
	// AAB034_西安市
	public static final String AAB034_AAB034_610100 = "610100";
	// AAB034_西安市新城区养老保险经办中心
	public static final String AAB034_AAB034_610102 = "610102";
	// AAB034_西安市碑林区养老保险经办中心
	public static final String AAB034_AAB034_610103 = "610103";
	// AAB034_西安市莲湖区养老保险经办中心
	public static final String AAB034_AAB034_610104 = "610104";
	// AAB034_西安市灞桥区养老保险经办中心
	public static final String AAB034_AAB034_610111 = "610111";
	// AAB034_西安市未央区养老保险经办中心
	public static final String AAB034_AAB034_610112 = "610112";
	// AAB034_西安市雁塔区养老保险经办中心
	public static final String AAB034_AAB034_610113 = "610113";
	// AAB034_西安市阎良区养老保险经办中心
	public static final String AAB034_AAB034_610114 = "610114";
	// AAB034_西安市高新区养老保险经办中心
	public static final String AAB034_AAB034_610115 = "610115";
	// AAB034_西安市经济开发区养老保险经办中心
	public static final String AAB034_AAB034_610116 = "610116";
	// AAB034_西安市长安区养老保险经办中心
	public static final String AAB034_AAB034_610121 = "610121";
	// AAB034_西安市蓝田县养老保险经办中心
	public static final String AAB034_AAB034_610122 = "610122";
	// AAB034_西安市临潼区养老保险经办中心
	public static final String AAB034_AAB034_610123 = "610123";
	// AAB034_西安市周至县养老保险经办中心
	public static final String AAB034_AAB034_610124 = "610124";
	// AAB034_西安市户县养老保险经办中心
	public static final String AAB034_AAB034_610125 = "610125";
	// AAB034_西安市高陵县养老保险经办中心
	public static final String AAB034_AAB034_610126 = "610126";
	// AAB034_西安市市本级养老保险经办处
	public static final String AAB034_AAB034_610199 = "610199";
	// AAB034_铜川市
	public static final String AAB034_AAB034_610200 = "610200";
	// AAB034_铜川市王益区养老保险经办中心
	public static final String AAB034_AAB034_610202 = "610202";
	// AAB034_铜川市印台区养老保险经办中心
	public static final String AAB034_AAB034_610203 = "610203";
	// AAB034_铜川市耀县养老保险经办中心
	public static final String AAB034_AAB034_610221 = "610221";
	// AAB034_铜川市宜君区养老保险经办中心
	public static final String AAB034_AAB034_610222 = "610222";
	// AAB034_铜川市市本级养老保险经办处
	public static final String AAB034_AAB034_610299 = "610299";
	// AAB034_宝鸡市
	public static final String AAB034_AAB034_610300 = "610300";
	// AAB034_宝鸡市渭滨区养老保险经办中心
	public static final String AAB034_AAB034_610302 = "610302";
	// AAB034_宝鸡市金台区养老保险经办中心
	public static final String AAB034_AAB034_610303 = "610303";
	// AAB034_宝鸡市宝鸡县养老保险经办中心
	public static final String AAB034_AAB034_610321 = "610321";
	// AAB034_宝鸡市凤翔县养老保险经办中心
	public static final String AAB034_AAB034_610322 = "610322";
	// AAB034_宝鸡市岐山县养老保险经办中心
	public static final String AAB034_AAB034_610323 = "610323";
	// AAB034_宝鸡市扶风县养老保险经办中心
	public static final String AAB034_AAB034_610324 = "610324";
	// AAB034_宝鸡市眉县养老保险经办中心
	public static final String AAB034_AAB034_610326 = "610326";
	// AAB034_宝鸡市陇县养老保险经办中心
	public static final String AAB034_AAB034_610327 = "610327";
	// AAB034_宝鸡市千阳县养老保险经办中心
	public static final String AAB034_AAB034_610328 = "610328";
	// AAB034_宝鸡市麟游县养老保险经办中心
	public static final String AAB034_AAB034_610329 = "610329";
	// AAB034_宝鸡市凤县养老保险经办中心
	public static final String AAB034_AAB034_610330 = "610330";
	// AAB034_宝鸡市太白县养老保险经办中心
	public static final String AAB034_AAB034_610331 = "610331";
	// AAB034_宝鸡市市本级养老保险经办处
	public static final String AAB034_AAB034_610399 = "610399";
	// AAB034_61040001 在新增，删除,修改异地安置人员信息时同步到异地就医核心系统用来表示BAB721。
	public static final String AAB034_FORYDJY_61040001 = "61040001";
	// AAB034_咸阳市
	public static final String AAB034_AAB034_610400 = "610400";
	// AAB034_咸阳市秦都区养老保险经办中心
	public static final String AAB034_AAB034_610402 = "610402";
	// AAB034_咸阳市渭城区养老保险经办中心
	public static final String AAB034_AAB034_610404 = "610404";
	// AAB034_咸阳市三原县养老保险经办中心
	public static final String AAB034_AAB034_610422 = "610422";
	// AAB034_咸阳市泾阳县养老保险经办中心
	public static final String AAB034_AAB034_610423 = "610423";
	// AAB034_咸阳市乾县养老保险经办中心
	public static final String AAB034_AAB034_610424 = "610424";
	// AAB034_咸阳市礼泉县养老保险经办中心
	public static final String AAB034_AAB034_610425 = "610425";
	// AAB034_咸阳市永寿县养老保险经办中心
	public static final String AAB034_AAB034_610426 = "610426";
	// AAB034_咸阳市彬县养老保险经办中心
	public static final String AAB034_AAB034_610427 = "610427";
	// AAB034_咸阳市长武县养老保险经办中心
	public static final String AAB034_AAB034_610428 = "610428";
	// AAB034_咸阳市旬邑县养老保险经办中心
	public static final String AAB034_AAB034_610429 = "610429";
	// AAB034_咸阳市淳化县养老保险经办中心
	public static final String AAB034_AAB034_610430 = "610430";
	// AAB034_咸阳市武功县养老保险经办中心
	public static final String AAB034_AAB034_610431 = "610431";
	// AAB034_咸阳市兴平市养老保险经办中心
	public static final String AAB034_AAB034_610481 = "610481";
	// AAB034_咸阳市市本级养老保险经办处
	public static final String AAB034_AAB034_610499 = "610499";
	// AAB034_渭南市
	public static final String AAB034_AAB034_610500 = "610500";
	// AAB034_渭南市临渭区养老保险经办中心
	public static final String AAB034_AAB034_610502 = "610502";
	// AAB034_渭南市华县养老保险经办中心
	public static final String AAB034_AAB034_610503 = "610503";
	// AAB034_渭南市潼关县养老保险经办中心
	public static final String AAB034_AAB034_610521 = "610521";
	// AAB034_渭南市大荔县养老保险经办中心
	public static final String AAB034_AAB034_610522 = "610522";
	// AAB034_渭南市合阳县养老保险经办中心
	public static final String AAB034_AAB034_610523 = "610523";
	// AAB034_渭南市澄城县养老保险经办中心
	public static final String AAB034_AAB034_610524 = "610524";
	// AAB034_渭南市蒲城县养老保险经办中心
	public static final String AAB034_AAB034_610525 = "610525";
	// AAB034_渭南市白水县养老保险经办中心
	public static final String AAB034_AAB034_610526 = "610526";
	// AAB034_渭南市富平县养老保险经办中心
	public static final String AAB034_AAB034_610527 = "610527";
	// AAB034_渭南市韩城市养老保险经办中心
	public static final String AAB034_AAB034_610528 = "610528";
	// AAB034_渭南市华阴市养老保险经办中心
	public static final String AAB034_AAB034_610581 = "610581";
	// AAB034_渭南市开发区养老保险经办中心
	public static final String AAB034_AAB034_610582 = "610582";
	// AAB034_渭南市市本级养老保险经办处
	public static final String AAB034_AAB034_610599 = "610599";
	// AAB034_延安市
	public static final String AAB034_AAB034_610600 = "610600";
	// AAB034_延安市宝塔区养老保险经办中心
	public static final String AAB034_AAB034_610602 = "610602";
	// AAB034_延安市延长县养老保险经办中心
	public static final String AAB034_AAB034_610621 = "610621";
	// AAB034_延安市延川县养老保险经办中心
	public static final String AAB034_AAB034_610622 = "610622";
	// AAB034_延安市子长县养老保险经办中心
	public static final String AAB034_AAB034_610623 = "610623";
	// AAB034_延安市安塞县养老保险经办中心
	public static final String AAB034_AAB034_610624 = "610624";
	// AAB034_延安市志丹县养老保险经办中心
	public static final String AAB034_AAB034_610625 = "610625";
	// AAB034_延安市吴期县养老保险经办中心
	public static final String AAB034_AAB034_610626 = "610626";
	// AAB034_延安市甘泉县养老保险经办中心
	public static final String AAB034_AAB034_610627 = "610627";
	// AAB034_延安市富县养老保险经办中心
	public static final String AAB034_AAB034_610628 = "610628";
	// AAB034_延安市洛川县养老保险经办中心
	public static final String AAB034_AAB034_610629 = "610629";
	// AAB034_延安市宜川县养老保险经办中心
	public static final String AAB034_AAB034_610630 = "610630";
	// AAB034_延安市黄龙县养老保险经办中心
	public static final String AAB034_AAB034_610631 = "610631";
	// AAB034_延安市黄陵县养老保险经办中心
	public static final String AAB034_AAB034_610632 = "610632";
	// AAB034_延安市市本级养老保险经办处
	public static final String AAB034_AAB034_610699 = "610699";
	// AAB034_汉中市
	public static final String AAB034_AAB034_610700 = "610700";
	// AAB034_汉中市汉台区养老保险经办中心
	public static final String AAB034_AAB034_610702 = "610702";
	// AAB034_汉中市南郑县养老保险经办中心
	public static final String AAB034_AAB034_610721 = "610721";
	// AAB034_汉中市城固县养老保险经办中心
	public static final String AAB034_AAB034_610722 = "610722";
	// AAB034_汉中市洋县养老保险经办中心
	public static final String AAB034_AAB034_610723 = "610723";
	// AAB034_汉中市西乡县养老保险经办中心
	public static final String AAB034_AAB034_610724 = "610724";
	// AAB034_汉中市勉县养老保险经办中心
	public static final String AAB034_AAB034_610725 = "610725";
	// AAB034_汉中市宁强县养老保险经办中心
	public static final String AAB034_AAB034_610726 = "610726";
	// AAB034_汉中市略阳县养老保险经办中心
	public static final String AAB034_AAB034_610727 = "610727";
	// AAB034_汉中市镇巴县养老保险经办中心
	public static final String AAB034_AAB034_610728 = "610728";
	// AAB034_汉中市留坝县养老保险经办中心
	public static final String AAB034_AAB034_610729 = "610729";
	// AAB034_汉中市佛坪县养老保险经办中心
	public static final String AAB034_AAB034_610730 = "610730";
	// AAB034_汉中市市本级养老保险经办处
	public static final String AAB034_AAB034_610799 = "610799";
	// AAB034_榆林市
	public static final String AAB034_AAB034_610800 = "610800";
	// AAB034_榆林市榆阳县养老保险经办中心
	public static final String AAB034_AAB034_610802 = "610802";
	// AAB034_榆林市神木县养老保险经办中心
	public static final String AAB034_AAB034_610821 = "610821";
	// AAB034_榆林市府谷县养老保险经办中心
	public static final String AAB034_AAB034_610822 = "610822";
	// AAB034_榆林市横山县养老保险经办中心
	public static final String AAB034_AAB034_610823 = "610823";
	// AAB034_榆林市靖边县养老保险经办中心
	public static final String AAB034_AAB034_610824 = "610824";
	// AAB034_榆林市定边县养老保险经办中心
	public static final String AAB034_AAB034_610825 = "610825";
	// AAB034_榆林市绥德县养老保险经办中心
	public static final String AAB034_AAB034_610826 = "610826";
	// AAB034_榆林市米脂县养老保险经办中心
	public static final String AAB034_AAB034_610827 = "610827";
	// AAB034_榆林市佳县养老保险经办中心
	public static final String AAB034_AAB034_610828 = "610828";
	// AAB034_榆林市吴堡县养老保险经办中心
	public static final String AAB034_AAB034_610829 = "610829";
	// AAB034_榆林市清涧县养老保险经办中心
	public static final String AAB034_AAB034_610830 = "610830";
	// AAB034_榆林市子洲县养老保险经办中心
	public static final String AAB034_AAB034_610831 = "610831";
	// AAB034_榆林市市本级养老保险经办处
	public static final String AAB034_AAB034_610899 = "610899";
	// AAB034_安康市
	public static final String AAB034_AAB034_610900 = "610900";
	// AAB034_安康市汉滨区养老保险经办中心
	public static final String AAB034_AAB034_610902 = "610902";
	// AAB034_安康市汉阴县养老保险经办中心
	public static final String AAB034_AAB034_610921 = "610921";
	// AAB034_安康市石泉县养老保险经办中心
	public static final String AAB034_AAB034_610922 = "610922";
	// AAB034_安康市宁陕县养老保险经办中心
	public static final String AAB034_AAB034_610923 = "610923";
	// AAB034_安康市紫阳县养老保险经办中心
	public static final String AAB034_AAB034_610924 = "610924";
	// AAB034_安康市岚皋县养老保险经办中心
	public static final String AAB034_AAB034_610925 = "610925";
	// AAB034_安康市平利县养老保险经办中心
	public static final String AAB034_AAB034_610926 = "610926";
	// AAB034_安康市镇坪县养老保险经办中心
	public static final String AAB034_AAB034_610927 = "610927";
	// AAB034_安康市旬阳县养老保险经办中心
	public static final String AAB034_AAB034_610928 = "610928";
	// AAB034_安康市白河县养老保险经办中心
	public static final String AAB034_AAB034_610929 = "610929";
	// AAB034_安康市市本级养老保险经办处
	public static final String AAB034_AAB034_610999 = "610999";
	// AAB034_商洛市
	public static final String AAB034_AAB034_611000 = "611000";
	// AAB034_商洛市商州区养老保险经办中心
	public static final String AAB034_AAB034_611001 = "611001";
	// AAB034_商洛市洛南县养老保险经办中心
	public static final String AAB034_AAB034_611021 = "611021";
	// AAB034_商洛市丹凤县养老保险经办中心
	public static final String AAB034_AAB034_611022 = "611022";
	// AAB034_商洛市商南县养老保险经办中心
	public static final String AAB034_AAB034_611023 = "611023";
	// AAB034_商洛市山阳县养老保险经办中心
	public static final String AAB034_AAB034_611024 = "611024";
	// AAB034_商洛市镇安县养老保险经办中心
	public static final String AAB034_AAB034_611025 = "611025";
	// AAB034_商洛市柞水县养老保险经办中心
	public static final String AAB034_AAB034_611026 = "611026";
	// AAB034_商洛市市本级养老保险经办处
	public static final String AAB034_AAB034_611099 = "611099";
	// AAB034_杨凌示范区
	public static final String AAB034_AAB034_611100 = "611100";
	// AAB034_杨凌示范区养老保险经办处
	public static final String AAB034_AAB034_611199 = "611199";
	// AAB034_陕西省劳动和社会保障厅
	public static final String AAB034_AAB034_619600 = "619600";
	// AAB034_省本级
	public static final String AAB034_AAB034_619700 = "619700";
	// AAB034_陕西省医疗保险管理中心
	public static final String AAB034_AAB034_619800 = "619800";
	// AAB034_行业养老
	public static final String AAB034_AAB034_619900 = "619900";
	// AAB051_未参保
	public static final String AAB051_AAB051_0 = "0";
	// AAB051_参保缴费
	public static final String AAB051_AAB051_1 = "1";
	// AAB051_暂停缴费
	public static final String AAB051_AAB051_2 = "2";
	// AAB051_终止参保
	public static final String AAB051_AAB051_3 = "3";
	// AAB081_未申报
	public static final String AAB081_AAB081_0 = "0";
	// AAB081_已申报
	public static final String AAB081_AAB081_1 = "1";
	// AAB081_补申报
	public static final String AAB081_AAB081_2 = "2";
	// AAB086_未加收
	public static final String AAB086_AAB086_0 = "0";
	// AAB086_已加收
	public static final String AAB086_AAB086_1 = "1";
	// AAB086_已结算（退收）
	public static final String AAB086_AAB086_2 = "2";
	// AAB087_未核定
	public static final String AAB087_AAB087_0 = "0";
	// AAB087_已核定
	public static final String AAB087_AAB087_1 = "1";
	// AAB100_单位新参保
	public static final String AAB100_AAB100_1 = "1";
	// AAB100_单位合并
	public static final String AAB100_AAB100_2 = "2";
	// AAB100_单位分立
	public static final String AAB100_AAB100_3 = "3";
	// AAB100_单位破产
	public static final String AAB100_AAB100_4 = "4";
	// AAB100_单位成建制转出
	public static final String AAB100_AAB100_5 = "5";
	// AAB100_单位成建制转入
	public static final String AAB100_AAB100_6 = "6";
	// AAB100_单位其他终止
	public static final String AAB100_AAB100_9 = "9";
	// AAB165_未足额缴费（欠缴）
	public static final String AAB165_AAB165_0 = "0";
	// AAB165_已足额缴费（已缴）
	public static final String AAB165_AAB165_1 = "1";
	// AAB165_缓缴
	public static final String AAB165_AAB165_2 = "2";
	// AAB165_已挂帐
	public static final String AAB165_AAB165_3 = "3";
	// AAB165_已核销
	public static final String AAB165_AAB165_4 = "4";
	// AAB166_未发出征集通知
	public static final String AAB166_AAB166_0 = "0";
	// AAB166_已发出征集通知
	public static final String AAB166_AAB166_1 = "1";
	// AAB192_未划分
	public static final String AAB192_AAB192_0 = "0";
	// AAB192_已划分
	public static final String AAB192_AAB192_1 = "1";
	// AAB200_不区分
	public static final String AAB200_AAB200_0 = "0";
	// AAB200_个人
	public static final String AAB200_AAB200_1 = "1";
	// AAB200_单位
	public static final String AAB200_AAB200_2 = "2";
	// AAB230_单位足额缴费
	public static final String AAB230_AAB230_1 = "1";
	// AAB230_单位未足额缴费
	public static final String AAB230_AAB230_2 = "2";
	// AAB230_不参与单位结算的补收
	public static final String AAB230_AAB230_3 = "3";
	// AAB230_个人补缴欠款
	public static final String AAB230_AAB230_4 = "4";
	// AAB262_未还款
	public static final String AAB262_AAB262_0 = "0";
	// AAB262_逾期未还
	public static final String AAB262_AAB262_1 = "1";
	// AAB262_按时还款
	public static final String AAB262_AAB262_2 = "2";
	// AAB262_逾期还款
	public static final String AAB262_AAB262_3 = "3";
	// AAB270_加收10%补收
	public static final String AAB270_AAB270_1 = "1";
	// AAB270_加收10%退收
	public static final String AAB270_AAB270_2 = "2";
	// AAB270_其他补收
	public static final String AAB270_AAB270_3 = "3";
	// AAB270_其他退收
	public static final String AAB270_AAB270_4 = "4";
	// AAB301_陕西省
	public static final String AAB301_AAB301_610000 = "610000";
	// AAB301_西安市
	public static final String AAB301_AAB301_610100 = "610100";
	// AAB301_西安市辖区
	public static final String AAB301_AAB301_610101 = "610101";
	// AAB301_新城区
	public static final String AAB301_AAB301_610102 = "610102";
	// AAB301_碑林区
	public static final String AAB301_AAB301_610103 = "610103";
	// AAB301_莲湖区
	public static final String AAB301_AAB301_610104 = "610104";
	// AAB301_灞桥区
	public static final String AAB301_AAB301_610111 = "610111";
	// AAB301_未央区
	public static final String AAB301_AAB301_610112 = "610112";
	// AAB301_雁塔区
	public static final String AAB301_AAB301_610113 = "610113";
	// AAB301_阎良区
	public static final String AAB301_AAB301_610114 = "610114";
	// AAB301_临潼区
	public static final String AAB301_AAB301_610115 = "610115";
	// AAB301_长安区
	public static final String AAB301_AAB301_610116 = "610116";
	// AAB301_蓝田县
	public static final String AAB301_AAB301_610122 = "610122";
	// AAB301_周至县
	public static final String AAB301_AAB301_610124 = "610124";
	// AAB301_户县
	public static final String AAB301_AAB301_610125 = "610125";
	// AAB301_高陵县
	public static final String AAB301_AAB301_610126 = "610126";
	// AAB301_铜川市
	public static final String AAB301_AAB301_610200 = "610200";
	// AAB301_铜川市辖区
	public static final String AAB301_AAB301_610201 = "610201";
	// AAB301_王益区
	public static final String AAB301_AAB301_610202 = "610202";
	// AAB301_印台区
	public static final String AAB301_AAB301_610203 = "610203";
	// AAB301_耀州区
	public static final String AAB301_AAB301_610204 = "610204";
	// AAB301_宜君县
	public static final String AAB301_AAB301_610222 = "610222";
	// AAB301_宝鸡市
	public static final String AAB301_AAB301_610300 = "610300";
	// AAB301_宝鸡市辖区
	public static final String AAB301_AAB301_610301 = "610301";
	// AAB301_渭滨区
	public static final String AAB301_AAB301_610302 = "610302";
	// AAB301_金台区
	public static final String AAB301_AAB301_610303 = "610303";
	// AAB301_陈仓区
	public static final String AAB301_AAB301_610304 = "610304";
	// AAB301_凤翔县
	public static final String AAB301_AAB301_610322 = "610322";
	// AAB301_岐山县
	public static final String AAB301_AAB301_610323 = "610323";
	// AAB301_扶风县
	public static final String AAB301_AAB301_610324 = "610324";
	// AAB301_眉县
	public static final String AAB301_AAB301_610326 = "610326";
	// AAB301_陇县
	public static final String AAB301_AAB301_610327 = "610327";
	// AAB301_千阳县
	public static final String AAB301_AAB301_610328 = "610328";
	// AAB301_麟游县
	public static final String AAB301_AAB301_610329 = "610329";
	// AAB301_凤县
	public static final String AAB301_AAB301_610330 = "610330";
	// AAB301_太白县
	public static final String AAB301_AAB301_610331 = "610331";
	// AAB301_咸阳市
	public static final String AAB301_AAB301_610400 = "610400";
	// AAB301_咸阳市辖区
	public static final String AAB301_AAB301_610401 = "610401";
	// AAB301_秦都区
	public static final String AAB301_AAB301_610402 = "610402";
	// AAB301_杨凌区
	public static final String AAB301_AAB301_610403 = "610403";
	// AAB301_渭城区
	public static final String AAB301_AAB301_610404 = "610404";
	// AAB301_三原县
	public static final String AAB301_AAB301_610422 = "610422";
	// AAB301_泾阳县
	public static final String AAB301_AAB301_610423 = "610423";
	// AAB301_乾县
	public static final String AAB301_AAB301_610424 = "610424";
	// AAB301_礼泉县
	public static final String AAB301_AAB301_610425 = "610425";
	// AAB301_永寿县
	public static final String AAB301_AAB301_610426 = "610426";
	// AAB301_彬县
	public static final String AAB301_AAB301_610427 = "610427";
	// AAB301_长武县
	public static final String AAB301_AAB301_610428 = "610428";
	// AAB301_旬邑县
	public static final String AAB301_AAB301_610429 = "610429";
	// AAB301_淳化县
	public static final String AAB301_AAB301_610430 = "610430";
	// AAB301_武功县
	public static final String AAB301_AAB301_610431 = "610431";
	// AAB301_兴平市
	public static final String AAB301_AAB301_610481 = "610481";
	// AAB301_渭南市
	public static final String AAB301_AAB301_610500 = "610500";
	// AAB301_渭南市辖区
	public static final String AAB301_AAB301_610501 = "610501";
	// AAB301_临渭区
	public static final String AAB301_AAB301_610502 = "610502";
	// AAB301_华县
	public static final String AAB301_AAB301_610521 = "610521";
	// AAB301_潼关县
	public static final String AAB301_AAB301_610522 = "610522";
	// AAB301_大荔县
	public static final String AAB301_AAB301_610523 = "610523";
	// AAB301_合阳县
	public static final String AAB301_AAB301_610524 = "610524";
	// AAB301_澄城县
	public static final String AAB301_AAB301_610525 = "610525";
	// AAB301_蒲城县
	public static final String AAB301_AAB301_610526 = "610526";
	// AAB301_白水县
	public static final String AAB301_AAB301_610527 = "610527";
	// AAB301_富平县
	public static final String AAB301_AAB301_610528 = "610528";
	// AAB301_韩城市
	public static final String AAB301_AAB301_610581 = "610581";
	// AAB301_华阴市
	public static final String AAB301_AAB301_610582 = "610582";
	// AAB301_延安市
	public static final String AAB301_AAB301_610600 = "610600";
	// AAB301_延安市辖区
	public static final String AAB301_AAB301_610601 = "610601";
	// AAB301_宝塔区
	public static final String AAB301_AAB301_610602 = "610602";
	// AAB301_延长县
	public static final String AAB301_AAB301_610621 = "610621";
	// AAB301_延川县
	public static final String AAB301_AAB301_610622 = "610622";
	// AAB301_子长县
	public static final String AAB301_AAB301_610623 = "610623";
	// AAB301_安塞县
	public static final String AAB301_AAB301_610624 = "610624";
	// AAB301_志丹县
	public static final String AAB301_AAB301_610625 = "610625";
	// AAB301_吴起县
	public static final String AAB301_AAB301_610626 = "610626";
	// AAB301_甘泉县
	public static final String AAB301_AAB301_610627 = "610627";
	// AAB301_富县
	public static final String AAB301_AAB301_610628 = "610628";
	// AAB301_洛川县
	public static final String AAB301_AAB301_610629 = "610629";
	// AAB301_宜川县
	public static final String AAB301_AAB301_610630 = "610630";
	// AAB301_黄龙县
	public static final String AAB301_AAB301_610631 = "610631";
	// AAB301_黄陵县
	public static final String AAB301_AAB301_610632 = "610632";
	// AAB301_汉中市
	public static final String AAB301_AAB301_610700 = "610700";
	// AAB301_汉中市辖区
	public static final String AAB301_AAB301_610701 = "610701";
	// AAB301_汉台区
	public static final String AAB301_AAB301_610702 = "610702";
	// AAB301_南郑县
	public static final String AAB301_AAB301_610721 = "610721";
	// AAB301_城固县
	public static final String AAB301_AAB301_610722 = "610722";
	// AAB301_洋县
	public static final String AAB301_AAB301_610723 = "610723";
	// AAB301_西乡县
	public static final String AAB301_AAB301_610724 = "610724";
	// AAB301_勉县
	public static final String AAB301_AAB301_610725 = "610725";
	// AAB301_宁强县
	public static final String AAB301_AAB301_610726 = "610726";
	// AAB301_略阳县
	public static final String AAB301_AAB301_610727 = "610727";
	// AAB301_镇巴县
	public static final String AAB301_AAB301_610728 = "610728";
	// AAB301_留坝县
	public static final String AAB301_AAB301_610729 = "610729";
	// AAB301_佛坪县
	public static final String AAB301_AAB301_610730 = "610730";
	// AAB301_榆林市
	public static final String AAB301_AAB301_610800 = "610800";
	// AAB301_榆林市辖区
	public static final String AAB301_AAB301_610801 = "610801";
	// AAB301_榆阳区
	public static final String AAB301_AAB301_610802 = "610802";
	// AAB301_神木县
	public static final String AAB301_AAB301_610821 = "610821";
	// AAB301_府谷县
	public static final String AAB301_AAB301_610822 = "610822";
	// AAB301_横山县
	public static final String AAB301_AAB301_610823 = "610823";
	// AAB301_靖边县
	public static final String AAB301_AAB301_610824 = "610824";
	// AAB301_定边县
	public static final String AAB301_AAB301_610825 = "610825";
	// AAB301_绥德县
	public static final String AAB301_AAB301_610826 = "610826";
	// AAB301_米脂县
	public static final String AAB301_AAB301_610827 = "610827";
	// AAB301_佳县
	public static final String AAB301_AAB301_610828 = "610828";
	// AAB301_吴堡县
	public static final String AAB301_AAB301_610829 = "610829";
	// AAB301_清涧县
	public static final String AAB301_AAB301_610830 = "610830";
	// AAB301_子洲县
	public static final String AAB301_AAB301_610831 = "610831";
	// AAB301_安康市
	public static final String AAB301_AAB301_610900 = "610900";
	// AAB301_安康市辖区
	public static final String AAB301_AAB301_610901 = "610901";
	// AAB301_汉滨区
	public static final String AAB301_AAB301_610902 = "610902";
	// AAB301_汉阴县
	public static final String AAB301_AAB301_610921 = "610921";
	// AAB301_石泉县
	public static final String AAB301_AAB301_610922 = "610922";
	// AAB301_宁陕县
	public static final String AAB301_AAB301_610923 = "610923";
	// AAB301_紫阳县
	public static final String AAB301_AAB301_610924 = "610924";
	// AAB301_岚皋县
	public static final String AAB301_AAB301_610925 = "610925";
	// AAB301_平利县
	public static final String AAB301_AAB301_610926 = "610926";
	// AAB301_镇坪县
	public static final String AAB301_AAB301_610927 = "610927";
	// AAB301_旬阳县
	public static final String AAB301_AAB301_610928 = "610928";
	// AAB301_白河县
	public static final String AAB301_AAB301_610929 = "610929";
	// AAB301_商洛市
	public static final String AAB301_AAB301_611000 = "611000";
	// AAB301_商洛市辖区
	public static final String AAB301_AAB301_611001 = "611001";
	// AAB301_商州区
	public static final String AAB301_AAB301_611002 = "611002";
	// AAB301_洛南县
	public static final String AAB301_AAB301_611021 = "611021";
	// AAB301_丹凤县
	public static final String AAB301_AAB301_611022 = "611022";
	// AAB301_商南县
	public static final String AAB301_AAB301_611023 = "611023";
	// AAB301_山阳县
	public static final String AAB301_AAB301_611024 = "611024";
	// AAB301_镇安县
	public static final String AAB301_AAB301_611025 = "611025";
	// AAB301_柞水县
	public static final String AAB301_AAB301_611026 = "611026";
	// AAB341_未通过
	public static final String AAB341_AAB341_0 = "0";
	// AAB341_通过
	public static final String AAB341_AAB341_1 = "1";
	// AAB342_一级单位
	public static final String AAB342_AAB342_0 = "0";
	// AAB342_二级单位
	public static final String AAB342_AAB342_1 = "1";
	// AAB345_单位
	public static final String AAB345_AAB345_1 = "1";
	// AAB345_银行
	public static final String AAB345_AAB345_2 = "2";
	// AAB345_邮局
	public static final String AAB345_AAB345_3 = "3";
	// AAB345_其他
	public static final String AAB345_AAB345_9 = "9";
	// AAC004_男
	public static final String AAC004_AAC004_1 = "1";
	// AAC004_女
	public static final String AAC004_AAC004_2 = "2";
	// AAC004_未说明性别
	public static final String AAC004_AAC004_9 = "9";
	// AAC005_汉族
	public static final String AAC005_AAC005_01 = "01";
	// AAC005_蒙古族
	public static final String AAC005_AAC005_02 = "02";
	// AAC005_回族
	public static final String AAC005_AAC005_03 = "03";
	// AAC005_藏族
	public static final String AAC005_AAC005_04 = "04";
	// AAC005_维吾尔族
	public static final String AAC005_AAC005_05 = "05";
	// AAC005_苗族
	public static final String AAC005_AAC005_06 = "06";
	// AAC005_彝族
	public static final String AAC005_AAC005_07 = "07";
	// AAC005_壮族
	public static final String AAC005_AAC005_08 = "08";
	// AAC005_布依族
	public static final String AAC005_AAC005_09 = "09";
	// AAC005_朝鲜族
	public static final String AAC005_AAC005_10 = "10";
	// AAC005_满族
	public static final String AAC005_AAC005_11 = "11";
	// AAC005_侗族
	public static final String AAC005_AAC005_12 = "12";
	// AAC005_瑶族
	public static final String AAC005_AAC005_13 = "13";
	// AAC005_白族
	public static final String AAC005_AAC005_14 = "14";
	// AAC005_土家族
	public static final String AAC005_AAC005_15 = "15";
	// AAC005_哈尼族
	public static final String AAC005_AAC005_16 = "16";
	// AAC005_哈萨克族
	public static final String AAC005_AAC005_17 = "17";
	// AAC005_傣族
	public static final String AAC005_AAC005_18 = "18";
	// AAC005_黎族
	public static final String AAC005_AAC005_19 = "19";
	// AAC005_傈傈族
	public static final String AAC005_AAC005_20 = "20";
	// AAC005_佤族
	public static final String AAC005_AAC005_21 = "21";
	// AAC005_畲族
	public static final String AAC005_AAC005_22 = "22";
	// AAC005_高山族
	public static final String AAC005_AAC005_23 = "23";
	// AAC005_拉祜族
	public static final String AAC005_AAC005_24 = "24";
	// AAC005_水族
	public static final String AAC005_AAC005_25 = "25";
	// AAC005_东乡族
	public static final String AAC005_AAC005_26 = "26";
	// AAC005_纳西族
	public static final String AAC005_AAC005_27 = "27";
	// AAC005_景颇族
	public static final String AAC005_AAC005_28 = "28";
	// AAC005_柯尔克孜族
	public static final String AAC005_AAC005_29 = "29";
	// AAC005_土族
	public static final String AAC005_AAC005_30 = "30";
	// AAC005_达翰尔族
	public static final String AAC005_AAC005_31 = "31";
	// AAC005_仫佬族
	public static final String AAC005_AAC005_32 = "32";
	// AAC005_羌族
	public static final String AAC005_AAC005_33 = "33";
	// AAC005_布朗族
	public static final String AAC005_AAC005_34 = "34";
	// AAC005_撒拉族
	public static final String AAC005_AAC005_35 = "35";
	// AAC005_毛南族
	public static final String AAC005_AAC005_36 = "36";
	// AAC005_仡佬族
	public static final String AAC005_AAC005_37 = "37";
	// AAC005_锡伯族
	public static final String AAC005_AAC005_38 = "38";
	// AAC005_阿昌族
	public static final String AAC005_AAC005_39 = "39";
	// AAC005_普米族
	public static final String AAC005_AAC005_40 = "40";
	// AAC005_塔吉克族
	public static final String AAC005_AAC005_41 = "41";
	// AAC005_怒族
	public static final String AAC005_AAC005_42 = "42";
	// AAC005_乌孜别克族
	public static final String AAC005_AAC005_43 = "43";
	// AAC005_俄罗斯族
	public static final String AAC005_AAC005_44 = "44";
	// AAC005_鄂温克族
	public static final String AAC005_AAC005_45 = "45";
	// AAC005_德昂族
	public static final String AAC005_AAC005_46 = "46";
	// AAC005_保安族
	public static final String AAC005_AAC005_47 = "47";
	// AAC005_裕固族
	public static final String AAC005_AAC005_48 = "48";
	// AAC005_京族
	public static final String AAC005_AAC005_49 = "49";
	// AAC005_塔塔尔族
	public static final String AAC005_AAC005_50 = "50";
	// AAC005_独龙族
	public static final String AAC005_AAC005_51 = "51";
	// AAC005_鄂伦春族
	public static final String AAC005_AAC005_52 = "52";
	// AAC005_赫哲族
	public static final String AAC005_AAC005_53 = "53";
	// AAC005_门巴族
	public static final String AAC005_AAC005_54 = "54";
	// AAC005_珞巴族
	public static final String AAC005_AAC005_55 = "55";
	// AAC005_基诺族
	public static final String AAC005_AAC005_56 = "56";
	// AAC008_在职
	public static final String AAC008_AAC008_1 = "1";
	// AAC008_退休
	public static final String AAC008_AAC008_2 = "2";
	// AAC008_一次性退休
	public static final String AAC008_AAC008_3 = "3";
	// AAC008_终止
	public static final String AAC008_AAC008_4 = "4";
	// AAC008_待退
	public static final String AAC008_AAC008_5 = "5";
	// AAC008_AAC008_22省属大学生
	public static final String AAC008_AAC008_22 = "22";
	// AAC008_AAC008_23市属大学生
	public static final String AAC008_AAC008_23 = "23";
	// AAC008_AAC008_24市属中小学生
	public static final String AAC008_AAC008_24 = "24";
	// AAC008_AAC008_25县属中小学生及婴幼儿
	public static final String AAC008_AAC008_25 = "25";
	// AAC008_城镇居民儿童
	public static final String AAC008_AAC008_81 = "81";
	// AAC008_城镇居民成人
	public static final String AAC008_AAC008_82 = "82";
	// AAC008_城镇居民老人
	public static final String AAC008_AAC008_83 = "83";
	// AAC008_大学生
	public static final String AAC008_AAC008_84 = "84";
	// AAC008_中小学生
	public static final String AAC008_AAC008_85 = "85";
	// AAC009_城镇（非农业户口）
	public static final String AAC009_AAC009_1 = "1";
	// AAC009_农村（农业户口）
	public static final String AAC009_AAC009_2 = "2";
	// AAC009_外地城镇户口
	public static final String AAC009_AAC009_3 = "3";
	// AAC009_外地非城镇户口
	public static final String AAC009_AAC009_4 = "4";
	// AAC009_待定
	public static final String AAC009_AAC009_5 = "5";
	// AAC011_无
	public static final String AAC011_AAC011_0 = "0";
	// AAC011_博士
	public static final String AAC011_AAC011_11 = "11";
	// AAC011_硕士
	public static final String AAC011_AAC011_12 = "12";
	// AAC011_大学
	public static final String AAC011_AAC011_21 = "21";
	// AAC011_大专
	public static final String AAC011_AAC011_31 = "31";
	// AAC011_中专
	public static final String AAC011_AAC011_40 = "40";
	// AAC011_技校
	public static final String AAC011_AAC011_50 = "50";
	// AAC011_高中
	public static final String AAC011_AAC011_61 = "61";
	// AAC011_职高
	public static final String AAC011_AAC011_62 = "62";
	// AAC011_初中
	public static final String AAC011_AAC011_70 = "70";
	// AAC011_小学
	public static final String AAC011_AAC011_80 = "80";
	// AAC011_文盲
	public static final String AAC011_AAC011_90 = "90";
	// AAC012_无
	public static final String AAC012_AAC012_0 = "0";

	// AAC012_工人
	public static final String AAC012_AAC012_1 = "1";
	// AAC012_农民
	public static final String AAC012_AAC012_2 = "2";
	// AAC012_学生
	public static final String AAC012_AAC012_3 = "3";
	// AAC012_干部
	public static final String AAC012_AAC012_4 = "4";

	// AAC012_部队复员
	public static final String AAC012_AAC012_20 = "20";
	// AAC012_军转干部
	public static final String AAC012_AAC012_21 = "21";
	// AAC012_军转干部师级
	public static final String AAC012_AAC012_22 = "22";
	// AAC012_军转干部团级
	public static final String AAC012_AAC012_23 = "23";
	// AAC012_军转干部营级
	public static final String AAC012_AAC012_24 = "24";
	// AAC012_自由职业者
	public static final String AAC012_AAC012_30 = "30";
	// AAC012_4050人员
	public static final String AAC012_AAC012_40 = "40";
	// AAC012_国家公务员
	public static final String AAC012_AAC012_5 = "5";
	// AAC012_下岗进中心人员
	public static final String AAC012_AAC012_50 = "50";
	// AAC012_现役军人
	public static final String AAC012_AAC012_6 = "6";
	// AAC012_无业人员
	public static final String AAC012_AAC012_7 = "7";
	// AAC012_其他
	public static final String AAC012_AAC012_9 = "9";
	// AAC013_原固定职工
	public static final String AAC013_AAC013_1 = "1";
	// AAC013_城镇合同制职工
	public static final String AAC013_AAC013_2 = "2";
	// AAC013_农民合同制工人
	public static final String AAC013_AAC013_3 = "3";
	// AAC013_临时工
	public static final String AAC013_AAC013_4 = "4";
	// AAC013_其他
	public static final String AAC013_AAC013_9 = "9";
	// AAC014_无专业技术职务
	public static final String AAC014_AAC014_0 = "0";
	// AAC014_正高级技术职务
	public static final String AAC014_AAC014_1 = "1";
	// AAC014_副高级技术职务
	public static final String AAC014_AAC014_2 = "2";
	// AAC014_中级技术职务
	public static final String AAC014_AAC014_3 = "3";
	// AAC014_初级技术职务
	public static final String AAC014_AAC014_4 = "4";
	// AAC015_无工人技术等级
	public static final String AAC015_AAC015_0 = "0";
	// AAC015_职业资格一级（高级技师）
	public static final String AAC015_AAC015_1 = "1";
	// AAC015_职业资格二级（技师）
	public static final String AAC015_AAC015_2 = "2";
	// AAC015_职业资格三级（高级）
	public static final String AAC015_AAC015_3 = "3";
	// AAC015_职业资格四级（中级）
	public static final String AAC015_AAC015_4 = "4";
	// AAC015_职业资格五级（初级）
	public static final String AAC015_AAC015_5 = "5";
	// AAC017_未婚
	public static final String AAC017_AAC017_1 = "1";
	// AAC017_已婚
	public static final String AAC017_AAC017_2 = "2";
	// AAC017_丧偶
	public static final String AAC017_AAC017_3 = "3";
	// AAC017_离婚
	public static final String AAC017_AAC017_4 = "4";
	// AAC017_其他
	public static final String AAC017_AAC017_9 = "9";
	// AAC019_无
	public static final String AAC019_AAC019_0 = "0";
	// AAC019_有毒
	public static final String AAC019_AAC019_1 = "1";
	// AAC019_有害
	public static final String AAC019_AAC019_2 = "2";
	// AAC019_井下
	public static final String AAC019_AAC019_3 = "3";
	// AAC019_高温
	public static final String AAC019_AAC019_4 = "4";
	// AAC019_高空
	public static final String AAC019_AAC019_5 = "5";
	// AAC019_特别繁重体力劳动
	public static final String AAC019_AAC019_6 = "6";
	// AAC019_其他
	public static final String AAC019_AAC019_9 = "9";
	// AAC020_无
	public static final String AAC020_AAC020_0 = "0";
	// AAC020_部、省级
	public static final String AAC020_AAC020_030 = "030";
	// AAC020_相当部、省级
	public static final String AAC020_AAC020_033 = "033";
	// AAC020_副部、副省级
	public static final String AAC020_AAC020_040 = "040";
	// AAC020_相当副部、副省级
	public static final String AAC020_AAC020_043 = "043";
	// AAC020_司、局、地、厅级
	public static final String AAC020_AAC020_050 = "050";
	// AAC020_巡视员
	public static final String AAC020_AAC020_051 = "051";
	// AAC020_相当司局级
	public static final String AAC020_AAC020_053 = "053";
	// AAC020_副司、副局、副地、副厅级
	public static final String AAC020_AAC020_060 = "060";
	// AAC020_助理巡视员
	public static final String AAC020_AAC020_061 = "061";
	// AAC020_相当副司局级
	public static final String AAC020_AAC020_063 = "063";
	// AAC020_县、处级
	public static final String AAC020_AAC020_070 = "070";
	// AAC020_调研员
	public static final String AAC020_AAC020_071 = "071";
	// AAC020_相当处级
	public static final String AAC020_AAC020_073 = "073";
	// AAC020_副县、副处级
	public static final String AAC020_AAC020_080 = "080";
	// AAC020_助理调研员
	public static final String AAC020_AAC020_081 = "081";
	// AAC020_相当副处级
	public static final String AAC020_AAC020_083 = "083";
	// AAC020_科级
	public static final String AAC020_AAC020_090 = "090";
	// AAC020_相当科级
	public static final String AAC020_AAC020_093 = "093";
	// AAC020_副科级
	public static final String AAC020_AAC020_100 = "100";
	// AAC020_相当副科级
	public static final String AAC020_AAC020_103 = "103";
	// AAC020_科员级
	public static final String AAC020_AAC020_110 = "110";
	// AAC020_办事员级
	public static final String AAC020_AAC020_120 = "120";
	// AAC020_无行政职务级别
	public static final String AAC020_AAC020_190 = "190";
	// AAC031_未参保
	public static final String AAC031_AAC031_0 = "0";
	// AAC031_参保缴费
	public static final String AAC031_AAC031_1 = "1";
	// AAC031_暂停缴费
	public static final String AAC031_AAC031_2 = "2";
	// AAC031_终止参保
	public static final String AAC031_AAC031_3 = "3";
	// AAC031_参保不缴费(医保用)
	public static final String AAC031_AAC031_4 = "4";
	// AAC050_新参保
	public static final String AAC050_AAC050_11 = "11";
	// AAC050_续保
	public static final String AAC050_AAC050_12 = "12";
	// AAC050_统筹范围外转入
	public static final String AAC050_AAC050_13 = "13";
	// AAC050_统筹范围内转入
	public static final String AAC050_AAC050_14 = "14";
	// AAC050_退保
	public static final String AAC050_AAC050_21 = "21";
	// AAC050_停保
	public static final String AAC050_AAC050_22 = "22";
	// AAC050_转出统筹范围外
	public static final String AAC050_AAC050_23 = "23";
	// AAC050_统筹范围内转出
	public static final String AAC050_AAC050_24 = "24";
	// AAC050_在职转退休
	public static final String AAC050_AAC050_25 = "25";
	// AAC050_缴费比例类别修改
	public static final String AAC050_AAC050_26 = "26";
	// AAC050_单位基本信息变更
	public static final String AAC050_AAC050_27 = "27";
	// AAC050_分支机构信息变更
	public static final String AAC050_AAC050_28 = "28";
	// AAC050_退休转在职
	public static final String AAC050_AAC050_29 = "29";
	// AAC050_重要信息变更
	public static final String AAC050_AAC050_31 = "31";
	// AAC050_个人缴费工资审核
	public static final String AAC050_AAC050_96 = "96";
	// AAC050_单位缴费工资审核
	public static final String AAC050_AAC050_97 = "97";
	// AAC050_基本信息变更
	public static final String AAC050_AAC050_98 = "98";
	// AAC050_基数变更
	public static final String AAC050_AAC050_99 = "99";
	// AAC070_转出
	public static final String AAC070_AAC070_1 = "1";
	// AAC070_转入
	public static final String AAC070_AAC070_2 = "2";
	// AAC092_未划分
	public static final String AAC092_AAC092_0 = "0";
	// AAC092_已划分
	public static final String AAC092_AAC092_1 = "1";
	// AAC120_补收
	public static final String AAC120_AAC120_1 = "1";
	// AAC120_退收
	public static final String AAC120_AAC120_2 = "2";
	// AAC120_调整补收
	public static final String AAC120_AAC120_3 = "3";
	// AAC122_困难企业
	public static final String AAC122_AAC122_1 = "1";
	// AAC122_一次性安置困难人员
	public static final String AAC122_AAC122_2 = "2";
	// AAC122_对越作战人员
	public static final String AAC122_AAC122_3 = "3";
	// AAC120_个人欠款核定
	public static final String AAC120_AAC120_7 = "7";
	// AAC132_单位缴费核定
	public static final String AAC132_AAC132_1 = "1";
	// AAC132_未申报单位缴费核定
	public static final String AAC132_AAC132_2 = "2";
	// AAC132_缴费基数核定
	public static final String AAC132_AAC132_3 = "3";
	// AAC132_医疗启动金核定
	public static final String AAC132_AAC132_4 = "4";
	// AAC250_已有家庭 (人员参保缴费方式)
	public static final String AAC250_AAC250_1 = "1";
	// AAC250_个人身份 (人员参保缴费方式)
	public static final String AAC250_AAC250_2 = "2";
	// AAC132_差额补退核定
	public static final String AAC132_AAC132_5 = "5";
	// AAD011_单位合并
	public static final String AAD011_AAD011_1 = "1";
	// AAD011_单位分立
	public static final String AAD011_AAD011_2 = "2";
	// AAD032_贷方
	public static final String AAD032_AAD032_D = "D";
	// AAD032_借方
	public static final String AAD032_AAD032_J = "J";
	// AAD122_基础养老金
	public static final String AAD122_AAD122_011 = "011";
	// AAD122_个人帐户养老金
	public static final String AAD122_AAD122_012 = "012";
	// AAD122_过渡性养老金
	public static final String AAD122_AAD122_013 = "013";
	// AAD122_调节金
	public static final String AAD122_AAD122_021 = "021";
	// AAD122_离休费
	public static final String AAD122_AAD122_031 = "031";
	// AAD122_退休费
	public static final String AAD122_AAD122_041 = "041";
	// AAD122_退职费
	public static final String AAD122_AAD122_051 = "051";
	// AAD122_离休人员护理费
	public static final String AAD122_AAD122_061 = "061";
	// AAD122_定期抚恤金
	public static final String AAD122_AAD122_1 = "1";
	// AAD122_综合性补贴
	public static final String AAD122_AAD122_101 = "101";
	// AAD122_取暖费
	public static final String AAD122_AAD122_102 = "102";
	// AAD122_离休加发
	public static final String AAD122_AAD122_103 = "103";
	// AAD122_省财政补贴
	public static final String AAD122_AAD122_104 = "104";
	// AAD122_市财政补贴
	public static final String AAD122_AAD122_105 = "105";
	// AAD122_代发1
	public static final String AAD122_AAD122_106 = "106";
	// AAD122_代发2
	public static final String AAD122_AAD122_107 = "107";
	// AAD122_代发3
	public static final String AAD122_AAD122_108 = "108";
	// AAD122_定期补贴
	public static final String AAD122_AAD122_2 = "2";
	// AAD122_调整增加的基础养老金
	public static final String AAD122_AAD122_401 = "401";
	// AAD122_调整增加的个人帐户养老金
	public static final String AAD122_AAD122_402 = "402";
	// AAE100_无效
	public static final String AAE100_AAE100_0 = "0";
	// AAE100_有效
	public static final String AAE100_AAE100_1 = "1";
	// AAE100_删除的
	public static final String AAE100_AAE100_3 = "3";
	// AAE101_未变更
	public static final String AAE101_AAE101_0 = "0";
	// AAE101_发生变更
	public static final String AAE101_AAE101_1 = "1";
	// AAE102_接收
	public static final String AAE102_AAE102_1 = "1";
	// AAE102_预处理
	public static final String AAE102_AAE102_2 = "2";
	// AAE102_预停保处理
	public static final String AAE102_AAE102_3 = "3";
	// AAE102_办理完毕
	public static final String AAE102_AAE102_4 = "4";
	// AAE103_未发生变更
	public static final String AAE103_AAE103_0 = "0";
	// AAE103_发生变更
	public static final String AAE103_AAE103_1 = "1";
	// AAE104_未发生变更
	public static final String AAE104_AAE104_0 = "0";
	// AAE104_发生变更
	public static final String AAE104_AAE104_1 = "1";
	// AAE105_未发生变更
	public static final String AAE105_AAE105_0 = "0";
	// AAE105_发生变更
	public static final String AAE105_AAE105_1 = "1";
	// AAE106_未发生变更
	public static final String AAE106_AAE106_0 = "0";
	// AAE106_发生变更
	public static final String AAE106_AAE106_1 = "1";
	// AAE107_未发生变更
	public static final String AAE107_AAE107_0 = "0";
	// AAE107_发生变更
	public static final String AAE107_AAE107_1 = "1";
	// AAE108_不参加单位结算
	public static final String AAE108_AAE108_0 = "0";
	// AAE108_参加单位结算
	public static final String AAE108_AAE108_1 = "1";
	// AAE109_不补收利息
	public static final String AAE109_AAE109_0 = "0";
	// AAE109_补收利息
	public static final String AAE109_AAE109_1 = "1";
	// AAE110_未参与缴费核定
	public static final String AAE110_AAE110_0 = "0";
	// AAE110_已参与缴费核定
	public static final String AAE110_AAE110_1 = "1";
	// AAE111_未到帐
	public static final String AAE111_AAE111_0 = "0";
	// AAE111_已到帐
	public static final String AAE111_AAE111_1 = "1";
	// AAE112_未记帐
	public static final String AAE112_AAE112_0 = "0";
	// AAE112_已记帐
	public static final String AAE112_AAE112_1 = "1";
	// AAE113_未记帐
	public static final String AAE113_AAE113_0 = "0";
	// AAE113_已记帐
	public static final String AAE113_AAE113_1 = "1";
	// AAE114_已实缴
	public static final String AAE114_AAE114_1 = "1";
	// AAE114_欠缴
	public static final String AAE114_AAE114_2 = "2";
	// AAE114_已退收
	public static final String AAE114_AAE114_7 = "7";
	// AAE114_已核销
	public static final String AAE114_AAE114_8 = "8";
	// AAE115_已实缴
	public static final String AAE115_AAE115_1 = "1";
	// AAE115_欠缴
	public static final String AAE115_AAE115_2 = "2";
	// AAE115_已退收
	public static final String AAE115_AAE115_7 = "7";
	// AAE115_已核销
	public static final String AAE115_AAE115_8 = "8";
	// AAE116_不可发放
	public static final String AAE116_AAE116_0 = "0";
	// AAE116_可发放
	public static final String AAE116_AAE116_1 = "1";
	// AAE116_复核未通过
	public static final String AAE116_AAE116_2 = "2";
	// AAE116_待遇终止
	public static final String AAE116_AAE116_3 = "3";
	// AAE117_未支付
	public static final String AAE117_AAE117_0 = "0";
	// AAE117_已支付
	public static final String AAE117_AAE117_1 = "1";
	// AAE117_等待支付
	public static final String AAE117_AAE117_2 = "2";
	// AAE117_支付在途
	public static final String AAE117_AAE117_3 = "3";
	// AAE118_未回写
	public static final String AAE118_AAE118_0 = "0";
	// AAE118_已回写
	public static final String AAE118_AAE118_1 = "1";
	// AAE119_待定
	public static final String AAE119_AAE119_0 = "0";
	// AAE119_登记在册
	public static final String AAE119_AAE119_1 = "1";
	// AAE119_破产
	public static final String AAE119_AAE119_2 = "2";
	// AAE119_注销
	public static final String AAE119_AAE119_3 = "3";
	// AAE120_未注销
	public static final String AAE120_AAE120_0 = "0";
	// AAE120_已注销
	public static final String AAE120_AAE120_1 = "1";
	// AAE120_已封存
	public static final String AAE120_AAE120_2 = "2";
	// AAE121_未封锁
	public static final String AAE121_AAE121_0 = "0";
	// AAE121_已封锁
	public static final String AAE121_AAE121_1 = "1";
	// AAE140_基本养老保险
	public static final String AAE140_AAE140_1 = "1";
	// AAE140_失业保险
	public static final String AAE140_AAE140_2 = "2";
	// AAE140_基本医疗保险
	public static final String AAE140_AAE140_3 = "3";
	// AAE140_工伤保险
	public static final String AAE140_AAE140_4 = "4";
	// AAE140_生育保险
	public static final String AAE140_AAE140_5 = "5";
	// AAE140_企业补充养老保险
	public static final String AAE140_AAE140_6 = "6";
	// AAE140_离休医疗保障
	public static final String AAE140_AAE140_7 = "7";
	// AAE140_补充医疗保险
	public static final String AAE140_AAE140_8 = "8";
	// AAE140_公务员医疗补助
	public static final String AAE140_AAE140_9 = "9";
	// AAE140_大额医疗补助
	public static final String AAE140_AAE140_10 = "10";
	// AAE140_医疗照顾人员医疗补助
	public static final String AAE140_AAE140_11 = "11";
	// AAE140_特大病医疗补助
	public static final String AAE140_AAE140_12 = "12";
	// AAE140_特大病医疗补助
	public static final String AAE140_AAE140_13 = "13";
	// AAE140_城镇居民基本医疗保险
	public static final String AAE140_AAE140_390 = "390";
	// AAE141_补发
	public static final String AAE141_AAE141_1 = "1";
	// AAE141_退发
	public static final String AAE141_AAE141_2 = "2";
	// AAE141_调整补发
	public static final String AAE141_AAE141_3 = "3";
	// AAE141_调整退发
	public static final String AAE141_AAE141_4 = "4";
	// AAE141_特殊补发
	public static final String AAE141_AAE141_5 = "5";
	// AAE141_特殊退发
	public static final String AAE141_AAE141_6 = "6";
	// AAE142_银行托收
	public static final String AAE142_AAE142_1 = "1";
	// AAE142_税务征收
	public static final String AAE142_AAE142_2 = "2";
	// AAE142_经办机构自收
	public static final String AAE142_AAE142_3 = "3";
	// AAE142_单位补收
	public static final String AAE142_AAE142_4 = "4";
	// AAE142_零星收款
	public static final String AAE142_AAE142_5 = "5";
	// AAE142_独立人员缴费
	public static final String AAE142_AAE142_6 = "6";
	// AAE142_无征集通知
	public static final String AAE142_AAE142_9 = "9";
	// AAE143_正常应缴记录
	public static final String AAE143_AAE143_1 = "1";
	// AAE143_补收记录
	public static final String AAE143_AAE143_2 = "2";
	// AAE143_按项目缴费
	public static final String AAE143_AAE143_3 = "3";
	// AAE143_调整补收记录
	public static final String AAE143_AAE143_4 = "4";
	// AAE143_补欠缴
	public static final String AAE143_AAE143_11 = "11";
	// AAE143_预缴
	public static final String AAE143_AAE143_12 = "12";
	// AAE143_补基数
	public static final String AAE143_AAE143_13 = "13";
	// AAE143_特殊补收记录
	public static final String AAE143_AAE143_14 = "14";
	// AAE143_退收
	public static final String AAE143_AAE143_18 = "18";
	// AAE143_一次性补收记录
	public static final String AAE143_AAE143_19 = "19";
	// AAE143_补比例
	public static final String AAE143_AAE143_20 = "20";
	// AAE143_补费记录
	public static final String AAE143_AAE143_21 = "21";
	// AAE143_历史缴费记录补录
	public static final String AAE143_AAE143_23 = "23";
	// AAE143_补助记录
	public static final String AAE143_AAE143_31 = "31";
	// AAE143_定额缴费
	public static final String AAE143_AAE143_41 = "41";
	// AAE144_配偶
	public static final String AAE144_AAE144_1 = "1";
	// AAE144_子女
	public static final String AAE144_AAE144_2 = "2";
	// AAE144_父母
	public static final String AAE144_AAE144_3 = "3";
	// AAE144_孤儿
	public static final String AAE144_AAE144_4 = "4";
	// AAE144_孤老
	public static final String AAE144_AAE144_5 = "5";
	// AAE144_其他
	public static final String AAE144_AAE144_9 = "9";
	// AAE145_银行
	public static final String AAE145_AAE145_2 = "2";
	// AAE145_邮局
	public static final String AAE145_AAE145_3 = "3";
	// AAE145_社保自付
	public static final String AAE145_AAE145_4 = "4";
	// AAE146_社区管理
	public static final String AAE146_AAE146_1 = "1";
	// AAE146_社保机构
	public static final String AAE146_AAE146_2 = "2";
	// AAE146_依托企业管理
	public static final String AAE146_AAE146_3 = "3";
	// AAE146_其他管理方式
	public static final String AAE146_AAE146_9 = "9";
	// AAE147_统筹地区
	public static final String AAE147_AAE147_1 = "1";
	// AAE147_省内非统筹地区
	public static final String AAE147_AAE147_2 = "2";
	// AAE147_跨省（外省）
	public static final String AAE147_AAE147_3 = "3";
	// AAE147_境外
	public static final String AAE147_AAE147_4 = "4";
	// AAE160_在职人员新参保
	public static final String AAE160_AAE160_111 = "111";
	// AAE160_在职人员续保
	public static final String AAE160_AAE160_121 = "121";
	// AAE160_在职人员统筹范围外转入
	public static final String AAE160_AAE160_131 = "131";
	// AAE160_在职人员统筹范围内转入
	public static final String AAE160_AAE160_141 = "141";
	// AAE160_退休人员续保
	public static final String AAE160_AAE160_151 = "151";
	// AAE160_在职人员死亡
	public static final String AAE160_AAE160_211 = "211";
	// AAE160_在职人员出国定居
	public static final String AAE160_AAE160_212 = "212";
	// AAE160_在职人员解除劳动合同
	public static final String AAE160_AAE160_221 = "221";
	// AAE160_在职人员辞职
	public static final String AAE160_AAE160_222 = "222";
	// AAE160_在职人员被辞退
	public static final String AAE160_AAE160_223 = "223";
	// AAE160_在职人员参军
	public static final String AAE160_AAE160_224 = "224";
	// AAE160_在职人员上学
	public static final String AAE160_AAE160_225 = "225";
	// AAE160_在职人员劳改劳教
	public static final String AAE160_AAE160_226 = "226";
	// AAE160_在职人员失踪
	public static final String AAE160_AAE160_227 = "227";
	// AAE160_停薪留职
	public static final String AAE160_AAE160_228 = "228";
	// AAE160_其他原因中断缴费
	public static final String AAE160_AAE160_229 = "229";
	// AAE160_在职人员转出统筹范围外
	public static final String AAE160_AAE160_231 = "231";
	// AAE160_在职人员统筹范围内转出
	public static final String AAE160_AAE160_241 = "241";
	// AAE160_在职转退休
	public static final String AAE160_AAE160_251 = "251";
	// AAE160_退休转在职
	public static final String AAE160_AAE160_252 = "252";
	// AAE160_农民工退保
	public static final String AAE160_AAE160_261 = "261";
	// AAE160_其他原因终止缴费
	public static final String AAE160_AAE160_269 = "269";
	// AAE160_正常离退休
	public static final String AAE160_AAE160_411 = "411";
	// AAE160_工伤提前退休
	public static final String AAE160_AAE160_412 = "412";
	// AAE160_特殊工种提前退休
	public static final String AAE160_AAE160_413 = "413";
	// AAE160_因病提前退休
	public static final String AAE160_AAE160_414 = "414";
	// AAE160_其他提前退休
	public static final String AAE160_AAE160_415 = "415";
	// AAE160_一次性退休
	public static final String AAE160_AAE160_416 = "416";
	// AAE160_离退休人员未提供生存
	public static final String AAE160_AAE160_421 = "421";
	// AAE160_离退休人员劳改劳教
	public static final String AAE160_AAE160_422 = "422";
	// AAE160_离退休人员失踪
	public static final String AAE160_AAE160_423 = "423";
	// AAE160_离退休人员待遇续发
	public static final String AAE160_AAE160_431 = "431";
	// AAE160_离退休人员出国定居
	public static final String AAE160_AAE160_441 = "441";
	// AAE160_离退休人员死亡
	public static final String AAE160_AAE160_451 = "451";
	// AAE160_失业人员新增
	public static final String AAE160_AAE160_611 = "611";
	// AAE160_失业人员待遇停发
	public static final String AAE160_AAE160_621 = "621";
	// AAE160_失业人员待遇续发
	public static final String AAE160_AAE160_631 = "631";
	// AAE160_失业人员重新就业
	public static final String AAE160_AAE160_641 = "641";
	// AAE160_失业人员参军
	public static final String AAE160_AAE160_642 = "642";
	// AAE160_失业人员出国定居
	public static final String AAE160_AAE160_643 = "643";
	// AAE160_失业人员退休
	public static final String AAE160_AAE160_644 = "644";
	// AAE160_失业人员劳改劳教
	public static final String AAE160_AAE160_645 = "645";
	// AAE160_失业人员拒不接受职业和就业指导
	public static final String AAE160_AAE160_646 = "646";
	// AAE160_失业人员死亡
	public static final String AAE160_AAE160_647 = "647";
	// AAE160_失业人员待遇到期
	public static final String AAE160_AAE160_648 = "648";
	// AAE160_终止失业待遇其他原因
	public static final String AAE160_AAE160_649 = "649";

	// AAE160_城镇居民户籍外迁
	public static final String AAE160_AAE160_941 = "941";
	// AAE160_城镇居民参军服役
	public static final String AAE160_AAE160_942 = "942";
	// AAE160_城镇居民转职工
	public static final String AAE160_AAE160_943 = "943";
	// AAE160_其他原因终止缴费
	public static final String AAE160_AAE160_949 = "941";

	// AAE162_在职死亡
	public static final String AAE162_AAE162_1 = "1";
	// AAE162_个人账户一次性领取
	public static final String AAE162_AAE162_10 = "10";
	// AAE162_个人账户一次性转统筹
	public static final String AAE162_AAE162_11 = "11";
	// AAE162_在职出国定居
	public static final String AAE162_AAE162_2 = "2";
	// AAE162_退休死亡
	public static final String AAE162_AAE162_3 = "3";
	// AAE162_退休出国定居
	public static final String AAE162_AAE162_4 = "4";
	// AAE162_退休一次性待遇
	public static final String AAE162_AAE162_5 = "5";
	// AAE162_其他
	public static final String AAE162_AAE162_6 = "6";
	// AAE162_供养亲属死亡
	public static final String AAE162_AAE162_7 = "7";
	// AAE162_个人账户拨付
	public static final String AAE162_AAE162_8 = "8";
	// AAE162_个人账户一次性继承
	public static final String AAE162_AAE162_9 = "9";
	// ACK222_普通住院
	public static final String ACK222_ACK222_1 = "1";
	// ACK222_紧急抢救
	public static final String ACK222_ACK222_2 = "2";
	// ACK222_家庭病床
	public static final String ACK222_ACK222_3 = "3";
	// ACK222_市内转入
	public static final String ACK222_ACK222_4 = "4";
	// ACK222_转出市外
	public static final String ACK222_ACK222_5 = "5";
	// ACK222_立体定向放射装置
	public static final String ACK222_ACK222_6 = "6";
	// ACK222_高新技术治疗项目
	public static final String ACK222_ACK222_7 = "7";
	// ACK222_异地住院报销
	public static final String ACK222_ACK222_8 = "8";
	// ACK222_家庭病床
	public static final String ACK222_ACK222_9 = "9";
	// ACK222_精神疾病住院
	public static final String ACK222_ACK222_10 = "10";
	// ACK222_特殊病结算
	public static final String ACK222_ACK222_11 = "11";
	// ACK222_医院内部职工住院
	public static final String ACK222_ACK222_12 = "12";
	// ACK222_异地单病种
	public static final String ACK222_ACK222_13 = "13";
	// ACK222_特殊材料
	public static final String ACK222_ACK222_14 = "14";
	// ACK222_终末期肾病器官移植
	public static final String ACK222_ACK222_15 = "15";
	// ACK222_艾滋病机会性感染
	public static final String ACK222_ACK222_16 = "16";
	// AIA005_某项待遇增加定额
	public static final String AIA005_AIA005_1 = "1";
	// AIA005_某项待遇增加百分比
	public static final String AIA005_AIA005_2 = "2";
	// AIA005_总额增加定额
	public static final String AIA005_AIA005_3 = "3";
	// AIA005_总额增加百分比
	public static final String AIA005_AIA005_4 = "4";
	// AIC140_帐户返还
	public static final String AIC140_AIC140_1 = "1";
	// AIC140_余龄养老金
	public static final String AIC140_AIC140_10 = "10";
	// AIC140_丧葬费
	public static final String AIC140_AIC140_2 = "2";
	// AIC140_一次性抚恤金
	public static final String AIC140_AIC140_3 = "3";
	// AIC140_其他从统筹中支付部分
	public static final String AIC140_AIC140_4 = "4";
	// AIC140_一次性退休支付
	public static final String AIC140_AIC140_5 = "5";
	// AIC140_工伤一次性退保
	public static final String AIC140_AIC140_6 = "6";
	// AIC140_在职死亡支付
	public static final String AIC140_AIC140_7 = "7";
	// AIC140_退休死亡支付
	public static final String AIC140_AIC140_8 = "8";
	// AIC140_退保支付
	public static final String AIC140_AIC140_9 = "9";
	// AIC141_在职
	public static final String AIC141_AIC141_1 = "1";
	// AIC141_离退休
	public static final String AIC141_AIC141_2 = "2";
	// AIC141_供养亲属
	public static final String AIC141_AIC141_3 = "3";
	// AIC144_夫妻
	public static final String AIC144_AIC144_1 = "1";
	// AIC144_子女
	public static final String AIC144_AIC144_2 = "2";
	// AIC144_父母
	public static final String AIC144_AIC144_3 = "3";
	// AIC144_原单位经办人
	public static final String AIC144_AIC144_4 = "4";
	// AIC144_本人
	public static final String AIC144_AIC144_5 = "5";
	// AIC144_其它关系
	public static final String AIC144_AIC144_9 = "9";
	// AIC161_建国前老工人
	public static final String AIC161_AIC161_0 = "0";
	// AIC161_离休
	public static final String AIC161_AIC161_1 = "1";
	// AIC161_正常退休
	public static final String AIC161_AIC161_2 = "2";
	// AIC161_退职
	public static final String AIC161_AIC161_3 = "3";
	// AIC161_因病提前退休
	public static final String AIC161_AIC161_4 = "4";
	// AIC161_特殊工种提前退休
	public static final String AIC161_AIC161_5 = "5";
	// AIC161_工伤提前退休
	public static final String AIC161_AIC161_6 = "6";
	// AIC161_非工残提前退休
	public static final String AIC161_AIC161_7 = "7";
	// AIC161_军转干部退休
	public static final String AIC161_AIC161_8 = "8";
	// AIC161_政策性提前退休
	public static final String AIC161_AIC161_9 = "9";
	// AIC163_非提前退休
	public static final String AIC163_AIC163_0 = "0";
	// AIC163_提前退休
	public static final String AIC163_AIC163_1 = "1";
	// AIC190_新增
	public static final String AIC190_AIC190_1 = "1";
	// AIC190_增资
	public static final String AIC190_AIC190_10 = "10";
	// AIC190_离退休人员统筹范围内转出
	public static final String AIC190_AIC190_11 = "11";
	// AIC190_离退休人员统筹范围内转入
	public static final String AIC190_AIC190_12 = "12";
	// AIC190_离退休人员统筹范围外转出
	public static final String AIC190_AIC190_13 = "13";
	// AIC190_原离退休人员新增调整
	public static final String AIC190_AIC190_14 = "14";
	// AIC190_停发
	public static final String AIC190_AIC190_2 = "2";
	// AIC190_续发
	public static final String AIC190_AIC190_3 = "3";
	// AIC190_离退休人员出国定居
	public static final String AIC190_AIC190_4 = "4";
	// AIC190_离退休人员死亡
	public static final String AIC190_AIC190_5 = "5";
	// AIC190_供养亲属待遇终止
	public static final String AIC190_AIC190_6 = "6";
	// AIC190_离退休待遇终止
	public static final String AIC190_AIC190_7 = "7";
	// AIC190_减少
	public static final String AIC190_AIC190_8 = "8";
	// AIC190_调整
	public static final String AIC190_AIC190_9 = "9";
	// AIC230_基础养老金
	public static final String AIC230_AIC230_011 = "011";
	// AIC230_个人帐户养老金
	public static final String AIC230_AIC230_012 = "012";
	// AIC230_过渡性养老金
	public static final String AIC230_AIC230_013 = "013";
	// AIC230_扣减金额
	public static final String AIC230_AIC230_014 = "014";
	// AIC230_核发差额
	public static final String AIC230_AIC230_015 = "015";
	// AIC230_调节金
	public static final String AIC230_AIC230_021 = "021";
	// AIC230_离休费
	public static final String AIC230_AIC230_031 = "031";
	// AIC230_退休费
	public static final String AIC230_AIC230_041 = "041";
	// AIC230_退职费
	public static final String AIC230_AIC230_051 = "051";
	// AIC230_离休人员护理费
	public static final String AIC230_AIC230_061 = "061";
	// AIC230_交通费
	public static final String AIC230_AIC230_062 = "062";
	// AIC230_离休加发基数
	public static final String AIC230_AIC230_063 = "063";
	// AIC230_349号文标杆
	public static final String AIC230_AIC230_064 = "064";
	// AIC230_统外补贴
	public static final String AIC230_AIC230_065 = "065";
	// AIC230_综合性补贴
	public static final String AIC230_AIC230_101 = "101";
	// AIC230_取暖费
	public static final String AIC230_AIC230_102 = "102";
	// AIC230_离休加发
	public static final String AIC230_AIC230_103 = "103";
	// AIC230_省财政补贴
	public static final String AIC230_AIC230_104 = "104";
	// AIC230_市财政补贴
	public static final String AIC230_AIC230_105 = "105";
	// AIC230_代发1
	public static final String AIC230_AIC230_106 = "106";
	// AIC230_代发2
	public static final String AIC230_AIC230_107 = "107";
	// AIC230_代发3
	public static final String AIC230_AIC230_108 = "108";
	// AIC230_调整增加的基础养老金
	public static final String AIC230_AIC230_401 = "401";
	// AIC230_调整增加的个人帐户养老金
	public static final String AIC230_AIC230_402 = "402";
	// AIC320_定期抚恤金
	public static final String AIC320_AIC320_1 = "1";
	// AIC320_定期补贴
	public static final String AIC320_AIC320_2 = "2";
	// AIC323_无
	public static final String AIC323_AIC323_0 = "0";
	// AIC323_国家劳模
	public static final String AIC323_AIC323_1 = "1";
	// AIC323_省劳模
	public static final String AIC323_AIC323_2 = "2";
	// AIC323_市劳模
	public static final String AIC323_AIC323_3 = "3";
	// AIC323_县劳模
	public static final String AIC323_AIC323_4 = "4";
	// AIC323_其他
	public static final String AIC323_AIC323_5 = "5";
	// AIC324_否
	public static final String AIC324_AIC324_0 = "0";
	// AIC324_是
	public static final String AIC324_AIC324_1 = "1";
	// AIC329_井下
	public static final String AIC329_AIC329_1 = "1";
	// AIC329_有毒
	public static final String AIC329_AIC329_2 = "2";
	// AIC329_有害
	public static final String AIC329_AIC329_3 = "3";
	// AIC329_高温
	public static final String AIC329_AIC329_4 = "4";
	// AIC329_高空
	public static final String AIC329_AIC329_5 = "5";
	// AIC329_特别繁重体力劳动
	public static final String AIC329_AIC329_6 = "6";
	// AIC329_其他
	public static final String AIC329_AIC329_9 = "9";
	// AIC333_否
	public static final String AIC333_AIC333_0 = "0";
	// AIC333_是
	public static final String AIC333_AIC333_1 = "1";
	// AIC336_登记
	public static final String AIC336_AIC336_1 = "1";
	// AIC336_挂失
	public static final String AIC336_AIC336_2 = "2";
	// AIC336_补办
	public static final String AIC336_AIC336_3 = "3";
	// AIC336_解挂
	public static final String AIC336_AIC336_4 = "4";
	// AIC336_终止
	public static final String AIC336_AIC336_5 = "5";
	// AIE001_未调整待遇
	public static final String AIE001_AIE001_0 = "0";
	// AIE001_正在调整待遇
	public static final String AIE001_AIE001_1 = "1";
	// AIE001_调整完毕
	public static final String AIE001_AIE001_2 = "2";
	// AJA001_失业保险金
	public static final String AJA001_AJA001_11 = "11";
	// AJA001_职业介绍补贴
	public static final String AJA001_AJA001_12 = "12";
	// AJA001_职业培训补贴
	public static final String AJA001_AJA001_13 = "13";
	// AJA001_医疗补助金
	public static final String AJA001_AJA001_14 = "14";
	// AJA001_失业人员其他待遇
	public static final String AJA001_AJA001_19 = "19";
	// AJA001_一次性丧葬补助
	public static final String AJA001_AJA001_21 = "21";
	// AJA001_一次性抚恤补助
	public static final String AJA001_AJA001_22 = "22";
	// AJB100_职业介绍
	public static final String AJB100_AJB100_1 = "1";
	// AJB100_职业培训
	public static final String AJB100_AJB100_2 = "2";
	// AJC101_非农民工
	public static final String AJC101_AJC101_0 = "0";
	// AJC101_农民工
	public static final String AJC101_AJC101_1 = "1";
	// AJC110_新增
	public static final String AJC110_AJC110_1 = "1";
	// AJC110_待遇停发
	public static final String AJC110_AJC110_2 = "2";
	// AJC110_待遇续发
	public static final String AJC110_AJC110_3 = "3";
	// AJC110_待遇终止
	public static final String AJC110_AJC110_4 = "4";
	// AKA003_个人缴费金额
	public static final String AKA003_AKA003_1 = "1";
	// AKA003_单位缴费划入帐户金额
	public static final String AKA003_AKA003_2 = "2";
	
	// AJA004_农民工标识
	public static final String AJA004_AJA004_0 = "0";
	// AJA004_农民合同制工人
	public static final String AJA004_AJA004_1 = "1";

	// 收费类别
	// AKA063_西药费
	public static final String AKA063_AKA063_1 = "01";
	// AKA063_中成药
	public static final String AKA063_AKA063_2 = "02";
	// AKA063_中草药
	public static final String AKA063_AKA063_3 = "03";
	// AKA063_诊查费
	public static final String AKA063_AKA063_4 = "04";
	// AKA063_治疗费
	public static final String AKA063_AKA063_8 = "08";
	// AKA063_化验费
	public static final String AKA063_AKA063_9 = "09";
	// AKA063_手术费
	public static final String AKA063_AKA063_10 = "10";
	// AKA063_血费
	public static final String AKA063_AKA063_13 = "13";
	// AKA063_床位费
	public static final String AKA063_AKA063_17 = "17";
	// AKA063_护理费
	public static final String AKA063_AKA063_19 = "19";
	// AKA063_检查费
	public static final String AKA063_AKA063_20 = "20";
	// AKA063_调温费
	public static final String AKA063_AKA063_21 = "21";
	// AKA063_特殊材料费
	public static final String AKA063_AKA063_22 = "22";
	// AKA063_特需服务
	public static final String AKA063_AKA063_23 = "23";
	// AKA063_其他
	public static final String AKA063_AKA063_24 = "24";
	// AKA063_体内置放材料
	public static final String AKA063_AKA063_25 = "25";
	// AKA063_血路管
	public static final String AKA063_AKA063_26 = "26";
	// AKA063_中草药汤剂
	public static final String AKA063_AKA063_27 = "27";
	// AKA063_针灸
	public static final String AKA063_AKA063_28 = "28";
	// AKA063_一般诊疗费
	public static final String AKA063_AKA063_29 = "29";
	public static final String AKA063_AKA063_30 = "30"; // 挂号费
	public static final String AKA063_AKA063_80 = "80"; // 外诊项目

	// AKA064_非处方药
	public static final String AKA064_AKA064_0 = "0";
	// AKA064_处方药
	public static final String AKA064_AKA064_1 = "1";
	// AKA065_甲类
	public static final String AKA065_AKA065_1 = "1";
	// AKA065_乙类
	public static final String AKA065_AKA065_2 = "2";
	// AKA065_丙类
	public static final String AKA065_AKA065_3 = "3";
	// AKA070_注射剂
	public static final String AKA070_AKA070_01 = "01";
	// AKA070_口服常释剂型
	public static final String AKA070_AKA070_02 = "02";
	// AKA070_缓释控释剂型
	public static final String AKA070_AKA070_03 = "03";
	// AKA070_口服液体剂
	public static final String AKA070_AKA070_04 = "04";
	// AKA070_丸剂
	public static final String AKA070_AKA070_05 = "05";
	// AKA070_颗粒剂
	public static final String AKA070_AKA070_06 = "06";
	// AKA070_口服散剂
	public static final String AKA070_AKA070_07 = "07";
	// AKA070_外用散剂
	public static final String AKA070_AKA070_08 = "08";
	// AKA070_软膏剂
	public static final String AKA070_AKA070_09 = "09";
	// AKA070_贴剂
	public static final String AKA070_AKA070_10 = "10";
	// AKA070_外用液体剂
	public static final String AKA070_AKA070_11 = "11";
	// AKA070_硬膏剂
	public static final String AKA070_AKA070_12 = "12";
	// AKA070_凝胶剂
	public static final String AKA070_AKA070_13 = "13";
	// AKA070_涂剂
	public static final String AKA070_AKA070_14 = "14";
	// AKA070_栓剂
	public static final String AKA070_AKA070_15 = "15";
	// AKA070_滴眼剂
	public static final String AKA070_AKA070_16 = "16";
	// AKA070_滴耳剂
	public static final String AKA070_AKA070_17 = "17";
	// AKA070_滴鼻剂
	public static final String AKA070_AKA070_18 = "18";
	// AKA070_吸入剂
	public static final String AKA070_AKA070_19 = "19";
	// AKA080_基本医疗保险
	public static final String AKA080_AKA080_1 = "1";
	// AKA080_大病保险
	public static final String AKA080_AKA080_2 = "2";
	// AKA101_三级特等
	public static final String AKA101_AKA101_01 = "01";
	// AKA101_三级甲等
	public static final String AKA101_AKA101_02 = "02";
	// AKA101_三级乙等
	public static final String AKA101_AKA101_03 = "03";
	// AKA101_三级丙等
	public static final String AKA101_AKA101_04 = "04";
	// AKA101_二级甲等
	public static final String AKA101_AKA101_05 = "05";
	// AKA101_二级乙等
	public static final String AKA101_AKA101_06 = "06";
	// AKA101_二级丙等
	public static final String AKA101_AKA101_07 = "07";
	// AKA101_一级甲等
	public static final String AKA101_AKA101_08 = "08";
	// AKA101_一级乙等
	public static final String AKA101_AKA101_09 = "09";
	// AKA101_一级丙等
	public static final String AKA101_AKA101_10 = "10";
	// AKA101_其他基层医疗机构
	public static final String AKA101_AKA101_11 = "11";
	// AKA101_其他
	public static final String AKA101_AKA101_12 = "12";
	// AKA101_定点药店
	public static final String AKA101_AKA101_13 = "13";
	// AKA103_普通病床
	public static final String AKA103_AKA103_1 = "1";
	// AKA103_CCU病床
	public static final String AKA103_AKA103_2 = "2";
	// AKA103_ICU病床
	public static final String AKA103_AKA103_3 = "3";
	// AKA103_麻醉病床
	public static final String AKA103_AKA103_4 = "4";
	// AKA105_普通病床
	public static final String AKA105_AKA105_1 = "1";
	// AKA105_CCU病床
	public static final String AKA105_AKA105_2 = "2";
	// AKA105_ICU病床
	public static final String AKA105_AKA105_3 = "3";
	// AKA105_麻醉病床
	public static final String AKA105_AKA105_4 = "4";
	// AKA122_传染病科
	public static final String AKA122_AKA122_001 = "001";
	// AKA122_心血管内科
	public static final String AKA122_AKA122_002 = "002";
	// AKA122_呼吸内科
	public static final String AKA122_AKA122_003 = "003";
	// AKA122_消化内科
	public static final String AKA122_AKA122_004 = "004";
	// AKA122_血液内科
	public static final String AKA122_AKA122_005 = "005";
	// AKA122_泌尿内科
	public static final String AKA122_AKA122_006 = "006";
	// AKA122_内分泌科
	public static final String AKA122_AKA122_007 = "007";
	// AKA123_非特殊病种
	public static final String AKA123_AKA123_0 = "0";
	// AKA123_住院特殊病种
	public static final String AKA123_AKA123_1 = "1";
	// AKA123_特殊病种
	public static final String AKA123_AKA123_2 = "2";
	// AKA123_门诊特殊慢性病
	public static final String AKA123_AKA123_3 = "3";
	// AKA123_门诊特殊治疗
	public static final String AKA123_AKA123_4 = "4";
	// AKA123_门诊特检特治
	public static final String AKA123_AKA123_5 = "5";
	// AKA123_立体定向放射装置
	public static final String AKA123_AKA123_6 = "6";
	// AKA123_高新技术治疗项目
	public static final String AKA123_AKA123_7 = "7";
	// AKA123_住院单病种
	public static final String AKA123_AKA123_8 = "8";
	// AKA123_特殊材料住院
	public static final String AKA123_AKA123_9 = "9";
	// AKA123_精神疾病住院
	public static final String AKA123_AKA123_10 = "10";
	// AKA123_结核病住院
	public static final String AKA123_AKA123_11 = "11";
	// AKA123_门诊急救
	public static final String AKA123_AKA123_13 = "13";

	// AKA130_普通门诊
	public static final String AKA130_AKA130_11 = "11";
	// AKA130_药店购药
	public static final String AKA130_AKA130_14 = "14";
	// AKA130_门诊慢性病
	public static final String AKA130_AKA130_15 = "15";
	// AKA130_特殊门诊病种
	public static final String AKA130_AKA130_16 = "16";
	// AKA130_特检特治
	public static final String AKA130_AKA130_17 = "17";
	// AKA130_门诊急救
	public static final String AKA130_AKA130_18 = "18";
	// AKA130_居民普通门诊
	public static final String AKA130_AKA130_19 = "19";
	// AKA130_普通住院
	public static final String AKA130_AKA130_21 = "21";
	// AKA130_特殊病种住院
	public static final String AKA130_AKA130_22 = "22";
	// AKA130_转外诊治住院
	public static final String AKA130_AKA130_23 = "23";
	// AKA130_异地住院
	public static final String AKA130_AKA130_25 = "25";
	// AKA130_学生儿童特定门诊
	public static final String AKA130_AKA130_26 = "26";
	// AKA130_家庭病床
	public static final String AKA130_AKA130_31 = "31";
	// AKA130_定点药店购药
	public static final String AKA130_AKA130_41 = "41";
	// AKA130_生育门诊
	public static final String AKA130_AKA130_51 = "51";
	// AKA130_生育住院
	public static final String AKA130_AKA130_52 = "52";
	// AKA130_失业门诊
	public static final String AKA130_AKA130_61 = "61";
	// AKA130_失业住院
	public static final String AKA130_AKA130_62 = "62";
	// AKA130_工伤门诊
	public static final String AKA130_AKA130_71 = "71";
	// AKA130_工伤住院
	public static final String AKA130_AKA130_72 = "72";

	// 医疗方式
	// 门诊
	public static final String AKA131_AKA131_1 = "1";
	// 住院
	public static final String AKA131_AKA131_2 = "2";
	// 药店
	public static final String AKA131_AKA131_3 = "3";

	// AKA132_统筹不支付
	public static final String AKA132_AKA132_0 = "0";
	// AKA132_统筹支付
	public static final String AKA132_AKA132_1 = "1";
	// AKA190_直辖市
	public static final String AKA190_AKA190_1 = "1";
	// AKA190_省会城市
	public static final String AKA190_AKA190_2 = "2";
	// AKA190_地级市
	public static final String AKA190_AKA190_3 = "3";
	// AKA190_县级市
	public static final String AKA190_AKA190_4 = "4";
	// AKA190_城镇
	public static final String AKA190_AKA190_5 = "5";
	// AKA190_农村
	public static final String AKA190_AKA190_6 = "6";
	// AKA213_药品
	public static final String AKA213_AKA213_1 = "1";
	// AKA213_诊疗项目
	public static final String AKA213_AKA213_2 = "2";
	// AKA213_服务设施
	public static final String AKA213_AKA213_3 = "3";
	// AKA215_普通
	public static final String AKA215_AKA215_1 = "1";
	// AKA215_限制类用药
	public static final String AKA215_AKA215_2 = "2";
	// AKA220_价格不符
	public static final String AKA220_AKA220_1 = "1";
	// AKA220_内容不符
	public static final String AKA220_AKA220_2 = "2";
	// AKA220_甲类对为乙类
	public static final String AKA220_AKA220_3 = "3";
	// AKA220_乙类对为甲类
	public static final String AKA220_AKA220_4 = "4";
	// AKA220_范围内对为范围外
	public static final String AKA220_AKA220_5 = "5";
	// AKA220_范围外对为范围内
	public static final String AKA220_AKA220_6 = "6";
	// AKA220_其他
	public static final String AKA220_AKA220_7 = "7";
	// AKA221_未下载
	public static final String AKA221_AKA221_0 = "0";
	// AKA221_已下载
	public static final String AKA221_AKA221_1 = "1";
	// AKB022_医院
	public static final String AKB022_AKB022_1 = "1";
	// AKB022_药店
	public static final String AKB022_AKB022_2 = "2";
	// AKB023_医院
	public static final String AKB023_AKB023_1 = "1";
	// AKB023_卫生院
	public static final String AKB023_AKB023_2 = "2";
	// AKB023_门诊部
	public static final String AKB023_AKB023_3 = "3";
	// AKB023_诊所
	public static final String AKB023_AKB023_4 = "4";
	// AKB023_专科病防治院
	public static final String AKB023_AKB023_5 = "5";
	// AKB023_社区卫生服务机构
	public static final String AKB023_AKB023_6 = "6";
	// AKB023_药店
	public static final String AKB023_AKB023_7 = "7";
	// AKB035_未开设前台
	public static final String AKB035_AKB035_0 = "0";
	// AKB035_已开设前台
	public static final String AKB035_AKB035_1 = "1";
	// AKB130_待遇审核期
	public static final String AKB130_AKB130_1 = "1";
	// AKB130_欠费
	public static final String AKB130_AKB130_2 = "2";
	// AKB130_停保
	public static final String AKB130_AKB130_3 = "3";
	// AKB130_退保
	public static final String AKB130_AKB130_4 = "4";
	// AKB130_破产
	public static final String AKB130_AKB130_5 = "5";
	// AKB130_其他
	public static final String AKB130_AKB130_9 = "9";
	// AKB131_本地定点
	public static final String AKB131_AKB131_1 = "1";
	// AKB131_本地非定点
	public static final String AKB131_AKB131_2 = "2";
	// AKB131_异地约定
	public static final String AKB131_AKB131_3 = "3";
	// AKB131_异地非约定
	public static final String AKB131_AKB131_4 = "4";
	// AKB131_异地定点
	public static final String AKB131_AKB131_5 = "5";
	// AKB131_异地非定点 2010-01-21新增
	public static final String AKB131_AKB131_6 = "6";
	// AKC021_在职
	public static final String AKC021_AKC021_11 = "11";
	// AKC021_在职长期驻外
	public static final String AKC021_AKC021_12 = "12";
	// AKC021_退休
	public static final String AKC021_AKC021_21 = "21";
	// AKC021_退休异地安置
	public static final String AKC021_AKC021_22 = "22";
	// AKC021_离休
	public static final String AKC021_AKC021_31 = "31";
	// AKC021_老红军
	public static final String AKC021_AKC021_32 = "32";
	// AKC021_二等乙级伤残军人
	public static final String AKC021_AKC021_33 = "33";
	// AKC021_医疗照顾人员
	public static final String AKC021_AKC021_34 = "34";
	// AKC021_城镇居民
	public static final String AKC021_AKC021_80 = "80";
	// AKC021_城镇居民成人
	public static final String AKC021_AKC021_82 = "82";
	// AKC021_城镇居民儿童
	public static final String AKC021_AKC021_81 = "81";
	// AKC021_城镇居民老人
	public static final String AKC021_AKC021_83 = "83";
	// AKC021_大学生
	public static final String AKC021_AKC021_84 = "84";
	// AKC021_中小学生
	public static final String AKC021_AKC021_85 = "85";
	// AKC021_灵活就业人员
	public static final String AKC021_AKC021_90 = "90";
	// 1945.9.2后离休
	public static final String AKC021_AKC021_91 = "91";
	// AKC141_正常
	public static final String AKC141_AKC141_1 = "1";
	// AKC141_挂失
	public static final String AKC141_AKC141_2 = "2";
	// AKC141_封锁
	public static final String AKC141_AKC141_3 = "3";
	// AKC141_注销
	public static final String AKC141_AKC141_4 = "4";
	// AKC141_换社保卡
	public static final String AKC141_AKC141_5 = "5";
	// AKC160_待遇审核期
	public static final String AKC160_AKC160_1 = "1";
	// AKC160_欠费
	public static final String AKC160_AKC160_2 = "2";
	// AKC160_停保
	public static final String AKC160_AKC160_3 = "3";
	// AKC160_退保
	public static final String AKC160_AKC160_4 = "4";
	// AKC160_IC卡挂失
	public static final String AKC160_AKC160_5 = "5";
	// AKC160_IC卡注销
	public static final String AKC160_AKC160_6 = "6";
	// AKC160_假卡
	public static final String AKC160_AKC160_7 = "7";
	// AKC160_其他
	public static final String AKC160_AKC160_9 = "9";
	// AKC170_转院住院
	public static final String AKC170_AKC170_01 = "01";
	// AKC170_转院住院（异地）
	public static final String AKC170_AKC170_02 = "02";
	// AKC170_住院
	public static final String AKC170_AKC170_03 = "03";
	// AKC170_异地住院
	public static final String AKC170_AKC170_04 = "04";
	// AKC170_家庭病床
	public static final String AKC170_AKC170_05 = "05";
	// AKC170_医疗包干
	public static final String AKC170_AKC170_06 = "06";
	// AKC170_特殊病种门诊
	public static final String AKC170_AKC170_07 = "07";
	// AKC170_门诊大额
	public static final String AKC170_AKC170_08 = "08";
	// AKC170_特殊住院
	public static final String AKC170_AKC170_09 = "09";
	// AKC170_特殊住院
	public static final String AKC170_AKC170_10 = "10";
	// AKC175_未审批
	public static final String AKC175_AKC175_0 = "0";
	// AKC175_审批通过
	public static final String AKC175_AKC175_1 = "1";
	// AKC175_审批未通过
	public static final String AKC175_AKC175_3 = "3";
	// AKC191_正常
	public static final String AKC191_AKC191_1 = "1";
	// AKC191_特检特治
	public static final String AKC191_AKC191_2 = "2";
	// AKC191_生育并发症
	public static final String AKC191_AKC191_3 = "3";
	// AKC191_紧急抢救
	public static final String AKC191_AKC191_4 = "4";
	// AKC191_急诊
	public static final String AKC191_AKC191_5 = "5";
	// AKC191_传染病
	public static final String AKC191_AKC191_6 = "6";
	// AKC191_孕产妇
	public static final String AKC191_AKC191_7 = "7";
	// AKC191_紧急抢救
	public static final String AKC191_AKC191_22 = "22";
	// AKC191_手术病人复诊
	public static final String AKC191_AKC191_23 = "23";
	// AKC191_急性重大传染病
	public static final String AKC191_AKC191_24 = "24";
	// AKC191_孕产妇
	public static final String AKC191_AKC191_25 = "25";
	// AKC191_精神类疾病
	public static final String AKC191_AKC191_26 = "26";
	// AKC191_恶性肿瘤
	public static final String AKC191_AKC191_27 = "27";
	// AKC195_治愈
	public static final String AKC195_AKC195_1 = "1";
	// AKC195_好转
	public static final String AKC195_AKC195_2 = "2";
	// AKC195_未愈
	public static final String AKC195_AKC195_3 = "3";
	// AKC195_死亡
	public static final String AKC195_AKC195_4 = "4";
	// AKC195_转院
	public static final String AKC195_AKC195_5 = "5";
	// AKC195_转外
	public static final String AKC195_AKC195_6 = "6";
	// AKC195_其他
	public static final String AKC195_AKC195_9 = "9";
	// AKC195_TYPE_正常
	public static final String AKC195_TYPE_1 = "1";
	// AKC195_TYPE_死亡
	public static final String AKC195_TYPE_2 = "2";
	// AKC197_实时结算
	public static final String AKC197_AKC197_0 = "0";
	// AKC197_现金报销
	public static final String AKC197_AKC197_1 = "1";
	// AKC198_未审核
	public static final String AKC198_AKC198_1 = "1";
	// AKC198_审核通过
	public static final String AKC198_AKC198_2 = "2";
	// AKC198_审核未通过
	public static final String AKC198_AKC198_3 = "3";
	// AKC224_非药品
	public static final String AKC224_AKC224_0 = "0";
	// AKC224_药品
	public static final String AKC224_AKC224_1 = "1";
	// AKC267_未冲减
	public static final String AKC267_AKC267_0 = "0";
	// AKC267_已冲减
	public static final String AKC267_AKC267_1 = "1";
	// AKC269_未进行月结算
	public static final String AKC269_AKC269_0 = "0";
	// AKC269_已进行月结算
	public static final String AKC269_AKC269_1 = "1";
	// AKC314_帐户返还
	public static final String AKC314_AKC314_1 = "1";
	// AKC314_帐户继承
	public static final String AKC314_AKC314_2 = "2";
	// AKC314_帐户并入统筹
	public static final String AKC314_AKC314_3 = "3";
	// AKC401_普通人员
	public static final String AKC401_AKC401_1 = "1";
	// AKC401_退休认定已复核人员
	public static final String AKC401_AKC401_2 = "2";
	// AKC402_累计补助
	public static final String AKC402_AKC402_1 = "1";
	// AKC402_一次性补助
	public static final String AKC402_AKC402_2 = "2";
	// ALA040_死亡
	public static final String ALA040_ALA040_00 = "00";
	// ALA040_伤残一级
	public static final String ALA040_ALA040_01 = "01";
	// ALA040_伤残二级
	public static final String ALA040_ALA040_02 = "02";
	// ALA040_伤残三级
	public static final String ALA040_ALA040_03 = "03";
	// ALA040_伤残四级
	public static final String ALA040_ALA040_04 = "04";
	// ALA040_伤残五级
	public static final String ALA040_ALA040_05 = "05";
	// ALA040_伤残六级
	public static final String ALA040_ALA040_06 = "06";
	// ALA040_伤残七级
	public static final String ALA040_ALA040_07 = "07";
	// ALA040_伤残八级
	public static final String ALA040_ALA040_08 = "08";
	// ALA040_伤残九级
	public static final String ALA040_ALA040_09 = "09";
	// ALA040_伤残十级
	public static final String ALA040_ALA040_10 = "10";
	// ALA040_未达等级
	public static final String ALA040_ALA040_11 = "11";
	// ALA041_工伤医疗费
	public static final String ALA041_ALA041_010 = "010";
	// ALA041_住院伙食补助费
	public static final String ALA041_ALA041_011 = "011";
	// ALA041_辅助器具安置费
	public static final String ALA041_ALA041_012 = "012";
	// ALA041_一次性伤残补助金
	public static final String ALA041_ALA041_020 = "020";
	// ALA041_一次性工亡补助金
	public static final String ALA041_ALA041_030 = "030";
	// ALA041_直接及医疗期内死亡工亡补助金
	public static final String ALA041_ALA041_031 = "031";
	// ALA041_享受伤残抚恤金期间死亡工亡补助金
	public static final String ALA041_ALA041_032 = "032";
	// ALA041_丧葬费
	public static final String ALA041_ALA041_040 = "040";
	// ALA041_1-4级异地安家补助费
	public static final String ALA041_ALA041_050 = "050";
	// ALA041_5-6级生活费
	public static final String ALA041_ALA041_060 = "060";
	// ALA041_一次性医疗补助金
	public static final String ALA041_ALA041_070 = "070";
	// ALA041_伤残抚恤金
	public static final String ALA041_ALA041_080 = "080";
	// ALA041_伤残护理费
	public static final String ALA041_ALA041_090 = "090";
	// ALA041_供养直系亲属定期抚恤金
	public static final String ALA041_ALA041_100 = "100";
	// ALA041_供养配偶定期抚恤金
	public static final String ALA041_ALA041_101 = "101";
	// ALA041_供养其他亲属定期抚恤金
	public static final String ALA041_ALA041_102 = "102";
	// ALA041_供养孤身亲属增发抚恤金
	public static final String ALA041_ALA041_103 = "103";
	// ALA042_当地职工月平均工资
	public static final String ALA042_ALA042_1 = "1";
	// ALA042_本人月工资
	public static final String ALA042_ALA042_2 = "2";
	// ALC025_书面
	public static final String ALC025_ALC025_1 = "1";
	// ALC025_电报
	public static final String ALC025_ALC025_2 = "2";
	// ALC025_电话
	public static final String ALC025_ALC025_3 = "3";
	// ALC025_口头
	public static final String ALC025_ALC025_4 = "4";
	// ALC025_其他
	public static final String ALC025_ALC025_9 = "9";
	// ALC027_生产事故
	public static final String ALC027_ALC027_01 = "01";
	// ALC027_科研技改伤亡
	public static final String ALC027_ALC027_02 = "02";
	// ALC027_突发疾病
	public static final String ALC027_ALC027_03 = "03";
	// ALC027_履行职责伤亡
	public static final String ALC027_ALC027_04 = "04";
	// ALC027_见义勇为
	public static final String ALC027_ALC027_05 = "05";
	// ALC027_交通事故
	public static final String ALC027_ALC027_06 = "06";
	// ALC027_伤残军人
	public static final String ALC027_ALC027_07 = "07";
	// ALC027_意外事故、失踪
	public static final String ALC027_ALC027_08 = "08";
	// ALC027_其他工伤
	public static final String ALC027_ALC027_09 = "09";
	// ALC027_职业中毒
	public static final String ALC027_ALC027_10 = "10";
	// ALC027_尘肺
	public static final String ALC027_ALC027_11 = "11";
	// ALC027_物理因素职业病
	public static final String ALC027_ALC027_12 = "12";
	// ALC027_职业性传染病
	public static final String ALC027_ALC027_13 = "13";
	// ALC027_职业性眼病
	public static final String ALC027_ALC027_14 = "14";
	// ALC027_职业性耳鼻喉病
	public static final String ALC027_ALC027_15 = "15";
	// ALC027_职业性肿瘤
	public static final String ALC027_ALC027_16 = "16";
	// ALC027_职业性皮肤病
	public static final String ALC027_ALC027_17 = "17";
	// ALC027_其它职业病
	public static final String ALC027_ALC027_18 = "18";
	// ALC028_未违章
	public static final String ALC028_ALC028_1 = "1";
	// ALC028_违章指挥
	public static final String ALC028_ALC028_2 = "2";
	// ALC028_强令冒险作业
	public static final String ALC028_ALC028_3 = "3";
	// ALC029_未认定为工伤
	public static final String ALC029_ALC029_0 = "0";
	// ALC029_认定为工伤
	public static final String ALC029_ALC029_1 = "1";
	// ALC050_新增
	public static final String ALC050_ALC050_1 = "1";
	// ALC050_停发
	public static final String ALC050_ALC050_2 = "2";
	// ALC050_续发
	public static final String ALC050_ALC050_3 = "3";
	// ALC050_终止
	public static final String ALC050_ALC050_4 = "4";
	// ALC060_完全护理依赖
	public static final String ALC060_ALC060_1 = "1";
	// ALC060_大部分护理依赖
	public static final String ALC060_ALC060_2 = "2";
	// ALC060_部分护理依赖
	public static final String ALC060_ALC060_3 = "3";
	// ALC080_未终止
	public static final String ALC080_ALC080_0 = "0";
	// ALC080_终止
	public static final String ALC080_ALC080_1 = "1";
	// ALC081_非旧伤复发
	public static final String ALC081_ALC081_0 = "0";
	// ALC081_旧伤复发
	public static final String ALC081_ALC081_1 = "1";
	// ALC090_工伤人员
	public static final String ALC090_ALC090_1 = "1";
	// ALC090_供养亲属
	public static final String ALC090_ALC090_2 = "2";
	// ALC124_国产
	public static final String ALC124_ALC124_1 = "1";
	// ALC124_进口
	public static final String ALC124_ALC124_2 = "2";
	// ALC141_非孤身
	public static final String ALC141_ALC141_0 = "0";
	// ALC141_孤身
	public static final String ALC141_ALC141_1 = "1";
	// ALC163_不通过
	public static final String ALC163_ALC163_0 = "0";
	// ALC163_通过
	public static final String ALC163_ALC163_1 = "1";
	// ALC164_宣传
	public static final String ALC164_ALC164_1 = "1";
	// ALC164_培训
	public static final String ALC164_ALC164_2 = "2";
	// ALC164_其它
	public static final String ALC164_ALC164_9 = "9";
	// AMC024_怀孕小于四个月流产
	public static final String AMC024_AMC024_1 = "1";
	// AMC024_怀孕大于四个月流产
	public static final String AMC024_AMC024_2 = "2";
	// AMC024_习惯性流产
	public static final String AMC024_AMC024_3 = "3";
	// AMC024_生育后节育措施失败流产（怀孕不满三个月）
	public static final String AMC024_AMC024_4 = "4";
	// AMC026_正常产
	public static final String AMC026_AMC026_1 = "1";
	// AMC026_流产
	public static final String AMC026_AMC026_2 = "2";
	// AMC026_难产
	public static final String AMC026_AMC026_3 = "3";
	// AMC026_剖腹产
	public static final String AMC026_AMC026_4 = "4";
	// AMC027_非晚育
	public static final String AMC027_AMC027_0 = "0";
	// AMC027_晚育
	public static final String AMC027_AMC027_1 = "1";
	// AMB032_正常发放
	public static final String AMB032_AMB032_1 = "1";
	// AMB032_调整发放
	public static final String AMB032_AMB032_2 = "2";
	// AMB032_全额退款
	public static final String AMB032_AMB032_3 = "3";
	// AMB032_补发
	public static final String AMB032_AMB032_4 = "4";
	// AMB032_退发
	public static final String AMB032_AMB032_5 = "5";
	// AMC050_生育津贴
	public static final String AMC050_AMC050_1 = "1";
	// AMC050_护理假津贴
	public static final String AMC050_AMC050_2 = "2";
	// AMC050_生育医疗费
	public static final String AMC050_AMC050_3 = "3";
	// AMC050_计划生育手术费
	public static final String AMC050_AMC050_4 = "4";
	// AMC050_奖励个人返还
	public static final String AMC050_AMC050_5 = "5";
	// AMC050_其他费用
	public static final String AMC050_AMC050_6 = "6";
	// 计划生育类型.1.正常生育
	public static final String BEARING_TYPE_1 = "1";
	// 计划生育类型.2.流产
	public static final String BEARING_TYPE_2 = "2";
	// 计划生育类型.3.其他
	public static final String BEARING_TYPE_3 = "3";
	// BAA001_
	public static final String BAA001_BAA001_00 = "00";
	// BAA001_1
	public static final String BAA001_BAA001_1 = "1";
	// BAA001_西安市
	public static final String BAA001_BAA001_6101 = "6101";
	// BAA001_西安市新城区
	public static final String BAA001_BAA001_610102 = "610102";
	// BAA001_西安市碑林区
	public static final String BAA001_BAA001_610103 = "610103";
	// BAA001_西安市莲湖区
	public static final String BAA001_BAA001_610104 = "610104";
	// BAA001_西安市灞桥区
	public static final String BAA001_BAA001_610111 = "610111";
	// BAA001_西安市未央区
	public static final String BAA001_BAA001_610112 = "610112";
	// BAA001_西安市雁塔区
	public static final String BAA001_BAA001_610113 = "610113";
	// BAA001_西安市阎良区
	public static final String BAA001_BAA001_610114 = "610114";
	// BAA001_西安市高新区
	public static final String BAA001_BAA001_610115 = "610115";
	// BAA001_西安市经济开发区
	public static final String BAA001_BAA001_610116 = "610116";
	// BAA001_西安市长安区
	public static final String BAA001_BAA001_610121 = "610121";
	// BAA001_西安市蓝田县
	public static final String BAA001_BAA001_610122 = "610122";
	// BAA001_西安市临潼区
	public static final String BAA001_BAA001_610123 = "610123";
	// BAA001_西安市周至县
	public static final String BAA001_BAA001_610124 = "610124";
	// BAA001_西安市户县
	public static final String BAA001_BAA001_610125 = "610125";
	// BAA001_西安市高陵县
	public static final String BAA001_BAA001_610126 = "610126";
	// BAA001_西安市本级
	public static final String BAA001_BAA001_610199 = "610199";
	// 铜川市
	public static final String BAA001_BAA001_6102 = "6102";
	// BAA001_铜川市王益区
	public static final String BAA001_BAA001_610202 = "610202";
	// BAA001_铜川市印台区
	public static final String BAA001_BAA001_610203 = "610203";
	// BAA001_铜川市耀县
	public static final String BAA001_BAA001_610204 = "610204";
	// BAA001_铜川市宜君区
	public static final String BAA001_BAA001_610222 = "610222";
	// BAA001_铜川市新区
	public static final String BAA001_BAA001_610207 = "610207";
	// BAA001_铜川市本级
	public static final String BAA001_BAA001_610299 = "610299";
	// BAA001_宝鸡市
	public static final String BAA001_BAA001_6103 = "6103";
	// BAA001_宝鸡市渭滨区
	public static final String BAA001_BAA001_610302 = "610302";
	// BAA001_宝鸡市金台区
	public static final String BAA001_BAA001_610303 = "610303";
	// BAA001_宝鸡市宝鸡县
	public static final String BAA001_BAA001_610321 = "610321";
	// BAA001_宝鸡市凤翔县
	public static final String BAA001_BAA001_610322 = "610322";
	// BAA001_宝鸡市岐山县
	public static final String BAA001_BAA001_610323 = "610323";
	// BAA001_宝鸡市扶风县
	public static final String BAA001_BAA001_610324 = "610324";
	// BAA001_宝鸡市眉县
	public static final String BAA001_BAA001_610326 = "610326";
	// BAA001_宝鸡市陇县
	public static final String BAA001_BAA001_610327 = "610327";
	// BAA001_宝鸡市千阳县
	public static final String BAA001_BAA001_610328 = "610328";
	// BAA001_宝鸡市麟游县
	public static final String BAA001_BAA001_610329 = "610329";
	// BAA001_宝鸡市凤县
	public static final String BAA001_BAA001_610330 = "610330";
	// BAA001_宝鸡市太白县
	public static final String BAA001_BAA001_610331 = "610331";
	// BAA001_宝鸡市本级
	public static final String BAA001_BAA001_610399 = "610399";
	// BAA001_咸阳市
	public static final String BAA001_BAA001_6104 = "6104";
	// BAA001_咸阳市秦都区
	public static final String BAA001_BAA001_610402 = "610402";
	// BAA001_咸阳市渭城区
	public static final String BAA001_BAA001_610404 = "610404";
	// BAA001_咸阳市三原县
	public static final String BAA001_BAA001_610422 = "610422";
	// BAA001_咸阳市泾阳县
	public static final String BAA001_BAA001_610423 = "610423";
	// BAA001_咸阳市乾县
	public static final String BAA001_BAA001_610424 = "610424";
	// BAA001_咸阳市礼泉县
	public static final String BAA001_BAA001_610425 = "610425";
	// BAA001_咸阳市永寿县
	public static final String BAA001_BAA001_610426 = "610426";
	// BAA001_咸阳市彬县
	public static final String BAA001_BAA001_610427 = "610427";
	// BAA001_咸阳市长武县
	public static final String BAA001_BAA001_610428 = "610428";
	// BAA001_咸阳市旬邑县
	public static final String BAA001_BAA001_610429 = "610429";
	// BAA001_咸阳市淳化县
	public static final String BAA001_BAA001_610430 = "610430";
	// BAA001_咸阳市武功县
	public static final String BAA001_BAA001_610431 = "610431";
	// BAA001_咸阳市兴平市
	public static final String BAA001_BAA001_610481 = "610481";
	// BAA001_咸阳市本级
	public static final String BAA001_BAA001_610499 = "610499";
	// BAA001_渭南市
	public static final String BAA001_BAA001_6105 = "6105";
	// BAA001_渭南市临渭区
	public static final String BAA001_BAA001_610502 = "610502";
	// BAA001_渭南市开发区
	public static final String BAA001_BAA001_610503 = "610503";
	// BAA001_渭南市华县
	public static final String BAA001_BAA001_610521 = "610521";
	// BAA001_渭南市潼关县
	public static final String BAA001_BAA001_610522 = "610522";
	// BAA001_渭南市大荔县
	public static final String BAA001_BAA001_610523 = "610523";
	// BAA001_渭南市合阳县
	public static final String BAA001_BAA001_610524 = "610524";
	// BAA001_渭南市澄城县
	public static final String BAA001_BAA001_610525 = "610525";
	// BAA001_渭南市蒲城县
	public static final String BAA001_BAA001_610526 = "610526";
	// BAA001_渭南市白水县
	public static final String BAA001_BAA001_610527 = "610527";
	// BAA001_渭南市富平县
	public static final String BAA001_BAA001_610528 = "610528";
	// BAA001_渭南市韩城市
	public static final String BAA001_BAA001_610581 = "610581";
	// BAA001_渭南市华阴市
	public static final String BAA001_BAA001_610582 = "610582";
	// BAA001_渭南市本级
	public static final String BAA001_BAA001_610599 = "610599";
	// 延安市
	public static final String BAA001_BAA001_6106 = "6106";
	// BAA001_延安市
	public static final String BAA001_BAA001_610600 = "610600";
	// BAA001_延安市宝塔区
	public static final String BAA001_BAA001_610602 = "610602";
	// BAA001_延安市延长县
	public static final String BAA001_BAA001_610621 = "610621";
	// BAA001_延安市延川县
	public static final String BAA001_BAA001_610622 = "610622";
	// BAA001_延安市子长县
	public static final String BAA001_BAA001_610623 = "610623";
	// BAA001_延安市安塞县
	public static final String BAA001_BAA001_610624 = "610624";
	// BAA001_延安市志丹县
	public static final String BAA001_BAA001_610625 = "610625";
	// BAA001_延安市吴期县
	public static final String BAA001_BAA001_610626 = "610626";
	// BAA001_延安市甘泉县
	public static final String BAA001_BAA001_610627 = "610627";
	// BAA001_延安市富县
	public static final String BAA001_BAA001_610628 = "610628";
	// BAA001_延安市洛川县
	public static final String BAA001_BAA001_610629 = "610629";
	// BAA001_延安市宜川县
	public static final String BAA001_BAA001_610630 = "610630";
	// BAA001_延安市黄龙县
	public static final String BAA001_BAA001_610631 = "610631";
	// BAA001_延安市黄陵县
	public static final String BAA001_BAA001_610632 = "610632";
	// BAA001_延安市本级
	public static final String BAA001_BAA001_610699 = "610601";
	// BAA001_汉中市
	public static final String BAA001_BAA001_6107 = "6107";
	// BAA001_汉中市汉台区
	public static final String BAA001_BAA001_610702 = "610702";
	// BAA001_汉中市南郑县
	public static final String BAA001_BAA001_610721 = "610721";
	// BAA001_汉中市城固县
	public static final String BAA001_BAA001_610722 = "610722";
	// BAA001_汉中市洋县
	public static final String BAA001_BAA001_610723 = "610723";
	// BAA001_汉中市西乡县
	public static final String BAA001_BAA001_610724 = "610724";
	// BAA001_汉中市勉县
	public static final String BAA001_BAA001_610725 = "610725";
	// BAA001_汉中市宁强县
	public static final String BAA001_BAA001_610726 = "610726";
	// BAA001_汉中市略阳县
	public static final String BAA001_BAA001_610727 = "610727";
	// BAA001_汉中市镇巴县
	public static final String BAA001_BAA001_610728 = "610728";
	// BAA001_汉中市留坝县
	public static final String BAA001_BAA001_610729 = "610729";
	// BAA001_汉中市佛坪县
	public static final String BAA001_BAA001_610730 = "610730";
	// BAA001_汉中市本级
	public static final String BAA001_BAA001_610799 = "610799";
	// BAA001_榆林市
	public static final String BAA001_BAA001_6108 = "6108";
	// BAA001_榆林市榆阳县
	public static final String BAA001_BAA001_610802 = "610802";
	// BAA001_榆林市神木县
	public static final String BAA001_BAA001_610821 = "610821";
	// BAA001_榆林市府谷县
	public static final String BAA001_BAA001_610822 = "610822";
	// BAA001_榆林市横山县
	public static final String BAA001_BAA001_610823 = "610823";
	// BAA001_榆林市靖边县
	public static final String BAA001_BAA001_610824 = "610824";
	// BAA001_榆林市定边县
	public static final String BAA001_BAA001_610825 = "610825";
	// BAA001_榆林市绥德县
	public static final String BAA001_BAA001_610826 = "610826";
	// BAA001_榆林市米脂县
	public static final String BAA001_BAA001_610827 = "610827";
	// BAA001_榆林市佳县
	public static final String BAA001_BAA001_610828 = "610828";
	// BAA001_榆林市吴堡县
	public static final String BAA001_BAA001_610829 = "610829";
	// BAA001_榆林市清涧县
	public static final String BAA001_BAA001_610830 = "610830";
	// BAA001_榆林市子洲县
	public static final String BAA001_BAA001_610831 = "610831";
	// BAA001_榆林市本级
	public static final String BAA001_BAA001_610899 = "610899";
	// BAA001_安康市
	public static final String BAA001_BAA001_6109 = "6109";
	// BAA001_安康市汉滨区
	public static final String BAA001_BAA001_610902 = "610902";
	// BAA001_安康市汉阴县
	public static final String BAA001_BAA001_610921 = "610921";
	// BAA001_安康市石泉县
	public static final String BAA001_BAA001_610922 = "610922";
	// BAA001_安康市宁陕县
	public static final String BAA001_BAA001_610923 = "610923";
	// BAA001_安康市紫阳县
	public static final String BAA001_BAA001_610924 = "610924";
	// BAA001_安康市岚皋县
	public static final String BAA001_BAA001_610925 = "610925";
	// BAA001_安康市平利县
	public static final String BAA001_BAA001_610926 = "610926";
	// BAA001_安康市镇坪县
	public static final String BAA001_BAA001_610927 = "610927";
	// BAA001_安康市旬阳县
	public static final String BAA001_BAA001_610928 = "610928";
	// BAA001_安康市白河县
	public static final String BAA001_BAA001_610929 = "610929";
	// BAA001_安康市本级
	public static final String BAA001_BAA001_610999 = "610999";
	// BAA001_商洛市
	public static final String BAA001_BAA001_6110 = "6110";
	// BAA001_商洛市商州区
	public static final String BAA001_BAA001_611001 = "611001";
	// BAA001_商洛市洛南县
	public static final String BAA001_BAA001_611021 = "611021";
	// BAA001_商洛市丹凤县
	public static final String BAA001_BAA001_611022 = "611022";
	// BAA001_商洛市商南县
	public static final String BAA001_BAA001_611023 = "611023";
	// BAA001_商洛市山阳县
	public static final String BAA001_BAA001_611024 = "611024";
	// BAA001_商洛市镇安县
	public static final String BAA001_BAA001_611025 = "611025";
	// BAA001_商洛市柞水县
	public static final String BAA001_BAA001_611026 = "611026";
	// BAA001_商洛市本级
	public static final String BAA001_BAA001_611099 = "611099";
	// BAA001_杨凌示范区
	public static final String BAA001_BAA001_6111 = "6111";
	// BAA001_杨凌示范区本级
	public static final String BAA001_BAA001_611199 = "611199";
	// BAA001_陕西省直医疗
	public static final String BAA001_BAA001_6198 = "6198";
	// BAA001_陕西省本级
	public static final String BAA001_BAA001_6199 = "6199";
	// BAA001_3_陕西省级医疗保险
	public static final String BAA001_3_BAA001_3_6198 = "6198";
	// BAA003_省直
	public static final String BAA003_BAA003_001 = "001";
	// BAA003_西安
	public static final String BAA003_BAA003_002 = "002";
	// BAA003_咸阳
	public static final String BAA003_BAA003_003 = "003";

	public static final String AAA006_AAA006_0 = "0"; // 无需审核
	public static final String AAA006_AAA006_1 = "1"; // 未审核
	public static final String AAA006_AAA006_2 = "2"; // 已审核

	// BAA006_未审核
	public static final String BAA006_BAA006_1 = "1";
	// BAA006_已审核
	public static final String BAA006_BAA006_2 = "2";
	// BAA007_通过
	public static final String BAA007_BAA007_1 = "1";
	// BAA007_批量通过
	public static final String BAA007_BAA007_2 = "2";
	// BAA007_全额拒付
	public static final String BAA007_BAA007_3 = "3";
	// BAA007_部分拒付
	public static final String BAA007_BAA007_4 = "4";
	// BAA011_单位
	public static final String BAA011_BAA011_1 = "1";
	// BAA011_个人
	public static final String BAA011_BAA011_2 = "2";
	// BAA011_定点医药机构
	public static final String BAA011_BAA011_3 = "3";
	// BAA011_数据分区
	public static final String BAA011_BAA011_4 = "4";
	// BAA011_其他
	public static final String BAA011_BAA011_5 = "5";
	// BAA022_否
	public static final String BAA022_BAA022_1 = "1";
	// BAA022_是
	public static final String BAA022_BAA022_2 = "2";
	// BAA023_无
	public static final String BAA023_BAA023_1 = "1";
	// BAA023_有定期供养
	public static final String BAA023_BAA023_2 = "2";
	// BAA030_0—50万（包含50万）
	public static final String BAA030_BAA030_101 = "101";
	// BAA030_50—100万（大于50万，包含100万）
	public static final String BAA030_BAA030_102 = "102";
	// BAA030_100—500万（大于100万，包含500万）
	public static final String BAA030_BAA030_103 = "103";
	// BAA030_500万以上（大于500万）
	public static final String BAA030_BAA030_104 = "104";
	// BAA101_基本养老保险缴费比例_邮电行业企业
	public static final String BAA101_BAA101_011 = "011";
	// BAA101_基本养老保险缴费比例_有色行业企业
	public static final String BAA101_BAA101_021 = "021";
	// BAA101_基本养老保险缴费比例_中建行业企业
	public static final String BAA101_BAA101_031 = "031";
	// BAA101_基本养老保险缴费比例_铁路行业企业
	public static final String BAA101_BAA101_041 = "041";
	// BAA101_基本养老保险缴费比例_石油行业企业
	public static final String BAA101_BAA101_051 = "051";
	// BAA101_基本养老保险缴费比例_中建行业企业
	public static final String BAA101_BAA101_061 = "061";
	// BAA101_基本养老保险缴费比例_金融行业企业
	public static final String BAA101_BAA101_071 = "071";
	// BAA101_基本养老保险缴费比例_中建行业企业
	public static final String BAA101_BAA101_081 = "081";
	// BAA101_基本养老保险缴费比例_电力行业企业
	public static final String BAA101_BAA101_091 = "091";
	// BAA101_基本养老保险缴费比例
	public static final String BAA101_BAA101_1 = "1";
	// BAA101_基本养老保险缴费比例_民航行业企业
	public static final String BAA101_BAA101_101 = "101";
	// BAA101_独立人员缴费比例
	public static final String BAA101_BAA101_4 = "4";
	// BAA101_4050人员缴费比例
	public static final String BAA101_BAA101_5 = "5";
	// BAA101_军转干部缴费比例
	public static final String BAA101_BAA101_6 = "6";
	// BAA102_失业保险缴费比例
	public static final String BAA102_BAA102_1 = "1";
	// BAA102_独立人员缴费比例
	public static final String BAA102_BAA102_2 = "2";
	// BAA103_基本医疗保险缴费比例
	public static final String BAA103_BAA103_1 = "1";
	// BAA103_基本医疗独立人员缴费比例
	public static final String BAA103_BAA103_3 = "3";
	// BAA103_基本医疗保险在职缴费比例
	public static final String BAA103_BAA103_4 = "4";
	// BAA103_基本医疗保险退休缴费比例
	public static final String BAA103_BAA103_5 = "5";
	// BAA103_基本医疗保险财政补助缴费比例
	public static final String BAA103_BAA103_6 = "6";
	// BAA101_基本医疗4050人员缴费比例
	public static final String BAA103_BAA103_7 = "7";
	// BAA101_灵活就业人员缴费比例
	public static final String BAA103_BAA103_8 = "8";
	// BAA103_破产企业缴费比例
	public static final String BAA103_BAA103_9 = "9";
	// BAA103_城镇非从业居民
	public static final String BAA103_BAA103_11 = "11";
	// BAA103_低保对象
	public static final String BAA103_BAA103_12 = "12";
	// BAA103_重度残疾人
	public static final String BAA103_BAA103_13 = "13";
	// BAA103_低收入家庭60周岁以上的老年人
	public static final String BAA103_BAA103_14 = "14";
	// BAA103_丧失劳动能力的残疾人
	public static final String BAA103_BAA103_15 = "15";
	// BAA103_三无人员
	public static final String BAA103_BAA103_16 = "16";
	public static final Object BAA103_BAA103_17 = "17";
	public static final Object BAA103_BAA103_18 = "18";
	// BAA103_城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_21 = "21";
	// BAA103_属于低保对象的城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_22 = "22";
	// BAA103_重度残疾的城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_23 = "23";

	public static final Object BAA103_BAA103_24 = "24";
	public static final Object BAA103_BAA103_25 = "25";
	public static final Object BAA103_BAA103_26 = "26";

	// BAA103_(学生)城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_27 = "27";
	// BAA103_(学生)属于低保对象的城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_28 = "28";
	// BAA103_(学生)重度残疾的城镇中小学阶段的学生、少年儿童
	public static final String BAA103_BAA103_29 = "29";
	// BAA103_基本医疗保离休人员缴费比例
	public static final String BAA103_BAA103_31 = "31";
	// 低保大学生
	public static final String BAA103_BAA103_32 = "32";
	// 重残大学生
	public static final String BAA103_BAA103_33 = "33";
	// BAA103_基本医疗军干系统缴费比例
	public static final String BAA103_BAA103_41 = "41";
	// BAA103_基本医疗破产企业缴费比例
	public static final String BAA103_BAA103_42 = "42";
	// BAA103_基本医疗保险特殊缴费比例
	public static final String BAA103_BAA103_43 = "43";
	// BAA103_基本医疗保险困难企业退休缴费比例
	public static final String BAA103_BAA103_44 = "44";
	// BAA103_城镇非从业居民一档
	public static final String BAA103_BAA103_45 = "45";
	// BAA103_低保对象一档
	public static final String BAA103_BAA103_46 = "46";
	// BAA103_重度残疾人一档
	public static final String BAA103_BAA103_47 = "47";
	// BAA103_低收入家庭60周岁以上的老年人一档
	public static final String BAA103_BAA103_48 = "48";
	// BAA103_丧失劳动能力的残疾人一档
	public static final String BAA103_BAA103_49 = "49";
	// BAA103_三无人员一档
	public static final String BAA103_BAA103_50 = "50";

	// BAA104_一级工伤
	public static final String BAA104_BAA104_1 = "1";
	// BAA104_二级工伤
	public static final String BAA104_BAA104_2 = "2";
	// BAA104_三级工伤
	public static final String BAA104_BAA104_3 = "3";
	// BAA105_生育保险缴费比例
	public static final String BAA105_BAA105_1 = "1";
	// BAA108_补充医疗保险缴费比例
	public static final String BAA109_BAA108_1 = "1";
	// BAA109_公务员医疗补助缴费比例
	public static final String BAA109_BAA109_1 = "1";
	// BAA109_公务员医疗补助个人缴费比例
	public static final String BAA109_BAA109_2 = "2";
	// BAA109_公务员医疗补助财政缴费比例
	public static final String BAA109_BAA109_6 = "6";

	// BAA110_重大疾病医疗补助缴费比例
	public static final String BAA110_BAA110_1 = "1";
	// BAA110_重大疾病医疗独立人员缴费比例
	public static final String BAA110_BAA110_3 = "3";
	// BAA110_重大疾病财政补助缴费比例
	public static final String BAA110_BAA110_6 = "6";
	// BAA110_重大疾病4050人员缴费比例
	public static final String BAA110_BAA110_7 = "7";
	// BAA110_重大疾病军转干部缴费比例
	public static final String BAA110_BAA110_8 = "8";
	// BAA110_重大疾病困难企业缴费比例
	public static final String BAA110_BAA110_9 = "9";
	// BAA110_重大疾病军干系统缴费比例
	public static final String BAA110_BAA110_41 = "41";
	// BAA110_重大疾病破产企业缴费比例
	public static final String BAA110_BAA110_42 = "42";
	// BAA110_大病医疗保险困难企业退休缴费比例
	public static final String BAA110_BAA110_44 = "44";
	// BAA110_大病医疗保险离休人员缴费比例
	public static final String BAA110_BAA110_31 = "31";

	// BAA111_医疗照顾人员医疗补助缴费比例类别
	public static final String BAA111_BAA111_1 = "1";

	// BAA111_医疗照顾人员医疗补助财政缴费比例类别
	public static final String BAA111_BAA111_6 = "6";
	// BAA153_30岁以下
	public static final String BAA153_BAA153_1 = "1";
	// BAA153_31岁—40岁
	public static final String BAA153_BAA153_2 = "2";
	// BAA153_41岁—50岁
	public static final String BAA153_BAA153_3 = "3";
	// BAA153_51岁以上
	public static final String BAA153_BAA153_4 = "4";
	// BAA153_退休人员
	public static final String BAA153_BAA153_5 = "5";
	// BAB501_否
	public static final String BAB501_BAB501_0 = "0";
	// BAB501_是
	public static final String BAB501_BAB501_1 = "1";
	// BAB505_解散
	public static final String BAB505_BAB505_1 = "1";
	// BAB505_破产
	public static final String BAB505_BAB505_2 = "2";
	// BAB505_撤消
	public static final String BAB505_BAB505_3 = "3";
	// BAB505_转移
	public static final String BAB505_BAB505_4 = "4";
	// BAB505_分立
	public static final String BAB505_BAB505_5 = "5";
	// BAB505_合并
	public static final String BAB505_BAB505_6 = "6";
	// BAB505_其他
	public static final String BAB505_BAB505_7 = "7";
	// BAB517_单位新发证
	public static final String BAB517_BAB517_1 = "1";
	// BAB517_换证
	public static final String BAB517_BAB517_2 = "2";
	// BAB517_补证
	public static final String BAB517_BAB517_3 = "3";
	// BAB517_年审
	public static final String BAB517_BAB517_4 = "4";
	// BAB518_第一行
	public static final String BAB518_BAB518_1 = "1";
	// BAB518_第二行
	public static final String BAB518_BAB518_2 = "2";
	// BAB518_第三行
	public static final String BAB518_BAB518_3 = "3";
	// BAB518_第四行
	public static final String BAB518_BAB518_4 = "4";
	// BAB519_邮电行业企业
	public static final String BAB519_BAB519_001 = "001";
	// BAB519_有色行业企业
	public static final String BAB519_BAB519_002 = "002";
	// BAB519_中建行业企业
	public static final String BAB519_BAB519_003 = "003";
	// BAB519_铁路行业企业
	public static final String BAB519_BAB519_004 = "004";
	// BAB519_石油行业企业
	public static final String BAB519_BAB519_005 = "005";
	// BAB519_交通行业企业
	public static final String BAB519_BAB519_006 = "006";
	// BAB519_金融行业企业
	public static final String BAB519_BAB519_007 = "007";
	// BAB519_煤炭行业企业
	public static final String BAB519_BAB519_008 = "008";
	// BAB519_电力行业企业
	public static final String BAB519_BAB519_009 = "009";
	// BAB519_民航行业企业
	public static final String BAB519_BAB519_010 = "010";
	// BAB519_水利行业企业
	public static final String BAB519_BAB519_011 = "011";
	// BAB519_监狱行业企业
	public static final String BAB519_BAB519_012 = "012";
	// BAB519_非行业企业
	public static final String BAB519_BAB519_018 = "018";
	// BAB706_普通申报
	public static final String BAB706_BAB706_1 = "1";
	// BAB706_4050
	public static final String BAB706_BAB706_2 = "2";
	// BAB706_军转干部
	public static final String BAB706_BAB706_3 = "3";
	// BAB706_历史缴费记录补录
	public static final String BAB706_BAB706_4 = "4";
	// BAB706_煤炭申报
	public static final String BAB706_BAB706_5 = "5";
	// BAB706_建筑申报
	public static final String BAB706_BAB706_6 = "6";
	// BAB706_营业面积申报
	public static final String BAB706_BAB706_7 = "7";
	// BAB807_新立户
	public static final String BAB807_BAB807_1 = "1";
	// BAB807_并户
	public static final String BAB807_BAB807_2 = "2";
	// BAB807_分户
	public static final String BAB807_BAB807_3 = "3";
	// BAB807_成建制转入
	public static final String BAB807_BAB807_4 = "4";
	// BAB807_已参保
	public static final String BAB807_BAB807_5 = "5";
	// BAB807_其他
	public static final String BAB807_BAB807_6 = "6";
	// BAC505_按时间认定
	public static final String BAC505_BAC505_001 = "001";
	// BAC505_按工龄认定
	public static final String BAC505_BAC505_002 = "002";
	// BAC505_按缴费认定
	public static final String BAC505_BAC505_003 = "003";
	// BAC505_按其它认定
	public static final String BAC505_BAC505_009 = "009";
	// BAC506_原固定职工
	public static final String BAC506_BAC506_1 = "1";
	// BAC506_城镇合同制职工
	public static final String BAC506_BAC506_2 = "2";
	// BAC506_农村合同制职工
	public static final String BAC506_BAC506_3 = "3";
	// BAC506_临时工
	public static final String BAC506_BAC506_4 = "4";
	// BAC506_参军
	public static final String BAC506_BAC506_5 = "5";
	// BAC506_其他
	public static final String BAC506_BAC506_9 = "9";
	// BAC509_企业职工
	public static final String BAC509_BAC509_001 = "001";
	// BAC509_军转干部
	public static final String BAC509_BAC509_002 = "002";
	// BAC509_4050人员
	public static final String BAC509_BAC509_003 = "003";
	// BAC509_自由职业者
	public static final String BAC509_BAC509_004 = "009";
	// BAC515_非公务员
	public static final String BAC515_BAC515_1 = "1";
	// BAC515_公务员
	public static final String BAC515_BAC515_2 = "2";
	// BAC515_参照公务员
	public static final String BAC515_BAC515_3 = "3";
	// BAC516_人员状态
	public static final String BAC516_BAC516_AAC008 = "AAC008";
	// BAC516_个人身份
	public static final String BAC516_BAC516_AAC012 = "AAC012";
	// BAC516_公务员类别
	public static final String BAC516_BAC516_BAC515 = "BAC515";
	// BAC520_在职死亡
	public static final String BAC520_BAC520_1 = "1";
	// BAC520_在职出国
	public static final String BAC520_BAC520_2 = "2";
	// BAC520_退保
	public static final String BAC520_BAC520_3 = "3";
	// BAC520_其他原因
	public static final String BAC520_BAC520_4 = "4";
	// BAC521_无高级技术职务类型
	public static final String BAC521_BAC521_00 = "00";
	// BAC521_文物博物研究馆员
	public static final String BAC521_BAC521_101 = "101";
	// BAC521_文物博物副研究馆员
	public static final String BAC521_BAC521_102 = "102";
	// BAC521_教授
	public static final String BAC521_BAC521_11 = "11";
	// BAC521_档案研究馆员
	public static final String BAC521_BAC521_111 = "111";
	// BAC521_档案副研究馆员
	public static final String BAC521_BAC521_112 = "112";
	// BAC521_副教授
	public static final String BAC521_BAC521_12 = "12";
	// BAC521_高级工艺美术师
	public static final String BAC521_BAC521_121 = "121";
	// BAC521_高级讲师
	public static final String BAC521_BAC521_131 = "131";
	// BAC521_高级实习指导教师
	public static final String BAC521_BAC521_132 = "132";
	// BAC521_国家级教练
	public static final String BAC521_BAC521_141 = "141";
	// BAC521_高级教练
	public static final String BAC521_BAC521_142 = "142";
	// BAC521_译审
	public static final String BAC521_BAC521_151 = "151";
	// BAC521_副译审
	public static final String BAC521_BAC521_152 = "152";
	// BAC521_播音指导
	public static final String BAC521_BAC521_161 = "161";
	// BAC521_主任播音员
	public static final String BAC521_BAC521_162 = "162";
	// BAC521_高级会计师
	public static final String BAC521_BAC521_171 = "171";
	// BAC521_高级统计师
	public static final String BAC521_BAC521_181 = "181";
	// BAC521_高级经济师
	public static final String BAC521_BAC521_191 = "191";
	// BAC521_高级国际商务师
	public static final String BAC521_BAC521_192 = "192";
	// BAC521_高级实验师
	public static final String BAC521_BAC521_201 = "201";
	// BAC521_社会科学研究员
	public static final String BAC521_BAC521_21 = "21";
	// BAC521_高级讲师
	public static final String BAC521_BAC521_211 = "211";
	// BAC521_社会科学副研究员
	public static final String BAC521_BAC521_22 = "22";
	// BAC521_中学高级教师
	public static final String BAC521_BAC521_221 = "221";
	// BAC521_高级政工师
	public static final String BAC521_BAC521_231 = "231";
	// BAC521_一级公证员
	public static final String BAC521_BAC521_241 = "241";
	// BAC521_二级公证员
	public static final String BAC521_BAC521_242 = "242";
	// BAC521_一级律师
	public static final String BAC521_BAC521_251 = "251";
	// BAC521_自然科学研究员
	public static final String BAC521_BAC521_31 = "31";
	// BAC521_自然科学副研究员
	public static final String BAC521_BAC521_32 = "32";
	// BAC521_主任医师
	public static final String BAC521_BAC521_41 = "41";
	// BAC521_副主任医师
	public static final String BAC521_BAC521_42 = "42";
	// BAC521_主任药师
	public static final String BAC521_BAC521_43 = "43";
	// BAC521_副主任药师
	public static final String BAC521_BAC521_44 = "44";
	// BAC521_主任护师
	public static final String BAC521_BAC521_45 = "45";
	// BAC521_副主任护师
	public static final String BAC521_BAC521_46 = "46";
	// BAC521_主任技师
	public static final String BAC521_BAC521_47 = "47";
	// BAC521_副主任技师
	public static final String BAC521_BAC521_48 = "48";
	// BAC521_高级工程师
	public static final String BAC521_BAC521_51 = "51";
	// BAC521_农业技术推广研究员
	public static final String BAC521_BAC521_61 = "61";
	// BAC521_高级农艺师
	public static final String BAC521_BAC521_62 = "62";
	// BAC521_高级畜牧师
	public static final String BAC521_BAC521_63 = "63";
	// BAC521_高级兽医师
	public static final String BAC521_BAC521_64 = "64";
	// BAC521_高级审计师
	public static final String BAC521_BAC521_701 = "701";
	// BAC521_高级记者
	public static final String BAC521_BAC521_71 = "71";
	// BAC521_主任放映师
	public static final String BAC521_BAC521_711 = "711";
	// BAC521_主任记者
	public static final String BAC521_BAC521_72 = "72";
	// BAC521_一级美术设计师
	public static final String BAC521_BAC521_721 = "721";
	// BAC521_二级美术设计师
	public static final String BAC521_BAC521_722 = "722";
	// BAC521_高级编辑
	public static final String BAC521_BAC521_73 = "73";
	// BAC521_一级摄影师
	public static final String BAC521_BAC521_731 = "731";
	// BAC521_二级摄影师
	public static final String BAC521_BAC521_732 = "732";
	// BAC521_主任编辑
	public static final String BAC521_BAC521_74 = "74";
	// BAC521_二级录音师
	public static final String BAC521_BAC521_741 = "741";
	// BAC521_一级编辑
	public static final String BAC521_BAC521_75 = "75";
	// BAC521_一级剪辑师
	public static final String BAC521_BAC521_751 = "751";
	// BAC521_二级字幕设计师
	public static final String BAC521_BAC521_761 = "761";
	// BAC521_一级编剧
	public static final String BAC521_BAC521_801 = "801";
	// BAC521_二级编剧
	public static final String BAC521_BAC521_802 = "802";
	// BAC521_一级作曲
	public static final String BAC521_BAC521_803 = "803";
	// BAC521_二级作曲
	public static final String BAC521_BAC521_804 = "804";
	// BAC521_一级导演
	public static final String BAC521_BAC521_805 = "805";
	// BAC521_二级导演
	public static final String BAC521_BAC521_806 = "806";
	// BAC521_一级演员
	public static final String BAC521_BAC521_807 = "807";
	// BAC521_二级演员
	public static final String BAC521_BAC521_808 = "808";
	// BAC521_一级演奏员
	public static final String BAC521_BAC521_809 = "809";
	// BAC521_编审
	public static final String BAC521_BAC521_81 = "81";
	// BAC521_二级演奏员
	public static final String BAC521_BAC521_810 = "810";
	// BAC521_一级指挥
	public static final String BAC521_BAC521_811 = "811";
	// BAC521_二级指挥
	public static final String BAC521_BAC521_812 = "812";
	// BAC521_一级美术师
	public static final String BAC521_BAC521_813 = "813";
	// BAC521_二级美术师
	public static final String BAC521_BAC521_814 = "814";
	// BAC521_一级舞美设计师
	public static final String BAC521_BAC521_815 = "815";
	// BAC521_二级舞美设计师
	public static final String BAC521_BAC521_816 = "816";
	// BAC521_副编审
	public static final String BAC521_BAC521_82 = "82";
	// BAC521_图书资料研究馆员
	public static final String BAC521_BAC521_91 = "91";
	// BAC521_图书资料副研究馆员
	public static final String BAC521_BAC521_92 = "92";
	// BAC531_未启用
	public static final String BAC531_BAC531_0 = "0";
	// BAC531_已启用
	public static final String BAC531_BAC531_1 = "1";
	// BAC601_新制卡
	public static final String BAC601_BAC601_01 = "01";
	// BAC601_挂失
	public static final String BAC601_BAC601_02 = "02";
	// BAC601_解挂
	public static final String BAC601_BAC601_03 = "03";
	// BAC601_注销
	public static final String BAC601_BAC601_04 = "04";
	// BAC601_补发
	public static final String BAC601_BAC601_05 = "05";
	// BAC604_新制卡
	public static final String BAC604_BAC604_1 = "1";
	// BAC604_重制卡
	public static final String BAC604_BAC604_2 = "2";
	// BAC605_未生成文件
	public static final String BAC605_BAC605_1 = "1";
	// BAC605_已生成文件
	public static final String BAC605_BAC605_2 = "2";
	// BAC606_待数据交接
	public static final String BAC606_BAC606_01 = "01";
	// BAC606_待发放
	public static final String BAC606_BAC606_04 = "04";
	// BAC606_已发放
	public static final String BAC606_BAC606_05 = "05";
	// BAC608_数据交接
	public static final String BAC608_BAC608_01 = "01";
	// BAC608_制卡登记
	public static final String BAC608_BAC608_02 = "02";
	// BAC608_卡交接
	public static final String BAC608_BAC608_03 = "03";
	// BAC608_发放
	public static final String BAC608_BAC608_04 = "04";
	// BAC610_否
	public static final String BAC610_BAC610_0 = "0";
	// BAC610_是
	public static final String BAC610_BAC610_1 = "1";
	// BAC719_定额
	public static final String BAC719_BAC719_1 = "1";
	// BAC719_比例
	public static final String BAC719_BAC719_2 = "2";
	// BAC801_否
	public static final String BAC801_BAC801_0 = "0";
	// BAC801_是
	public static final String BAC801_BAC801_1 = "1";
	// BAC802_否
	public static final String BAC802_BAC802_0 = "0";
	// BAC802_是
	public static final String BAC802_BAC802_1 = "1";
	// BAC803_否
	public static final String BAC803_BAC803_0 = "0";
	// BAC803_是
	public static final String BAC803_BAC803_1 = "1";
	// BAD001_无
	public static final String BAD001_BAD001_000 = "000";
	// BAD001_中国工商银行
	public static final String BAD001_BAD001_102 = "102";
	// BAD001_中国农业银行
	public static final String BAD001_BAD001_103 = "103";
	// BAD001_中国银行
	public static final String BAD001_BAD001_104 = "104";
	// BAD001_中国建设银行
	public static final String BAD001_BAD001_105 = "105";
	// BAD001_中国进出口银行
	public static final String BAD001_BAD001_202 = "202";
	// BAD001_中国农业发展银行
	public static final String BAD001_BAD001_203 = "203";
	// BAD001_交通银行
	public static final String BAD001_BAD001_301 = "301";
	// BAD001_中信实业银行
	public static final String BAD001_BAD001_302 = "302";
	// BAD001_中国光大银行
	public static final String BAD001_BAD001_303 = "303";
	// BAD001_华夏银行
	public static final String BAD001_BAD001_304 = "304";
	// BAD001_中国民生银行
	public static final String BAD001_BAD001_305 = "305";
	// BAD001_广东发展银行
	public static final String BAD001_BAD001_306 = "306";
	// BAD001_深圳发展银行
	public static final String BAD001_BAD001_307 = "307";
	// BAD001_招商银行
	public static final String BAD001_BAD001_308 = "308";
	// BAD001_兴业银行
	public static final String BAD001_BAD001_309 = "309";
	// BAD001_上海浦东发展银行
	public static final String BAD001_BAD001_310 = "310";
	// BAD001_城市商业银行
	public static final String BAD001_BAD001_313 = "313";
	// BAD001_农村商业银行
	public static final String BAD001_BAD001_314 = "314";
	// BAD001_邮政储蓄
	public static final String BAD001_BAD001_315 = "315";
	// BAD003_代收
	public static final String BAD003_BAD003_1 = "1";
	// BAD003_代发
	public static final String BAD003_BAD003_2 = "2";
	// BAD003_代收代发
	public static final String BAD003_BAD003_3 = "3";
	// BAE100_陕西
	public static final String BAE100_BAE100_1 = "1";
	// BAE100_山西
	public static final String BAE100_BAE100_10 = "A";
	// BAE100_江苏
	public static final String BAE100_BAE100_11 = "B";
	// BAE100_浙江
	public static final String BAE100_BAE100_12 = "C";
	// BAE100_天津
	public static final String BAE100_BAE100_13 = "D";
	// BAE100_安徽
	public static final String BAE100_BAE100_14 = "E";
	// BAE100_江西
	public static final String BAE100_BAE100_15 = "F";
	// BAE100_贵州
	public static final String BAE100_BAE100_16 = "G";
	// BAE100_云南
	public static final String BAE100_BAE100_17 = "H";
	// BAE100_四川
	public static final String BAE100_BAE100_18 = "I";
	// BAE100_西藏
	public static final String BAE100_BAE100_19 = "J";
	// BAE100_北京
	public static final String BAE100_BAE100_2 = "2";
	// BAE100_广西
	public static final String BAE100_BAE100_20 = "K";
	// BAE100_湖北
	public static final String BAE100_BAE100_21 = "L";
	// BAE100_湖南
	public static final String BAE100_BAE100_22 = "M";
	// BAE100_广东
	public static final String BAE100_BAE100_23 = "N";
	// BAE100_上海
	public static final String BAE100_BAE100_24 = "O";
	// BAE100_海南
	public static final String BAE100_BAE100_25 = "P";
	// BAE100_福建
	public static final String BAE100_BAE100_26 = "Q";
	// BAE100_重庆
	public static final String BAE100_BAE100_27 = "R";
	// BAE100_甘肃
	public static final String BAE100_BAE100_28 = "S";
	// BAE100_宁夏
	public static final String BAE100_BAE100_29 = "T";
	// BAE100_黑龙江
	public static final String BAE100_BAE100_3 = "3";
	// BAE100_新疆
	public static final String BAE100_BAE100_30 = "U";
	// BAE100_青海
	public static final String BAE100_BAE100_31 = "V";
	// BAE100_香港特别行政区
	public static final String BAE100_BAE100_32 = "W";
	// BAE100_澳门特别行政区
	public static final String BAE100_BAE100_33 = "X";
	// BAE100_台湾
	public static final String BAE100_BAE100_34 = "Y";
	// BAE100_吉林
	public static final String BAE100_BAE100_4 = "4";
	// BAE100_辽宁
	public static final String BAE100_BAE100_5 = "5";
	// BAE100_内蒙古
	public static final String BAE100_BAE100_6 = "6";
	// BAE100_河北
	public static final String BAE100_BAE100_7 = "7";
	// BAE100_河南
	public static final String BAE100_BAE100_8 = "8";
	// BAE100_山东
	public static final String BAE100_BAE100_9 = "9";
	// BAE101_省级
	public static final String BAE101_BAE101_1 = "100";
	// BAE101_安康市
	public static final String BAE101_BAE101_10 = "109";
	// BAE101_商洛市
	public static final String BAE101_BAE101_11 = "110";
	// BAE101_杨凌示范区
	public static final String BAE101_BAE101_12 = "111";
	// BAE101_省级
	public static final String BAE101_BAE101_13 = "200";
	// BAE101_北京房山区
	public static final String BAE101_BAE101_14 = "202";
	// BAE101_北京西城区
	public static final String BAE101_BAE101_15 = "203";
	// BAE101_中国印钞
	public static final String BAE101_BAE101_16 = "204";
	// BAE101_省级
	public static final String BAE101_BAE101_17 = "300";
	// BAE101_省级
	public static final String BAE101_BAE101_18 = "400";
	// BAE101_省级
	public static final String BAE101_BAE101_19 = "500";
	// BAE101_西安市
	public static final String BAE101_BAE101_2 = "101";
	// BAE101_省级
	public static final String BAE101_BAE101_20 = "600";
	// BAE101_省级
	public static final String BAE101_BAE101_21 = "700";
	// BAE101_省级
	public static final String BAE101_BAE101_22 = "800";
	// BAE101_省级
	public static final String BAE101_BAE101_23 = "900";
	// BAE101_省级
	public static final String BAE101_BAE101_24 = "A00";
	// BAE101_省级
	public static final String BAE101_BAE101_25 = "B00";
	// BAE101_省级
	public static final String BAE101_BAE101_26 = "C00";
	// BAE101_省级
	public static final String BAE101_BAE101_27 = "D00";
	// BAE101_省级
	public static final String BAE101_BAE101_28 = "E00";
	// BAE101_省级
	public static final String BAE101_BAE101_29 = "F00";
	// BAE101_铜川市
	public static final String BAE101_BAE101_3 = "102";
	// BAE101_省级
	public static final String BAE101_BAE101_30 = "G00";
	// BAE101_省级
	public static final String BAE101_BAE101_31 = "H00";
	// BAE101_省级
	public static final String BAE101_BAE101_32 = "I00";
	// BAE101_重庆南坪
	public static final String BAE101_BAE101_33 = "I01";
	// BAE101_省级
	public static final String BAE101_BAE101_34 = "J00";
	// BAE101_省级
	public static final String BAE101_BAE101_35 = "K00";
	// BAE101_省级
	public static final String BAE101_BAE101_36 = "L00";
	// BAE101_省级
	public static final String BAE101_BAE101_37 = "M00";
	// BAE101_省级
	public static final String BAE101_BAE101_38 = "N00";
	// BAE101_省级
	public static final String BAE101_BAE101_39 = "O00";
	// BAE101_宝鸡市
	public static final String BAE101_BAE101_4 = "103";
	// BAE101_浦东新区
	public static final String BAE101_BAE101_40 = "O01";
	// BAE101_黄浦区
	public static final String BAE101_BAE101_41 = "O02";
	// BAE101_卢湾区
	public static final String BAE101_BAE101_42 = "O03";
	// BAE101_杨浦区
	public static final String BAE101_BAE101_43 = "O04";
	// BAE101_闵行区
	public static final String BAE101_BAE101_44 = "O05";
	// BAE101_虹口区
	public static final String BAE101_BAE101_45 = "O06";
	// BAE101_徐汇区
	public static final String BAE101_BAE101_46 = "O07";
	// BAE101_省级
	public static final String BAE101_BAE101_47 = "P00";
	// BAE101_海南省
	public static final String BAE101_BAE101_48 = "P01";
	// BAE101_蒲田市
	public static final String BAE101_BAE101_49 = "P02";
	// BAE101_咸阳市
	public static final String BAE101_BAE101_5 = "104";
	// BAE101_省级
	public static final String BAE101_BAE101_50 = "Q00";
	// BAE101_省级
	public static final String BAE101_BAE101_51 = "R00";
	// BAE101_省级
	public static final String BAE101_BAE101_52 = "S00";
	// BAE101_白银市
	public static final String BAE101_BAE101_53 = "S01";
	// BAE101_省级
	public static final String BAE101_BAE101_54 = "T00";
	// BAE101_省级
	public static final String BAE101_BAE101_55 = "U00";
	// BAE101_省级
	public static final String BAE101_BAE101_56 = "V00";
	// BAE101_西宁市
	public static final String BAE101_BAE101_57 = "V01";
	// BAE101_渭南市
	public static final String BAE101_BAE101_6 = "105";
	// BAE101_延安市
	public static final String BAE101_BAE101_7 = "106";
	// BAE101_汉中市
	public static final String BAE101_BAE101_8 = "107";
	// BAE101_榆林市
	public static final String BAE101_BAE101_9 = "108";
	// BAE102_省本级
	public static final String BAE102_BAE102_1 = "10000";
	// BAE102_高新区
	public static final String BAE102_BAE102_10 = "10108";
	// BAE102_清涧县
	public static final String BAE102_BAE102_100 = "10811";
	// BAE102_子洲县
	public static final String BAE102_BAE102_101 = "10812";
	// BAE102_市本级
	public static final String BAE102_BAE102_102 = "10900";
	// BAE102_汉滨区
	public static final String BAE102_BAE102_103 = "10901";
	// BAE102_汉阴县
	public static final String BAE102_BAE102_104 = "10902";
	// BAE102_石泉县
	public static final String BAE102_BAE102_105 = "10903";
	// BAE102_宁陕县
	public static final String BAE102_BAE102_106 = "10904";
	// BAE102_紫阳县
	public static final String BAE102_BAE102_107 = "10905";
	// BAE102_岚皋县
	public static final String BAE102_BAE102_108 = "10906";
	// BAE102_平利县
	public static final String BAE102_BAE102_109 = "10907";
	// BAE102_长安县
	public static final String BAE102_BAE102_11 = "10109";
	// BAE102_镇坪县
	public static final String BAE102_BAE102_110 = "10908";
	// BAE102_旬阳县
	public static final String BAE102_BAE102_111 = "10909";
	// BAE102_白河县
	public static final String BAE102_BAE102_112 = "10910";
	// BAE102_市本级
	public static final String BAE102_BAE102_113 = "11000";
	// BAE102_商州区
	public static final String BAE102_BAE102_114 = "11001";
	// BAE102_洛南县
	public static final String BAE102_BAE102_115 = "11002";
	// BAE102_丹凤县
	public static final String BAE102_BAE102_116 = "11003";
	// BAE102_商南县
	public static final String BAE102_BAE102_117 = "11004";
	// BAE102_山阳县
	public static final String BAE102_BAE102_118 = "11005";
	// BAE102_镇安县
	public static final String BAE102_BAE102_119 = "11006";
	// BAE102_蓝田县
	public static final String BAE102_BAE102_12 = "10110";
	// BAE102_柞水县
	public static final String BAE102_BAE102_120 = "11007";
	// BAE102_市本级
	public static final String BAE102_BAE102_121 = "11100";
	// BAE102_临潼区
	public static final String BAE102_BAE102_13 = "10111";
	// BAE102_周至县
	public static final String BAE102_BAE102_14 = "10112";
	// BAE102_户县
	public static final String BAE102_BAE102_15 = "10113";
	// BAE102_高陵县
	public static final String BAE102_BAE102_16 = "10114";
	// BAE102_经济开发区
	public static final String BAE102_BAE102_17 = "10115";
	// BAE102_市本级
	public static final String BAE102_BAE102_18 = "10200";
	// BAE102_王益区
	public static final String BAE102_BAE102_19 = "10201";
	// BAE102_市本级
	public static final String BAE102_BAE102_2 = "10100";
	// BAE102_印台区
	public static final String BAE102_BAE102_20 = "10202";
	// BAE102_耀县
	public static final String BAE102_BAE102_21 = "10203";
	// BAE102_宜君县
	public static final String BAE102_BAE102_22 = "10204";
	// BAE102_市本级
	public static final String BAE102_BAE102_23 = "10300";
	// BAE102_渭滨区
	public static final String BAE102_BAE102_24 = "10301";
	// BAE102_金台区
	public static final String BAE102_BAE102_25 = "10302";
	// BAE102_宝鸡县
	public static final String BAE102_BAE102_26 = "10303";
	// BAE102_凤翔县
	public static final String BAE102_BAE102_27 = "10304";
	// BAE102_岐山县
	public static final String BAE102_BAE102_28 = "10305";
	// BAE102_扶风县
	public static final String BAE102_BAE102_29 = "10306";
	// BAE102_新城区
	public static final String BAE102_BAE102_3 = "10101";
	// BAE102_眉县
	public static final String BAE102_BAE102_30 = "10307";
	// BAE102_陇县
	public static final String BAE102_BAE102_31 = "10308";
	// BAE102_千阳县
	public static final String BAE102_BAE102_32 = "10309";
	// BAE102_麟游县
	public static final String BAE102_BAE102_33 = "10310";
	// BAE102_凤县
	public static final String BAE102_BAE102_34 = "10311";
	// BAE102_太白县
	public static final String BAE102_BAE102_35 = "10312";
	// BAE102_市本级
	public static final String BAE102_BAE102_36 = "10400";
	// BAE102_秦都区
	public static final String BAE102_BAE102_37 = "10401";
	// BAE102_渭城区
	public static final String BAE102_BAE102_38 = "10402";
	// BAE102_三原县
	public static final String BAE102_BAE102_39 = "10403";
	// BAE102_碑林区
	public static final String BAE102_BAE102_4 = "10102";
	// BAE102_泾阳县
	public static final String BAE102_BAE102_40 = "10404";
	// BAE102_乾县
	public static final String BAE102_BAE102_41 = "10405";
	// BAE102_礼泉县
	public static final String BAE102_BAE102_42 = "10406";
	// BAE102_永寿县
	public static final String BAE102_BAE102_43 = "10407";
	// BAE102_彬县
	public static final String BAE102_BAE102_44 = "10408";
	// BAE102_长武县
	public static final String BAE102_BAE102_45 = "10409";
	// BAE102_旬邑县
	public static final String BAE102_BAE102_46 = "10410";
	// BAE102_淳化县
	public static final String BAE102_BAE102_47 = "10411";
	// BAE102_武功县
	public static final String BAE102_BAE102_48 = "10412";
	// BAE102_兴平市
	public static final String BAE102_BAE102_49 = "10413";
	// BAE102_莲湖区
	public static final String BAE102_BAE102_5 = "10103";
	// BAE102_市本级
	public static final String BAE102_BAE102_50 = "10500";
	// BAE102_临渭区
	public static final String BAE102_BAE102_51 = "10501";
	// BAE102_华县
	public static final String BAE102_BAE102_52 = "10502";
	// BAE102_潼关县
	public static final String BAE102_BAE102_53 = "10503";
	// BAE102_大荔县
	public static final String BAE102_BAE102_54 = "10504";
	// BAE102_合阳县
	public static final String BAE102_BAE102_55 = "10505";
	// BAE102_澄城县
	public static final String BAE102_BAE102_56 = "10506";
	// BAE102_蒲城县
	public static final String BAE102_BAE102_57 = "10507";
	// BAE102_白水县
	public static final String BAE102_BAE102_58 = "10508";
	// BAE102_富平县
	public static final String BAE102_BAE102_59 = "10509";
	// BAE102_灞桥区
	public static final String BAE102_BAE102_6 = "10104";
	// BAE102_韩城县
	public static final String BAE102_BAE102_60 = "10510";
	// BAE102_华阴市
	public static final String BAE102_BAE102_61 = "10511";
	// BAE102_开发区
	public static final String BAE102_BAE102_62 = "10512";
	// BAE102_市本级
	public static final String BAE102_BAE102_63 = "10600";
	// BAE102_宝塔区
	public static final String BAE102_BAE102_64 = "10601";
	// BAE102_延长县
	public static final String BAE102_BAE102_65 = "10602";
	// BAE102_延川县
	public static final String BAE102_BAE102_66 = "10603";
	// BAE102_子长县
	public static final String BAE102_BAE102_67 = "10604";
	// BAE102_安塞县
	public static final String BAE102_BAE102_68 = "10605";
	// BAE102_志丹县
	public static final String BAE102_BAE102_69 = "10606";
	// BAE102_未央区
	public static final String BAE102_BAE102_7 = "10105";
	// BAE102_吴旗县
	public static final String BAE102_BAE102_70 = "10607";
	// BAE102_甘泉县
	public static final String BAE102_BAE102_71 = "10608";
	// BAE102_富县
	public static final String BAE102_BAE102_72 = "10609";
	// BAE102_洛川县
	public static final String BAE102_BAE102_73 = "10610";
	// BAE102_宜川县
	public static final String BAE102_BAE102_74 = "10611";
	// BAE102_黄龙县
	public static final String BAE102_BAE102_75 = "10612";
	// BAE102_黄陵县
	public static final String BAE102_BAE102_76 = "10613";
	// BAE102_市本级
	public static final String BAE102_BAE102_77 = "10700";
	// BAE102_汉台区
	public static final String BAE102_BAE102_78 = "10701";
	// BAE102_城固县
	public static final String BAE102_BAE102_79 = "10702";
	// BAE102_雁塔区
	public static final String BAE102_BAE102_8 = "10106";
	// BAE102_南郑县
	public static final String BAE102_BAE102_80 = "10703";
	// BAE102_勉县
	public static final String BAE102_BAE102_81 = "10704";
	// BAE102_洋县
	public static final String BAE102_BAE102_82 = "10705";
	// BAE102_略阳县
	public static final String BAE102_BAE102_83 = "10706";
	// BAE102_西乡县
	public static final String BAE102_BAE102_84 = "10707";
	// BAE102_宁强县
	public static final String BAE102_BAE102_85 = "10708";
	// BAE102_镇巴县
	public static final String BAE102_BAE102_86 = "10709";
	// BAE102_留坝县
	public static final String BAE102_BAE102_87 = "10710";
	// BAE102_佛坪县
	public static final String BAE102_BAE102_88 = "10711";
	// BAE102_市本级
	public static final String BAE102_BAE102_89 = "10800";
	// BAE102_阎良区
	public static final String BAE102_BAE102_9 = "10107";
	// BAE102_榆阳区
	public static final String BAE102_BAE102_90 = "10801";
	// BAE102_神木县
	public static final String BAE102_BAE102_91 = "10802";
	// BAE102_府谷县
	public static final String BAE102_BAE102_92 = "10803";
	// BAE102_横山县
	public static final String BAE102_BAE102_93 = "10804";
	// BAE102_靖边县
	public static final String BAE102_BAE102_94 = "10805";
	// BAE102_定边县
	public static final String BAE102_BAE102_95 = "10806";
	// BAE102_绥德县
	public static final String BAE102_BAE102_96 = "10807";
	// BAE102_米脂县
	public static final String BAE102_BAE102_97 = "10808";
	// BAE102_佳县
	public static final String BAE102_BAE102_98 = "10809";
	// BAE102_吴堡县
	public static final String BAE102_BAE102_99 = "10810";
	// BAE103_统筹范围内
	public static final String BAE103_BAE103_1 = "1";
	// BAE103_统筹范围外
	public static final String BAE103_BAE103_2 = "2";
	// BAE103_数据中心内转移
	public static final String BAE103_BAE103_3 = "3";
	// BAE701_单位
	public static final String BAE701_BAE701_1 = "1";
	// BAE701_个人
	public static final String BAE701_BAE701_2 = "2";
	// BAE702_经办机构
	public static final String BAE702_BAE702_0 = "0";
	// BAE702_单位
	public static final String BAE702_BAE702_1 = "1";
	// BAE702_个人
	public static final String BAE702_BAE702_2 = "2";
	// BAE702_家庭
	public static final String BAE702_BAE702_3 = "3";
	// BAE702_定点医疗机构
	// public static final String BAE702_BAE702_4 = "4";
	// BAE702_社区
	public static final String BAE702_BAE702_5 = "5";
	// BAE702_学校
	public static final String BAE702_BAE702_6 = "6";
	// BAE702_班級
	public static final String BAE702_BAE702_7 = "7";
	// BAE717_基金征集计划
	public static final String BAE717_BAE717_1 = "1";
	// BAE717_医保注入计划
	public static final String BAE717_BAE717_2 = "2";
	// BAE718_普通待转基金
	public static final String BAE718_BAE718_1 = "1";
	// BAE718_4050待转基金
	public static final String BAE718_BAE718_2 = "2";
	// BAE718_军转干部待转基金
	public static final String BAE718_BAE718_3 = "3";
	// BAE718_税务征收待转
	public static final String BAE718_BAE718_4 = "4";
	// BAE723_预缴
	public static final String BAE723_BAE723_1 = "1";
	// BAE723_税务非计划征收
	public static final String BAE723_BAE723_2 = "2";
	// BAE723_转入
	public static final String BAE723_BAE723_3 = "3";
	// BAE723_转出
	public static final String BAE723_BAE723_4 = "4";
	// BAE723_冲抵
	public static final String BAE723_BAE723_5 = "5";
	// BAE723_退款
	public static final String BAE723_BAE723_6 = "6";
	// BAE727_收现金
	public static final String BAE727_BAE727_1 = "1";
	// BAE727_收支票
	public static final String BAE727_BAE727_2 = "2";
	// BAE727_托收单
	public static final String BAE727_BAE727_3 = "3";
	// BAE727_POS结算
	public static final String BAE727_BAE727_4 = "4";
	// BAE727_付现金
	public static final String BAE727_BAE727_5 = "5";
	// BAE727_付支票
	public static final String BAE727_BAE727_6 = "6";
	// BAE727_基金转帐
	public static final String BAE727_BAE727_7 = "7";
	// BAE727_单位银行托收
	public static final String BAE727_BAE727_8 = "8";
	// BAE727_个人银行托收
	public static final String BAE727_BAE727_9 = "9";
	// BAE727_单位银行托付
	public static final String BAE727_BAE727_10 = "10";
	// BAE727_个人银行托付
	public static final String BAE727_BAE727_11 = "11";
	// BAE727_邮政汇寄
	public static final String BAE727_BAE727_12 = "12";
	// BAE727_税务征收
	public static final String BAE727_BAE727_13 = "13";
	// BAE727_现金缴款单
	public static final String BAE727_BAE727_14 = "14";
	// BAE731_现金交款单
	public static final String BAE731_BAE731_1 = "1";
	// BAE731_税票
	public static final String BAE731_BAE731_2 = "2";
	// BAE731_电汇凭证
	public static final String BAE731_BAE731_3 = "3";
	// BAE731_转帐支票
	public static final String BAE731_BAE731_4 = "4";
	// BAE731_现金支票
	public static final String BAE731_BAE731_5 = "5";
	// BAE731_缴费专用票
	public static final String BAE731_BAE731_6 = "6";
	// BAE734_未指定
	public static final String BAE734_BAE734_00 = "00";
	// BAE734_在职
	public static final String BAE734_BAE734_01 = "01";
	// BAE734_退休
	public static final String BAE734_BAE734_02 = "02";
	// BAE734_离休
	public static final String BAE734_BAE734_03 = "03";
	// BAE734_其它
	public static final String BAE734_BAE734_04 = "04";
	// BAE735_否
	public static final String BAE735_BAE735_0 = "0";
	// BAE735_是
	public static final String BAE735_BAE735_1 = "1";
	// BAE739_否
	public static final String BAE739_BAE739_0 = "0";
	// BAE739_是
	public static final String BAE739_BAE739_1 = "1";
	// BAE746_否
	public static final String BAE746_BAE746_0 = "0";
	// BAE746_是
	public static final String BAE746_BAE746_1 = "1";
	// BAE747_否
	public static final String BAE747_BAE747_0 = "0";
	// BAE747_是
	public static final String BAE747_BAE747_1 = "1";
	// BAE751_地税代征
	public static final String BAE751_BAE751_1 = "01";
	// BAE751_银行托收
	public static final String BAE751_BAE751_2 = "02";
	// BAE751_地税回盘
	public static final String BAE751_BAE751_3 = "03";
	// BAE751_银行回盘
	public static final String BAE751_BAE751_4 = "04";
	// BAE751_银行新增人员报盘
	public static final String BAE751_BAE751_5 = "05";
	// BAE751_新建帐号回盘
	public static final String BAE751_BAE751_6 = "06";
	// BAE761_失败
	public static final String BAE761_BAE761_0 = "0";
	// BAE761_成功
	public static final String BAE761_BAE761_1 = "1";
	// BAE762_未回盘
	public static final String BAE762_BAE762_0 = "0";
	// BAE762_已回盘
	public static final String BAE762_BAE762_1 = "1";
	// BAE769_文件回盘
	public static final String BAE769_BAE769_1 = "1";
	// BAE769_人工登记
	public static final String BAE769_BAE769_2 = "2";
	// BAE769_人工登记-单笔
	public static final String BAE769_BAE769_3 = "3";
	// BAE775_税票回单到帐
	public static final String BAE775_BAE775_1 = "1";
	// BAE775_社保自收到帐
	public static final String BAE775_BAE775_2 = "2";
	// BAE775_银行托收到帐
	public static final String BAE775_BAE775_3 = "3";
	// BAE775_代理机构到帐登记
	public static final String BAE775_BAE775_4 = "4";
	// BAE775_税票回单到帐--单笔录入
	public static final String BAE775_BAE775_5 = "5";
	// BAE786_收入户
	public static final String BAE786_BAE786_1 = "1";
	// BAE786_支出户
	public static final String BAE786_BAE786_2 = "2";
	// BAE787_正
	public static final String BAE787_BAE787_1 = "1";
	// BAE787_负
	public static final String BAE787_BAE787_2 = "2";
	// BAE791_未指定
	public static final String BAE791_BAE791_00 = "00";
	// BAE791_企业
	public static final String BAE791_BAE791_01 = "01";
	// BAE791_事业
	public static final String BAE791_BAE791_02 = "02";
	// BAE791_其它
	public static final String BAE791_BAE791_03 = "03";
	// BAE792_未指定
	public static final String BAE792_BAE792_00000 = "00000";
	// BAE792_住院费用支出
	public static final String BAE792_BAE792_00201 = "00201";
	// BAE792_特检特治费用支出
	public static final String BAE792_BAE792_00202 = "00202";
	// BAE792_慢性病费用支出
	public static final String BAE792_BAE792_00203 = "00203";
	// BAE792_其它支出
	public static final String BAE792_BAE792_00204 = "00204";

	// BAE793_单位缴费
	public static final String BAE793_BAE793_001101 = "001101";
	// BAE793_个人缴费
	public static final String BAE793_BAE793_001102 = "001102";
	// BAE793_个人账户做实部分
	public static final String BAE793_BAE793_001103 = "001103";
	// BAE793_一般待转基金
	public static final String BAE793_BAE793_001104 = "001104";
	// BAE793_4050人员待转基金
	public static final String BAE793_BAE793_001105 = "001105";
	// BAE793_军转干部待转基金
	public static final String BAE793_BAE793_001106 = "001106";
	// BAE793_地税征收待转
	public static final String BAE793_BAE793_001107 = "001107";
	// BAE793_其他财政补贴待转
	public static final String BAE793_BAE793_001108 = "001108";
	// BAE793_单位缴费-统筹部分
	public static final String BAE793_BAE793_001109 = "001109";
	// BAE793_单位缴费-划转个人账户部分
	public static final String BAE793_BAE793_00110A = "00110A";
	// BAE793_个人缴费-统筹部分
	public static final String BAE793_BAE793_00110B = "00110B";
	// BAE793_个人缴费-划转个人账户部分
	public static final String BAE793_BAE793_00110C = "00110C";
	// BAE793_利息收入-收入户利息
	public static final String BAE793_BAE793_001201 = "001201";
	// BAE793_利息收入-支出户利息
	public static final String BAE793_BAE793_001202 = "001202";
	// BAE793_利息收入-财政专户利息收入
	public static final String BAE793_BAE793_001203 = "001203";
	// BAE793_利息收入-企业上缴利息收入
	public static final String BAE793_BAE793_001204 = "001204";
	// BAE793_利息收入-补缴利息收入
	public static final String BAE793_BAE793_001205 = "001205";
	// BAE793_财政补贴收入-地方财政
	public static final String BAE793_BAE793_001301 = "001301";
	// BAE793_财政补贴收入-中央财政
	public static final String BAE793_BAE793_001302 = "001302";
	// BAE793_转移收入
	public static final String BAE793_BAE793_001401 = "001401";
	// BAE793_其他收入-滞纳金
	public static final String BAE793_BAE793_001901 = "001901";
	// BAE793_其他收入-其它
	public static final String BAE793_BAE793_001902 = "001902";
	// BAE793_基础性养老金
	public static final String BAE793_BAE793_001A01 = "001A01";
	// BAE793_个人帐户养老金
	public static final String BAE793_BAE793_001A02 = "001A02";
	// BAE793_过渡性养老金
	public static final String BAE793_BAE793_001A03 = "001A03";
	// BAE793_离休金
	public static final String BAE793_BAE793_001A04 = "001A04";
	// BAE793_退休金
	public static final String BAE793_BAE793_001A05 = "001A05";
	// BAE793_退职金
	public static final String BAE793_BAE793_001A06 = "001A06";
	// BAE793_补贴
	public static final String BAE793_BAE793_001A07 = "001A07";
	// BAE793_补贴调节金
	public static final String BAE793_BAE793_001A08 = "001A08";
	// BAE793_医疗补助支出
	public static final String BAE793_BAE793_001B01 = "001B01";
	// BAE793_丧葬抚恤补助支出
	public static final String BAE793_BAE793_001C01 = "001C01";
	// BAE793_其他费用支出
	public static final String BAE793_BAE793_001D01 = "001D01";
	// BAE793_转移支出
	public static final String BAE793_BAE793_001E01 = "001E01";
	// BAE793_其他支出
	public static final String BAE793_BAE793_001F01 = "001F01";
	// BAE793_现金日记帐
	public static final String BAE793_BAE793_001G00 = "001G00";
	// BAE793_收入户存款-西安市工商银行陕西分行
	public static final String BAE793_BAE793_001H01 = "001H01";
	// BAE793_暂付款-单位暂付款
	public static final String BAE793_BAE793_001I01 = "001I01";
	// BAE793_暂付款-其它暂付款
	public static final String BAE793_BAE793_001I02 = "001I02";
	// BAE793_暂收款-借入基金
	public static final String BAE793_BAE793_001J01 = "001J01";
	// BAE793_暂收款-基金暂收
	public static final String BAE793_BAE793_001J02 = "001J02";
	// BAE793_基金暂收-地税暂收
	public static final String BAE793_BAE793_001J03 = "001J03";
	// BAE793_基金暂收-不明转移暂收
	public static final String BAE793_BAE793_001J04 = "001J04";
	// BAE793_基金暂收-其他暂收
	public static final String BAE793_BAE793_001J05 = "001J05";
	// BAE793_支出户存款
	public static final String BAE793_BAE793_001K01 = "001K01";
	// BAE793_基本医疗保险费统筹收入
	public static final String BAE793_BAE793_002101 = "002101";
	// BAE793_基本医疗保险费统筹利息收入
	public static final String BAE793_BAE793_002102 = "002102";
	// BAE793_基本医疗保险费统筹财政补贴收入
	public static final String BAE793_BAE793_002103 = "002103";
	// BAE793_基本医疗保险费统筹上级补贴收入
	public static final String BAE793_BAE793_002104 = "002104";
	// BAE793_基本医疗保险费统筹下级上解收入
	public static final String BAE793_BAE793_002105 = "002105";
	// BAE793_基本医疗保险费统筹其它收入
	public static final String BAE793_BAE793_002106 = "002106";
	// BAE793_医疗个人账户收入单位缴费划转
	public static final String BAE793_BAE793_002201 = "002201";
	// BAE793_医疗个人账户收入个人缴纳
	public static final String BAE793_BAE793_002202 = "002202";
	// BAE793_医疗个人账户收入利息收入
	public static final String BAE793_BAE793_002203 = "002203";
	// BAE793_医疗个人账户收入转移收入
	public static final String BAE793_BAE793_002204 = "002204";
	// BAE793_重大疾病补助收入其它
	public static final String BAE793_BAE793_002301 = "002301";
	// BAE793_重大疾病补助基金收入利息收入
	public static final String BAE793_BAE793_002302 = "002302";
	// BAE793_重大疾病补助基金收入-其它收入
	public static final String BAE793_BAE793_002303 = "002303";
	// BAE793_公务员医疗补助基金收入单位缴纳收入
	public static final String BAE793_BAE793_002401 = "002401";
	// BAE793_公务员医疗补助基金收入财政补贴收入
	public static final String BAE793_BAE793_002402 = "002402";
	// BAE793_公务员医疗补助基金收入利息收入
	public static final String BAE793_BAE793_002403 = "002403";
	// BAE793_公务员医疗补助基金收入-其它收入
	public static final String BAE793_BAE793_002404 = "002404";
	// BAE793_医疗照顾人员医疗补助基金收入单位缴纳收入
	public static final String BAE793_BAE793_002501 = "002501";
	// BAE793_医疗照顾人员医疗补助基金收入财政补贴收入
	public static final String BAE793_BAE793_002502 = "002502";
	// BAE793_医疗照顾人员医疗补助基金收入利息收入
	public static final String BAE793_BAE793_002503 = "002503";
	// BAE793_医疗照顾人员医疗补助基金收入-其它收入
	public static final String BAE793_BAE793_002504 = "002504";
	// BAE793_基本医疗保险统筹基金支出医疗保险待遇支出
	public static final String BAE793_BAE793_002601 = "002601";
	// BAE793_基本医疗保险统筹基金支出上解上级支出
	public static final String BAE793_BAE793_002602 = "002602";
	// BAE793_基本医疗保险统筹基金支出补助下级支出
	public static final String BAE793_BAE793_002603 = "002603";
	// BAE793_基本医疗保险统筹基金支出其它支出
	public static final String BAE793_BAE793_002604 = "002604";
	// BAE793_医疗个人账户支出医疗保险待遇支出
	public static final String BAE793_BAE793_002701 = "002701";
	// BAE793_医疗个人账户支出转移支出
	public static final String BAE793_BAE793_002702 = "002702";
	// BAE793_重大疾病医疗待遇支出-住院费用支出
	public static final String BAE793_BAE793_002801 = "002801";
	// BAE793_公务员医疗待遇支出-住院费用支出
	public static final String BAE793_BAE793_002901 = "002901";
	// BAE793_医疗照顾人员待遇支出-住院费用支出
	public static final String BAE793_BAE793_002A01 = "002A01";
	// BAE793_现金
	public static final String BAE793_BAE793_002B01 = "002B01";
	// BAE793_收入户存款
	public static final String BAE793_BAE793_002B02 = "002B02";
	// BAE793_支出户存款
	public static final String BAE793_BAE793_002B03 = "002B03";
	// BAE793_暂付款-借出基金
	public static final String BAE793_BAE793_002C01 = "002C01";
	// BAE793_暂付款-基金暂付
	public static final String BAE793_BAE793_002C02 = "002C02";
	// BAE793_暂收款-借入基金
	public static final String BAE793_BAE793_002D01 = "002D01";
	// BAE793_暂收款-基金暂收
	public static final String BAE793_BAE793_002D02 = "002D02";
	// BAE793_待转保险收入
	public static final String BAE793_BAE793_002E01 = "002E01";
	// BAE793_待转利息收入
	public static final String BAE793_BAE793_002F01 = "002F01";
	// BAE793_部分企业退休人员补助金支出
	public static final String BAE793_BAE793_003M01 = "003M01";
	// BAE793_劳模补助金支出
	public static final String BAE793_BAE793_003M02 = "003M02";
	// BAE793_厂长经理生活补助支出
	public static final String BAE793_BAE793_003M03 = "003M03";
	// BAE793_其他补助支出
	public static final String BAE793_BAE793_003M04 = "003M04";
	// BAE793_基本医疗单位缴费
	public static final String BAE793_BAE793_005A01 = "005A01";
	// BAE793_基本医疗个人缴费
	public static final String BAE793_BAE793_005A02 = "005A02";
	// BAE793_基本医疗利息收入
	public static final String BAE793_BAE793_005A03 = "005A03";
	// BAE793_基本医疗财政补贴收入
	public static final String BAE793_BAE793_005A04 = "005A04";
	// BAE793_基本医疗上级补助收入
	public static final String BAE793_BAE793_005A05 = "005A05";
	// BAE793_基本医疗下级上解收入
	public static final String BAE793_BAE793_005A06 = "005A06";
	// BAE793_基本医疗其他收入
	public static final String BAE793_BAE793_005A07 = "005A07";
	// BAE793_个人账户单位缴费
	public static final String BAE793_BAE793_005B01 = "005B01";
	// BAE793_个人账户个人缴费
	public static final String BAE793_BAE793_005B02 = "005B02";
	// BAE793_个人账户利息收入
	public static final String BAE793_BAE793_005B03 = "005B03";
	// BAE793_个人账户转移收入
	public static final String BAE793_BAE793_005B04 = "005B04";
	// BAE793_个人账户其它收入
	public static final String BAE793_BAE793_005B05 = "005B05";
	// BAE793_大额医疗缴费
	public static final String BAE793_BAE793_005C01 = "005C01";
	// BAE793_大额利息收入
	public static final String BAE793_BAE793_005C02 = "005C02";
	// BAE793_大额其它收入
	public static final String BAE793_BAE793_005C03 = "005C03";
	// BAE793_待转保险收入
	public static final String BAE793_BAE793_005D01 = "005D01";
	// BAE793_基本医疗待遇支出
	public static final String BAE793_BAE793_005F01 = "005F01";
	// BAE793_基本医疗上解上级支出
	public static final String BAE793_BAE793_005F02 = "005F02";
	// BAE793_基本医疗补助下级支出
	public static final String BAE793_BAE793_005F03 = "005F03";
	// BAE793_基本医疗其他支出
	public static final String BAE793_BAE793_005F04 = "005F04";
	// BAE793_医疗个人账户医疗费支出
	public static final String BAE793_BAE793_005G01 = "005G01";
	// BAE793_医疗个人账户转移支出
	public static final String BAE793_BAE793_005G02 = "005G02";
	// BAE793_医疗个人账户其它支出
	public static final String BAE793_BAE793_005G03 = "005G03";
	// BAE793_大额医疗待遇支出
	public static final String BAE793_BAE793_005H01 = "005H01";
	// BAE793_大额医疗上解上级支出
	public static final String BAE793_BAE793_005H02 = "005H02";
	// BAE793_大额医疗补助下级支出
	public static final String BAE793_BAE793_005H03 = "005H03";
	// BAE793_大额医疗其他支出
	public static final String BAE793_BAE793_005H04 = "005H04";

	// BAE794_转待转基金
	public static final String BAE794_BAE794_1 = "1";
	// BAE794_冲抵欠费
	public static final String BAE794_BAE794_2 = "2";
	// BAE794_转收入
	public static final String BAE794_BAE794_3 = "3";
	// BAE807_养老保险
	public static final String BAE807_BAE807_1 = "1";
	// BAE807_省直医疗保险
	public static final String BAE807_BAE807_2 = "2";
	// BAE807_职工医疗保险
	public static final String BAE807_BAE807_3 = "3";
	// BAE807_居民医疗保险
	public static final String BAE807_BAE807_6 = "6";
	// BAE809_缴费
	public static final String BAE809_BAE809_01 = "01";
	// BAE809_养老支付
	public static final String BAE809_BAE809_02 = "02";
	// BAE809_失业支付
	public static final String BAE809_BAE809_03 = "03";
	// BAE809_医疗支付
	public static final String BAE809_BAE809_04 = "04";
	// BAE809_工伤支付
	public static final String BAE809_BAE809_05 = "05";
	// BAE809_生育支付
	public static final String BAE809_BAE809_06 = "06";
	// BAE809_基金转帐
	public static final String BAE809_BAE809_07 = "07";
	// BAE810_现金
	public static final String BAE810_BAE810_1 = "1";
	// BAE810_支票
	public static final String BAE810_BAE810_2 = "2";
	// BAE810_托收单
	public static final String BAE810_BAE810_3 = "3";
	// BAE810_基金转帐
	public static final String BAE810_BAE810_7 = "7";
	// BAE810_现金缴款单
	public static final String BAE810_BAE810_14 = "14";
	// BAE810_转帐
	public static final String BAE810_BAE810_15 = "15";
	// BAE821_月积数法
	public static final String BAE821_BAE821_1 = "1";
	// BAE821_年积数法
	public static final String BAE821_BAE821_2 = "2";
	// BAE822_养老在职计息
	public static final String BAE822_BAE822_1 = "1";
	// BAE822_养老退休计息
	public static final String BAE822_BAE822_2 = "2";
	// BAE826_个人
	public static final String BAE826_BAE826_1 = "1";
	// BAE826_单位
	public static final String BAE826_BAE826_2 = "2";
	// BAE826_医疗服务机构
	public static final String BAE826_BAE826_3 = "3";
	// BAE826_settle_个人
	public static final String BAE826_settle_BAE826_settle_1 = "1";
	// BAE826_settle_单位
	public static final String BAE826_settle_BAE826_settle_2 = "2";
	// BAE850_未结算
	public static final String BAE850_BAE850_0 = "0";
	// BAE850_已结算
	public static final String BAE850_BAE850_1 = "1";
	// BAE854_普通门诊现金报销
	public static final String BAE854_BAE854_1 = "1";
	// BAE854_特殊门诊现金报销
	public static final String BAE854_BAE854_2 = "2";
	// BAE854_住院现金报销
	public static final String BAE854_BAE854_3 = "3";
	// BAE854_定点医药机构月度结算
	public static final String BAE854_BAE854_4 = "4";
	// BAE854_定点医药机构暂留金年度结算
	public static final String BAE854_BAE854_5 = "5";
	// BAE854_待遇调整
	public static final String BAE854_BAE854_6 = "6";
	// BAE854_个人账户拨付
	public static final String BAE854_BAE854_7 = "7";
	// BAE854_个人账户返还
	public static final String BAE854_BAE854_8 = "8";
	// BAE854_个人账户入统筹
	public static final String BAE854_BAE854_9 = "9";
	// BAE854_定点医药机构超统筹年度结算
	public static final String BAE854_BAE854_10 = "10";
	// BAE854_定点医药机构年终奖励
	public static final String BAE854_BAE854_15 = "15";
	// BKC050_暂留金
	public static final String BKC050_BKC050_1 = "1";
	// BKC050_超统筹
	public static final String BKC050_BKC050_2 = "2";
	// BKC050_默认值
	public static final String BKC050_BKC050_3 = "3";
	// BAE855_有账号
	public static final String BAE855_BAE855_1 = "1";
	// BAE855_全部
	public static final String BAE855_BAE855_2 = "2";
	// BAE858_内部转帐
	public static final String BAE858_BAE858_00 = "00";
	// BAE858_银行代收
	public static final String BAE858_BAE858_01 = "01";
	// BAE858_税务征收
	public static final String BAE858_BAE858_02 = "02";
	// BAE858_社保自收
	public static final String BAE858_BAE858_03 = "03";
	// BAE858_代理机构征收
	public static final String BAE858_BAE858_04 = "04";
	// BAE858_转移收入
	public static final String BAE858_BAE858_05 = "05";
	// BAE858_其他
	public static final String BAE858_BAE858_06 = "06";
	// BAE858_银行邮储代发
	public static final String BAE858_BAE858_11 = "11";
	// BAE858_邮局汇寄
	public static final String BAE858_BAE858_12 = "12";
	// BAE858_社保自付
	public static final String BAE858_BAE858_13 = "13";
	// BAE858_转移支出
	public static final String BAE858_BAE858_14 = "14";
	// BAE858_其他
	public static final String BAE858_BAE858_15 = "15";
	// BAE859_个人
	public static final String BAE859_BAE859_1 = "1";
	// BAE859_单位
	public static final String BAE859_BAE859_2 = "2";
	// BAE859_医疗服务机构
	public static final String BAE859_BAE859_3 = "3";
	// BAE859_代理机构编号
	public static final String BAE859_BAE859_4 = "4";
	// BAE860_个人
	public static final String BAE860_BAE860_1 = "1";
	// BAE860_单位
	public static final String BAE860_BAE860_2 = "2";
	// BAE860_医疗服务机构
	public static final String BAE860_BAE860_3 = "3";
	// BAE860_代理机构编号
	public static final String BAE860_BAE860_4 = "4";
	// BAE864_财务单位类型
	public static final String BAE864_BAE864_01 = "01";
	// BAE864_医疗人员类型
	public static final String BAE864_BAE864_02 = "02";
	// BAE868_按科目汇总记帐
	public static final String BAE868_BAE868_1 = "1";
	// BAE868_按科目和辅助项汇总记帐
	public static final String BAE868_BAE868_2 = "2";
	// BIC720_西安市
	public static final String BIC720_BIC720_1 = "610100";
	// BIC720_商洛市
	public static final String BIC720_BIC720_10 = "611000";
	// BIC720_杨凌示范区
	public static final String BIC720_BIC720_11 = "611100";
	// BIC720_行业
	public static final String BIC720_BIC720_12 = "619900";
	// BIC720_铜川市
	public static final String BIC720_BIC720_2 = "610200";
	// BIC720_宝鸡市
	public static final String BIC720_BIC720_3 = "610300";
	// BIC720_咸阳市
	public static final String BIC720_BIC720_4 = "610400";
	// BIC720_渭南市
	public static final String BIC720_BIC720_5 = "610500";
	// BIC720_延安市
	public static final String BIC720_BIC720_6 = "610600";
	// BIC720_汉中市
	public static final String BIC720_BIC720_7 = "610700";
	// BIC720_榆林市
	public static final String BIC720_BIC720_8 = "610800";
	// BIC720_安康市
	public static final String BIC720_BIC720_9 = "610900";
	// BIC724_不影响待遇
	public static final String BIC724_BIC724_1 = "1";
	// BIC724_全额退款调整
	public static final String BIC724_BIC724_3 = "3";
	// BIC732_未审核
	public static final String BIC732_BIC732_1 = "1";
	// BIC732_已审核
	public static final String BIC732_BIC732_2 = "2";
	// BIC733_正常拨付
	public static final String BIC733_BIC733_1 = "1";
	// BIC733_财政补贴
	public static final String BIC733_BIC733_2 = "2";
	// BIC734_1倍
	public static final String BIC734_BIC734_1 = "1";
	// BIC734_1.5倍
	public static final String BIC734_BIC734_2 = "1.5";
	// BIC734_2倍
	public static final String BIC734_BIC734_3 = "2";
	// BIC739_正常调整
	public static final String BIC739_BIC739_1 = "1";
	// BIC739_作废调整
	public static final String BIC739_BIC739_0 = "0";
	// BIC801_否
	public static final String BIC801_BIC801_0 = "0";
	// BIC801_是
	public static final String BIC801_BIC801_1 = "1";
	// BIC804_非管理岗位
	public static final String BIC804_BIC804_1 = "1";
	// BIC804_管理岗位
	public static final String BIC804_BIC804_2 = "2";
	// BIC807_待退
	public static final String BIC807_BIC807_1 = "1";
	// BIC807_离退休
	public static final String BIC807_BIC807_2 = "2";
	// BIC859_38号文计算办法
	public static final String BIC859_BIC859_1 = "1";
	// BIC859_28号文计算办法
	public static final String BIC859_BIC859_2 = "2";
	// BIC859_老人待遇计算办法
	public static final String BIC859_BIC859_3 = "3";
	// BIC869_退休特批
	public static final String BIC869_BIC869_0 = "0";
	// BIC869_是
	public static final String BIC869_BIC869_1 = "1";
	// BIC869_正常退休
	public static final String BIC869_BIC869_2 = "2";
	// BIC923_取暖费
	public static final String BIC923_BIC923_1 = "1";
	// BIC924_发放点
	public static final String BIC924_BIC924_1 = "1";
	// BIC924_单位
	public static final String BIC924_BIC924_2 = "2";
	// BIC925_正常养老待遇
	public static final String BIC925_BIC925_1 = "1";
	// BIC925_供养亲属待遇
	public static final String BIC925_BIC925_2 = "2";
	// BIC925_单位代发
	public static final String BIC925_BIC925_3 = "3";
	// BIC926_正常拨付
	public static final String BIC926_BIC926_1 = "1";
	// BIC926_正常离休拨付
	public static final String BIC926_BIC926_10 = "10";
	// BIC926_省财政补助
	public static final String BIC926_BIC926_11 = "11";
	// BIC926_死亡拨付
	public static final String BIC926_BIC926_12 = "12";
	// BIC926_出国拨付
	public static final String BIC926_BIC926_13 = "13";
	// BIC926_全额退款
	public static final String BIC926_BIC926_14 = "14";
	// BIC926_农民工退保
	public static final String BIC926_BIC926_20 = "20";
	// BIC926_年调补拨
	public static final String BIC926_BIC926_2 = "2";
	// BIC926_增发生活费
	public static final String BIC926_BIC926_3 = "3";
	// BIC926_续发补拨
	public static final String BIC926_BIC926_4 = "4";
	// BIC926_待退补拨
	public static final String BIC926_BIC926_5 = "5";
	// BIC926_取暖费补拨
	public static final String BIC926_BIC926_6 = "6";
	// BIC926_个人特殊补拨
	public static final String BIC926_BIC926_7 = "7";
	// BIC926_单位特殊补拨
	public static final String BIC926_BIC926_8 = "8";
	// BIC926_正常退休拨付
	public static final String BIC926_BIC926_9 = "9";
	// BIC927_增加
	public static final String BIC927_BIC927_1 = "1";
	// BIC927_删除
	public static final String BIC927_BIC927_2 = "2";
	// BIC927_修改
	public static final String BIC927_BIC927_3 = "3";
	// BKA005_定额结算
	public static final String BKA005_BKA005_01 = "01";
	// BKA005_计算方式下当前使用的定额结算
	public static final String BKA005_BKA005_01_1 = "1";
	// BKA005_计算方式下当前使用的总量控制下的据实结算
	public static final String BKA005_BKA005_01_2 = "2";
	// BKA005_单病种结算
	public static final String BKA005_BKA005_02 = "02";
	// BKA005_按项目结算
	public static final String BKA005_BKA005_03 = "03";
	// BKA005_完全进入大额结算
	public static final String BKA005_BKA005_04 = "04";
	// BKA246_调节免疫功能药
	public static final String BKA246_BKA246_01 = "01";
	// BKA246_调节水、电解质及酸碱平衡药物
	public static final String BKA246_BKA246_02 = "02";
	// BKA246_呼吸系统药物
	public static final String BKA246_BKA246_03 = "03";
	// BKA246_激素及调节内分泌功能药
	public static final String BKA246_BKA246_04 = "04";
	// BKA246_解毒药
	public static final String BKA246_BKA246_05 = "05";
	// BKA246_解热镇痛及非甾体抗炎药
	public static final String BKA246_BKA246_06 = "06";
	// BKA246_抗变态反应药物
	public static final String BKA246_BKA246_07 = "07";
	// BKA246_抗寄生虫病药
	public static final String BKA246_BKA246_08 = "08";
	// BKA246_抗微生物药物
	public static final String BKA246_BKA246_09 = "09";
	// BKA246_抗肿瘤药物
	public static final String BKA246_BKA246_10 = "10";
	// BKA246_麻醉用药物
	public static final String BKA246_BKA246_11 = "11";
	// BKA246_泌尿系统药物
	public static final String BKA246_BKA246_12 = "12";
	// BKA246_神经系统用药物
	public static final String BKA246_BKA246_13 = "13";
	// BKA246_生物制品
	public static final String BKA246_BKA246_14 = "14";
	// BKA246_维生素及矿物质缺乏症用药物
	public static final String BKA246_BKA246_15 = "15";
	// BKA246_消化系统药物
	public static final String BKA246_BKA246_16 = "16";
	// BKA246_血液系统药物
	public static final String BKA246_BKA246_17 = "17";
	// BKA246_循环系统药物
	public static final String BKA246_BKA246_18 = "18";
	// BKA246_营养治疗药
	public static final String BKA246_BKA246_19 = "19";
	// BKA246_诊断用药物
	public static final String BKA246_BKA246_20 = "20";
	// BKA246_镇痛药
	public static final String BKA246_BKA246_21 = "21";
	// BKA246_治疗精神障碍药
	public static final String BKA246_BKA246_22 = "22";
	// BKA246_专科用药
	public static final String BKA246_BKA246_23 = "23";
	// BKA246_耳鼻喉科用药
	public static final String BKA246_BKA246_24 = "24";
	// BKA246_妇科用药
	public static final String BKA246_BKA246_25 = "25";
	// BKA246_骨伤科用药
	public static final String BKA246_BKA246_26 = "26";
	// BKA246_民族药
	public static final String BKA246_BKA246_27 = "27";
	// BKA246_内科用药
	public static final String BKA246_BKA246_28 = "28";
	// BKA246_皮肤科用药
	public static final String BKA246_BKA246_29 = "29";
	// BKA246_外科用药
	public static final String BKA246_BKA246_30 = "30";
	// BKA246_眼科用药
	public static final String BKA246_BKA246_31 = "31";
	// BKA246_肿瘤用药
	public static final String BKA246_BKA246_32 = "32";
	// BKA247_免疫抑制药
	public static final String BKA247_BKA247_01001 = "01001";
	// BKA247_生物反应调节药
	public static final String BKA247_BKA247_01002 = "01002";
	// BKA247_调节水、电解质及酸碱平衡药物
	public static final String BKA247_BKA247_02001 = "02001";
	// BKA247_平喘药
	public static final String BKA247_BKA247_03001 = "03001";
	// BKA247_祛痰药
	public static final String BKA247_BKA247_03002 = "03002";
	// BKA247_镇咳药
	public static final String BKA247_BKA247_03003 = "03003";
	// BKA247_雌激素、抗雌激素、孕激素及抗孕激素类
	public static final String BKA247_BKA247_04001 = "04001";
	// BKA247_甲状旁腺及钙代谢调节药
	public static final String BKA247_BKA247_04002 = "04002";
	// BKA247_甲状腺激素及抗甲状腺药
	public static final String BKA247_BKA247_04003 = "04003";
	// BKA247_其他激素及调节内分泌功能药
	public static final String BKA247_BKA247_04004 = "04004";
	// BKA247_肾上腺皮质激素类
	public static final String BKA247_BKA247_04005 = "04005";
	// BKA247_下丘脑垂体激素及其类似物
	public static final String BKA247_BKA247_04006 = "04006";
	// BKA247_雄激素、抗雄激素及同化激素类
	public static final String BKA247_BKA247_04007 = "04007";
	// BKA247_胰岛素及其他影响血糖的药物
	public static final String BKA247_BKA247_04008 = "04008";
	// BKA247_其他解毒药
	public static final String BKA247_BKA247_05001 = "05001";
	// BKA247_氰化物中毒解毒药
	public static final String BKA247_BKA247_05002 = "05002";
	// BKA247_有机磷酸酯类解毒药
	public static final String BKA247_BKA247_05003 = "05003";
	// BKA247_重金属、类金属中毒解毒药
	public static final String BKA247_BKA247_05004 = "05004";
	// BKA247_解热镇痛及非甾体抗炎药
	public static final String BKA247_BKA247_06001 = "06001";
	// BKA247_抗痛风药
	public static final String BKA247_BKA247_06002 = "06002";
	// BKA247_H1受体阻断药
	public static final String BKA247_BKA247_07001 = "07001";
	// BKA247_过敏介质阻释药
	public static final String BKA247_BKA247_07002 = "07002";
	// BKA247_抗阿米巴病药及抗滴虫病药
	public static final String BKA247_BKA247_08001 = "08001";
	// BKA247_抗疟药
	public static final String BKA247_BKA247_08002 = "08002";
	// BKA247_抗丝虫病及抗黑热病药
	public static final String BKA247_BKA247_08003 = "08003";
	// BKA247_抗吸虫病药
	public static final String BKA247_BKA247_08004 = "08004";
	// BKA247_驱肠虫药
	public static final String BKA247_BKA247_08005 = "08005";
	// BKA247_合成抗菌药
	public static final String BKA247_BKA247_09001 = "09001";
	// BKA247_抗病毒药
	public static final String BKA247_BKA247_09002 = "09002";
	// BKA247_抗分枝杆菌药
	public static final String BKA247_BKA247_09003 = "09003";
	// BKA247_抗生素类
	public static final String BKA247_BKA247_09004 = "09004";
	// BKA247_抗真菌药
	public static final String BKA247_BKA247_09005 = "09005";
	// BKA247_激素类及抗激素类抗肿瘤药
	public static final String BKA247_BKA247_10001 = "10001";
	// BKA247_其他抗肿瘤药物
	public static final String BKA247_BKA247_10002 = "10002";
	// BKA247_细胞毒药物
	public static final String BKA247_BKA247_10003 = "10003";
	// BKA247_局部麻醉药
	public static final String BKA247_BKA247_11001 = "11001";
	// BKA247_麻醉辅助药
	public static final String BKA247_BKA247_11002 = "11002";
	// BKA247_全身麻醉药
	public static final String BKA247_BKA247_11003 = "11003";
	// BKA247_利尿药
	public static final String BKA247_BKA247_12001 = "12001";
	// BKA247_其他泌尿系统药物
	public static final String BKA247_BKA247_12002 = "12002";
	// BKA247_前列腺疾病用药
	public static final String BKA247_BKA247_12003 = "12003";
	// BKA247_脱水药
	public static final String BKA247_BKA247_12004 = "12004";
	// BKA247_抗癫痫药
	public static final String BKA247_BKA247_13001 = "13001";
	// BKA247_抗帕金森病药
	public static final String BKA247_BKA247_13002 = "13002";
	// BKA247_抗偏头痛药
	public static final String BKA247_BKA247_13003 = "13003";
	// BKA247_抗重症肌无力药
	public static final String BKA247_BKA247_13004 = "13004";
	// BKA247_脑血管病用药
	public static final String BKA247_BKA247_13005 = "13005";
	// BKA247_其他类
	public static final String BKA247_BKA247_13006 = "13006";
	// BKA247_镇静催眠药
	public static final String BKA247_BKA247_13007 = "13007";
	// BKA247_中枢兴奋药
	public static final String BKA247_BKA247_13008 = "13008";
	// BKA247_生物制品
	public static final String BKA247_BKA247_14001 = "14001";
	// BKA247_矿物质类
	public static final String BKA247_BKA247_15001 = "15001";
	// BKA247_维生素类
	public static final String BKA247_BKA247_15002 = "15002";
	// BKA247_肝病辅助治疗药
	public static final String BKA247_BKA247_16001 = "16001";
	// BKA247_肛肠科用药
	public static final String BKA247_BKA247_16002 = "16002";
	// BKA247_抗酸药及抗溃疡病药
	public static final String BKA247_BKA247_16003 = "16003";
	// BKA247_利胆药
	public static final String BKA247_BKA247_16004 = "16004";
	// BKA247_其他消化系统药物
	public static final String BKA247_BKA247_16005 = "16005";
	// BKA247_胃肠解痉及胃动力药
	public static final String BKA247_BKA247_16006 = "16006";
	// BKA247_泻药、止泻药
	public static final String BKA247_BKA247_16007 = "16007";
	// BKA247_助消化药
	public static final String BKA247_BKA247_16008 = "16008";
	// BKA247_抗凝血药及溶拴药
	public static final String BKA247_BKA247_17001 = "17001";
	// BKA247_抗贫血药
	public static final String BKA247_BKA247_17002 = "17002";
	// BKA247_抗血小板药
	public static final String BKA247_BKA247_17003 = "17003";
	// BKA247_升白细胞药
	public static final String BKA247_BKA247_17004 = "17004";
	// BKA247_血浆及血容量扩充药
	public static final String BKA247_BKA247_17005 = "17005";
	// BKA247_止血药
	public static final String BKA247_BKA247_17006 = "17006";
	// BKA247_β受体阻滞药
	public static final String BKA247_BKA247_18001 = "18001";
	// BKA247_调血脂药
	public static final String BKA247_BKA247_18002 = "18002";
	// BKA247_钙拮抗药
	public static final String BKA247_BKA247_18003 = "18003";
	// BKA247_抗心律失常药
	public static final String BKA247_BKA247_18004 = "18004";
	// BKA247_抗休克血管活性药及改善心脑循环药
	public static final String BKA247_BKA247_18005 = "18005";
	// BKA247_利尿降压药
	public static final String BKA247_BKA247_18006 = "18006";
	// BKA247_其他血管舒张药
	public static final String BKA247_BKA247_18007 = "18007";
	// BKA247_其他药物
	public static final String BKA247_BKA247_18008 = "18008";
	// BKA247_强心药
	public static final String BKA247_BKA247_18009 = "18009";
	// BKA247_血管紧张素II受体拮抗药
	public static final String BKA247_BKA247_18010 = "18010";
	// BKA247_血管紧张素转换酶抑制药
	public static final String BKA247_BKA247_18011 = "18011";
	// BKA247_作用于a受体的药物
	public static final String BKA247_BKA247_18012 = "18012";
	// BKA247_肠内营养药
	public static final String BKA247_BKA247_19001 = "19001";
	// BKA247_肠外营养药
	public static final String BKA247_BKA247_19002 = "19002";
	// BKA247_其他诊断用药物
	public static final String BKA247_BKA247_20001 = "20001";
	// BKA247_造影剂
	public static final String BKA247_BKA247_20002 = "20002";
	// BKA247_镇痛药
	public static final String BKA247_BKA247_21001 = "21001";
	// BKA247_抗焦虑药
	public static final String BKA247_BKA247_22001 = "22001";
	// BKA247_抗精神病药
	public static final String BKA247_BKA247_22002 = "22002";
	// BKA247_抗抑郁药
	public static final String BKA247_BKA247_22003 = "22003";
	// BKA247_抗躁狂药
	public static final String BKA247_BKA247_22004 = "22004";
	// BKA247_耳鼻喉科用药
	public static final String BKA247_BKA247_23001 = "23001";
	// BKA247_放射性同位素药
	public static final String BKA247_BKA247_23002 = "23002";
	// BKA247_妇产科用药
	public static final String BKA247_BKA247_23003 = "23003";
	// BKA247_口腔科用药
	public static final String BKA247_BKA247_23004 = "23004";
	// BKA247_皮肤科外用药
	public static final String BKA247_BKA247_23005 = "23005";
	// BKA247_眼科用药
	public static final String BKA247_BKA247_23006 = "23006";
	// BKA247_鼻病
	public static final String BKA247_BKA247_24001 = "24001";
	// BKA247_耳病
	public static final String BKA247_BKA247_24002 = "24002";
	// BKA247_牙病
	public static final String BKA247_BKA247_24003 = "24003";
	// BKA247_咽喉病
	public static final String BKA247_BKA247_24004 = "24004";
	// BKA247_妇科用扶正剂
	public static final String BKA247_BKA247_25001 = "25001";
	// BKA247_妇科用理血剂
	public static final String BKA247_BKA247_25002 = "25002";
	// BKA247_妇科用清热剂
	public static final String BKA247_BKA247_25003 = "25003";
	// BKA247_妇科用药消肿散结
	public static final String BKA247_BKA247_25004 = "25004";
	// BKA247_补肾壮骨剂
	public static final String BKA247_BKA247_26001 = "26001";
	// BKA247_骨伤科用活血化瘀剂
	public static final String BKA247_BKA247_26002 = "26002";
	// BKA247_骨伤科用活血通络剂
	public static final String BKA247_BKA247_26003 = "26003";
	// BKA247_民族药
	public static final String BKA247_BKA247_27001 = "27001";
	// BKA247_安神剂
	public static final String BKA247_BKA247_28001 = "28001";
	// BKA247_扶正剂
	public static final String BKA247_BKA247_28002 = "28002";
	// BKA247_固涩剂
	public static final String BKA247_BKA247_28003 = "28003";
	// BKA247_化痰、止咳、平喘剂
	public static final String BKA247_BKA247_28004 = "28004";
	// BKA247_化浊降脂
	public static final String BKA247_BKA247_28005 = "28005";
	// BKA247_解表剂
	public static final String BKA247_BKA247_28006 = "28006";
	// BKA247_开窍剂
	public static final String BKA247_BKA247_28007 = "28007";
	// BKA247_理气剂
	public static final String BKA247_BKA247_28008 = "28008";
	// BKA247_清热剂
	public static final String BKA247_BKA247_28009 = "28009";
	// BKA247_祛湿剂
	public static final String BKA247_BKA247_28010 = "28010";
	// BKA247_祛瘀剂
	public static final String BKA247_BKA247_28011 = "28011";
	// BKA247_温里剂
	public static final String BKA247_BKA247_28012 = "28012";
	// BKA247_消导剂
	public static final String BKA247_BKA247_28013 = "28013";
	// BKA247_泻下剂
	public static final String BKA247_BKA247_28014 = "28014";
	// BKA247_止血剂
	public static final String BKA247_BKA247_28015 = "28015";
	// BKA247_治风剂
	public static final String BKA247_BKA247_28016 = "28016";
	// BKA247_皮肤科用药
	public static final String BKA247_BKA247_29001 = "29001";
	// BKA247_清热剂
	public static final String BKA247_BKA247_30001 = "30001";
	// BKA247_外科用清热剂
	public static final String BKA247_BKA247_30002 = "30002";
	// BKA247_外科用温经理气活血剂
	public static final String BKA247_BKA247_30003 = "30003";
	// BKA247_眼科用扶正剂
	public static final String BKA247_BKA247_31001 = "31001";
	// BKA247_眼科用清热剂
	public static final String BKA247_BKA247_31002 = "31002";
	// BKA247_抗肿瘤药
	public static final String BKA247_BKA247_32001 = "32001";
	// BKA247_肿瘤辅助用药
	public static final String BKA247_BKA247_32002 = "32002";
	// BKA248_药店购药结算
	public static final String BKA248_BKA248_01 = "01";
	// BKA248_门诊特殊慢性病购药
	public static final String BKA248_BKA248_02 = "02";
	// BKA248_门诊特殊治疗购药
	public static final String BKA248_BKA248_03 = "03";
	// BKA248_门诊普通
	public static final String BKA248_BKA248_06 = "06";
	// BKA248_门诊特殊慢性病就医
	public static final String BKA248_BKA248_07 = "07";
	// BKA248_住院就医
	public static final String BKA248_BKA248_08 = "08";
	// BKA248_医疗照顾人员绿色通道
	public static final String BKA248_BKA248_09 = "09";
	// BKA248_慢性肾功能衰竭病人腹膜透析
	public static final String BKA248_BKA248_10 = "10";
	// BKA248_血液透析
	public static final String BKA248_BKA248_11 = "11";
	// BKA248_肾移植术后服用抗排斥药
	public static final String BKA248_BKA248_12 = "12";
	// BKA248_恶性肿瘤门诊放、化疗
	public static final String BKA248_BKA248_13 = "13";
	// BKA248_CT和SPECT（单光子发射电子计算机扫描装置?
	public static final String BKA248_BKA248_14 = "14";
	// BKA248_核磁共振
	public static final String BKA248_BKA248_15 = "15";
	// BKA248_心脏彩色B超
	public static final String BKA248_BKA248_16 = "16";
	// BKA248_颈颅彩色多普勒血管检查(TCD)
	public static final String BKA248_BKA248_17 = "17";
	// BKA248_胃、十二指肠镜检查
	public static final String BKA248_BKA248_18 = "18";
	// BKA248_结肠镜检查
	public static final String BKA248_BKA248_19 = "19";
	// BKA248_动态心电图
	public static final String BKA248_BKA248_20 = "20";
	// BKA248_高压氧舱治疗
	public static final String BKA248_BKA248_21 = "21";
	// BKA248_核素扫描
	public static final String BKA248_BKA248_22 = "22";
	// BKA248_支气管镜检查
	public static final String BKA248_BKA248_23 = "23";
	// BKA248_体外振波碎石治疗泌尿系统、肠道结石
	public static final String BKA248_BKA248_24 = "24";
	// BKA248_体外射频治疗重度前列腺肥大
	public static final String BKA248_BKA248_25 = "25";
	// BKA248_家庭病床
	public static final String BKA248_BKA248_26 = "26";
	// BKA248_转外就医
	public static final String BKA248_BKA248_27 = "27";
	// BKA248_大额慢性病门诊
	public static final String BKA248_BKA248_28 = "28";
	// BKA248_46开住院结算
	public static final String BKA248_BKA248_29 = "29";
	// BKA248_高新技术治疗项目
	public static final String BKA248_BKA248_30 = "30";
	// BKA248_精神疾病住院
	public static final String BKA248_BKA248_31 = "31";
	// BKA248_结核病住院
	public static final String BKA248_BKA248_32 = "32";
	// BKA248_单病种
	public static final String BKA248_BKA248_33 = "33";
	// BKA248_特殊材料
	public static final String BKA248_BKA248_34 = "34";
	// BKA248_门诊急救
	public static final String BKA248_BKA248_35 = "35";
	// BKA248_门诊统筹结算
	public static final String BKA248_BKA248_36 = "36";
	// BKA248_全口义齿
	public static final String BKA248_BKA248_37 = "37";
	// BKA248_终末期肾病器官移植
	public static final String BKA248_BKA248_38 = "38";
	// BKA248_艾滋病机会性感染
	public static final String BKA248_BKA248_39 = "39";

	// 工伤住院
	public static final String BKA248_BKA248_40 = "40";
	// 工伤门诊
	public static final String BKA248_BKA248_41 = "41";
	// 门诊特检特治
	public static final String BKA248_BKA248_50 = "50";
	// BKA260_免疫抑制药
	public static final String BKA260_BKA260_010010001 = "010010001";
	// BKA260_生物反应调节药
	public static final String BKA260_BKA260_010020001 = "010020001";
	// BKA260_调节水、电解质及酸碱平衡药物
	public static final String BKA260_BKA260_020010001 = "020010001";
	// BKA260_平喘药
	public static final String BKA260_BKA260_030010001 = "030010001";
	// BKA260_祛痰药
	public static final String BKA260_BKA260_030020001 = "030020001";
	// BKA260_镇咳药
	public static final String BKA260_BKA260_030030001 = "030030001";
	// BKA260_雌激素及抗雌激素类
	public static final String BKA260_BKA260_040010001 = "040010001";
	// BKA260_孕激素及抗孕激素类
	public static final String BKA260_BKA260_040010002 = "040010002";
	// BKA260_甲状旁腺及钙代谢调节药
	public static final String BKA260_BKA260_040020001 = "040020001";
	// BKA260_甲状腺激素类
	public static final String BKA260_BKA260_040030001 = "040030001";
	// BKA260_抗甲状腺药
	public static final String BKA260_BKA260_040030002 = "040030002";
	// BKA260_其他激素及调节内分泌功能药
	public static final String BKA260_BKA260_040040001 = "040040001";
	// BKA260_肾上腺皮质激素类
	public static final String BKA260_BKA260_040050001 = "040050001";
	// BKA260_下丘脑垂体激素及其类似物
	public static final String BKA260_BKA260_040060001 = "040060001";
	// BKA260_雄激素、抗雄激素及同化激素类
	public static final String BKA260_BKA260_040070001 = "040070001";
	// BKA260_口服降糖药
	public static final String BKA260_BKA260_040080001 = "040080001";
	// BKA260_胰岛素
	public static final String BKA260_BKA260_040080002 = "040080002";
	// BKA260_其他解毒药
	public static final String BKA260_BKA260_050010001 = "050010001";
	// BKA260_氰化物中毒解毒药
	public static final String BKA260_BKA260_050020001 = "050020001";
	// BKA260_有机磷酸酯类解毒药
	public static final String BKA260_BKA260_050030001 = "050030001";
	// BKA260_重金属、类金属中毒解毒药
	public static final String BKA260_BKA260_050040001 = "050040001";
	// BKA260_解热镇痛及非甾体抗炎药
	public static final String BKA260_BKA260_060010001 = "060010001";
	// BKA260_抗痛风药
	public static final String BKA260_BKA260_060020001 = "060020001";
	// BKA260_H1受体阻断药
	public static final String BKA260_BKA260_070010001 = "070010001";
	// BKA260_过敏介质阻释药
	public static final String BKA260_BKA260_070020001 = "070020001";
	// BKA260_抗阿米巴病药及抗滴虫病药
	public static final String BKA260_BKA260_080010001 = "080010001";
	// BKA260_抗疟药
	public static final String BKA260_BKA260_080020001 = "080020001";
	// BKA260_抗丝虫病及抗黑热病药
	public static final String BKA260_BKA260_080030001 = "080030001";
	// BKA260_抗吸虫病药
	public static final String BKA260_BKA260_080040001 = "080040001";
	// BKA260_驱肠虫药
	public static final String BKA260_BKA260_080050001 = "080050001";
	// BKA260_磺胺类
	public static final String BKA260_BKA260_090010001 = "090010001";
	// BKA260_喹诺酮类
	public static final String BKA260_BKA260_090010002 = "090010002";
	// BKA260_硝基呋喃类
	public static final String BKA260_BKA260_090010003 = "090010003";
	// BKA260_硝基咪唑类
	public static final String BKA260_BKA260_090010004 = "090010004";
	// BKA260_蛋白酶抑制剂
	public static final String BKA260_BKA260_090020001 = "090020001";
	// BKA260_非核苷类逆转录酶抑制剂
	public static final String BKA260_BKA260_090020002 = "090020002";
	// BKA260_广谱类
	public static final String BKA260_BKA260_090020003 = "090020003";
	// BKA260_核苷类逆转录酶抑制剂
	public static final String BKA260_BKA260_090020004 = "090020004";
	// BKA260_其他抗病毒药
	public static final String BKA260_BKA260_090020005 = "090020005";
	// BKA260_抗结核病类
	public static final String BKA260_BKA260_090030001 = "090030001";
	// BKA260_抗麻风病类
	public static final String BKA260_BKA260_090030002 = "090030002";
	// BKA260_氨基糖苷类
	public static final String BKA260_BKA260_090040001 = "090040001";
	// BKA260_大环内酯类
	public static final String BKA260_BKA260_090040002 = "090040002";
	// BKA260_林可酰胺类
	public static final String BKA260_BKA260_090040003 = "090040003";
	// BKA260_其他抗生素类
	public static final String BKA260_BKA260_090040004 = "090040004";
	// BKA260_青霉素类
	public static final String BKA260_BKA260_090040005 = "090040005";
	// BKA260_四环素类
	public static final String BKA260_BKA260_090040006 = "090040006";
	// BKA260_碳青霉烯类
	public static final String BKA260_BKA260_090040007 = "090040007";
	// BKA260_糖肽类
	public static final String BKA260_BKA260_090040008 = "090040008";
	// BKA260_头孢菌素
	public static final String BKA260_BKA260_090040009 = "090040009";
	// BKA260_酰胺醇类
	public static final String BKA260_BKA260_090040010 = "090040010";
	// BKA260_吡咯类
	public static final String BKA260_BKA260_090050001 = "090050001";
	// BKA260_丙烯胺类
	public static final String BKA260_BKA260_090050002 = "090050002";
	// BKA260_多烯类
	public static final String BKA260_BKA260_090050003 = "090050003";
	// BKA260_其他抗真菌药
	public static final String BKA260_BKA260_090050004 = "090050004";
	// BKA260_三唑类
	public static final String BKA260_BKA260_090050005 = "090050005";
	// BKA260_激素类及抗激素类抗肿瘤药
	public static final String BKA260_BKA260_100010001 = "100010001";
	// BKA260_其他抗肿瘤药物
	public static final String BKA260_BKA260_100020001 = "100020001";
	// BKA260_其他细胞毒药物
	public static final String BKA260_BKA260_100030001 = "100030001";
	// BKA260_影响核酸合成的药物
	public static final String BKA260_BKA260_100030002 = "100030002";
	// BKA260_作用于DNA复制的拓扑异构酶Ⅰ抑制剂
	public static final String BKA260_BKA260_100030003 = "100030003";
	// BKA260_作用于DNA化学结构的药物
	public static final String BKA260_BKA260_100030004 = "100030004";
	// BKA260_作用于核酸转录的药物
	public static final String BKA260_BKA260_100030005 = "100030005";
	// BKA260_作用于微管蛋白合成的药物
	public static final String BKA260_BKA260_100030006 = "100030006";
	// BKA260_局部麻醉药
	public static final String BKA260_BKA260_110010001 = "110010001";
	// BKA260_肌肉松弛药
	public static final String BKA260_BKA260_110020001 = "110020001";
	// BKA260_其他麻醉辅助药
	public static final String BKA260_BKA260_110020002 = "110020002";
	// BKA260_静脉麻醉药
	public static final String BKA260_BKA260_110030001 = "110030001";
	// BKA260_吸入麻醉药
	public static final String BKA260_BKA260_110030002 = "110030002";
	// BKA260_利尿药
	public static final String BKA260_BKA260_120010001 = "120010001";
	// BKA260_其他泌尿系统药物
	public static final String BKA260_BKA260_120020001 = "120020001";
	// BKA260_前列腺疾病用药
	public static final String BKA260_BKA260_120030001 = "120030001";
	// BKA260_脱水药
	public static final String BKA260_BKA260_120040001 = "120040001";
	// BKA260_抗癫痫药
	public static final String BKA260_BKA260_130010001 = "130010001";
	// BKA260_抗帕金森病药
	public static final String BKA260_BKA260_130020001 = "130020001";
	// BKA260_抗偏头痛药
	public static final String BKA260_BKA260_130030001 = "130030001";
	// BKA260_抗重症肌无力药
	public static final String BKA260_BKA260_130040001 = "130040001";
	// BKA260_脑血管病用药
	public static final String BKA260_BKA260_130050001 = "130050001";
	// BKA260_其他类
	public static final String BKA260_BKA260_130060001 = "130060001";
	// BKA260_镇静催眠药
	public static final String BKA260_BKA260_130070001 = "130070001";
	// BKA260_中枢兴奋药
	public static final String BKA260_BKA260_130080001 = "130080001";
	// BKA260_生物制品
	public static final String BKA260_BKA260_140010001 = "140010001";
	// BKA260_矿物质类
	public static final String BKA260_BKA260_150010001 = "150010001";
	// BKA260_维生素类
	public static final String BKA260_BKA260_150020001 = "150020001";
	// BKA260_肝病辅助治疗药
	public static final String BKA260_BKA260_160010001 = "160010001";
	// BKA260_肛肠科用药
	public static final String BKA260_BKA260_160020001 = "160020001";
	// BKA260_抗酸药及胃粘膜保护药
	public static final String BKA260_BKA260_160030001 = "160030001";
	// BKA260_抑酸药
	public static final String BKA260_BKA260_160030002 = "160030002";
	// BKA260_利胆药
	public static final String BKA260_BKA260_160040001 = "160040001";
	// BKA260_其他消化系统药物
	public static final String BKA260_BKA260_160050001 = "160050001";
	// BKA260_催吐药
	public static final String BKA260_BKA260_160060001 = "160060001";
	// BKA260_胃肠解痉药
	public static final String BKA260_BKA260_160060002 = "160060002";
	// BKA260_胃动力药和止吐药
	public static final String BKA260_BKA260_160060003 = "160060003";
	// BKA260_泻药
	public static final String BKA260_BKA260_160070001 = "160070001";
	// BKA260_止泻药
	public static final String BKA260_BKA260_160070002 = "160070002";
	// BKA260_助消化药
	public static final String BKA260_BKA260_160080001 = "160080001";
	// BKA260_抗凝血药
	public static final String BKA260_BKA260_170010001 = "170010001";
	// BKA260_溶拴药
	public static final String BKA260_BKA260_170010002 = "170010002";
	// BKA260_其他抗贫血药
	public static final String BKA260_BKA260_170020001 = "170020001";
	// BKA260_铁剂
	public static final String BKA260_BKA260_170020002 = "170020002";
	// BKA260_抗血小板药
	public static final String BKA260_BKA260_170030001 = "170030001";
	// BKA260_升白细胞药
	public static final String BKA260_BKA260_170040001 = "170040001";
	// BKA260_血浆及血容量扩充药
	public static final String BKA260_BKA260_170050001 = "170050001";
	// BKA260_止血药
	public static final String BKA260_BKA260_170060001 = "170060001";
	// BKA260_β受体阻滞药
	public static final String BKA260_BKA260_180010001 = "180010001";
	// BKA260_调血脂药
	public static final String BKA260_BKA260_180020001 = "180020001";
	// BKA260_钙拮抗药
	public static final String BKA260_BKA260_180030001 = "180030001";
	// BKA260_抗心律失常药
	public static final String BKA260_BKA260_180040001 = "180040001";
	// BKA260_抗休克血管活性药及改善心脑循环药
	public static final String BKA260_BKA260_180050001 = "180050001";
	// BKA260_利尿降压药
	public static final String BKA260_BKA260_180060001 = "180060001";
	// BKA260_其他血管舒张药
	public static final String BKA260_BKA260_180070001 = "180070001";
	// BKA260_其他药物
	public static final String BKA260_BKA260_180080001 = "180080001";
	// BKA260_其他强心药
	public static final String BKA260_BKA260_180090001 = "180090001";
	// BKA260_洋地黄类
	public static final String BKA260_BKA260_180090002 = "180090002";
	// BKA260_血管紧张素II受体拮抗药
	public static final String BKA260_BKA260_180100001 = "180100001";
	// BKA260_血管紧张素转换酶抑制药
	public static final String BKA260_BKA260_180110001 = "180110001";
	// BKA260_作用于a受体的药物
	public static final String BKA260_BKA260_180120001 = "180120001";
	// BKA260_肠内营养药
	public static final String BKA260_BKA260_190010001 = "190010001";
	// BKA260_氨基酸类
	public static final String BKA260_BKA260_190020001 = "190020001";
	// BKA260_脂肪乳剂
	public static final String BKA260_BKA260_190020002 = "190020002";
	// BKA260_其他诊断用药物
	public static final String BKA260_BKA260_200010001 = "200010001";
	// BKA260_胆道造影剂
	public static final String BKA260_BKA260_200020001 = "200020001";
	// BKA260_非离子型造影剂
	public static final String BKA260_BKA260_200020002 = "200020002";
	// BKA260_离子型造影剂
	public static final String BKA260_BKA260_200020003 = "200020003";
	// BKA260_特殊造影剂
	public static final String BKA260_BKA260_200020004 = "200020004";
	// BKA260_一般造影剂
	public static final String BKA260_BKA260_200020005 = "200020005";
	// BKA260_镇痛药
	public static final String BKA260_BKA260_210010001 = "210010001";
	// BKA260_抗焦虑药
	public static final String BKA260_BKA260_220010001 = "220010001";
	// BKA260_抗精神病药
	public static final String BKA260_BKA260_220020001 = "220020001";
	// BKA260_抗抑郁药
	public static final String BKA260_BKA260_220030001 = "220030001";
	// BKA260_抗躁狂药
	public static final String BKA260_BKA260_220040001 = "220040001";
	// BKA260_耳鼻喉科用药
	public static final String BKA260_BKA260_230010001 = "230010001";
	// BKA260_放射性同位素药
	public static final String BKA260_BKA260_230020001 = "230020001";
	// BKA260_局部抗感染药
	public static final String BKA260_BKA260_230030001 = "230030001";
	// BKA260_其他妇产科用药
	public static final String BKA260_BKA260_230030002 = "230030002";
	// BKA260_子宫收缩药
	public static final String BKA260_BKA260_230030003 = "230030003";
	// BKA260_口腔科用药
	public static final String BKA260_BKA260_230040001 = "230040001";
	// BKA260_角质促成剂及溶解药
	public static final String BKA260_BKA260_230050001 = "230050001";
	// BKA260_抗感染药
	public static final String BKA260_BKA260_230050002 = "230050002";
	// BKA260_其他皮肤科外用药
	public static final String BKA260_BKA260_230050003 = "230050003";
	// BKA260_肾上腺皮质激素类药物
	public static final String BKA260_BKA260_230050004 = "230050004";
	// BKA260_抗感染药
	public static final String BKA260_BKA260_230060001 = "230060001";
	// BKA260_抗青光眼药
	public static final String BKA260_BKA260_230060002 = "230060002";
	// BKA260_其他眼科用药
	public static final String BKA260_BKA260_230060003 = "230060003";
	// BKA260_肾上腺皮质激素类药物
	public static final String BKA260_BKA260_230060004 = "230060004";
	// BKA260_鼻病
	public static final String BKA260_BKA260_240010001 = "240010001";
	// BKA260_耳病
	public static final String BKA260_BKA260_240020001 = "240020001";
	// BKA260_牙病
	public static final String BKA260_BKA260_240030001 = "240030001";
	// BKA260_咽喉病
	public static final String BKA260_BKA260_240040001 = "240040001";
	// BKA260_妇科用扶正剂
	public static final String BKA260_BKA260_250010001 = "250010001";
	// BKA260_活血化瘀剂
	public static final String BKA260_BKA260_250020001 = "250020001";
	// BKA260_理气养血剂
	public static final String BKA260_BKA260_250020002 = "250020002";
	// BKA260_止血剂
	public static final String BKA260_BKA260_250020003 = "250020003";
	// BKA260_内服清热剂
	public static final String BKA260_BKA260_250030001 = "250030001";
	// BKA260_外用清热剂
	public static final String BKA260_BKA260_250030002 = "250030002";
	// BKA260_妇科用药消肿散结
	public static final String BKA260_BKA260_250040001 = "250040001";
	// BKA260_补肾壮骨剂
	public static final String BKA260_BKA260_260010001 = "260010001";
	// BKA260_内服骨伤科用活血化瘀剂
	public static final String BKA260_BKA260_260020001 = "260020001";
	// BKA260_外用骨伤科用活血化瘀剂
	public static final String BKA260_BKA260_260020002 = "260020002";
	// BKA260_内服骨伤科用活血通络剂
	public static final String BKA260_BKA260_260030001 = "260030001";
	// BKA260_外用骨伤科用活血通络剂
	public static final String BKA260_BKA260_260030002 = "260030002";
	// BKA260_民族药
	public static final String BKA260_BKA260_270010001 = "270010001";
	// BKA260_补肾安神
	public static final String BKA260_BKA260_280010001 = "280010001";
	// BKA260_清肝安神
	public static final String BKA260_BKA260_280010002 = "280010002";
	// BKA260_养心安神
	public static final String BKA260_BKA260_280010003 = "280010003";
	// BKA260_益气养血安神
	public static final String BKA260_BKA260_280010004 = "280010004";
	// BKA260_重镇安神
	public static final String BKA260_BKA260_280010005 = "280010005";
	// BKA260_补气剂
	public static final String BKA260_BKA260_280020001 = "280020001";
	// BKA260_气血双补
	public static final String BKA260_BKA260_280020002 = "280020002";
	// BKA260_温阳剂
	public static final String BKA260_BKA260_280020003 = "280020003";
	// BKA260_养血剂
	public static final String BKA260_BKA260_280020004 = "280020004";
	// BKA260_益气养阴
	public static final String BKA260_BKA260_280020005 = "280020005";
	// BKA260_阴阳双补
	public static final String BKA260_BKA260_280020006 = "280020006";
	// BKA260_滋阴剂
	public static final String BKA260_BKA260_280020007 = "280020007";
	// BKA260_固精止遗
	public static final String BKA260_BKA260_280030001 = "280030001";
	// BKA260_固涩止泻
	public static final String BKA260_BKA260_280030002 = "280030002";
	// BKA260_理肺止咳剂
	public static final String BKA260_BKA260_280040001 = "280040001";
	// BKA260_平喘剂
	public static final String BKA260_BKA260_280040002 = "280040002";
	// BKA260_清热化痰剂
	public static final String BKA260_BKA260_280040003 = "280040003";
	// BKA260_润肺化痰剂
	public static final String BKA260_BKA260_280040004 = "280040004";
	// BKA260_温化寒痰剂
	public static final String BKA260_BKA260_280040005 = "280040005";
	// BKA260_化浊降脂
	public static final String BKA260_BKA260_280050001 = "280050001";
	// BKA260_表里双解剂
	public static final String BKA260_BKA260_280060001 = "280060001";
	// BKA260_扶正解表
	public static final String BKA260_BKA260_280060002 = "280060002";
	// BKA260_辛凉解表剂
	public static final String BKA260_BKA260_280060003 = "280060003";
	// BKA260_辛温解表剂
	public static final String BKA260_BKA260_280060004 = "280060004";
	// BKA260_芳香、化痰开窍剂
	public static final String BKA260_BKA260_280070001 = "280070001";
	// BKA260_清热开窍剂
	public static final String BKA260_BKA260_280070002 = "280070002";
	// BKA260_疏肝和胃剂
	public static final String BKA260_BKA260_280080001 = "280080001";
	// BKA260_疏肝解郁剂
	public static final String BKA260_BKA260_280080002 = "280080002";
	// BKA260_清利肝胆剂
	public static final String BKA260_BKA260_280090001 = "280090001";
	// BKA260_清热解毒剂
	public static final String BKA260_BKA260_280090002 = "280090002";
	// BKA260_清热祛暑剂
	public static final String BKA260_BKA260_280090003 = "280090003";
	// BKA260_清热泻火剂
	public static final String BKA260_BKA260_280090004 = "280090004";
	// BKA260_清脏腑热剂
	public static final String BKA260_BKA260_280090005 = "280090005";
	// BKA260_扶正祛湿
	public static final String BKA260_BKA260_280100001 = "280100001";
	// BKA260_化瘀祛湿
	public static final String BKA260_BKA260_280100002 = "280100002";
	// BKA260_化瘀通淋
	public static final String BKA260_BKA260_280100003 = "280100003";
	// BKA260_清热除湿
	public static final String BKA260_BKA260_280100004 = "280100004";
	// BKA260_清热通淋
	public static final String BKA260_BKA260_280100005 = "280100005";
	// BKA260_祛风除湿
	public static final String BKA260_BKA260_280100006 = "280100006";
	// BKA260_散寒除湿
	public static final String BKA260_BKA260_280100007 = "280100007";
	// BKA260_消肿利水
	public static final String BKA260_BKA260_280100008 = "280100008";
	// BKA260_补肾活血
	public static final String BKA260_BKA260_280110001 = "280110001";
	// BKA260_化瘀宽胸
	public static final String BKA260_BKA260_280110002 = "280110002";
	// BKA260_化瘀通脉
	public static final String BKA260_BKA260_280110003 = "280110003";
	// BKA260_活血消癥
	public static final String BKA260_BKA260_280110004 = "280110004";
	// BKA260_祛瘀化痰
	public static final String BKA260_BKA260_280110005 = "280110005";
	// BKA260_温阳活血
	public static final String BKA260_BKA260_280110006 = "280110006";
	// BKA260_养血活血
	public static final String BKA260_BKA260_280110007 = "280110007";
	// BKA260_益气活血
	public static final String BKA260_BKA260_280110008 = "280110008";
	// BKA260_滋阴活血
	public static final String BKA260_BKA260_280110009 = "280110009";
	// BKA260_回阳救逆
	public static final String BKA260_BKA260_280120001 = "280120001";
	// BKA260_温中散寒剂
	public static final String BKA260_BKA260_280120002 = "280120002";
	// BKA260_益气复脉
	public static final String BKA260_BKA260_280120003 = "280120003";
	// BKA260_消导剂
	public static final String BKA260_BKA260_280130001 = "280130001";
	// BKA260_泻下剂
	public static final String BKA260_BKA260_280140001 = "280140001";
	// BKA260_止血剂
	public static final String BKA260_BKA260_280150001 = "280150001";
	// BKA260_化瘀祛风
	public static final String BKA260_BKA260_280160001 = "280160001";
	// BKA260_平肝潜阳
	public static final String BKA260_BKA260_280160002 = "280160002";
	// BKA260_平肝熄风
	public static final String BKA260_BKA260_280160003 = "280160003";
	// BKA260_祛风通络
	public static final String BKA260_BKA260_280160004 = "280160004";
	// BKA260_疏散外风
	public static final String BKA260_BKA260_280160005 = "280160005";
	// BKA260_养血祛风
	public static final String BKA260_BKA260_280160006 = "280160006";
	// BKA260_皮肤科用药
	public static final String BKA260_BKA260_290010001 = "290010001";
	// BKA260_清利肝胆剂
	public static final String BKA260_BKA260_300010001 = "300010001";
	// BKA260_清热解毒剂
	public static final String BKA260_BKA260_300010002 = "300010002";
	// BKA260_清热祛暑剂
	public static final String BKA260_BKA260_300010003 = "300010003";
	// BKA260_清热泻火剂
	public static final String BKA260_BKA260_300010004 = "300010004";
	// BKA260_清脏腑热剂
	public static final String BKA260_BKA260_300010005 = "300010005";
	// BKA260_外科用清利肝胆剂
	public static final String BKA260_BKA260_300020001 = "300020001";
	// BKA260_外科用清热解毒剂
	public static final String BKA260_BKA260_300020002 = "300020002";
	// BKA260_外科用清热利湿剂
	public static final String BKA260_BKA260_300020003 = "300020003";
	// BKA260_外科用通淋消石剂
	public static final String BKA260_BKA260_300020004 = "300020004";
	// BKA260_外科用温经理气活血剂
	public static final String BKA260_BKA260_300030001 = "300030001";
	// BKA260_眼科用扶正剂
	public static final String BKA260_BKA260_310010001 = "310010001";
	// BKA260_眼科用清热剂
	public static final String BKA260_BKA260_310020001 = "310020001";
	// BKA260_抗肿瘤药
	public static final String BKA260_BKA260_320010001 = "320010001";
	// BKA260_肿瘤辅助用药
	public static final String BKA260_BKA260_320020001 = "320020001";
	// BKA266_未上传
	public static final String BKA266_BKA266_0 = "0";
	// BKA266_未审核
	public static final String BKA266_BKA266_1 = "1";
	// BKA266_审核不通过
	public static final String BKA266_BKA266_2 = "2";
	// BKA266_审核通过
	public static final String BKA266_BKA266_3 = "3";
	// BKA268_是
	public static final String BKA268_BKA268_1 = "1";
	// BKA268_否
	public static final String BKA268_BKA268_2 = "2";
	// BKB021_一级
	public static final String BKB021_BKB021_1 = "1";
	// BKB021_二级
	public static final String BKB021_BKB021_2 = "2";
	// BKB021_三级
	public static final String BKB021_BKB021_3 = "3";
	// BKB021_四级
	public static final String BKB021_BKB021_4 = "4";
	// BKB025_一致
	public static final String BKB025_BKB025_1 = "1";
	// BKB025_不一致
	public static final String BKB025_BKB025_2 = "2";
	// BKB025_未申报
	public static final String BKB025_BKB025_3 = "3";
	// BKB034_无缝接口
	public static final String BKB034_BKB034_1 = "1";
	// BKB034_HIS接口
	public static final String BKB034_BKB034_2 = "2";
	// BKB034_现金报销
	public static final String BKB034_BKB034_3 = "3";
	// BKB034_无HIS接口
	public static final String BKB034_BKB034_4 = "4";
	// BKB035_未注册
	public static final String BKB035_BKB035_1 = "1";
	// BKB035_已注册
	public static final String BKB035_BKB035_2 = "2";
	// BKB056_执行成功
	public static final String BKB056_BKB056_1 = "1";
	// BKB056_执行失败
	public static final String BKB056_BKB056_2 = "2";
	// BKC009_市内转院
	public static final String BKC009_BKC009_1 = "1";
	// BKC009_市外转院
	public static final String BKC009_BKC009_2 = "2";
	// BKC009_异地安置转院
	public static final String BKC009_BKC009_3 = "3";
	// BKC009_转往市外
	public static final String BKC009_BKC009_4 = "4";
	// BKC009_市外转入
	public static final String BKC009_BKC009_5 = "5";
	// BKC009_市外互转
	public static final String BKC009_BKC009_6 = "6";
	// 上转
	public static final String BKC070_KC29_BKC070_KC29_1 = "1";
	// 下转
	public static final String BKC070_KC29_BKC070_KC29_2 = "2";
	// 平转
	public static final String BKC070_KC29_BKC070_KC29_3 = "3";
	// BKC010_脑中风丧失全部或部分行动能力且病情符合住院条件者
	public static final String BKC010_BKC010_1 = "1";
	// BKC010_其他
	public static final String BKC010_BKC010_10 = "10";
	// BKC010_骨折牵引固定需卧床者
	public static final String BKC010_BKC010_2 = "2";
	// BKC010_恶性肿瘤晚期行动困难者
	public static final String BKC010_BKC010_3 = "3";
	// BKC010_严重心肺疾患出现心肺功能衰竭、本人生活不能完全自理者
	public static final String BKC010_BKC010_4 = "4";
	// BKC010_卧床或80岁以上老人患慢性疾病需连续治疗者
	public static final String BKC010_BKC010_5 = "5";
	// BKC011_病情不符
	public static final String BKC011_BKC011_1 = "1";
	// BKC011_其他
	public static final String BKC011_BKC011_10 = "10";
	// BKC011_年龄不符
	public static final String BKC011_BKC011_2 = "2";
	// BKC011_病种不符
	public static final String BKC011_BKC011_3 = "3";
	// BKC013_其他
	public static final String BKC013_BKC013_99 = "99";
	// BKC022_北京市
	public static final String BKC022_BKC022_1 = "01";
	// BKC022_江苏省
	public static final String BKC022_BKC022_10 = "10";
	// BKC022_浙江省
	public static final String BKC022_BKC022_11 = "11";
	// BKC022_安徽省
	public static final String BKC022_BKC022_12 = "12";
	// BKC022_福建省
	public static final String BKC022_BKC022_13 = "13";
	// BKC022_江西省
	public static final String BKC022_BKC022_14 = "14";
	// BKC022_山东省
	public static final String BKC022_BKC022_15 = "15";
	// BKC022_河南省
	public static final String BKC022_BKC022_16 = "16";
	// BKC022_湖北省
	public static final String BKC022_BKC022_17 = "17";
	// BKC022_湖南省
	public static final String BKC022_BKC022_18 = "18";
	// BKC022_广东省
	public static final String BKC022_BKC022_19 = "19";
	// BKC022_天津市
	public static final String BKC022_BKC022_2 = "02";
	// BKC022_广西壮族自治区
	public static final String BKC022_BKC022_20 = "20";
	// BKC022_海南省
	public static final String BKC022_BKC022_21 = "21";
	// BKC022_重庆市
	public static final String BKC022_BKC022_22 = "22";
	// BKC022_四川省
	public static final String BKC022_BKC022_23 = "23";
	// BKC022_贵州省
	public static final String BKC022_BKC022_24 = "24";
	// BKC022_云南省
	public static final String BKC022_BKC022_25 = "25";
	// BKC022_西藏自治区
	public static final String BKC022_BKC022_26 = "26";
	// BKC022_陕西省
	public static final String BKC022_BKC022_27 = "27";
	// BKC022_甘肃省
	public static final String BKC022_BKC022_28 = "28";
	// BKC022_青海省
	public static final String BKC022_BKC022_29 = "29";
	// BKC022_河北省
	public static final String BKC022_BKC022_3 = "03";
	// BKC022_宁夏回族自治区
	public static final String BKC022_BKC022_30 = "30";
	// BKC022_新疆维吾尔自治区
	public static final String BKC022_BKC022_31 = "31";
	// BKC022_台湾省
	public static final String BKC022_BKC022_32 = "32";
	// BKC022_香港特别行政区
	public static final String BKC022_BKC022_33 = "33";
	// BKC022_澳门特别行政区
	public static final String BKC022_BKC022_34 = "34";
	// BKC022_山西省
	public static final String BKC022_BKC022_4 = "04";
	// BKC022_内蒙古自治区
	public static final String BKC022_BKC022_5 = "05";
	// BKC022_辽宁省
	public static final String BKC022_BKC022_6 = "06";
	// BKC022_吉林省
	public static final String BKC022_BKC022_7 = "07";
	// BKC022_黑龙江省
	public static final String BKC022_BKC022_8 = "08";
	// BKC022_上海市
	public static final String BKC022_BKC022_9 = "09";
	// BKC026_定点医药机构消费
	public static final String BKC026_BKC026_1 = "1";
	// BKC026_现金报销
	public static final String BKC026_BKC026_2 = "2";
	// BKC026_常驻外地人员拨付
	public static final String BKC026_BKC026_3 = "3";
	// BKC026_个人账户结算支付
	public static final String BKC026_BKC026_4 = "4";
	// BKC026_结算撤消
	public static final String BKC026_BKC026_5 = "5";
	// BKC028_未结算
	public static final String BKC028_BKC028_1 = "1";
	// BKC028_已结算
	public static final String BKC028_BKC028_2 = "2";
	// BKC033_定点机构费用审核
	public static final String BKC033_BKC033_0 = "0";
	// BKC033_整笔拒付
	public static final String BKC033_BKC033_1 = "1";
	// BKC033_部分拒付
	public static final String BKC033_BKC033_2 = "2";
	// BKC033_参保人投诉
	public static final String BKC033_BKC033_3 = "3";
	// BKC033_受奖励情况
	public static final String BKC033_BKC033_4 = "4";
	// BKC033_平时抽查
	public static final String BKC033_BKC033_5 = "5";
	// BKC033_年终实地检查
	public static final String BKC033_BKC033_6 = "6";
	// BKC033_其他
	public static final String BKC033_BKC033_7 = "7";
	// BKC036_未结算
	public static final String BKC036_BKC036_1 = "1";
	// BKC036_已结算
	public static final String BKC036_BKC036_2 = "2";

	// BKC074未复核
	public static final String BKC074_BKC074_0 = "0";
	// BKC074已复核
	public static final String BKC074_BKC074_1 = "1";
	// BKC074已审批
	public static final String BKC074_BKC074_3 = "3";

	// BKC070违规扣款医保科审批
	public static final String BKC070_BKC070_1 = "1";
	// BKC070违规扣款稽核科审批
	public static final String BKC070_BKC070_2 = "2";

	// BKC049_未结算
	public static final String BKC049_BKC049_1 = "1";
	// BKC049_已结算
	public static final String BKC049_BKC049_2 = "2";
	// BKC038_冒名顶替
	public static final String BKC038_BKC038_01 = "01";
	// BKC038_其它
	public static final String BKC038_BKC038_10 = "10";
	// BKC041_评分百分比
	public static final String BKC041_BKC041_1 = "1";
	// BKC041_参数百分比
	public static final String BKC041_BKC042_2 = "2";
	// BKC041_扣分返还
	public static final String BKC041_BKC042_3 = "3";

	// BKC042_超剂量
	public static final String BKC042_BKC042_1 = "01";
	// BKC042_超计划
	public static final String BKC042_BKC042_2 = "02";
	// BKC042_超目录
	public static final String BKC042_BKC042_3 = "03";
	// BKC042_超病种
	public static final String BKC042_BKC042_4 = "04";
	// BKC042_超限额
	public static final String BKC042_BKC042_5 = "05";
	// BKC042_其它
	public static final String BKC042_BKC042_6 = "06";
	// BKC043_第一段
	public static final String BKC043_BKC043_1 = "1";
	// BKC043_第二段
	public static final String BKC043_BKC043_2 = "2";
	// BKC043_第三段
	public static final String BKC043_BKC043_3 = "3";
	// BKC044_第一段
	public static final String BKC044_BKC044_1 = "1";
	// BKC044_第二段
	public static final String BKC044_BKC044_2 = "2";
	// BKC044_第三段
	public static final String BKC044_BKC044_3 = "3";
	// BKC054_第一段
	public static final String BKC054_BKC054_1 = "1";
	// BKC054_第二段
	public static final String BKC054_BKC054_2 = "2";
	// BKC055_慢性病审核通过
	public static final String BKC055_BKC055_00 = "00";
	// BKC055_其它
	public static final String BKC055_BBKC055_10 = "10";
	// BKC055_超剂量用药
	public static final String BKC055_BKC055_01 = "01";
	// BKC057_基本医疗保险
	public static final String BKC057_BKC057_0 = "0";
	// BKC057_公务员
	public static final String BKC057_BKC057_1 = "1";
	// BKC057_医疗照顾人员
	public static final String BKC057_BKC057_2 = "2";
	// BKC057_重大疾病补助
	public static final String BKC057_BKC057_3 = "3";
	// BKC058_个人账户
	public static final String BKC058_BKC058_1 = "1";
	// BKC058_统筹金
	public static final String BKC058_BKC058_2 = "2";
	// BKC058_医疗照顾人员补助基金
	public static final String BKC058_BKC058_3 = "3";
	// BKC058_公务员补助基金
	public static final String BKC058_BKC058_4 = "4";
	// BKC058_重大疾病补助基金
	public static final String BKC058_BKC058_5 = "5";
	// BKC060_参保病人基本信息查询
	public static final String BKC060_BKC060_001 = "001";
	// BKC060_参保病人就医资格校验
	public static final String BKC060_BKC060_002 = "002";
	// BKC060_住院登记
	public static final String BKC060_BKC060_121 = "121";
	// BKC060_普通门诊预结算
	public static final String BKC060_BKC060_211 = "211";
	// BKC060_药店购药预结算
	public static final String BKC060_BKC060_214 = "214";
	// BKC060_门诊特殊慢性病预结算
	public static final String BKC060_BKC060_215 = "215";
	// BKC060_门诊特殊治疗预结算
	public static final String BKC060_BKC060_216 = "216";
	// BKC060_门诊特检特治预结算
	public static final String BKC060_BKC060_217 = "217";
	// BKC060_住院预结算
	public static final String BKC060_BKC060_221 = "221";
	// BKC060_普通门诊结算
	public static final String BKC060_BKC060_311 = "311";
	// BKC060_药店购药结算
	public static final String BKC060_BKC060_314 = "314";
	// BKC060_门诊特殊慢性病结算
	public static final String BKC060_BKC060_315 = "315";
	// BKC060_门诊特殊治疗结算
	public static final String BKC060_BKC060_316 = "316";
	// BKC060_门诊特检特治结算
	public static final String BKC060_BKC060_317 = "317";
	// BKC060_住院结算
	public static final String BKC060_BKC060_321 = "321";
	// BKC060_住院登记作废
	public static final String BKC060_BKC060_421 = "421";
	// BKC060_普通门诊结算退费
	public static final String BKC060_BKC060_511 = "511";
	// BKC060_药店购药结算退费
	public static final String BKC060_BKC060_514 = "514";
	// BKC060_门诊特殊慢性病结算退费
	public static final String BKC060_BKC060_515 = "515";
	// BKC060_门诊特殊治疗结算退费
	public static final String BKC060_BKC060_516 = "516";
	// BKC060_门诊特检特治结算退费
	public static final String BKC060_BKC060_517 = "517";
	// BKC060_住院结算退费
	public static final String BKC060_BKC060_521 = "521";
	// BKC060_每日住院费用明细上传
	public static final String BKC060_BKC060_621 = "621";
	// BKC062_等待处理
	public static final String BKC062_BKC062_0 = "0";
	// BKC062_处理成功
	public static final String BKC062_BKC062_1 = "1";
	// BKC062_处理失败
	public static final String BKC062_BKC062_2 = "2";
	// BKC067_等待上传
	public static final String BKC067_BKC067_0 = "0";
	// BKC067_上传成功
	public static final String BKC067_BKC067_1 = "1";
	// BKC067_上传失败
	public static final String BKC067_BKC067_2 = "2";
	// BKC068_预结算
	public static final String BKC068_BKC067_1 = "1";
	// BKC068_结算
	public static final String BKC068_BKC067_2 = "2";
	// BKC083_未审批
	public static final String BKC083_BKC083_1 = "1";
	// BKC083_审批通过
	public static final String BKC083_BKC083_2 = "2";
	// BKC083_整笔拒付
	public static final String BKC083_BKC083_3 = "3";
	// BKC083_费用扣减
	public static final String BKC083_BKC083_4 = "4";
	// BKC090_允许欠款
	public static final String BKC090_BKC090_1 = "1";
	// BKC090_延迟入院
	public static final String BKC090_BKC090_2 = "2";
	// BKC090_允许首诊
	public static final String BKC090_BKC090_3 = "3";
	// BKC272_基本医疗缴费
	public static final String BKC272_BKC272_01 = "01";
	// BKC272_公务员补贴
	public static final String BKC272_BKC272_02 = "02";
	// BKC272_医疗照顾人员医疗补助
	public static final String BKC272_BKC272_03 = "03";
	// BKC272_利息
	public static final String BKC272_BKC272_04 = "04";
	// BKC272_继承
	public static final String BKC272_BKC272_05 = "05";
	// BKC272_转入
	public static final String BKC272_BKC272_06 = "06";
	// BKC272_其它
	public static final String BKC272_BKC272_07 = "07";
	// BKC278_公务员
	public static final String BKC278_BKC278_1 = "1";
	// BKC278_医疗照顾人员
	public static final String BKC278_BKC278_2 = "2";
	// BKC281_是
	public static final String BKC281_BKC281_1 = "1";
	// BKC281_否
	public static final String BKC281_BKC281_2 = "2";

	// BKC120_增加统筹支付比例
	public static final String BKC120_BKC120_01 = "01";
	// BKC120_限定个人支付最高比例
	public static final String BKC120_BKC120_02 = "02";
	// Boolean_否
	public static final String Boolean_Boolean_F = "F";
	// Boolean_是
	public static final String Boolean_Boolean_T = "T";
	// FUNCTIONID_税务征收报盘
	public static final String FUNCTIONID_FUNCTIONID_1 = "001";
	// FUNCTIONID_银行发放报盘
	public static final String FUNCTIONID_FUNCTIONID_2 = "002";
	// FUNCTIONID_本期新增发放人员报盘
	public static final String FUNCTIONID_FUNCTIONID_4 = "004";
	// FUNCTIONID_银行发放无帐号人员报盘
	public static final String FUNCTIONID_FUNCTIONID_5 = "005";
	// PRINTNAME_离退休死亡支付审批表
	public static final String PRINTNAME_PRINTNAME_1 = "deathTable.raq";
	// PRINTNAME_职工离退休审批表
	public static final String PRINTNAME_PRINTNAME_2 = "treatshenpitable.raq";
	// PRINTNAME_个人帐户一次性支付审批表
	public static final String PRINTNAME_PRINTNAME_3 = "terminateInsure.raq";
	// PRINTNAME_迟退人员花名册
	public static final String PRINTNAME_PRINTNAME_4 = "RetireeRegister.raq";
	// PRINTNAME_参加基本养老保险人员转移情况表
	public static final String PRINTNAME_PRINTNAME_5 = "localareamovement.raq";
	// PRINTNAME_社会保险费应收核定单
	public static final String PRINTNAME_PRINTNAME_6 = "CalcContributionInfosDisplay.raq";
	// PRINTNAME_社会保险费应收核定明细单
	public static final String PRINTNAME_PRINTNAME_7 = "CalcContributionInfoCount.raq";
	// TAA102_上传失败
	public static final String TAA102_TAA102_1 = "1";
	// TAA102_已上传
	public static final String TAA102_TAA102_2 = "2";
	// TAA102_正在处理
	public static final String TAA102_TAA102_3 = "3";
	// TAA102_处理完成
	public static final String TAA102_TAA102_4 = "4";
	// TAA102_已下载
	public static final String TAA102_TAA102_5 = "5";
	// TAA103_待审核
	public static final String TAA103_TAA103_0 = "0";
	// TAA103_审核通过
	public static final String TAA103_TAA103_1 = "1";
	// TAA103_审核不通过
	public static final String TAA103_TAA103_2 = "2";
	// SAA043_填写资料
	public static final String SAA043_SAA043_1 = "1";
	// SAA043_提交审核
	public static final String SAA043_SAA043_2 = "2";
	// SAA043_预审
	public static final String SAA043_SAA043_3 = "3";
	// SAA043_受理
	public static final String SAA043_SAA043_4 = "4";
	// SAA043_审核
	public static final String SAA043_SAA043_5 = "5";
	// SAA043_办结
	public static final String SAA043_SAA043_6 = "6";
	// ZHJX801_在职或转移
	public static final String ZHJX801_ZHJX801_1 = "1";
	// ZHJX801_退休或死亡
	public static final String ZHJX801_ZHJX801_2 = "2";
	// ZZI801_基本养老保险
	public static final String ZZI801_ZZI801_1 = "1";
	// ZZK801_重大疾病医疗补助
	public static final String ZZK801_ZZK801_10 = "10";
	// ZZK801_医疗照顾人员医疗补助
	public static final String ZZK801_ZZK801_11 = "11";
	// ZZK801_基本医疗保险
	public static final String ZZK801_ZZK801_3 = "3";
	// ZZK801_公务员医疗补助
	public static final String ZZK801_ZZK801_9 = "9";
	// ZZZ801_在职
	public static final String ZZZ801_ZZZ801_1 = "1";
	// ZZZ801_退休
	public static final String ZZZ801_ZZZ801_2 = "2";
	// ZZZ802_在职
	public static final String ZZZ802_ZZZ802_1 = "1";

	// ZZZ803_单位
	public static final String ZZZ803_ZZZ803_1 = "1";
	// ZZZ803_个人
	public static final String ZZZ803_ZZZ803_2 = "2";
	// ZZZ803_家庭
	public static final String ZZZ803_ZZZ803_3 = "3";
	// ZZZ803_社区
	public static final String ZZZ803_ZZZ803_4 = "4";

	// ZZZ810_是
	public static final String ZZZ810_ZZZ810_1 = "1";
	// ZZZ810_否
	public static final String ZZZ810_ZZZ810_0 = "0";
	// ZZZ811_社平工资
	public static final String ZZZ811_ZZZ811_1 = "1";
	// ZZZ811_缴费基数上限
	public static final String ZZZ811_ZZZ811_2 = "2";
	// ZZZ811_缴费基数下限
	public static final String ZZZ811_ZZZ811_3 = "3";
	// ZZZ811_缴费基数
	public static final String ZZZ811_ZZZ811_4 = "4";

	// BKC291_儿子
	public static final String BKC291_BKC291_11 = "11";
	// BKC291_女儿
	public static final String BKC291_BKC291_12 = "12";
	// BKC291_儿媳
	public static final String BKC291_BKC291_13 = "13";
	// BKC291_女婿
	public static final String BKC291_BKC291_14 = "14";
	// BKC291_父亲
	public static final String BKC291_BKC291_15 = "15";
	// BKC291_母亲
	public static final String BKC291_BKC291_16 = "16";
	// BKC291_公公
	public static final String BKC291_BKC291_17 = "17";
	// BKC291_婆婆
	public static final String BKC291_BKC291_18 = "18";
	// BKC291_岳父
	public static final String BKC291_BKC291_19 = "19";
	// BKC291_岳母
	public static final String BKC291_BKC291_20 = "20";
	// BKC291_祖父
	public static final String BKC291_BKC291_21 = "21";
	// BKC291_祖母
	public static final String BKC291_BKC291_22 = "22";
	// BKC291_外祖父
	public static final String BKC291_BKC291_23 = "23";
	// BKC291_外祖母
	public static final String BKC291_BKC291_24 = "24";
	// BKC291_孙子
	public static final String BKC291_BKC291_25 = "25";
	// BKC291_孙女
	public static final String BKC291_BKC291_26 = "26";
	// BKC291_孙媳婿
	public static final String BKC291_BKC291_27 = "27";
	// BKC291_外孙子女
	public static final String BKC291_BKC291_28 = "28";
	// BKC291_外孙媳婿
	public static final String BKC291_BKC291_29 = "29";
	// BKC291_兄弟姐妹
	public static final String BKC291_BKC291_30 = "30";
	// BKC291_其他亲属
	public static final String BKC291_BKC291_31 = "31";

	// outpatientsettlementsave_西安算法
	public static final String outpatientsettlementsave_6101 = "6101";
	// outpatientsettlementsave_省直算法
	public static final String outpatientsettlementsave_6199 = "6199";
	// BKC114_按技术等级分段计算
	public static final String BKC114_BKC114_01 = "01";
	// BKC114_按总费用分段计算
	public static final String BKC114_BKC114_02 = "02";
	// BKC114_按费用组成分段
	public static final String BKC114_BKC114_03 = "03";

	// BKC115_无限额
	public static final String BKC115_BKC115_1 = "1";
	// BKC115_按分段计算限额
	public static final String BKC115_BKC115_2 = "2";
	// BKC115_按病种计算限额
	public static final String BKC115_BKC115_3 = "3";

	// DYGX_无
	public static final String DYGX_DYGX_0 = "0";
	// DYGX_名称相同
	public static final String DYGX_DYGX_1 = "1";
	// DYGX_名称与剂型相同
	public static final String DYGX_DYGX_2 = "2";
	// DYGX_名称类似
	public static final String DYGX_DYGX_3 = "3";
	// DYGX_名称不同
	public static final String DYGX_DYGX_4 = "4";

	// ALL_YEAR_MONTH_灵活就业人员可退休年龄。 30年*12=360月
	public static final String ALL_YEAR_MONTH = "360";
	// JOB_YEAR_MONTH_灵活就业人员可退休年龄。 15年*12=180月
	public static final String JOB_YEAR_MONTH = "180";

	public static final String TYPE_410002_1 = "1"; // 标准技术等级
	public static final String TYPE_410002_2 = "2"; // 单病种
	public static final String TYPE_410002_3 = "3"; // 特殊材料
	public static final String TYPE_410002_4 = "4"; // 居民标准技术等级
	public static final String TYPE_410002_5 = "5"; // 高新技术治疗
	public static final String TYPE_410002_6 = "6"; // 应用立体定向放射装置
	public static final String TYPE_410002_7 = "7"; // 精神病
	public static final String TYPE_410002_8 = "8"; // 结核病
	public static final String TYPE_410002_9 = "9"; // 普通病
	public static final String TYPE_410002_10 = "10"; // 终未期肾病器官移植
	public static final String TYPE_410002_11 = "11"; // 艾滋病机会性感染
	public static final String TYPE_410002_12 = "12"; // 学生儿童先天性心脏病

	// BAB811_统帐结合
	public static final String BAB811_BAB811_1 = "1";
	// BAB811_单建统筹
	public static final String BAB811_BAB811_2 = "2";

	// BLANCETYPE_1_按比例
	public static final String BLANCETYPE_1 = "1";
	// BLANCETYPE_2_按定额
	public static final String BLANCETYPE_2 = "2";

	/**
	 * 统计类型定义--bigin--
	 */
	// TJLX_求和sum
	public static final String TJLX_TJLX_1 = "1"; // sum
	// TJLX_求平均avg
	public static final String TJLX_TJLX_2 = "2"; // avg
	// TJLX_求最小min
	public static final String TJLX_TJLX_3 = "3"; // min
	// TJLX_求最大max
	public static final String TJLX_TJLX_4 = "4"; // max
	// TJLX_求次数count
	public static final String TJLX_TJLX_5 = "5"; // count

	/**
	 * 是否是聚合字段
	 */
	// 聚合字段
	public static final String ISSUMCOL_ISSUMCOL_1 = "1";
	// 不是聚合字段
	public static final String ISSUMCOL_ISSUMCOL_2 = "2";

	/**
	 * 统计时取值方式
	 */
	// 单值
	public static final String QZFS_QZFS_1 = "1"; // 单值
	// 数值
	public static final String QZFS_QZFS_2 = "2"; // 数值
	// 字段
	public static final String QZFS_QZFS_3 = "3"; // 字段

	/**
	 * 数学符号
	 */
	// 加法运算
	public static final String SXFH_SXFH_1 = "1";
	// 减法运算
	public static final String SXFH_SXFH_2 = "2";
	// 乘法运算
	public static final String SXFH_SXFH_3 = "3";
	// 除法运算
	public static final String SXFH_SXFH_4 = "4";
	// 无括号
	public static final String SXFH_SXFH_10 = "10";
	// 左括号
	public static final String SXFH_SXFH_11 = "11";
	// 右括号
	public static final String SXFH_SXFH_12 = "12";
	// 等于
	public static final String SXFH_SXFH_20 = "20";
	// 不等于
	public static final String SXFH_SXFH_21 = "21";
	// 大于
	public static final String SXFH_SXFH_22 = "22";
	// 大于等于
	public static final String SXFH_SXFH_23 = "23";
	// 小于
	public static final String SXFH_SXFH_24 = "24";
	// 小于等于
	public static final String SXFH_SXFH_25 = "25";
	// 象
	public static final String SXFH_SXFH_26 = "26";
	// 不像
	public static final String SXFH_SXFH_27 = "27";
	// 并且
	public static final String SXFH_SXFH_30 = "30";
	// 或者
	public static final String SXFH_SXFH_31 = "31";
	/**
	 * 统计类型定义--end--
	 */
	/**
	 * 
	 * *************************** 系统升级新增 ***************************
	 */
	// FILETYPE_Txt
	public static final String FILETYPE_FILETYPE_1 = "1";
	// FILETYPE_Excel
	public static final String FILETYPE_FILETYPE_2 = "2";
	// FILETYPE_DBF
	public static final String FILETYPE_FILETYPE_3 = "3";
	// FILETYPE_PDF
	public static final String FILETYPE_FILETYPE_4 = "4";

	/**
	 * 
	 * *************************** 人员转移新增 ***************************
	 */
	// 职工
	public static final String USERTYPE_USERTYPE_1 = "1";
	// 居民
	public static final String USERTYPE_USERTYPE_2 = "2";
	// 学生
	public static final String USERTYPE_USERTYPE_3 = "3";

	// 学生转职工
	public static final String MOVETYPE_MOVETYPE_IN_211 = "211";
	// 居民转职工
	public static final String MOVETYPE_MOVETYPE_IN_212 = "212";
	// 职工转职工
	public static final String MOVETYPE_MOVETYPE_IN_213 = "213";
	// 职工跨经办机构
	public static final String MOVETYPE_MOVETYPE_IN_214 = "214";

	// 职工转居民
	public static final String MOVETYPE_MOVETYPE_IN_221 = "221";
	// 学生转居民
	public static final String MOVETYPE_MOVETYPE_IN_222 = "222";
	// 居民转居民
	public static final String MOVETYPE_MOVETYPE_IN_223 = "223";
	// 居民跨经办机构
	public static final String MOVETYPE_MOVETYPE_IN_224 = "224";

	// 职工转学生
	public static final String MOVETYPE_MOVETYPE_IN_231 = "231";
	// 居民转学生
	public static final String MOVETYPE_MOVETYPE_IN_232 = "232";
	// 学生转学生
	public static final String MOVETYPE_MOVETYPE_IN_233 = "233";
	// 学生跨经办机构
	public static final String MOVETYPE_MOVETYPE_IN_234 = "234";

	// 职工转学生
	public static final String MOVETYPE_MOVETYPE_OUT_111 = "111";
	// 职工转居民
	public static final String MOVETYPE_MOVETYPE_OUT_112 = "112";
	// 职工转职工
	public static final String MOVETYPE_MOVETYPE_OUT_113 = "113";
	// 职工跨经办机构
	public static final String MOVETYPE_MOVETYPE_OUT_114 = "114";

	// 居民转职工
	public static final String MOVETYPE_MOVETYPE_OUT_121 = "121";
	// 居民转学生
	public static final String MOVETYPE_MOVETYPE_OUT_122 = "122";
	// 居民转居民
	public static final String MOVETYPE_MOVETYPE_OUT_123 = "123";
	// 居民跨经办机构
	public static final String MOVETYPE_MOVETYPE_OUT_124 = "124";

	// 学生转职工
	public static final String MOVETYPE_MOVETYPE_OUT_131 = "131";
	// 学生转居民
	public static final String MOVETYPE_MOVETYPE_OUT_132 = "132";
	// 学生转学生
	public static final String MOVETYPE_MOVETYPE_OUT_133 = "133";
	// 学生跨经办机构
	public static final String MOVETYPE_MOVETYPE_OUT_134 = "134";

	// AAE011_经办人
	public static final String AAE011_AAE011 = "nonghang";

	// AAE046_交易类型：主体查询接口
	public static final String AAE046_AAE046_00 = "00";
	// AAE046_交易类型：查询交易接口
	public static final String AAE046_AAE046_01 = "01";
	// AAE046_交易类型：交费交易接口
	public static final String AAE046_AAE046_02 = "02";
	// AAE046_交易类型：取消交易接口
	public static final String AAE046_AAE046_03 = "03";
	// AAE046_交易类型：对账交易
	public static final String AAE046_AAE046_05 = "05";

	// AAE047_银行方对仗标志（未对帐）
	public static final String AAE047_AAE047_1 = "1";
	// AAE047_银行方对仗标志（对帐成功）
	public static final String AAE047_AAE047_2 = "2";
	// AAE047_银行方对仗标志（对帐失败）
	public static final String AAE047_AAE047_3 = "3";

	// AAE049_社保对仗标志（未对帐）
	public static final String AAE049_AAE049_1 = "1";
	// AAE049_社保对仗标志（对帐成功）
	public static final String AAE049_AAE049_2 = "2";
	// AAE049_社保对仗标志（对帐失败）
	public static final String AAE049_AAE049_3 = "3";

	// CAC100_对账差异类型（正常）
	public static final String CAC100_CAC100_0 = "0";
	// CAC100_对账差异类型（差异已处理）
	public static final String CAC100_CAC100_1 = "1";
	// CAC100_对账差异类型（社保方不存在数据）
	public static final String CAC100_CAC100_2 = "2";
	// CAC100_对账差异类型（银行方不存在数据）
	public static final String CAC100_CAC100_3 = "3";

	// JYZTDM_交易状态代码：连接成功
	public static final String JYZTDM_00 = "00";
	// JYZTDM_交易状态代码：查询交易成功
	public static final String JYZTDM_100 = "100查询交易成功";
	// JYZTDM_交易状态代码：对应的家庭/学好号码不存在
	public static final String JYZTDM_101 = "101对应的家庭/学好号码不存在";
	// JYZTDM_交易状态代码：有特殊人员需至社区认定交费
	public static final String JYZTDM_104 = "104有特殊人员需至社区认定交费";

	// BAD004_无
	public static final String BAD004_BAD004_00 = " ";
	// BAD004_邮政银行
	public static final String BAD004_BAD004_315 = "315";
	// BAD004_交通银行
	public static final String BAD004_BAD004_301 = "301";
	// BAD004_建设银行
	public static final String BAD004_BAD004_105 = "105";
	// BAD004_工商银行
	public static final String BAD004_BAD004_102 = "102";
	// BAD004_中国农业银行
	public static final String BAD004_BAD004_103 = "103";
	// BAD004_中国招商银行
	public static final String BAD004_BAD004_308 = "308";

	// 退休认定--未通过
	public static final String BAE197_BAE197_0 = "0";
	// 退休认定--已通过
	public static final String BAE197_BAE197_1 = "1";
	// 退休认定--已复核
	public static final String BAE197_BAE197_2 = "2";

	// 退休认定--数据来源--职工缴费
	public static final String AAE004_AAE004_1 = "1";
	// 退休认定--数据来源--居民缴费
	public static final String AAE004_AAE004_2 = "2";
	// 退休认定--数据来源--视同缴费
	public static final String AAE004_AAE004_3 = "3";
	// 退休认定--数据来源--异地转入职工
	public static final String AAE004_AAE004_4 = "4";
	// 退休认定--数据来源--异地转入居民
	public static final String AAE004_AAE004_5 = "5";

	// --------------------网上申报核心静态代码----beg

	// 预约状态_预约
	public static final String BOOK_STATE_0 = "0";
	// 预约状态_登记预约
	public static final String BOOK_STATE_1 = "1";
	// 预约状态_取消预约
	public static final String BOOK_STATE_2 = "2";

	// 时段_上午
	public static final String PER_TIME_0 = "0";
	// 时段_下午
	public static final String PER_TIME_1 = "1";

	// 业务类型_年审预约
	public static final String OPERATE_TYPE_0 = "0";
	// 业务类型_经办预约
	public static final String OPERATE_TYPE_1 = "1";
	// 数据源名称
	public static final String DATA_SOURCE_RET = "publicExchangeRet";
	// Date_DAY_星期日
	public static final String Date_DAY_Date_DAY_0 = "0";
	// Date_DAY_星期一
	public static final String Date_DAY_Date_DAY_1 = "1";
	// Date_DAY_星期二
	public static final String Date_DAY_Date_DAY_2 = "2";
	// Date_DAY_星期三
	public static final String Date_DAY_Date_DAY_3 = "3";
	// Date_DAY_星期四
	public static final String Date_DAY_Date_DAY_4 = "4";
	// Date_DAY_星期五
	public static final String Date_DAY_Date_DAY_5 = "5";
	// Date_DAY_星期六
	public static final String Date_DAY_Date_DAY_6 = "6";
	// --------------------网上申报核心静态代码----end

	// AAE172_无证书
	public static final String AAE172_AAE172_0 = "0";
	// AAE172_临时证书
	public static final String AAE172_AAE172_1 = "1";
	// AAE172_USBKEY
	public static final String AAE172_AAE172_2 = "2";

	// AAE179_AAE179_1企业劳资人员
	public static final String AAE179_AAE179_1 = "1";
	// AAE179_AAE179_2代理缴费中介机构
	public static final String AAE179_AAE179_2 = "2";
	// AAE179_AAE179_3无固定工作的自由参保人
	public static final String AAE179_AAE179_3 = "3";
	// AAE179_AAE179_4有固定工作的企业参保人员
	public static final String AAE179_AAE179_4 = "4";
	// AAE179_AAE179_5社区
	public static final String AAE179_AAE179_5 = "5";
	// AAE179_AAE179_6家庭
	public static final String AAE179_AAE179_6 = "6";
	// AAE179_AAE179_7 社保经办人员（家庭移动办公）
	public static final String AAE179_AAE179_7 = "7";

	// 劳模基本医疗二次报销提升比例
	public static final String AAA000_AAA000_1 = "1";
	// 劳模大额医疗二次报销提升比例
	public static final String AAA000_AAA000_2 = "2";

	// 结算类型--一次结算
	public static final String AKC199_AKC199_1 = "1";
	// 结算类型--劳模二次结算
	public static final String AKC199_AKC199_2 = "2";

	public static final String AAE201_AAE201_0 = "0";
	// 劳模等级--地市级劳模
	public static final String AAE201_AAE201_1 = "1";
	// 劳模等级--省级劳模
	public static final String AAE201_AAE201_2 = "2";
	// 劳模等级--国家劳模
	public static final String AAE201_AAE201_3 = "3";

	// BKC046_第一档
	public static final String BKC046_BKC046_1 = "1";
	// BKC046_第二档
	public static final String BKC046_BKC046_2 = "2";

	// EMP_OR_DEN_0职工标志
	public static final String EMP_OR_DEN_0 = "0";
	// EMP_OR_DEN_1居民标志
	public static final String EMP_OR_DEN_1 = "1";

	/************************************** 生育静态代码 ****************************************/

	// 工伤待遇流程控制代码 在lc01 和lc03 使用
	public static final String BAA008_BAA008_FLOW_15 = "15"; // 劳动局认定通过
	public static final String BAA008_BAA008_FLOW_20 = "20"; // 劳动局鉴定通过
	public static final String BAA008_BAA008_FLOW_25 = "25"; // 事故登记通过
	public static final String BAA008_BAA008_FLOW_30 = "30"; // 认定登记通过
	public static final String BAA008_BAA008_FLOW_34 = "34"; // 认定登记复核退回
	public static final String BAA008_BAA008_FLOW_35 = "35"; // 认定登记复核通过
	public static final String BAA008_BAA008_FLOW_39 = "39"; // 历史劳动能力鉴定信息
	// lc03表
	public static final String BAA008_BAA008_FLOW_40 = "40"; // 劳动能力鉴定登记通过
	public static final String BAA008_BAA008_FLOW_45 = "45"; // 工伤待遇审核通过
	public static final String BAA008_BAA008_FLOW_49 = "49"; // 工伤待遇复核退回
	public static final String BAA008_BAA008_FLOW_50 = "50"; // 工伤待遇复核通过
	public static final String BAA008_BAA008_FLOW_55 = "55"; // 工亡待遇审核通过
	public static final String BAA008_BAA008_FLOW_59 = "59"; // 工亡待遇复核退回
	public static final String BAA008_BAA008_FLOW_60 = "60"; // 工亡待遇复核通过
	public static final String BAA008_BAA008_FLOW_65 = "65"; // 一次性领取待遇审核通过
	public static final String BAA008_BAA008_FLOW_90 = "90"; // 流程终止

	public static final String AAB071_AAB071_01 = "01"; // 新建工程项目
	public static final String AAB071_AAB071_02 = "02"; // 在建工程项目

	public static final String AAB100_AAB100_01 = "01"; // 建筑施工项目
	// public static final String AAB100_AAB100_02 = "02"; //餐饮娱乐..
	// 鉴定类型 ALC214
	public static final String ALC214_ALC214_1 = "1"; // 初次鉴定
	public static final String ALC214_ALC214_2 = "2"; // 再次鉴定
	public static final String ALC214_ALC214_3 = "3"; // 复查鉴定

	// 工伤待遇类别
	// 一次性待遇
	public static final String ALC601_ALC601_05 = "05"; // 一次性伤残补助金
	public static final String ALC601_ALC601_10 = "10"; // 一次性工亡补助金
	public static final String ALC601_ALC601_15 = "15"; // 丧葬补助金
	public static final String ALC601_ALC601_20 = "20"; // 安家补助费
	public static final String ALC601_ALC601_21 = "21"; // 劳动能力鉴定费用
	public static final String ALC601_ALC601_22 = "22"; // 体检费
	public static final String ALC601_ALC601_25 = "25"; // 辅助器具安装配置费用
	public static final String ALC601_ALC601_30 = "30"; // 一次性领取工伤保险待遇金额
	public static final String ALC601_ALC601_35 = "35"; // 供养一次性领取待遇金额
	public static final String ALC601_ALC601_40 = "40"; // 医疗费
	public static final String ALC601_ALC601_45 = "45"; // 一次性领取医疗费
	public static final String ALC601_ALC601_50 = "50"; // 医疗住院伙食补助
	public static final String ALC601_ALC601_55 = "55"; // 医疗交通费
	public static final String ALC601_ALC601_60 = "60"; // 医疗住宿费
	public static final String ALC601_ALC601_65 = "65"; // 康复费

	// 定期待遇
	public static final String ALC601_ALC601_505 = "505"; // 伤残津贴
	public static final String ALC601_ALC601_510 = "510"; // 护理费
	public static final String ALC601_ALC601_515 = "515"; // 供养亲属抚恤金

	// 认定结论
	public static final String ALC313_ALC313_0 = "0"; // 不予认定工伤
	public static final String ALC313_ALC313_1 = "1"; // 认定工伤
	public static final String ALC313_ALC313_2 = "2"; // 视同工伤
	// 工伤待遇支付类别
	public static final String ALC190_ALC190_1 = "1"; // 正常发放
	public static final String ALC190_ALC190_3 = "3"; // 补发
	public static final String ALC190_ALC190_4 = "4"; // 退发

	// 工伤待遇类别
	public static final String ALC191_ALC191_1 = "1"; // 定期待遇
	public static final String ALC191_ALC191_2 = "2"; // 非定期待遇

	// 证件类型
	public static final String AAC058_AAC058_1 = "1";// 居民身份证（户口簿）

	public static final String AAC058_AAC058_2 = "2";// 中国人民解放军军官证

	public static final String AAC058_AAC058_3 = "3";// 中国人民武装警察警官证

	public static final String AAC058_AAC058_4 = "4";// 香港特区护照/身份证明

	public static final String AAC058_AAC058_5 = "5";// 澳门特区护照/身份证明

	public static final String AAC058_AAC058_6 = "6";// 台湾居民来往大陆通行证

	public static final String AAC058_AAC058_7 = "7";// 婴儿出生证

	public static final String AAC058_AAC058_8 = "8";// 外国人护照
	// 是否老工伤标志
	public static final String ALC420_ALC420_0 = "0";// 非老工伤人员

	// 是否老工伤标志
	public static final String ALC456_ALC456_0 = "0";// 非1-4级死亡

	public static final String ALC456_ALC456_1 = "1";// 1-4级死亡

	public static final String ALC420_ALC420_1 = "1";// 老工伤人员
	// 生育状态
	public static final String AMC089_AMC089_1 = "1"; // 产前
	public static final String AMC089_AMC089_2 = "2"; // 产中
	public static final String AMC089_AMC089_3 = "3"; // 产后
	public static final String AMC089_AMC089_4 = "4"; // 生育津贴
	// 生育类型
	public static final String AMC078_AMC078_2 = "2";// 正常生育

	public static final String AMC078_AMC078_3 = "3";// 流产
	public static final String AMC078_AMC078_4 = "4";// 其他

	// 工伤生育信息审批类型

	public static final String ALC130_ALC130_1 = "1";// 工伤事故登记时间小于参保时间
	public static final String ALC130_ALC130_2 = "2";// 工伤人员身份证号与名字同时修改
	// 是否康复费
	public static final String ALC613_ALC613_1 = "1";// 是康复费
	public static final String ALC613_ALC613_0 = "0";// 非康复费
	// 是否辅助器具伙食交通住宿费
	public static final String ALC643_ALC643_1 = "1";// 是辅助器具伙食交通住宿费
	public static final String ALC643_ALC643_0 = "0";// 非辅助器具伙食交通住宿费

	// ALC021_死亡
	public static final String ALC021_ALC021_1 = "1";
	// ALC021_重伤
	public static final String ALC021_ALC021_2 = "2";
	// ALC021_轻伤
	public static final String ALC021_ALC021_3 = "3";
	// ALC021_小工伤
	public static final String ALC021_ALC021_4 = "4";
	// ALC021_门诊
	public static final String ALC021_ALC021_5 = "5";
	// ALC021_住院
	public static final String ALC021_ALC021_6 = "5";

	// BAA008_未复核（工伤生育使用）
	public static final String BAA008_BAA008_0 = "0";
	// BAA008_复核通过（工伤生育使用）
	public static final String BAA008_BAA008_1 = "1";
	// BAA008_复核不通过
	public static final String BAA008_BAA008_2 = "2";
	// BAA008_未复核
	public static final String BAA008_BAA008_3 = "3";

	// BAE823_个人
	public static final String BAE823_BAE821_1 = "1";
	// BAE823_单位
	public static final String BAE823_BAE822_2 = "2";
	// BAE823_定点医疗机构
	public static final String BAE823_BAE822_3 = "3";
	// BAE823_辅助器具配置机构
	public static final String BAE823_BAE822_4 = "4";

	// BAE104_统筹范围类别_统筹范围内
	public static final String BAE104_BAE104_1 = "1";
	// BAE104_统筹范围类别_统筹范围外
	public static final String BAE104_BAE104_2 = "2";

	// BKA113_单价控制
	public static final String BKA113_BKA113_1 = "1";
	// BKA113_总价控制
	public static final String BKA113_BKA113_2 = "2";
	// BKA113_数量控制
	public static final String BKA113_BKA113_3 = "3";

	// BKA111_统筹基金支付标准类别
	public static final String BKA111_BKA111_11 = "11";
	// BKA111_重大疾病补助标准类别
	public static final String BKA111_BKA111_12 = "12";
	// BKA111_公务补助限额标准类别
	public static final String BKA111_BKA111_13 = "13";
	// BKA111_三大目录内价格控制标准类别
	public static final String BKA111_BKA111_21 = "21";
	// BKA111_三大目录外价格控制标准类别
	public static final String BKA111_BKA111_22 = "22";
	// BKA111_门诊特检特治标准类别
	public static final String BKA111_BKA111_31 = "31";
	// BKA111_住院特检特治标准类别
	public static final String BKA111_BKA111_32 = "32";
	// BKA111_门诊慢性病限制类别
	public static final String BKA111_BKA111_41 = "41";
	// BKA111_门诊大病标准类别
	public static final String BKA111_BKA111_42 = "42";
	// BKA111_门诊特殊病种标准类别
	public static final String BKA111_BKA111_51 = "51";
	// BKA111_住院特殊病种标准类别
	public static final String BKA111_BKA111_52 = "52";
	public static final String BKA111_BKA111_1 = "1"; // 起付线补助标准
	public static final String BKA111_BKA111_2 = "2"; // 统筹个人负担补助标准
	public static final String BKA111_BKA111_3 = "3"; // 大额个人负担补助标准
	public static final String BKA111_BKA111_4 = "4"; // 个人自费补助标准
	public static final String BKA111_BKA111_5 = "5"; // 个人负担合计
	public static final String BKA111_BKA111_6 = "6"; // 个人先自付补助标准

	// BKA101_45岁以下（含45岁）三级医院报销比例
	public static final String BKA101_BKA101_100001 = "100001";
	// BKA101_45岁以下（含45岁）二级及二级以下医院报销比例
	public static final String BKA101_BKA101_100002 = "100002";
	// BKA101_46岁以上三级医院报销比例
	public static final String BKA101_BKA101_100003 = "100003";
	// BKA101_46岁以上二级及二级以下医院报销比例
	public static final String BKA101_BKA101_100004 = "100004";
	// BKA101_退休人员三级医院报销比例
	public static final String BKA101_BKA101_100005 = "100005";
	// BKA101_退休人员二级及二级以下医院报销比例
	public static final String BKA101_BKA101_100006 = "100006";
	// BKA102_城镇职工大额补助基金支付标准
	public static final String BKA102_BKA102_200001 = "200001";
	// BKA102_城镇居民大额补助基金支付标准
	public static final String BKA102_BKA102_200002 = "200002";
	// BKA103_公务补助限额标准
	public static final String BKA103_BKA103_300001 = "300001";
	// BKA104_范围内自费项目价格控制标准
	public static final String BKA104_BKA104_400001 = "400001";
	// BKA105_范围外自费项目价格控制标准
	public static final String BKA105_BKA105_500001 = "500001";
	// BKA112_否
	public static final String BKA112_BKA112_0 = "0";
	// BKA112_是
	public static final String BKA112_BKA112_1 = "1";
	// BKZ301_否
	public static final String BKZ301_BKZ301_0 = "0";
	// BKZ301_是
	public static final String BKZ301_BKZ301_1 = "1";

	// BKA071_否
	public static final String BKA071_BKA071_0 = "0";
	// BKA071_是
	public static final String BKA071_BKA071_1 = "1";
	// BKA076_否
	public static final String BKA076_BKA076_0 = "0";
	// BKA076_是
	public static final String BKA076_BKA076_1 = "1";

	// BAZ200_产前检查
	public static final String BAZ200_BAZ200_M01 = "M01";
	// BAZ200_顺产
	public static final String BAZ200_BAZ200_M02 = "M02";
	// BAZ200_剖腹产
	public static final String BAZ200_BAZ200_M03 = "M03";
	// BAZ200_剖腹产
	public static final String BAZ200_BAZ200_M04 = "M04";
	// BAZ200_人工流产
	public static final String BAZ200_BAZ200_M05 = "M05";
	// BAZ200_生育引起的疾病
	public static final String BAZ200_BAZ200_M06 = "M06";

	// 医疗类别(AKA130)分类
	public static final String AKA130_KC32 = "32";
	public static final String AKA130_KC38 = "38";
	public static final String AKA130_KC42 = "42";
	public static final String AKA130_KC62 = "62";

	// 医保统计编码
	public static final String BKA150_BKA150_00 = "00"; // 甲类西药
	public static final String BKA150_BKA150_01 = "01"; // 甲类中成药
	public static final String BKA150_BKA150_02 = "02"; // 乙类西药
	public static final String BKA150_BKA150_03 = "03"; // 乙类中成药
	public static final String BKA150_BKA150_04 = "04"; // 中草药
	public static final String BKA150_BKA150_05 = "05"; // 自费西药
	public static final String BKA150_BKA150_06 = "06"; // 自费中成药
	public static final String BKA150_BKA150_07 = "07"; // 自费中草药
	public static final String BKA150_BKA150_08 = "08"; // 民族药
	public static final String BKA150_BKA150_09 = "09"; // 生物制剂
	public static final String BKA150_BKA150_10 = "10"; // 抗肿瘤药
	public static final String BKA150_BKA150_11 = "11"; // 抗肿瘤中成药
	public static final String BKA150_BKA150_12 = "12"; // 紧急抢救目录外用药
	public static final String BKA150_BKA150_13 = "13"; // 床位费
	public static final String BKA150_BKA150_14 = "14"; // 监护床位费
	public static final String BKA150_BKA150_15 = "15"; // 层流洁净病房床位费
	public static final String BKA150_BKA150_16 = "16"; // 陪护床床位费
	public static final String BKA150_BKA150_17 = "17"; // 住院诊查费
	public static final String BKA150_BKA150_18 = "18"; // 会诊费
	public static final String BKA150_BKA150_19 = "19"; // 护理费
	public static final String BKA150_BKA150_20 = "20"; // 一般专项护理
	public static final String BKA150_BKA150_21 = "21"; // 检查费
	public static final String BKA150_BKA150_22 = "22"; // 放射费
	public static final String BKA150_BKA150_23 = "23"; // CT
	public static final String BKA150_BKA150_24 = "24"; // MRI
	public static final String BKA150_BKA150_25 = "25"; // 彩色B超
	public static final String BKA150_BKA150_26 = "26"; // 动态心电图
	public static final String BKA150_BKA150_27 = "27"; // ICU监护费
	public static final String BKA150_BKA150_28 = "28"; // 特殊检查
	public static final String BKA150_BKA150_29 = "29"; // 化验费
	public static final String BKA150_BKA150_30 = "30"; // 特殊支付化验费
	public static final String BKA150_BKA150_31 = "31"; // 治疗费
	public static final String BKA150_BKA150_32 = "32"; // 特殊治疗费
	public static final String BKA150_BKA150_33 = "33"; // 手术费
	public static final String BKA150_BKA150_34 = "34"; // 介入治疗
	public static final String BKA150_BKA150_35 = "35"; // 全自费血
	public static final String BKA150_BKA150_36 = "36"; // 紧急抢救用血
	public static final String BKA150_BKA150_37 = "37"; // 重大手术用血
	public static final String BKA150_BKA150_38 = "38"; // 调温费
	public static final String BKA150_BKA150_39 = "39"; // 特殊材料费
	public static final String BKA150_BKA150_40 = "40"; // 部分自费材料费
	public static final String BKA150_BKA150_41 = "41"; // 全自费材料费
	public static final String BKA150_BKA150_42 = "42"; // 其他费
	public static final String BKA150_BKA150_43 = "43"; // 诊查费
	public static final String BKA150_BKA150_44 = "44"; // 挂号费
	public static final String BKA150_BKA150_45 = "45"; // 起付标准

	// 医疗使用标志
	public static final String AKA022_AKA022_1 = "1"; // 是
	public static final String AKA022_AKA022_2 = "2"; // 否

	// 生育使用标志
	public static final String AMA011_AMA011_1 = "1"; // 是
	public static final String AMA011_AMA011_2 = "2"; // 否

	// 统计方式(1单次2累计)
	public static final String BKB199_BKB199_1 = "1"; // 单次
	public static final String BKB199_BKB199_2 = "2"; // 累计

	// IC卡封面打印状态
	public static final String BAC666_BAC666_0 = "0"; // 未打印
	public static final String BAC666_BAC666_1 = "1"; // 已打印

	// 医保证卡片打印状态
	public static final String BKC288_BKC288_0 = "0"; // 未打印
	public static final String BKC288_BKC288_1 = "1"; // 已打印

	// 银行代征代缴
	public static final String BAE500_BAE500_00 = "00"; // 未对账
	public static final String BAE500_BAE500_01 = "01"; // 已对账

	/*------------------------------- 社保卡改造  ------------------------------*/
	public static final String BZE041_0 = "0";// 未启用
	public static final String BZE041_1 = "1";// 已启用
	public static final String CERTIFY_FLAG_0 = "0";// 未启用
	public static final String CERTIFY_FLAG_1 = "1";// 已启用

	// 社保卡险种：医疗保险
	public static final String AAE140_AAE140_30 = "30";
	// 社保卡险种：医疗保险-职工
	public static final String AAE140_AAE140_31 = "31";
	// 社保卡险种：医疗保险-居民
	public static final String AAE140_AAE140_32 = "32";
	// 社保卡险种：工商保险
	public static final String AAE140_AAE140_40 = "40";
	// 社保卡险种：生育保险
	public static final String AAE140_AAE140_50 = "50";

	// AAC050_社保卡绑定业务：社保征缴
	public static final String AAC050_AAC050_100 = "100";
	// AAC050_社保卡绑定业务：待遇发放
	public static final String AAC050_AAC050_101 = "101";

	// 01结算未确认
	public static final String BKC421_BKC421_01 = "01";
	// 02退费未确认
	public static final String BKC421_BKC421_02 = "02";
	// 03交易已确认
	public static final String BKC421_BKC421_03 = "03";
	// 03退费确认
	public static final String BKC421_BKC421_04 = "04";
	// 存在
	public static final String IS_EXIST_1 = "1";
	// 不存在
	public static final String IS_EXIST_2 = "2";
	// 西安市就医地医疗保险机构编码
	public static final String BAA001_BAA001_61990001 = "61990001";
	// 铜川市的人往西安住院统一数据分区
	public static final String BAA001_BAA001_61020001 = "61020001";
	// 西安市就医地协议状态
	public static final String BAE019_BAE019_BAE019_1 = "1";
	// 异地安置备案
	public static final String BAE018_BAE018_BAE018_01 = "01";
	// 转外就医备案
	public static final String BAE018_BAE018_BAE018_03 = "03";
	// 备案有效天数(分级诊疗用),转外就医默认10天不用次静态代码
	public static final String DAY_DAY_DAY_14 = "14";
	public static final String BKC027_BKC027_2 = "2";// 医疗费统筹报销--现金报销备案时用
	public static final String BKC027_BKC027_3 = "3";// 常驻外地人员拨付--异地安置个人帐户退费
	public static final String BKC027_BKC027_4 = "4";// 个人账户退费
	public static final String BKC027_BKC027_5 = "5";// 生育津贴审核
	public static final String BKC027_BKC027_6 = "6";// 提取社保卡信息统一入口【仅含境外普通住院、生育住院】零星结算，查询详细业务类型以本表AKC190关联KC21即可.
	public static final String BKC027_BKC027_7 = "7";// 工伤待遇应付核定 //20160928号已停用
	// 待遇方法方式
	public static final String ISUSE_ISUSE_1 = "1";// 用银行卡发放
	public static final String ISUSE_ISUSE_2 = "2";// 用社保卡发放
	public static final String EMPTY_EMPTY = "";// 空代码项

	// 社保卡交易状态代码
	public static final String BAZ346_BAZ346_010 = "010"; // 交易成功
	
	// 网上办事功能id
	public static final String SAA015_SAA015_M3020 = "M3020";// 人员转移
	public static final String SAA015_SAA015_M3003 = "M3003";// 人员信息修改
	public static final String SAA015_SAA015_M3004 = "M3004";// 人员停保登记
	public static final String SAA015_SAA015_M3002 = "M3002";// 人员新参保登记
	public static final String SAA015_SAA015_M3005 = "M3005";// 人员续保登记
	public static final String SAA015_SAA015_M3006 = "M3006";// 人员缴费基数申报
	public static final String SAA015_SAA015_M3001 = "M3001";// 单位信息修改
	public static final String SAA015_SAA015_M3011 = "M3011";// 居民人员停保登记
	public static final String SAA015_SAA015_M3012 = "M3012";// 居民人员续保登记
	public static final String SAA015_SAA015_M3018 = "M3018";// 异地安置备案登记
	public static final String SAA015_SAA015_M3019 = "M3019";// 生育备案登记
	public static final String SAA015_SAA015_M3017 = "M3017";// 转外就诊登记
	public static final String SAA015_SAA015_M3010 = "M3010";// 居民人员信息修改
	
	public static final String SAA015_SAA015_M4001 = "M4001";  //单位信息修改
	public static final String SAA015_SAA015_M4002 = "M4002";  //人员新参保登记
	public static final String SAA015_SAA015_M4003 = "M4003";  //人员信息修改
	public static final String SAA015_SAA015_M4004 = "M4004";  //人员停保登记
	public static final String SAA015_SAA015_M4005 = "M4005";  //人员续保登记
	public static final String SAA015_SAA015_M4006 = "M4006";  //人员缴费基数申报
	public static final String SAA015_SAA015_M4007 = "M4007";  //单位缴费核定
	public static final String SAA015_SAA015_M4008 = "M4008";  //征集通知
	public static final String SAA015_SAA015_M4009 = "M4009";  //失业金申领
	public static final String SAA015_SAA015_M4010 = "M4010";  //年审功能
	public static final String SAA015_SAA015_M4022 = "M4022";  //稳岗补贴申请

	// 网上办事事项id
	public static final String SAA004_SAA004_00000000 = "00000000";// 备用字段
	
	// 网上办事服务机构ID
	public static final String SZZ003_SZZ003_00000201 = "00000201";// 市医保中心
	
	// 申报来源
	public static final String TAA105_TAA105_1 = "1";// 网上大厅
	
	//未通过原因
	public static final String MESSAGE_MESSAGE_1 = "1";  //校验通过
	public static final String MESSAGE_MESSAGE_2 = "2";  //单位下不存在此个
	public static final String MESSAGE_MESSAGE_3 = "3";  //医疗基数不符合政策
	public static final String MESSAGE_MESSAGE_4 = "4";  //工伤基数不符合政策
	public static final String MESSAGE_MESSAGE_34 = "34";  //基数不符合政策
	//个人所参见的险种
	public static final String AAE140_FLAG_AAE140_FLAG_34 = "34";  //医疗工伤保险
	public static final String AAE140_FLAG_AAE140_FLAG_4 = "4";  //工伤保险
	public static final String AAE140_FLAG_AAE140_FLAG_3 = "3";  //医疗保险
	public static final String AAE140_FLAG_AAE140_FLAG_2 = "2";  //单位下不存在此人

	
	
}
