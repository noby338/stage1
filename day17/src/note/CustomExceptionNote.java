package note;
/**
 * @Description 自定义异常的使用
 * 自定义异常必须手动抛出，自动抛出的异常必须为系统自带的
 * 主动抛出：异常通过throw关键字被手动抛出
 * 被动抛出：程序中没有通过throw关键字自动抛出
 * @Author Noby
 * @Date 2023/3/18 18:40
 */
public class CustomExceptionNote {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);//自动抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throw new MyThrowable();//主动抛出异常(自定义异常只能通过主动抛出)
        } catch (Exception myThrowable) {
            myThrowable.printStackTrace();
        }
    }
}

/**
 * @Description 自定义异常
 * @Author Noby
 * @Date 2023/3/18 19:47
 */
class MyThrowable extends Exception {//继承Exception的自定义异常，常用该方法定义自定义异常
    public MyThrowable() {
        super("自定义异常1");//调用Exception的构造方法，传入的参数为异常的打印信息
    }
    public MyThrowable(String info) {
        super(info);
    }
}