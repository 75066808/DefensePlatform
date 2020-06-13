package example.controller;

import example.pojo.User.User;
import example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/")
    public String main() {
        return "logintest";
    }

    @RequestMapping(value="login", method=RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password) {
        System.out.println("--- in login controller ---");
        System.out.println("--- call login ---");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return username + "#" + password;
    }


    @RequestMapping(value="register", method=RequestMethod.POST)
    @ResponseBody
    public boolean register(String username, String password, String realname) {
        System.out.println("--- in login controller ---");
        System.out.println("--- call register ---");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("realname:" + realname);
        return true;
    }


}
