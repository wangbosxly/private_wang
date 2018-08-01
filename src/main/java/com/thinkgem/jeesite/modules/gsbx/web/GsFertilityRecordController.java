package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsFertilityRecord;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.gsbx.service.GsFertilityRecordService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 生育信息备案
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsFertilityRecord")
public class GsFertilityRecordController extends BaseController {
    @Autowired
    Nw_wsPort gsPort;

    @Autowired
    GsFertilityRecordService gsFertilityRecordService;

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model, GsFertilityRecord gsFertilityRecord) {
        model.addAttribute("gsFertilityRecord",gsFertilityRecord);
        return "/modules/gsbx/gsFertilityRecordFormt";
    }

    @RequestMapping(value = "info",method = RequestMethod.POST)
    public String info(Model model, GsFertilityRecord gsFertilityRecord,HttpSession session) {
        // 人员参保信息查询
        JSONObject json = null;
        try {
            json = gsFertilityRecordService.findPersonInfo(gsFertilityRecord);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (super.validateGsJSON(json,model,"未参加生育保险")) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsFertilityRecord> gsFertilityRecords = JSONObject.parseArray(array.toString(), GsFertilityRecord.class);
            //判断是否参加生育保险
            model.addAttribute("ctype", "error");
            for (GsFertilityRecord fertilityRecord : gsFertilityRecords) {
                if("5".equals(fertilityRecord.getAAE140())){
                    model.addAttribute("flag", "true");
                    gsFertilityRecord.setAAC001(gsFertilityRecords.get(0).getAAC001());
                    findGsFertilityRecord(model, gsFertilityRecord,session);
                }
            }
            model.addAttribute("infoList", gsFertilityRecords);
        }
        model.addAttribute("gsFertilityRecord",gsFertilityRecord);
        return "/modules/gsbx/gsFertilityRecordFormt";
    }

    /**
     * 查询人员生育备案信息
     * 历史信息
     */
    @RequestMapping(value = "find",method = RequestMethod.POST)
    public String findGsFertilityRecord(Model model, GsFertilityRecord gsFertilityRecord,HttpSession session) {
        // 人员生育备案信息查询
        JSONObject json = null;
        try {
            json =  gsFertilityRecordService.findByAAC001(gsFertilityRecord.getAAC001());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"人员生育备案信息查询成功")) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsFertilityRecord> gsFertilityRecords = JSONObject.parseArray(array.toString(), GsFertilityRecord.class);
            session.setAttribute("gsFertilityRecords",gsFertilityRecords);
            model.addAttribute("infoListLs", gsFertilityRecords);
        }
        model.addAttribute("gsFertilityRecord",gsFertilityRecord);
        return "/modules/gsbx/gsFertilityRecordFormt";
    }

    /**
     * 提交生育备案
     * @param model
     * @param gsFertilityRecord
     * @return
     */
    @RequestMapping(value = "submit",method = RequestMethod.POST)
    public String submit(Model model, GsFertilityRecord gsFertilityRecord) {
        try {
            JSONObject jsonObject = gsFertilityRecordService.save(gsFertilityRecord);
            super.validateGsJSON(jsonObject,model,"人员生育信息备案成功");
            form(model, gsFertilityRecord);
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(model, "工伤生育保险接口调用失败");
        }
        return "/modules/gsbx/gsFertilityRecordFormt";
    }

    /**
     * 打印生育卡
     */
    @RequestMapping("download")
    public void download(String AMC087, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        List<GsFertilityRecord> gsFertilityRecords = (List<GsFertilityRecord>) session.getAttribute("gsFertilityRecords");
        for (GsFertilityRecord gsFertilityRecord : gsFertilityRecords) {

            if(AMC087!=null&&AMC087.equals(gsFertilityRecord.getAMC087())){
                Date date = DateUtils.parseDate(AMC087);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                String year = String.valueOf(c.getWeekYear());
                String month = String.valueOf(c.get(Calendar.MONTH)+1);
                String str = JSONObject.toJSONString(gsFertilityRecord, new PascalNameFilter());
                JSONObject jsonObject = JSONObject.parseObject(str);
                jsonObject.put("year", year);
                jsonObject.put("month", month);
                jsonObject.put("AAB004", UserUtils.getUser().getGsAAB004());
                jsonObject.put("AAC005", DictUtils.getDictLabels(jsonObject.getString("AAC005"),"AAC005_5",""));
                try {
                    PostHelperUtils.printPDF(jsonObject,"/WEB-INF/jasper/GSZGSY.jasper",jsonObject.getString("AAC002")+"SY.pdf",request,response);
                   //PostHelperUtils.exportGSZGSYPdf(jsonObject,request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
