package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_citizen {
    public int apply_citizen_id;
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
    public int checked;


    public Apply_citizen(
            int apply_citizen_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String community,
            String reason,
            int duration,
            int checked
    ) {
        this.apply_citizen_id = apply_citizen_id;
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
        this.checked = checked;
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, real-name=yuruijing, community=cc, reason=res, time=forever}
    public static Apply_citizen convertMapToClass(Map<String, Object> map) {
        return new Apply_citizen(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("real-name"),
                (String)map.get("community"),
                (String)map.get("reason"),
                Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(Apply_citizen apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("address", apply.address);
        map.put("real_name", apply.real_name);
        map.put("community", apply.community);
        map.put("reason", apply.reason);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
}
