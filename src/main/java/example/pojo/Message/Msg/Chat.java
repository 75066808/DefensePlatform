package example.pojo.Message.Msg;

public class Chat {
    public int from_id;
    public int to_id;
    public String content;
    public String time;//datetime型，八字节

    public Chat(
            int from_id,
            int to_id,
            String content,
            String time//datetime型，八字节

    ) {
        this.from_id = from_id;
        this.to_id = to_id;
        this.content = content;
        this.time = time;
    }

}
