package example.service;

import example.dao.UserDao;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public String login(String username, String password) {
        //String pwd = userDao.findPassword(username);
        //System.out.println(username + "#111");
        return username + "#110";
        //return pwd.equals(password);
    }

    public boolean logout(String username) {
        return true;
    }

    public boolean register(User user, String password) {
        //userDao.addUser(user, password);
        return true;
    }

    public boolean modifyPassword(String username, String password) {
        //userDao.modifyPassword(username, password);
        return true;
    }
}
