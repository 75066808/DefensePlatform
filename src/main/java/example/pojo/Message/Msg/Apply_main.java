package example.pojo.Message.Msg;

public class Apply_main {
    public int apply_main_id;
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


    public Apply_main(
            int apply_main_id,
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
        this.apply_main_id = apply_main_id;
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
