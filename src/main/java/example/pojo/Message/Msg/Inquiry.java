package example.pojo.Message.Msg;

public class Inquiry {
    public int user_id;
    public int doctor_id;
    public String title;
    public String content;
    public String apply;
    public String inquiry_time;
    public int inquiry_state;

    public Inquiry(int user_id,
                   int doctor_id,
                   String title,
                   String content,
                   String apply,
                   String inquiry_time,
                   int inquiry_state) {
        this.user_id = user_id;
        this.doctor_id = doctor_id;
        this.title = title;
        this.content = content;
        this.apply = apply;
        this.inquiry_time = inquiry_time;
        this.inquiry_state = inquiry_state;
    }
}
