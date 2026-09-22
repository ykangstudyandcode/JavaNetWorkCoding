import java.net.*;
public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server is running...");
        //创建客户端对象
       DatagramSocket socket =new DatagramSocket(6666);

        //创建数据包对象接收数据
        byte[] data = new byte[1024 *64];

        DatagramPacket packet = new DatagramPacket(data,data.length);

        while(true){
        //接收数据包
        socket.receive(packet);
        
        int len = packet.getLength();
        //解析数据包
        String message = new String(data, 0, len);
        System.out.println("Received message: " + message);

        System.out.println("--------------------------------");
        System.out.println("Data received successfully.");
        System.out.println("Sender's address: " + packet.getAddress());
        System.out.println("Sender's port: " + packet.getPort());
        }
    }
}