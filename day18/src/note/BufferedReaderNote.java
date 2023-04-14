package note;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 缓冲字符输入流
 * @author Noby
 * @since 2023/3/18 23:06
 */
public class BufferedReaderNote {
    public static void main(String[] args) throws IOException {
        //region 构造 要以字符输入流为参数构造
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("day18/src/res/txtFile.txt")
        );
        //endregion

        //region 以行读入字符串
        String line;
        while ((line = bufferedReader.readLine()) != null) {//readLine方法返回读取的行字符串，读取后指针指向下一行，当没有字符串的时候将会返回null
            System.out.println(line);
        }
        //endregion

    }
}
