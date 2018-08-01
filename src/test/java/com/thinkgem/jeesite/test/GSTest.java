package com.thinkgem.jeesite.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sybx.util.HttpsUtils;
import net.vsame.url2sql.utils.PostParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 工伤测试类
 *
 * @author X_P
 * @author  2018-05-30 9:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class GSTest {

    @Autowired
    Nw_wsPort gsPort;

    @Test
    public void 单位基本信息查询() {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000026");   //操作人
        json.put("AAB001", "10499000458");//单位编号
        json.put("BAA001", "610499");     //数据分区
        List<PostParam> params = new ArrayList<PostParam>();
        params.add(new PostParam("string", "string", json.toString()));
        String s = HttpsUtils.get("http://10.189.129.227:8005/nw_ws/nw_ws", "string=" + json.toString());
        System.out.println(s);
    }

    /**
     * 人员基本信息查询
     * nwws2101
     */
    @Test
    public void 人员基本信息查询() {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000033");   //操作人
        json.put("AAB001", "10499000440");//单位编号
        json.put("BAA001", "610499");     //数据分区
//      json.put("AAC002", ""); // 身份证 ()
//      json.put("AAC001", ""); // 个人编号 ()
//      json.put("AAC003", ""); // 姓名 ()
        json.put("pageNo", "1");
        json.put("pageSize", "2");
        try {
            String s = gsPort.nwws2101(json.toString());
            System.out.println(s);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 人员参保信息查询
     * nwws2102
     */
    @Test
    public void 人员参保信息查询() {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000037");   //操作人
        json.put("AAB001", "10499000464");//单位编号
        json.put("BAA001", "610499");     //数据分区AAC002	身份证
//        json.put("AAC001", "049950006941");     //数据分区AAC002	身份证
        json.put("AAE140", "5");     //数据分区
        json.put("AAC031", "1");
        json.put("pageNo", "1");
        json.put("pageSize", "2");
        try {
            String s = gsPort.nwws2102(json.toString());
            System.out.println(s);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * !人员缴费基数查询
     * nwws2103
     */
    @Test
    public void 人员缴费基数查询() throws RemoteException {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000033");   //操作人
        json.put("AAB001", "10499000440");//单位编号
        json.put("BAA001", "610499");     //数据分区
//        json.put("AAC001", "049950006838");     //个人编号
        json.put("AAE140", "4");     //险种 工伤4  生育5
        json.put("pageNo", "1");
        json.put("pageSize", "10");
        String s = gsPort.nwws2103(json.toString());
        System.out.println(s);
    }

    /**
     * !生育备案查询
     * nwws2151
     */
    @Test
    public void 生育备案查询() throws RemoteException {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000033");   //操作人
        json.put("AAB001", "10499000440");//单位编号
        json.put("BAA001", "610499");     //数据分区
        json.put("AAC001", "049950006941");     //个人编号
        String s = gsPort.nwws2151(json.toString());
//        String s = "{\"msg\":\"\",\"code\":\"0\",\"RETLIST\":[{\"AAC001\":\"049950006941\",\"AAE036\":\"2018-06-06 17:22:20\",\"BAA005\":\"000000035034\",\"AAB001\":\"10499000440\",\"AAB034\":\"610499\",\"AMC061\":\"1\",\"AAE011\":\"sy_001\",\"BAA001\":\"610499\",\"AMC032\":1}]}\n";
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray jsonArray = JSONObject.parseArray(jsonObject.getString("RETLIST"));
        System.out.println(jsonArray.getJSONObject(0));

    }

    /**
     * 人员新参保增加
     */
    @Test
    public void 人员新参保() {
        JSONObject json = new JSONObject();
        json.put("AAE170", "SY00000102");//操作人
        json.put("AAB001", "10499002914");//单位编号
        json.put("BAA001", "610499");//数据分区
        json.put("AAC002", "610404610923201");//身份证号
        //json.put("AAC001","049900037039");//个人编号
        json.put("AAC003", "常新民");//身份证号
        json.put("SAA036", "xy");//受理单号
        json.put("BAE941", "xy");//申报流水号
//        BAE941	申报流水号
// …	其他人员信息
        json.put("AAE011", "李四");//经办人
        json.put("AAE036", DateUtils.formatDateTime(new Date()));//	经办时间
        json.put("SAA037", "李四");//SAA037	申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        json.put("SAA015", "M4002");    //功能id
        // BUS_ID   从哪里获取	业务ID 不是必须的
        // SAA031	表单模板id        不是必须
        json.put("SAA004", " ");//SAA004	事项id
        json.put("BAE702", "1");//单位1，个人0  BAE702	主体类型
        json.put("BAE703", "10499002914");//BAE703	主体编号  应该是单位编号了，猜的。
        json.put("SAA043", "1");//SAA043	业务状态 1填写资料  2提交审核  3预审  4 受理  5 审核  6办结
        json.put("SZZ003", "00000363"); //SZZ003	服务机构ID 宝鸡的是这个，咸阳的不清楚 00000201
        json.put("TAA103", "0");        // 审核结果,0待审核,1审核通过,2审核不通过
        json.put("TAA105", "1");//    申报来源,1网上大厅,2微信        TAA105	申报来源

        JSONObject jsonObject = PostHelperUtils.getJSONInfo("/loseJob/person/basicInfoQuery.json", json.toString());
        System.out.println(jsonObject);
    }

    @Test
    public void 单位信息变更() throws Exception {
        JSONObject json = new JSONObject();
        json.put("AAE170", "00000026");   //操作人
        json.put("AAB001", "10499000458");//单位编号
        json.put("BAA001", "610499");     //数据分区
        String s1 = gsPort.nwws0001(json.toString());
        JSONObject jsonObject = JSONObject.parseObject(s1);
        jsonObject.put("AAB004", "有钱的单位");
        jsonObject.putAll(json);
        jsonObject.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//流水号
        jsonObject.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());//订单号
        jsonObject.put("SAA015", "M4001");//功能id
        jsonObject.put("BAE702", "1");//主体类别 单位1 个人0
        jsonObject.put("BAE703", "10499000458");//主体编号
        jsonObject.put("SAA043", CodeConstant.SAA043_SAA043_3);//审核状态
        jsonObject.put("SAA037", "老王");//申请人
        jsonObject.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        //bae941 saa036 saa015 bae702 bae703 saa043 saa037 saa038
        String s = gsPort.nwws1701(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 生育信息备案 () throws RemoteException {
        JSONObject json = new JSONObject();
        json.put("AAE170","00000033");	// 操作人
        json.put("AAB001","10499000440");	// 单位编号
        json.put("BAA001","610499");	// 数据分区"
        json.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo());	// 受理单号
        json.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());	// 申报流水号
        json.put("AAC001","049950006941");	// 个人编号
//        json.put("AMC087","2015-10-01");	// 怀孕日期 页面传值 非必填
        json.put("AMC032","1");	// 胎次 页面传值
//        json.put("AMC091","张三");	// 配偶姓名
//        json.put("AMC092","610404610923201");	// 配偶身份证号
//        json.put("AMC093","陕西省西咸新区秦汉中学");	// 配偶单位名称
//        json.put("AMC094","0");	// 配偶胎次
        json.put("TAA101",CommonUtility.get19BitCurTimeAPP());	// 申报时间
//        json.put("AAE003",CommonUtility.get6BitCurTimeAPP());	// 对应费款所属期
        json.put("AAE011","sy_001");	// 经办人
        json.put("AAE036",CommonUtility.get19BitCurTimeAPP());	// 经办时间
        json.put("SAA037","sy_001");	// 申请人
        json.put("SAA038",CommonUtility.get19BitCurTimeAPP());	// 申请时间
        json.put("SAA015","M4004");	// 功能id
//        json.put("BUS_ID"," ");	// 业务ID
//        json.put("SAA031"," ");	// 表单模板id
        json.put("SAA004"," ");	// 事项id
        json.put("BAE702","1");	// 主体类型
        json.put("BAE703","10499000440");	// 主体编号
        json.put("SAA043","3");	// 业务状态
        json.put("SZZ003","");	// 服务机构ID
        json.put("TAA103","0");	// 审核结果
        json.put("TAA105","1");	// 申报来源
        String s = gsPort.nwws2351(json.toString());
        System.out.println(s);
    }

    @Test
    public void 工伤信息备案() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000033");//	操作人
        jsonObject.put("AAB001","10499000440");//	单位编号
        jsonObject.put("BAA001","610499");//	数据分区
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo());//	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo());//	申报流水号
        jsonObject.put("AAC001","049950006941");//	个人编号
        jsonObject.put("ALC020","2018-05-06");//	工伤发生日期
        jsonObject.put("ALC203","2018-05-08");//	工伤报告日期
        jsonObject.put("ALC021","6");//	伤害程度
        jsonObject.put("ALC025","1");//	报告方式
        jsonObject.put("ALC027","1");//	工伤类别
        jsonObject.put("ALC207","01");//	事故类别
        jsonObject.put("ALC023","张三");//	事故地点
        jsonObject.put("ALC022","1");//	伤害部位
        jsonObject.put("ALC024","张三");//	报告人姓名
        jsonObject.put("ALC605","18791009022");//	报告人联系电话
        jsonObject.put("ALC800","事故摘要");//	事故摘要
        jsonObject.put("ALC626","1");//	是否定点医疗机构(默认非定点，0)
        jsonObject.put("AKB021","医疗机构");//	医疗机构名称
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP());//	申报时间
//        jsonObject.put("AAE003","AAE003");//	对应费款所属期
        jsonObject.put("AAE011","sy_001");//	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP());//	经办时间
        jsonObject.put("SAA037","sy_001");//	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP());//	申请时间
        jsonObject.put("SAA015","M3002");//	功能id
//        jsonObject.put("BUS_ID","BUS_ID");//	业务ID
//        jsonObject.put("SAA031","SAA031");//	表单模板id
        jsonObject.put("SAA004"," ");//	事项id
        jsonObject.put("BAE702"," ");//	主体类型
        jsonObject.put("BAE703","10499000440");//	主体编号
        jsonObject.put("SAA043","3");//	业务状态
        jsonObject.put("SZZ003"," ");//	服务机构ID
        jsonObject.put("TAA103","0");//	审核结果
        jsonObject.put("TAA105","1");//	申报来源
        String s = gsPort.nwws2901(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 缴费基数申报 () throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000026"); //	操作人
        jsonObject.put("AAB001","10499000458"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo()); //	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
        jsonObject.put("AAC001","049950006871"); //	个人编号049950006838
        jsonObject.put("AAE140","4"); //	险种 工伤4 生育5
        jsonObject.put("AAE030","2017"); //	开始年
        jsonObject.put("AAC040","6000"); //	工资
        jsonObject.put("BAC504","6000"); //	个人缴费基数
//        jsonObject.put("AAC002","AAC002"); //	身份证
//        jsonObject.put("AAC003","AAC003"); //	姓名
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP()); //	申报时间
//        jsonObject.put("AAE003","AAE003"); //	对应费款所属期
        jsonObject.put("AAE011","sy_001"); //	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP()); //	经办时间
        jsonObject.put("SAA037","sy_001"); //	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP()); //	申请时间
        jsonObject.put("SAA015","M3005"); //	功能id
//        jsonObject.put("BUS_ID","BUS_ID"); //	业务ID
//        jsonObject.put("SAA031","SAA031"); //	表单模板id
        jsonObject.put("SAA004"," "); //	事项id
        jsonObject.put("BAE702"," "); //	主体类型
        jsonObject.put("BAE703","10499000440"); //	主体编号
        jsonObject.put("SAA043","3"); //	业务状态
        jsonObject.put("SZZ003"," "); //	服务机构ID
        jsonObject.put("TAA103","0"); //	审核结果
        jsonObject.put("TAA105","1"); //	申报来源
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        String s = gsPort.nwws2302(jsonArray.toString());
        System.out.println(s);
    }
    @Test
    public void 社平工资查询 () throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000033"); //	操作人
        jsonObject.put("AAE030","2018-06-08"); //	日期
        jsonObject.put("BAA001","610499"); //	数据分区
        //"BAA151"// 缴费基数上限
        //"BAA152"// 缴费基数下限
        //"BAC504"// 社平工资
        String s = gsPort.nwws0004(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 单位参保信息查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000033"); //	操作人
        jsonObject.put("AAB001","10499000440"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区
        String s = gsPort.nwws1102(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 一次性伤残补助金申请查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000037"); //	操作人
        jsonObject.put("AAB001","10499000464"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区
//        jsonObject.put("AAC001","049950006871"); //	个人编号
        jsonObject.put("AAC003","测试员工09");
        String s = gsPort.nwws2902(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 一次性伤残补助金申报 () throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000026"); //	操作人
        jsonObject.put("AAB001","10499000458"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo()); //	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
        jsonObject.put("AAC001","049950006871"); //	个人编号
        jsonObject.put("ALC150","000000000011180"); //	工伤伤申号
//        jsonObject.put("ALC070","ALC070"); //	一次性待遇金额
//        jsonObject.put("ALC601","ALC601"); //	工伤待遇类别
        jsonObject.put("AAE002","201806"); //	费款所属期
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP()); //	申报时间
        jsonObject.put("AAE003","201806"); //	对应费款所属期
        jsonObject.put("AAE011","sy_001"); //	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP()); //	经办时间
        jsonObject.put("SAA037","sy_001"); //	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP()); //	申请时间
        jsonObject.put("SAA015","M4021"); //	功能id
        jsonObject.put("SAA004"," "); //	事项id
        jsonObject.put("BAE702","1"); //	主体类型
        jsonObject.put("BAE703","10499000458"); //	主体编号
        jsonObject.put("SAA043","3"); //	业务状态
        jsonObject.put("SZZ003"," "); //	服务机构ID
        jsonObject.put("TAA103","0"); //	审核结果
        jsonObject.put("TAA105","1"); //	申报来源
        String s = gsPort.nwws2903(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 一次性工亡补助金申请查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000037"); //	操作人"AAC003":"56年-男"
        jsonObject.put("AAB001","10499000464"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区"AAC002":"610301199409203397"
//        jsonObject.put("AAC001","049950006941"); //	个人编号
//        jsonObject.put("AAC003","56年-男"); //	个人编号
        jsonObject.put("AAC002","610301199409209086"); //	个人编号
        String s = gsPort.nwws2904(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 一次性工亡补助金申报 () throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000026"); //	操作人
        jsonObject.put("AAB001","10499000458"); //	单位编号
        jsonObject.put("BAA001","610499"); //	数据分区
        jsonObject.put("SAA036","XY" + GenerateSequenceUtil.generateSequenceNo()); //	受理单号
        jsonObject.put("BAE941","XY" + GenerateSequenceUtil.generateSequenceNo()); //	申报流水号
        jsonObject.put("AAC001","049950006941"); //	个人编号
        jsonObject.put("ALC150","000000000011179"); //	工伤伤申号
//        jsonObject.put("ALC070","3820.75"); //	一次性待遇金额 AAC013
//        jsonObject.put("ALC601","ALC601"); //	工伤待遇类别
        jsonObject.put("AAE002","201806"); //	费款所属期
        jsonObject.put("TAA101",CommonUtility.get19BitCurTimeAPP()); //	申报时间
        jsonObject.put("AAE003","201806"); //	对应费款所属期
        jsonObject.put("AAE011","sy_001"); //	经办人
        jsonObject.put("AAE036",CommonUtility.get19BitCurTimeAPP()); //	经办时间
        jsonObject.put("SAA037","sy_001"); //	申请人
        jsonObject.put("SAA038",CommonUtility.get19BitCurTimeAPP()); //	申请时间
        jsonObject.put("SAA015","M4022"); //	功能id
        jsonObject.put("SAA004"," "); //	事项id
        jsonObject.put("BAE702","1"); //	主体类型
        jsonObject.put("BAE703","10499000458"); //	主体编号
        jsonObject.put("SAA043","3"); //	业务状态
        jsonObject.put("SZZ003"," "); //	服务机构ID
        jsonObject.put("TAA103","0"); //	审核结果
        jsonObject.put("TAA105","1"); //	申报来源
        String s = gsPort.nwws2905(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 单位缴费信息查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000026");//	操作人
        jsonObject.put("AAB001","10499000458");//	单位编号
        jsonObject.put("BAA001","610499");//	数据分区
        jsonObject.put("AAE041","201801");//	开始费款所属期
        jsonObject.put("AAE042","201801");//	结束费款所属期
        jsonObject.put("AAE140","5");//  险种列表
        jsonObject.put("BAE746","1");//	是否计算利息
        jsonObject.put("BAE747","1");//	是否计算滞纳金
        String s = gsPort.nwws1104(jsonObject.toString());
        System.out.println(s);
    }

    @Test
    public void 业务受理进度查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Action","1");	//同步数据标志
        jsonObject.put("StartDate","2018-01-01");	//开始时间
        jsonObject.put("EndDate","2018-06-27");	//截止时间
        jsonObject.put("BAA001","610499");	//数据分区
//        jsonObject.put("SAA037","");	//申请人
//        jsonObject.put("SAA015","M4001");	//功能id
//        jsonObject.put("BAE702","");	//主体类型
        jsonObject.put("BAE703","10499000464");	//主体编号
//        jsonObject.put("SAA043","");	//业务状态
//        jsonObject.put("SAA080","");	//服务机构ID
        String s = gsPort.nwws0401(jsonObject.toString());
        System.out.println(s);
    }
    @Test
    public void 业务受理进度明细查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BAA001","610499");	//数据分区
        jsonObject.put("AAE170","00000037");	//数据分区
        jsonObject.put("BAE703","10499000464");	//数据分区
        jsonObject.put("SAA036","XY201806261949170001");	//数据分区

        String s = gsPort.nwws0403(jsonObject.toString());
        System.out.println(s);
    }
    @Test
    public void 单位缴费核定单查询() throws RemoteException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170","00000037");
        jsonObject.put("AAB001","10499000464");
        jsonObject.put("AAB004","咸阳测试单位");
        jsonObject.put("AAE041","201805");
        jsonObject.put("AAE042","201805");
        jsonObject.put("BAA001","610499");
//        jsonObject.put("BAE703","10499000464");	//数据分区
        System.out.println(jsonObject);
        String s = gsPort.nwws1106(jsonObject.toString());
        System.out.println(s);
    }
}