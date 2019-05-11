import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws IOException {
        String fromclient;

        ServerSocket Server = new ServerSocket(25000);

        System.out.println("TCPServer Waiting for client on port 25000");

        while (true) {
            Socket connected = Server.accept();
            System.out.println(
                " THE CLIENT" + " " + connected.getInetAddress() + ":" + connected.getPort() + " IS CONNECTED ");

            PrintWriter out = new PrintWriter(connected.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);


            while (true) {
                String input = sc.nextLine();
                out.println(input);
            }
        }

    }
}