package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class apply_community {
    public int apply_community_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String community;
    public String reason;
    public String invite_code;
    public int duration;
    public int checked;


    public apply_community(
            int apply_community_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String community,
            String reason,
            String invite_code,
            int duration,
            int checked
    ) {
        this.apply_community_id = apply_community_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.community = community;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
        this.checked = checked;
    }


    // {user=HLSSSS, pwd=123, phonenum=1392361111, email=75066808@qq.com, province=Fujian, address=china, community-name=fff, reason=reason, invite-code=2222, time=forever}
    public static apply_community convertMapToClass(Map<String, Object> map) {
        return new apply_community(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenum"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("community-name"),
                (String)map.get("reason"),
                (String)map.get("invite-code"),
                Converter.durationMap.get((String)map.get("time")),
                0
                );
    }

    public static Map<String, Object> convertClassToMap(apply_community apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("address", apply.address);
        map.put("community_name", apply.community);
        map.put("reason", apply.reason);
        map.put("invite_code", apply.invite_code);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
}
