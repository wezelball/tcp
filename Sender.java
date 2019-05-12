import java.io.*;
import java.net.*;
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
