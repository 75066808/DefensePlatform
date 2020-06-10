package example.pojo.Message;

import example.pojo.Message.Msg.*;

public class Message {

    public int id;
    public String type;
    public Object message;

    public Message(Blogs blogs) {
        this.type = "blogs";
        this.message = blogs;
    }

    public Message(News news) {
        this.type = "news";
        this.message = news;
    }

    public Message(Routine routine) {
        this.type = "routine";
        this.message = routine;
    }

    public Message(Inquiry inquiry) {
        this.type = "inquiry";
        this.message = inquiry;
    }
}
