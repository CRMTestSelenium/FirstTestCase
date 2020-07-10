import java.net.InetAddress;
import java.net.Socket;

public class IPTest {
    public static void main(String[] args) throws Exception{
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP: " + inetAddress.getHostAddress());

    }
}
