package note.generic;

/**
 * 泛型的类型擦除
 * @author Noby
 * @since 2023/3/18 0:54
 */
public class TypeErasureNote {
    public static void main(String[] args) {
        Student<String> student = new Student<>();
    }
}

class Student<T>{
    T data;
    /*
     编译器在处理泛型时，将带有泛型的语句进行翻译，之后得到的类型是：
     class Student {
        Object data;
     }
     jvm(虚拟机)并不识别泛型，只运行编译器翻译后得到的字节码文件
     */
}

class Person<T extends Number> {//泛型通配符是写在方法参数列表里面用于限制参数的类型范围，这里非泛型通配符
    T data;
    /*
     编译器在处理泛型时，将带有泛型的语句进行翻译，之后得到的类型是：
     class Person {
        Number data;
     }
     */
}

