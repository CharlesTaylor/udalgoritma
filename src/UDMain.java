import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
/*
 *
 *
 *	Test amacli Main Method
 *
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */

public class UDMain {

    public static void main(String[] args) {
    	Scanner scan = new Scanner( System.in);

    	//Variables
    	GUIFrame frame;
    	GameCore core;
    	GameSetup setup;

    	// TODO, add your application code
    	setup = new GameSetup();
    	core = new GameCore( setup);
    	frame = new GUIFrame( core);

    	int x = scan.nextInt();
	    }
}
