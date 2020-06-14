package example.pojo.User.Ordinary;

import example.pojo.Message.Msg.apply_doctor;

public class Doctor {
    public int doctor_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String real_name;
    public String certificate;
    public String reason;
    public String invite_code;


    public Doctor(
            int doctor_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String certificate,
            String reason,
            String invite_code
    ) {
        this.doctor_id = doctor_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.certificate = certificate;
        this.reason = reason;
        this.invite_code = invite_code;
    }

    public Doctor(apply_doctor apply) {
        this.doctor_id = apply.doctor_id;
        this.username = apply.username;
        this.password = apply.password;
        this.phone_number = apply.phone_number;
        this.email = apply.email;
        this.province = apply.province;
        this.address = apply.address;
        this.real_name = apply.real_name;
        this.certificate = apply.certificate;
        this.reason = apply.reason;
        this.invite_code = apply.invite_code;
    }
}