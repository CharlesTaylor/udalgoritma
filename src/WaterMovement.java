import java.awt.event.*;
import javax.swing.Timer;
/*
 *WaterMovement class
 *
 *	Suyun hareketini saglayan class
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */
public class WaterMovement implements ActionListener, GameView
{
	final int MESAFE_KATSAYI = 2;
	final int DEFAULT_X = 5;
	final int DEFAULT_Y = 98;

	Timer timer;
	GameCore game;
	int x;
	int y;
	int timeCounter;

	public WaterMovement( GameCore game)
	{
		this.game = game;
		timer = new Timer( 1000 , this);
		x = DEFAULT_X;
		y = DEFAULT_Y;
		timeCounter = 0;
	//	timer.setInitialDelay( 1000);
		timer.addActionListener( this);
	}

	public void startTimer()
	{
		timeCounter = 0;
		timer.start();
	}

	public void stopTimer()
	{
		timer.stop();
	}
	public void actionPerformed( ActionEvent e)
	{
		/*
		if( timeCounter == 1)
		{
			move( "south", 2);
		}else if( timeCounter == 2)
		{
			move( "east" , 1);
		}else if( timeCounter == 3)
		{
			move( "south", 1);
		}else if( timeCounter == 4)
		{
			move( "east", 1);
		}else if( timeCounter == 5)
		{
			move( "south", 1);
		}else if ( timeCounter == 6)
		{
			move( "east", 1);
		}else if ( timeCounter == 7)
		{
			move( "south" , 1);
		}else if( timeCounter == 8)
		{
			move( "west", 1);
		}else if( timeCounter == 9)
		{
			move( "north", 1);
		}else if( timeCounter == 10)
		{
			move( "east", 1);
		}else if( timeCounter == 11)
		{
			move( "north", 4);
		}else if( timeCounter == 12)
		{
			move( "east", 3);
			timer.stop();
		}
		if( timeCounter < setup.DEFAULT_MOVEMENT_COUNT )
			move( setup.getRandomArray().get(timeCounter), 1);
		else
			stopTimer();

		game.updateView(game.game);
		System.out.println( "Water moved to x = " + x + " y = " + y);
		timeCounter++;
		*/
		game.notifyViews();
	}

	public void move( String direction)
	{
		if( direction.equalsIgnoreCase( "west"))
		{
			x = x - MESAFE_KATSAYI;
		}
		else if(direction.equalsIgnoreCase( "east"))
		{
			x = x + MESAFE_KATSAYI;
		}
		else if(direction.equalsIgnoreCase( "north"))
		{
			y = y - MESAFE_KATSAYI;
		}
		else if( direction.equalsIgnoreCase( "south"))
		{
			y = y + MESAFE_KATSAYI;
		}
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void restart()
	{
		x = DEFAULT_X;
		y = DEFAULT_Y;
		game.notifyViews();
	}

	public void updateView( GameCore core)
	{
		if( timeCounter < game.getSetup().DEFAULT_MOVEMENT_COUNT )
			move( game.getSetup().getRandomArray().get(timeCounter));
		else
			stopTimer();
		//System.out.println( "Water moved to x = " + x + " y = " + y);
		timeCounter++;
	}
}
