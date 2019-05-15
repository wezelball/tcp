import java.io.*;
import java.net.*;
<<<<<<< HEAD
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
=======
import java.util.*;

public class Sender{
public static void main(String args[]) throws IOException{
    ServerSocket s=new ServerSocket(5000);

    try{
        Socket ss=s.accept();
        PrintWriter pw = new PrintWriter(ss.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(ss.getInputStream()));

        System.out.println("Client connected..");
        while(true)
        {
            System.out.println("Enter command:");
            pw.println(br.readLine());
            // Prints the reply back from python
            System.out.println(br1.readLine());
        }
    }
    finally{}
    }
}
>>>>>>> ae6445ebd2015ca6da6d153bb7790c7ed20e10d6
