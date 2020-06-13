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
    public static apply_doctor convertMapToClass(Map<String, Object> map) {
        return new apply_doctor(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("real-name"),
                (String)map.get("certificate-no"),
                (String)map.get("reason"),
                (String)map.get("invite-code"),
                //Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(apply_doctor apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("address", apply.address);
        map.put("real_name", apply.real_name);
        map.put("certificate_no", apply.certificate);
        map.put("reason", apply.reason);
        map.put("invite_code", apply.invite_code);
        // map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
}
