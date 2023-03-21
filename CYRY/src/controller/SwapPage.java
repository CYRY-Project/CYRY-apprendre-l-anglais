package controller;

import javax.swing.JLayeredPane;

import model.User;

import view.AccountUser;
import view.App;
import view.Connection;
import view.ForgetPassword;
import view.Home;
import view.MainPage;
import view.Menu;
import view.Inscription;
import view.LevelCompleted;

/**
 * Permet de changer de vue.
 *
 * @author Romain Guyenot
 * @author Yoann Jeauneau
 */
public class SwapPage
{
	/************** Méthodes **************/

	/**
	 * Une fois les panneaux vides, ajoute la vue souhaitée au panneau.
	 * 
	 * @param view La vue que l'on veut afficher
	 * @see #clearLayer()
	 * @see view.App#getApp()
	 */
	public static void swapPage(String view)
	{
		switch (view)
		{
		case "LogIn":
			clearLayer();
			App.getApp().getLayeredPane().add(new Connection(), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;

		case "SignIn":
			clearLayer();
			App.getApp().getLayeredPane().add(new Inscription(), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;

		case "ForgetPassword":
			clearLayer();
			App.getApp().getLayeredPane().add(new ForgetPassword(), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;

		case "MainPage":
			clearLayer();
			App.getApp().getLayeredPane().add(new MainPage(), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;
		}
	}

	/**
	 * Une fois les panneaux vides, ajoute la vue souhaitée au panneau.
	 * 
	 * @param view La vue que l'on veut afficher
	 * @param user L'utilisateur actuellement connecté
	 * @see User
	 * @see #clearLayer()
	 * @see view.App#getApp()
	 */
	public static void swapPage(String view, User user)
	{
		switch(view)
		{
		case "Home":
			clearLayer();
			App.getApp().getLayeredPane().add(new Home(user), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;

		case "Menu":
			Menu.setMenu(new Menu(user));
			App.getApp().getLayeredPane().add(Menu.getMenu(), JLayeredPane.PALETTE_LAYER);
			App.getApp().getLayeredPane().repaint();
			App.getApp().getLayeredPane().revalidate();
			break;

		case "Account":
			AccountUser.setAcc(new AccountUser(user));
			App.getApp().getLayeredPane().add(AccountUser.getAcc(), JLayeredPane.PALETTE_LAYER);
			App.getApp().getLayeredPane().repaint(); 
			App.getApp().getLayeredPane().revalidate();
			break;
			
		case "LevelCompleted":	
			clearLayer();
			App.getApp().getLayeredPane().add(new LevelCompleted(user), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;
		}
	}

	/**
	 * Retire l'ensemble des composents contenus dans les panneaux des couches DEFAULT et PALETTE
	 * 
	 * @see view.App
	 */
	public static void clearLayer()
	{
		int i = 0;
		int components = App.getApp().getLayeredPane().getComponentCountInLayer(JLayeredPane.DEFAULT_LAYER) + App.getApp().getLayeredPane().getComponentCountInLayer(JLayeredPane.PALETTE_LAYER);
		while(i < components)
		{
			App.getApp().getLayeredPane().remove(0);
			i++;
		}
	}
}