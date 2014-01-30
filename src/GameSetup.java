import java.util.Random;
import java.util.ArrayList;
/*
 * GameSetup class
 *
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */
public class GameSetup
{
	final int DEFAULT_MOVEMENT_COUNT = 60;
	Random rand;
	ArrayList<String> randomArray;
	public GameSetup()
	{
		rand = new Random();
		randomArray = movementRandomizer( DEFAULT_MOVEMENT_COUNT);
	}

	public ArrayList<String> movementRandomizer(int movementCount)
	{
		ArrayList<String> returner;
		returner = new ArrayList<String>();
		int temp = 0;
		for( int x = 0 ; x < movementCount ; x ++)
		{
			temp = rand.nextInt( 100);
			if( temp <= 10)
				returner.add( "West");
			else if( temp > 10 && temp < 20)
				returner.add( "South");
			else if( temp >= 20 && temp < 60)
				returner.add( "North");
			else if( temp >= 60)
				returner.add( "East");
		}
		return returner;
	}

	public ArrayList<String> getRandomArray()
	{
		return randomArray;
	}
}

