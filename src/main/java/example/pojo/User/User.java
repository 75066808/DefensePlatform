package example.pojo.User;
import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.*;

public class User {
    public int id;
    public String username;
    public String address;
    public int age;
    public int type;


    public User(int id,
                String username,
                String address,
                int age,
                int type) {

        this.id = id;
        this.username = username;
        this.address = address;
        this.age = age;
        this.type = type;
    }
}
