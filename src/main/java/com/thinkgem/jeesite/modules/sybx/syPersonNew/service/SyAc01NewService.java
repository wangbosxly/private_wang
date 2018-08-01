/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonNew.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 人员新参保Service
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings( { "unchecked", "rawtypes" })
public class SyAc01NewService  {

	private String retFlag = "1";

	public Double querySPGZ(User user){
        //封装参数，查询缴费基数及公司基本信息
        JSONObject json = new JSONObject();
        //AAE170	操作人
        json.put("AAE170",user.getAae170());
        //AAB001	单位编号
        json.put("AAB001",user.getAab001());
        //BAA001	数据分区
        json.put("BAA001",user.getBaa001());
        //BAB808	社平工资查询标记
        json.put("BAB808","9");
        JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        //这里查询不到社平工资时返回null，在colltroller层处理。
        jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
        return jsonObject==null?null:jsonObject.getDouble("BAB808");
    }

	
	public Page<PM_AC01View> findPage(Page<PM_AC01View> page, PM_AC01View ac01) {

		try {
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			User user = UserUtils.getUser();
			String aab001 = user.getCompany().getId();
			String aab004 = user.getCompany().getName();
			
			PM_AC01View[] pm_AC01View = new PM_AC01View[0];

			UserView userView = new UserView();
			userView.setAAE170(user.getAae170());
			userView.setAAB001(aab001);
			
			
			pm_AC01View = port.nwwssy2102(userView, ac01);
			// 返回后台数据
			List list = Arrays.asList(pm_AC01View);
			int countNum = 0;
			if (pm_AC01View.length > 0) {
				// 取得数据总数
				countNum = Integer.parseInt(pm_AC01View[0].getAAC002_1());
			}

			page.setCount(countNum);
			page.setList(list);
			
			
		}catch (Exception e) {
				e.printStackTrace();
			}
		return page;

	}

	@Transactional(readOnly = false)
	public String saveInfo(PM_AC01View ac01View) {
        User user = UserUtils.getUser();
        JSONObject json = (JSONObject) JSONObject.toJSON(ac01View);
        //操作人
        json.put("AAE170", user.getAae170());
        //单位编号
        json.put("AAB001", user.getAab001());
        //数据分区
        json.put("BAA001", user.getBaa001());
        //个人编号新参保为空
        json.put("AAC001"," ");
        //受理单号
        json.put("SAA036","XY"+ CommonUtility.getSAA036());
        //申报流水号
        json.put("BAE941","XY"+CommonUtility.getBAE941());
        //经办人
        json.put("AAE011",user.getAae011());
        //	经办时间
        json.put("AAE036", DateUtils.formatDateTime(new Date()));
        //SAA037	申请人
        json.put("SAA037",user.getAae011());
        //SAA038	申请时间
        json.put("SAA038", DateUtils.formatDateTime(new Date()));
        //功能id
        json.put("SAA015","M4002");
        // BUS_ID   从哪里获取	业务ID 不是必须的
        // SAA031	表单模板id        不是必须
        //SAA004	事项id 不确定对不对？？？？？？？？？？？？？？？？？？？
        json.put("SAA004", " ");
        //单位1，个人0  BAE702	主体类型
        json.put("BAE702","1");
        //BAE703	主体编号  应该是单位编号了，猜的。
        json.put("BAE703",user.getAab001());
        //SAA043	业务状态 1填写资料  2提交审核  3预审  4 受理  5 审核  6办结
        json.put("SAA043","3");
        //SZZ003	服务机构ID 宝鸡的是这个，咸阳的不清楚 00000201 ？？？？？？？？？？？？？？？
        json.put("SZZ003"," ");
        // 审核结果,0待审核,1审核通过,2审核不通过
        json.put("TAA103", "0");
        // 申报来源,1网上大厅,2微信        TAA105	申报来源
        json.put("TAA105","1");
        json.put("BAA008"," ");
        json.put("TAA101"," ");
        try {
            JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_ADD, json.toString());
            jsonInfo = PostHelperUtils.toParseJSONObject(jsonInfo);
            if(!PostHelperUtils.hasInfo(jsonInfo)){
                throw new RuntimeException(jsonInfo.getString("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "1";
		/*User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();
		
		String loginName =  UserUtils.getUser().getLoginName();
		String curryTime19 = CommonUtility.get19BitCurTimeAPP();
		String curryTime10 = CommonUtility.get10BitCurTimeAPP();
//		String aab001 = ac01View.getAAB001();
		try {
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			
			String bae941 = CommonUtility.getBAE941();
			String saa036 = CommonUtility.getSAA036();

			UserView userView = new UserView();

			//sa06a
//			SA06AView sa06a = new SA06AView();
//			sa06a.setSAA015(CodeConstant.SAA015_SAA015_M4002);//功能ID：人员新参保
//			sa06a.setSAA037(loginName);//登录人
//			sa06a.setBAE703(aab001);//主体编号
//			sa06a.setSAA043(CodeConstant.SAA043_SAA043_1);//业务状态
			
//			SA06AView sa06aView = this.querySa06aInfo(sa06a);
			
//			if(sa06aView == null){
				userView.setSAA036(saa036);// 受理单ID  通过接口返回 获取
//			}else{
//				userView.setSAA036(sa06aView.getSAA036());// 受理单ID   
//			}

			// 封装受理受理单的信息到userview
			userView.setSAA015(CodeConstant.SAA015_SAA015_M4002);// 功能id
			userView.setSAA004("00000334");// 事项id
			userView.setSZZ003("00000363");// 服务机构ID
			userView.setBAE702("1");// 主体类别(0个人,1单位)
			userView.setBAE703(aab001);// 主体编号
			userView.setSAA037(loginName);// 申请人
			userView.setSAA043(CodeConstant.SAA043_SAA043_3);// 业务状态:预审
			userView.setSAA038(curryTime19);//DateUtils.format2.format(new Date()));// 申请时间
			userView.setAAB001(aab001);// 
			userView.setAAE170(user.getAae170());//
			userView.setBAA001(user.getBaa001());
			userView.setSSA004("1");
			userView.setSAA031("");//表单模板ID
			userView.setBUS_ID("");//业务ID

			ac01View.setBAE941(bae941);//★申报流水号
			ac01View.setAAE003(CommonUtility.get6BitCurTimeAPP());//★对应费款所属期
			ac01View.setAAC001(" ");//个人编号 设置为空格
			ac01View.setBAA001(user.getBaa001());//数据分区编号

			ac01View.setAAE011(loginName);//经办人
			ac01View.setAAE036(curryTime19);//经办时间
			ac01View.setBAA008(CodeConstant.BAA008_BAA008_3);//复核标志:未复核

			ac01View.setSAA036(userView.getSAA036());//★受理单ID
			ac01View.setSAA015(CodeConstant.SAA015_SAA015_M4002);//功能ID：人员新参保登记
			ac01View.setTAA101(curryTime19);//★申报时间
			ac01View.setTAA102(CodeConstant.TAA102_TAA102_2);//★处理标志:已上传
			ac01View.setTAA103(CodeConstant.TAA103_TAA103_0);//★ 审核结果,0待审核,1审核通过,2审核不通过
			ac01View.setTAA105(CodeConstant.TAA105_TAA105_1);//★申报来源,1网上大厅
			ac01View.setBAC504(ac01View.getAAC040()); // 个人缴费基数
			ac01View.setTAE100("3");
			// PM_AC02表
			ac01View.setAAE140(CodeConstant.AAE140_AAE140_2); // 险种类型
			ac01View.setAAC031(CodeConstant.AAC031_AAC031_1); // 个人参保状态   ......默认是参保缴费
			ac01View.setBAC510(curryTime10); // 最近参保时间
			// PM_AC04表
			ac01View.setAAE030(CommonUtility.get4BitCurTimeAPP()+"01"); // 开始年月
			ac01View.setAAE100(CodeConstant.AAE100_AAE100_1); // 当前有效标志
			// PM_KC01表
			ac01View.setBKC281(CodeConstant.BKC281_BKC281_2); // 非公务员参加公务员统筹      ......先默认传“2”

			port.nwwssy2301(userView, ac01View);

		}catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				return "0";
			}

		return "1";*/
	}

    /**
     * 根据身份证查询个人参保信息（跟人员信息查询重复了。有空了改改）
     *
     * @param aac002 身份证号
     * @return
     */
	public PM_AC01View findInfoByAAC002(String aac002) {
        User user = UserUtils.getUser();
        //封装参数
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        json.put("BAC809","1"); //页码
        json.put("AAE140","2"); //险种
        json.put("AAC002","'"+aac002+"'");
        //调用接口获取个人信息
        try {
            //JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, json.toString());
            JSONArray jsonArray = PostHelperUtils.toParseJSONArray(jsonObject);
            List<PM_AC01View> list = JSONObject.parseArray(jsonArray.toString(), PM_AC01View.class);
            if(list!=null&&list.size()>0){
                return list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
		/*String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();
		
		String loginName =  UserUtils.getUser().getLoginName();
		try {
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			UserView userView = new UserView();
            // 功能id
			userView.setSAA004("00000334");// 事项id
			userView.setSZZ003("00000363");// 服务机构ID
			userView.setAAE170(user.getAae170());//
			userView.setBAE702("1");// 主体类别(0个人,1单位)
			userView.setBAE703(aab001);// 主体编号
			userView.setSAA037(loginName);// 申请人
			userView.setAAB001(aab001);// 

			PM_AC01View[] pac01View = new PM_AC01View[0];
			
			PM_AC01View ac01View = new PM_AC01View();
			
			ac01View.setAAC002(aac002);
			ac01View.setBAC809("9");//9-查询包括pm临时表信息
			
			//查询个人基本信息NWWS2101
			pac01View = port.nwwssy2101(userView, ac01View);
			
			if(pac01View.length >= 1){
				// 返回后台数据
				List list = Arrays.asList(pac01View);
				
				PM_AC01View vo1 = (PM_AC01View) list.get(0);

				return vo1;
			}
			
			
		}catch (Exception e) {
				e.printStackTrace();
			}
		return null;*/

	}

	public PM_AC01View findInfoByAAC001(String aac001) {

		try {
			User user = UserUtils.getUser();
			String aab001 = user.getCompany().getId();
			String aab004 = user.getCompany().getName();
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			PM_AC01View ac01View = new PM_AC01View();
			ac01View.setAAB001(aab001);
			ac01View.setBAA001(user.getBaa001());
			ac01View.setAAE140(CodeConstant.AAE140_AAE140_2);
			ac01View.setAAC001("'"+aac001+"'");
			PM_AC01View[] pm_AC01View = new PM_AC01View[0];

			UserView userView = new UserView();
			userView.setAAE170(user.getAae170());
			userView.setAAB001(aab001);
			
			
			pm_AC01View = port.nwwssy2102(userView, ac01View);
			// 返回后台数据
			List list = Arrays.asList(pm_AC01View);
			
			PM_AC01View vo1 = (PM_AC01View) list.get(0);

			return vo1;

		}catch (Exception e) {
				e.printStackTrace();
			}
		return null;

//		return super.findPage(page, ac01);
	}

	@Transactional(readOnly = false)
	public String submitInfo(PM_AC01View ac01View) {
		
//		SA06AView sa06AView = new SA06AView();
//		UserView userView = new UserView();
//		String loginName =  UserUtils.getUser().getLoginName();
//		String curryTime = CommonUtility.get19BitCurTimeAPP();
//		String aab001 = a.getAab001();
//		try {
////			NwwsPort port = MedicalInterfaceUtils.getPort();
//			
//			SA06AView sa06a = new SA06AView();
//			sa06a.setSAA015(CodeConstant.SAA015_SAA015_M3002);//功能ID：人员新参保
////			sa06a.setSAA037(loginName);//登录人
//			sa06a.setBAE703(aab001);//主体编号
//			sa06a.setSAA043(CodeConstant.SAA043_SAA043_1);//业务状态
//			
//			SA06AView sa06aView = sa06aService.querySa06aInfo(sa06a);
//			
//			if(sa06aView != null){
//				userView.setSAA036(sa06aView.getSAA036());// 受理单ID
//				userView.setSAA015(CodeConstant.SAA015_SAA015_M3002);//功能ID：人员新参保登记
//				userView.setBAE702(CodeConstant.BAE702_BAE702_1);//主体类别(0个人,1单位)
//				userView.setBAE703(a.getAab001());//主体编号
//				userView.setSAA043(CodeConstant.SAA043_SAA043_3);//业务状态:提交审核
//				userView.setSAA037(loginName);//申请人
//				userView.setSAA038(curryTime);//申请时间
//
////				port.nwws0302(userView, sa06AView);
//				sa06aService.updateSa06aInfo(userView, sa06AView);
//				
//				retFlag = "1";
//			}else{
//				retFlag = "2";
//			}
//			
//		}catch (Exception e) {
//				e.printStackTrace();
//				System.out.println(e);
//				retFlag = "0";
//				return retFlag;
//			}

		return retFlag;
	}

	
//	public SA06AView querySa06aInfo(SA06AView sa06aView){
//		SA06AView sa06aviewOut = null;
//		List sa06aList = new ArrayList();
//		SA06AView sa06aview[] = new SA06AView[0];
//		
//		try {
//			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
//			sa06aview = port.nwws0303(sa06aView);
//			//调用公共服务接口
//			if (sa06aview.length >=1) {
//				//根据传入的SAA043、BAE703、SAA015 保证返回一条记录.
//				sa06aList.add(sa06aview[0]);
//			}
//			if(sa06aList.size()>=1){
//				sa06aviewOut = new SA06AView();
//				sa06aviewOut = (SA06AView) sa06aList.get(0);
//				return sa06aviewOut;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}	

//	public void updateSa06aInfo(UserView  userview,SA06AView sa06aView){
//		try {
//			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();			
//			port.nwws0302(userview,sa06aView);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}	
	
	
}