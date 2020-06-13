package example.controller;
import example.converter.Converter;
import example.pojo.Message.Msg.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import example.service.MessageService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // {target=to, sender=test_usr, title=title, main-text=text }
    @RequestMapping(value="/chat/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendChat(@RequestBody Map<String, Object> chat) {
        messageService.sendChat(new Chat(chat));
    }


    @RequestMapping(value="/chat/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findChatNum(String username, String function) {
        return messageService.findChatNum(username);
    }

    @RequestMapping(value="/chat/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findChatPage(String username, String function, int page) {
        List<Map<String, Object>> list = new LinkedList<>();
        List<Chat> chats = messageService.findChatPage(username, page);

        for (Chat chat : chats)
            list.add(chat.toMapPart());
        return list;
    }

    @RequestMapping(value="/chat/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findChatContent(String username, int page, int num) {
        return messageService.findChatContent(username, page, num).toMap();
    }

    /*
    {user=HLSSSS, pwd=123, roles=Main, invite-code=}
    {user=HLSSSS, pwd=123, roles=Info, invite-code=}
    {user=HLSSSS, pwd=123, roles=Area, invite-code=}
    {user=HLSSSS, pwd=123, roles=Commercial, invite-code=}
    {user=HLSSSS, pwd=123, roles=Doctor, invite-code=}
    {user=HLSSSS, pwd=123, roles=Medical, invite-code=}
    */
    @RequestMapping(value="/invite/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendInviteCode(@RequestBody Map<String, Object> invite) {
        messageService.sendInviteCode(new invite_code(invite));
    }

    // {user=HLSSSS, pwd=123, phonenum=1392361111, email=75066808@qq.com, province=Fujian, address=china, community-name=fff, reason=reason, invite-code=2222, time=forever}
    // {user=HLSSSS, pwd=123, phonenum=, email=, province=Anhui, address=, community-name=, reason=, invite-code=, time=one-month}
    @RequestMapping(value="/apply/community/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCommunityAdminApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendCommunityAdminApply(new apply_community(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/commercial/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCommercialAdminApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendCommercialAdminApply(new apply_commerical(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=2222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/medical/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendMedicalAdminApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendMedicalAdminApply(new Apply_medical_admin(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/information/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendInformationAdminApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendInformationAdminApply(new Apply_info(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/super/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendSuperAdminApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendSuperAdminApply(new Apply_main(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/doctor/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendDoctorApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendDoctorApply(new apply_doctor(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, community=cc, reason=res, time=forever}
    @RequestMapping(value="/apply/citizen/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCitizenApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendCitizenApply(new Apply_citizen(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, time=forever}
    @RequestMapping(value="/apply/merchant/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendMerchantApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendMerchatApply(new Apply_business(apply)))
            return "success";
        else
            return "fail";
    }

    // {user=HLSSSS, pwd=123, business-district=bbb, shop-name=ffff, reason=ccc, time=forever}
    @RequestMapping(value="/apply/opening/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendOpeningApply(@RequestBody Map<String, Object> apply) {
        if (messageService.sendOpeningApply(new Apply_opening(apply)))
            return "success";
        else
            return "fail";
    }


    /*type
        Main Admin application
        Commercial Admin application
        Info Admin application
        Medical Admin application
        Area Admin application
        Doctor application
     */
    @RequestMapping(value="/apply/role/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findRoleApplyNum(String username, String function, @RequestParam(value="form-type") String type) {
        switch(type) {
            case "Main Admin application":
                return messageService.findMainApplyNum(username);
            case "Commercial Admin application":
                return messageService.findCommercialApplyNum(username);
            case "Info Admin application":
                return messageService.findInfoApplyNum(username);
            case "Medical Admin application":
                return messageService.findMedicalApplyNum(username);
            case "Area Admin application":
                return messageService.findCommunityApplyNum(username);
            case "Doctor application":
                return messageService.findDoctorApplyNum(username);
            default:
                return 0;
        }
    }

    @RequestMapping(value="/apply/role/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findRoleApplyPage(String username, String function, @RequestParam(value="form-type") String type, int page) {
        List<Map<String, Object>> list = new LinkedList<>();
        switch(type) {
            case "Main Admin application":
                List<Apply_main> mains = messageService.findMainApplyPage(username, page);
                for (Apply_main main : mains)
                    list.add(main.toMapPart());
                return list;
            case "Commercial Admin application":
                List<apply_commerical> commericals = messageService.findCommercialApplyPage(username, page);
                for (apply_commerical commerical : commericals)
                    list.add(commerical.toMapPart());
                return list;
            case "Info Admin application":
                List<Apply_info> infos = messageService.findInfoApplyPage(username, page);
                for (Apply_info info : infos)
                    list.add(info.toMapPart());
                return list;
            case "Medical Admin application":
                List<Apply_medical_admin> medicals = messageService.findMedicalApplyPage(username, page);
                for (Apply_medical_admin medical : medicals)
                    list.add(medical.toMapPart());
                return list;
            case "Area Admin application":
                List<apply_community> communities = messageService.findCommunityApplyPage(username, page);
                for (apply_community community : communities)
                    list.add(community.toMapPart());
                return list;
            case "Doctor application":
                List<apply_doctor> doctors = messageService.findDoctorApplyPage(username, page);
                for (apply_doctor doctor : doctors)
                    list.add(doctor.toMapPart());
                return list;
            default:
                return null;
        }
    }

    @RequestMapping(value="/apply/role/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findRoleApplyContent(String username, int page, int num, @RequestParam(value="form-type") String type) {
        switch(type) {
            case "Main Admin application":
                return messageService.findMainApplyContent(username, page, num).toMap();
            case "Commercial Admin application":
                return messageService.findCommercialApplyContent(username, page, num).toMap();
            case "Info Admin application":
                return messageService.findInfoApplyContent(username, page, num).toMap();
            case "Medical Admin application":
                return messageService.findMedicalApplyContent(username, page, num).toMap();
            case "Area Admin application":
                return messageService.findCommunityApplyContent(username, page, num).toMap();
            case "Doctor application":
                return messageService.findDoctorApplyContent(username, page, num).toMap();
            default:
                return null;
        }
    }

    @RequestMapping(value="/apply/opening/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findOpeningApplyNum(String username, String function) {
        return messageService.findOpeningApplyNum(username);
    }

    @RequestMapping(value="/apply/opening/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findOpeningApplyPage(String username, String function, int page) {
        List<Map<String, Object>> list = new LinkedList<>();
        List<Apply_opening> openings = messageService.findOpeningApplyPage(username, page);

        for (Apply_opening opening : openings)
            list.add(opening.toMapPart());

        return list;
    }

    @RequestMapping(value="/apply/opening/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findOpeningApplyContent(String username, int page, int num) {
        return messageService.findOpeningApplyContent(username, page, num).toMap();
    }

    // disagree agree
    @RequestMapping(value="/apply/role/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedBackRoleApply(String username, String function, @RequestParam(value="form-type") String type, int page, int id, String action) {
        messageService.feedBackRoleApply(username, function, Converter.applyTypeMap.get(type), page, id, action);
    }

    // disagree agree
    @RequestMapping(value="/apply/opening/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedBackOpeningApply(String username, String function, int page, int id, String action) {
        messageService.feedBackOpeningApply(username, function, page, id, action);
    }

    // {user=HLSSSS, pwd=123, province=Anhui, address=china, real-name=yuruijing, age=99, symptom=fever, color=grean}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, symptom=confirm, color=yellow}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, color=orange}
    @RequestMapping(value="/report/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendReport(@RequestBody Map<String, Object> report) {
        messageService.sendReport(new submission(report));
    }

    @RequestMapping(value="/report/find", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findReport(String username, String function) {
        return messageService.findReport(username);
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s}
    @RequestMapping(value="/medical_help/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendMedicalHelp(@RequestBody Map<String, Object> help) {
        messageService.sendMedicalHelp(new medical_help(help));
    }


    @RequestMapping(value="/medical_help/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findMedicalHelpNum(String username, String function) {
        return messageService.findMedicalApplyNum(username);
    }
    // {user=HLSSSS, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s}

    @RequestMapping(value="/medical_help/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findMedicalHelpPage(String username, String function, int page) {
        List<Map<String, Object>> list = new LinkedList<>();
        List<medical_help> helps = messageService.findMedicalHelpPage(username, page);

        for (medical_help help : helps)
            list.add(help.toMapPart());

        return list;
    }

    @RequestMapping(value="/medical_help/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findMedicalHelpContent(String username, int page, int num) {
        return messageService.findMedicalHelpContent(username, page, num).toMap();
    }

    // {user=zhang7, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s, target-doctor=c}
    @RequestMapping(value="/medical_help/distribute/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendDistributeMedicalHelp(@RequestBody Map<String, Object> help) {
        messageService.sendDistributeMedicalHelp(new medical_help_d(help));
    }

    @RequestMapping(value="/medical_help/distribute/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findDistributeMedicalHelpNum(String username, String function) {
        return messageService.findDistributeMedicalHelpNum(username);
    }

    @RequestMapping(value="/medical_help/distribute/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findDistributeMedicalHelpPage(String username, String function, int page) {
        List<Map<String, Object>> list = new LinkedList<>();
        List<medical_help_d> helps = messageService.findDistributeMedicalHelpPage(username, page);

        for (medical_help_d help : helps)
            list.add(help.toMapPart());

        return list;
    }

    @RequestMapping(value="/medical_help/distribute/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findDistributeMedicalHelpContent(String username, int page, int num) {
        return messageService.findDistributeMedicalHelpContent(username, page, num).toMap();
    }
}
