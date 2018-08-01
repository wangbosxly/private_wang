package com.thinkgem.jeesite.modules.nwws.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;

import org.apache.log4j.Category; //java class

import com.thinkgem.jeesite.modules.nwws.entity.PM_AC01;

/**
 * <p>
 * Title: 陕西社保
 * </p>
 * <p>
 * Description: 公共工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: www.pansky.com.cn
 * </p>
 * 
 * @author pansky
 * @version 2006-09-11
 */

public class CommonUtility {

	public CommonUtility() {
	}

	public final static String dateStyleStr = "yyyy-MM-dd";
	public static final String FILE_ADDRESS = "/D:/jeesiteHZ/jeesite-master/src/main/webapp/WEB-INF/classes/com/thinkgem/jeesite/modules/sysyjsl/web/report.jasper";

	public static Context context = null;
	public static Context messageContext = null;
	public final static String ymStyleStr = "yyyyMM";
	private static transient Category cat = Category.getInstance("com.jwhat.application.common.CommonUtility");

	/**
	 * 取应用服务器当前时间（应用服务器�?时间的格式："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return String
	 */
	public static String get19BitCurTimeAPP() {
		String timeFormat = "yyyy-MM-dd HH:mm:ss";
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 取应用服务器当前日期（应用服务器�?日期的格式："yyyy-MM-dd"
	 * 
	 * @return String
	 */
	public static String get10BitCurTimeAPP() {
		String timeFormat = "yyyy-MM-dd";
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 取应用服务器当前年月（应用服务器�?年月的格式："yyyyMM"
	 * 
	 * @return String
	 */
	public static String get6BitCurTimeAPP() {
		String timeFormat = "yyyyMM";
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 取应用服务器当前日期（应用服务器�?日期的格式："yyyyMMdd"
	 * 
	 * @return String
	 */
	public static String get8BitCurTimeAPP() {
		String timeFormat = "yyyyMMdd";
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 取应用服务器当前年份（应用服务器�?年份的格式："yyyy"
	 * 
	 * @return String
	 */
	public static String get4BitCurTimeAPP() {
		String timeFormat = "yyyy";
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 取得数据库应用服务时间
	 * 
	 * @param dateType
	 *            返回日期字符串的格式
	 * @return String 返回指定格式的日期字符串，默认为dateStyleStr
	 * @throws TxException
	 */
	public static String getCurrentDate(String dateType) {
		return date2Str(getCurrentTimeStampOrigin(), dateType);
	}

	/**
	 * 把timestamp转换为字串
	 * 
	 * @param ts
	 *            待转换的
	 * @return String 转换timestamp字串（转换格式：yyyyMMddHHmmss.SSSSSS）
	 */
	public static String timestamp2Str(java.sql.Timestamp ts) {
		String timestamp = "";
		if (isNull(ts)) {
			return timestamp;
		}
		if ("1900-01-01".equals(date2Str(ts, dateStyleStr))) {
			return timestamp; // 如果是默认的空日期则返回""
		}

		timestamp = date2Str(ts, "yyyy-MM-dd HH:mm:ss");
		// timestamp = timestamp + "." + fixPrefixStr("" + ts.getNanos() / 1000
		// , 6 , "0") ; //加上毫秒部分6位,前补0
		return timestamp;
	}

	/**
	 * 从数据库服务器得到时间戳
	 * 
	 * @return Timestamp
	 * @throws TxException
	 */
	public static java.sql.Timestamp getCurrentTimeStampOrigin() {
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		return timestamp;
	}

	/**
	 * 取应用服务器当前时间（应用服务器�?
	 * 
	 * @param timeFormat
	 *            时间的格式，如："yyyyMMddHHmmss.SSSSSS"
	 * @return String
	 */
	public static String getCurTimeAPP(String timeFormat) {
		return date2Str(new Date(), timeFormat);
	}

	/**
	 * 把时间转换为字串
	 * 
	 * @param date
	 *            待转换的时间
	 * @param format
	 *            转换格式：yyyyMMdd
	 * @return String
	 */
	public static String date2Str(Date date, String format) {
		if (isNull(date)) {
			return "";
		}

		String precision = "";
		if ("yyyyMMddHHmmss.SSSSSS".equalsIgnoreCase(format)) {
			precision = "000";
			format = "yyyyMMddHHmmss.SSSSSS";
		}
		if (dateStyleStr.equalsIgnoreCase(format)) {
			format = dateStyleStr;
		}
		format = isEmpty(format) ? dateStyleStr : format;
		format = "yyyyMMddHHmmss.SSSSSS".equalsIgnoreCase(format) ? "yyyyMMddHHmmss.SSS" : format;
		// SimpleDateFormat的转换毫秒的精度最多为3�?
		SimpleDateFormat df = new SimpleDateFormat(format);

		return df.format(date) + precision;
	}

	/**
	 * 判断Object是否为null
	 * 
	 * @param oValue
	 *            对象
	 * @return boolean
	 */
	public static boolean isNull(Object oValue) {
		return oValue == null ? true : false;
	}

	/**
	 * 判断字符串是否为空串""
	 * 
	 * @param sValue
	 *            字符�?
	 * @return boolean
	 */
	public static boolean isEmpty(String sValue) {
		if (isNull(sValue)) {
			return true;
		}
		return sValue.trim().equals("") ? true : false;
	}

	/**
	 * 把字串转换为日期
	 * 
	 * @param sdate
	 *            字串形式的日期（最长的格式：yyyyMMddHHmmss.SSS）
	 * @param format
	 *            字串格式
	 * @return Date 转换为日期类型
	 */
	public static java.util.Date str2Date(String sdate, String format) {
		if (isEmpty(sdate)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date new_date = null;
		try {
			new_date = df.parse(sdate);
		} catch (Exception e) {
			e.printStackTrace();
			cat.debug("把字串转换为日期错误：" + sdate + "，需转换的日期格式为：" + format);
		}
		return new_date;
	}

	/**
	 * 日期格式转换
	 * 
	 * @param sdate
	 *            String
	 * @param informat
	 *            String
	 * @param outformat
	 *            String
	 * @return Date
	 */
	public static String strDateTrans(String sdate, String informat, String outformat) {
		Date date = str2Date(sdate, informat);
		return date2Str(date, outformat);
	}

	/**
	 * 把字串转换为日期（SqlDate类型）
	 * 
	 * @param sdate
	 *            字串形式的日期（格式：yyyyMMdd）
	 * @return sql.Date 转换为日期类型（SqlDate类型）
	 */
	public static java.sql.Date str2SqlDate(String sdate) {
		if (isEmpty(sdate)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(dateStyleStr);

		java.util.Date utilDate = null;
		java.sql.Date sqlDate = null;
		try {
			utilDate = df.parse(sdate);
			sqlDate = new java.sql.Date(utilDate.getTime());
		} catch (Exception e) {
			cat.debug("把字串转换为日期错误：" + sdate);
			// e.printStackTrace();
		}
		return sqlDate;
	}

	/**
	 * 把timestamp字串转换为timestamp
	 * 
	 * @param timestamp
	 *            timestamp字串(格式：yyyyMMddHHmmss.SSSSSS)
	 * @return Timestamp
	 */
	public static java.sql.Timestamp str2Timestamp(String timestamp) {
		java.sql.Timestamp ts = null;
		String prefixDate = null;
		String suffixDate = null;

		if (isEmpty(timestamp)) {
			return ts;
		}
		try {
			if (timestamp.length() == 10) {
				timestamp = timestamp.trim() + " 00:00:00";
			}
			prefixDate = subStringByByte(timestamp, 0, 19); // Date部分19位
			suffixDate = fixSuffixStr(subStringByByte(timestamp, 20, 6), 6, "0"); // 毫秒部分6位
		} catch (Exception e) {
			e.printStackTrace();
			return ts;
		}
		// yyyyMMddHHmmss
		ts = new java.sql.Timestamp(str2Date(prefixDate, "yyyyMMddHHmmss").getTime());
		// SSSSSS 但要补足6位
		ts.setNanos(toInt(suffixDate) * 1000);
		return ts;
	}

	/**
	 * 计算指定年度的前后的年度
	 * 
	 * @param year
	 *            传入年度
	 * @param relayYears
	 *            增加、减少的年度
	 * @return String 返回新的年度
	 */
	public static String relayYear(String year, int relayYears) {
		String newYear = "";
		try {
			newYear = date2Str(dateAdd(str2Date(year, "yyyy"), java.util.GregorianCalendar.YEAR, relayYears), "yyyy");
		} catch (Exception e) {
		}
		return newYear;
	}

	/**
	 * 计算指定年月的前后的年月
	 * 
	 * @param yearMon
	 *            传入年月
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String relayYM(String yearMon, int relayMons) {
		String newYM = "";
		try {
			newYM = date2Str(dateAdd(str2Date(yearMon, ymStyleStr), java.util.GregorianCalendar.MONTH, relayMons),
					ymStyleStr);
		} catch (Exception e) {
		}
		return newYM;
	}

	/**
	 * 计算指定年月日的前后的天数
	 * 
	 * @param yearMonDay
	 *            传入年月日
	 * @param relayDay
	 *            天数
	 * @return String 返回新的年月日
	 */
	public static String relayYMD(String yearMonDay, int relayDay) {
		String newYMD = "";
		try {
			newYMD = date2Str(dateAdd(str2Date(yearMonDay, dateStyleStr), java.util.GregorianCalendar.YEAR, relayDay),
					dateStyleStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newYMD;
	}

	/**
	 * 计算指定年月日的前后的天数
	 * 
	 * @param yearMonDay
	 *            传入年月日
	 * @param relayDay
	 *            天数
	 * @return String 返回新的年月日
	 */
	public static String relayYMDate(String yearMonDay, int relayDay) {
		String newYMD = "";
		try {
			newYMD = date2Str(dateAdd(str2Date(yearMonDay, dateStyleStr), java.util.GregorianCalendar.DATE, relayDay),
					dateStyleStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newYMD;
	}

	/**
	 * 计算指定年月日的前后的年月
	 * 
	 * @param yearMon
	 *            传入年月
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String relayDate(String yearMonDay, int relayYear) {
		String newYMD = "";
		try {
			newYMD = date2Str(dateAdd(str2Date(yearMonDay, dateStyleStr), java.util.GregorianCalendar.DATE, relayYear),
					dateStyleStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newYMD;
	}

	/**
	 * 计算指定年月的前后的年月
	 * 
	 * @param yearMon
	 *            传入年月
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String relayYM2(String yearMon, int relayMons) {
		String newYM = "";
		String ymStyleStr = "yyyy-MM";
		try {
			newYM = date2Str(dateAdd(str2Date(yearMon, ymStyleStr), java.util.GregorianCalendar.MONTH, relayMons),
					ymStyleStr);
		} catch (Exception e) {
		}
		return newYM;
	}

	/**
	 * 计算指定年月的前后的年月,relayMons=1返回传入年月
	 * 
	 * @param yearMon
	 *            传入年月 yyyyMM
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String addYM(String yearMon, int relayMons) {
		String newYM = "";
		try {
			newYM = date2Str(dateAdd(str2Date(yearMon, ymStyleStr), java.util.GregorianCalendar.MONTH, relayMons - 1),
					ymStyleStr);
		} catch (Exception e) {
		}
		return newYM;
	}

	/**
	 * 返回两个日期之间的月数
	 * 
	 * @param startDate
	 *            开始日期（前）
	 * @param endDate
	 *            结束日期（后）
	 * @return int 月数
	 */
	public static int monthsBetween(Date startDate, Date endDate) {
		GregorianCalendar gcStart = new GregorianCalendar();
		GregorianCalendar gcEnd = new GregorianCalendar();
		gcStart.setTime(startDate);
		gcEnd.setTime(endDate);
		return (gcEnd.get(GregorianCalendar.YEAR) - gcStart.get(GregorianCalendar.YEAR)) * 12
				+ gcEnd.get(GregorianCalendar.MONTH) - gcStart.get(GregorianCalendar.MONTH);
	}

	/**
	 * 计算两个年月间的月数--同月返回为0
	 * 
	 * @param begYM
	 *            开始年月（前）YYYYMM
	 * @param endYM
	 *            结束年月（后）YYYYMM
	 * @return int
	 */
	public static int monthsBetweenYM(String begYM, String endYM) {
		if (!isYearMonth(begYM)) {
			begYM = date2Str(str2Date("1900-01-01", dateStyleStr), ymStyleStr);
		}
		if (!isYearMonth(endYM)) {
			endYM = date2Str(str2Date("1900-01-01", dateStyleStr), ymStyleStr);
		}

		int months = 0;
		try {
			int begYear = new Integer(begYM.substring(0, 4)).intValue();
			int endYear = new Integer(endYM.substring(0, 4)).intValue();
			int begMonth = new Integer(begYM.substring(4, 6)).intValue();
			int endMonth = new Integer(endYM.substring(4, 6)).intValue();
			months = (endYear - begYear) * 12 + (endMonth - begMonth);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return months;
	}

	/**
	 * 计算两个年月间的月数--同月返回为1
	 * 
	 * @param begYM
	 *            开始年月（前）YYYYMM
	 * @param endYM
	 *            结束年月（后）YYYYMM
	 * @return int
	 */
	public static int monthsBetweenYM2(String begYM, String endYM) {
		if (!isYearMonth(begYM)) {
			begYM = date2Str(str2Date("1900-01-01", dateStyleStr), ymStyleStr);
		}
		if (!isYearMonth(endYM)) {
			endYM = date2Str(str2Date("1900-01-01", dateStyleStr), ymStyleStr);
		}

		int months = 0;
		try {
			int begYear = new Integer(begYM.substring(0, 4)).intValue();
			int endYear = new Integer(endYM.substring(0, 4)).intValue();
			int begMonth = new Integer(begYM.substring(4, 6)).intValue();
			int endMonth = new Integer(endYM.substring(4, 6)).intValue();
			months = (endYear - begYear) * 12 + (endMonth - begMonth + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return months;
	}

	/**
	 * 计算两个日期间的月数
	 * 
	 * @param begYMD
	 *            开始年月（前）YYYY-MM-dd
	 * @param endYMD
	 *            结束年月（后）YYYY-MM-dd
	 * @return int
	 */
	public static int monthsBetweenYMD(String begYMD, String endYMD) {
		String begYMD1 = changeDateFormat(begYMD, "yyyyMM");
		String endYMD1 = changeDateFormat(endYMD, "yyyyMM");
		return monthsBetweenYM2(begYMD1, endYMD1);
	}

	/**
	 * 计算两个年月间的月数--同月返回为1 (注意：调用本方法，要保证年月的格式正确。为提高效率不对年月进行效验)
	 * 
	 * @param begYM
	 *            开始年月（前）YYYYMM
	 * @param endYM
	 *            结束年月（后）YYYYMM
	 * @return int
	 */
	public static int countMonths(String begYM, String endYM) {
		int months = 0;
		try {
			int begYear = new Integer(begYM.substring(0, 4)).intValue();
			int endYear = new Integer(endYM.substring(0, 4)).intValue();
			int begMonth = new Integer(begYM.substring(4, 6)).intValue();
			int endMonth = new Integer(endYM.substring(4, 6)).intValue();
			months = (endYear - begYear) * 12 + (endMonth - begMonth + 1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return months;
	}

	/**
	 * 计算两个年月日间的月数 (注意：调用本方法，要保证年月的格式正确。为提高效率不对年月进行效验)
	 * 
	 * @param begYM
	 *            开始年月（前）YYYY-MM-DD
	 * @param endYM
	 *            结束年月（后）YYYY-MM-DD
	 * @return int
	 */
	public static double countMonth(String begYMD, String endYMD) {
		double months = 0;
		try {
			double begYear = new Double(begYMD.substring(0, 4)).intValue();
			double endYear = new Double(endYMD.substring(0, 4)).intValue();
			double begMonth = new Double(begYMD.substring(5, 7)).intValue();
			double endMonth = new Double(endYMD.substring(5, 7)).intValue();
			double begDay = new Double(begYMD.substring(8, 10)).intValue();
			double endDay = new Double(endYMD.substring(8, 10)).intValue();
			months = (endYear - begYear) * 12 + (endMonth - begMonth) + (endDay - begDay) / 30.00;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return months;

	}

	private static class ElapsedTime {
		public int getDays(GregorianCalendar g1, GregorianCalendar g2) {
			int elapsed = 0;
			GregorianCalendar gc1, gc2;

			if (g2.after(g1)) {
				gc2 = (GregorianCalendar) g2.clone();
				gc1 = (GregorianCalendar) g1.clone();
			} else {
				gc2 = (GregorianCalendar) g1.clone();
				gc1 = (GregorianCalendar) g2.clone();
			}

			gc1.clear(Calendar.MILLISECOND);
			gc1.clear(Calendar.SECOND);
			gc1.clear(Calendar.MINUTE);
			gc1.clear(Calendar.HOUR_OF_DAY);

			gc2.clear(Calendar.MILLISECOND);
			gc2.clear(Calendar.SECOND);
			gc2.clear(Calendar.MINUTE);
			gc2.clear(Calendar.HOUR_OF_DAY);

			while (gc1.before(gc2)) {
				gc1.add(Calendar.DATE, 1);
				elapsed++;
			}
			return elapsed;
		}

		public int getMonths(GregorianCalendar g1, GregorianCalendar g2) {
			int elapsed = 0;
			GregorianCalendar gc1, gc2;

			if (g2.after(g1)) {
				gc2 = (GregorianCalendar) g2.clone();
				gc1 = (GregorianCalendar) g1.clone();
			} else {
				gc2 = (GregorianCalendar) g1.clone();
				gc1 = (GregorianCalendar) g2.clone();
			}

			gc1.clear(Calendar.MILLISECOND);
			gc1.clear(Calendar.SECOND);
			gc1.clear(Calendar.MINUTE);
			gc1.clear(Calendar.HOUR_OF_DAY);
			gc1.clear(Calendar.DATE);

			gc2.clear(Calendar.MILLISECOND);
			gc2.clear(Calendar.SECOND);
			gc2.clear(Calendar.MINUTE);
			gc2.clear(Calendar.HOUR_OF_DAY);
			gc2.clear(Calendar.DATE);

			while (gc1.before(gc2)) {
				gc1.add(Calendar.MONTH, 1);
				elapsed++;
			}
			return elapsed;
		}
	}

	/**
	 * 医保缴费核定用于计算年龄
	 * 
	 * @param birthYM
	 *            出生年月日
	 * @param yearMonth
	 *            计算年龄的年月
	 * @return int 年龄
	 */
	public static int countLevyAge(String birthday, String yearMonth) {
		if (!isDate(birthday)) {
			return 0;
		}
		// 取得个人出生年月
		String birthYM = birthday.substring(0, 4) + birthday.substring(5, 7);
		if (!isYearMonth(birthYM)) {
			return 0;
		}
		if (!isYearMonth(yearMonth)) {
			return 0;
		}
		String strMonthDay = birthday.substring(8, 10); // 出生的日期
		String strMonth = yearMonth.substring(4, 6); // 计算月份
		String birthMont = birthday.substring(5, 7); // 出生月份
		int age = 0;
		String montOneDay = "01";
		// 判断个人出生日期为每个月的第一天 计算月数加一个月，否则不增加一个月
		if (montOneDay.equalsIgnoreCase(strMonthDay)) {
			if (!birthMont.equalsIgnoreCase(strMonth)) {
				age = (monthsBetweenYM(birthYM, yearMonth) + 1) / 12;
			}
			// 判断计算月份是否和出生月份不相同，如果是不增加一个月
			if (birthMont.equalsIgnoreCase(strMonth)) {
				age = (monthsBetweenYM(birthYM, yearMonth)) / 12;
			}
		}
		if (!montOneDay.equalsIgnoreCase(strMonthDay)) {
			age = (monthsBetweenYM(birthYM, yearMonth)) / 12;
		}
		return age;
	}

	/**
	 * 根据增加or减少的时间得到新的日期
	 * 
	 * @param curDate
	 *            当前日期
	 * @param field
	 *            需操作的'年'or'月'or'日' (Calendar.MONTH Calendar.DATE )
	 * @param addNumber
	 *            增加or减少的时间
	 * @return Date 新的日期
	 */
	public static Date dateAdd(Date curDate, int field, int addNumber) {
		GregorianCalendar curGc = new GregorianCalendar();
		curGc.setTime(curDate);
		curGc.add(field, addNumber);
		return curGc.getTime();
	}

	/**
	 * 根据日期获取月份
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String date2Month(String dateStr) {
		Date date = str2Date(dateStr, dateStyleStr);
		String ym = date2Str(date, ymStyleStr);
		return ym;
	}

	/**
	 * 判断firstDate是否不在lastDate之后
	 * 
	 * @param lastDate
	 *            开始日期
	 * @param firstDate
	 *            结束日期
	 * @param dateFormat
	 *            eg:ymStyleStr ; dateStyleStr
	 * @return boolean @
	 */
	public static boolean notAfter(String firstDate, String lastDate, String dateFormat) {
		Date first = null;
		Date last = null;
		try {
			if (lastDate.equals(firstDate)) {
				return true;
			}
			first = str2Date(firstDate, dateFormat);
			last = str2Date(lastDate, dateFormat);
		} catch (Exception ex) {
			cat.debug("errors.date: " + firstDate + " or " + lastDate);
		}
		return first.before(last);
	}

	/**
	 * 判断查询日期是否在指定日期之间
	 * 
	 * @param firstDate
	 *            开始日期
	 * @param lastDate
	 *            结束日期
	 * @param queryDate
	 *            查询日期
	 * @param dateFormat
	 *            eg:ymStyleStr ; dateStyleStr
	 * @return boolean
	 */
	public static boolean isBetweenDate(String firstDate, String lastDate, String queryDate, String dateFormat) {
		try {
			if (!isEmpty(queryDate) && (!CommonUtility.notAfter(firstDate, queryDate, dateFormat)
					|| !CommonUtility.notAfter(queryDate, lastDate, dateFormat))) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 找出两个年月间除去ArrayList里面指明的年月后剩下的年月 主要在处理无记录补缴时使用
	 * 
	 * @param begYM
	 *            开始年月
	 * @param endYM
	 *            结束年月
	 * @param yearMonths
	 *            年月
	 * @return ArrayList 新的年月数组
	 */
	public static ArrayList invertYM(String begYM, String endYM, ArrayList yearMonths) {
		// 先找出这两个年月间的月数
		int months = monthsBetweenYM(begYM, endYM);
		// 将该时间段内的年月放到hashtable里面记录
		Hashtable hs = new Hashtable();
		for (int i = 0; i < months + 1; i++) {
			hs.put(relayYM(begYM, i), relayYM(begYM, i));
		}
		// 将已经存在在yearMonths里面的年月从hashtable里面移走
		for (int i = 0; i < yearMonths.size(); i++) {
			hs.remove(yearMonths.get(i));
		}
		// 将剩下的结果放到arrayList里面
		ArrayList al = new ArrayList(hs.values());
		return al;
	}

	/**
	 * 判断是否正确的日期格式
	 * 
	 * @param sValue
	 *            日期字串：yyyy-MM-dd HH:mm:ss 或 yyyyMMddHHmmss
	 * @return boolean
	 */
	public static boolean isDateTime(String sValue) {
		boolean flag = false;

		if (sValue.length() == 19) {
			String date = sValue.substring(0, 10);
			String time = sValue.substring(11, 19);
			flag = isDate(date);
			if (flag == true) {
				flag = isTime(time);
			}

			return flag;
		} else if (sValue.length() == 14) {
			String date = sValue.substring(0, 8);
			String time = sValue.substring(8, 14);
			flag = isDate(date);
			if (flag == true) {
				flag = isTime(time);
			}
		}
		return flag;
	}

	/**
	 * 判断是否正确的日期格式
	 * 
	 * @param sValue
	 *            日期字串：yyyyMMdd 或 yyyy-MM-dd
	 * @return boolean
	 */
	public static boolean isDate(String sValue) {
		if (sValue.length() == 10) {
			return isDate2(sValue);
		} else if (sValue.length() == 8) {
			return isDate1(sValue);

		} else {
			return false;
		}
	}

	/**
	 * 判断是否正确的日期格式
	 * 
	 * @param sValue
	 *            日期字串：yyyyMMdd
	 * @return boolean
	 */
	public static boolean isDate1(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		String dateSeparator = "";
		int intYear;
		int intMon;
		int intDay;
		boolean boolLeapYear = false;
		if (getByteSize(sValue) != 8) {
			// 长度只能为8位
			return false;
		}
		intYear = toInt(sValue.substring(0, 4));
		intMon = toInt(sValue.substring(4, 6));
		intDay = toInt(sValue.substring(6, 8));
		if (intMon > 12 || intMon < 1) {
			return false;
		}
		if (intYear < 1900) {
			return false;
		}
		if ((intMon == 1 || intMon == 3 || intMon == 5 || intMon == 7 || intMon == 8 || intMon == 10 || intMon == 12)
				&& (intDay > 31 || intDay < 1)) {
			return false;
		}
		if ((intMon == 4 || intMon == 6 || intMon == 9 || intMon == 11) && (intDay > 30 || intDay < 1)) {
			return false;
		}
		if (intMon == 2) {
			if ((intYear % 100) == 0) {
				if ((intYear % 400) == 0) {
					boolLeapYear = true;
				}
			} else {
				if ((intYear % 4) == 0) {
					boolLeapYear = true;
				}
			}
			if (boolLeapYear) {
				if (intDay > 29 || intDay < 1) {
					return false;
				}
			} else {
				if (intDay > 28 || intDay < 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断是否正确的日期格式：现在
	 * 
	 * @param sValue
	 *            日期字串：yyyy-MM-dd
	 * @return boolean
	 */
	public static boolean isDate2(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		String dateSeparator = "-"; // 日期分隔符
		if (sValue.length() != 10) {
			return false;
		}
		String temp1 = sValue.substring(0, 4);
		String temp2 = sValue.substring(5, 7);
		String temp3 = sValue.substring(8, 10);
		String seperator1 = sValue.substring(4, 5);
		String seperator2 = sValue.substring(7, 8);
		sValue = temp1 + temp2 + temp3;
		if (!(seperator1.equals("-") && seperator2.equals("-"))) {
			return false;
		}

		return isDate1(sValue);
	}

	/**
	 * 判断是否正确的时间格式
	 * 
	 * @param sValue
	 *            日期字串：HHmmss
	 * @return boolean
	 */
	public static boolean isTime(String sValue) {
		if (sValue.length() == 8) {
			return isTime2(sValue);
		} else if (sValue.length() == 6) {
			return isTime1(sValue);
		} else {
			return false;
		}
	}

	/**
	 * 判断是否正确的时间格式
	 * 
	 * @param sValue
	 *            日期字串：HHmmss
	 * @return boolean
	 */
	public static boolean isTime1(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
//		String dateSeparator = "";
		int intHour;
		int intMinute;
		int intSecond;
		if (getByteSize(sValue) != 6) {
			// 长度只能为6位
			return false;
		}
		intHour = toInt(sValue.substring(0, 2));
		intMinute = toInt(sValue.substring(2, 4));
		intSecond = toInt(sValue.substring(4, 6));

		// 小时
		if (intHour > 24 || intHour < 0) {
			return false;
		}
		// 分钟
		if (intMinute > 60 || intMinute < 0) {
			return false;
		}
		// 秒
		if (intSecond > 60 || intSecond < 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否正确的时间格式
	 * 
	 * @param sValue
	 *            日期字串：HH:mm:ss
	 * @return boolean
	 */
	public static boolean isTime2(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		String dateSeparator = ":";
		String hour;
		String minute;
		String second;
		if (getByteSize(sValue) != 8) {
			// 长度只能为8位
			return false;
		}
		hour = sValue.substring(0, 2);
		minute = sValue.substring(3, 5);
		second = sValue.substring(6, 8);
		String seperator1 = sValue.substring(2, 3);
		String seperator2 = sValue.substring(5, 6);
		sValue = hour + minute + second;
		if (!(seperator1.equals(":") && seperator2.equals(":"))) {
			return false;
		}
		return isTime1(sValue);
	}

	/**
	 * 改变日期格式：入参必须是正确的格式（要经过isDate2（）,或isDate效验）
	 * 
	 * @param sdate
	 *            日期字串：yyyyMMdd or yyyy-MM-dd
	 * @param format
	 *            日期格式
	 * @return String
	 */
	public static String changeDateFormat(String sdate, String format) {
		Date date = null;
		String changeDate = "";
		if (format.equals("yyyyMMdd")) {
			date = str2Date(sdate, "yyyy-MM-dd");
			changeDate = date2Str(date, "yyyyMMdd");

		} else if (format.equals("yyyy-MM-dd")) {
			date = str2Date(sdate, "yyyyMMdd");
			changeDate = date2Str(date, "yyyy-MM-dd");

		} else if (format.equals("yyyyMM")) {
			date = str2Date(sdate, "yyyy-MM-dd");
			changeDate = date2Str(date, "yyyyMM");

		} else if (format.equals("yyyy-MM")) {
			date = str2Date(sdate, "yyyyMMdd");
			changeDate = date2Str(date, "yyyy-MM");

		} else if (format.equals("yyyyMMddHHmmss")) {
			date = str2Date(sdate, "yyyy-MM-dd HH:mm:ss");
			changeDate = date2Str(date, "yyyyMMddHHmmss");

		} else if (format.equals("yyyy-MM-dd HH:mm:ss")) {
			date = str2Date(sdate, "yyyyMMddHHmmss");
			changeDate = date2Str(date, "yyyy-MM-dd HH:mm:ss");
		}

		return changeDate;
	}

	/**
	 * 比较两个日期的大小：入参的格式是（yyyy-MM-dd或yyyyMMdd）
	 * 
	 * @param startDate
	 *            String 开始日期
	 * @param endDate
	 *            String 结束日期
	 * @return boolean
	 */
	public static boolean compareToDate(String startDate, String endDate) {
		if (endDate.equals("")) {
			return true;
		}
		int i = 0;
		i = endDate.compareTo(startDate);
		if (i > 0 || i == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 比较两个日期的大小：入参的格式是（yyyy-MM-dd或yyyyMMdd）
	 * 
	 * @param startDate
	 *            String 开始日期
	 * @param endDate
	 *            String 结束日期
	 * @return boolean
	 */
	public static boolean compareToDate1(String startDate, String endDate) {
		if (endDate.equals("")) {
			return true;
		}
		int i = 0;
		i = endDate.compareTo(startDate);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否正确的年月格式
	 * 
	 * @param sValue
	 *            日期字串：yyyyMM
	 * @return boolean
	 */
	public static boolean isYearMonth(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		String dateSeparator = ""; // 日期分隔符
		if (sValue.length() != 6) {
			return false;
		}
		String temp1 = sValue.substring(0, 4);
		String temp2 = sValue.substring(4);
		sValue = temp1 + temp2 + "01";
		return isDate(sValue);
	}

	/**
	 * 根据输入年月得到该年月的包含最后一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyyMM
	 * @return String yyyy-MM-dd
	 */
	public static String getYmEndDay(String yearMonth) {
		return date2Str(dateAdd(str2Date(getYmFirstDay(relayYM(yearMonth, 1)), dateStyleStr),
				java.util.GregorianCalendar.DATE, -1), dateStyleStr);
	}

	/**
	 * 根据输入年月得到该年月的包含最后一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM
	 * @return String yyyy-MM-dd
	 */
	public static String getYmEndDay2(String yearMonth) {
		String dateStyleStr = "yyyy-MM-dd";
		String ymStyleStr = "yyyy-MM";
		return date2Str(dateAdd(str2Date(getYmFirstDay2(relayYM2(yearMonth, 1)), dateStyleStr),
				java.util.GregorianCalendar.DATE, -1), dateStyleStr);
	}

	/**
	 * 根据输入年月得到该年月的包含第一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyyMM
	 * @return String yyyyMMdd
	 */
	public static String getYmFirstDay(String yearMonth) {
		return date2Str(str2Date(yearMonth, ymStyleStr), dateStyleStr);
	}

	/**
	 * 根据输入年月得到该年月的包含第一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyyMM
	 * @return String yyyyMMdd
	 */
	public static String getYmFirstDay2(String yearMonth) {
		String dateStyleStr = "yyyy-MM-dd";
		String ymStyleStr = "yyyy-MM";
		return date2Str(str2Date(yearMonth, ymStyleStr), dateStyleStr);
	}

	/**
	 * 根据输入的String日期(yyyyMMdd)，得出年月
	 * 
	 * @param strDate
	 *            输入的String日期
	 * @param inFormat
	 *            输入日期的格式（如：yyyyMMddHHmmss.SSS）
	 * @param outFormat
	 *            输出日期的格式（如：yyyyMMddHHmmss.SSS）
	 * @return String 年月
	 */
	public static String getStrDateYM(String strDate, String inFormat, String outFormat) {
		if (isEmpty(inFormat)) {
			inFormat = dateStyleStr;
		}

		return date2Str(str2Date(strDate, inFormat), outFormat);
	}

	/**
	 * 获得串s的字节长度
	 * 
	 * @param src
	 *            串s
	 * @return int 字节长度
	 */
	public static int getByteSize(String src) {
		int ret = 0;
		if (isNull(src)) {
			return ret;
		}
		try {
			ret = getBytes_encode(src).length;
		} catch (Exception e) {
		}
		return ret;
	}

	public static byte[] getBytes_encode(String sourceStr) {
		byte[] newByte = null;
		try {
			newByte = sourceStr.getBytes("GBK");
			throw new Exception();
		} catch (Exception e) {
			// cat.debug("getBytes_encode(GBK) Error, source String is:" +
			// sourceStr);
			newByte = sourceStr.getBytes();
		}
		return newByte;
	}

	/**
	 * 传入字符串头尾trim
	 * 
	 * @param str
	 *            字符串
	 * @return String
	 */
	public static String trim(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 从一个字符表达式中抽取出来的一段字符串
	 * 
	 * @param str
	 *            字符表达式
	 * @param offset
	 *            开始偏移量（从0开始）
	 * @param length
	 *            截取长度
	 * @return String 抽取出来的一段字符串
	 */
	public static String subStringByByte(String str, int offset, int length) {
		String newStr = "";
		int skipLen = 0;
		int newLength = 0;

		int byteLength = 0;

		// 输入校验
		if (str == null || length < 1 || offset < 0) {
			return newStr;
		}
		int strLengthByByte = getBytes_encode(str).length;
		if (strLengthByByte < offset + 1) {
			return newStr;
		}
		if (strLengthByByte - offset < length) {
			length = strLengthByByte - offset;
		}

		// 按字节取子串
		byte[] subBytes = null;
		ByteArrayInputStream bytesStream = new ByteArrayInputStream(getBytes_encode(str));
		bytesStream.skip(offset + skipLen);

		try {
			subBytes = new byte[strLengthByByte - offset];
			// （1）判断开始的偏移量
			byteLength = bytesStream.read(subBytes, 0, strLengthByByte - offset);
			if (byteLength == -1) {
				return "";
			}
			newStr = new String(subBytes);
			if (newStr == null || newStr.length() < 1 || getBytes_encode(newStr).length < byteLength) { // 如果开始偏移量往后的不可转变为string,则表示截取的第一位是半个汉字
				skipLen = skipLen + 1;
			}
			// cat.debug(newStr);

			bytesStream.reset();
			bytesStream.skip(offset + skipLen);
			newLength = length - skipLen; // 新的截取长度
			if (newLength < 1) {
				return "";
			}
			subBytes = new byte[newLength];
			// （2）判断结束的偏移量
			byteLength = bytesStream.read(subBytes, 0, newLength);
			newStr = new String(subBytes);
			if (newStr == null || newStr.length() < 1 || getBytes_encode(newStr).length < byteLength) { // 如果重新截取的不可转变为string,则表示截取的最后一位是半个汉字
				newLength = newLength - 1;
			} else {
				return newStr;
			}
			// cat.debug(newStr);

			bytesStream.reset();
			bytesStream.skip(offset + skipLen);
			if (newLength < 1) {
				return "";
			}
			subBytes = new byte[newLength];
			// （3）
			byteLength = bytesStream.read(subBytes, 0, newLength);
			newStr = new String(subBytes);
			if (newStr == null || newStr.length() < 1 || getBytes_encode(newStr).length < byteLength) {
				return "";
			}

			return newStr;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 返回一个指定字串右边length个字节组成的字符串
	 * 
	 * @param str
	 *            原字串
	 * @param strLen
	 *            截取的长度
	 * @return String @
	 */
	public static String rightStrByByte(String str, int strLen) {
		if (isNull(str)) {
			return "";
		}
		int offset = getByteSize(str) - strLen;
		if (offset < 0) {
			return str;
		}
		return subStringByByte(str, offset, strLen);
	}

	/**
	 * 返回一个指定字串左边length个字节组成的字符串
	 * 
	 * @param str
	 *            原字串
	 * @param strLen
	 *            截取的长度
	 * @return String @
	 */
	public static String leftStrByByte(String str, int strLen) {
		if (isNull(str)) {
			return "";
		}
		if (getByteSize(str) <= strLen) {
			return str;
		}
		return subStringByByte(str, 0, strLen);
	}

	/**
	 * 获取字符串左边的数字串
	 * 
	 * @param str
	 *            原字串
	 * @return String @
	 */
	public static String leftNumberByByte(String str) {
		if (isNull(str)) {
			return "";
		}
		int len = 1;
		while (isDouble(subStringByByte(str, 0, len)) && len <= str.length()) {
			len++;
		}
		return subStringByByte(str, 0, len - 1);

	}

	/**
	 * 将字符串按特定分隔符拆分为一个String数组
	 * 
	 * @param str
	 *            以固定符号分割的字符串
	 * @param splitChar
	 *            分隔符
	 * @return 找不到时返回一个空的数组，判断数组的size
	 */
	public static String[] splitStr(String str, String splitChar) {
		if (str == null || str.length() == 0) {
			return new String[0];
		}
		if (splitChar == null || splitChar.length() == 0) {
			return new String[0];
		}
		int count = 1, pos = 0;

		while ((pos = str.indexOf(splitChar, pos)) >= 0) {
			count++;
			if (pos + splitChar.length() >= str.length()) {
				break;
			} else {
				pos = pos + splitChar.length();
			}
		}
		if (count == 1) {
			return new String[0];
		}
		String arrSplit[] = new String[count];

		if (count == 1) {
			arrSplit[0] = str;
		} else {
			int i = 0;
			while (i < count) {
				if (str.indexOf(splitChar) >= 0) {
					arrSplit[i] = str.substring(0, str.indexOf(splitChar));
				} else {
					arrSplit[i] = str;
					break;
				}
				str = str.substring(str.indexOf(splitChar) + splitChar.length());
				i++;
			}
		}
		return arrSplit;
	}

	/**
	 * 给字串加上前缀（按字符）
	 * 
	 * @param srcStr
	 *            需要加入前缀的字串
	 * @param length
	 *            返回字串总长度
	 * @param fixChar
	 *            前缀字符
	 * @return String 加上前缀后的字串
	 */
	public static String fixPrefixStr(String srcStr, int length, String fixChar) {
		if (isNull(srcStr)) {
			srcStr = "";
		}
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length - srcStr.length(); i++) {
			sb.append(fixChar);
		}
		return new String(sb) + srcStr;
	}

	/**
	 * 给字串加上前缀（按字节）
	 * 
	 * @param srcStr
	 *            需要加入前缀的字串
	 * @param length
	 *            返回字串总长度
	 * @param fixChar
	 *            前缀字符
	 * @return String 加上前缀后的字串
	 */
	public static String fixPrefixStrb(String srcStr, int length, String fixChar) {
		if (isNull(srcStr)) {
			srcStr = "";
		}
		StringBuffer sb = new StringBuffer(length);

		int srcSize = 0;
		srcSize = getBytes_encode(srcStr).length;

		for (int i = 0; i < length - srcSize; i++) {
			sb.append(fixChar);
		}
		return new String(sb) + srcStr;
	}

	/**
	 * 给字串加上后缀（按字符）
	 * 
	 * @param srcStr
	 *            需要加入后缀的字串
	 * @param length
	 *            返回字串总长度
	 * @param fixChar
	 *            后缀字符
	 * @return String 加上后缀后的字串
	 */
	public static String fixSuffixStr(String srcStr, int length, String fixChar) {
		if (isNull(srcStr)) {
			srcStr = "";
		}
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length - srcStr.length(); i++) {
			sb.append(fixChar);
		}
		return srcStr + new String(sb);
	}

	/**
	 * 给字串加上后缀（按字节）
	 * 
	 * @param srcStr
	 *            需要加入后缀的字串
	 * @param length
	 *            返回字串总长度
	 * @param fixChar
	 *            后缀字符
	 * @return String 加上后缀后的字串
	 */
	public static String fixSuffixStrb(String srcStr, int length, String fixChar) {
		String encoding = "GBK";
		if (isNull(srcStr)) {
			srcStr = "";
		}
		StringBuffer sb = new StringBuffer(length);
		int srcSize = 0;
		try {
			srcSize = srcStr.getBytes(encoding).length;
		} catch (UnsupportedEncodingException ue) {
		}
		for (int i = 0; i < length - srcSize; i++) {
			sb.append(fixChar);
		}
		return srcStr + new String(sb);
	}

	/**
	 * 四舍五入
	 * 
	 * @param a
	 *            要操作的数据
	 * @param fractionPos
	 *            舍入的小数位数
	 * @return double
	 */
	public static double round(double a, int fractionPos) {
		// 取多一位，增加精度
		double dblBase = Math.pow(10, fractionPos + 1);
		// 截掉小数点后fractionPos+1位的数据
		long intBase = (long) (mul(dblBase, a));
		// 除以10，四舍五入
		long dblTemp = Math.round(intBase / 10.0);

		return dblTemp / (dblBase / 10);
	}

	/**
	 * 双精度乘法计算（主要解决浮点漂移问题）
	 * 
	 * @param v1
	 *            double
	 * @param v2
	 *            double
	 * @return double
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 四舍五入到2位小数
	 * 
	 * @param a
	 *            要操作的数据
	 * @return double
	 */
	public static double round2frac(double a) {
		return round(a, 2);
	}

	/**
	 * 把可能为null的字符串变量转换为0长度字串
	 * 
	 * @param str
	 *            字符串变量
	 * @return String ""
	 */
	public static String null2Str(String str) {
		if (isEmpty(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 把可能为null的字符串变量转换为值等于"0"的字串
	 * 
	 * @param str
	 *            传入子串变量
	 * @return String
	 */
	public static String null2Zero(String str) {
		String zero = "0";
		if (isEmpty(str)) {
			return zero;
		}
		return str.trim();
	}

	/**
	 * 替换出现的字串
	 * 
	 * @param oldString
	 *            原子串
	 * @param strSearch
	 *            查询子串
	 * @param strReplace
	 *            替换子串
	 * @return Sring 新的子串
	 */
	public static String replaceString(String oldString, String strSearch, String strReplace) {
		/*
		 * String ret = oldString; int pos = oldString.indexOf(strSearch);
		 * if(pos >= 0) ret = oldString.substring(0,pos) + strReplace +
		 * oldString.substring(pos + strSearch.length()); return ret;
		 */
		int pos = oldString.indexOf(strSearch);
		while (pos >= 0) {
			oldString = oldString.substring(0, pos) + strReplace + oldString.substring(pos + strSearch.length());
			pos = oldString.indexOf(strSearch);
		}
		return oldString;
	}

	/**
	 * 格式化数字（两位小数）
	 * 
	 * @param number
	 *            原double
	 * @return double 格式化后的double
	 */
	public static double format1frac(double number) {
		return Double.parseDouble(format(number, "0.00"));
	}

	/**
	 * 格式化数字（两位小数）
	 * 
	 * @param number
	 *            原double
	 * @return String 转为子串
	 */
	public static String format2frac(double number) {
		return format(number, "0.00");
	}

	/**
	 * 格式化数字
	 * 
	 * @param number
	 *            原数字
	 * @param patternSize
	 *            小数位的长度
	 * @return String
	 */
	public static String format(String number, int patternSize) {
		double d = toDouble(number);
		String pattern = patternSize < 1 ? "0" : fixSuffixStr("0.", patternSize + 2, "0");
		return format(d, pattern);
	}

	public static String format(double number, int patternSize) {
		String pattern = patternSize < 1 ? "0" : fixSuffixStr("0.", patternSize + 2, "0");
		return format(number, pattern);
	}

	/**
	 * 格式化数字（不推荐使用）
	 * 
	 * @param number
	 *            原double
	 * @param pattern
	 *            输出数字字串的格式（eg:"0.00"）
	 * @return String 转为子串
	 */
	public static String format(double number, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number);
	}

	/**
	 * 修补15,17位个人身份证号码为18位
	 * 
	 * @param personIDCode
	 *            15,17位身份证
	 * @return String 18位身份证
	 */
	public static String fixPersonIDCode(String fixYear, String personIDCode) {
		String retIDCode = "";
		String id17 = "";
		if (personIDCode.trim().length() != 17 && personIDCode.trim().length() != 15) {
			return personIDCode;
		}
		if (personIDCode.trim().length() == 15) {
			id17 = personIDCode.substring(0, 6) + fixYear + personIDCode.substring(6, 15); // 15为身份证补fixYear
		} else {
			id17 = personIDCode;
		}
		if (id17.indexOf("A") > 0 || id17.indexOf("X") > 0 || id17.indexOf("x") > 0) {
			return personIDCode;
		}
		char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个
		int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 }; // 18个;
		int[] idcd = new int[18];
		int i;
		int j;
		int sum;
		int remainder;

		for (i = 1; i < 18; i++) {
			j = 17 - i;
			idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
		}

		sum = 0;
		for (i = 1; i < 18; i++) {
			sum = sum + idcd[i] * factor[i];
		}
		remainder = sum % 11;
		String lastCheckBit = String.valueOf(code[remainder]);
		return id17 + lastCheckBit;

	}

	/**
	 * 修补15,17位个人身份证号码为18位
	 * 
	 * @param personIDCode
	 *            15,17位身份证
	 * @return String 18位身份证
	 */
	public static String fixPersonIDCode(String personIDCode) {
		String retIDCode = "";
		String id17 = "";
		if (personIDCode.trim().length() != 17 && personIDCode.trim().length() != 15) {
			return personIDCode;
		}
		if (personIDCode.trim().length() == 15) {
			id17 = personIDCode.substring(0, 6) + "19" + personIDCode.substring(6, 15); // 15为身份证补'19'
		} else {
			id17 = personIDCode;
		}
		if (id17.indexOf("A") > 0 || id17.indexOf("X") > 0 || id17.indexOf("x") > 0) {
			return personIDCode;
		}
		char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个
		int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 }; // 18个;
		int[] idcd = new int[18];
		int i;
		int j;
		int sum;
		int remainder;

		for (i = 1; i < 18; i++) {
			j = 17 - i;
			idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
		}

		sum = 0;
		for (i = 1; i < 18; i++) {
			sum = sum + idcd[i] * factor[i];
		}
		remainder = sum % 11;
		String lastCheckBit = String.valueOf(code[remainder]);
		return id17 + lastCheckBit;

	}

	/**
	 * 判断是否是有效的18位或15位个人身份证号码
	 * 
	 * @param identityId
	 *            18位或15位个人身份证号码
	 * @return boolean
	 */
	public static boolean isIdentityId(String identityId) {
		if (isEmpty(identityId)) {
			return false;
		}
		try {
			if (identityId.length() == 18) {
				String identityId15 = identityId.substring(0, 6) + identityId.substring(8, 17);
				String fixYear = identityId.substring(6, 8);
				// cat.debug("the identityId15 is : "+identityId15);
				if (fixPersonIDCode(fixYear, identityId15).equalsIgnoreCase(identityId)) {
					return true;
				} else {
					return false;
				}
			} else if (identityId.length() == 15) {
				try {
					if (isLong(identityId)) {
						String identityId15 = "19" + identityId.substring(6, 12);
						// 判断所得到的出身是不是正确的日期格式
						if (isDate(identityId15)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} catch (Exception ex) {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 判断是否是有效的15位个人身份证号码
	 * 
	 * @param identityId
	 *            15位个人身份证号码
	 * @return boolean
	 */
	public static boolean isIdentityId15(String identityId) {
		// 判断得到的身份证号码是不是空的
		if (isEmpty(identityId)) {
			return false;
		}

		try {
			// 判断长度是不是15位
			if (identityId.length() == 15) {
				// 判断所得到的身份证是不是都是数字
				if (isLong(identityId)) {
					String identityId15 = "19" + identityId.substring(6, 12);
					// 判断所得到的出身日期是不是正确的日期格式
					if (isDate(identityId15)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得人员的出生日期
	 * 
	 * @param psidcd
	 *            身份证号
	 * @return String
	 */
	public static String getBirthDay(String psidcd) {
		String birthDay = "";
		// 如果不是有效的18位或15位个人身份证号码
		if (!isIdentityId(psidcd)) {
			return "";
		}
		// 修补15位个人身份证号码为18位
		if (psidcd.length() == 15) {
			psidcd = fixPersonIDCode("19", psidcd);
		}

		birthDay = psidcd.substring(6, 14);
		// 判断是否正确的日期格式：yyyyMMdd
		if (!isDate(birthDay)) {
			return "";
		}
		// birthDay = birthDay.substring(0, 4) + "-" + birthDay.substring(4, 6)
		// + "-" +
		// birthDay.substring(6, 8);

		return birthDay;
	}

	/**
	 * 获得人员的出生日期
	 * 
	 * @param psidcd
	 *            身份证号
	 * @return String
	 */
	public static String getBirthDay2(String psidcd) {
		String birthDay = changeDateFormat(getBirthDay(psidcd), "yyyy-MM-dd");
		return birthDay;
	}

	/**
	 * 获得人员的性别
	 * 
	 * @param psidcd
	 *            身份证号
	 * @return String
	 */
	public static String getPersonSex(String psidcd) {
		String personSex = "";

		// 如果不是有效的18位或15位个人身份证号码
		if (!isIdentityId(psidcd)) {
			return "";
		}
		// 修补15位个人身份证号码为18位
		if (psidcd.length() == 15) {
			psidcd = fixPersonIDCode("19", psidcd);
		}

		// 身份证号的第十七 是偶数的话，则该人员是女的；是奇数的话，则该人员是男的，
		personSex = psidcd.substring(16, 17);
		if (toInt(personSex) % 2 == 0) {
			personSex = "2"; // 女2
		} else {
			personSex = "1"; // 男1
		}

		return personSex;
	}

	/**
	 * 判断字符串是否为正整数
	 * 
	 * @param s
	 *            String字符串
	 * @return boolean
	 * @author 顾 义 波
	 */
	public static boolean isNumber(String s) {
		if (isEmpty(s)) {
			return false;
		}
		String re = "^[0-9]*$";
		Pattern pettern = Pattern.compile(re);
		Matcher matcher = pettern.matcher(s);
		boolean rs = matcher.find();
		return rs;
	}

	/**
	 * 判断是否为长整数
	 * 
	 * @param sValue
	 *            数字串
	 * @return boolean
	 */
	public static boolean isLong(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		try {
			Long.parseLong(sValue);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断是否为Double
	 * 
	 * @param sValue
	 *            数字串
	 * @return boolean
	 */
	public static boolean isDouble(String sValue) {
		if (isEmpty(sValue)) {
			return false;
		}
		try {
			Double.parseDouble(sValue);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断是否为带规定位数小数的字符串，可以用于输入小数格式判断
	 * 
	 * @param sValue
	 *            输入的字符串
	 * @param precise
	 *            小数位长度
	 * @return boolean
	 */
	public static boolean isDecimalByDigits(String sValue, int precise) {
		if (isLong(sValue)) {
			return true;
		}
		if (!isDouble(sValue)) {
			return false;
		}

		int indexZero = sValue.indexOf(".");
		if (indexZero == 0 && precise == 0) {
			return true;
		}

		String decimalStr = subStringByByte(sValue, indexZero + 1, sValue.length() - indexZero);
		return decimalStr.length() > precise ? false : true;
	}

	/**
	 * 检查是否是有效的设置位数的比例数eg:0.25 ZHM 最好使用isDecimalByDigits这个方法！ 2003-10-09
	 * 
	 * @param sValue
	 *            小数
	 * @param digits
	 *            设置的小数位数（0到1之间）
	 * @return boolean 是否是有效的设置位数的小数
	 */
	public static boolean isProportion(String sValue, int digits) {
		if (isEmpty(sValue)) {
			return false;
		}
		if (!isDouble(sValue)) {
			return false;
		}
		if (sValue.length() != 2 + digits) {
			return false;
		}

		double dValue = toDouble(sValue);
		if (dValue == 0) {
			return true;
		}
		if ((dValue >= 0.0) && (dValue <= 1.00)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否 为0~~1的小数
	 * 
	 * @param sValue
	 *            输入的字符串
	 * @return boolean
	 */
	public static boolean isBetweenZeroToOne(String sValue) {
		if (!isDouble(sValue)) {
			return false;
		}
		double dl = toDouble(sValue);
		if (0 <= dl && dl <= 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Convert a String to Int.
	 * 
	 * @param sValue
	 *            数字串
	 * @return int
	 */
	public static int toInt(String sValue) {
		try {
			sValue = format(sValue, 0);
			return Integer.parseInt(sValue);
		} catch (Exception e) {
			// cat.debug("Convert [" + sValue + "] to Int Failed!");
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Convert a String to Long.
	 * 
	 * @param sValue
	 *            数字串
	 * @return int
	 */
	public static long toLong(String sValue) {
		try {
			sValue = format(sValue, 0);
			return Long.parseLong(sValue);
		} catch (Exception e) {
			// cat.debug("Convert [" + sValue + "] to Long Failed!");
			// e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Convert a String to Double.
	 * 
	 * @param sValue
	 *            数字串
	 * @return int
	 */
	public static double toDouble(String sValue) {
		try {
			return Double.parseDouble(sValue);
		} catch (Exception e) {
			// cat.debug("Convert [" + sValue + "] to double Failed!") ;
			// e.printStackTrace();
			return 0.0;
		}
	}

	/**
	 * 转换double to String
	 * 
	 * @param doubleValue
	 *            vdouble
	 * @return String
	 */
	public static String double2Str(double doubleValue) {
		return new Double(doubleValue).toString();
	}

	/**
	 * Convert a Integer to String .
	 * 
	 * @param iValue
	 *            int
	 * @return String
	 */
	public static String int2Str(int iValue) {
		return new Integer(iValue).toString();
	}

	/**
	 * 判断传入ArrayList的大小是否是1
	 * 
	 * @param list
	 *            ArrayList
	 * @return boolean
	 */
	public static boolean isOneSizeList(ArrayList list) {
		if (isNull(list)) {
			return false;
		}
		if (list.size() != 1) {
			return false;
		}
		return true;
	}

	/**
	 * 两个String数值进行加、减、乘、除的四则运算
	 * 
	 * @param decimal1
	 *            数值1
	 * @param decimal2
	 *            数值2
	 * @param sign
	 *            + - * /
	 * @return String 计算结果
	 */
	public static String stringCalculate(String decimal1, String decimal2, String sign) {
		if ("+".equals(sign)) {
			return format2frac(toDouble(decimal1) + toDouble(decimal2));
		} else if ("-".equals(sign)) {
			return format2frac(toDouble(decimal1) - toDouble(decimal2));
		} else if ("*".equals(sign)) {
			return format2frac(toDouble(decimal1) * toDouble(decimal2));
		} else if ("/".equals(sign)) {
			return format2frac(toDouble(decimal1) / toDouble(decimal2));
		} else {
			return "";
		}
	}

	/**
	 * 金额转换为大写人民币
	 * 
	 * @param ind_amt
	 *            金额
	 * @return String 大写人民币
	 */
	public static String moneyToChinese(double ind_amt) {
		// int i ;
		int li_lendec;
		int li_lenint;
		int li_amout_flag = 0;
		int li_dec_length = 2;
		String ls_numstr;
		String a;
		String b;
		String c;
		String d;
		String bbak = "";
		String[] ls_dxint = new String[13];
		String[] ls_dxdec = new String[2];
		String[] ls_sz = new String[13];
		String ls_dxstr = "万仟佰拾亿仟佰拾万仟佰拾元";
		String ls_szstr = "零壹贰叁肆伍陆柒捌玖";

		if (ind_amt == 0) {
			ls_dxstr = "零元整";
			return ls_dxstr;
		} else {
			if (ind_amt < 0) {
				ind_amt = Math.abs(ind_amt); // 取绝对值
				li_amout_flag = 1;
			}
		}
		// 格式数据为 ######0.00 格式
		ls_numstr = format(ind_amt, "0.00");
		li_lenint = ls_numstr.substring(0, ls_numstr.indexOf(".")).length();
		// 截取小数点最后两位
		if (ls_numstr.substring(ls_numstr.indexOf(".") + 1, ls_numstr.length()).equals("00")) {
			li_lendec = 0;
		} else {
			li_lendec = 2;
			if (ls_numstr.substring(ls_numstr.indexOf(".") + 2, ls_numstr.length()).equals("0")) {
				li_dec_length = 1;
			}
		}

		for (int i = 1; i <= 13; i++) {
			// ls_dxint[i]=mid(ls_dxstr,26 - i*2+1,2)
			// System.out.println(ls_dxstr.substring( 13 - i ,13 - i + 1 ));
			ls_dxint[i - 1] = ls_dxstr.substring(13 - i, 13 - i + 1);
			if (i < 11) {
				// ls_sz[i]=mid(ls_szstr,i*2 - 1,2)
				ls_sz[i - 1] = ls_szstr.substring(i - 1, i);
			} else {
				ls_sz[i - 1] = " ";
			}
		}
		ls_dxdec[0] = "角";
		ls_dxdec[1] = "分";
		ls_dxstr = " ";

		for (int y = 1; y <= li_lenint; y++) {
			a = ls_numstr.substring(0, li_lenint).substring(y - 1, y);
			b = ls_sz[Integer.parseInt(a)];
			c = ls_dxint[li_lenint - y];
			if (!ls_dxstr.equals(" ")) {
				d = ls_dxstr.substring(ls_dxstr.length() - 1, ls_dxstr.length());
			} else {
				d = "";
			}
			if (b.equals("零") && (d.equals("零") || b.equals(bbak) || c.equals("元") || c.equals("万") || c.equals("亿"))) {
				b = "";
			}
			if (a.equals("0") && !c.equals("元") && !c.equals("万") && !c.equals("亿")) {
				c = "";
			}
			if ((c.equals("元") || c.equals("万") || c.equals("亿")) && d.equals("零") && a.equals("0")) {
				ls_dxstr = ls_dxstr.substring(0, ls_dxstr.length() - 1);
				d = ls_dxstr.substring(ls_dxstr.length() - 1, ls_dxstr.length());
				if (c.equals("元") && d.equals("万") || c.equals("万") && d.equals("亿")) {
					c = "";
				}
			}
			ls_dxstr = ls_dxstr + b + c;
			bbak = b;
		}

		for (int z = 1; z <= li_lendec; z++) {
			a = ls_numstr.substring(li_lenint + 1, li_lenint + li_lendec + 1).substring(z - 1, z);
			if (a.equals("0") && ls_dxdec[z - 1].equals("分")) {
				b = "";
			} else {
				b = ls_sz[Integer.parseInt(a)];
			}
			if (!a.equals("0")) {
				ls_dxstr = ls_dxstr + b + ls_dxdec[z - 1];
			} else {
				ls_dxstr = ls_dxstr + b;
			}
		}

		if (li_lendec == 0 || li_dec_length == 1) {
			ls_dxstr = ls_dxstr + "整";
		}
		if (ind_amt < 1.00) {
			ls_dxstr = "零" + ls_dxstr.trim();
		}
		if (li_amout_flag == 1) {
			ls_dxstr = "负" + ls_dxstr;
		}

		return ls_dxstr;
	}

	/**
	 * 金额转换为大写人民币
	 * 
	 * @param sumofcash
	 *            金额
	 * @return String 大写人民币
	 */
	public static String moneyToChinese2(double sumofcash) {
		String[] arr = { "分", "角", "元", "拾", "百", "千", "万", "拾万", "百万", "千万", "亿", "拾亿", "百亿", "千亿" };
		String sTmp = "";
		String sMoney = "";
		String header = "";
		if (sumofcash < 0) {
			header = "负";
		}
		sumofcash = Math.abs(sumofcash);
		double dTmp = sumofcash * 100;
		sMoney = format(dTmp, "0,000.#");
		StringTokenizer st = new StringTokenizer(sMoney, ",");
		String tmp = "";
		while (st.hasMoreElements()) {
			tmp = tmp + st.nextToken();
		}
		sMoney = tmp;
		int iLen = sMoney.length();
		int count = 0;
		for (int i = 0; i < iLen; i++) {
			String sTemp = sMoney.substring(i, i + 1);
			if (sTemp.equals("0")) {
				count++;
				if (count == 1) {
					sTmp = sTmp + trans(sTemp);
				}
			} else {
				sTmp = sTmp + trans(sTemp);
				sTmp = sTmp + arr[iLen - i - 1];
				count = 0;
			}
		}
		sTmp = sTmp.trim();
		iLen = sTmp.length();
		if (sTmp.substring(iLen - 1, iLen).equals("零")) {
			sTmp = sTmp.substring(0, iLen - 1);
		}
		sTmp = sTmp + "整";
		sTmp = header.concat(sTmp);
		return sTmp;
	}

	private static String trans(String args) {
		int iTemp = Integer.parseInt(args);
		String sRes = "";
		switch (iTemp) {
		case 1:
			sRes = "壹";
			break;
		case 2:
			sRes = "贰";
			break;
		case 3:
			sRes = "叁";
			break;
		case 4:
			sRes = "肆";
			break;
		case 5:
			sRes = "伍";
			break;
		case 6:
			sRes = "陆";
			break;
		case 7:
			sRes = "柒";
			break;
		case 8:
			sRes = "捌";
			break;
		case 9:
			sRes = "玖";
			break;
		case 0:
			sRes = "零";
		}
		return sRes;
	}

	/**
	 * 金额转换为大写人民币
	 * 
	 * @param num
	 *            金额
	 * @return String 大写人民币
	 */
	public static String moneyToChinese3(double num) {
		int li_amout_flag = 1;
		if (num < 0) {
			num = Math.abs(num); // 取绝对值
			li_amout_flag = -1;
		}
		String s_num, s_char, s_num_hz;
		int i_len_of_snum, i, i_flag, i_char;
		boolean flag = false;
		i_flag = 1;
		// NumberFormatter numberFormatter = new NumberFormatter();
		// s_num = numberFormatter.formatDouble(num);
		s_num = format(num, "0.00");
		if (s_num.indexOf(".") == -1) {
			s_num = s_num + ".00";
		}
		if (s_num.equals("0.00")) {
			return "零元整";
		}
		s_num_hz = "";
		i_len_of_snum = s_num.length();
		for (int k = i_len_of_snum; k > 0; k--) {
			s_char = s_num.substring(k - 1, k);
			if (s_char.equals(".")) {
				s_char = "元";
			} else {
				i_char = Integer.parseInt(s_char);
				switch (i_char) {
				case 0:
					s_char = "零";
					break;
				case 1:
					s_char = "壹";
					break;
				case 2:
					s_char = "贰";
					break;
				case 3:
					s_char = "叁";
					break;
				case 4:
					s_char = "肆";
					break;
				case 5:
					s_char = "伍";
					break;
				case 6:
					s_char = "陆";
					break;
				case 7:
					s_char = "柒";
					break;
				case 8:
					s_char = "捌";
					break;
				case 9:
					s_char = "玖";
				}
			}
			if (!s_char.equals("零")) {
				switch (i_len_of_snum - k) {
				case 0:
					s_char = s_char + "分";
					break;
				case 1:
					s_char = s_char + "角";
					break;
				case 4:
					s_char = s_char + "拾";
					break;
				case 5:
					s_char = s_char + "佰";
					break;
				case 6:
					s_char = s_char + "仟";
					break;
				case 7:
					s_char = s_char + "万";
					flag = true;
					break;
				case 8:
					if (i_flag == 0) {
						s_char = s_char + "拾万";
					} else {
						s_char = s_char + "拾";
					}
					break;
				case 9:
					if (i_flag == 0 && !flag) {
						s_char = s_char + "佰万";
						flag = true;
						// s_char = s_char + "佰";
					} else {
						s_char = s_char + "佰";
					}
					break;
				case 10:
					if (i_flag == 0 && !flag) {
						s_char = s_char + "仟万";
						flag = true;
						// s_char = s_char + "仟";
					} else {
						s_char = s_char + "仟";
					}
					break;
				case 11:
					s_char = s_char + "亿";
				}
				i_flag = 1;
			} else {
				i_flag = 0;
			}
			s_num_hz = s_char + s_num_hz;
		}
		i = s_num_hz.indexOf("零零");
		while (i != -1) {
			s_num_hz = s_num_hz.substring(0, i) + s_num_hz.substring(i + 1);
			i = s_num_hz.indexOf("零零");
		}
		boolean flag2 = false; // 最后一位为零
		if (s_num_hz.substring(s_num_hz.length() - 1).equals("零")) {
			s_num_hz = s_num_hz.substring(0, s_num_hz.length() - 1); // + "整";
			flag2 = true;
		}
		int idx = s_num_hz.indexOf("元");
		if (s_num_hz.substring(idx - 1, idx).equals("零")) {
			s_num_hz = s_num_hz.substring(0, idx - 1) + s_num_hz.substring(idx);
		}
		if (flag2) {
			s_num_hz = s_num_hz + "整";
		}

		if (li_amout_flag == -1) {
			s_num_hz = "负" + s_num_hz;
		}
		return s_num_hz;
	}

	/**
	 * 获得人员在某一年的年龄
	 * 
	 * @param psidcd
	 *            身份证号
	 * @param yearMonth
	 *            计算年龄的年月
	 * @return int 年龄
	 */
	public static int countPersonAge(String psidcd, String yearMonth) {
		// if (SysConstant.PersonIdencod_DefaultIdencod.equals(psidcd)){ //
		// 没有身份证???
		// return 0 ;
		// }
		if (psidcd.trim().length() < 18) { // 身份证位数不对
			return 0;
		}
		String birthYM = psidcd.substring(6, 12);
		return countAge(birthYM, yearMonth);
	}

	/**
	 * 获得人员在某一年的年龄
	 * 
	 * @param birthday
	 *            出生日期 yyyyMMdd
	 * @param yearMonth
	 *            计算年龄的年月
	 * @return int 年龄
	 */
	public static int countPersonAgeByBirthday(String birthday, String yearMonth) {
		if (!isDate(birthday)) {
			return 0;
		}
		String birthYM = birthday.substring(0, 4) + birthday.substring(5, 7);
		return countAge(birthYM, yearMonth);
	}

	/**
	 * 获得人员在某一年的年龄
	 * 
	 * @param birthYM
	 *            出生年月
	 * @param yearMonth
	 *            计算年龄的年月
	 * @return int 年龄
	 */
	public static int countAge(String birthYM, String yearMonth) {
		if (!isYearMonth(birthYM)) {
			return 0;
		}
		if (!isYearMonth(yearMonth)) {
			return 0;
		}
		int age = 0;
		age = (monthsBetweenYM(birthYM, yearMonth)) / 12;
		return age;
	}

	/**
	 * 得到此年的上一个年度
	 * 
	 * @return String 上一个年度
	 * @author 潘 龙
	 */
	public static String last_Year() {
		Date systemDate = new Date();
		String year = CommonUtility.date2Str(systemDate, "yyyy");
		int nowYear = Integer.parseInt(year);
		int lastYear = nowYear - 1;
		String last_Year = String.valueOf(lastYear);
		return last_Year;
	}

	/**
	 * 得到此年的下一个年度
	 * 
	 * @param year
	 *            年度
	 * @return String 下一个年度
	 * @author 潘 龙
	 */
	public static String next_Year(String year) {
		int nowYear = Integer.parseInt(year);
		int nextYear = nowYear + 1;
		String next_Year = String.valueOf(nextYear);
		return next_Year;
	}

	/**
	 * 将多少年多少个月转换为月 1年1月转换为13月
	 * 
	 * @author 潘 龙
	 */
	public static int sumMonth(String yearAndMonth) {
		int flagYear = yearAndMonth.indexOf("年");
		String syear = yearAndMonth.substring(0, flagYear);
		int year = Integer.parseInt(syear);
		int flagMonth = yearAndMonth.indexOf("月");
		String smonth = yearAndMonth.substring(flagYear + 1, flagMonth);
		int month = Integer.parseInt(smonth);
		int sumMonth = month + year * 12;
		return sumMonth;
	}

	/**
	 * 将月转换为多少年多少个月
	 * 
	 * @author 潘 龙
	 */
	public static String yearAndMonth(int month) {
		int year = month / 12;
		int monthTr = month % 12;
		String yearAndMonth = year + "年" + monthTr + "月";
		return yearAndMonth;
	}

	/**
	 * 将月转换为多少岁
	 * 
	 * @author 潘 龙
	 */
	public static String retireAge(int month) {
		int year = month / 12;
		String yearAndMonth = year + "岁";
		return yearAndMonth;
	}

	/**
	 * 将月转换为多少年，18月1.5年
	 * 
	 * @author 潘 龙
	 */
	public static String monthToYear(int month) {
		double year = format1frac(month / 12.0);
		String yearAndMonth = String.valueOf(year) + "年";
		return yearAndMonth;
	}

	/**
	 * 返回两个年度之间的差的值
	 * 
	 * @param String
	 *            startYear格式为yyyy
	 * @param String
	 *            lastYear格式为yyyy
	 * @author 潘 龙
	 */
	public static String bachValue(String startYear, String lastYear) {
		int istartYear = Integer.parseInt(startYear);
		int ilastYear = Integer.parseInt(lastYear);
		int bachValue = istartYear - ilastYear;
		String sbachValue = String.valueOf(bachValue);
		return sbachValue;
	}

	/**
	 * 返回为 12年1月 为13
	 * 
	 * @param month
	 *            int 输入的月数
	 * @return String 有余数就进位的年
	 * @author 潘 龙
	 */
	public static String yearEnter(String smonth) {
		int month = Integer.parseInt(smonth);
		int year = month / 12;
		int residual = month % 12;
		if (residual != 0) {
			year += 1;
		} else {
			year = year;
		}
		String syear = String.valueOf(year);
		return syear;
	}

	/**
	 * 返回对应的代码项 (输入 AAC008,1 返回 在职)
	 * 
	 * @param codeO
	 *            String
	 * @param codeT
	 *            String
	 * @return String
	 */
	public static String getError(String codeO, String codeT) {
		Hashtable hashtable = new Hashtable();
		String codeS = "";
		if (codeO.equals("AAE140")) {
			hashtable.put("1", "基本养老保险");
			hashtable.put("2", "失业保险");
			hashtable.put("3", "基本医疗保险");
			hashtable.put("4", "工伤保险");
			hashtable.put("5", "生育保险");
			hashtable.put("6", "企业补充养老保险");
			hashtable.put("7", "个人储蓄性养老保险");
			hashtable.put("8", "补充医疗保险");
			hashtable.put("9", "公务员医疗补助");
			hashtable.put("10", "重大疾病医疗补助");
			hashtable.put("11", "医疗照顾人员医疗补助");
		}
		if (codeO.equals("AAC008")) {
			hashtable.put("", "全部");
			hashtable.put("1", "在职");
			hashtable.put("2", "退休");
			hashtable.put("3", "一次性退休");
			hashtable.put("4", "终止");
			hashtable.put("5", "待退");
		}
		if (codeO.equals("AIC161")) {
			hashtable.put("1", "离休");
			hashtable.put("2", "退休");
			hashtable.put("3", "退职");
			hashtable.put("4", "病退");
			hashtable.put("5", "特殊工种提前退休");
			hashtable.put("6", "工伤退休");
			hashtable.put("7", "非工残提前退休");
			hashtable.put("8", "军转干部退休");
			hashtable.put("9", "其他");
		}
		if (codeO.equals("AAE145")) {
			hashtable.put("2", "银行");
			hashtable.put("3", "邮局");
			hashtable.put("4", "社保自付");
		}
		if (codeO.equals("AAB051")) {// 单位参保状态
			hashtable.put("0", "未参保");
			hashtable.put("1", "参保缴费");
			hashtable.put("2", "暂停缴费");
			hashtable.put("3", "终止参保");
		}

		codeS = (String) hashtable.get(codeT);
		return codeS;
	}

	public static boolean isUnUniqueSqlException(SQLException e) {
		if (e.getMessage().indexOf("ORA-00001") >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户录入个人编号自动补足前缀构要求的位数（12位）
	 * 
	 * @param aac001
	 *            String 用户录入的个人编号
	 * @param size
	 *            int 要求补足的结果位数（12位）
	 * @param organizeId
	 *            String 机构代码
	 * @return String 补位后的个人编号
	 * @throws Exception
	 */

	public static String getStrAAC001(String aac001, int size, String organizeId) throws Exception {
		/*
		 * 例如： 00212 － 040000000212 00000212 － 040000000212 000000212 －
		 * 000000212 12331000000212 － 12331000000212
		 */
		String retAAC001 = "";
		if (!isEmpty(aac001)) {
			if (aac001.trim().length() > size - 4) { // 超过顺序号位数的不补前缀
				retAAC001 = aac001;
			} else {
				String organId = CommonUtility.subStringByByte(organizeId, 2, 6);
				retAAC001 = CommonUtility.fixPrefixPublic(aac001, 8, "0");
				retAAC001 = organId + retAAC001;
			}
		}
		return retAAC001;
	}

	/**
	 * 根据用户录入单位编号自动补足前缀构要求的位数（11位）
	 * 
	 * @param aab001
	 *            String 用户录入的单位编号
	 * @param size
	 *            int 要求补足的结果位数（11位）
	 * @param organizeId
	 *            String 机构代码
	 * @return String 补位后的单位编号
	 * @throws Exception
	 */
	public static String getStrAAB001(String aab001, int size, String organizeId) throws Exception {
		/*
		 * 例如： 212 － 10400000212 000212 － 10400000212 000000212 － 000000212
		 * 12331000000212 － 12331000000212
		 */
		String retAAB001 = "";
		if (!isEmpty(aab001)) {
			if (aab001.trim().length() > size - 5) {
				retAAB001 = aab001;
			} else {
				String organId = CommonUtility.subStringByByte(organizeId, 1, 6);
				retAAB001 = CommonUtility.fixPrefixPublic(aab001, 6, "0");
				retAAB001 = organId + retAAB001;
			}
		}
		return retAAB001;
	}

	/**
	 * 给字串加上前缀（按字符给编号填补值）
	 * 
	 * @param srcStr
	 *            需要加入前缀的字串
	 * @param length
	 *            返回字串总长度
	 * @param fixChar
	 *            前缀字符
	 * @return String 加上前缀后的字串
	 */
	public static String fixPrefixPublic(String srcStr, int length, String fixChar) throws Exception {
		StringBuffer sb = new StringBuffer(length);
		if (isNull(srcStr)) {
			srcStr = "";
		} else {
			int size = srcStr.length();
			if (size > length) {
				srcStr = srcStr.substring((size - length), size);
			} else {
				for (int i = 0; i < length - srcStr.length(); i++) {
					sb.append(fixChar);
				}
			}
		}
		return new String(sb) + srcStr;
	}

	/**
	 * 日期转换为时间的函数 用于按照日期查找时间范围
	 * 
	 * @param date
	 *            String
	 * @return String
	 * @throws Exception
	 */
	public static String getDateStartTime(String date) {
		if (date != null) {
			return date + " 00:00:00";
		} else {
			return date;
		}
	}

	/**
	 * 根据输入年月得到该季度所有的月份
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM-dd
	 * @return String yyyy-MM-dd
	 */

	public static ArrayList getQuarterMonths(String yearMonth) {
		ArrayList monthsList = new ArrayList();
		int year = new Integer(yearMonth.substring(0, 4)).intValue();
		int month = new Integer(yearMonth.substring(5, 7)).intValue();
		String startYm = "" + year + "-";
		if (month >= 1 && month <= 3) {
			monthsList.add(year + "01");
			monthsList.add(year + "02");
			monthsList.add(year + "03");
		} else if (month >= 4 && month <= 6) {
			monthsList.add(year + "04");
			monthsList.add(year + "05");
			monthsList.add(year + "06");

		} else if (month >= 7 && month <= 9) {
			monthsList.add(year + "07");
			monthsList.add(year + "08");
			monthsList.add(year + "09");

		} else if (month >= 10 && month <= 12) {
			monthsList.add(year + "10");
			monthsList.add(year + "11");
			monthsList.add(year + "12");

		}
		return monthsList;
	}

	/**
	 * 根据输入年月得到该年月的包含第一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM-dd
	 * @return String yyyy-MM-dd
	 */
	public static String getQuarterFirstDay2(String yearMonth) {
		int year = new Integer(yearMonth.substring(0, 4)).intValue();
		int month = new Integer(yearMonth.substring(5, 7)).intValue();
		String startYm = "" + year + "-";
		if (month >= 1 && month <= 3) {
			startYm = startYm + "01";
		} else if (month >= 4 && month <= 6) {
			startYm = startYm + "04";
		} else if (month >= 7 && month <= 9) {
			startYm = startYm + "07";
		} else if (month >= 10 && month <= 12) {
			startYm = startYm + "10";
		}

		return getYmFirstDay2(startYm);
	}

	/**
	 * 根据输入年月得到该年月的包含最后一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM-dd
	 * @return String yyyy-MM-dd
	 */
	public static String getQuarterLastDay2(String yearMonth) {
		int year = new Integer(yearMonth.substring(0, 4)).intValue();
		int month = new Integer(yearMonth.substring(5, 7)).intValue();
		String startYm = "" + year + "-";
		if (month >= 1 && month <= 3) {
			startYm = startYm + "01";
		} else if (month >= 4 && month <= 6) {
			startYm = startYm + "04";
		} else if (month >= 7 && month <= 9) {
			startYm = startYm + "07";
		} else if (month >= 10 && month <= 12) {
			startYm = startYm + "10";
		}
		return getYmEndDay2(startYm);
	}

	/**
	 * 根据输入年月得到该年第一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM-dd
	 * @return String yyyy-MM-dd
	 */
	public static String getYearFirstDay(String yearMonth) {
		String year = yearMonth.substring(0, 4);
		String month = "01";
		String day = "01";
		return year + "-" + month + "-" + day;
	}

	/**
	 * 根据输入年月得到该年的最后一天的String型日期
	 * 
	 * @param yearMonth
	 *            年月yyyy-MM-dd
	 * @return String yyyy-MM-dd
	 */
	public static String getYearLastDay(String yearMonth) {
		String year = yearMonth.substring(0, 4);
		String month = "12";
		String day = "31";
		return year + "-" + month + "-" + day;

	}

	/**
	 * 日期转换为时间的函数 用于按照日期查找时间范围
	 * 
	 * @param date
	 *            String
	 * @return String
	 * @throws Exception
	 */
	public static String getDateStopTime(String date) {
		if (date != null) {
			return date + " 23:59:59";
		} else {
			return date;
		}
	}

	public static String getSimpleDateStr(String datestr) {
		if (datestr != null) {
			return datestr.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
		} else {
			return datestr;
		}
	}

	public static String addMethod(char[] add1, char[] add2) { // BigInteger相加方法
		int len1 = add1.length;
		int len2 = add2.length;
		System.out.println("The length of add1 is : " + len1);
		System.out.println("The length of add2 is : " + len2);
		int len = Math.max(len1, len2);
		int i;
		char[] temp1 = new char[len];
		char[] temp2 = new char[len];

		char[] result = new char[len + 1];

		for (i = 0; i < len1; i++) {
			temp1[len - 1 - i] = add1[len1 - 1 - i];
		}
		for (i = 0; i < len2; i++) {
			temp2[len - 1 - i] = add2[len2 - 1 - i];
		}

		int m = 0;
		for (i = 0; i < len; i++) { // 相加
			if (temp1[len - 1 - i] != 0) {
				temp1[len - 1 - i] -= 48;
			}
			if (temp2[len - 1 - i] != 0) {
				temp2[len - 1 - i] -= 48;
			}
			m = temp1[len - 1 - i] + temp2[len - 1 - i];
			if (m >= 10) {
				m -= 10;
				result[len - i] += m;
				result[len - 1 - i] += 1;
			} else {
				result[len - i] += m;
			}
		}
		System.out.print("add1 + add2 = "); // 输出相加结果
		i = 0;
		if (result[0] == 0) {
			i = 1;
		}
		StringBuffer sb = new StringBuffer();
		for (; i < len + 1; i++) {
			System.out.print(Integer.toString(result[i]));
			sb.append(Integer.toString(result[i]));
		}
		return sb.toString();
	}

	/**
	 * 长整形数字的加法
	 * 
	 * @param str1
	 *            String 第一个数字，不能为空必须是数字
	 * @param str2
	 *            String 第二个数字，不能为空必须是数字
	 * @return String 返回相加结果
	 */
	public static String addBigInteger(String str1, String str2) {
		int i = 0;
		char[] num1 = new char[str1.length()];
		char[] num2 = new char[str2.length()];
		for (; i < str1.length(); i++) {
			num1[i] = str1.charAt(i);
		}
		for (i = 0; i < str2.length(); i++) {
			num2[i] = str2.charAt(i);
		}
		return addMethod(num1, num2);
	}

	/**
	 * 长整形数字的减法
	 * 
	 * @param str1
	 *            String 第一个数字，不能为空必须是数字
	 * @param str2
	 *            String 第二个数字，不能为空必须是数字
	 * @return String 返回相减结果（str1>str2为正数，str1<str2为负数）
	 */
	public static String subMethod(char[] sub1, char[] sub2) { // BigInteger相减方法
		int len1 = sub1.length;
		int len2 = sub2.length;
		System.out.println("The length of add1 is : " + len1);
		System.out.println("The length of add2 is : " + len2);
		int len = Math.max(len1, len2);
		int i;
		char[] temp1 = new char[len];
		char[] temp2 = new char[len];
		char[] result = new char[len + 1];

		if (len1 > len2) {
			for (i = 0; i < len1; i++) {
				temp1[len - 1 - i] = sub1[len1 - 1 - i];
			}
			for (i = 0; i < len2; i++) {
				temp2[len - 1 - i] = sub2[len2 - 1 - i];
			}
		} else { // 保证减数大于被减数
			for (i = 0; i < len1; i++) {
				temp2[len - 1 - i] = sub1[len1 - 1 - i];
			}
			for (i = 0; i < len2; i++) {
				temp1[len - 1 - i] = sub2[len2 - 1 - i];
			}
		}

		int m = 0;
		for (i = 0; i < len; i++) { // 相减
			if (temp1[len - 1 - i] != 0) {
				temp1[len - 1 - i] -= 48;
			}
			if (temp2[len - 1 - i] != 0) {
				temp2[len - 1 - i] -= 48;
			}
			m = temp1[len - 1 - i] - temp2[len - 1 - i];
			if (m < 0) { // 如果计算的那一位的减数小于被减数那么相前一位借10
				m += 10;
				result[len - i] += m;
				temp1[len - 1 - i] -= 1;
			} else {
				result[len - i] += m;
			}
		}
		System.out.print("add1 - add2 = "); // 输出减法结果
		i = 0;
		while (result[i] == 0) {
			i++;
		}
		StringBuffer sb = new StringBuffer();

		if ((len2 > len1) || (len1 == len2 && sub1[0] < sub2[0])) {
			System.out.print("-");
			sb.append("-");
		}
		for (; i < len + 1; i++) {
			System.out.print(Integer.toString(result[i]));
			sb.append(Integer.toString(result[i]));
		}
		return sb.toString();
	}

	/**
	 * 取两个数中小的那个
	 * 
	 * @param number1
	 *            double
	 * @param number2
	 *            double
	 * @return double
	 * @throws Exception
	 */
	public static double getMinNumber(double number1, double number2) throws Exception {
		double minnumber = 0;

		if (number1 > number2) {
			minnumber = number2;
		} else {
			minnumber = number1;
		}
		return minnumber;
	}

	/**
	 * 取两个数中大的那个
	 * 
	 * @param number1
	 *            double
	 * @param number2
	 *            double
	 * @return double
	 * @throws Exception
	 */
	public static double getMaxNumber(double number1, double number2) throws Exception {
		double maxnumber = 0;

		if (number1 > number2) {
			maxnumber = number2;
		} else {
			maxnumber = number1;
		}
		return maxnumber;
	}

	/**
	 * 判断是否是字母
	 * 
	 * @param ascii
	 *            int
	 * @return boolean
	 */
	private static boolean isAlphabet(int ascii) {
		if (ascii > 0 && ascii < 160) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 如参为0时，返回0 否则返回param1
	 * 
	 * @param param1
	 *            String
	 * @return double
	 */
	public static double getISZero(double param1) {
		if (param1 != 0.0) {
			return param1;
		} else {
			return 0.0;
		}
	}

	/**
	 * 得到上个月的最后一天
	 * 
	 * @return String @
	 */
	public static String getLastMonth() {
		Calendar cal = Calendar.getInstance(); // 当前日期
		cal.set(Calendar.DATE, 1); // 设为当前月的1号
		cal.add(Calendar.DATE, -1); // 减一天，变为上月最后一天

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.format(cal.getTime());

		return simpleDateFormat.format(cal.getTime());
	}

	/**
	 * 计算指定年月的前后的年月
	 * 
	 * @param yearMon
	 *            传入年月
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String relayYM22(String yearMon, int relayMons) {
		String newYM = "";
		String ymStyleStr = "yyyyMM";
		try {
			newYM = date2Str(dateAdd(str2Date(yearMon, ymStyleStr), java.util.GregorianCalendar.MONTH, relayMons),
					ymStyleStr);
		} catch (Exception e) {
		}
		return newYM;
	}

	/**
	 * 计算指定年月日的前后的年月
	 * 
	 * @param yearMon
	 *            传入年月
	 * @param relayMons
	 *            增加、减少的月数
	 * @return String 返回新的年月
	 */
	public static String relayYMDate2(String yearMonDay, int relayMonth) {
		String newYMD = "";
		try {
			newYMD = date2Str(
					dateAdd(str2Date(yearMonDay, dateStyleStr), java.util.GregorianCalendar.MONTH, relayMonth),
					dateStyleStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newYMD;
	}

	public static String toUppercase(String strSource) {
		String strChanged = "";
		strChanged = strSource.toUpperCase();
		return strChanged;
	}

	/**
	 * 比对时间大小--zq
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare_date_1(String date1, String date2, String date3) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d1 = df.parse(date1);
			java.util.Date d2 = df.parse(date2);
			java.util.Date d3 = df.parse(date3);
			if (d1.getTime() <= d2.getTime() && d2.getTime() < d3.getTime()) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比对时间大小--zq
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare_date(String date1, String date2, String date3) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d1 = df.parse(date1);
			java.util.Date d2 = df.parse(date2);
			java.util.Date d3 = df.parse(date3);
			if (d1.getTime() <= d2.getTime() && d2.getTime() <= d3.getTime()) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 给定日期,返回该日期历史最近周日的日期
	 * 
	 * @param String
	 *            date 日期yyyy-MM-dd
	 * @return String 历史最近周日的日期yyyy-MM-dd
	 * @author 李 健
	 */
	public static String datetimeAddHour(String datetime, int hour) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		String rtn = "";
		try {
			date = sdf.parse(datetime);
			Calendar ca = Calendar.getInstance();
			ca.setTime(date);
			ca.add(Calendar.HOUR_OF_DAY, hour);
			rtn = sdf.format(ca.getTime());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rtn;
	}

	/**
	 * 将日期以给定的偏移量增加或减少
	 * 
	 * @param String
	 *            date 日期yyyy-MM-dd
	 * @param int
	 *            i 偏移量
	 * @return String 日期yyyy-MM-dd
	 * @author 李 健
	 */
	public static String getDateByOffset(String date, int m) {
		String rDate = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, m);
		rDate = df.format(c.getTime());
		return rDate;
	}

	/**
	 * 计算指定年月日的前后的天数
	 * 
	 * @param yearMonDay
	 *            传入年月日
	 * @param relayDay
	 *            天数
	 * @return String 返回新的年月日
	 */
	public static String addYMD(String yearMonDay, int relayDay) {
		String newYMD = "";
		try {
			newYMD = date2Str(dateAdd(str2Date(yearMonDay, dateStyleStr), java.util.GregorianCalendar.DATE, relayDay),
					dateStyleStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newYMD;
	}

	/**
	 * 返回日期是星期几
	 * 
	 * @param startDate
	 *            日期
	 * @param format
	 *            转换格式：yyyy-MM-dd
	 * @return int 星期
	 */
	public static String dateofweek2(String sdate, String format) {

		String week = "";

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(str2Date(sdate, format));

		int date = calendar.get(calendar.DAY_OF_WEEK);

		switch (date) {
		case 1:
			week = "0";
			break;
		case 2:
			week = "1";
			break;
		case 3:
			week = "2";
			break;
		case 4:
			week = "3";
			break;
		case 5:
			week = "4";
			break;
		case 6:
			week = "5";
			break;
		case 7:
			week = "6";
			break;

		}
		return week;

	}

	/**
	 * 险种集合
	 * 
	 * @return boolean
	 */
	public static ArrayList getAAE140() {
		ArrayList aae140List = new ArrayList();
		PM_AC01 pm_ac01_2 = new PM_AC01();
		pm_ac01_2.setAAE140("2");
		aae140List.add(pm_ac01_2);
		PM_AC01 pm_ac01_3 = new PM_AC01();
		pm_ac01_3.setAAE140("3");
		aae140List.add(pm_ac01_3);
		PM_AC01 pm_ac01_4 = new PM_AC01();
		pm_ac01_4.setAAE140("4");
		aae140List.add(pm_ac01_4);
		PM_AC01 pm_ac01_5 = new PM_AC01();
		pm_ac01_5.setAAE140("5");
		aae140List.add(pm_ac01_5);
		return aae140List;
	}

	/**
	 * 获得一个UUID
	 * 
	 * @return String uuid
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	/**
	 * 将String 类型转换为date.后格式化后输�?
	 * 
	 * @param str
	 * @return
	 */
	public static String dataformat(String str) {
		String returnStr = "";
		try {
			if (isNull(str)) {
				return "";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = sdf.parse(str);
			returnStr = date2Str(date, "yyyyMMdd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnStr;
	}

	public static String getBAE941() {

		return GenerateSequenceUtil.generateSequenceNo();

	}

	public static String getSAA036() {

		return GenerateSequenceUtil.generateSequenceNo();

	}

	public static String getAAE140Name(String value) {

		String aae140Name = "";
		if (CodeConstant.AAE140_AAE140_3.equals(value)) {
			aae140Name = "基本医疗保险";
		} else if (CodeConstant.AAE140_AAE140_4.equals(value)) {
			aae140Name = "工伤保险";
		} else if (CodeConstant.AAE140_AAE140_5.equals(value)) {
			aae140Name = "生育保险";
		} else if (CodeConstant.AAE140_AAE140_8.equals(value)) {
			aae140Name = "补充医疗保险保险";
		} else if (CodeConstant.AAE140_AAE140_9.equals(value)) {
			aae140Name = "公务员医疗补助";
		} else if (CodeConstant.AAE140_AAE140_10.equals(value)) {
			aae140Name = "大额医疗补助";
		} else if (CodeConstant.AAE140_AAE140_390.equals(value)) {
			aae140Name = "城镇居民基本医疗保险";
		}
		return aae140Name;
	}

	public static String getAAE143Name(String value) {

		String aae143Name = "";
		if (CodeConstant.AAE143_AAE143_1.equals(value)) {
			aae143Name = "正常应缴记录";
		} else if (CodeConstant.AAE143_AAE143_2.equals(value)) {
			aae143Name = "补收记录";
		} else if (CodeConstant.AAE143_AAE143_3.equals(value)) {
			aae143Name = "按项目缴费";
		} else if (CodeConstant.AAE143_AAE143_13.equals(value)) {
			aae143Name = "补基数";
		} else if (CodeConstant.AAE143_AAE143_19.equals(value)) {
			aae143Name = "一次性补收记录";
		} else if (CodeConstant.AAE143_AAE143_23.equals(value)) {
			aae143Name = "特殊补收";
		}

		return aae143Name;
	}

	/**
	 * 获取list中指定的数据
	 *
	 * @param pageNo
	 *            第几页
	 * @param count
	 *            总记录数
	 * @param pageSize
	 *            每页显示条数
	 * @param last
	 *            最后一页的页码
	 * @param list
	 *            总数据
	 * @return
	 */
	public static List subPage(int pageNo, int count, int pageSize, int last, List list) {

		last = (count + pageSize - 1) / pageSize;
		if (last < 1) {
			last = 1;
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo > last) {
			pageNo = last;
		}
		List returnList = new ArrayList();
		int begin = (pageNo - 1) * pageSize;
		int maxSize = begin + pageSize;

		if (maxSize < count) {
			returnList = list.subList(begin, maxSize);
		} else {
			returnList = list.subList(begin, count);
		}

		return returnList;
	}
}
