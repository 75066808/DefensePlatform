package example.pojo.Message.Msg;

public class Routine {
    public String receiver;
    public String date;
    public String content;
    public int checked;

    public Routine(String receiver, String date, String content, int checked) {
        this.receiver = receiver;
        this.date = date;
        this.content = content;
        this.checked = checked;
    }
}
