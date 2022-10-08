package note;

import java.io.*;

public class FileInputStreamNote {//字节输入流
    public static void main(String[] args) throws IOException {
        //region 构造
        /*
          public FileInputStream(File file)
          public FileInputStream(String name)

          注意：如果文件不存在，则运行报错(不会像输入流一样自动创建文件)
         */
        //endregion

        //region 通过字节读入数据
        method();
        //endregion

        //region 通过字节数组读入数据
        method1();
        //endregion

    }

    private static void method1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("day17\\src\\note\\res\\FileOutputStreamNote.txt");
        byte[] bytes = new byte[7];
        int length;
        String str = "";
        while ((length = fileInputStream.read(bytes)) != -1) {
            str += new String(bytes, 0, length);
        }
        System.out.println("通过字节数组读入数据" + str);
    }

    private static void method() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("day17\\src\\note\\res\\FileOutputStreamNote.txt");
        int by;
        String str = "";
        while ((by = fileInputStream.read()) != -1) {
            str += (char)by;
        }
        fileInputStream.close();//关闭字节输入流
        /*
        read方法，调用一次返回一个读取到的字符，并将指针指向下一个字符，若未读取到字符这返回-1
         */
        System.out.println("通过字节读入数据" + str);
    }
}
