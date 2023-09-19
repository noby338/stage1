package note;

import java.io.IOException;
import java.net.*;

/**
 * UDP数据报协议,发送端
 * @author Noby
 * @since 2023/3/19 13:55
 */
public class UDPSendNote {
    public static void main(String[] args) throws IOException {
        String info = "How are you?中文";
        //1、创建套接字
        DatagramSocket datagramSocket = new DatagramSocket();//DatagramSocket实现UDP协议
        //2、获取数据报
        DatagramPacket datagramPacket = new DatagramPacket(info.getBytes(),info.getBytes().length, InetAddress.getLocalHost(),11111);
        //3、发送数据
        datagramSocket.send(datagramPacket);
        //4、关闭套接字
        datagramSocket.close();
    }
}
