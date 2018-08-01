package com.thinkgem.jeesite.modules.nwws.valueobject;

import java.io.Serializable;
import java.util.ArrayList;
import com.thinkgem.jeesite.modules.nwws.entity.PersonBasicInfo;
import lss.nw_ws.valueobject.PM_AC01View;

/**
 * <p>
 * Title: AC01表的数据接口转换，用于WEBService调用与平台间的数据转换
 * </p>
 * 
 * <p>
 * Description: AC01表的数据接口转换，用于WEBService调用与平台间的数据转换
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2006 PANSKY
 * </p>
 * 
 * <p>
 * Company: 长天科技集团(PANSKY)
 * </p>
 * 
 * @author 徐鹏
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class PM_AC01Transfer implements Serializable {
	private static final long serialVersionUID = 1L;

	public PM_AC01Transfer() {
	}

	public static PersonBasicInfo getValueObject(PM_AC01View view) {
		PersonBasicInfo VO = new PersonBasicInfo();
		// PM_AC01表
		VO.setBaa001(view.getBAA001());
		VO.setBac808(view.getBAC808());
		VO.setAac002(view.getAAC002());
		VO.setAac003(view.getAAC003());
		VO.setAac004(view.getAAC004());
		VO.setAac005(view.getAAC005());
		VO.setAac006(view.getAAC006());
		VO.setBic701(view.getBIC701());
		VO.setAac007(view.getAAC007());
		VO.setAae005(view.getAAE005());
		VO.setAae006(view.getAAE006());
		VO.setAae007(view.getAAE007());
		VO.setAac009(view.getAAC009());
		VO.setAac010(view.getAAC010());
		VO.setAac011(view.getAAC011());
		VO.setAac012(view.getAAC012());
		VO.setAac013(view.getAAC013());
		VO.setAac014(view.getAAC014());
		VO.setBac521(view.getBAC521());
		VO.setAac015(view.getAAC015());
		VO.setAac019(view.getAAC019());
		VO.setAac020(view.getAAC020());
		VO.setAae011(view.getAAE011());
		VO.setAae036(view.getAAE036());
		VO.setBaa008(view.getBAA008());
		VO.setAac008(view.getAAC008());
		VO.setAkc021(view.getAKC021());
		VO.setAkc401(view.getAKC401());
		VO.setBkc281(view.getBKC281());
		VO.setBaa009(view.getBAA009());
		VO.setBaa010(view.getBAA010());
		VO.setAab024(view.getAAB024());
		VO.setAab025(view.getAAB025());
		VO.setAab026(view.getAAB026());
		VO.setAac017(view.getAAC017());
		VO.setBac503(view.getBAC503());
		VO.setBac515(view.getBAC515());
		VO.setBac508(view.getBAC508());
		VO.setBac801(view.getBAC801());
		VO.setBac802(view.getBAC802());
		VO.setBac803(view.getBAC803());
		VO.setBic802(view.getBIC802());
		VO.setAab060(view.getAAB060());
		VO.setAae013(view.getAAE013());
		VO.setBac501(view.getBAC501());
		VO.setBac502(view.getBAC502());
		VO.setBac511(view.getBAC511());
		VO.setBac809(view.getBAC809());
		VO.setAab034(view.getAAB034());
		VO.setAac058(view.getAAC058());
		VO.setAac121(view.getAAC121());
		VO.setAac122(view.getAAC122());
		VO.setTae100(view.getTAE100());
		VO.setAac040(view.getAAC040());

		return VO;
	}

	public static PM_AC01View getView(PersonBasicInfo VO) {
		PM_AC01View view = new PM_AC01View();
		view.setBAA001(VO.getBaa001());
		view.setBAC808(VO.getBac808());
		view.setAAC002(VO.getAac002());
		view.setAAC003(VO.getAac003());
		view.setAAC004(VO.getAac004());
		view.setAAC005(VO.getAac005());
		view.setAAC006(VO.getAac006());
		view.setBIC701(VO.getBic701());
		view.setAAC007(VO.getAac007());
		view.setAAE005(VO.getAae005());
		view.setAAE006(VO.getAae006());
		view.setAAE007(VO.getAae007());
		view.setAAC009(VO.getAac009());
		view.setAAC010(VO.getAac010());
		view.setAAC011(VO.getAac011());
		view.setAAC012(VO.getAac012());
		view.setAAC013(VO.getAac013());
		view.setAAC014(VO.getAac014());
		view.setBAC521(VO.getBac521());
		view.setAAC015(VO.getAac015());
		view.setAAC019(VO.getAac019());
		view.setAAC020(VO.getAac020());
		view.setAAE011(VO.getAae011());
		view.setBAA001(VO.getBaa001());
		view.setAAE036(VO.getAae036());
		view.setBAA008(VO.getBaa008());
		view.setBAA009(VO.getBaa009());
		view.setBAA010(VO.getBaa010());
		view.setAAB024(VO.getAab024());
		view.setAAB025(VO.getAab025());
		view.setAAB026(VO.getAab026());
		view.setAAC017(VO.getAac017());
		view.setBAC503(VO.getBac503());
		view.setBAC515(VO.getBac515());
		view.setBAC508(VO.getBac508());
		view.setBAC801(VO.getBac801());
		view.setBAC802(VO.getBac802());
		view.setBAC803(VO.getBac803());
		view.setBIC802(VO.getBic802());
		view.setAAB060(VO.getAab060());
		view.setAAE013(VO.getAae013());
		view.setBAC501(VO.getBac501());
		view.setBAC502(VO.getBac502());
		view.setBAC511(VO.getBac511());
		view.setBAC809(VO.getBac809());
		view.setAAB034(VO.getAab034());
		view.setAAC058(VO.getAac058());
		view.setAAC121(VO.getAac121());
		view.setAAC122(VO.getAac122());
		view.setTAE100(VO.getTae100());
		view.setAAC040(VO.getAac040());
		return view;
	}

	public static ArrayList ArrayToVOList(PM_AC01View[] viewArray) {
		ArrayList resList = new ArrayList();
		for (int i = 0; i < viewArray.length; i++) {
			resList.add(getValueObject(viewArray[i]));
		}
		return resList;
	}

	public static PM_AC01View[] ListToViewArray(ArrayList VOList) {
		PM_AC01View[] res = new PM_AC01View[VOList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = getView((PersonBasicInfo) VOList.get(i));
		}
		return res;
	}
}
