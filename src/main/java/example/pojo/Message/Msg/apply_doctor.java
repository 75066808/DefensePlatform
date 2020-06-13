package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class apply_doctor {
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
    public int duration;
    public int checked;


    public apply_doctor(
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
            String invite_code,
            int duration,
            int checked
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
        this.duration = duration;
        this.checked = checked;
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, reason=res, invite-code=2222, time=forever}
    public apply_doctor(Map<String, Object> map) {
        this.username = (String)map.get("user");
        this.password = (String)map.get("pwd");
        this.phone_number = (String)map.get("phonenumber");
        this.email = (String)map.get("email");
        this.province = (String)map.get("province");
        this.address = (String)map.get("address");
        this.real_name = (String)map.get("real-name");
        this.certificate = (String)map.get("certificate-no");
        this.reason = (String)map.get("reason");
        this.invite_code = (String)map.get("invite-code");
        this.duration = Converter.durationMap.get((String)map.get("time"));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", this.username);
        map.put("pwd", this.password);
        map.put("phonenumber", this.phone_number);
        map.put("email", this.email);
        map.put("province", this.province);
        map.put("address", this.address);
        map.put("real_name", this.real_name);
        map.put("certificate_no", this.certificate);
        map.put("reason", this.reason);
        map.put("invite_code", this.invite_code);
        map.put("time", Converter.durationReverseMap.get(this.duration));
        return map;
    }

    public Map<String, Object> toMapPart() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.username);
        return map;
    }
}
