package note;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcPra {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java87");
        Statement statement = connection.createStatement();
        statement.execute("delete from boy where name = 'kace'");
        connection.close();
        statement.close();
    }
}
