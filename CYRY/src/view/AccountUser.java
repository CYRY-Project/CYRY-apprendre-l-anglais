package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.SwapPage;
import controller.VerifAccountUser;
import model.User;

public class AccountUser extends JPanel
{
	/************** Attributs **************/

	private			boolean		flag = false;
	private			boolean		flagDelete = false;
	private			JTextField	fieldNewName;

	private	static	int			xMiddle = (int) (App.getWindowWidth() / 2);
	private	static	AccountUser	acc;

	/************** Constructeurs **************/

	public AccountUser(User user)
	{
		setLayout(null);
		setVisible(true);
		setBackground(new Color(206, 216, 224));
		this.setBounds(xMiddle - 450,0,900,App.getWindowHeight());

		// Déclaration et initialisation des éléments de la vue

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JLabel avatar = new JLabel(avatarStr);
		JLabel name = new JLabel(user.getUserName(), SwingConstants.CENTER);
		JLabel level = new JLabel("Niveau : " + String.valueOf(user.getUserLevel()), SwingConstants.CENTER);
		JLabel points = new JLabel("Points : " + String.valueOf(user.getUserPoints()), SwingConstants.CENTER);
		JLabel newName = new JLabel("Nouvel identifiant");
		fieldNewName = new JTextField();
		JLabel easy = new JLabel("Débutant");
		JLabel easyNumber = new JLabel(VerifAccountUser.returnDifficultyExerciseDone(user,1) + "/" + VerifAccountUser.returnDifficultyExercise(1));
		JLabel medium = new JLabel("Intermédiaire");
		JLabel mediumNumber = new JLabel(VerifAccountUser.returnDifficultyExerciseDone(user,2) +"/" + VerifAccountUser.returnDifficultyExercise(2));
		JLabel hard = new JLabel("Avancé");
		JLabel hardNumber = new JLabel(VerifAccountUser.returnDifficultyExerciseDone(user,3) +"/" + VerifAccountUser.returnDifficultyExercise(3));
		JLabel mcq = new JLabel("QCM");
		JLabel mcqNumber = new JLabel(VerifAccountUser.returnNumberExerciseDone(user, 1) +"/" + VerifAccountUser.returnNumberExercise(1));
		JLabel situation = new JLabel("Situation");
		JLabel situationNumber = new JLabel(VerifAccountUser.returnNumberExerciseDone(user, 2) +"/" + VerifAccountUser.returnNumberExercise(2));
		JLabel fillText = new JLabel("Texte à trous");
		JLabel fillNumber = new JLabel(VerifAccountUser.returnNumberExerciseDone(user, 3) +"/" + VerifAccountUser.returnNumberExercise(3));
		JLabel translation = new JLabel("Traduction");
		JLabel transNumber = new JLabel(VerifAccountUser.returnNumberExerciseDone(user, 4) +"/" + VerifAccountUser.returnNumberExercise(4));
		JLabel buildSentence = new JLabel("Construction de phrase");
		JLabel sentenceNumber = new JLabel(VerifAccountUser.returnNumberExerciseDone(user, 5) +"/" + VerifAccountUser.returnNumberExercise(5));
		JButton deleteAccount = new JButton("Supprimer le compte");
		JButton validDelete = new JButton("oui ?");
		JButton updateAccount = new JButton("Modifier le compte");
		JButton validUpdate = new JButton("Valider");
		JButton disconnectAccount = new JButton("Déconnexion");

		//Modification de la police 

		name.setFont(new Font("Dialog", Font.BOLD, 18));
		level.setFont(new Font("Dialog", Font.BOLD, 16));
		points.setFont(new Font("Dialog", Font.BOLD, 16));
		easy.setFont(new Font("Dialog", Font.BOLD, 16));
		easyNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		medium.setFont(new Font("Dialog", Font.BOLD, 16));
		mediumNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		hard.setFont(new Font("Dialog", Font.BOLD, 16));
		hardNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		mcq.setFont(new Font("Dialog", Font.BOLD, 16));
		mcqNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		situation.setFont(new Font("Dialog", Font.BOLD, 16));
		situationNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		fillText.setFont(new Font("Dialog", Font.BOLD, 16));
		fillNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		translation.setFont(new Font("Dialog", Font.BOLD, 16));
		transNumber.setFont(new Font("Dialog", Font.BOLD, 15));
		buildSentence.setFont(new Font("Dialog", Font.BOLD, 16));
		sentenceNumber.setFont(new Font("Dialog", Font.BOLD, 15));

		//positionnement des elements

		deleteAccount.setBounds(10,10,200,30);
		validDelete.setBounds(220,10,70,30);
		disconnectAccount.setBounds(740,10,150,30);
		updateAccount.setBounds(10,50,200,30);
		avatar.setBounds(420,100,60,60);
		name.setBounds(350,170,200,20);
		level.setBounds(400,200,100,20);
		points.setBounds(390,230,120,20);

		newName.setBounds(10,90,100,20);
		fieldNewName.setBounds(10,110,200,30);
		validUpdate.setBounds(130,145,80,20);

		mcqNumber.setBounds(120,400,30,20);
		mcq.setBounds(145,400,200,20);
		situationNumber.setBounds(120,430,30,20);
		situation.setBounds(145,430,200,20);
		fillNumber.setBounds(120,460,30,20);
		fillText.setBounds(145,460,200,20);
		transNumber.setBounds(120,490,30,20);
		translation.setBounds(145,490,200,20);
		sentenceNumber.setBounds(120,520,30,20);
		buildSentence.setBounds(145,520,200,20);

		easyNumber.setBounds(570,400,30,20);
		easy.setBounds(605,400,200,20);
		mediumNumber.setBounds(570,430,30,20);
		medium.setBounds(605,430,200,20);
		hardNumber.setBounds(570,460,30,20);
		hard.setBounds(605,460,200,20);


		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure

		mcqNumber.setForeground(new Color(178, 133, 108));
		situationNumber.setForeground(new Color(178, 133, 108));
		fillNumber.setForeground(new Color(178, 133, 108));
		transNumber.setForeground(new Color(178, 133, 108));
		sentenceNumber.setForeground(new Color(178, 133, 108));

		easyNumber.setForeground(Color.red);
		mediumNumber.setForeground(Color.red);
		hardNumber.setForeground(Color.red);

		updateAccount.setBackground(new Color(0, 176, 155));
		updateAccount.setForeground(Color.white);
		updateAccount.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						updateAccount.getBorder().getBorderInsets(updateAccount).top, 
						updateAccount.getBorder().getBorderInsets(updateAccount).left, 
						updateAccount.getBorder().getBorderInsets(updateAccount).bottom, 
						updateAccount.getBorder().getBorderInsets(updateAccount).right)));
		deleteAccount.setBackground(new Color(0, 176, 155));
		deleteAccount.setForeground(Color.white);
		deleteAccount.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						deleteAccount.getBorder().getBorderInsets(deleteAccount).top, 
						deleteAccount.getBorder().getBorderInsets(deleteAccount).left, 
						deleteAccount.getBorder().getBorderInsets(deleteAccount).bottom, 
						deleteAccount.getBorder().getBorderInsets(deleteAccount).right)));
		disconnectAccount.setBackground(new Color(235, 57, 78));
		disconnectAccount.setForeground(Color.white);
		disconnectAccount.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						disconnectAccount.getBorder().getBorderInsets(disconnectAccount).top, 
						disconnectAccount.getBorder().getBorderInsets(disconnectAccount).left, 
						disconnectAccount.getBorder().getBorderInsets(disconnectAccount).bottom, 
						disconnectAccount.getBorder().getBorderInsets(disconnectAccount).right)));
		validDelete.setBackground(new Color(255, 163, 50));
		validDelete.setForeground(Color.white);
		validDelete.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 163, 50), 2), 
				BorderFactory.createEmptyBorder(
						validDelete.getBorder().getBorderInsets(validDelete).top, 
						validDelete.getBorder().getBorderInsets(validDelete).left, 
						validDelete.getBorder().getBorderInsets(validDelete).bottom, 
						validDelete.getBorder().getBorderInsets(disconnectAccount).right)));

		//Ajout des éléments

		this.add(avatar);
		this.add(name);
		this.add(level);
		this.add(points);
		this.add(deleteAccount);
		this.add(validDelete);
		this.add(updateAccount);
		this.add(disconnectAccount);
		this.add(newName);
		this.add(fieldNewName);
		this.add(validUpdate);
		this.add(mcq);
		this.add(mcqNumber);
		this.add(situation);
		this.add(situationNumber);
		this.add(fillText);
		this.add(fillNumber);
		this.add(buildSentence);
		this.add(sentenceNumber);
		this.add(translation);
		this.add(transNumber);
		this.add(sentenceNumber);
		this.add(easy);
		this.add(easyNumber);
		this.add(medium);
		this.add(mediumNumber);
		this.add(hard);
		this.add(hardNumber);

		//Champs caché

		newName.setVisible(false);
		fieldNewName.setVisible(false);
		validUpdate.setVisible(false);
		validDelete.setVisible(false);

		//Gestion des cliques

		// déconnexion

		disconnectAccount.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				SwapPage.swapPage("MainPage");
				System.gc();
			}
		});

		// supprimer compte 

		deleteAccount.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(!flagDelete)
				{
					validDelete.setVisible(true);
					flagDelete = true;
				}
				else
				{
					validDelete.setVisible(false);
					flagDelete = false;
				}
			}
		});

		// valider la suppression

		validDelete.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				VerifAccountUser.deleteUser(user);
			}
		});

		// fait apparaitre les champs pour modifier

		updateAccount.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(!flag)
				{
					newName.setVisible(true);
					fieldNewName.setVisible(true);
					validUpdate.setVisible(true);
					flag = true;
				}
				else
				{
					AccountUser.this.clear();
					newName.setVisible(false);
					fieldNewName.setVisible(false);
					validUpdate.setVisible(false);
					flag = false;
				}
			}
		});

		Action actionValidUpdate = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String valName = fieldNewName.getText();
				System.out.println(fieldNewName.getText() );
				try 
				{
					VerifAccountUser.updateUserName(AccountUser.acc,user, valName);
				} 
				catch (HeadlessException e1) 
				{
					e1.printStackTrace();
				}
			}
		};

		fieldNewName.addActionListener(actionValidUpdate);
		validUpdate.addActionListener(actionValidUpdate);
	}

	/************** Accesseurs **************/

	/********** Getters **********/

	public static  AccountUser getAcc()
	{
		return acc;
	}

	/********** Setters **********/

	public static void setAcc(AccountUser newAcc)
	{
		acc = newAcc;
	}

	public void clear()
	{
		this.fieldNewName.setText("");
	}
}