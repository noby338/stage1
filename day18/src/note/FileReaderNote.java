package note;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderNote {//字符输入流
    public static void main(String[] args) throws IOException {
        //region 字符数组读入
        method();
        //endregion

        //region 字符读入
        method1();
        //endregion

    }

    private static void method1() throws IOException {
        FileReader fileReader = new FileReader("day18\\src\\res\\englishtxtfile.txt");
        int ch;
        String str = "";
        while ((ch = fileReader.read()) != -1) {
            str += (char) ch;
        }
        System.out.println("字符读入"+str);
    }

    private static void method() throws IOException {
        FileReader fileReader = new FileReader("day18\\src\\res\\englishtxtfile.txt");
        char[] chars = new char[100];
        int len;
        String str = "";
        while ((len = fileReader.read(chars)) != -1) {
            str += new String(chars,0,len);
        }
        System.out.println("字符数组读入"+str);
    }
}
