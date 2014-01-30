import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/*
 *  InputReader
 *
 *	GUIFrame deki TextFielddan input alip commandlari ayirir
 *
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */
public class InputReader implements Iterator
{
	private Scanner scan;
	private String save;
	private String temp;
	private ArrayList<Command> commands;
	private int currentCommandNo;

	public InputReader( String input)
	{
		commands = new ArrayList<Command>();
		save = input;
		scan = new Scanner( input);
		while( scan.hasNext())
		{
			commands.add( new Command( scan.nextLine() ) );
		}
		currentCommandNo = 0;
	}

	public boolean hasNext() {
		return currentCommandNo < commands.size();
	}

	public Command next() {
		if ( commands.size() > 0) {
			if ( currentCommandNo >= 0 && currentCommandNo < commands.size() ) {
				return commands.get( currentCommandNo++ );
			}
			else {
				return commands.get( commands.size() - 1);
			}
		}
		else {
			return null;
		}
	}

	public void remove() {
		// todo
	}

	public void setText( String input) {
		commands = new ArrayList<Command>();
		save = input;
		scan = new Scanner( input);
		while( scan.hasNext())
		{
			commands.add( new Command( scan.nextLine() ) );
		}
		currentCommandNo = 0;
	}

	public boolean commandExists() {
		return commands.size() != 0;
	}
}
