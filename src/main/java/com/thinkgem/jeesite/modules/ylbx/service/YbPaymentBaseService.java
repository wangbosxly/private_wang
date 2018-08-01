package com.thinkgem.jeesite.modules.ylbx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

/**
 * 描述:
 * 缴费基数申报service
 *
 * @author X_P
 * @create 2018-07-03 16:58
 */
@Service
@Transactional
public class YbPaymentBaseService {


    @Autowired
    private Nw_wsPort ybPort;

    /**
     * 保存基数
     * @param ybPersons
     * @return
     * @throws RemoteException
     */
    public JSONObject save(List<YbPerson> ybPersons) throws RemoteException {
        String str = JSONObject.toJSONString(ybPersons,new PascalNameFilter());
        JSONArray array = JSONObject.parseArray(str);
        JSONArray jsonArray = new JSONArray();
        User user = UserUtils.getUser();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();
        for (Object o : array) {
            JSONObject json = (JSONObject) o;
            if(StringUtils.isEmpty(json.getString("AAC001"))){
                continue;
            }
            // 获取用户信息
            json.put("SAA036",saa036);  //SAA036	受理单ID	VARCHAR2(20)	N
            json.put("SAA004"," ");  //SAA004	事项ID	VARCHAR2(20)	N
            json.put("SAA015","M3006");  //SAA015	功能ID	VARCHAR2(5)	固定为M3006
            json.put("BAE702","1");  //BAE702	主体类型（1 单位)	VARCHAR2(3)	固定为1
            json.put("BAE703",user.getYbBAE703());  //BAE703	主体编号	VARCHAR2(20)	N
            json.put("SAA043","3");  //SAA043	业务状态（3 未受理，6已受理）	VARCHAR2(3)	固定为3
            json.put("SAA037",user.getYbAAE170());  //SAA037	申请人	VARCHAR2(20)	N
            json.put("SAA038", CommonUtility.get19BitCurTimeAPP());  //SAA038	申请时间	VARCHAR2(19)	N
            json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//BAE941	申报流水号	VARCHAR2(32)	N
            json.put("AAE011",user.getYbAAE170());  //AAE011	经办人        	VARCHAR2(50)	N
            json.put("AAE036",CommonUtility.get19BitCurTimeAPP());  //AAE036	经办时间	VARCHAR2(19)	N
            json.put("TAA101",CommonUtility.get19BitCurTimeAPP());  //TAA101	申报时间	VARCHAR2(19)	N
            json.put("TAA103","0");  //TAA103	审核结果（0 待审核）	VARCHAR2(3)	固定为0
            json.put("TAA105","1");  //TAA105	申报来源（1 网上大厅）   	VARCHAR2(3)	固定为1
            json.put("AAE140","3");  //AAE140	险种	VARCHAR2(3)	N
            json.put("AAB001",user.getYbAAB001());  //AAB001	单位编号	VARCHAR2(15)	N
            json.put("AAE030",String.valueOf(Calendar.getInstance().getWeekYear()));  //AAE030	开始年月	VARCHAR2(6)	N
            jsonArray.add(json);
        }
        return JSONObject.parseObject(ybPort.nwws2302 (jsonArray.toString()));
    }
}