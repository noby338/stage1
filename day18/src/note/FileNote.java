package note;

import java.io.File;
import java.io.IOException;
/**
 * File对象的使用
 * @author Noby
 * @since 2023/3/18 21:36
 */
public class FileNote {
    public static void main(String[] args) throws IOException {
        //region 构造函数
        //通过路径创建对应的file对象，对该对象的操作即为对该文件的操作
        File txtFile = new File("day18/src/res/fileDir/txtFile.txt");//通过绝对路径创建文件对象
        new File("day18/src/res/fileDir","txtFile.txt");//可以将路径和文件分开
        File aaa = new File("day18/src/res/fileDir/aaa");//通过相对路径创建文件、文件夹对象
        File ccc = new File("day18/src/res/fileDir/bbb/ccc");
        System.out.println(txtFile);//day18\src\res\fileDir\txtFile.txt
        //endregion

        //region 成员方法
        System.out.println("txtFile.getName() = " + txtFile.getName());//txtFile.getName() = txtFile.txt
        System.out.println("txtFile.getAbsolutePath() = " + txtFile.getAbsolutePath());//txtFile.getAbsolutePath() = D:\IdeaProjects\stage1\day18\src\res\fileDir\txtFile.txt
        System.out.println("txtFile.getPath() = " + txtFile.getPath());//txtFile.getPath() = day18\src\res\fileDir\txtFile.txt
        System.out.println("txtFile.getParent() = " + txtFile.getParent());//txtFile.getParent() = day18\src\res\fileDir
        System.out.println("txtFile.exists() = " + txtFile.exists());//txtFile.exists() = true
        System.out.println("txtFile.isFile() = " + txtFile.isFile());//txtFile.isFile() = true
        System.out.println("txtFile.isDirectory() = " + txtFile.isDirectory());//txtFile.isDirectory() = false
        System.out.println("txtFile.delete() = " + txtFile.delete());//txtFile.delete() = true
        System.out.println("txtFile.createNewFile() = " + txtFile.createNewFile());//txtFile.createNewFile() = true
        System.out.println("txtFile.length() = " + txtFile.length());//txtFile.length() = 0
        System.out.println("aaa.mkdir() = " + aaa.mkdir());//aaa.mkdir() = false
        //mkdir()创建单个目录，mkdirs()创建多级目录
        System.out.println("ccc.mkdirs() = " + ccc.mkdirs());//ccc.mkdirs() = false

        new File("day18/src/res/fileDir/aaa","txtFile1.txt").createNewFile();
        new File("day18/src/res/fileDir/aaa","txtFile2.txt").createNewFile();
        File[] files = aaa.listFiles();//获取该路径的文件数组，不包含文件夹
        for (File f : files) {
            System.out.println("f:" + f);
            //f:day18\src\res\fileDir\aaa\txtFile1.txt
            //f:day18\src\res\fileDir\aaa\txtFile2.txt
        }
        //endregion
    }
}
