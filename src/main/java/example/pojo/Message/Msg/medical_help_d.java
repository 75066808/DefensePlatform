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
    public static medical_help_d convertMapToClass(Map<String, Object> map) {
        return new medical_help_d(
                0,
                (String)map.get("user"),
                (String)map.get("target-doctor"),
                (String)map.get("pwd"),
                (String)map.get("phonenumber"),
                (String)map.get("province"),
                (String)map.get("address"),
                (String)map.get("realname"),
                Converter.genderMap.get((String)map.get("gender")),
                Integer.parseInt((String)map.get("age")),
                (String)map.get("department"),
                (String)map.get("symptom"),
                0
        );
    }

    public static Map<String, Object> convertClassToMap(medical_help_d help) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", help.username);
        map.put("pwd", help.password);
        map.put("phonenumber", help.phone_number);
        map.put("province", help.province);
        map.put("address", help.address);
        map.put("realname", help.real_name);
        map.put("gender", Converter.genderReverseMap.get(help.sex));
        map.put("age", String.valueOf(help.age));
        map.put("department", help.department);
        map.put("symptom", help.symotoms);
        return map;
    }
}
