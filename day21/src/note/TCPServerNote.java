package note;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerNote {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(11111);
        Socket socket = serverSocket.accept();
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        socket.close();
        serverSocket.close();

    }
}
