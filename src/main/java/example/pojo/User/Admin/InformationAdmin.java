package example.pojo.User.Admin;

import example.pojo.Message.Msg.Apply_info;

public class InformationAdmin {
    public int informationadmin_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String reason;
    public String invite_code;
    public int duration;


    public InformationAdmin(
            int informationadmin_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String reason,
            String invite_code,
            int duration
    ) {
        this.informationadmin_id = informationadmin_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
    }

    public InformationAdmin(Apply_info apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.reason = apply.reason;
        this.invite_code = apply.invite_code;
        this.duration = apply.duration;
    }

}
