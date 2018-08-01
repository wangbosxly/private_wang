package com.thinkgem.jeesite.common.utils;
/**
 * 电子档案公共类
 * @author liujun
 *
 */
public class AraeUtils {
	private static String fondsID = "" ;
	
	public static String getFondsID(String baa001){
		if("6102".equals(baa001)){
			fondsID ="1080";
		}else if("610299".equals(baa001)){
			fondsID="1086";
		}else if("610202".equals(baa001)){
			fondsID="1081";
		}else if("610203".equals(baa001)){
			fondsID="1082";
		}else if("610204".equals(baa001)){
			fondsID="1083";
		}else if("610207".equals(baa001)){
			fondsID="1085";
		}else if("610222".equals(baa001)){
			fondsID="1084";
		}
		return fondsID;
	}
}
