package example.service;

import example.dao.UserDao;
import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;
import example.pojo.User.Ordinary.Merchant;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUser(String username) {
        return userDao.findUser(username);
    }

    public List<User> findUsers(String adminName, String regionType) {
        return userDao.findUsers(adminName, regionType);
    }


    public boolean setCitizen(String username, Citizen citizen) {
        userDao.addCitizen(username, citizen);
        return true;
    }

    public boolean setDoctor(String username, Doctor doctor) {
        userDao.addDoctor(username, doctor);
        return true;
    }

    public boolean setMerchant(String username, Merchant merchant) {
        userDao.addMerchant(username, merchant);
        return true;
    }


    public boolean setSuperAdmin(String adminName, SuperAdmin superAdmin) {
        userDao.addSuperAdmin(adminName, superAdmin);
        return true;
    }

    public boolean setInformationAdmin(String adminName, InformationAdmin informationAdmin) {
        userDao.addInformationAdmin(adminName, informationAdmin);
        return true;
    }

    public boolean setCommunityAdmin(String adminName, CommunityAdmin communityAdmin) {
        userDao.addCommunityAdmin(adminName, communityAdmin);
        return true;
    }


    public boolean setMedicalAdmin(String adminName, MedicalAdmin medicalAdmin) {
        userDao.addMedicalAdmin(adminName, medicalAdmin);
        return true;
    }

    public boolean setBusinessAdmin(String adminName, BusinessAdmin businessAdmin) {
        userDao.addBusinessAdmin(adminName, businessAdmin);
        return true;
    }
}
