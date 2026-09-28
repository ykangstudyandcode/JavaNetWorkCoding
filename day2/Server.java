package day2;

import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] args){
        try {
            //open the port for client to connect
            ServerSocketChannel Server = ServerSocketChannel.open();
            Server.bind(new InetSocketAddress(8080));

            while(true) {
                SocketChannel Client = Server.accept();
                System.out.println("Connect status is good");

                //Set a subthread  to run the task
                Runnable thread1 =new NetworkThread(Client);
                Thread task = new Thread(thread1);
                task.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
