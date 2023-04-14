package note;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * TCP数据报协议,发送端
 * @author Noby
 * @since 2023/3/19 13:56
 */
public class TCPSendNote {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(), 11111);//Socket底层实现了TCP协议
        String info = "TCPInfo中文";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(info.getBytes());
        socket.close();
    }
}
