import javax.swing.*;
/**
 * @(#)Command.java
 *
 *
 * @author Ozan Can Altýok
 * @version 1.00 2013/6/4
 */


public class Command {

	public static int NORTH = 1;
	public static int EAST = 2;
	public static int SOUTH = 3;
	public static int WEST = 4;
	private int time;
	private int route;

    public Command( String command) {
		if ( command.matches( "[a-zA-Z]+\\([0-9]+\\)") ) {
			String[] commandTokens = command.split("\\(");
			String commandName = commandTokens[0];
			String commandTimeTokens = commandTokens[1];
			String commandTime = commandTimeTokens.split("\\)")[0];
			if ( commandName.equals( "goLeft") || commandName.equals( "goRight") ||
				commandName.equals( "goUp") || commandName.equals( "goDown") ) {
				int timeToTake = Integer.parseInt(commandTime);
				if ( timeToTake > 0 && timeToTake < 60) {
					time = timeToTake;
				}
				else {
					time = 1;
				}

				if ( commandName.equalsIgnoreCase( "goLeft") ) {
					route = WEST;
				}
				else if ( commandName.equalsIgnoreCase( "goRight") ) {
					route = EAST;
				}
				else if ( commandName.equalsIgnoreCase( "goUp") ) {
					route = NORTH;
				}
				else if ( commandName.equalsIgnoreCase( "goDown") ) {
					route = SOUTH;
				}
				else {
					JOptionPane.showMessageDialog( null, "Komutlar yanlýþ girilmiþtir, program sonlandýrýlacaktýr!!");
				}
			}
			else {
				JOptionPane.showMessageDialog( null, "Komutlar yanlýþ girilmiþtir, program sonlandýrýlacaktýr!!");
			}
		}
		else {
			JOptionPane.showMessageDialog( null, "Komutlar yanlýþ girilmiþtir, program sonlandýrýlacaktýr!!");
		}
    }

	public int getTime() {
		return time;
	}

	public int getRoute() {
		return route;
	}
}