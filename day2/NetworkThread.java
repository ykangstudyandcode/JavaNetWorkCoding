package day2;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NetworkThread implements Runnable {
    private final SocketChannel client;

    public NetworkThread(SocketChannel client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ByteBuffer channel = ByteBuffer.allocateDirect(1024);
                //write the message to the ByteBuffer
                int read = client.read(channel);
                if(read == -1){
                    client.close();
                    break;
                }
                //change to read mode
                channel.flip();
                //get all the message from bytebuffer
                String message = StandardCharsets.UTF_8.decode(channel).toString();
                System.out.println(message);
                //clean up the ByteBuffer
                channel.clear();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

