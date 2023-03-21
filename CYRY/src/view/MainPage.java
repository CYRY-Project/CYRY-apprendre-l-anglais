package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.SwapPage;

public class MainPage extends JPanel
{
	/************** Attributs **************/

	private	static	String	imageStr = "src/image/do_you_speak_english_flag.png";
	private	static	int		xMiddle = (int) (App.getWindowWidth() / 2);

	/************** Constructeurs **************/

	public MainPage()
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// Déclaration et initialisation des éléments de la vue

		ImageIcon speakEnglish = new ImageIcon(imageStr);
		JLabel image = new JLabel(speakEnglish);
		JLabel labelPage = new JLabel("Accueil", SwingConstants.CENTER);
		JButton buttonLogIn = new JButton("Connexion");
		JButton buttonSignIn = new JButton("Inscription");

		// Positionnement des éléments

		image.setBounds(xMiddle - 300, 10, 600, 400);
		labelPage.setBounds(xMiddle - 65, 430, 130, 30);
		buttonLogIn.setBounds(xMiddle - 180,550,150,30);
		buttonSignIn.setBounds(xMiddle + 30, 550, 150, 30);

		// Modification des polices

		labelPage.setFont(new Font("Dialog", Font.BOLD, 25));

		// Retrait du fond du JPanel

		setOpaque(false);

		// Ajout des éléments dans le JPanel

		this.add(image);
		this.add(labelPage);
		this.add(buttonLogIn);
		this.add(buttonSignIn);

		// Action de l'appuit sur les boutons

		buttonLogIn.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("LogIn");
					}
				});

		buttonSignIn.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("SignIn") ;
					}
				});
	}
}