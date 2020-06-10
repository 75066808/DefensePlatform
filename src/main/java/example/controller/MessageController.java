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

    @RequestMapping(value="/{id}",  method=RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessages(@PathVariable("id") String id) {
        return messageService.findMessages(id);
    }


    @RequestMapping(value="/dest/{to}", method=RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessages(@PathVariable("to") String to, String type) {
        return messageService.findMessages(to, type);
    }


    @RequestMapping(value="/src/{from}", method=RequestMethod.GET)
    @ResponseBody
    public List<Message> findMessages(@PathVariable("from") String from, String to, String type) {
        return messageService.findMessages(from, to, type);
    }

    @RequestMapping(value="/type/{type}", method=RequestMethod.GET)
    @ResponseBody
    public List<Message> fetchMessages(@PathVariable("type") String type) {//查看论坛或新闻
        return messageService.fetchMessages(type);
    }


    @RequestMapping(value="/", method=RequestMethod.POST)
    @ResponseBody
    public List<User> sendMessage(String username, String function) {
        User user1 = new User(1,"hhh", "china", 55, 12);
        User user2 = new User(2,"hhh", "china", 55, 12);

        List<User> list = new LinkedList<>();
        list.add(user1);
        list.add(user2);

        System.out.println(username);
        System.out.println(function);
        return list;
    }

    @RequestMapping(value="/broadcast", method=RequestMethod.PUT)
    @ResponseBody
    public boolean sendMessage(Message message, List<String> usernames) {
        return messageService.sendMessage(message, usernames);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    @ResponseBody
    public boolean modifyMessage(@PathVariable("id") String id, Message message) {
        return messageService.modifyMessage(id, message);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteMessage(@PathVariable("id") String id) {
        return messageService.deleteMessage(id);
    }
}
