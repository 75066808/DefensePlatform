package example.pojo.User;

public class User {
    public int id;
    public String username;
    public String password;
    public String real_name;

    public User(int id,
                String username,
                String password,
                String real_name){

        this.id = id;
        this.username = username;
        this.password = password;
        this.real_name = real_name;
    }
}
