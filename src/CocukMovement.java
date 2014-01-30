import java.awt.event.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * @(#)CocukMovement.java
 *
 *
 * @author Ozan Can Altýok
 * @version 1.00 2013/6/4
 */


public class CocukMovement implements GameView {

	final int MESAFE_KATSAYI = 2;
	final int DEFAULT_X = 75;
	final int DEFAULT_Y = 98;

	int x;
	int y;
	InputReader commandLinePrompt;
	GameCore game;
	//LinkedBlockingQueue<Timer> timerQueue;

    public CocukMovement( GameCore game, InputReader reader) {
		commandLinePrompt = reader;
		//timerQueue = new LinkedBlockingQueue<Timer>();
		this.game = game;
		x = DEFAULT_X;
		y = DEFAULT_Y;
    }

	public void performMovement() {
		int i = 1;
		while ( commandLinePrompt.hasNext() ) {
			Command currentCommand = commandLinePrompt.next();
			if ( currentCommand != null) {
				int commandRoute = currentCommand.getRoute();
				if ( commandRoute == Command.SOUTH ) {
					int lastI = i - 1;
					for (; i <= currentCommand.getTime() + lastI; i++) {
						Date curDate = new Date( new Date().getTime() + 1000 * i);
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
								public void run() {
									y += MESAFE_KATSAYI;
								}
							}, curDate);
						/*
						try {
							timerQueue.put( timer);
						} catch (Exception e) {
							e.printStackTrace();
						}
						*/
					}
				}
				else if ( commandRoute == Command.NORTH ) {
					int lastI = i - 1;
					for (; i <= currentCommand.getTime() + lastI; i++) {
						Date curDate = new Date( new Date().getTime() + 1000 * i);
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
								public void run() {
									y -= MESAFE_KATSAYI;
								}
							}, curDate);
						/*
						try {
							timerQueue.put( timer);
						} catch (Exception e) {
							e.printStackTrace();
						}
						*/
					}
				}
				else if ( commandRoute == Command.EAST ) {
					int lastI = i - 1;
					for (; i <= currentCommand.getTime() + lastI; i++) {
						Date curDate = new Date( new Date().getTime() + 1000 * i);
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
								public void run() {
									x += MESAFE_KATSAYI;
								}
							}, curDate);
						/*
						try {
							timerQueue.put( timer);
						} catch (Exception e) {
							e.printStackTrace();
						}
						*/
					}
				}
				else {
					int lastI = i - 1;
					for (; i <= currentCommand.getTime() + lastI ; i++) {
						Date curDate = new Date( new Date().getTime() + 1000 * i);
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
								public void run() {
									x -= MESAFE_KATSAYI;
								}
							}, curDate);

						/*
						try {
							timerQueue.put( timer);
						} catch (Exception e) {
							e.printStackTrace();
						}
						*/
					}
				}
				/*
				while ( timerQueue.size() > 0 ) {
					try {
						Timer t = timerQueue.take();
						t.cancel();
						t.purge();
					} catch ( Exception e) {
						e.printStackTrace();
					}
				}
				*/
				game.notifyViews();
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setIR( InputReader ir) {
		commandLinePrompt = ir;
	}

	public void restart() {
		x = DEFAULT_X;
		y = DEFAULT_Y;
		game.notifyViews();
	}

	public void updateView( GameCore core) {
		// todo
	}

	public boolean allMovementsReached() {
		return commandLinePrompt.commandExists() && !commandLinePrompt.hasNext();
	}
}