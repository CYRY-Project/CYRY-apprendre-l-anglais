package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controller.SwapPage;

import model.User;

public class LevelCompleted extends JPanel
{
	/************** Attributs **************/

	private	static	String	imageStr = "src/image/level.png";
	private	static	int		xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean	menuOpened = false;
	private			boolean	accountOpened = false;

	private			boolean	timerOn = true;
	private			Timer	countdown;
	private			int		counter = 20;
	private			JLabel	commentsTime;

	/************** Constructeurs **************/

	public LevelCompleted(User user)
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		//timer qui ramène sur la vue "Home" au bout de 10 secondes

		countdown = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				counter--;
				commentsTime.setText("Sinon, vous allez être redirigé automatiquement dans " + String.valueOf(counter) + " secondes au menu principal.");
				if(counter == 0)
				{
					timerOn = false;
					countdown.stop();
					SwapPage.swapPage("Home", user);
				}
			}
		});
		countdown.start();

		// Déclaration et initialisation des éléments de la vue

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JButton avatar = new JButton(avatarStr);
		JLabel name = new JLabel(user.getUserName());
		JLabel level = new JLabel("Niveau : " + String.valueOf(user.getUserLevel()));
		JLabel points = new JLabel("Points : " + String.valueOf(user.getUserPoints()));
		JButton menu = new JButton("Menu");

		ImageIcon imageLvl = new ImageIcon(imageStr);
		JLabel levelCompleted = new JLabel(imageLvl);
		JLabel lvlCompleted = new JLabel("Vous avez terminé tout les exercises de ce niveau de difficulté. Well Done !", SwingConstants.CENTER);
		JLabel comments = new JLabel("Si ce n'est pas déjà fait, lancez vous sur les niveaux de difficulté supérieurs.", SwingConstants.CENTER);
		commentsTime = new JLabel("Sinon, vous allez être redirigé automatiquement dans " + String.valueOf(counter) + " secondes au menu principal.", SwingConstants.CENTER);

		// Positionnement des éléments

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		levelCompleted.setBounds(xMiddle - 300, 150, 600, 150 );
		lvlCompleted.setBounds(xMiddle - (App.getWindowWidth() / 2), (App.getWindowHeight() / 2) , App.getWindowWidth(), 30);
		comments.setBounds(xMiddle - (App.getWindowWidth() / 2), (App.getWindowHeight() / 2) + 50, App.getWindowWidth(), 30);
		commentsTime.setBounds(xMiddle - (App.getWindowWidth() / 2), (App.getWindowHeight() / 2) + 100, App.getWindowWidth(), 30);

		//Modification des polices 

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		lvlCompleted.setFont(new Font("Dialog",Font.BOLD,25));
		comments.setFont(new Font("Dialog",Font.BOLD,20));
		commentsTime.setFont(new Font("Dialog",Font.BOLD,20));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure	

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		// Retrait du fond du JPanel

		avatar.setOpaque(false);
		avatar.setContentAreaFilled(false);
		avatar.setBorderPainted(false);

		setOpaque(false);

		// Ajout des éléments dans le JPanel

		this.add(avatar);
		this.add(name);
		this.add(level);
		this.add(points);
		this.add(menu);
		this.add(lvlCompleted);
		this.add(levelCompleted);
		this.add(comments);
		this.add(commentsTime);

		//Gestion des cliques

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
					countdown.stop();
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					menuOpened = false;
					if(timerOn)
					{
						countdown.start();
					}
				}
			}
		});

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
					countdown.stop();
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
					if(timerOn)
					{
						countdown.start();
					}
				}
			}
		});
	}
}