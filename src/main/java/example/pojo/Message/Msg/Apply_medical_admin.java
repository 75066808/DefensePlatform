package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_medical_admin {
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
    public int checked;


    public  Apply_medical_admin(
            int medical_admin_id,
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
            int checked
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
        this.checked = checked;
    }

    /*
    // {user=HLSSSS, pwd=123, phonenumber=2222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, certificate-no=123456, invite-code=2222, time=forever}
    public static Apply_medical_admin convertMapToClass(Map<String, Object> map) {
        return new Apply_medical_admin(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("real-name"),
                (String)map.get("certificate-no"),
                (String)map.get("invite-code"),
                Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(Apply_medical_admin apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("address", apply.address);
        map.put("business_district", apply.business_district);
        map.put("reason", apply.reason);
        map.put("invite_code", apply.invite_code);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }*/
}
