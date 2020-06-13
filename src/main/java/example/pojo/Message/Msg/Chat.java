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
    public Chat(Map<String, Object> map) {
        this.from_name = (String)map.get("sender");
        this.to_name = (String)map.get("target");
        this.content = (String)map.get("main-text");
        this.title = (String)map.get("title");
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.from_name);
        map.put("target", this.to_name);
        map.put("main_text", this.content);
        map.put("title", this.title);
        return map;
    }

    public Map<String, Object> toMapPart() {
        Map<String, Object> map = new HashMap<>();
        map.put("sender", this.from_name);
        map.put("title", this.title);
        return map;
    }

}
