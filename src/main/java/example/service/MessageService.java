package example.service;

import example.dao.MessageDao;
import example.dao.UserDao;

import example.pojo.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.pojo.Message.Msg.*;
import example.pojo.User.Admin.BusinessAdmin;
import example.pojo.User.Admin.CommunityAdmin;
import example.pojo.User.Admin.MedicalAdmin;
import example.pojo.User.Admin.SuperAdmin;
import example.pojo.User.Ordinary.Business_man;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        Citizen newcitizen = new Citizen(0, apply.username, apply.password, apply.phone_number, 
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
        Business_man newmerchant = new Business_man(0, username, apply.password, apply.phone_number, apply.email, 
        apply.province, apply.address, apply.business_district, apply.duration);

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
            
        List<Apply_info> applylist = messageDao.show_Apply_info();
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

    public int findOpeningApplyNum(String username) {
        String district = isBusiness(username);
        if (district ==  null)
            return 0;

        List<Apply_opening> applylist = findOpeningApply(district);
        return applylist.size()/10 + 1;

    }

    public List<Apply_opening> findOpeningApplyPage(String username, int page) {
        String district = isBusiness(username);
        if (district ==  null)
            return null;

        List<Apply_opening> applylist = findOpeningApply(district);
        List<Apply_opening> newlist = new ArrayList<Apply_opening>();
        for (int i = (page - 1) * 10; i < applylist.size() && i < page * 10; i++){
            newlist.add(applylist.get(i));
        }
        return newlist;
    }

    public Apply_opening findOpeningApplyContent(String username, int page, int num) {
        String district = isBusiness(username);
        if (district ==  null)
            return null;

        List<Apply_opening> applylist = findOpeningApply(district);
        return applylist.get((page - 1) * 10 + num - 1);
    }

    public void sendReport(submission report) {
        report.sub_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).substring(0, 10);
        messageDao.add_submission(report);
        // a message to community admin if innormal
        if(report.situation == 0){
            String username = report.username;
            List<Citizen> ctzlist = userDao.show_citizen();
            String cmu = null;
            for(int i = 0; i < ctzlist.size(); i++){
                if(ctzlist.get(i).username.equals(username)){
                    cmu = ctzlist.get(i).community;
                    break;
                }
            }

            List<CommunityAdmin> adminlist = userDao.show_communityadmin();
            CommunityAdmin tmp = null;
            String admin = null;
            int i = 0;
            for (; i < adminlist.size(); i++){
                tmp = adminlist.get(i);
                if(tmp.community.equals(cmu)){
                    admin = tmp.username;
                    break;
                }
            }
            if(admin != null){
                String content = "Situation: " + report.situation + "\n" + "Color: " + report.color;
                Chat msg = new Chat(0, "system", admin, content, "Abnormal Information: " + username);
                sendChat(msg);
            }
            
        }
    }


    public Map<String, Object> findReport(String username) {
        String community = isCommunity(username);
        Map<String, Object> map = new HashMap<>();
        if(community == null)
            return map;
        List<submission> sublist = messageDao.show_submission();
        submission tmp;
        String ctime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).substring(0, 10);
        int cyear = Integer.valueOf(ctime.substring(0, 4));
        int cmonth = Integer.valueOf(ctime.substring(5, 7));
        int cday = Integer.valueOf(ctime.substring(8, 10));

        List<String> total_people = totalCommunity(community);
        int t_reported = 0,  y_reported = 0;
        int t_normal = 0, y_normal = 0;

        for (int i = 0; i < sublist.size(); i++){
            tmp = sublist.get(i);
            String time = tmp.sub_date;
            int year = Integer.valueOf(time.substring(0, 4));
            int month = Integer.valueOf(time.substring(5, 7));
            int day = Integer.valueOf(time.substring(8, 10));
            if(cyear == year && cmonth == month && cday == day && total_people.contains(tmp.username)){
                t_reported++;
                if(tmp.situation == 0)
                    t_normal++;
            }
            //Further improvent: yesterday calculation
            else if(cyear == year && cmonth == month && cday == day + 1 && total_people.contains(tmp.username)){
                y_reported++;
                if(tmp.situation == 0)
                    y_normal++;
            }
        }
        map.put("today_total_people", total_people.size());
        map.put("yesterday_total_people", total_people.size());
        map.put("today_reported", t_reported);
        map.put("yesterday_reported", y_reported);
        map.put("today_not_reported", total_people.size() - t_reported);
        map.put("yesterday_not_reported", total_people.size() - y_reported);
        map.put("today_unnormal", t_reported - t_normal);
        map.put("yesterday_unnormal", y_reported - y_normal);
        map.put("today_normal", t_normal);
        map.put("yesterday_normal", y_normal);
        return map;
    }

    public void sendMedicalHelp(medical_help help) {
        messageDao.add_medical_help(help);
    }

    public int findMedicalHelpNum(String username) {
        if(!isMedical(username))
            return 0;
        List<medical_help> helplist = messageDao.show_medical_help();
        return helplist.size()/10 + 1;
        
    }

    public List<medical_help> findMedicalHelpPage(String username, int page) {
        if(!isMedical(username))
            return null;
        List<medical_help> helplist = messageDao.show_medical_help();
        List<medical_help> newlist = new ArrayList<medical_help>();
        for (int i = (page - 1) * 10; i < helplist.size() && i < page * 10; i++){
            newlist.add(helplist.get(i));
        }
        return newlist;
    }

    public medical_help findMedicalHelpContent(String username, int page, int num) {
        if(!isMedical(username))
            return null;
        List<medical_help> helplist = messageDao.show_medical_help();
        return helplist.get((page - 1) * 10 + num - 1);
    }

    public void sendDistributeMedicalHelp(medical_help_d help) {
        System.out.println("sendDistributeMedicalHelp");
        System.out.println(help);
    }

    public int findDistributeMedicalHelpNum(String username) {
        if(!isDoctor(username))
            return 0;
        List<medical_help_d> helplist = messageDao.show_medical_help_d();
        return helplist.size()/10 + 1;
        
    }

    public List<medical_help_d> findDistributeMedicalHelpPage(String username, int page) {
        if(!isDoctor(username))
            return null;
        List<medical_help_d> helplist = messageDao.show_medical_help_d();
        List<medical_help_d> newlist = new ArrayList<medical_help_d>();
        for (int i = (page - 1) * 10; i < helplist.size() && i < page * 10; i++){
            newlist.add(helplist.get(i));
        }
        return newlist;
    }

    public medical_help_d findDistributeMedicalHelpContent(String username, int page, int num) {
        if(!isDoctor(username))
            return null;
        List<medical_help_d> helplist = messageDao.show_medical_help_d();
        return helplist.get((page - 1) * 10 + num - 1);
    }
    
    //Improvement: return a list of district
    String isBusiness(String username){
        List<BusinessAdmin> adminlist = userDao.show_businessadmin();
        BusinessAdmin tmp = null;
        int i = 0;
        String district = null;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username)){
                district = tmp.business_district;
                break;
            }
        }
        return district;
    }

    String isCommunity(String username){
        List<CommunityAdmin> adminlist = userDao.show_communityadmin();
        CommunityAdmin tmp = null;
        int i = 0;
        String community = null;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username)){
                community = tmp.community;
                break;
            }
        }
        return community;
    }

    Boolean isMedical(String username){
        List<MedicalAdmin> adminlist = userDao.show_medical_admin();
        MedicalAdmin tmp = null;
        int i = 0;
        for (; i < adminlist.size(); i++){
            tmp = adminlist.get(i);
            if(tmp.username.equals(username)){
                return true;
            }
        }
        return false;
    }

    Boolean isDoctor(String username){
        List<Doctor> doclist = userDao.show_doctor();
        Doctor tmp = null;
        int i = 0;
        for (; i < doclist.size(); i++){
            tmp = doclist.get(i);
            if(tmp.username.equals(username)){
                return true;
            }
        }
        return false;
    }

    List<String> totalCommunity(String community){
        List<Citizen> ctzlist = userDao.show_citizen();
        List<String> newlist = new ArrayList<String>();
        Citizen tmp = null;
        int num = 0;
        for (int i = 0; i < ctzlist.size(); i++){
            tmp = ctzlist.get(i);
            if(tmp.community.equals(community)){
                newlist.add(tmp.username);
            }
        }
        return newlist;
    }

    List<Apply_opening> findOpeningApply(String district){
        List<Apply_opening> applylist = messageDao.show_apply_opening();
        List<Apply_opening> newlist = new ArrayList<Apply_opening>();
        Apply_opening tmp = null;
        for (int i = 0; i < applylist.size(); i++){
            tmp = applylist.get(i);
            if(tmp.business_district.equals(district)){
                newlist.add(applylist.get(i));
            }
        }
        return newlist;
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
