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
    public static Apply_business convertMapToClass(Map<String, Object> map) {
        return new Apply_business(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("email"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("business-district"),
                Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(Apply_business apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("phonenumber", apply.phone_number);
        map.put("email", apply.email);
        map.put("province", apply.province);
        map.put("address", apply.address);
        map.put("business_district", apply.business_district);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
}
