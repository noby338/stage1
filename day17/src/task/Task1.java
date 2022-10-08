package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {
    /*
    1.练习复制文件2种方式
     */
    public static void main(String[] args) throws IOException {
        File aaa = new File("day17\\src\\task\\res\\aaa");
        aaa.mkdirs();
        File copy = new File(aaa, "copy");
        copy.createNewFile();
        FileOutputStream fileOutputStream0 = new FileOutputStream(copy);
        fileOutputStream0.write("copystring".getBytes());


        method(copy);
        method1(copy);


    }

    private static void method1(File copy) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(copy);
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File("day17\\src\\task\\res\\paste1")
        );
        int i;
        while ((i = fileInputStream.read()) != -1) {
            fileOutputStream.write(i);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void method(File copy) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(copy);
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File("day17\\src\\task\\res\\paste")
        );
        int len;
        byte[] bytes = new byte[1024];
        String str = "";
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
