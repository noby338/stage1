package note;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池
 *
 * DataSource为java的数据库连接池标准接口(Druid为Alibaba的三方开源实现)
 * 获取模块class根目录方法
 *
 * @author Noby
 * @since 2022/10/3
 */
public class ConnectionPoolNote {
    public static void main(String[] args) throws Exception{
        //1、导入Druid jar包
        //2、定义配置文件
        Properties properties = new Properties();
        //获取模块class根目录方法
        properties.load(new FileInputStream(ConnectionPoolNote.class.getClassLoader().getResource("druid.properties").getPath()));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        Connection connection2 = dataSource.getConnection();
        Connection connection3 = dataSource.getConnection();

        System.out.println("connection = " + connection);
        System.out.println("connection2 = " + connection2);
        System.out.println("connection3 = " + connection3);
    }
}
