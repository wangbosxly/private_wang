package com.thinkgem.jeesite.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.service.DictService;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.util.Date;

public class test {

    /**
     * 测试失业单位错误信息核查
     */
    @Test
    public void test1(){
        JSONObject json = new JSONObject();
//		json.put("SAA015", "M4019");
//		json.put("AAE011", "aa");
//		json.put("AAC003", "孙超");
//		json.put("AAC002", "610331198710210012");
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("CODE_TYPE", "0");
//        json.put("AAB034", "610499");
//        json.put("AAE005", "1112123");
//        json.put("BAB811", "sy_001");
//        json.put("StartYM", "20170101");
//        json.put("EndYM", "20180314");
//        json.put("AAE140", "2");
//        json.put("AAB033", "3");
 //       json.put("BKB026", "61bbc611525cfc5c29c2183664402f8e");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_ERRORINFOQUERY, json.toString());
        JSONArray objects = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonObject);
    }

    /**
     * 稳岗补贴测试
     */
    @Test
    public void test2(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");//操作人
        json.put("AAB001", "10400000538");//单位编号
		json.put("SAA015", "M4020");//功能id   稳岗补贴 M4020
        json.put("BAA001", "610499");//数据分区
        json.put("BJB003","01");//稳岗补贴类型 01兼并重组   02化解产能过剩  03淘汰落后产能  04城市企业转型  06 其他
        json.put("AAE002", "2017-01-01");//费款所属期
        json.put("BAZ005", "2017");//批量流水号
		json.put("AAE011", "aa");//经办人
		json.put("AAC003", "孙超");
		json.put("AAC002", "610331198710210012");
//        json.put("CODE_TYPE", "0");
        json.put("AAB034", "610499");
        json.put("AAE005", "1112123");
        json.put("BAB811", "sy_001");
        json.put("StartYM", "20170101");
        json.put("EndYM", "20180314");
        json.put("AAE140", "2");
        json.put("AAB033", "3");
        json.put("AAB004", "中国石油天然气股份有限公司长庆石");

               json.put("BKB026", "61bbc611525cfc5c29c2183664402f8e");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_SUBSIDIESINFOQUERY, json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 数据字典转存本地
     */
    @Test
    public void test3(){

        JSONObject json = new JSONObject();
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/dataDictionary/information/query.json",json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        DictService dictService = new DictService();
        for (Object o : jsonArray) {
            JSONObject j = (JSONObject) o;
            Dict dict = new Dict();
            dict.setValue(j.getString("VALUE"));
            dict.setType(j.getString("CODE_TYPE")+"_5");
            dict.setLabel(j.getString("NAME"));
            dict.setParentId(j.getString("PARENT_CODE"));
            dict.setSort(Integer.parseInt(j.getString("SORT")));
            dictService.save(dict);
        }
    }

    /**
     * 单位缴费核定打印
     */
    @Test
    public void test4(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");//操作人
        json.put("AAB001", "10400000538");//单位编号
        json.put("SAA015", "M4020");//功能id   稳岗补贴 M4020
        json.put("BAA001", "610499");//数据分区
        json.put("BJB003","01");//稳岗补贴类型 01兼并重组   02化解产能过剩  03淘汰落后产能  04城市企业转型  06 其他
        json.put("AAE002", "2017-01-01");//费款所属期
        json.put("BAZ005", "2017");//批量流水号
        json.put("AAE011", "aa");//经办人
        json.put("AAC003", "孙超");
        json.put("AAC002", "610331198710210012");
//        json.put("CODE_TYPE", "0");
        json.put("AAB034", "610499");
        json.put("AAE005", "1112123");
        json.put("BAB811", "sy_001");
        json.put("StartYM", "201701");
        json.put("EndYM", "201803");
        json.put("AAE140", "2");
        json.put("AAB033", "3");
        json.put("AAB004", "中国石油天然气股份有限公司长庆石");

        json.put("BKB026", "61bbc611525cfc5c29c2183664402f8e");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/unit/pay/printed.json", json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 人员基本信息查询
     */
    @Test
    public void test5(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");//操作人
        json.put("AAB001", "10400000538");//单位编号
        json.put("BAA001", "610499");//数据分区
        json.put("AAC002","610404610923201");//身份证号
        json.put("AAC001","049900037039");//个人编号
        json.put("AAC003","常新民");//身份证号
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/person/basicInfoQuery.json", json.toString());
        System.out.println(jsonObject);

    }

    /**
     * 人员新参保增加
     */
    @Test
    public void test6(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");//操作人
        json.put("AAB001", "10400000538");//单位编号
        json.put("BAA001", "610499");//数据分区
        json.put("AAC002","610404610923201");//身份证号
        json.put("AAC001","049900037039");//个人编号
        json.put("AAC003","常新民");//身份证号
        json.put("SAA036","xy");//受理单号
        json.put("BAE941","xy");//申报流水号
//        BAE941	申报流水号
// …	其他人员信息
        json.put("AAE011","李四");//经办人
        json.put("AAE036", DateUtils.formatDateTime(new Date()));//	经办时间
        json.put("SAA037","李四");//SAA037	申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        json.put("SAA015","M4002");	//功能id
        // BUS_ID   从哪里获取	业务ID 不是必须的
        // SAA031	表单模板id        不是必须
        json.put("SAA004", "00000334");//SAA004	事项id
        json.put("BAE702","1");//单位1，个人0  BAE702	主体类型
        json.put("BAE703","10400000538");//BAE703	主体编号  应该是单位编号了，猜的。
        json.put("SAA043","1");//SAA043	业务状态 1填写资料  2提交审核  3预审  4 受理  5 审核  6办结
        json.put("SZZ003","00000363"); //SZZ003	服务机构ID 宝鸡的是这个，咸阳的不清楚 00000201
        json.put("TAA103", "0");       	// 审核结果,0待审核,1审核通过,2审核不通过
        json.put("TAA105","1");//    申报来源,1网上大厅,2微信        TAA105	申报来源

        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/person/basicInfoQuery.json", json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 社平工资查询
     */
    @Test
    public void test7(){
        JSONObject json = new JSONObject();
       json.put("AAE170","SY00000102333"); //AAE170	操作人
       json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("BAB808","9");//BAB808	社平工资查询标记

        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 单位缴费查询
     */

    @Test
    public  void test8(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("BAB811", "SY00000102");
        json.put("StartYM", "20170101");
        json.put("EndYM", "20170614");
        json.put("AAE140", "2");
        json.put("AAB033", "2");
        json.put("AAE143", "1");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_PAYINFOQUERY, json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 单位缴费核定
     */
    @Test
    public void test9(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("AAE140", "2");
        //正常应交记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        json.put("StartYM", "201601");
        json.put("EndYM", "201712");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_PAY_QUERY, json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 查询人员参保信息
     */
    @Test
    public void test10(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("AAC002","'62210119900720003'");//身份证号
        //json.put("AAC001","049900037039");//个人编号
        //json.put("AAC003","'常新民'");//身份证号
        //json.put("AAE002", "201703");
        //json.put("AAE035", "201705");
        //正常应交记录
        //json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        json.put("AAE140","2"); //险种
        json.put("BAC808","20"); //每页数据量
        //json.put("AAC031","1"); //参保状态
        json.put("BAC809","1"); //页码
        //json.put("AAC031","1"); //参保状态
        //json.put("AAC050","-1"); //
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonArray);
    }

    /**
     * 人员缴费查询
     */
    @Test
    public void test11(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("BAC809","1"); //页码
        //json.put("AAC002","610404610923201");//身份证号
        //json.put("AAC001","049900037039");//个人编号
        //正常应交记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        //json.put("AAE002","201701");//费款所属期
        json.put("AAE140","2"); //险种
        json.put("BAC808","20"); //每页数据量
        json.put("AAC031","1"); //参保状态
        json.put("AAE003","201706");//费款所属期
        json.put("AAE002","201706");//费款所属期
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_PAY_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonArray);
    }

    /**
     * 单位征集计划
     */
    @Test
    public void test12(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("AAE140", "2");
        //缴费方式
        json.put("AAB033", CodeConstant.AAB033_AAB033_2);
        //不为1时查征集计划
        json.put("AAE143", CodeConstant.AAE143_AAE143_2);
        json.put("BAE703", "10400000538");//BAE703主体编号
        json.put("StartYM", "201701");
        json.put("EndYM", "201712");
        json.put("AAE063", "-1");//setAAE063("-1");//查询缴费记录中所有的未做过征集计划的缴费核定记录
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_PAY_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonArray);
    }

    /**
     * 单位缴费信息查询，利用征集流水号
     */
    @Test
    public void test13(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("AAE140", "2");
        //备注为利用征集流水号查询
        json.put("BAB811", "1");
        //征集流水号
        json.put("AAE063", "000000185747");

        //缴费方式
        json.put("AAB033", CodeConstant.AAB033_AAB033_2);
        //不为1时查征集计划
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        json.put("BAE703", "10400000538");//BAE703主体编号
        json.put("StartYM", "201702");
        json.put("EndYM", "201703");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_PAYINFOQUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonArray);
    }

    /**
     * 单位补差缴费核定
     */
    @Test
    public void test14(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");
        json.put("AAB001", "10400000538");
        json.put("BAA001", "610499");
        json.put("AAE140", "2");
        //正常应交记录
        //json.put("AAE143", CodeConstant.AAE143_AAE143_2);
        json.put("StartYM", "201701");
        json.put("EndYM", "201705");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_SENDERS_QUERY, json.toString());
        System.out.println(jsonObject);
    }

    /**
     * 查询异动相信信息
     */
    @Test
    public void test15(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("AAE140","2"); //险种
        //json.put("AAC031","1"); //参保状态
        json.put("AAC050","21"); //
        json.put("AAE002","201701");//费款所属期
        json.put("AAE035","201705");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
        System.out.println(jsonArray);
    }

    @Test
    public void test16(){
        JSONObject json = new JSONObject();
        json.put("bAB701", "60545.99");
        json.put("AAE170", "SY00000102");
        json.put("bAE742", "0");
        json.put("BAE703","10400000538");
       // json.put("SAA015",CodeConstant.SAA015_SAA015_M);

        json.put("aAE003", "201804");
        json.put("aAE002", "201707");
        json.put("aAB122", "25948.93");
        json.put("aAB121", "8649383");
        json.put("aAB120", "8649383");
        json.put("aAE140", "2");
        json.put("aAB034", "610499");
        json.put("aAB137", "86494.92");
        json.put("aAB083", "1087");
        json.put("bAA001", "610499");
        json.put("aAB004", "中国石油天然气股份有限公司长庆石");
        json.put("aAB001", "10400000538");
        json.put("bAA005", "SYWS8e5ee1780abd81e334c8daa043db");
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_UNIT_PAY_CHECK, json.toString());
        JSONObject jsonObject = PostHelperUtils.toParseJSONObject(jsonInfo);
    }

    /**
     * 人员缴费查询
     */
    @Test
    public void test17(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        //json.put("AAC002","610404610923201");//身份证号
        //json.put("AAC001","049900037039");//个人编号
        //正常应交记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_13);
        json.put("AAE002","201705");//费款所属期
        json.put("AAE003","201705");//费款所属期
        json.put("AAE140","2"); //险种
        //json.put("BAA005","8fb5eacf0abd81e350ad588af0a32684");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_PAY_INFO_QUERY, json.toString());
        JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);

        System.out.println(jsonArray);
    }

    @Test
    public void test18(){
        System.out.println("".equals(null));
        Integer.parseInt(null);
    }

    @Test
    public void test19(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("startYM","201701");//费款所属期
        json.put("endYM","201712");//费款所属期
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.MONEY_TO_TURN, json.toString());
        JSONArray retlist = PostHelperUtils.toParseJSONArray(jsonObject, "RETLIST");
    }
    /**
     * 进度查询
     */
    @Test
    public void test20(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Action", "3");//3为办件公示，不关心时间段，只查100个记录
        jsonObject.put("BAA001", "610499");
        jsonObject.put("AAE170","SY00000102"); //AAE170	操作人
        jsonObject.put("AAB001","10400000538"); //AAB001	单位编号
        //jsonObject.put("SAA037", user.getLoginName());
        jsonObject.put("BAE703", "10400000538");
        //jsonObject.put("SAA043", "6");// 业务状态  查询是否接办
        //jsonObject.put("SAA015", "M2010");// 功能ID
        JSONObject json = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_QUERY_ACCEPT_INFO_REALTIME, jsonObject.toString());
        JSONArray result = PostHelperUtils.toParseJSONArray(json, "Results");
    }

    /**
     * 稳岗补贴申请第一步
     */
    public void test21(){
        JSONObject json = new JSONObject();
            json.put("AAE170", "SY00000102");// SY00000102
            json.put("AAB001", "10400000538");// 10400000538
            json.put("AAE140", "2");//险种
            json.put("SAA015", "M4022");	//
            json.put("BAE702", "1");// 主题 1单位   0个人
            json.put("BAE703", "10400000538");//主题编号
            json.put("SAA043", "3");//受理状态  3 待审核
            json.put("SAA004", " ");//
            json.put("SAA037", "SY00000102");//申请人
            json.put("SAA038", CommonUtility.get19BitCurTimeAPP());//
            json.put("BAA001", "610499");//数据分区编号
            json.put("AAB034", "610499");//社会保险经办机构编码
            json.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());//受理单ID
            json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//申报流水号
            json.put("AAE002", "2017");//费款所属期
            json.put("BJC003", "05");//稳岗补贴类型TYPE=BJB003
            json.put("BJC408", "1");//养老保险补贴0/1
            json.put("BJC409", "0");//医疗保险补贴0/1
            json.put("BJC410", "1");//失业保险补贴0/1
            json.put("BJC411", "0");//生活补贴/岗位补贴0/1
            json.put("BJC403", "0");//技能提升培训0/1
            json.put("BJC400", "0");//转岗培训补贴0/1
            json.put("AJC053", "2222");//上年企业缴费总额
            json.put("BJC602", "0.5");//补贴率
            json.put("AJC159", "1111");//补贴上限
            json.put("TAA103", "3");//
            json.put("TAA105", "1");//

    }


    public void test22(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");// SY00000102  json.put() AAE170	操作人
        json.put("AAB001", "10400000538");// 10400000538  AAB001	单位编号
        json.put("AAE140", "2");//险种
        json.put("SAA015", "M4022");	// SAA015	功能id
        json.put("BAE702", "1");// 主题 1单位   0个人 BAE702	主体类别(0个人,1单位)
        json.put("BAE703", "10400000538");//主题编号 BAE703	主体编号
        json.put("SAA043", "3");//受理状态  3 待审核
        json.put("SAA004", " ");// SAA004	事项id
        json.put("SAA037", "SY00000102");//申请人
        json.put("SAA038", CommonUtility.get19BitCurTimeAPP());//
        json.put("BAA001", "610499");//数据分区编号 BAA001	数据分区
        json.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());//受理单ID SAA036	受理单ID


        //SAA031	表单模板id
        //SAA039	业务表单内容
        //SAA043	业务状态
        //SAA024	法定期限
        //SAA018	承诺时限
        //SAA055	处理时间
        //SAA041	受理时间
        //SAA040	办结时间
        //BUS_ID	业务ID
        //SZZ003	服务机构ID
       // SAA080	受理人
        //SAA037	申请人
        //SAA038	申请时间
    }
    

    @Test
    public void test23(){
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");// SY00000102
        json.put("AAB001", "10400000538");// 10400000538
        json.put("BAA001", "610499");//数据分区编号
        json.put("SAA036", "XY201805221510450000");
        json.put("SAA015", "M4022");  //功能id
        //		savejson.put("TAA103", "-1");     //查所有情况不用传审核结果
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/acceptanceSingle/detailsQuery.json", json.toString());
        JSONArray result = PostHelperUtils.toParseJSONArray(jsonObject, "LIST");

    }

    @Test
    public void 人员基本信息查询(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("BAC809", "9");
        json.put("AAC002", "610324197101313122");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/person/basicInfoQuery.json", json.toString());
        JSONArray result = PostHelperUtils.toParseJSONArray(jsonObject, "LIST");
       /* AAE170	操作人	是
        AAB001	单位编号	是
        BAA001	数据分区	是
        BAC809	检查标志	否
        AAC002	身份证	是
        AAC001	个人编号	否
        AAC003	姓名	否*/

    }
    @Test
    public void 稳岗合格人员导出查询(){
        JSONObject json = new JSONObject();
        json.put("AAE170","SY00000102"); //AAE170	操作人
        json.put("AAB001","10400000538"); //AAB001	单位编号
        json.put("BAA001","610499"); //BAA001	数据分区
        json.put("SAA015","M4020"); //功能id
        json.put("SAA004",""); //事项id
        json.put("SZZ003",""); //服务机构id
        json.put("BAE702","1"); //主体类别
        json.put("BAE703","10400000538"); //主体编号
        json.put("SAA037", "SY00000102");//申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        json.put("SAA036", "XY201805251548440003");//SAA036	受理单号
        json.put("BJB003", "");//SAA038	补贴类别
        json.put("AAE030", "");//年份
        json.put("TAA103", "2");//查失败人员明细
        json.put("BAZ005", "000000000866825");//查成功人员明细

      //  jc02View.setBAZ005(baz005);//查成功人员明细
        JSONArray array = new JSONArray();
        array.add(json);
        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/unit/subsidiesInfoQuery.json", array.toString());
        JSONArray result = PostHelperUtils.toParseJSONArray(jsonObject, "LIST");
    }

    @Test
    public void MD5(){
        String s = "dne8uj3h";
        Md5PasswordEncoder m = new Md5PasswordEncoder();
        String s1 = m.encodePassword(s, null);
        System.out.println(s1);
    }
}
