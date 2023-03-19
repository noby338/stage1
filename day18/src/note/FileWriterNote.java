package note;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description 字符输出流
 * 在使用FileWriter进行写操作时，数据通常是先被写入到缓冲区中，直到缓冲区被填满或者使用flush()方法强制写入文件才会将数据写入到文件中。
 * 这样做可以提高写入文件的效率，避免频繁地进行IO操作，提高程序的性能。同时，使用flush()方法可以确保在写入文件时数据不会丢失，特别是在程序异常退出时。
 * @Author Noby
 * @Date 2023/3/18 22:54
 */
public class FileWriterNote {
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
        FileWriter fileWriter = new FileWriter("day18/src/res/FileWriter.txt");
        fileWriter.write('A');
        fileWriter.write(97);
        //endregion

        //region 字符数组写出
        fileWriter.write("Hello".toCharArray());
        //endregion

        //region 字符串写出
        fileWriter.write("World中文");
        fileWriter.flush();//作用是
        //endregion

        fileWriter.close();
    }
}
