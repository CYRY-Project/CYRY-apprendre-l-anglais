package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.SwapPage;
import controller.VerifExercise;

import model.User;
import model.Exercise;

public class Situation extends JPanel 
{
	/************** Attributs **************/
	
	private	static	int					xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean				flag = false;
	private			boolean				flagMenu = false;
	private			boolean				flagA1 = false ;
	private			boolean				flagA2 = false ;
	private			boolean				flagA3 = false ;
	private			boolean				flagA4 = false ;

	private			String				chooseAnswer = "";
	private			ArrayList<Integer>	answerPicked = new ArrayList<Integer>() ;

	/************** Constructeurs **************/

	public Situation(User user,Exercise exercise)
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// Déclaration et initialisation des éléments de la vue

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JButton avatar = new JButton(avatarStr);
		JLabel name = new JLabel(user.getUserName());
		JLabel level = new JLabel("Level : " + String.valueOf(user.getUserLevel()));
		JLabel points = new JLabel("Score : " + String.valueOf(user.getUserPoints()));
		JButton menu = new JButton("Menu");

		ImageIcon image1 = new ImageIcon("src/image/exercise/" + exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		ImageIcon image2 = new ImageIcon("src/image/exercise/" +exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		ImageIcon image3 = new ImageIcon("src/image/exercise/" +exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		ImageIcon image4 = new ImageIcon("src/image/exercise/" +exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));

		JLabel labelQuestion = new JLabel (exercise.getExerciseQuestions().get(0).get(1),SwingConstants.CENTER);

		JButton buttonAnswer1 = new JButton(image1);
		JButton buttonAnswer2 = new JButton(image2);
		JButton buttonAnswer3 = new JButton(image3);
		JButton buttonAnswer4 = new JButton(image4);
		JButton buttonConfirm = new JButton ("Valider");
		JButton buttonQuit = new JButton ("Quitter");
		JButton buttonRules = new JButton("Règles");

		// Positionnement des éléments

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		labelQuestion.setBounds(xMiddle - 400, 80, 800, 50);
		buttonAnswer1.setBounds(xMiddle - 400, 180, 300, 200);
		buttonAnswer2.setBounds(xMiddle - 400, 420, 300, 200);
		buttonAnswer3.setBounds(xMiddle + 125, 180, 300, 200);
		buttonAnswer4.setBounds(xMiddle + 125, 420, 300, 200);
		buttonConfirm.setBounds(xMiddle - 40, 640, 80, 30);
		buttonQuit.setBounds(App.getWindowWidth() - 110, 640, 80, 30);
		buttonRules.setBounds(30, 640, 80, 30);

		// Retrait du fond du JPanel et de la CheckBox

		avatar.setOpaque(false);
		avatar.setContentAreaFilled(false);
		avatar.setBorderPainted(false);

		setOpaque(false);

		// Modification des polices

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		labelQuestion.setFont(new Font("Dialog", Font.BOLD, 25));

		//Gestion des bordures

		buttonConfirm.setBackground(new Color(0, 176, 155));
		buttonConfirm.setForeground(Color.white);
		buttonConfirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).top, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).left, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).bottom, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).right)));
		buttonQuit.setBackground(Color.white);
		buttonQuit.setForeground(new Color(235, 57, 78));
		buttonQuit.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuit.getBorder().getBorderInsets(buttonQuit).top, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).left, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).bottom, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).right)));
		buttonRules.setBackground(new Color(255, 163, 50));
		buttonRules.setForeground(Color.white);
		buttonRules.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 163, 50), 2), 
				BorderFactory.createEmptyBorder(
						buttonRules.getBorder().getBorderInsets(buttonRules).top, 
						buttonRules.getBorder().getBorderInsets(buttonRules).left, 
						buttonRules.getBorder().getBorderInsets(buttonRules).bottom, 
						buttonRules.getBorder().getBorderInsets(buttonRules).right)));

		// Retrait du fond du JPanel et de la CheckBox

		this.add(avatar);
		this.add(name);
		this.add(level);
		this.add(points);
		this.add(menu);

		this.add(labelQuestion);
		this.add(buttonAnswer1);
		this.add(buttonAnswer2);
		this.add(buttonAnswer3);
		this.add(buttonAnswer4);
		this.add(buttonConfirm);
		this.add(buttonQuit);
		this.add(buttonRules);

		// Action de l'appuit sur les boutons

		avatar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!flag)
				{

					SwapPage.swapPage("Account",user);
					name.setVisible(false);
					level.setVisible(false);
					points.setVisible(false);
					menu.setEnabled(false);
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
					flag = true ;
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
					if(flagA1)
					{
						buttonAnswer1.setEnabled(true);
					}
					if(flagA2)
					{
						buttonAnswer2.setEnabled(true);
					}
					if(flagA3)
					{
						buttonAnswer3.setEnabled(true);
					}
					if(flagA4)
					{
						buttonAnswer4.setEnabled(true);
					}
					if(!flagA1 && !flagA2 && !flagA3 && !flagA4)
					{
						buttonAnswer1.setEnabled(true);
						buttonAnswer2.setEnabled(true);
						buttonAnswer3.setEnabled(true);
						buttonAnswer4.setEnabled(true);
					}
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
					flag = false;
				}
			}
		});

		menu.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!flagMenu)
				{
					SwapPage.swapPage("Menu",user);
					avatar.setEnabled(false);
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
					flagMenu = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					if(flagA1)
					{
						buttonAnswer1.setEnabled(true);
					}
					if(flagA2)
					{
						buttonAnswer2.setEnabled(true);
					}
					if(flagA3)
					{
						buttonAnswer3.setEnabled(true);
					}
					if(flagA4)
					{
						buttonAnswer4.setEnabled(true);
					}
					if(!flagA1 && !flagA2 && !flagA3 && !flagA4)
					{
						buttonAnswer1.setEnabled(true);
						buttonAnswer2.setEnabled(true);
						buttonAnswer3.setEnabled(true);
						buttonAnswer4.setEnabled(true);
					}
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
					flagMenu = false;
				}
			}
		});

		buttonAnswer1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!flagA1)
				{	
					String	valueA1 = buttonAnswer1.getIcon().toString();
					String[] strTabAnswer = valueA1.split("/");
					chooseAnswer = strTabAnswer[3];
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					Situation.this.addBorder(buttonAnswer1);
					flagA1 = true;
				}
				else
				{
					chooseAnswer = "";
					buttonAnswer2.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					Situation.this.removeBorder(buttonAnswer1);
					flagA1 = false;
				}
			}
		});

		buttonAnswer2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!flagA2)
				{	
					String	valueA2 = buttonAnswer2.getIcon().toString();
					String[] strTabAnswer = valueA2.split("/");
					chooseAnswer = strTabAnswer[3];
					buttonAnswer1.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					Situation.this.addBorder(buttonAnswer2);
					flagA2 = true;
				}
				else
				{
					chooseAnswer = "";
					buttonAnswer1.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					Situation.this.removeBorder(buttonAnswer2);
					flagA2 = false;
				}
			}
		});

		buttonAnswer3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!flagA3)
				{	
					String	valueA3 = buttonAnswer3.getIcon().toString();
					String[] strTabAnswer = valueA3.split("/");
					chooseAnswer = strTabAnswer[3];
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					Situation.this.addBorder(buttonAnswer3);
					flagA3 = true;
				}
				else
				{
					chooseAnswer = "";
					buttonAnswer1.setEnabled(true);
					buttonAnswer2.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					Situation.this.removeBorder(buttonAnswer3);
					flagA3 = false;
				}
			}
		});

		buttonAnswer4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!flagA4)
				{	
					String	valueA4 = buttonAnswer4.getIcon().toString();
					String[] strTabAnswer = valueA4.split("/");
					chooseAnswer = strTabAnswer[3];
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					Situation.this.addBorder(buttonAnswer4);
					flagA4 = true;
				}
				else
				{
					chooseAnswer = "";
					buttonAnswer1.setEnabled(true);
					buttonAnswer2.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					Situation.this.removeBorder(buttonAnswer4);
					flagA4 = false;
				}
			}
		});

		buttonConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!chooseAnswer.isBlank())
				{
					VerifExercise.verifAnswer(user, exercise, chooseAnswer);
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"Veuillez choisir une réponse ");
				}
			}
		});

		buttonQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SwapPage.swapPage("Home",user);
			}
		});
		
		buttonRules.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(App.getApp(), "Choisir la bonne réponse parmi les 4 choix possibles pour répondre à la question.\n\n"
						+ "Cliquer sur la réponse choisie puis cliquer sur \"Valider\".");
			}
		});
	}

	/************** Méthodes **************/

	//ajoute des bordures au bouton selectionné

	public void addBorder(JButton btn)
	{
		btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 55, 78), 3), 
				BorderFactory.createEmptyBorder(
						btn.getBorder().getBorderInsets(btn).top, 
						btn.getBorder().getBorderInsets(btn).left, 
						btn.getBorder().getBorderInsets(btn).bottom, 
						btn.getBorder().getBorderInsets(btn).right)));
	}

	//enleve des bordures au bouton selectionné

	public void removeBorder(JButton btn)
	{
		btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 191, 155) , 0), 
				BorderFactory.createEmptyBorder(
						btn.getBorder().getBorderInsets(btn).top, 
						btn.getBorder().getBorderInsets(btn).left, 
						btn.getBorder().getBorderInsets(btn).bottom, 
						btn.getBorder().getBorderInsets(btn).right)));
	}
}