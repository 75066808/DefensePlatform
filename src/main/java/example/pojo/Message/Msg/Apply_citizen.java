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
    public Apply_citizen(Map<String, Object> map) {
        this.username = (String)map.get("user");
        this.password = (String)map.get("pwd");
        this.phone_number = (String)map.get("phonenumber");
        this.email = (String)map.get("email");
        this.province = (String)map.get("province");
        this.address = (String)map.get("address");
        this.real_name = (String)map.get("real-name");
        this.community = (String)map.get("community");
        this.reason = (String)map.get("reason");
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
        map.put("community", this.community);
        map.put("reason", this.reason);
        map.put("time", Converter.durationReverseMap.get(this.duration));
        return map;
    }

    public Map<String, Object> toMapPart() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.username);
        return map;
    }
}
