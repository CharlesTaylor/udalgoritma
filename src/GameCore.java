import java.util.ArrayList;
/*
 * GameCore class
 *
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */
public class GameCore
{
	//Properties
	ArrayList<GameView> views;
	ArrayList<String> randomizer;
	GameSetup setup;

	//Constructor
	public GameCore(GameSetup setup)
	{
		this.setup = setup;
		randomizer = setup.getRandomArray();
		views = new ArrayList<GameView>();
	}

	//Methods
	public void addView( GameView view)
	{
		views.add( view);
		// notifyViews();
		if ( view != null)
			view.updateView( this);
	}

	public void notifyViews()
	{
		if ( views != null)
			for ( GameView view : views)
				view.updateView( this);
	}

	public void removeView( GameView view)
	{
		views.remove( view);
	}

	public GameSetup getSetup()
	{
		return setup;
	}
}