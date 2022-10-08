package note;

import java.io.File;
import java.io.IOException;

public class FileNote {//文件对象

    public static void main(String[] args) throws IOException {
        //region 构造函数
        //通过路径创建对应的file对象，对该对象的操作即为对该文件的操作
        File file = new File("D:\\IdeaProjects\\term87\\day17\\src\\note\\res\\txtfile.txt");//通过绝对路径创建文件对象
        new File("D:\\IdeaProjects\\term87\\day17\\src\\note\\res","txtfile.txt");//可以将路径和文件分开
        File dir = new File("day17\\src\\note\\res\\aaa");//通过相对路径创建文件、文件夹对象
        File dirs = new File("day17\\src\\note\\res\\bbb\\ccc");
        System.out.println(file);
        //endregion

        //region 成员方法
        System.out.println("file.getName() = " + file.getName());//获取文件名
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());//获取文件的绝对路径
        System.out.println("file.getPath() = " + file.getPath());//获取文件的相对路径(即为创建时的路径)
        System.out.println("file.getParent() = " + file.getParent());//获取父及文件夹路径
        System.out.println("file.exists() = " + file.exists());//文件是否存在
        System.out.println("file.isFile() = " + file.isFile());//是否为一个文件
        System.out.println("file.isDirectory() = " + file.isDirectory());//是否为一个文件夹
        System.out.println("file.delete() = " + file.delete());//删除文件
        System.out.println("file.createNewFile() = " + file.createNewFile());//创建文件
        System.out.println("dir.mkdir() = " + dir.mkdir());//创建文件夹
        System.out.println("file.length() = " + file.length());//获取字节长度
        new File("day17\\src\\note\\res\\aaa","txtfile1.txt").createNewFile();
        new File("day17\\src\\note\\res\\aaa","txtfile2.txt").createNewFile();
        File[] files = dir.listFiles();//获取该路径的文件数组，不包含文件夹
        for (File file1 : files) {
            System.out.println("数组" + file1);
        }

/*
        mkdir()方法只要路径中有某个文件夹不存在及创建失败
        此时想要创建成功，应该用mkdirs()
         */
        System.out.println("dirs.mkdirs() = " + dirs.mkdirs());//创建多级文件夹
        //endregion

    }
}
