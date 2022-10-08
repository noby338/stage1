package pra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamPra {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File("day17\\src\\pra\\res\\FileOutputStreamPra.txt")
        );
        String info = "this is a info";
        fileOutputStream.write(info.getBytes());
        fileOutputStream.close();
    }
}
