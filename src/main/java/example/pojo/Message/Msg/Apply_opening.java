package example.pojo.Message.Msg;

public class Apply_opening {
    public int apply_opening_id;
    public String username;
    public String password;
    public String business_district;
    public String email;
    public String shop_name;
    public int duration;
    public int checked;


    public Apply_opening(
            int apply_opening_id,
            String username,
            String password,
            String business_district,
            String email,
            String shop_name,
            int duration,
            int checked
    ) {
        this.apply_opening_id = apply_opening_id;
        this.username = username;
        this.password = password;
        this.business_district = business_district;
        this.email = email;
        this.shop_name = shop_name;
        this.duration = duration;
        this.checked = checked;
    }

}
