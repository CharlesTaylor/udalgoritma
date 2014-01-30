import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
 * GUIFrame class extends JFrame
 *
 * Programin ustune kuruldugu JFramedir
 *
 *
 * @author : Fatih Karaoglanoglu & Ozan Can Alt�ok
 *
 */
public class GUIFrame extends JFrame implements ActionListener
{
	TextArea text;
	JButton b;
	JButton restartButton;
	JLabel jl;
	GameArea jp;
	GameCore game;
	WaterMovement water;
	CocukMovement cocuk;
	public GUIFrame( GameCore game)
	{
		JOptionPane.showMessageDialog( null, "�niversiteye Do�ru 2013 CS Lab� Algoritma Oyununa ho� geldiniz !\n" +
			"Bu oyunumuzda algoritmalar�n mant���n� basit�e g�rece�iz. �ncelikle, yan taraftaki yaz� alan�n� bo�\n" +
			"b�rak�p \"Harekete Ba�la\"ya bas�p N harfi ile g�sterilen ninemizin nas�l bir yol izledi�ini anlamaya\n" +
			"�al��al�m. Ard�ndan yukar� k�s�mda bulunan \"Yeniden Dene\"ye bas�p yandaki yaz� alan�na komutlar�\n" +
			"giriniz. Komutlar� girerken bir �nceki a�amada g�rm�� oldu�unuz harekete g�re nineye suyu (S) nas�l\n" +
			"yeti�tirebilece�inizi d���n�n�z. Daha sonra a�a�� k�s�mdaki \"Harekete Ba�la\" d��mesine tekrardan\n" +
			"bas�n�z. Bakal�m suyu nineye yeti�tirebilecek misiniz?\n�nemli Not: Nine maksimum 60 hamle yapmaktad�r." +
			"(By Bilkent IEEE WebTeam)");
		this.game = game;
		text = new TextArea( "", 10, 50);
		text.setFont( new Font( "Courier New", Font.PLAIN, 15) );
		jp = new GameArea(game, new InputReader( text.getText() ) );
		water = jp.getWater();
		cocuk = jp.getCocuk();
		setLayout( new BorderLayout());
		jl = new JLabel( "");
		b = new JButton( "Harekete Ba�la");
		restartButton = new JButton( "Yeniden Dene");
		jp.setPreferredSize( new Dimension( 600, 500));
		jp.add( jl);
		add( "East" , text);
		add( "South" ,b);
		add( "West", jp);
		add( "North", restartButton);
		b.addActionListener( this);
		restartButton.addActionListener( this);
		pack();
		game.addView( water);
		game.addView( cocuk);
		game.addView( jp);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setVisible( true);
	}


	public void actionPerformed( ActionEvent e)
	{
		if ( e.getSource() == b) {
			InputReader inputs;
			inputs = new InputReader( text.getText());
			jp.setIR( inputs);
			water.startTimer();
			cocuk.performMovement();
			b.setEnabled( false);
		}
		else if ( e.getSource() == restartButton) {
			water.restart();
			cocuk.restart();
			water.stopTimer();
			b.setEnabled( true);
		}
	}
}
