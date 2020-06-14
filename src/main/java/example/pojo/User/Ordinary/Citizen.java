package example.pojo.User.Ordinary;

import example.pojo.Message.Msg.Apply_citizen;

public class Citizen {
    public int citizen_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String community;
    public String reason;
    public String real_name;
    public int duration;


    public Citizen(
            int citizen_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String community,
            String reason,
            int duration
    ) {
        this.citizen_id = citizen_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.community = community;
        this.reason = reason;
        this.real_name = real_name;
        this.duration = duration;
    }

    public Citizen(Apply_citizen apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.community = apply.community;
        this.reason = apply.reason;
        this.real_name = apply.real_name;
        this.duration = apply.duration;
    }
}