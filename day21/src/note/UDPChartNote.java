package note;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPChartNote {//基于UDP协议和多线程的聊天室
    public static void main(String[] args) {
        new Thread(new ChartSend()).start();
        new Thread(new ChartReceive()).start();
    }
}

class ChartSend implements Runnable {

    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String info = scanner.nextLine();
                DatagramPacket datagramPacket = new DatagramPacket(info.getBytes(), info.getBytes().length, InetAddress.getLocalHost(), 11111);
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ChartReceive implements Runnable {

    @Override
    public void run() {

        try {
            DatagramSocket datagramSocket = new DatagramSocket(11111);
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                datagramSocket.receive(datagramPacket);
                System.out.println(new String(bytes, 0, datagramPacket.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}