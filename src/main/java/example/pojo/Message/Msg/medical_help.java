package example.pojo.Message.Msg;

public class medical_help {
    public String username;
    public String password;
    public String phone_number;
    public String province;
    public String address;
    public String real_name;
    public int sex;
    public int age;
    public String symotoms;
    public int checked;


    public medical_help(
            String username,
            String password,
            String phone_number,
            String province,
            String address,
            String real_name,
            int sex,
            int age,
            String symotoms,
            int checked
    ) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.sex = sex;
        this.age = age;
        this.symotoms = symotoms;
        this.checked = checked;
    }

}
