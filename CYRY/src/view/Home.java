package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.SwapPage;

import model.User;

public class Home extends JPanel
{
	/************** Attributs **************/

	private	static	String	imageStr = "src/image/do_you_speak_english_flag.png";
	private	static	int 	xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean	menuOpened = false;
	private			boolean	accountOpened = false;

	private			String	comments = "Le but de cette application est de vous aider à améliorer votre anglais.\n\n"
						+ "Vous trouverez sur Cyry 3 niveaux de difficulté (débutant, intermédiaire et avancé)\n"
						+ "que vous pourrez choisir en cliquant sur le bouton 'Menu' en haut à droite.\n\n"
						+ "Chaque niveau se compose de 10 exercices, chaque exercice réussi vous permettra\n"
						+ "de gagner des points et des niveaux pour débloquer la difficulté suivante.\n\n"
						+ "En cliquant sur votre avatar en haut à gauche, vous pourrez consulter votre compte pour\n"
						+ "vous déconnecter, voir votre progression, modifier votre compte ou le supprimer.";

	/************** Constructeurs **************/

	public Home(User user)
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// Déclaration et initialisation des éléments de la vue

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JButton avatar = new JButton(avatarStr);
		JLabel name = new JLabel(user.getUserName());
		JLabel level = new JLabel("Niveau : " + String.valueOf(user.getUserLevel()));
		JLabel points = new JLabel("Points : " + String.valueOf(user.getUserPoints()));
		JButton menu = new JButton("Menu");

		ImageIcon speakEnglish = new ImageIcon(imageStr);
		JLabel image = new JLabel(speakEnglish);
		JLabel labelPage = new JLabel("Bienvenue sur Cyry !", SwingConstants.CENTER);
		JTextArea rules = new JTextArea(comments);

		// Positionnement des éléments

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		image.setBounds(xMiddle - 300, 10, 600, 400);
		labelPage.setBounds(xMiddle - 125, 430, 250, 30);
		rules.setBounds(xMiddle - 320, 480, 640, 200);

		// Modification des polices

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		labelPage.setFont(new Font("Dialog", Font.BOLD, 25));
		rules.setFont(new Font("Dialog", Font.BOLD, 14));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure	

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		// Retrait du fond du JPanel, de l'avatar et des règles.

		setOpaque(false);

		avatar.setOpaque(false);
		avatar.setContentAreaFilled(false);
		avatar.setBorderPainted(false);

		rules.setOpaque(false);
		rules.setEditable(false);

		// Ajout des éléments dans le JPanel

		this.add(avatar);
		this.add(name);
		this.add(level);
		this.add(points);
		this.add(menu);

		this.add(image);
		this.add(labelPage);
		this.add(rules);

		// Action de l'appuit sur les boutons

		avatar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!accountOpened)
				{
					SwapPage.swapPage("Account",user);
					name.setVisible(false);
					level.setVisible(false);
					points.setVisible(false);
					menu.setEnabled(false);
					accountOpened = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(AccountUser.getAcc());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					name.setVisible(true);
					level.setVisible(true);
					points.setVisible(true);
					menu.setEnabled(true);
					accountOpened = false;
				}
			}
		});

		menu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!menuOpened)
				{
					SwapPage.swapPage("Menu",user);
					avatar.setEnabled(false);
					menuOpened = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					menuOpened = false;
				}
			}
		});
	}
}