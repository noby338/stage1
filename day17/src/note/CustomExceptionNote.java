package note;

public class CustomExceptionNote {//自定义异常
    /*
    自定义异常必须手动抛出，自动抛出的异常必须为系统自带的
    主动抛出：异常通过throw关键字被手动抛出
    被动抛出：程序中没有通过throw关键字自动抛出
     */
    public static void main(String[] args) {

        try {
            System.out.println(1/0);//自动抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            throw new MyThrowable1();//主动抛出异常(自定义异常只能通过主动抛出)
        } catch (Exception myThrowable1) {
            myThrowable1.printStackTrace();
        }
    }
}

class MyThrowable1 extends Exception {//继承Exception的自定义异常，常用该方法定义自定义异常
    public MyThrowable1 () {
        super("自定义异常1");//调用Exception的构造方法，传入的参数为异常的打印信息
    }
}