package example.pojo.User;

public class User {
    public int id;
    public String username;
    public String address;
    public int age;
    public int type;
    public int supervisor;
    public int vise_type;

    public User(int id,
                String username,
                String address,
                int age,
                int type,
                int supervisor,
                int vise_type) {

        this.id = id;
        this.username = username;
        this.address = address;
        this.age = age;
        this.type = type;
        this.supervisor = supervisor;
        this.vise_type = vise_type;
    }
}
