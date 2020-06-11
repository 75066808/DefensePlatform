package example.service;

import example.dao.MessageDao;
import example.dao.UserDao;

import example.pojo.Message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    public List<Message> findMessages(String id) {
        return null;//messageDao.findMessages(id);
    }

    public List<Message> findMessages(String to, String type) {
        return null;//messageDao.findMessages(to, type);
    }

    public List<Message> findMessages(String from, String to, String type) {
        return null;//messageDao.findMessages(from, to, type);
    }


    public List<Message> fetchMessages(String type) {
        return null;//messageDao.fetchMessages(type);
    }


    public boolean sendMessage(Message message) {
        //messageDao.addMessage(message);
        return true;
    }

    public boolean sendMessage(Message message, List<String> usernames) {
        //messageDao.addMessage(message, usernames);
        return true;
    }


    public boolean modifyMessage(String id, Message message) {
        //messageDao.modifyMessage(message, id);
        return true;
    }

    public boolean deleteMessage(String id) {
        //messageDao.deleteMessage(id);
        return true;
    }

}
