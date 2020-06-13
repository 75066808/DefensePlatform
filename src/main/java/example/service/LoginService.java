package example.service;

import example.dao.UserDao;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            return username + "#" + password + "#1";
        }
        else return username+ "#" + password + "#0";
    }

    public boolean logout(String username) {
        return true;
    }

    //Assume that username is unique
    public boolean register(User user, String password) {
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
}
