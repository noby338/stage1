package note;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientNote {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(), 11111);//Socket底层实现了TCP协议
        String info = "TCPInfo";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(info.getBytes());
        socket.close();
    }
}
