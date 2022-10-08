package pra;

import java.io.File;
import java.io.IOException;

public class FilePra {
    public static void main(String[] args) throws IOException {
        File file = new File("day17\\src\\pra\\res\\FilePra.txt");
        System.out.println(file.createNewFile());
        System.out.println(new File("day17\\src\\pra\\res\\aaa\\bbb").mkdirs());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
        System.out.println(file.length());
        file.delete();
        System.out.println(file.exists());

        File file1 = new File("day17\\src\\pra\\res\\aaa\\bbb\\ccc");
        System.out.println("file1.mkdirs() = " + file1.mkdirs());
        String path = "day17\\src\\pra\\aaa";
        File file2 = new File(path, "FilePra2.txt");
        if (file2.isFile() && file2.exists()) {
            file2.delete();
        }
    }
}
