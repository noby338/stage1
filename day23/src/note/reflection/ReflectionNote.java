package note.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 反射的基本使用
 * @author Noby
 * @since 2023/3/21 0:32
 */
public class ReflectionNote {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //region 获取字节码对象的方法，Class<?>是一个存放字节码对象的类
        //方式一 通过Class类的forName方法
        Class<?> personClass = Class.forName("note.reflection.Person");//注意使用全限定名
        //方式二 通过类的class静态属性
        personClass = Person.class;
        //方式三 通过对象的getClass()方法
        personClass = new Person().getClass();

        System.out.println("personClass = " + personClass);//class Person
        //endregion

        //region  创建对象
        //方式一 通过newInstance()方法
        Person person = (Person) personClass.newInstance();//只能得到无参构造方法生成的对象
        //方式二 通过获取构造方法 必须通过对应的构造方法创建对象
        Constructor<?> personConstructor = personClass.getConstructor(String.class, int.class);
        System.out.println("personConstructor = " + personConstructor);
        /*
        String.class int.class表示传入的第一个参数为String，第二个参数为int 的构造函数
         */
        Person noby = (Person) personConstructor.newInstance("noby", 20);//得到有参构造方法生成的对象
        Person kace = (Person) personClass.getConstructor().newInstance();//得到无参构造方法生成的对象
        System.out.println("noby = " + noby);
        System.out.println("kace = " + kace);
        //endregion

        //region 操作属性
        Field name = personClass.getDeclaredField("name");//获取指定属性(并没有指定是哪一对象的属性)
        System.out.println("name = " + name);//打印的是该属性的信息，而不是某个对象的属性值
        Field[] declaredFields = personClass.getDeclaredFields();//获取所有属性
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
        name.setAccessible(true);//如果访问的属性为私有属性，则需开启强制访问(不推荐，通常调用getter、setter方法)
        name.set(kace, "kace");//第一个参数为值得赋予对象，第二个参数为赋予的值，name表示赋予的属性
        //endregion

        //region 操作方法
        Method show = personClass.getDeclaredMethod("show", null);//获取无参方法
        Method say = personClass.getDeclaredMethod("say", String.class, int.class);//获取有参方法
        Method[] declaredMethods = personClass.getDeclaredMethods();//获取所有方法
        show.invoke(kace, null);//调用方法
        String hi = (String) say.invoke(kace, "hi",2);
        System.out.println(hi);
        //endregion
    }
}

