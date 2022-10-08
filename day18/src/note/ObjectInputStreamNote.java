package note;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class ObjectInputStreamNote {//对象输入流(反序列化流：流转换为对象)
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //region 构造
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("day18\\src\\res\\ObjectOutputStream.txt")
        );
        //endregion

        //region readObject
        HashSet<Person> person= (HashSet<Person>)objectInputStream.readObject();
        Iterator<Person> iterator = person.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //endregion

    }
}
