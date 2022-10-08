package pra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamPra {
    public static void main(String[] args) throws IOException {
        File file = new File("day17\\src\\pra\\res\\FileOutputStreamPra.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len;
        String res = "";
        while ((len = fileInputStream.read(bytes)) != -1) {
            res += new String(bytes, 0, len);
        }
        System.out.println(res);

        //region
        FileInputStream fileInputStream1 = new FileInputStream(
                new File("day17\\src\\pra\\res\\FileOutputStreamPra.txt")
        );
        int c;
        String str = "";
        while ((c = fileInputStream1.read()) != -1) {
            str += (char) c;
        }
        System.out.println("str = " + str);
        //endregion

    }
}
