package note;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Description 字符输入流
 * @Author Noby
 * @Date 2023/3/18 22:59
 */
public class FileReaderNote {
    public static void main(String[] args) throws IOException {
        //region 字符数组读入
        method();
        //endregion

        //region 字符读入
        method2();
        //endregion

    }

    private static void method() throws IOException {
        FileReader fileReader = new FileReader("day18/src/res/txtFile.txt");
        char[] chars = new char[1024];
        int len;
        String str = "";
        while ((len = fileReader.read(chars)) != -1) {
            str += new String(chars, 0, len);
        }
        System.out.println("字符数组读入：\n" + str);
    }

    private static void method2() throws IOException {
        FileReader fileReader = new FileReader("day18/src/res/txtFile.txt");
        int ch;
        String str = "";
        while ((ch = fileReader.read()) != -1) {
            str += (char) ch;
        }
        System.out.println("字符读入：\n" + str);
    }


}
