package example.pojo.Message.Msg;

public class Chat {
    public int chat_id;
    public String from_name;
    public String to_name;
    public String content;
    public String title;//datetime型，八字节

    public Chat(
            int chat_id,
            String from_name,
            String to_name,
            String content,
            String title

    ) {
        this.chat_id = chat_id;
        this.from_name = from_name;
        this.to_name = to_name;
        this.content = content;
        this.title = title;
    }

}
