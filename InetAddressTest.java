import java.net.*;
public class InetAddressTest{
    public static void main(String[] args) throws Exception{
        //get local ip address
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        //get ip address by domain name
	    InetAddress ip2 = InetAddress.getByName("www.Google.com"); 
        System.out.println(ip2.getHostName());       
        System.out.println(ip2.getHostAddress());

        System.out.println(ip2.isReachable(6000));

        InetAddress ip[] = InetAddress.getAllByName("www.Google.com");
        for(InetAddress inetaddress : ip){
            System.out.println(inetaddress.getHostAddress());
        }
    }
}
