package example.pojo.Message.Msg;

public class Chat {
    public int from_name;
    public int to_name;
    public String content;
    public String title;//datetime型，八字节

    public Chat(
            int from_name,
            int to_name,
            String content,
            String title

    ) {
        this.from_name = from_name;
        this.to_name = to_name;
        this.content = content;
        this.title = title;
    }

}
