package example.dao;

import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;
import example.pojo.User.Ordinary.Merchant;
import example.pojo.User.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    public User findUser(String username) {
        return null;
    }

    public List<User> findUsers(String adminName, String regionType) {
        return null;
    }

    public String findPassword(String username) {
        return null;
    }

    public void addUser(User user, String password) {

    }

    public void addCitizen(String username, Citizen citizen) {

    }

    public void addDoctor(String username, Doctor doctor) {

    }

    public void addMerchant(String username, Merchant merchant) {

    }


    public void addSuperAdmin(String adminName, SuperAdmin superAdmin) {

    }

    public void addInformationAdmin(String adminName, InformationAdmin informationAdmin) {

    }

    public void addCommunityAdmin(String adminName, CommunityAdmin communityAdmin) {

    }


    public void addMedicalAdmin(String adminName, MedicalAdmin medicalAdmin) {

    }

    public void addBusinessAdmin(String adminName, BusinessAdmin businessAdmin) {

    }

    public void modifyPassword(String username, String password) {

    }
}

