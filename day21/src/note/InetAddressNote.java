package note;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressNote {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();//获取本机地址
        InetAddress mycomputer = InetAddress.getByName("LAPTOP-TB48V8LU");//根据主机名获取地址
        InetAddress woniuName = InetAddress.getByName("www.woniuxy.com");//根据域名获取地址
        InetAddress woniuIp = InetAddress.getByName("101.37.65.91");//根据ip获取地址

        System.out.println("localHost = " + localHost);
        System.out.println("mycomputer = " + mycomputer);
        System.out.println("woniu = " + woniuName);
        System.out.println("woniuIp = " + woniuIp);

        System.out.println(InetAddress.getLocalHost().toString().split("/")[1]);
    }
}
