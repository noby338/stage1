package note;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * @Description 文件编码演示
 * @Author Noby
 * @Date 2023/3/18 21:31
 */
public class FileCodeNote {
    public static void main(String[] args) throws IOException {
        //region 乱码的字节流演示
        FileInputStream fileInputStream = new FileInputStream("day18/src/res/txtFile.txt");
        int i = fileInputStream.read();
        System.out.println(i);//228
        System.out.println((char) i);
        /*
        为什么不是0-127？
        因为进行了编码
         */
        FileInputStream fileInputStream1 = new FileInputStream("day18/src/res/txtFile.txt");

        byte[] bytes = new byte[3];
        fileInputStream1.read(bytes);
        System.out.println(new String(bytes));//该编码下，一个汉字占3个字节
        //endregion
    }
}
