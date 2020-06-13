package example.pojo.User.Admin;
public class MedicalAdmin {
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String real_name;
    public String certificate;
    public String invite_code;
    public int checked;


    public MedicalAdmin(
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String certificate,
            String invite_code,
            int checked
    ) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.certificate = certificate;
        this.invite_code = invite_code;
        this.checked = checked;
    }
}