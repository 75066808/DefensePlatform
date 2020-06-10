package example.pojo.Message.Msg;

public class Routine {
    public int receiver_id;
    public String date;
    public String content;
    public int checked;

    public Routine(int receiver_id, String date, String content, int checked) {
        this.receiver_id = receiver_id;
        this.date = date;
        this.content = content;
        this.checked = checked;
    }
}
