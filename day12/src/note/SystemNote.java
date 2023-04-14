package note;

/**
 * System的基本使用
 * @author Noby
 * @since 2023/3/17
 */
public class SystemNote {
    public static void main(String[] args) {
        //System.nanoTime提供相对精确的计时，但是不能用他来计算当前日期。System.currentTimeMillis()返回以毫秒为单位的当前时间
        System.out.println("System.nanoTime() = " + System.nanoTime());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        //退出当前程序，0表示状态值为正常，其他为异常
//        System.exit(0);
        new Student();
        new Student();
        new Student();
        //jvm的垃圾回收
        System.gc();
    }
}

class Student {

    //清除垃圾时，会默认调用被清空对象的finalize方法。
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("垃圾已经被收取啦！");
    }
}
