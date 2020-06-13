package example.pojo.User.Ordinary;

public class Business_man {
    public int business_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public int duration;


    public Business_man(
            int business_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            int duration
    ) {
        this.business_id = business_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.duration = duration;
    }

}