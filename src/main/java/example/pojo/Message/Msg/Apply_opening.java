package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_opening {
    public int apply_opening_id;
    public String username;
    public String password;
    public String business_district;
    public String email;
    public String shop_name;
    public int duration;
    public int checked;


    public Apply_opening(
            int apply_opening_id,
            String username,
            String password,
            String business_district,
            String email,
            String shop_name,
            int duration,
            int checked
    ) {
        this.apply_opening_id = apply_opening_id;
        this.username = username;
        this.password = password;
        this.business_district = business_district;
        this.email = email;
        this.shop_name = shop_name;
        this.duration = duration;
        this.checked = checked;
    }

    /*
    // {user=HLSSSS, pwd=123, business-district=bbb, shop-name=ffff, reason=ccc, time=forever}
    public static Apply_opening convertMapToClass(Map<String, Object> map) {
        return new Apply_opening(
                0,
                (String)map.get("user"),
                (String)map.get("pwd"),
                (String)map.get("business-district"),
                (String)map.get("shop-name"),
                (String)map.get("reason"),
                Converter.durationMap.get((String)map.get("time")),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(Apply_business apply) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", apply.username);
        map.put("pwd", apply.password);
        map.put("business_district", apply.business_district);
        map.put("shop_name", apply.business_district);
        map.put("reason", apply.business_district);
        map.put("time", Converter.durationReverseMap.get(apply.duration));
        return map;
    }
    */
}
