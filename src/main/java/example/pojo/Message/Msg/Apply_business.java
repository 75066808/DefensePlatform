package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_business {
    public int apply_business_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public int duration;
    public int checked;


    public Apply_business(
            int apply_business_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            int duration,
            int checked
    ) {
        this.apply_business_id = apply_business_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.duration = duration;
        this.checked = checked;
    }

    // {user=HLSSSS, pwd=123, phonenumber=22222, email=75066808@qq.com, province=Anhui, address=china, business-district=bbb, time=forever}
    public Apply_business (Map<String, Object> map) {
        this.username = (String) map.get("user");
        this.password = (String) map.get("pwd");
        this.phone_number = (String) map.get("phonenumber");
        this.email = (String) map.get("email");
        this.province = (String) map.get("province");
        this.address = (String) map.get("address");
        this.business_district = (String) map.get("business-district");
        this.duration = Converter.durationMap.get((String) map.get("time"));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", this.username);
        map.put("pwd", this.password);
        map.put("phonenumber", this.phone_number);
        map.put("email", this.email);
        map.put("province", this.province);
        map.put("address", this.address);
        map.put("business_district", this.business_district);
        map.put("time", Converter.durationReverseMap.get(this.duration));
        return map;
    }

    public Map<String, Object> toMapPart() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.username);
        return map;
    }
}