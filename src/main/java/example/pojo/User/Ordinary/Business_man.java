package example.pojo.User.Ordinary;

import example.pojo.Message.Msg.Apply_business;

public class Business_man {
    public int business_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public int duration;


    public Business_man(
            int business_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            int duration
    ) {
        this.business_id = business_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.duration = duration;
    }

    public Business_man(Apply_business apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.business_district = apply.business_district;
        this.duration = apply.duration;
    }

}