package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    /*
    2.拷贝指定图片到项目文件夹下，文件名保持一致。
     */
    public static void main(String[] args) throws IOException {
        File copy = new File("day17\\src\\task\\res\\aaa\\举手素材.gif");
        FileInputStream fileInputStream = new FileInputStream(
                copy
        );
        File path = new File("day17\\src\\task\\res\\bbb");
        path.mkdir();
        File paste = new File(path, copy.getName());
        paste.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(
                paste
        );

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
