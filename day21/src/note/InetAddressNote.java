package note;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址、域名的使用
 * @author Noby
 * @since 2023/3/19 13:50
 */
public class InetAddressNote {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();//获取本机地址
        InetAddress myComputer = InetAddress.getByName("LAPTOP-7JVG6UKI");//根据主机名获取地址
        InetAddress baiduDomain = InetAddress.getByName("www.baidu.com");//根据域名获取地址
        InetAddress baiduIP = InetAddress.getByName("163.177.151.110");//根据ip获取地址

        System.out.println("localHost = " + localHost);
        System.out.println("myComputer = " + myComputer);
        System.out.println("baiduDomain = " + baiduDomain);
        System.out.println("baiduIP = " + baiduIP);

    }
}
