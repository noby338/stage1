package note;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterNote {//缓冲字符输出流
    public static void main(String[] args) throws IOException {
        //region 构造 要以字符输出流为参数构造
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("day18\\src\\res\\BufferedWriter.txt")
        );
        //endregion

        //region 字符串写出
        bufferedWriter.write("buffereWriter");
        bufferedWriter.newLine();//换行
        bufferedWriter.write("this is newline");
        bufferedWriter.flush();
        bufferedWriter.close();//此处只需调用一次close方法，filewriter也将会被关闭
        //endregion
    }
}
