package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class medical_help_d {
    public int medical_help_id;
    public String username;
    public String doctorname;
    public String password;
    public String phone_number;
    public String province;
    public String address;
    public String real_name;
    public int sex;
    public int age;
    public String department;
    public String symotoms;
    public int checked;


    public medical_help_d(
            int medical_help_id,
            String username,
            String doctorname,
            String password,
            String phone_number,
            String province,
            String address,
            String real_name,
            int sex,
            int age,
            String department,
            String symotoms,
            int checked
    ) {
        this.medical_help_id = medical_help_id;
        this.username = username;
        this.doctorname = doctorname;
        this.password = password;
        this.phone_number = phone_number;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.sex = sex;
        this.age = age;
        this.department = department;
        this.symotoms = symotoms;
        this.checked = checked;
    }

    // {user=zhang7, pwd=123, phonenumber=22222, province=Anhui, address=china, realname=urara, gender=male, age=99, department=1212, symptom=s, target-doctor=c}
    public medical_help_d(Map<String, Object> map) {
        this.username = (String)map.get("user");
        this.doctorname = (String)map.get("target-doctor");
        this.password = (String)map.get("pwd");
        this.phone_number = (String)map.get("phonenumber");
        this.province = (String)map.get("province");
        this.address = (String)map.get("address");
        this.real_name = (String)map.get("realname");
        this.sex = Converter.genderMap.get((String)map.get("gender"));
        this.age = Integer.parseInt((String)map.get("age"));
        this.department = (String)map.get("department");
        this.symotoms = (String)map.get("symptom");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", this.username);
        map.put("pwd", this.password);
        map.put("phonenumber", this.phone_number);
        map.put("province", this.province);
        map.put("address", this.address);
        map.put("realname", this.real_name);
        map.put("gender", Converter.genderReverseMap.get(this.sex));
        map.put("age", String.valueOf(this.age));
        map.put("department", this.department);
        map.put("symptom", this.symotoms);
        return map;
    }

    public Map<String, Object> toMapPart() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.username);
        map.put("department", this.department);
        return map;
    }
}
