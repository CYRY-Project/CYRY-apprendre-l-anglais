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

public class Inscription extends JPanel
{
	/************** Attributs **************/

	private	static	String			imageStr = "src/image/do_you_speak_english_flag.png";
	private	static	int				xMiddle = (int) (App.getWindowWidth() / 2);

	private			JTextField		fieldId;
	private			JPasswordField	fieldPassword;
	private			JPasswordField	fieldPasswordVerif;
	private			JTextField		fieldDate;

	/************** Constructeurs **************/

	public Inscription()
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// Déclaration et initialisation des éléments de la vue

		ImageIcon speakEnglish = new ImageIcon(imageStr);
		JLabel image = new JLabel(speakEnglish);
		JLabel labelPage = new JLabel("Inscription", SwingConstants.CENTER);
		JLabel labelId = new JLabel("Identifiant", SwingConstants.RIGHT);
		fieldId = new JTextField();
		JLabel labelPassword = new JLabel("Mot de passe", SwingConstants.RIGHT);
		fieldPassword = new JPasswordField();
		JLabel labelPasswordVerif = new JLabel("Confirmer le mot de passe", SwingConstants.RIGHT);
		fieldPasswordVerif = new JPasswordField();
		JLabel labelDate = new JLabel("Date de naissance (JJ-MM-AAAA)", SwingConstants.RIGHT);
		fieldDate = new JTextField();
		JButton buttonMain = new JButton("Accueil");
		JButton buttonClear = new JButton("Effacer");
		JButton buttonConfirm = new JButton("Valider");
		JButton buttonLogIn = new JButton("Connexion");

		// Positionnement des éléments

		image.setBounds(xMiddle - 300, 10, 600, 400);
		labelPage.setBounds(xMiddle - 65, 430, 130, 30);
		labelId.setBounds(xMiddle - 160, 470, 60, 30);
		fieldId.setBounds(xMiddle - 90, 470, 250, 30);
		labelPassword.setBounds(xMiddle - 180, 510, 80, 30);
		fieldPassword.setBounds(xMiddle - 90, 510, 250, 30);
		labelPasswordVerif.setBounds(xMiddle - 250, 550, 150, 30);
		fieldPasswordVerif.setBounds(xMiddle - 90, 550, 250, 30);
		labelDate.setBounds(xMiddle - 300, 590, 200, 30);
		fieldDate.setBounds(xMiddle - 90, 590, 250, 30);
		buttonMain.setBounds(50, 640, 80, 30);
		buttonClear.setBounds(xMiddle - 300, 640, 80, 30);
		buttonConfirm.setBounds(xMiddle + 220, 640, 80, 30);
		buttonLogIn.setBounds(App.getWindowWidth() - 180, 640, 100, 30);

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
		buttonClear.setBackground(new Color(235, 57, 78));
		buttonClear.setForeground(Color.white);
		buttonClear.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonClear.getBorder().getBorderInsets(buttonClear).top, 
						buttonClear.getBorder().getBorderInsets(buttonClear).left, 
						buttonClear.getBorder().getBorderInsets(buttonClear).bottom, 
						buttonClear.getBorder().getBorderInsets(buttonClear).right)));
		buttonConfirm.setBackground(new Color(0, 176, 155));
		buttonConfirm.setForeground(Color.white);
		buttonConfirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).top, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).left, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).bottom, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).right)));
		buttonLogIn.setBackground(Color.white);
		buttonLogIn.setForeground(new Color(103, 91, 243));
		buttonLogIn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(103, 91, 243), 2), 
				BorderFactory.createEmptyBorder(
						buttonLogIn.getBorder().getBorderInsets(buttonLogIn).top, 
						buttonLogIn.getBorder().getBorderInsets(buttonLogIn).left, 
						buttonLogIn.getBorder().getBorderInsets(buttonLogIn).bottom, 
						buttonLogIn.getBorder().getBorderInsets(buttonLogIn).right)));

		// Retrait du fond du JPanel

		setOpaque(false);

		// Ajout des éléments dans le JPanel

		this.add(image);
		this.add(labelPage);
		this.add(labelId);
		this.add(fieldId);
		this.add(labelPassword);
		this.add(fieldPassword);
		this.add(labelPasswordVerif);
		this.add(fieldPasswordVerif);
		this.add(labelDate);
		this.add(fieldDate);
		this.add(buttonMain);
		this.add(buttonClear);
		this.add(buttonConfirm);
		this.add(buttonLogIn);

		// Action de l'appuit sur les boutons

		Action actionConfirm = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				{
					VerifUser.verifSub(Inscription.this, fieldId.getText(), fieldPassword.getText(), fieldPasswordVerif.getText(), fieldDate.getText());
				}
			}
		};

		fieldId.addActionListener(actionConfirm);
		fieldPassword.addActionListener(actionConfirm);
		fieldPasswordVerif.addActionListener(actionConfirm);
		fieldDate.addActionListener(actionConfirm);
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

		buttonClear.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						clear();
					}
				});

		buttonLogIn.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						SwapPage.swapPage("LogIn");
					}
				});
	}

	/************** Accesseurs **************/
	
	/********** Setters **********/

	public void clear()	
	{
		this.fieldId.setText("");
		this.fieldPassword.setText("");
		this.fieldPasswordVerif.setText("");
		this.fieldDate.setText("");
	}
}