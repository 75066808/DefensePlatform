package example.controller;
import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;
import example.pojo.User.Ordinary.Merchant;
import example.pojo.User.User;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{name}", method=RequestMethod.GET)
    @ResponseBody
    public User findUser(@PathVariable("name") String username){
        return userService.findUser(username);
    }

    @RequestMapping(value = "/region/{name}", method=RequestMethod.GET)
    @ResponseBody
    public List<User> findUsers(@PathVariable("name") String adminName, String regionType){
        return userService.findUsers(adminName, regionType);
    }

    @RequestMapping(value = "/citizen/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setCitizen(@PathVariable("name") String username, Citizen citizen) {
        return userService.setCitizen(username, citizen);
    }

    @RequestMapping(value = "/doctor/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setDoctor(@PathVariable("name") String username, Doctor doctor) {
        return userService.setDoctor(username, doctor);
    }

    @RequestMapping(value = "/merchant/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setMerchant(@PathVariable("name") String username, Merchant merchant) {
        return userService.setMerchant(username, merchant);
    }

    @RequestMapping(value = "/super/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setSuperAdmin(@PathVariable("name") String adminName, SuperAdmin superAdmin) {
        return userService.setSuperAdmin(adminName, superAdmin);
    }

    @RequestMapping(value = "/information/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setInformationAdmin(@PathVariable("name") String adminName, InformationAdmin informationAdmin ) {
        return userService.setInformationAdmin(adminName, informationAdmin);
    }

    @RequestMapping(value = "/community/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setCommunityAdmin(@PathVariable("name") String adminName, CommunityAdmin communityAdmin) {
        return userService.setCommunityAdmin(adminName, communityAdmin);
    }

    @RequestMapping(value = "/medical/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setMedicalAdmin(@PathVariable("name") String adminName, MedicalAdmin medicalAdmin) {
        return userService.setMedicalAdmin(adminName, medicalAdmin);
    }

    @RequestMapping(value = "/business/{name}", method=RequestMethod.POST)
    @ResponseBody
    public boolean setBusinessAdmin(@PathVariable("name") String adminName, BusinessAdmin businessAdmin) {
        return userService.setBusinessAdmin(adminName, businessAdmin);
    }

}

