package note;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

/**
 * 自定义实现根据配置文件加载JDBC，定义增删改查方法
 * @author Noby
 * @since 2023/3/20 23:38
 */
public class MyJdbcNote {
    private static final String proPath;
    private static final Properties properties;
    private static final String driver;
    private static final String url;
    private static final String user;
    private static final String password;
    private static Connection connection;
    static{
        properties = new Properties();
        //读取bin文件夹下文件的方法，(只要将文件放入src中，对应的bin文件夹也会出现该文件)
        proPath = MyJdbcNote.class.getClassLoader().getResource("db.properties").getPath();
        /*
        因为项目编写好之后是将bin目录进行打包，所以要得到bin文件夹下的配置文件
        Test.class   		获取到当前类的字节码对象,同时将src的文件复制到bin目录下
        getClassLoader()	获取类加载器，而且一个项目中一般情况下只有一个类加载器
        getResource(参数)    该方法返回该url对象，获取资源(文件)默认到bin文件夹下去获取，参数就是bin下的文件名
        getPath()			获取到路径

        读取src下的文件的方法：
		System.getProperty获取系统参数      user.dir当前项目的根路径
		path = System.getProperty("user.dir")+"\\src\\db.properties";
		System.out.println(path);
         */
        try {
            properties.load(new FileInputStream(proPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        user = properties.getProperty("jdbc.user");
        password = properties.getProperty("jdbc.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students,new Student(1,"noby"),new Student(3,"july"));
//        insert(students.get(1));
//        update(1,2,"kace");
//        selectAll();

    }

    static void insert(Student student) {
        PreparedStatement insert;
        try {
            insert = connection.prepareStatement("insert into student values(?,?)");
            insert.setInt(1,student.getId());
            insert.setString(2,student.getName());
            insert.execute();
            insert.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void update(int record,int id,String name) {
        PreparedStatement update;
        try {
            update = connection.prepareStatement("update student set sid = ?,sname = ? where sid = ?");
            update.setInt(1,id);
            update.setString(2,name);
            update.setInt(3,record);
            update.execute();
            update.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static void selectAll() {
        Statement select;
        try {
            select = connection.createStatement();

            ResultSet resultSet = select.executeQuery("select * from student");
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getString("sid") + ",name:" + resultSet.getString(2));
            }
            select.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
