package example.service;

import example.dao.UserDao;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.User.Admin.BusinessAdmin;
import example.pojo.User.Admin.CommunityAdmin;
import example.pojo.User.Admin.MedicalAdmin;
import example.pojo.User.Admin.SuperAdmin;
import example.pojo.User.Ordinary.Business_man;
import example.pojo.User.Ordinary.Doctor;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public String login(String username, String password) {
        List<User> userlist = userDao.findUsers(username);
        //Assume that username is unique
        String pwd = userDao.findPassword(userlist.get(0).id);
        boolean res = pwd.equals(password);
        if(res == true){
            String str7 = isBusinessAdmin(username) ? "1" : "0";
            String str6 = isSuper(username) ? "1" : "0";
            String str5 = isMerchant(username) ? "1" : "0";
            String str4 = isCommunity(username) ? "1" : "0";
            String str3 = isDoctor(username) ? "1" : "0";
            String str2 = isMedical(username) ? "1" : "0";
            String str1 = isSuper(username) ? "1" : "0";
            return username + "#1" + str7 + str6 + str5 + str4 + str3 + str2 + str1;
        }
        else return "false";
    }


    //Assume that username is unique
    public boolean register(User user) {
        List<User> userlist = userDao.findUsers(user.username);
        if(userlist.isEmpty()){
            userDao.addUser(user);
            return true;
        }
        
        return false;
    }

    public boolean modifyPassword(String username, String password) {
        List<User> userlist = userDao.findUsers(username);
        //Assume that username is unique
        int userid = userlist.get(0).id;
        userDao.modifyPassword(userid, password);
        return true;
    }

    boolean isSuper(String username){
        List<SuperAdmin> adminlist = userDao.show_superadmin();
        SuperAdmin tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }

    boolean isMerchant(String username){
        List<Business_man> adminlist = userDao.show_business_man();
        Business_man tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }

    boolean isDoctor(String username){
        List<Doctor> adminlist = userDao.show_doctor();
        Doctor tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }

    boolean isCommunity(String username){
        List<CommunityAdmin> adminlist = userDao.show_communityadmin();
        CommunityAdmin tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }

    boolean isBusinessAdmin(String username){
        List<BusinessAdmin> adminlist = userDao.show_businessadmin();
        BusinessAdmin tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }

    boolean isMedical(String username){
        List<MedicalAdmin> adminlist = userDao.show_medical_admin();
        MedicalAdmin tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username))
                break;
        }
        if(i == adminlist.size())
            return false;
        else return true;
    }
}
