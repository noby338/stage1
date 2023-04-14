package note;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP数据报协议,接收端
 * @author Noby
 * @since 2023/3/19 13:56
 */
public class UDPReceiveNote {
    public static void main(String[] args) throws IOException {
        //1、创建套接字
        DatagramSocket datagramSocket = new DatagramSocket(11111);
        //2、创建数据报
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //3、获取数据
        datagramSocket.receive(datagramPacket);//receive方法：阻塞方法，没接收到任何数据时就等待消息，程序暂停执行
        //4、关闭套接字
        datagramSocket.close();

        System.out.println(new String(bytes,0,datagramPacket.getLength()));//datagramPacket.getLength() 获取接收到数据的长度

//        while(true) {
//            datagramSocket.receive(datagramPacket);//receive方法：阻塞方法，没接收到任何数据时就等待消息，程序暂停执行
//
//            System.out.println(new String(bytes,0,datagramPacket.getLength()));//datagramPacket.getLength() 获取接收到数据的长度
//
//        }
    }
}
