package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class App extends JFrame
{
	/************** Attributs **************/	

	private	static	Toolkit			tool = Toolkit.getDefaultToolkit();
	private	static	Dimension		screenSize = tool.getScreenSize();
	private	static	int				screenWidth = screenSize.width;
	private	static	int				screenHeight = screenSize.height;
	private	static	int				windowWidth = (int) (screenWidth * 0.95);
	private	static	int				windowHeight = (int) (screenHeight * 0.95);
	private	static	Color			defaultBack = new Color(255, 191, 155);

	private	static	App				app;
	private	static	JLayeredPane	layeredPane;

	/************** Constructeurs **************/

	public App()
	{
		setTitle("CYRY - Apprendre l'anglais");
		setSize(windowWidth, windowHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(defaultBack);

		MainPage main = new MainPage();

		layeredPane = getLayeredPane();
		layeredPane.add(main, JLayeredPane.DEFAULT_LAYER);

	}

	/************** Accesseurs **************/

	/********** Getters **********/

	public static App getApp()
	{
		return app;
	}

	public static int getWindowWidth()
	{
		return windowWidth;
	}

	public static int getWindowHeight()
	{
		return windowHeight;
	}

	/************** Méthodes **************/

	public static void main(String []args)
	{
		app = new App();
		app.setVisible(true);
	}
}