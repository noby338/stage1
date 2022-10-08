package note;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamNote {//字节输出流
    public static void main(String[] args) throws IOException {
        //region 构造
        /*
        常用构造方法
        public FileOutputStream(File file)
		public FileOutputStream(String name)
		public FileOutputStream(File file, boolean append)
		public FileOutputStream(String name, boolean append)

		注意：如果file文件不存在，构造方法也会帮助我们创建出一个文件
         */
        File file  = new File("day17\\src\\note\\res\\FileOutputStreamNote.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file,false);//参数二表示是否追加,默认为false
        FileOutputStream fileOutputStream1 = new FileOutputStream("day17\\src\\note\\res\\FileOutputStreamNote1.txt");//此种方法可以省略创建file对象
        //endregion

        //region 通过字节数组写出数据
        String data = "fileoutputstreaminfo";
        byte[] bytes = data.getBytes();
        fileOutputStream.write(bytes,2,3);//此处第二个索引表示的是长度
        //endregion

        //region 正则表达式输入换行
        fileOutputStream.write('\n');
        //endregion

        //region 通过字节写出数据
        fileOutputStream.write('a');
        //endregion


        fileOutputStream.close();//关闭字节输出流
    }
}
