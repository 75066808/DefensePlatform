package example.service;

import example.dao.MessageDao;
import example.dao.UserDao;

import example.pojo.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.Message.Msg.*;

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

    public void sendCommunityAdminApply(apply_community apply) {
        messageDao.add_apply_community(apply);
    }

    public void sendCommercialAdminApply(apply_commerical apply) {
        messageDao.add_apply_commerical(apply);
    }

    public void sendMedicalAdminApply(Apply_medical_admin apply) {
        messageDao.add_apply_medical_admin(apply);
    }

    public void sendInformationAdminApply(Apply_info apply) {
        messageDao.add_apply_info(apply);
    }

    public void sendDoctorApply(apply_doctor apply) {
        messageDao.add_apply_doctor(apply);
    }

    public void sendCitizenApply(Apply_citizen apply) {
        messageDao.add_apply_citizen(apply);
    }

    public void sendMerchatApply(Apply_business apply) {
        messageDao.add_apply_business(apply);
    }

    public void sendOpeningApply(Apply_opening apply) {
        //messageDao.add_opening(apply);
    }

    public int findRoleApplyNum(String username, String type) {
        if(type.equals("Main Admin application")){
            List<Apply_main> applylist = messageDao.show_apply_main();
            //check user name
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
