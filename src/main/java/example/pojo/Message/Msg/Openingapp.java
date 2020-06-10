package example.pojo.Message.Msg;

public class Openingapp {
    public int user_id;
    public String opening_date;
    public String app_date;
    public int checked;
    public String purpose;
    public String reason;
    public int apply_state;

    public Openingapp(int user_id,
                   String opening_date,
                   String app_date,
                   int checked,
                   String purpose,
                   String reason,
                   int apply_state) {
        this.user_id = user_id;
        this.opening_date = opening_date;
        this.app_date = app_date;
        this.checked = checked;
        this.purpose = purpose;
        this.reason = reason;
        this.apply_state = apply_state;
    }
}
