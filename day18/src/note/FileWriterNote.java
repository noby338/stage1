package note;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterNote {//字符输出流
    public static void main(String[] args) throws IOException {
        //region 构造方法
        /*
          public FileWriter(File file)
          public FileWriter(String fileName)
          public FileWriter(File file, boolean append)
          public FileWriter(String fileName, boolean append)
         */
        //endregion

        //region 字符写出
        FileWriter fileWriter = new FileWriter("day18\\src\\res\\FileWriter.txt");
        fileWriter.write('A');
        fileWriter.write(97);
        fileWriter.flush();//刷新
        //endregion

        //region 字符数组写出
        fileWriter.write("Hello".toCharArray());
        fileWriter.flush();
        //endregion

        //region 字符串写出
        fileWriter.write("World");
        fileWriter.flush();
        //endregion

        fileWriter.close();
    }
}
