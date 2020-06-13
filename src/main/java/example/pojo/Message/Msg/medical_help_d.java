package example.pojo.Message.Msg;

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

}
