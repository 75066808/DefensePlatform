package example.dao;
import example.pojo.Message.Message;
import example.pojo.Message.Msg.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

@Repository
public class MessageDao {



    public Blogs findBlogs(int blogs_id) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Blogs temp = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from blogs where id = " + blogs_id;
            rs = statement.executeQuery(sql);
            statement.executeUpdate(sql);
            if(rs.next()) temp = new Blogs(rs.getString("title"),rs.getString("content"),rs.getInt("blogs_id"));
            rs.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
        return temp;
    }


    public List<Message> findMessages(String to, String type) {
        return null;
    }

    public List<Message> findMessages(String from, String to, String type) {
        return null;
    }

    public void addblogs(Blogs blog) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into blogs (title,content,user_id) values ('" + blog.title +"','"+ blog.content +"'," + blog.user_id +")";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }

    public void addcomments(String content, int user_id, int blogs_id) {   //lid is unknown
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into comments (content,user_id,blogs_id) values ('" + content +"',"+ user_id +"," + blogs_id +")";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }


    public List<comment> findcomments(int blogs_id) {   //lid is unknown
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        List<comment> list = null;
        comment temp;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from comments where blogs_id" + " = " +blogs_id;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new comment(rs.getString("content"),rs.getInt("user_id"),rs.getInt("blogs_id"));
                list.add(temp);
            }
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
        return list;
    }
    public void deletecomment(int id) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql =  "delete from blogs where blogs_id = " + id;
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }

    public void addnews(News news) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into news (title,content,user_id) values ('" + news.title +"','"+ news.content +"'," + news.user_id +")";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }
    public News findnews(int id) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        News temp = null;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from news where id" + " = " + id;
            rs = statement.executeQuery(sql);
            if(rs.next()) temp = new News(rs.getString("title"),rs.getString("content"),rs.getInt("user_id"));

            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
        return temp;
    }
    public void addroutine(Routine routine) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into routine (receiver_id,routine_date,checked,content) values (" + routine.receiver_id +","+ "NOW()" +"," + routine.checked + ",'" +routine.content + "')";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }

    public void addinquiry(Inquiry inquiry) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into inquiry (user_id,title,content,inquiry_state) values (" + inquiry.user_id + ",'"+inquiry.title+"','"+inquiry.content+"',0)";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }
    public void applyinquiry(int doctor_id, String content , int inquiry_id) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in = new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "update inquiry set doctor_id=" + doctor_id + ",apply='" + content + "',inquiry_state=1 where id=" + inquiry_id;
            statement.executeUpdate(sql);
            con.close();
        } catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("完毕！");
        }
    }
    public Inquiry findinquiry(int inquiry_id) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        Inquiry temp = null;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from inquiry where id" + " = " + inquiry_id;
            rs = statement.executeQuery(sql);
            if(rs.next()) temp = new Inquiry(rs.getInt("user_id"),rs.getInt("doctor_id"),rs.getString("title"),rs.getString("content"),rs.getString("apply"),rs.getString("inquiry_date"),rs.getInt("inquiry_state"));
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
        return temp;
    }
    public void addchat (Chat chat) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        Inquiry temp = null;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into chat (from_id,to_id,content,time) values ("+","+chat.from_id+","+chat.time+",'"+chat.content+"','"+chat.time+ "')";
            statement.executeUpdate(sql);

            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }
    public void addopening(Openingapp openingapp) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "insert into opening_app (user_id,opening_date,app_date,checked,purpose,apply_state) values (" + openingapp.user_id + ",'"+openingapp.opening_date+"','"+openingapp.app_date+"',0,'"+ openingapp.purpose + "',0 )";
            statement.executeUpdate(sql);
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
    }
    public Openingapp findOpeningapp(int opening_app_id) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        Openingapp temp = null;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from opening_app where id" + " = " + opening_app_id;
            rs = statement.executeQuery(sql);
            if(rs.next()) temp = new Openingapp(rs.getInt("user_id"),rs.getString("opening_date"),rs.getString("app_date"),rs.getInt("checked"),rs.getString("purpose"),rs.getString("reason"),rs.getInt("apply_state"));
            con.close();
        }
        catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("完毕！");
        }
        return temp;
    }
    public void modifyMessage(Message message, String id) {

    }
    public void apply_opening (int opening_app_id, String reason ,int apply_state) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in = new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, seruser, serpassword);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + seruser + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "update opening_app set reason = '" + reason + "',apply_state ='" + apply_state + "',checked = 1 where id=" + opening_app_id;
            statement.executeUpdate(sql);
            con.close();
        } catch (ClassNotFoundException e) {
            // 数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            // 数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("完毕！");
        }
    }
}
