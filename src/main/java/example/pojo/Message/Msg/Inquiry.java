package example.pojo.Message.Msg;

public class Inquiry {
    public String username;
    public String doctorname;
    public String title;
    public String content;
    public String apply;
    public String inquiry_time;
    public int inquiry_state;

    public Inquiry(String username,
                   String doctorname,
                   String title,
                   String content,
                   String apply,
                   String inquiry_time,
                   int inquiry_state) {
        this.username = username;
        this.doctorname = doctorname;
        this.title = title;
        this.content = content;
        this.apply = apply;
        this.inquiry_time = inquiry_time;
        this.inquiry_state = inquiry_state;
    }
}
