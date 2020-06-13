package example.pojo.User.Admin;

public class SuperAdmin {
    public int superadmin_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String reason;
    public String invite_code;
    public int duration;
    public int checked;


    public SuperAdmin(
            int superadmin_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String reason,
            String invite_code,
            int duration,
            int checked
    ) {
        this.superadmin_id = superadmin_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
        this.checked = checked;
    }

}
