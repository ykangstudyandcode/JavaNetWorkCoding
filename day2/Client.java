package day2;

import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        try {
            //open the port for connection
            SocketChannel socket = SocketChannel.open();
            socket.connect(new InetSocketAddress("localhost",8080));

            System.out.println("Please wait....");

            Scanner scanner = new Scanner(System.in);

            while(true){

                String  message = scanner.nextLine();
                if("exit".equals(message)){
                    socket.close();
                    break;
                }
                ByteBuffer packet = StandardCharsets.UTF_8.encode(message+'\n');
                socket.write(packet);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
