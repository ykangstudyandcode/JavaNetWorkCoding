import java.net.ServerSocket;

import java.io.InputStream;
import java.io.DataInputStream;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws Exception {
    
        ServerSocket socket =  new ServerSocket(8888);

        Socket Clientsocket =socket.accept();

        InputStream Data = Clientsocket.getInputStream();

        DataInputStream message = new DataInputStream(Data);

        while(true){

            try{
                String messageText = message.readUTF();
                System.out.println(messageText);
            }catch(Exception e){
                System.out.println(Clientsocket.getRemoteSocketAddress() + ": " + "Client disconnected.");
                message.close();
                socket.close();
                break;
            }
        }

    }
}