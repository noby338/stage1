package note.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class JdbcUtil {
    @SuppressWarnings("unchecked")
    public static <T> T GetInstance(Class<?> clazz) {
        //region 利用注解给对象赋值 方式1：注解写在对象上
        Object dataSource = null;
        try {
            dataSource = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (clazz.isAnnotationPresent(Jdbc.class)) {//DataSource类上是否存在Anno.class 的注解
            Jdbc annotation = clazz.getAnnotation(Jdbc.class);//获取Anno注解
            // 得到注解中的属性值

            ((DataSource) dataSource).setDataSourceDriver(annotation.driver());
            ((DataSource) dataSource).setDataSourceUrl(annotation.url());
            ((DataSource) dataSource).setDataSourceUsername(annotation.username());
            ((DataSource) dataSource).setDataSourcePwd(annotation.pwd());
        }
        //endregion
        return (T) dataSource;
    }

    @SuppressWarnings("unchecked")
    public static <T> T GetInstance2(Class<?> clazz) {
        //region 利用注解给对象赋值 方式2：注解写在属性上
        Object dataSource = null;
        try {
            dataSource = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Driver.class)) {
                String value = field.getAnnotation(Driver.class).value();
                String methodName = "get"
                        + field.getName().substring(0, 1).toUpperCase()//field.getName()获取属性的名字
                        + field.getName().substring(1);
                try {
                    Method method = clazz.getDeclaredMethod(methodName, field.getType());//field.getType()获取属性的种类
                    method.invoke(dataSource, value);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    field.setAccessible(true);
                    try {
                        field.set(dataSource, value);
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    }
                }

            } else if (field.isAnnotationPresent(Url.class)) {
                // url
            } else if (field.isAnnotationPresent(Username.class)) {
                // user
            } else if (field.isAnnotationPresent(Pwd.class)) {
                // pwd
            }
        }
        return (T) dataSource;
        //endregion
    }

}
