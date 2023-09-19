package task;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    /*
    1.请用户从控制台输入信息，程序将信息存储到文件Info.txt中。可以输入多条信息，每条信息存储一行。当用户输入：”886”时，程序结束。
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入信息：");
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File("day17\\src\\task\\res\\Info.txt"),true
        );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        String info = scanner.nextLine();
        bufferedOutputStream.write(info.getBytes());
    }
}
