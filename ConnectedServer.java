import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ConnectedServer 
{
	private Socket theSocket;
	private PrintWriter output;
	private Scanner input;
	
	public ConnectedServer(Socket theSocket) throws Exception
	{
		this.theSocket = theSocket;
		this.output = new PrintWriter(this.theSocket.getOutputStream(), true);
		this.input = new Scanner(this.theSocket.getInputStream());
	}
	
	public void sendMessage(String msg)
	{
		this.output.println(msg);
	}
	
	public String getMessage()
	{
		return this.input.nextLine();
	}
	
	public void sendByte(int theByte) throws Exception
	{
		this.theSocket.getOutputStream().write(theByte);
	}
	
	public int readByte() throws Exception
	{
		return this.theSocket.getInputStream().read();
	}
}
