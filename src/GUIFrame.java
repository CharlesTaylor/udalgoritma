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
 * @author : Fatih Karaoglanoglu & Ozan Can Altýok
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
		JOptionPane.showMessageDialog( null, "Üniversiteye Doðru 2013 CS Labý Algoritma Oyununa hoþ geldiniz !\n" +
			"Bu oyunumuzda algoritmalarýn mantýðýný basitçe göreceðiz. Öncelikle, yan taraftaki yazý alanýný boþ\n" +
			"býrakýp \"Harekete Baþla\"ya basýp N harfi ile gösterilen ninemizin nasýl bir yol izlediðini anlamaya\n" +
			"çalýþalým. Ardýndan yukarý kýsýmda bulunan \"Yeniden Dene\"ye basýp yandaki yazý alanýna komutlarý\n" +
			"giriniz. Komutlarý girerken bir önceki aþamada görmüþ olduðunuz harekete göre nineye suyu (S) nasýl\n" +
			"yetiþtirebileceðinizi düþününüz. Daha sonra aþaðý kýsýmdaki \"Harekete Baþla\" düðmesine tekrardan\n" +
			"basýnýz. Bakalým suyu nineye yetiþtirebilecek misiniz?\nÖnemli Not: Nine maksimum 60 hamle yapmaktadýr." +
			"(By Bilkent IEEE WebTeam)");
		this.game = game;
		text = new TextArea( "", 10, 50);
		text.setFont( new Font( "Courier New", Font.PLAIN, 15) );
		jp = new GameArea(game, new InputReader( text.getText() ) );
		water = jp.getWater();
		cocuk = jp.getCocuk();
		setLayout( new BorderLayout());
		jl = new JLabel( "");
		b = new JButton( "Harekete Baþla");
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
