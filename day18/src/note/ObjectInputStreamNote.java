package note;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 对象输入流(反序列化流：流转换为对象)
 * @author Noby
 * @since 2023/3/18 23:15
 */
public class ObjectInputStreamNote {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //region 构造
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("day18/src/res/ObjectOutputStream.txt")
        );
        //endregion

        //region readObject
        Set<Person> person= (HashSet<Person>)objectInputStream.readObject();
        for (Person value : person) {
            System.out.println(value);
        }
        //endregion

        objectInputStream.close();

    }
}
