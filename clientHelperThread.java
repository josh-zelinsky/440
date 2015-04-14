public abstract class clientHelperThread extends Thread
{
	protected int[] theFileArray;
	protected ConnectedServer cs;
	
	clientHelperThread(int[] theFileArray, ConnectedServer cs)
	{
		this.theFileArray = theFileArray;
		this.cs = cs;
	}
}
