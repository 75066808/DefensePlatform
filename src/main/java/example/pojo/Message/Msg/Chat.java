package example.pojo.Message.Msg;

import java.util.HashMap;
import java.util.Map;

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


    // {target=to, sender=test_usr, title=title, main-text=text }
    static Chat convertMapToClass(Map<String, Object> map) {
        return new Chat(
                0,
                (String)map.get("sender"),
                (String)map.get("target"),
                (String)map.get("main-text"),
                (String)map.get("title")
        );
    }

    static Map<String, Object> convertDataToClass(Chat chat) {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", chat.from_name);
        map.put("target", chat.to_name);
        map.put("main-text", chat.content);
        map.put("title", chat.title);
        return map;
    }

}
