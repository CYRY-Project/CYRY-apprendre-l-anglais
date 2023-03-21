package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.SwapPage;
import controller.VerifUser;

public class Connection extends JPanel
{
	/************** Attributs **************/

	private	static	String			imageStr = "src/image/do_you_speak_english_flag.png";
	private	static	int				xMiddle = (int) (App.getWindowWidth() / 2);

	private			JTextField		fieldId;
	private			JPasswordField	fieldPassword;

	/************** Constructeurs **************/

	public Connection()
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// Déclaration et initialisation des éléments de la vue

		ImageIcon speakEnglish = new ImageIcon(imageStr);
		JLabel image = new JLabel(speakEnglish);
		JLabel labelPage = new JLabel("Connexion", SwingConstants.CENTER);
		JLabel labelId = new JLabel("Identifiant", SwingConstants.RIGHT);
		fieldId = new JTextField();
		JLabel labelPassword = new JLabel("Mot de passe", SwingConstants.RIGHT);
		fieldPassword = new JPasswordField();
		JButton buttonMain = new JButton("Accueil");
		JButton buttonForget = new JButton("Mot de passe perdu");
		JButton buttonConfirm = new JButton("Valider");
		JButton buttonSignIn = new JButton("Inscription");

		// Positionnement des éléments

		image.setBounds(xMiddle - 300, 10, 600, 400);
		labelPage.setBounds(xMiddle - 65, 430, 130, 30);
		labelId.setBounds(xMiddle - 160, 510, 60, 30);
		fieldId.setBounds(xMiddle - 90, 510, 250, 30);
		labelPassword.setBounds(xMiddle - 180, 570, 80, 30);
		fieldPassword.setBounds(xMiddle - 90, 570, 250, 30);
		buttonMain.setBounds(50, 640, 80, 30);
		buttonForget.setBounds(xMiddle - 300, 640, 150, 30);
		buttonConfirm.setBounds(xMiddle + 220, 640, 80, 30);
		buttonSignIn.setBounds(App.getWindowWidth() - 180, 640, 100, 30);

		// Modification des polices

		labelPage.setFont(new Font("Dialog", Font.BOLD, 25));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure

		buttonMain.setBackground(Color.white);
		buttonMain.setForeground(new Color(235, 57, 78));
		buttonMain.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonMain.getBorder().getBorderInsets(buttonMain).top, 
						buttonMain.getBorder().getBorderInsets(buttonMain).left, 
						buttonMain.getBorder().getBorderInsets(buttonMain).bottom, 
						buttonMain.getBorder().getBorderInsets(buttonMain).right)));
		buttonForget.setBackground(new Color(235, 57, 78));
		buttonForget.setForeground(Color.white);
		buttonForget.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonForget.getBorder().getBorderInsets(buttonForget).top, 
						buttonForget.getBorder().getBorderInsets(buttonForget).left, 
						buttonForget.getBorder().getBorderInsets(buttonForget).bottom, 
						buttonForget.getBorder().getBorderInsets(buttonForget).right)));
		buttonConfirm.setBackground(new Color(0, 176, 155));
		buttonConfirm.setForeground(Color.white);
		buttonConfirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).top, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).left, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).bottom, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).right)));
		buttonSignIn.setBackground(Color.white);
		buttonSignIn.setForeground(new Color(103, 91, 243));
		buttonSignIn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(103, 91, 243), 2), 
				BorderFactory.createEmptyBorder(
						buttonSignIn.getBorder().getBorderInsets(buttonSignIn).top, 
						buttonSignIn.getBorder().getBorderInsets(buttonSignIn).left, 
						buttonSignIn.getBorder().getBorderInsets(buttonSignIn).bottom, 
						buttonSignIn.getBorder().getBorderInsets(buttonSignIn).right)));

		// Retrait du fond du JPanel

		setOpaque(false);

		// Ajout des éléments dans le JPanel

		this.add(image);
		this.add(labelPage);
		this.add(labelId);
		this.add(fieldId);
		this.add(labelPassword);
		this.add(fieldPassword);
		this.add(buttonMain);
		this.add(buttonForget);
		this.add(buttonConfirm);
		this.add(buttonSignIn);

		// Action à l'appuit sur les boutons

		Action actionConfirm = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				VerifUser.verifConn(Connection.this,fieldId.getText(),fieldPassword.getText());

			}
		};

		fieldId.addActionListener(actionConfirm);
		fieldPassword.addActionListener(actionConfirm);
		buttonConfirm.addActionListener(actionConfirm);

		buttonMain.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("MainPage");
					}
				});

		buttonForget.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("ForgetPassword");
					}
				});

		buttonSignIn.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("SignIn");
					}
				});
	}

	/************** Accesseurs **************/

	/********** Setters **********/

	public void clear()	
	{
		this.fieldId.setText("");
		this.fieldPassword.setText("");
	}
}