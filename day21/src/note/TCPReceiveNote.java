package note;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @Description TCP数据报协议,接收端
 * @Author Noby
 * @Date 2023/3/19 13:56
 */
public class TCPReceiveNote {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(11111);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int len = inputStream.read(bytes);
        socket.close();
        serverSocket.close();
        System.out.println(new String(bytes, 0, len));
    }
}
