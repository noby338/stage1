package note;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 字节输入流的基本使用
 * @author Noby
 * @since 2023/3/18 22:15
 */
public class FileInputStreamNote {
    public static void main(String[] args) throws IOException {
        //region 构造
        /*
          public FileInputStream(File file)
          public FileInputStream(String name)

          注意：如果文件不存在，则运行报错(不会像输出流一样自动创建文件)
         */
        //endregion

        //region 通过字节读入数据
        method();
        //endregion

        //region 通过字节数组读入数据
        method2();
        //endregion

    }

    /**
     * 通过字节读入数据
     * @throws IOException
     */
    private static void method() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("day18/src/res/txtFile.txt");
        int by;
        String str = "";
        while ((by = fileInputStream.read()) != -1) {//read方法，调用一次返回一个读取到的字符，并将指针指向下一个字符，若未读取到字符则返回-1
            str += (char) by;
        }
        fileInputStream.close();//关闭字节输入流
        System.out.println("通过字节读入数据：\n" + str);
    }


    /**
     * 通过字节数组读入数据
     * @throws IOException
     */
    private static void method2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("day18/src/res/txtFile.txt");
        byte[] bytes = new byte[1024];
        int length;
        String str = "";
        while ((length = fileInputStream.read(bytes)) != -1) {
            str += new String(bytes, 0, length, StandardCharsets.UTF_8);
        }
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));
        //不能这么写，当文本中的字符串超过1024个字符时，会出现读入不全
//        int length = fileInputStream.read(bytes);
//        String str = new String(bytes, 0, length);
        System.out.println("通过字节数组读入数据：\n" + str);
    }
}
