package example.pojo.Message.Msg;

public class submission {
    public int submission_id;
    public String username;
    public String password;
    public String province;
    public String address;
    public String real_name;
    public int situation;
    public int color;
    public String sub_date;
    public int checked;


    public submission(
            int submission_id,
            String username,
            String password,
            String province,
            String address,
            String real_name,
            int situation,
            int color,
            String sub_date,
            int checked
    ) {
        this.submission_id = submission_id;
        this.username = username;
        this.password = password;
        this.province = province;
        this.address = address;
        this.real_name = real_name;
        this.situation = situation;
        this.color = color;
        this.sub_date = sub_date;
        this.checked = checked;
    }

}
