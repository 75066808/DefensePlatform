package example.service;

import example.dao.UserDao;
import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;
import example.pojo.User.Ordinary.Business_man;
import example.pojo.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public boolean setCitizen(String username, Citizen citizen) {
        userDao.add_citizen(citizen);
        return true;
    }

    public boolean setDoctor(String username, Doctor doctor) {
        userDao.add_Doctor(doctor);
        return true;
    }

    public boolean setMerchant(String username, Business_man merchant) {
        userDao.add_business_man(merchant);
        return true;
    }


    public boolean setSuperAdmin(String adminName, SuperAdmin superAdmin) {
        userDao.add_superadmin(superAdmin);
        return true;
    }

    public boolean setInformationAdmin(String adminName, InformationAdmin informationAdmin) {
        userDao.add_informationadmin(informationAdmin);
        return true;
    }

    public boolean setCommunityAdmin(String adminName, CommunityAdmin communityAdmin) {
        userDao.add_communityadmin(communityAdmin);
        return true;
    }


    public boolean setMedicalAdmin(String adminName, MedicalAdmin medicalAdmin) {
        userDao.add_medicaladmin(medicalAdmin);
        return true;
    }

    public boolean setBusinessAdmin(String adminName, BusinessAdmin businessAdmin) {
        userDao.add_businessadmin(businessAdmin);
        return true;
    }
}
