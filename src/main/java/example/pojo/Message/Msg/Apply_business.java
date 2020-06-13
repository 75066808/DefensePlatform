package example.pojo.Message.Msg;

public class Apply_business {
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String business_district;
    public int duration;
    public int checked;


    public Apply_business(
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String business_district,
            int duration,
            int checked
    ) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.business_district = business_district;
        this.duration = duration;
        this.checked = checked;
    }

}
