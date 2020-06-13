package example.pojo.User.Ordinary;

public class Citizen {
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String community;
    public String reason;
    public String real_name;
    public int duration;


    public Citizen(
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String real_name,
            String community,
            String reason,
            int duration
    ) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.community = community;
        this.reason = reason;
        this.real_name = real_name;
        this.duration = duration;
    }
}