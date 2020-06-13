package example.dao;

import example.pojo.Message.Msg.*;
import example.pojo.User.Admin.*;
import example.pojo.User.Ordinary.Citizen;
import example.pojo.User.Ordinary.Doctor;
import example.pojo.User.Ordinary.Business_man;
import example.pojo.User.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class UserDao {

    public User findUser(int user_id) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user = "root";
        String password = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        User res = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + user + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from users where id = " + user_id;
            rs = statement.executeQuery(sql);
            if(rs.next()){
                res = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("real_name"));
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

        return res;
    }

    public List<User> findUsers(String username) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user = "root";
        String password = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        User temp = null;
        List<User> list = new ArrayList<User>();
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + user + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select * from users where username" + " = " +username;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("real_name"));
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

    public String findPassword(int user_id) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String user = "root";
        String password = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        String user_password = null;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("\n\t\t成功以 " + user + " 身份连接到数据库！！！");

            // 2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            // 要执行的SQL语句

            sql = "select password from users where id = " + user_id;
            rs = statement.executeQuery(sql);
            if (rs.next()){
                user_password =  rs.getString("password");
                return  user_password;
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

        return null;
    }

    public int addUser(User user) {
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

            sql = "insert into users (username,password,real_name) values ('" + user.username +"',"+ user.password +",'" + user.real_name +"')";
            statement.executeUpdate(sql);
            sql = "SELECT LAST_INSERT_ID()";
            rs = statement.executeQuery(sql);
            if (rs.next()){
                return  rs.getInt("LAST_INSERT_ID()");
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
        return 0;
    }
    /*
        public void addCitizen(String username, Citizen citizen) {

        }

        public void addDoctor(String username, Doctor doctor) {

        }

        public void addMerchant(String username, Merchant merchant) {

        }


        public void addSuperAdmin(String adminName, SuperAdmin superAdmin) {

        }

        public void addInformationAdmin(String adminName, InformationAdmin informationAdmin) {

        }

        public void addCommunityAdmin(String adminName, CommunityAdmin communityAdmin) {

        }


        public void addMedicalAdmin(String adminName, MedicalAdmin medicalAdmin) {

        }

        public void addBusinessAdmin(String adminName, BusinessAdmin businessAdmin) {

        }
    */
    public void modifyPassword(int user_id, String password) {
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

            sql =  "update users set password='" + password + "'where id = " + user_id;
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

    public void add_business_man(Business_man business_man) { // lid is known
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

            sql = "insert into business_man (username,password,phone_number,email,province,address,business_district,duration,checked) values ('" + business_man.username +"','"+ business_man.password +"','" + business_man.phone_number +"','" + business_man.email +"','" + business_man.province+"','" + business_man.address+"','" + business_man.business_district+"','" + business_man.duration +"')";
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
    public void add_businessadmin(BusinessAdmin businessadmin) { // lid is known
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

            sql = "insert into business_admin (username,password,phone_number,email,province,address,business_district,reason,invite_code,duration) values ('" + businessadmin.username +"','"+ businessadmin.password +"','" + businessadmin.phone_number +"','" + businessadmin.email +"','" + businessadmin.province+"','" + businessadmin.address+"','" + businessadmin.business_district+"','" + businessadmin.reason +"','" + businessadmin.invite_code+"','" + businessadmin.duration + "')";
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

    List<BusinessAdmin> find_businessadmin(String business_district) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        BusinessAdmin temp;
        List<BusinessAdmin> list = new ArrayList<BusinessAdmin>();
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
            sql = "select * from business_admin where business_district = "+business_district;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new BusinessAdmin(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
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

    List<Business_man> find_business_man(String business_district){
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Business_man temp;
        List<Business_man> list = new ArrayList<Business_man>();
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
            sql = "select * from business_man where business_district = "+business_district;
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Business_man(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
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

    public void add_citizen(Citizen citizen) { // lid is known
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

            sql = "insert into citizen (username,password,phone_number,email,province,address,realname,community,reason,duration,checked) values ('" + citizen.username +"','"+ citizen.password +"','" + citizen.phone_number +"','" + citizen.email +"','" + citizen.province+"','" + citizen.address+"','" + citizen.real_name+"','" + citizen.community +"','" + citizen.reason +"','" + citizen.duration + "')";
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
    List<Citizen> find_citizen(String community) { // lid is known
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        String seruser = "root";
        String serpassword = "password";
        Scanner in=new Scanner(System.in);
        String sql;
        ResultSet rs = null;
        Citizen temp;
        List<Citizen> list = new ArrayList<Citizen>();
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
            sql = "select * from Citizen ";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                temp = new Citizen(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
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

    public void add_Doctor(Doctor doctor) { // lid is known
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

            sql = "insert into doctor (username,password,phone_number,email,province,address,real_name,certificate,reason,invite_code) values ('" + doctor.username +"','"+ doctor.password +"','" + doctor.phone_number +"','" + doctor.email +"','" + doctor.province+"','" + doctor.address+"','" + doctor.real_name+"','" + doctor.certificate +"','" + doctor.reason+"','" + doctor.invite_code + "')";
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

}

