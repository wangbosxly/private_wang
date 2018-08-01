package com.thinkgem.jeesite.common.utils.excel.sy;

import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;

/**
 * 导出功能中将静态代码值转换为对应的汉字
 * @description 
 * @since 20170621
 * @author njx
 * @version 1.0
 */
public class StaticCodeConvert {
	public StaticCodeConvert(){
	}
	
	/**
	 * 缴费类型AAE143转换方法
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AAE143(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
		   code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_1)){
			code_name="正常应缴记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_2)){
			code_name="补收记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_4)){
			code_name="调整补收记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_11)){
			code_name="补欠缴";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_12)){
			code_name="预缴";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_13)){
			code_name="补基数";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_14)){
			code_name="特殊补收记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_18)){
			code_name="退收";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_19)){
			code_name="一次性补收记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_20)){
			code_name="补比例";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_21)){
			code_name="补费记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_23)){
			code_name="历史缴费记录补录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_31)){
			code_name="补助记录";
		}else if(codeValue.equals(CodeConstant.AAE143_AAE143_41)){
			code_name="定额缴费";
		}else{
			code_name="请联系技术人员维护AAE143对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}
	
	
	/**
	 * 缴费标志AAE114 转换方法
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AAE114(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
		   code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.AAE114_AAE114_1)){
			code_name="已实缴";
		}else if(codeValue.equals(CodeConstant.AAE114_AAE114_2)){
			code_name="欠缴";
		}else if(codeValue.equals(CodeConstant.AAE114_AAE114_7)){
			code_name="已退收";
		}else if(codeValue.equals(CodeConstant.AAE114_AAE114_8)){
			code_name="已核销";
		}else{
			code_name="请联系技术人员维护AAE114对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}
	
	/**
	 * 个人参加的险种
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AAE140_FLAG(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
		   code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.AAE140_FLAG_AAE140_FLAG_2)){
			code_name="单位下不存在此人";
		}else if(codeValue.equals(CodeConstant.AAE140_FLAG_AAE140_FLAG_3)){
			code_name="医疗保险";
		}else if(codeValue.equals(CodeConstant.AAE140_FLAG_AAE140_FLAG_34)){
			code_name="医疗工伤保险";
		}else if(codeValue.equals(CodeConstant.AAE140_FLAG_AAE140_FLAG_4)){
			code_name="工伤保险";
		}else{
			code_name="请联系技术人员维护AAE140_FLAG对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}
	
	/**
	 * 未通过原因
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_MESSAGE(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
			code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.MESSAGE_MESSAGE_1)){
			code_name="校验通过";
		}else if(codeValue.equals(CodeConstant.MESSAGE_MESSAGE_2)){
			code_name="单位下不存在此个";
		}else if(codeValue.equals(CodeConstant.MESSAGE_MESSAGE_3)){
			code_name="医疗基数不符合政策";
		}else if(codeValue.equals(CodeConstant.MESSAGE_MESSAGE_4)){
			code_name="工伤基数不符合政策";
		}else if(codeValue.equals(CodeConstant.MESSAGE_MESSAGE_34)){
			code_name="基数不符合政策";
		}else{
			code_name="请联系技术人员维护MESSAGE对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}	
	
	/**
	 * 缴费标志AAC031 转换方法
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AAC031(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
		   code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.AAC031_AAC031_0)){
			code_name="未参保";
		}else if(codeValue.equals(CodeConstant.AAC031_AAC031_1)){
			code_name="参保缴费";
		}else if(codeValue.equals(CodeConstant.AAC031_AAC031_2)){
			code_name="暂停缴费";
		}else if(codeValue.equals(CodeConstant.AAC031_AAC031_3)){
			code_name="终止参保收";
		}else if(codeValue.equals(CodeConstant.AAC031_AAC031_4)){
			code_name="参保不缴费(医保用)";
		}else{
			code_name="请联系技术人员维护AAC031对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}
	
	/**
	 * 缴费标志AJA004 转换方法
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AJA004(String codeValue){
		String code_name="";
		if(codeValue.equals("")){
		   code_name="导出过程获取代码值为空,无法转换";
		}else if(codeValue.equals(CodeConstant.AJA004_AJA004_0)){
			code_name="职工";
		}else if(codeValue.equals(CodeConstant.AJA004_AJA004_1)){
			code_name="农民合同制工人";
		}else{
			code_name="请联系技术人员维护AJA004对应的代码值：【"+codeValue+"】.";
		}
		return code_name;
	}
	
	
	/**
	 * 缴费标志AJA004 转换方法
	 * @param codeValue
	 * @return
	 */
	public static String returnCodeName_AJA004_TO_VALUE(String codeName){
		String code_value="";
		if(codeName.equals("")){
			codeName="导出过程获取代码值为空,无法转换";
		}else if(codeName.equals("职工")){
			code_value=CodeConstant.AJA004_AJA004_0;
		}else if(codeName.equals("农民合同制工人")){
			code_value=CodeConstant.AJA004_AJA004_1;
		}else{
			code_value="请联系技术人员维护AJA004对应的代码值：【"+code_value+"】.";
		}
		return code_value;
	}	
}
