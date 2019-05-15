import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Sender {

    public static void main(String[] args) throws IOException {

        int port = 65000;
        boolean connected  = false;
    
        try (ServerSocket serverSocket = new ServerSocket(port))    {
            System.out.println("Server is listening on port " + port);

            while(!connected) {
            Socket socket = serverSocket.accept();
            System.out.println("Pi client connected");

            new ServerThread(socket).start();
            connected = true;
            }

        } catch (IOException ex)  {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    
    }
    
}