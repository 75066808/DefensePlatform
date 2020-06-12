package example.controller;
import example.pojo.Message.Message;
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

    @RequestMapping(value="/chat/send", method=RequestMethod.POST)
    @ResponseBody
    public void sendChat(@RequestBody Map<String, Object> chat) {
        System.out.println("sendChat");
        System.out.println(chat);
    }


    @RequestMapping(value="/chat/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findChatNum(String username, String function) {
        System.out.println("findChatNum");
        System.out.println(username);
        return 5;
    }

    @RequestMapping(value="/chat/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findChatPage(String username, String function, int page) {
        System.out.println("findChatPage");
        System.out.println(username);
        System.out.println(page);

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

    // {user=HLSSSS, pwd=123, roles=Main, invite-code=2222}
    @RequestMapping(value="/invite/add", method=RequestMethod.POST)
    @ResponseBody
    public void addInviteCode(@RequestBody Map<String, Object> invite) {
        System.out.println("addInviteCode");
        System.out.println(invite);
    }

    // {user=HLSSSS, pwd=123, phonenum=1392361111, email=75066808@qq.com, province=Fujian, address=china, community-name=fff, reason=reason, invite-code=2222, time=forever}
    // {user=HLSSSS, pwd=123, phonenum=, email=, province=Anhui, address=, community-name=, reason=, invite-code=, time=one-month}
    @RequestMapping(value="/apply/community/add", method=RequestMethod.POST)
    @ResponseBody
    public String addCommunityAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addCommunityAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/commercial/add", method=RequestMethod.POST)
    @ResponseBody
    public String addCommercialAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addCommercialAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=2222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/medical/add", method=RequestMethod.POST)
    @ResponseBody
    public String addMedicalAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addMedicalAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/information/add", method=RequestMethod.POST)
    @ResponseBody
    public String addInformationAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addInformationAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/super/add", method=RequestMethod.POST)
    @ResponseBody
    public String addSuperAdminApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addSuperAdminApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, reason=res, invite-code=2222, time=forever}
    @RequestMapping(value="/apply/doctor/add", method=RequestMethod.POST)
    @ResponseBody
    public String addDoctorApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addDoctorApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, community=cc, reason=res, time=forever}
    @RequestMapping(value="/apply/citizen/add", method=RequestMethod.POST)
    @ResponseBody
    public String addCitizenApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addCitizenApply");
        System.out.println(apply);
        return "success";
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, time=forever}
    @RequestMapping(value="/apply/merchant/add", method=RequestMethod.POST)
    @ResponseBody
    public String addMerchantApply(@RequestBody Map<String, Object> apply) {
        System.out.println("addMerchantApply");
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
    @RequestMapping(value="/apply/find/num", method=RequestMethod.POST)
    @ResponseBody
    public int findApplyNum(String username, String function, @RequestParam(value="form-type") String type) {
        System.out.println("findApplyNum");
        System.out.println(username);
        System.out.println(type);
        return 5;
    }

    @RequestMapping(value="/apply/find/page", method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findApplyPage(String username, String function, @RequestParam(value="form-type") String type, int page) {
        System.out.println("findApplyPage");
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

    @RequestMapping(value="/apply/find/content", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findApplyContent(String username, int page, int num, @RequestParam(value="form-type") String type) {
        System.out.println("findChatContent");

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

    // disagree agree
    @RequestMapping(value="/apply/feedback", method=RequestMethod.POST)
    @ResponseBody
    public void feedBackApply(String username, String function, @RequestParam(value="form-type") String type, int page, int id, String action) {
        System.out.println("feedBackApply");
        System.out.println(username);
        System.out.println(type);
        System.out.println(page);
        System.out.println(id);
        System.out.println(action);
    }


}
