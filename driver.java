import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
public class driver
{
	static LinkedList<ConnectedClient> theClients = new LinkedList<ConnectedClient>();
	public static void main(String[] args) throws Exception
	{
		//connect to the server
		Socket theServer = new Socket("localhost",1234);
		
		ClientCommunicationProtocol ccp = new ClientCommunicationProtocol(theServer);
		ServerSocket ss = new ServerSocket(1234);
		while(true)
		{
			System.out.println("Waiting...");
			Socket connection = ss.accept();
			ConnectedClient cc = new ConnectedClient(connection);
			driver.theClients.add(cc);
			ResponseThread rt = new ResponseThread(cc);
			rt.start();
			System.out.println("Connected!");
		}
	}
}
