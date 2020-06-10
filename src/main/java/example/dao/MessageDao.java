package example.dao;
import example.pojo.Message.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    public List<Message> findMessages(String id) {
        return null;
    }

    public List<Message> findMessages(String to, String type) {
        return null;
    }

    public List<Message> findMessages(String from, String to, String type) {
        return null;
    }

    public void addMessage(Message message) { // lid is known

    }

    public void addMessageIntoNewList(Message message) {   //lid is unknown
        // insert into database
    }

    public void deleteMessage(String id) {

    }

    public void modifyMessage(Message message, String id) {

    }
}
