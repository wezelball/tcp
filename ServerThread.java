// Network sockets
import java.io.*;
import java.net.*;

// thread to communicate with pi
public class ServerThread extends Thread 
{
  private Socket socket;
  //private Timer waitTimer;

  public ServerThread(Socket socket)  
  {
    this.socket = socket;
  }  
 
  public void run() 
  {
    try {
      InputStream input = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      OutputStream output = socket.getOutputStream();
      PrintWriter writer = new PrintWriter(output, true);

      String text;
      // Socket connection extablished, all conversation occurs in the do loop 
      do  {
        // Let's ask for number of objects
        writer.println("nobj:");
        System.out.println("Server wrote: nobj:");
        //Timer.delay(1.0);
        Thread.sleep(1000);
        writer.println("Xc:");
        System.out.println("Server wrote: Xc:");
        //Timer.delay(1.0);
        Thread.sleep(1000);

        text = reader.readLine();
        System.out.println("Server read: " + text);

      } while (!text.equals("bye"));

      socket.close();
    } 
    catch (IOException ex)  {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
    }
    catch (InterruptedException ie) {   // for the Thread.sleep
        ie.printStackTrace();
    }

    
  }
}