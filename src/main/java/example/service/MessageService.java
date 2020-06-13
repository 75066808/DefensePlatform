package example.service;

import example.dao.MessageDao;
import example.dao.UserDao;

import example.pojo.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.Message.Msg.*;
import example.pojo.User.Ordinary.Citizen;

import java.util.List;
import java.util.ArrayList;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    public void sendChat(Chat chat) {
        messageDao.addchat(chat);
    }

    public int findChatNum(String username) {
        List<Chat> chatlist = messageDao.show_chat_to(username);
        return chatlist.size()/10 + 1;
    }

    public List<Chat> findChatPage(String username, int page) {
        List<Chat> chatlist = messageDao.show_chat_to(username);
        List<Chat> newlist = new ArrayList<Chat>();
        for (int i = (page - 1) * 10; i < chatlist.size() && i < page * 10; i++){
            newlist.add(chatlist.get(i));
        }
        return newlist;
    }

    public Chat findChatContent(String username, int page, int num) {
        List<Chat> chatlist = messageDao.show_chat_to(username);
        return chatlist.get((page - 1) * 10 + num - 1);
    }

    public void sendInviteCode(invite_code invite) {
        messageDao.add_invite_code(invite);
    }

    public boolean sendCommunityAdminApply(apply_community apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        //TO DO:...
        if(check.type == 0){
            messageDao.add_apply_community(apply);
            return true;
        }
        return false;
    }

    public boolean sendCommercialAdminApply(apply_commerical apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        if(check.type == 0){
            messageDao.add_apply_commerical(apply);
            return true;
        }
        return false;
    }

    public boolean sendMedicalAdminApply(Apply_medical_admin apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        if(check.type == 0){
            messageDao.add_apply_medical_admin(apply);
            return true;
        }
        return false;
    }

    public boolean sendInformationAdminApply(Apply_info apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        if(check.type == 0){
            messageDao.add_apply_info(apply);
            return true;
        }
        return false;
    }

    public boolean sendSuperAdminApply(Apply_main apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        if(check.type == 0){
            messageDao.add_apply_main(apply);
            return true;
        }
        return false;
    }

    public boolean sendDoctorApply(apply_doctor apply) {
        String code = apply.invite_code;
        invite_code check = messageDao.find_invite_code(code);
        if(check.type == 0){
            messageDao.add_apply_doctor(apply);
            return true;
        }
        return false;
    }

    public boolean sendCitizenApply(Apply_citizen apply) {
        List<Citizen> citizenlist = userDao.show_citizen();
        String username = apply.username;
        Citizen tmp = null;
        for (int i = 0; i < citizenlist.size(); i++){
            tmp = citizenlist.get(i);
            if(tmp.username.equals(username))
                return false;
        }
        Citizen newcitizen = new Citizen(apply.username, apply.password, apply.phone_number, 
        apply.email, apply.province, apply.address, apply.real_name, apply.community, apply.reason, apply.duration);
        
        userDao.add_citizen(newcitizen);
    }

    public boolean sendMerchatApply(Apply_business apply) {
        messageDao.add_apply_business(apply);
    }

    public void sendOpeningApply(Apply_opening apply) {
        //messageDao.add_opening(apply);
    }

    public int findRoleApplyNum(String username, String type) {
        if(type.equals("Main Admin application")){
            List<Apply_main> applylist = messageDao.show_apply_main();
            //check user na
            return chatlist.size()/10 + 1;
        }
        else if(type.equals("Commercial Admin application")){

        }
        else if(type.equals("Info Admin application")){

        }
        else if(type.equals("Area Admin application")){

        }
        else if(type.equals("Doctor application")){

        }
        else if(type.equals("Medical Admin application")){

        }
    }
}
