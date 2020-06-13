package example.service;

import example.dao.MessageDao;
import example.dao.UserDao;

import example.pojo.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.Message.Msg.*;
import example.pojo.User.Admin.BusinessAdmin;
import example.pojo.User.Admin.SuperAdmin;
import example.pojo.User.Ordinary.Business_man;
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
        return true;
    }

    public boolean sendMerchatApply(Apply_business apply) {
        List<Business_man> merchantlist = userDao.show_business_man();
        String username = apply.username;
        Business_man tmp = null;
        for (int i = 0; i < merchantlist.size(); i++){
            tmp = merchantlist.get(i);
            if(tmp.username.equals(username))
                return false;
        }
        Business_man newmerchant = new Business_man(username, apply.password, apply.phone_number, apply.email, 
        apply.province, apply.address, apply.business_district, apply.duration)

        userDao.add_business_man(newmerchant);
        return true;
    }

    public boolean sendOpeningApply(Apply_opening apply) {
        //messageDao.add_opening(apply);
        return true;
    }

    public int findMainApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<Apply_main> applylist = messageDao.show_apply_main();
        //check user na
        return applylist.size()/10 + 1;
    }

    public List<Apply_main> findMainApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<Apply_main> applylist = messageDao.show_apply_main();
        //check user na
        List<Apply_main> newlist = new ArrayList<Apply_main>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public Apply_main findMainApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<Apply_main> applylist = messageDao.show_apply_main();
        //check user na
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findCommercialApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<apply_commerical> applylist = messageDao.show_apply_commerical();
        return applylist.size()/10 + 1;
    }

    public List<apply_commerical> findCommercialApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<apply_commerical> applylist = messageDao.show_apply_commerical();
        List<apply_commerical> newlist = new ArrayList<apply_commerical>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public apply_commerical findCommercialApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<apply_commerical> applylist = messageDao.show_apply_commerical();
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findInfoApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<Apply_info> applylist = messageDao.show_Apply_info();
        return applylist.size()/10 + 1;
    }

    public List<Apply_info> findInfoApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<Apply_info> applylist = messageDao.show_Apply_info();
        List<Apply_info> newlist = new ArrayList<Apply_info>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public Apply_info findInfoApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<Apply_info> applylist = messageDao.show_Apply_community();
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findMedicalApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<Apply_medical_admin> applylist = messageDao.show_apply_medical_admin();
        return applylist.size()/10 + 1;
    }

    public List<Apply_medical_admin> findMedicalApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<Apply_medical_admin> applylist = messageDao.show_apply_medical_admin();
        List<Apply_medical_admin> newlist = new ArrayList<Apply_medical_admin>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public Apply_medical_admin findMedicalApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<Apply_medical_admin> applylist = messageDao.show_apply_medical_admin();
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findCommunityApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<apply_community> applylist = messageDao.show_apply_community();
        return applylist.size()/10 + 1;
    }

    public List<apply_community> findCommunityApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<apply_community> applylist = messageDao.show_apply_community();
        List<apply_community> newlist = new ArrayList<apply_community>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public apply_community findCommunityApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<apply_community> applylist = messageDao.show_apply_community();
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findDoctorApplyNum(String username) {
        if(!isSuper(username))
            return 0;
            
        List<apply_doctor> applylist = messageDao.show_apply_doctor();
        return applylist.size()/10 + 1;
    }

    public List<apply_doctor> findDoctorApplyPage(String username, int page) {
        if(!isSuper(username))
            return null;
            
        List<apply_doctor> applylist = messageDao.show_apply_doctor();
        List<apply_doctor> newlist = new ArrayList<apply_doctor>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public apply_doctor findDoctorApplyContent(String username, int page, int num) {
        if(!isSuper(username))
            return null;
            
        List<apply_doctor> applylist = messageDao.show_apply_doctor();
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public int findOpeningApplyNum(String username, String function) {
        System.out.println("findOpeningApplyNum");
        System.out.println(username);
        return 5;
    }

    String isBusiness(String username){
        List<BusinessAdmin> adminlist = userDao.show_business_admin();
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
}
