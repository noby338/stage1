package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    /*
    3.实现将一个文件夹aaa拷贝到另外一个文件夹copy中
	aaa文件夹
		--bbb
			bbb.txt
			bbb.jpg
		--ccc
			ccc.txt
			ccc.jpg
		aaa.txt
		aaa.jpg

	copy文件夹
		--???
     */
    public static void main(String[] args) throws Exception {
        File copyPath = new File("day17\\src\\task\\res\\aa");
        File pastePath = new File("day17\\src\\task\\res\\aaa");
        long startTime = System.currentTimeMillis();
        copy(copyPath, pastePath);
        long endTime = System.currentTimeMillis();
        System.out.println("复制用时：" + (endTime - startTime) + "ms") ;
    }

    static void copy(File copyPath, File pastePath) throws IOException {
        File[] files = copyPath.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                File pasteFile = new File(pastePath, file.getName());
                pasteFile.createNewFile();
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(pasteFile);
                int len;
                byte[] bytes = new byte[1024];
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes,0,len);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                File pasteDir = new File(pastePath, file.getName());
                pasteDir.mkdir();
                copy(file,pasteDir);
            }
        }

    }
}
