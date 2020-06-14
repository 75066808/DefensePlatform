package example.pojo.User.Admin;

import example.pojo.Message.Msg.Apply_main;

public class SuperAdmin {
    public int superadmin_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String reason;
    public String invite_code;
    public int duration;


    public SuperAdmin(
            int superadmin_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String reason,
            String invite_code,
            int duration
    ) {
        this.superadmin_id = superadmin_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
    }

    public SuperAdmin(Apply_main apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.reason = apply.reason;
        this.invite_code = apply.invite_code;
        this.duration = apply.duration;
    }

}
