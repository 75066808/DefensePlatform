package example.dao;
import example.pojo.Message.Message;
import example.pojo.Message.Msg.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class MessageDao {



    /* public Blogs findBlogs(int blogs_id) {
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

     public List<Blogs> findBlogs(String part_content,String part_title,int user_id) {
         Connection con;
         String driver = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
         String seruser = "root";
         String serpassword = "password";
         Scanner in=new Scanner(System.in);
         String sql;
         ResultSet rs = null;
         int mes_count = 0;
         List<Blogs> temp = null;
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

             sql = "select * from blogs ";
             sql += "where ";
             if(part_content!=null) {
                 if(mes_count != 0){
                     sql += "and ";
                 }
                 sql += "content like %" + part_content +"%";
             }
             rs = statement.executeQuery(sql);
             statement.executeUpdate(sql);
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
 */
    public invite_code find_invite_code(String code){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        invite_code temp;
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
            sql = "select * from invite_code where "+code;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new invite_code(rs.getString(1),rs.getInt(2));
                return temp;
            }
            statement.executeUpdate(sql);
            con.close();
            return null;
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
        return null;
    };

    public void add_invite_code(invite_code invite_code) { // lid is known
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

            sql = "insert into invite_code (code, type) values ('"+ invite_code.code +"'," +invite_code.type+")";
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

    public void add_apply_medical_admin(Apply_medical_admin apply_medical_admin) { // lid is known
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

            sql = "insert into Apply_medical_admin (username, password, phone_number, email, province, address, real_name, certificate, invite_code, duration ,checked) values ('" + apply_medical_admin.username +"','"+ apply_medical_admin.password +"','" + apply_medical_admin.phone_number +"','" + apply_medical_admin.email +"','" + apply_medical_admin.province+"','" + apply_medical_admin.address+"','" + apply_medical_admin.real_name+"','" + apply_medical_admin.certificate +"','" + apply_medical_admin.invite_code + "'," +"0"+")";
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

    public void delete_apply_medical_admin(int medical_admin_id) { // lid is known
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

            sql = "delete from apply_medical_admin where medical_admin_id = " + medical_admin_id;
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

    List<Apply_medical_admin> show_apply_medical_admin() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_medical_admin temp;
        List<Apply_medical_admin> list = new ArrayList<Apply_medical_admin>();
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
            sql = "select * from apply_doctor ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_medical_admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }



    public void add_apply_doctor(apply_doctor apply_doctor) { // lid is known
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

            sql = "insert into apply_doctor (username,password,phone_number,email,province,address,real_name,certificate,reason,invite_code,checked) values ('" + apply_doctor.username +"','"+ apply_doctor.password +"','" + apply_doctor.phone_number +"','" + apply_doctor.email +"','" + apply_doctor.province+"','" + apply_doctor.address+"','" + apply_doctor.real_name+"','" + apply_doctor.certificate +"','" + apply_doctor.reason+"','" + apply_doctor.invite_code + "'," +"0"+")";
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
    public void delete_apply_doctor(int doctor_id) { // lid is known
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

            sql = "delete from apply_doctor where doctor_id = " + doctor_id;
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

    List<apply_doctor> show_apply_doctor() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        apply_doctor temp;
        List<apply_doctor> list = new ArrayList<apply_doctor>();
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
            sql = "select * from apply_doctor ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new apply_doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getInt(13));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }

    public void add_medical_help(medical_help medical_help) { // lid is known
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

            sql = "insert into medical_help (username,password,phone_number,province,address,real_name,sex,age,symotoms,checked) values ('" + medical_help.username +"','"+ medical_help.password +"','" + medical_help.phone_number +"','" + medical_help.province +"','" + medical_help.address+"','" + medical_help.real_name+"'," + medical_help.sex + "," + medical_help.age +",'" + medical_help.symotoms + "'," +"0"+")";
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

    public void delete_medical_help(int medical_help_id) { // lid is known
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

            sql = "delete from medical_help where medical_help_id = " + medical_help_id;
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

    List<medical_help> show_medical_help() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        medical_help temp;
        List<medical_help> list = new ArrayList<medical_help>();
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
            sql = "select * from medical_help ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new medical_help(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getInt(12));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }
    public void add_medical_help_d(medical_help_d medical_help_d) { // lid is known
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

            sql = "insert into medical_help_d (username,password,phone_number,province,address,real_name,sex,age,symotoms,checked) values ('" + medical_help_d.username +"','" + medical_help_d.doctorname +"','"+ medical_help_d.password +"','" + medical_help_d.phone_number +"','" + medical_help_d.province +"','" + medical_help_d.address+"','" + medical_help_d.real_name+"'," + medical_help_d.sex + "," + medical_help_d.age +",'" + medical_help_d.symotoms + "'," +"0"+")";
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

    public void delete_medical_help_d(int medical_help_id) { // lid is known
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

            sql = "delete from medical_help_d where medical_help_id = " + medical_help_id;
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

    List<medical_help_d> show_medical_help_d() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        medical_help_d temp;
        List<medical_help_d> list = new ArrayList<medical_help_d>();
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
            sql = "select * from medical_help_d ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new medical_help_d(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getInt(13));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }
    public void add_apply_community(apply_community apply_community) { // lid is known
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

            sql = "insert into apply_community (username,password,phone_number,email,province,address,community,reason,invite_code,duration,checked) values ('" + apply_community.username +"','"+ apply_community.password +"','" + apply_community.phone_number +"','" + apply_community.email +"','" + apply_community.province+"','" + apply_community.address+"','" + apply_community.community+"','" + apply_community.reason +"','" + apply_community.invite_code+"','" + apply_community.duration + "'," +"0"+")";
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

    public void delete_apply_community(int apply_community_id) { // lid is known
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

            sql = "delete from apply_community where apply_community_id = " + apply_community_id;
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

    List<apply_community> show_apply_community() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        apply_community temp;
        List<apply_community> list = new ArrayList<apply_community>();
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
            sql = "select * from apply_community ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new apply_community(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getInt(12));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }

    public void add_apply_commerical(apply_commerical apply_commerical) { // lid is known
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

            sql = "insert into apply_commerical (username,password,phone_number,email,province,address,business_district,reason,invite_code,duration,checked) values ('" + apply_commerical.username +"','"+ apply_commerical.password +"','" + apply_commerical.phone_number +"','" + apply_commerical.email +"','" + apply_commerical.province+"','" + apply_commerical.address+"','" + apply_commerical.business_district+"','" + apply_commerical.reason +"','" + apply_commerical.invite_code+"','" + apply_commerical.duration + "'," +"0"+")";
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

    public void delete_apply_commerical(int apply_commerical_id) { // lid is known
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

            sql = "delete from apply_commerical where apply_commerical_id = " + apply_commerical_id;
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

    List<apply_commerical> show_apply_commerical() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        apply_commerical temp;
        List<apply_commerical> list = new ArrayList<apply_commerical>();
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
            sql = "select * from medical_help ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new apply_commerical(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getInt(12));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }


    public void add_apply_opening(Apply_opening apply_opening) { // lid is known
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

            sql = "insert into apply_opening (username,password,business_distract,shop_name,duration,checked) values ('" + apply_opening.username +"','"+ apply_opening.password+"','" + apply_opening.business_district +"','" + apply_opening.shop_name+"','" +  apply_opening.duration + "'," +"0"+")";
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

    public void delete_apply_opening(int apply_opening_id) { // lid is known
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

            sql = "delete from apply_opening where apply_opening_id = " + apply_opening_id;
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

    List<Apply_opening> show_apply_opening() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_opening temp;
        List<Apply_opening> list = new ArrayList<Apply_opening>();
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
            sql = "select * from medical_help ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_opening(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }

    public void add_apply_info(Apply_info apply_info) { // lid is known
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

            sql = "insert into apply_info (username,password,phone_number,email,province,reason,invite_code,duration,checked) values ('" + apply_info.username +"','"+ apply_info.password +"','" + apply_info.phone_number +"','" + apply_info.email +"','" + apply_info.province+"','" + apply_info.reason+"','" + apply_info.invite_code+"','" + apply_info.duration + "'," +"0"+")";
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

    public void delete_apply_info(int apply_info_id) { // lid is known
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

            sql = "delete from apply_info where apply_info_id = " + apply_info_id;
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

    List<Apply_info> show_Apply_info() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_info temp;
        List<Apply_info> list = new ArrayList<Apply_info>();
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
            sql = "select * from apply_info ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_info(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }



    public void add_apply_main(Apply_main apply_main) { // lid is known
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

            sql = "insert into apply_main (username,password,phone_number,email,province,address,reason,invite_code,duration,checked) values ('" + apply_main.username +"','"+ apply_main.password +"','" + apply_main.phone_number +"','" + apply_main.email +"','" + apply_main.province+"','" + apply_main.reason+"','" + apply_main.invite_code+"','" + apply_main.duration + "'," +"0"+")";
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

    public void delete_apply_main(int apply_main_id) { // lid is known
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

            sql = "delete from apply_main where apply_main_id = " + apply_main_id;
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

    List<Apply_main> show_apply_main() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_main temp;
        List<Apply_main> list = new ArrayList<Apply_main>();
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
            sql = "select * from apply_main ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_main(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }


    public void add_apply_citizen(Apply_citizen apply_citizen) { // lid is known
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

            sql = "insert into apply_citizen (username,password,phone_number,email,province,address,real_name,community,reason,duration,checked) values ('" + apply_citizen.username +"','"+ apply_citizen.password +"','" + apply_citizen.phone_number +"','" + apply_citizen.email +"','" + apply_citizen.province+"','" + apply_citizen.address+"','" + apply_citizen.real_name+"','" + apply_citizen.community +"','" + apply_citizen.reason +"','" + apply_citizen.duration + "'," +"0"+")";
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

    public void delete_apply_citizen(int apply_citizen_id) { // lid is known
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

            sql = "delete from apply_citizen where apply_citizen_id = " + apply_citizen_id;
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

    List<Apply_citizen> show_apply_citizen() { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_citizen temp;
        List<Apply_citizen> list = new ArrayList<Apply_citizen>();
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
            sql = "select * from apply_citizen ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_citizen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getInt(12));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    }


    public void add_apply_business(Apply_business apply_business) { // lid is known
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

            sql = "insert into apply_business (username,password,phone_number,email,province,address,business_district,duration,checked) values ('" + apply_business.username +"','"+ apply_business.password +"','" + apply_business.phone_number +"','" + apply_business.email +"','" + apply_business.province+"','" + apply_business.address+"','" + apply_business.business_district+"','" + apply_business.duration + "'," +"0"+")";
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

    public void delete_apply_business(int apply_business_id) { // lid is known
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

            sql = "delete from apply_business where apply_business_id = " + apply_business_id;
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

    List<Apply_business> show_apply_business(){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Apply_business temp;
        List<Apply_business> list = new ArrayList<Apply_business>();
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
            sql = "select * from apply_business ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Apply_business(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    };

    public void addchat (Chat chat) { // lid is known
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

            sql = "insert into chat (from_name,to_name,content,title) values ("+","+chat.from_name+","+chat.to_name+",'"+chat.content+"','"+chat.title+ "')";
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
    List<Chat> show_chat_to(String username){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Chat temp;
        List<Chat> list = new ArrayList<Chat>();
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
            sql = "select * from chat where to_name = " +username;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Chat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(4));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    };

    List<medical_help_d> show_doctor_medical(String doctorname){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        medical_help_d temp;
        List<medical_help_d> list = new ArrayList<medical_help_d>();
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
            sql = "select * from medical_help_d where doctorname = " +doctorname;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new medical_help_d(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getInt(13));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    };

    public void add_submission(submission submission) { // lid is known
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

            sql = "insert into submission (submission_id, username, password, province, address, real_name, situation, color, sub_date, checked) values ('" + submission.username +"','"+ submission.password +"','" + submission.province +"','" + submission.address+"','" + submission.real_name+"'," + submission.situation + "," + submission.color +",'"+submission.sub_date + "',"  +"0"+")";
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

    public void delete_submission(int submission_id) { // lid is known
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

            sql = "delete from submission where submission_id = " + submission_id;
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

    List<submission> show_submission(){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        submission temp;
        List<submission> list = new ArrayList<submission>();
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
            sql = "select * from submission ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new submission(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
                list.add(temp);
            }
            statement.executeUpdate(sql);
            con.close();
            return list;
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
        return null;
    };
/*
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
    }*/
}
