package example.pojo.User.Admin;

public class BusinessAdmin {
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public String reason;
    public String invite_code;
    public int duration;


    public BusinessAdmin(
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            String reason,
            String invite_code,
            int duration
    ) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
    }

}
