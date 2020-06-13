package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class Apply_opening {
    public int apply_opening_id;
    public String username;
    public String password;
    public String business_district;
    public String shop_name;
    public String reason;
    public int duration;
    public int checked;


    public Apply_opening(
            int apply_opening_id,
            String username,
            String password,
            String business_district,
            String shop_name,
            String reason,
            int duration,
            int checked
    ) {
        this.apply_opening_id = apply_opening_id;
        this.username = username;
        this.password = password;
        this.business_district = business_district;
        this.shop_name = shop_name;
        this.reason = reason;
        this.duration = duration;
        this.checked = checked;
    }


    // {user=HLSSSS, pwd=123, business-district=bbb, shop-name=ffff, reason=ccc, time=forever}
    public Apply_opening(Map<String, Object> map) {
        this.username = (String)map.get("user");
        this.password = (String)map.get("pwd");
        this.business_district = (String)map.get("business-district");
        this.shop_name = (String)map.get("shop-name");
        this.reason = (String)map.get("reason");
        this.duration = Converter.durationMap.get((String)map.get("time"));
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", this.username);
        map.put("pwd", this.password);
        map.put("business_district", this.business_district);
        map.put("shop_name", this.business_district);
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
