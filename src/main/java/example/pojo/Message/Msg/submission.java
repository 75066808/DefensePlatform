package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class submission {
    public int submission_id;
    public String username;
    public String password;
    public String province;
    public String address;
    public String real_name;
    public int age;
    public int situation;
    public int color;
    public String sub_date;
    public int checked;


    public submission(
            int submission_id,
            String username,
            String password,
            String province,
            String address,
            String real_name,
            int age,
            int situation,
            int color,
            String sub_date,
            int checked
    ) {
        this.submission_id = submission_id;
        this.username = username;
        this.password = password;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.age = age;
        this.situation = situation;
        this.color = color;
        this.sub_date = sub_date;
        this.checked = checked;
    }

    // {user=HLSSSS, pwd=123, province=Anhui, address=china, real-name=yuruijing, age=99, symptom=fever, color=grean}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, symptom=confirm, color=yellow}
    // {user=HLSSSS, pwd=123, province=Anhui, address=, real-name=, age=, color=orange}

    public submission(Map<String, Object> map) {
        this.username = (String)map.get("user");
        this.password = (String)map.get("pwd");
        this.province = (String)map.get("province");
        this.address = (String)map.get("address");
        this.real_name = (String)map.get("real-name");
        this.age = Integer.parseInt((String)map.get("age"));
        this.situation = map.containsKey("symptom0") ? 1 : 0;
        this.color = Converter.colorMap.get((String)map.get("color"));
    }


}
