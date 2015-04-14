public class byteRequestThread extends clientHelperThread
{
	public byteRequestThread(int[] theFileArray, ConnectedServer cs)
	{
		super(theFileArray, cs);
	}
	
	public void run()
	{
		//this guy constantly listens for a request from the server
		//for a certain byte and responds with that byte
		while(true)
		{
			//*****Write Code HERE****
			try
			{
			String whichByte = cs.getMessage();
			cs.sendByte(this.theFileArray[Integer.parseInt(whichByte)]);
			}
			catch(Exception g)
			{
				
			}
		}
	}
}
