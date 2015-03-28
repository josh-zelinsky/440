import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ResponseThread extends Thread
{
	ConnectedClient theClient;
	LinkedList<ConnectedClient> allTheClients;
	
	public ResponseThread(ConnectedClient theClient)
	{
		this.theClient = theClient;
		this.allTheClients = driver.theClients;
	}
	public void run()
	{
		System.out.println(this.theClient.getMessage());
	}
}
