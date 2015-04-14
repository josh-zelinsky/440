import java.io.FileWriter;


public class fileFillThread extends clientHelperThread
{
	public fileFillThread(int[] theFileArray, ConnectedServer cs)
	{
		super(theFileArray, cs);
	}

	public void run()
	{
		int count = 0;
		//this guy constantly tries to fill the byte array for the
		//receiving file
		//*****Write Code HERE****
		while(true)
		{
			for(int i = 0; i < this.theFileArray.length; i++)
			{
				if(this.theFileArray[i] == -1)
				{
					try 
					{
						cs.sendMessage("" + i);
						int theByte = cs.readByte();
						if(theByte != -1)
						{
							this.theFileArray[i] = theByte;
							count++;
						}
					}
					catch(Exception f)
					{

					}
				}
			}
			if(count == this.theFileArray.length)
			{
				break;
			}
		}
		try 
		{
			FileWriter fw = new FileWriter("./Documents/spongebob.jpg");
			for(int i = 0; i < this.theFileArray.length; i++)
			{
				fw.write(this.theFileArray[i]);
			}
			fw.close();
		}
			catch(Exception j)
			{
				
			}
	}
}
