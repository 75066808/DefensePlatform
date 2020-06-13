package example.controller;
import example.pojo.Message.Message;
import example.pojo.Message.Msg.Chat;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import example.service.MessageService;

import java.util.HashMap;
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
        messageService.sendChat(Chat.convertMapToClass(chat));
    }


    @RequestMapping(value="/chat/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findChatNum(String username, String function) {
        return messageService.findChatNum(username);
    }

    @RequestMapping(value="/chat/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findChatPage(String username, String function, int page) {
        List<Chat> chat = messageService.findChatPage(username, page);

        List<Map<String, Object>> list = new LinkedList<>();
        for (int i = 0;i < 10;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("sender", "zhang" + ((page - 1) * 10 + i));
            map.put("title", "This is the title " + ((page - 1) * 10 + i));
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value="/chat/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findChatContent(String username, int page, int num) {
        System.out.println("findChatContent");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);

        Map<String, Object> map = new HashMap<>();
        map.put("sender", "zhang" + ((page - 1) * 10 + num - 1));
        map.put("title", "This is the title " + ((page - 1) * 10 + num - 1));
        map.put("main_text", "This is the text " + ((page - 1) * 10 + num - 1));

        return map;
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
        System.out.println("sendInviteCode");
        System.out.println(invite);
    }

    // {user=HLSSSS, pwd=123, phonenum=1392361111, email=75066808@qq.com, province=Fujian, address=china, community-name=fff, reason=reason, invite-code=2222, time=forever}
    // {user=HLSSSS, pwd=123, phonenum=, email=, province=Anhui, address=, community-name=, reason=, invite-code=, time=one-month}
    @RequestMapping(value="/apply/community/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCommunityAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendCommunityAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/commercial/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCommercialAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendCommercialAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=2222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/medical/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendMedicalAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendMedicalAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/information/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendInformationAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendInformationAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/super/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendSuperAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendSuperAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/doctor/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendDoctorApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendDoctorApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, community=cc, reason=res, time=forever}
    @RequestMapping(value="/apply/citizen/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendCitizenApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendCitizenApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, time=forever}
    @RequestMapping(value="/apply/merchant/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendMerchantApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendMerchantApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, business-district=bbb, shop-name=ffff, reason=ccc, time=forever}
    @RequestMapping(value="/apply/opening/send", method=RequestMethod.POST)
    @ResponseBody
    public String sendOpeningApply(@RequestBody Map<String, Object> apply) {
        System.out.println("sendOpeningApply");
        System.out.println(apply);
        return "success";
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
        System.out.println("findRoleApplyNum");
        System.out.println(username);
        System.out.println(type);
        return 5;
    }

    @RequestMapping(value="/apply/role/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findRoleApplyPage(String username, String function, @RequestParam(value="form-type") String type, int page) {
        System.out.println("findRoleApplyPage");
        System.out.println(username);
        System.out.println(type);
        System.out.println(page);
        List<Map<String, Object>> list = new LinkedList<>();

        for (int i = 0;i < 10;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("sender", "zhang" + ((page - 1) * 10 + i));
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value="/apply/role/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findRoleApplyContent(String username, int page, int num, @RequestParam(value="form-type") String type) {
        System.out.println("findRoleApplyContent");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);
        System.out.println(type);

        Map<String, Object> map = new HashMap<>();

        switch(type) {
            case "Main Admin application":
                map.put("user", "main admin" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("address", "china");
                map.put("reason", "res");
                map.put("invite_code", "2222");
                map.put("time", "forever");
                break;
            case "Commercial Admin application":
                map.put("user", "commercial admin" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("address", "china");
                map.put("business_district", "bbb");
                map.put("reason", "res");
                map.put("invite_code", "2222");
                map.put("time", "forever");
                break;
            case "Info Admin application":
                map.put("user", "info admin" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("reason", "res");
                map.put("invite_code", "2222");
                map.put("time", "one-month");
                break;
            case "Medical Admin application":
                map.put("user", "medical admin" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("address", "china");
                map.put("real_name", "yuruijing");
                map.put("certificate_no", "123456");
                map.put("invite_code", "2222");
                map.put("time", "forever");
                break;
            case "Area Admin application":
                map.put("user", "area admin" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("address", "china");
                map.put("community_name", "ccc");
                map.put("reason", "res");
                map.put("invite_code", "2222");
                map.put("time", "forever");
                break;
            case "Doctor application":
                map.put("user", "doctor" + ((page - 1) * 10 + num - 1));
                map.put("pwd", "123");
                map.put("phonenumber", "22222");
                map.put("email", "75066808@qq.com");
                map.put("province", "Anhui");
                map.put("address", "china");
                map.put("real_name", "yuruijing");
                map.put("certificate_no", "123456");
                map.put("reason", "res");
                map.put("invite_code", "2222");
                map.put("time", "one-month");
                break;
            default:
                break;
        }

        return map;
    }

    @RequestMapping(value="/apply/opening/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findOpeningApplyNum(String username, String function) {
        System.out.println("findOpeningApplyNum");
        System.out.println(username);
        return 5;
    }

    @RequestMapping(value="/apply/opening/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findOpeningApplyPage(String username, String function, int page) {
        System.out.println("findOpeningApplyPage");
        System.out.println(username);
        System.out.println(page);
        List<Map<String, Object>> list = new LinkedList<>();

        for (int i = 0;i < 10;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("sender", "zhang" + ((page - 1) * 10 + i));
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value="/apply/opening/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findOpeningApplyContent(String username, int page, int num) {
        System.out.println("findOpeningApplyContent");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);

        Map<String, Object> map = new HashMap<>();
        map.put("user", "opening" + ((page - 1) * 10 + num - 1));
        map.put("pwd", "123");
        map.put("business_district", "bbb");
        map.put("shop_name", "sss");
        map.put("reason", "rrr");
        map.put("time", "forever");
        return map;
    }

    // disagree agree
    @RequestMapping(value="/apply/role/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedBackRoleApply(String username, String function, @RequestParam(value="form-type") String type, int page, int id, String action) {
        System.out.println("feedBackRoleApply");
        System.out.println(username);
        System.out.println(type);
        System.out.println(page);
        System.out.println(id);
        System.out.println(action);
    }

    // disagree agree
    @RequestMapping(value="/apply/opening/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedBackOpeningApply(String username, String function, int page, int id, String action) {
        System.out.println("feedBackOpeningApply");
        System.out.println(username);
        System.out.println(page);
        System.out.println(id);
        System.out.println(action);
    }

    // {user=HLSSSS, pwd=123, province=Anhui, address=china, real-name=yuruijing, age=99, symptom=fever, color=grean}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, symptom=confirm, color=yellow}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, color=orange}
    @RequestMapping(value="/report/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendReport(@RequestBody Map<String, Object> report) {
        System.out.println("sendReport");
        System.out.println(report);
    }

    @RequestMapping(value="/report/find", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findReport(String username, String function) {
        System.out.println("findReport");
        System.out.println(username);
        Map<String, Object> map = new HashMap<>();
        map.put("today_total_people", 1);
        map.put("yesterday_total_people", 2);
        map.put("today_reported", 3);
        map.put("yesterday_reported", 4);
        map.put("today_not_reported", 5);
        map.put("yesterday_not_reported", 6);
        map.put("today_normal", 7);
        map.put("yesterday_normal", 8);
        map.put("today_unnormal", 9);
        map.put("yesterday_unnormal", 10);
        return map;
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s}
    @RequestMapping(value="/medical_help/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendMedicalHelp(@RequestBody Map<String, Object> help) {
        System.out.println("sendMedicalHelp");
        System.out.println(help);
    }


    @RequestMapping(value="/medical_help/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findMedicalHelpNum(String username, String function) {
        System.out.println("findMedicalHelpNum");
        System.out.println(username);
        return 5;
    }
    // {user=HLSSSS, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s}

    @RequestMapping(value="/medical_help/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findMedicalHelpPage(String username, String function, int page) {
        System.out.println("findMedicalHelpPage");
        System.out.println(username);
        System.out.println(page);

        List<Map<String, Object>> list = new LinkedList<>();
        for (int i = 0;i < 10;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("sender", "zhang" + ((page - 1) * 10 + i));
            map.put("department",  "D" + ((page - 1) * 10 + i));
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value="/medical_help/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findMedicalHelpContent(String username, int page, int num) {
        System.out.println("findMedicalHelpContent");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);

        Map<String, Object> map = new HashMap<>();
        map.put("user", "zhang" + ((page - 1) * 10 + num - 1));
        map.put("pwd", "123");
        map.put("phonenumber", "22222");
        map.put("province", "Anhui");
        map.put("address", "china");
        map.put("realname", "urara");
        map.put("gender", "male");
        map.put("age", "99");
        map.put("department", "1212");
        map.put("symptom", "ssssssssssss");
        return map;
    }

    // {user=zhang7, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s, target-doctor=c}
    @RequestMapping(value="/medical_help/distribute/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendDistributeMedicalHelp(@RequestBody Map<String, Object> help) {
        System.out.println("sendDistributeMedicalHelp");
        System.out.println(help);
    }

    @RequestMapping(value="/medical_help/distribute/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findDistributeMedicalHelpNum(String username, String function) {
        System.out.println("findMedicalHelpNum");
        System.out.println(username);
        return 5;
    }

    @RequestMapping(value="/medical_help/distribute/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findDistributeMedicalHelpPage(String username, String function, int page) {
        System.out.println("findDistributeMedicalHelpPage");
        System.out.println(username);
        System.out.println(page);

        List<Map<String, Object>> list = new LinkedList<>();
        for (int i = 0;i < 10;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("sender", "zhang" + ((page - 1) * 10 + i));
            map.put("department",  "D" + ((page - 1) * 10 + i));
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value="/medical_help/distribute/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findDistributeMedicalHelpContent(String username, int page, int num) {
        System.out.println("findDistributeMedicalHelpContent");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);

        Map<String, Object> map = new HashMap<>();
        map.put("user", "zhang" + ((page - 1) * 10 + num - 1));
        map.put("pwd", "123");
        map.put("phonenumber", "22222");
        map.put("province", "Anhui");
        map.put("address", "china");
        map.put("realname", "urara");
        map.put("gender", "male");
        map.put("age", "99");
        map.put("department", "1212");
        map.put("symptom", "ssssssssssss");
        return map;
    }
}
