package example.pojo.User.Admin;

import example.pojo.Message.Msg.Apply_medical_admin;

public class MedicalAdmin {
    public int medical_admin_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String real_name;
    public String certificate;
    public String invite_code;
    public int duration;

    public MedicalAdmin(
            int medical_admin_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String certificate,
            String invite_code,
            int duration
    ) {
        this.medical_admin_id = medical_admin_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.certificate = certificate;
        this.invite_code = invite_code;
        this.duration = duration;
    }

    public MedicalAdmin(Apply_medical_admin apply) {
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.real_name = apply.real_name;
        this.certificate = apply.certificate;
        this.invite_code = apply.invite_code;
        this.duration = apply.duration;
    }
}