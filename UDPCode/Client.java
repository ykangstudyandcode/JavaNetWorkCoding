import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Client is running...");
       
        
         DatagramSocket socket = new DatagramSocket();

        //创建封装数据包对象封装要发出去的数据
        /* 
        publlic DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        这是一个有参构造方法，参数说明：
        buf：要发送的数据
        length：要发送的数据的长度
        address：要发送的目标主机的IP地址
        port：要发送的目标主机的端口号
        */
        Scanner scanner = new Scanner(System.in);
        while(true){
            //获取客户端的数据
        String message = scanner.nextLine();
            //将数据转换成字节数组
        byte[] data = message.getBytes();

        //创建数据包
        DatagramPacket packet = new DatagramPacket(data, data.length,
            InetAddress.getLocalHost(),6666);
        
        if("exit".equals(message)){
         System.out.println("Client is shutting down...");
            socket.close();
            break;
        }
        //发送数据包
        socket.send(packet);

        System.out.println("Data sent successfully.");
        
         }
    }
}
