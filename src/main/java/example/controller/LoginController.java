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

    @RequestMapping(value="login.do", method=RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password) {
        System.out.println("--- in login controller ---");
        System.out.println("--- call login ---");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return loginService.login(username, password);
    }

    @RequestMapping(value="/logout.do", method=RequestMethod.POST)
    @ResponseBody
    public boolean logout(String username){
        System.out.println("--- in login controller ---");
        System.out.println("--- call logout ---");
        System.out.println("username:" + username);
        return loginService.logout(username);
    }

    @RequestMapping(value="/register.do", method=RequestMethod.POST)
    @ResponseBody
    public boolean register(User user, String password) {
        System.out.println("--- in login controller ---");
        System.out.println("--- call register ---");
        System.out.println("user" + user);
        System.out.println("password:" + password);
        return loginService.register(user, password);
    }

    @RequestMapping(value="/password.do", method=RequestMethod.POST)
    @ResponseBody
    public boolean modifyPassword(String username, String password) {
        System.out.println("--- in login controller ---");
        System.out.println("--- call modifyPassword ---");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return loginService.modifyPassword(username, password);
    }
}
