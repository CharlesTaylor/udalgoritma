import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/*
 *GameArea class extends JPanel
 *
 *	Oyunun doncegi panel classidir
 *
 *
 *@author : Fatih Karaoglanoglu & Ozan Can Altýok
 *
 */
public class GameArea extends JPanel implements GameView
{
	WaterMovement water;
	CocukMovement cocuk;
	InputReader inputs;
	GameCore game;
	public GameArea(GameCore game, InputReader inputs)
	{
		this.game = game;
		this.inputs = inputs;
		water = new WaterMovement( game);
		cocuk = new CocukMovement( game, inputs);
		setPreferredSize( new Dimension( 600, 600));
	}

	public void paintComponent( Graphics g)
	{
		super.paintComponent( g);
		g.setFont( new Font( "Courier New", Font.BOLD, 25) );
		g.setColor( Color.RED);
		g.drawString( "N", 5* water.getX(), 5 *water.getY() );//Burasi drawImage olcak
		g.drawString( "S", 5 * cocuk.getX(), 5 * cocuk.getY() );
		if ( cocuk.allMovementsReached() && water.getX() == cocuk.getX() && water.getY() == cocuk.getY() ) {
			water.stopTimer();
			JOptionPane.showMessageDialog( null, "Suyu baþarý ile nineye ulaþtýrdýnýz :)))");
		}
	}

	public void updateView(GameCore game)
	{
		repaint();
	}

	public WaterMovement getWater()
	{
		return water;
	}

	public void setIR( InputReader r) {
		inputs = r;
		cocuk.setIR( inputs);
	}

	public CocukMovement getCocuk() {
		return cocuk;
	}
}
