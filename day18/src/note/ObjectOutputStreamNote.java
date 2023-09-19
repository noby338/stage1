package note;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 对象输出流(序列化流：对象转换为流)
 * @author Noby
 * @since 2023/3/18 23:14
 */
public class ObjectOutputStreamNote {
    public static void main(String[] args) throws Exception {
        //region 构造
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("day18/src/res/ObjectOutputStream.txt")
        );
        //endregion

        //region writeObject
        Set<Person> people = new HashSet<>();
        people.add(new Person("noby",22));
        people.add(new Person("kace",21));
        people.add(new Person("july",19));
        people.add(new Person("tom",19));
        objectOutputStream.writeObject(people);
        //endregion

        objectOutputStream.close();
    }

}

