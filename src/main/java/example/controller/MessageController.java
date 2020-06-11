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

    @RequestMapping(value="/chat/send",  method=RequestMethod.POST)
    @ResponseBody
    public void sendChat(@RequestBody Map<String, Object> chat) {
        System.out.println("Send chat");
        System.out.println(chat);
    }


    @RequestMapping(value="/chat/find/num",  method=RequestMethod.POST)
    @ResponseBody
    public int findChatNum(String username, String function) {
        System.out.println("Find chat num");
        System.out.println(username);
        return 5;
    }

    @RequestMapping(value="/chat/find/page",  method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> findChatPage(String username, String function, int page) {
        System.out.println("Find chat page");
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

    @RequestMapping(value="/chat/find/content",  method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findChatContent(String username, int page, int num) {
        System.out.println("Find chat content");

        System.out.println(username);
        System.out.println(page);
        System.out.println(num);

        Map<String, Object> map = new HashMap<>();
        map.put("sender", "zhang" + ((page - 1) * 10 + num - 1));
        map.put("title", "This is the title " + ((page - 1) * 10 + num - 1));
        map.put("main_text", "This is the text " + ((page - 1) * 10 + num - 1));

        return map;
    }



}
