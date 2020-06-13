package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_info {
    public int apply_info_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String reason;
    public String invite_code;
    public int duration;
    public int checked;


    public Apply_info(
            int apply_info_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String reason,
            String invite_code,
            int duration,
            int checked
    ) {
        this.apply_info_id = apply_info_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
        this.checked = checked;
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, reason=res, invite-code=2222, time=forever}
    public static Apply_info convertMapToClass(Map<String, Object> map) {
        return new Apply_info(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("reason"),
                (String)map.get("invite-code"),
                Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(Apply_info apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("reason", apply.reason);
        map.put("invite_code", apply.invite_code);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
}
