import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {

        //Create a socket to connect to the server
        Socket socket = new Socket("127.0.0.1", 8888);
        
        OutputStream Data = socket.getOutputStream();

        DataOutputStream message = new DataOutputStream(Data);

        Scanner input = new Scanner(System.in);
        System.out.print("Ready Start conversation: ");

        while(true) {
            String messageText = input.nextLine();
            if("exit".equals(messageText)) {
                System.out.println("Exiting the conversation.");
                message.close();
                socket.close();
                break;

            }

            message.writeUTF(messageText);
            message.flush();
        }
    }
}