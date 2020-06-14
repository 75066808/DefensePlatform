package example.pojo.User.Admin;

import example.pojo.Message.Msg.Apply_business;
import example.pojo.Message.Msg.Apply_medical_admin;
import example.pojo.Message.Msg.apply_commerical;

public class BusinessAdmin {
    public int apply_commerical_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public String reason;
    public String invite_code;
    public int duration;


    public BusinessAdmin(
            int apply_commerical_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            String reason,
            String invite_code,
            int duration
    ) {
        this.apply_commerical_id = apply_commerical_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
    }

    public BusinessAdmin(apply_commerical apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.business_district = apply.business_district;
        this.reason = apply.reason;
        this.invite_code = apply.invite_code;
        this.duration = apply.duration;
    }
}
