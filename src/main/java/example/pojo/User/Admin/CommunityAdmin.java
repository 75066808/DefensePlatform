package example.pojo.User.Admin;

public class CommunityAdmin {
    public int communityadmin_id;
    public String username;
    public String password;
    public String phone_number;
    public String email;
    public String province;
    public String address;
    public String community;
    public String reason;
    public String invite_code;
    public int duration;


    public CommunityAdmin(
            int communityadmin_id,
            String username,
            String password,
            String phone_number,
            String email,
            String province,
            String address,
            String community,
            String reason,
            String invite_code,
            int duration
    ) {
        this.communityadmin_id = communityadmin_id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
        this.province = province;
        this.address = address;
        this.community = community;
        this.reason = reason;
        this.invite_code = invite_code;
        this.duration = duration;
    }

}
