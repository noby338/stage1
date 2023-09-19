package note;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

/**
 * Properties的基本使用
 * @author Noby
 * @since 2023/3/17
 */
public class PropertiesNote {
    public static void main(String[] args) throws Exception{
        //配置文件以.properties为后缀
        Properties properties = new Properties();//属于Map集合

        //region properties集合的特有方法
        properties.setProperty("one","hello");//若用setProperty()方法，值只能存储字符串。Map中的put()方法值可以为任意类型
        properties.setProperty("two","world");
        properties.setProperty("three","java");

        System.out.println(properties.getProperty("one"));//相当于Map()中的get()方法

        Set<String> strings = properties.stringPropertyNames();//相当于Map中的keySet()方法
        System.out.println(strings);
        //endregion

        //region 将properties存储到配置文件
        FileOutputStream fos = new FileOutputStream("D:\\IdeaProjects\\stage1\\day15\\src\\PropertiesStore.properties");
        properties.store(fos,"这是一行注释");
        //endregion

        //region 将配置文件读取到properties集合中 利用配置文件的优点在于在不修改代码(通过配置文件)的前提下更改程序
        loadProperties();
        //endregion
    }

    private static void loadProperties() throws Exception{
        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\stage1\\day15\\src\\PropertiesStore.properties");
        Properties properties1 = new Properties();
        properties1.load(fis);
        Set<String> set = properties1.stringPropertyNames();
        System.out.println("以下遍历从配置文件读取到的键值对");
        for (String s : set) {
            System.out.println(s + "..." + properties1.getProperty(s));
        }
    }
}
