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
import model.Exercise;
import model.User;

public class Translation extends JPanel 
{
	/************** Attributs **************/
	
	private	static	int								xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean							menuOpened = false;
	private			boolean							accountOpened = false;

	private			ArrayList<Integer> 				questionDisplay = new ArrayList<Integer>() ;
	private			ArrayList<Integer>				answerDisplay = new ArrayList<Integer>() ;
	private			ArrayList<ArrayList<String>>	userAnswers = new ArrayList<ArrayList<String>>();
	private			JLabel 							chooseQuestion;
	private			JLabel 							chooseAnswer;
	private			boolean 						flagQ1 = false;
	private			boolean 						flagQ2 = false;
	private			boolean 						flagQ3 = false;
	private			boolean 						flagQ4 = false;
	private			boolean 						flagQ5 = false;
	private			boolean 						flagQ1C = false;
	private			boolean 						flagQ2C = false;
	private			boolean 						flagQ3C = false;
	private			boolean 						flagQ4C = false;
	private			boolean 						flagQ5C = false;
	private			boolean 						flagA1 = false;
	private			boolean 						flagA2 = false;
	private			boolean 						flagA3 = false;
	private			boolean 						flagA4 = false;
	private			boolean 						flagA5 = false;
	private			boolean 						flagA1C = false;
	private			boolean 						flagA2C = false;
	private			boolean 						flagA3C = false;
	private			boolean 						flagA4C = false;
	private			boolean 						flagA5C = false;

	/************** Constructeurs **************/
	
	public Translation(User user, Exercise exercise)
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

		JLabel title = new JLabel(exercise.getExerciseTitle(), SwingConstants.CENTER);
		chooseQuestion = new JLabel("", SwingConstants.CENTER);
		chooseAnswer = new JLabel("", SwingConstants.CENTER);
		JButton check = new JButton("Vérouiller");
		JButton buttonQuestion1 = new JButton(exercise.getExerciseQuestions().get(VerifExercise.randomAnswer(questionDisplay, exercise)).get(1));
		JButton buttonQuestion2 = new JButton(exercise.getExerciseQuestions().get(VerifExercise.randomAnswer(questionDisplay, exercise)).get(1));
		JButton buttonQuestion3 = new JButton(exercise.getExerciseQuestions().get(VerifExercise.randomAnswer(questionDisplay, exercise)).get(1));
		JButton buttonQuestion4 = new JButton(exercise.getExerciseQuestions().get(VerifExercise.randomAnswer(questionDisplay, exercise)).get(1));
		JButton buttonQuestion5 = new JButton(exercise.getExerciseQuestions().get(VerifExercise.randomAnswer(questionDisplay, exercise)).get(1));
		JButton buttonAnswer1 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answerDisplay, exercise)).get(1));
		JButton buttonAnswer2 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answerDisplay, exercise)).get(1));
		JButton buttonAnswer3 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answerDisplay, exercise)).get(1));
		JButton buttonAnswer4 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answerDisplay, exercise)).get(1));
		JButton buttonAnswer5 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answerDisplay, exercise)).get(1));
		JButton buttonReset = new JButton ("Réinitialiser");
		JButton buttonConfirm = new JButton ("Valider");
		JButton buttonQuit = new JButton ("Quitter");
		JButton buttonRules = new JButton("Règles");

		// Positionnement des éléments

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		title.setBounds(xMiddle - (App.getWindowWidth() / 2), 100, App.getWindowWidth(), 40);
		chooseQuestion.setBounds(xMiddle - 160, 440, 150, 30);
		chooseAnswer.setBounds(xMiddle + 10, 440, 150, 30);
		check.setBounds(xMiddle - 60, 480, 120, 20);
		buttonQuestion1.setBounds(xMiddle - 500, 300, 200, 30);
		buttonQuestion2.setBounds(xMiddle - 500, 370, 200, 30);
		buttonQuestion3.setBounds(xMiddle - 500, 440, 200, 30);
		buttonQuestion4.setBounds(xMiddle - 500, 510, 200, 30);
		buttonQuestion5.setBounds(xMiddle - 500, 580, 200, 30);
		buttonAnswer1.setBounds(xMiddle + 300, 300, 200, 30);
		buttonAnswer2.setBounds(xMiddle + 300, 370, 200, 30);
		buttonAnswer3.setBounds(xMiddle + 300, 440, 200, 30);
		buttonAnswer4.setBounds(xMiddle + 300, 510, 200, 30);
		buttonAnswer5.setBounds(xMiddle + 300, 580, 200, 30);
		buttonReset.setBounds(xMiddle - 140, 640, 120, 30);
		buttonConfirm.setBounds(xMiddle + 20, 640, 120, 30);
		buttonQuit.setBounds(App.getWindowWidth() - 110, 640, 80, 30);
		buttonRules.setBounds(30, 640, 80, 30);

		// Modification des polices

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		title.setFont(new Font("Dialog",Font.BOLD,25));
		chooseQuestion.setFont(new Font("Dialog",Font.BOLD,22));
		chooseAnswer.setFont(new Font("Dialog",Font.BOLD,22));
		buttonQuestion1.setFont(new Font("Dialog",Font.BOLD,16));
		buttonQuestion2.setFont(new Font("Dialog",Font.BOLD,16));
		buttonQuestion3.setFont(new Font("Dialog",Font.BOLD,16));
		buttonQuestion4.setFont(new Font("Dialog",Font.BOLD,16));
		buttonQuestion5.setFont(new Font("Dialog",Font.BOLD,16));
		buttonAnswer1.setFont(new Font("Dialog",Font.BOLD,16));
		buttonAnswer2.setFont(new Font("Dialog",Font.BOLD,16));
		buttonAnswer3.setFont(new Font("Dialog",Font.BOLD,16));
		buttonAnswer4.setFont(new Font("Dialog",Font.BOLD,16));
		buttonAnswer5.setFont(new Font("Dialog",Font.BOLD,16));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure	

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		chooseQuestion.setBackground(Color.white);
		chooseQuestion.setForeground(new Color(235, 57, 78));
		chooseQuestion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		chooseAnswer.setBackground(Color.white);
		chooseAnswer.setForeground(new Color(0, 0, 0));
		chooseAnswer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		check.setBackground(new Color(0, 176, 155));
		check.setForeground(Color.white);
		check.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						check.getBorder().getBorderInsets(check).top, 
						check.getBorder().getBorderInsets(check).left, 
						check.getBorder().getBorderInsets(check).bottom, 
						check.getBorder().getBorderInsets(check).right)));
		buttonQuestion1.setBackground(Color.white);
		buttonQuestion1.setForeground(new Color(235, 57, 78));
		buttonQuestion1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuestion1.getBorder().getBorderInsets(buttonQuestion1).top, 
						buttonQuestion1.getBorder().getBorderInsets(buttonQuestion1).left, 
						buttonQuestion1.getBorder().getBorderInsets(buttonQuestion1).bottom, 
						buttonQuestion1.getBorder().getBorderInsets(buttonQuestion1).right)));
		buttonQuestion2.setBackground(Color.white);
		buttonQuestion2.setForeground(new Color(235, 57, 78));
		buttonQuestion2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuestion2.getBorder().getBorderInsets(buttonQuestion2).top, 
						buttonQuestion2.getBorder().getBorderInsets(buttonQuestion2).left, 
						buttonQuestion2.getBorder().getBorderInsets(buttonQuestion2).bottom, 
						buttonQuestion2.getBorder().getBorderInsets(buttonQuestion2).right)));
		buttonQuestion3.setBackground(Color.white);
		buttonQuestion3.setForeground(new Color(235, 57, 78));
		buttonQuestion3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuestion3.getBorder().getBorderInsets(buttonQuestion3).top, 
						buttonQuestion3.getBorder().getBorderInsets(buttonQuestion3).left, 
						buttonQuestion3.getBorder().getBorderInsets(buttonQuestion3).bottom, 
						buttonQuestion3.getBorder().getBorderInsets(buttonQuestion3).right)));
		buttonQuestion4.setBackground(Color.white);
		buttonQuestion4.setForeground(new Color(235, 57, 78));
		buttonQuestion4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuestion4.getBorder().getBorderInsets(buttonQuestion4).top, 
						buttonQuestion4.getBorder().getBorderInsets(buttonQuestion4).left, 
						buttonQuestion4.getBorder().getBorderInsets(buttonQuestion4).bottom, 
						buttonQuestion4.getBorder().getBorderInsets(buttonQuestion4).right)));
		buttonQuestion5.setBackground(Color.white);
		buttonQuestion5.setForeground(new Color(235, 57, 78));
		buttonQuestion5.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuestion5.getBorder().getBorderInsets(buttonQuestion5).top, 
						buttonQuestion5.getBorder().getBorderInsets(buttonQuestion5).left, 
						buttonQuestion5.getBorder().getBorderInsets(buttonQuestion5).bottom, 
						buttonQuestion5.getBorder().getBorderInsets(buttonQuestion5).right)));
		buttonAnswer1.setBackground(Color.white);
		buttonAnswer1.setForeground(new Color(0, 0, 0));
		buttonAnswer1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).top, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).left, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).bottom, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).right)));
		buttonAnswer2.setBackground(Color.white);
		buttonAnswer2.setForeground(new Color(0, 0, 0));
		buttonAnswer2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).top, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).left, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).bottom, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).right)));
		buttonAnswer3.setBackground(Color.white);
		buttonAnswer3.setForeground(new Color(0, 0, 0));
		buttonAnswer3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).top, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).left, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).bottom, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).right)));
		buttonAnswer4.setBackground(Color.white);
		buttonAnswer4.setForeground(new Color(0, 0, 0));
		buttonAnswer4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).top, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).left, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).bottom, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).right)));
		buttonAnswer5.setBackground(Color.white);
		buttonAnswer5.setForeground(new Color(0, 0, 0));
		buttonAnswer5.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer5.getBorder().getBorderInsets(buttonAnswer5).top, 
						buttonAnswer5.getBorder().getBorderInsets(buttonAnswer5).left, 
						buttonAnswer5.getBorder().getBorderInsets(buttonAnswer5).bottom, 
						buttonAnswer5.getBorder().getBorderInsets(buttonAnswer5).right)));
		buttonReset.setBackground(new Color(235, 57, 78));
		buttonReset.setForeground(Color.white);
		buttonReset.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonReset.getBorder().getBorderInsets(buttonReset).top, 
						buttonReset.getBorder().getBorderInsets(buttonReset).left, 
						buttonReset.getBorder().getBorderInsets(buttonReset).bottom, 
						buttonReset.getBorder().getBorderInsets(buttonReset).right)));
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

		// Retrait du fond du JPanel et de l'avatar

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

		this.add(title);
		this.add(chooseQuestion);
		this.add(chooseAnswer);
		this.add(check);
		this.add(buttonQuestion1);
		this.add(buttonQuestion2);
		this.add(buttonQuestion3);
		this.add(buttonQuestion4);
		this.add(buttonQuestion5);
		this.add(buttonAnswer1);
		this.add(buttonAnswer2);
		this.add(buttonAnswer3);
		this.add(buttonAnswer4);
		this.add(buttonAnswer5);
		this.add(buttonReset);
		this.add(buttonConfirm);
		this.add(buttonQuit);
		this.add(buttonRules);

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
					check.setEnabled(false);
					buttonQuestion1.setEnabled(false);
					buttonQuestion2.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					buttonReset.setEnabled(false);
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
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
					check.setEnabled(true);
					if(!flagQ1C && !flagQ2 && !flagQ3 && !flagQ4 && !flagQ5)
					{
						buttonQuestion1.setEnabled(true);
					}
					if(!flagQ2C && !flagQ1 && !flagQ3 && !flagQ4 && !flagQ5)
					{
						buttonQuestion2.setEnabled(true);
					}
					if(!flagQ3C && !flagQ1 && !flagQ2 && !flagQ4 && !flagQ5)
					{
						buttonQuestion3.setEnabled(true);
					}
					if(!flagQ4C && !flagQ1 && !flagQ2 && !flagQ3 && !flagQ5)
					{
						buttonQuestion4.setEnabled(true);
					}
					if(!flagQ5C && !flagQ1 && !flagQ2 && !flagQ3 && !flagQ4)
					{
						buttonQuestion5.setEnabled(true);
					}
					if(!flagA1C && !flagA2 && !flagA3 && !flagA4 && !flagA5)
					{
						buttonAnswer1.setEnabled(true);
					}
					if(!flagA2C && !flagA1 && !flagA3 && !flagA4 && !flagA5)
					{
						buttonAnswer2.setEnabled(true);
					}
					if(!flagA3C && !flagA1 && !flagA2 && !flagA4 && !flagA5)
					{
						buttonAnswer3.setEnabled(true);
					}
					if(!flagA4C && !flagA1 && !flagA2 && !flagA3 && !flagA5)
					{
						buttonAnswer4.setEnabled(true);
					}
					if(!flagA5C && !flagA1 && !flagA2 && !flagA3 && !flagA4)
					{
						buttonAnswer5.setEnabled(true);
					}
					buttonReset.setEnabled(true);
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
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
					check.setEnabled(false);
					buttonQuestion1.setEnabled(false);
					buttonQuestion2.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					buttonReset.setEnabled(false);
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
					menuOpened = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					check.setEnabled(true);
					if(!flagQ1C && !flagQ2 && !flagQ3 && !flagQ4 && !flagQ5)
					{
						buttonQuestion1.setEnabled(true);
					}
					if(!flagQ2C && !flagQ1 && !flagQ3 && !flagQ4 && !flagQ5)
					{
						buttonQuestion2.setEnabled(true);
					}
					if(!flagQ3C && !flagQ1 && !flagQ2 && !flagQ4 && !flagQ5)
					{
						buttonQuestion3.setEnabled(true);
					}
					if(!flagQ4C && !flagQ1 && !flagQ2 && !flagQ3 && !flagQ5)
					{
						buttonQuestion4.setEnabled(true);
					}
					if(!flagQ5C && !flagQ1 && !flagQ2 && !flagQ3 && !flagQ4)
					{
						buttonQuestion5.setEnabled(true);
					}
					if(!flagA1C && !flagA2 && !flagA3 && !flagA4 && !flagA5)
					{
						buttonAnswer1.setEnabled(true);
					}
					if(!flagA2C && !flagA1 && !flagA3 && !flagA4 && !flagA5)
					{
						buttonAnswer2.setEnabled(true);
					}
					if(!flagA3C && !flagA1 && !flagA2 && !flagA4 && !flagA5)
					{
						buttonAnswer3.setEnabled(true);
					}
					if(!flagA4C && !flagA1 && !flagA2 && !flagA3 && !flagA5)
					{
						buttonAnswer4.setEnabled(true);
					}
					if(!flagA5C && !flagA1 && !flagA2 && !flagA3 && !flagA4)
					{
						buttonAnswer5.setEnabled(true);
					}
					buttonReset.setEnabled(true);
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
					menuOpened = false;
				}
			}
		});

		buttonQuestion1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagQ1)
				{
					Translation.this.addBorder(buttonQuestion1);
					chooseQuestion.setText(buttonQuestion1.getText());
					buttonQuestion2.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					flagQ1= true;
				}
				else
				{
					Translation.this.removeBorder(buttonQuestion1);
					chooseQuestion.setText("");
					if(!flagQ2C) buttonQuestion2.setEnabled(true);
					if(!flagQ3C) buttonQuestion3.setEnabled(true);
					if(!flagQ4C) buttonQuestion4.setEnabled(true);
					if(!flagQ5C) buttonQuestion5.setEnabled(true);
					flagQ1= false;
				}
			}
		});

		buttonQuestion2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagQ2)
				{
					Translation.this.addBorder(buttonQuestion2);
					chooseQuestion.setText(buttonQuestion2.getText());
					buttonQuestion1.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					flagQ2= true;
				}
				else
				{
					Translation.this.removeBorder(buttonQuestion2);
					chooseQuestion.setText("");
					if(!flagQ1C) buttonQuestion1.setEnabled(true);
					if(!flagQ3C) buttonQuestion3.setEnabled(true);
					if(!flagQ4C) buttonQuestion4.setEnabled(true);
					if(!flagQ5C) buttonQuestion5.setEnabled(true);
					flagQ2= false;
				}
			}
		});

		buttonQuestion3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagQ3)
				{
					Translation.this.addBorder(buttonQuestion3);
					chooseQuestion.setText(buttonQuestion3.getText());
					buttonQuestion1.setEnabled(false);
					buttonQuestion2.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					flagQ3= true;
				}
				else
				{
					Translation.this.removeBorder(buttonQuestion3);
					chooseQuestion.setText("");
					if(!flagQ1C) buttonQuestion1.setEnabled(true);
					if(!flagQ2C) buttonQuestion2.setEnabled(true);
					if(!flagQ4C) buttonQuestion4.setEnabled(true);
					if(!flagQ5C) buttonQuestion5.setEnabled(true);
					flagQ3= false;
				}
			}
		});

		buttonQuestion4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagQ4)
				{
					Translation.this.addBorder(buttonQuestion4);
					chooseQuestion.setText(buttonQuestion4.getText());
					buttonQuestion1.setEnabled(false);
					buttonQuestion2.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion5.setEnabled(false);
					flagQ4= true;
				}
				else
				{
					Translation.this.removeBorder(buttonQuestion4);
					chooseQuestion.setText("");
					if(!flagQ1C) buttonQuestion1.setEnabled(true);
					if(!flagQ2C) buttonQuestion2.setEnabled(true);
					if(!flagQ3C) buttonQuestion3.setEnabled(true);
					if(!flagQ5C) buttonQuestion5.setEnabled(true);
					flagQ4= false;
				}
			}
		});

		buttonQuestion5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagQ5)
				{
					Translation.this.addBorder(buttonQuestion5);
					chooseQuestion.setText(buttonQuestion5.getText());
					buttonQuestion1.setEnabled(false);
					buttonQuestion2.setEnabled(false);
					buttonQuestion3.setEnabled(false);
					buttonQuestion4.setEnabled(false);
					flagQ5= true;
				}
				else
				{
					Translation.this.removeBorder(buttonQuestion5);
					chooseQuestion.setText("");
					if(!flagQ1C) buttonQuestion1.setEnabled(true);
					if(!flagQ2C) buttonQuestion2.setEnabled(true);
					if(!flagQ3C) buttonQuestion3.setEnabled(true);
					if(!flagQ4C) buttonQuestion4.setEnabled(true);
					flagQ5= false;
				}
			}
		});

		buttonAnswer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA1)
				{
					Translation.this.addBorder(buttonAnswer1);
					chooseAnswer.setText(buttonAnswer1.getText());
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					flagA1= true;
				}
				else
				{
					Translation.this.removeBorder(buttonAnswer1);
					chooseAnswer.setText("");
					if(!flagA2C) buttonAnswer2.setEnabled(true);
					if(!flagA3C) buttonAnswer3.setEnabled(true);
					if(!flagA4C) buttonAnswer4.setEnabled(true);
					if(!flagA5C) buttonAnswer5.setEnabled(true);
					flagA1= false;
				}
			}
		});

		buttonAnswer2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA2)
				{
					Translation.this.addBorder(buttonAnswer2);
					chooseAnswer.setText(buttonAnswer2.getText());
					buttonAnswer1.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					flagA2= true;
				}
				else
				{
					Translation.this.removeBorder(buttonAnswer2);
					chooseAnswer.setText("");
					if(!flagA1C) buttonAnswer1.setEnabled(true);
					if(!flagA3C) buttonAnswer3.setEnabled(true);
					if(!flagA4C) buttonAnswer4.setEnabled(true);
					if(!flagA5C) buttonAnswer5.setEnabled(true);
					flagA2= false;
				}
			}
		});

		buttonAnswer3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA3)
				{
					Translation.this.addBorder(buttonAnswer3);
					chooseAnswer.setText(buttonAnswer3.getText());
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					flagA3 = true;
				}
				else
				{
					Translation.this.removeBorder(buttonAnswer3);
					chooseAnswer.setText("");
					if(!flagA1C) buttonAnswer1.setEnabled(true);
					if(!flagA2C) buttonAnswer2.setEnabled(true);
					if(!flagA4C) buttonAnswer4.setEnabled(true);
					if(!flagA5C) buttonAnswer5.setEnabled(true);
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
					Translation.this.addBorder(buttonAnswer4);
					chooseAnswer.setText(buttonAnswer4.getText());
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer5.setEnabled(false);
					flagA4 = true;
				}
				else
				{
					Translation.this.removeBorder(buttonAnswer4);
					chooseAnswer.setText("");
					if(!flagA1C) buttonAnswer1.setEnabled(true);
					if(!flagA2C) buttonAnswer2.setEnabled(true);
					if(!flagA3C) buttonAnswer3.setEnabled(true);
					if(!flagA5C) buttonAnswer5.setEnabled(true);
					flagA4 = false;
				}
			}
		});

		buttonAnswer5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA5)
				{
					Translation.this.addBorder(buttonAnswer5);
					chooseAnswer.setText(buttonAnswer5.getText());
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					flagA5 = true;
				}
				else
				{
					Translation.this.removeBorder(buttonAnswer5);
					chooseAnswer.setText("");
					if(!flagA1C) buttonAnswer1.setEnabled(true);
					if(!flagA2C) buttonAnswer2.setEnabled(true);
					if(!flagA3C) buttonAnswer3.setEnabled(true);
					if(!flagA4C) buttonAnswer4.setEnabled(true);
					flagA5 = false;
				}
			}
		});

		check.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String verifQuestion = chooseQuestion.getText();
				String verifAnswer = chooseAnswer.getText();

				if (verifQuestion.isBlank() || verifAnswer.isBlank())
				{
					JOptionPane.showMessageDialog(App.getApp(),"Sélectionnez une question et une réponse.");
				}
				else
				{	
					if(flagQ1)
					{
						flagQ1C = true;
						flagQ1 = false;
						buttonQuestion1.setEnabled(false);
						Translation.this.removeBorder(buttonQuestion1);
					}
					else
					{
						if(!flagQ1C)
						{
							buttonQuestion1.setEnabled(true);
						}	
					}
					if(flagQ2)
					{
						flagQ2C = true;
						flagQ2 = false;
						buttonQuestion2.setEnabled(false);
						Translation.this.removeBorder(buttonQuestion2);
					}
					else
					{
						if(!flagQ2C)
						{
							buttonQuestion2.setEnabled(true);
						}	
					}
					if(flagQ3)
					{
						flagQ3C = true;
						flagQ3 = false;
						buttonQuestion3.setEnabled(false);
						Translation.this.removeBorder(buttonQuestion3);
					}
					else
					{
						if(!flagQ3C)
						{
							buttonQuestion3.setEnabled(true);
						}	
					}
					if(flagQ4)
					{
						flagQ4C = true;
						flagQ4 = false;
						buttonQuestion4.setEnabled(false);
						Translation.this.removeBorder(buttonQuestion4);
					}
					else
					{
						if(!flagQ4C)
						{
							buttonQuestion4.setEnabled(true);
						}	
					}
					if(flagQ5)
					{
						flagQ5C = true;
						flagQ5 = false;
						buttonQuestion5.setEnabled(false);
						Translation.this.removeBorder(buttonQuestion5);
					}
					else
					{
						if(!flagQ5C)
						{
							buttonQuestion5.setEnabled(true);
						}			
					}

					/*******************************************/

					if(flagA1)
					{
						flagA1C = true;
						flagA1 = false;
						buttonAnswer1.setEnabled(false);
						Translation.this.removeBorder(buttonAnswer1);
					}
					else
					{
						if(!flagA1C)
						{
							buttonAnswer1.setEnabled(true);
						}
					}
					if(flagA2)
					{
						flagA2C = true;
						flagA2 = false;
						buttonAnswer2.setEnabled(false);
						Translation.this.removeBorder(buttonAnswer2);
					}
					else
					{
						if(!flagA2C)
						{
							buttonAnswer2.setEnabled(true);
						}
					}
					if(flagA3)
					{
						flagA3C = true;
						flagA3 = false;
						buttonAnswer3.setEnabled(false);
						Translation.this.removeBorder(buttonAnswer3);
					}
					else
					{
						if(!flagA3C)
						{
							buttonAnswer3.setEnabled(true);
						}
					}
					if(flagA4)
					{
						flagA4C = true;
						flagA4 = false;
						buttonAnswer4.setEnabled(false);
						Translation.this.removeBorder(buttonAnswer4);
					}
					else
					{
						if(!flagA4C)
						{
							buttonAnswer4.setEnabled(true);
						}
					}
					if(flagA5)
					{
						flagA5C = true;
						flagA5 = false;
						buttonAnswer5.setEnabled(false);
						Translation.this.removeBorder(buttonAnswer5);
					}
					else
					{
						if(!flagA5C)
						{
							buttonAnswer5.setEnabled(true);
						}
					}

					/********************************************/

					Translation.this.userAnswers.add(0,new ArrayList<String>());
					Translation.this.userAnswers.get(0).add(verifQuestion);
					Translation.this.userAnswers.get(0).add(verifAnswer);
					Translation.this.clear();
				}	
			}
		});

		buttonReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				buttonQuestion1.setEnabled(true); buttonAnswer1.setEnabled(true);
				buttonQuestion2.setEnabled(true); buttonAnswer2.setEnabled(true);
				buttonQuestion3.setEnabled(true); buttonAnswer3.setEnabled(true);
				buttonQuestion4.setEnabled(true); buttonAnswer4.setEnabled(true);
				buttonQuestion5.setEnabled(true); buttonAnswer5.setEnabled(true);
				flagQ1 = false ; flagA1 = false ;
				flagQ2 = false ; flagA2 = false ;
				flagQ3 = false ; flagA3 = false ;
				flagQ4 = false ; flagA4 = false ;
				flagQ5 = false ; flagA5 = false ;
				flagQ1C = false ; flagA1C = false ;
				flagQ2C = false ; flagA2C = false ;
				flagQ3C = false ; flagA3C = false ;
				flagQ4C = false ; flagA4C = false ;
				flagQ5C = false ; flagA5C = false ;
				Translation.this.userAnswers.clear();
			}
		});

		buttonConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(Translation.this.userAnswers.size() < exercise.getExerciseAnswers().size())
				{
					JOptionPane.showMessageDialog(App.getApp(),"Veuillez répondre à toutes les questions.");
				}
				else
				{
					VerifExercise.verifAnswerTranslation(user, exercise, userAnswers);
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
				JOptionPane.showMessageDialog(App.getApp(), "Associer les mots anglais aux mots français correspondants.\n\n"
						+ "Cliquer sur un mot anglais et sur un mot français puis cliquer sur \"Vérouiller\" pour enregistrer votre association de mots.\n"
						+ "Cliquer sur \"Réinitialiser\" pour recommencer l'exercice de zéro.\n\n"
						+ "Cliquer sur \"Valider\" une fois les cinq ensembles de mots enregistrés.");
			}
		});
	}
	
	/************** Accesseurs **************/
	
	/********** Setters **********/

	public void clear()
	{
		this.chooseQuestion.setText("");
		this.chooseAnswer.setText("");
	}
	
	/************** Méthodes **************/

	public void addBorder(JButton btn)
	{
		btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 55, 78), 2), 
				BorderFactory.createEmptyBorder(
						btn.getBorder().getBorderInsets(btn).top, 
						btn.getBorder().getBorderInsets(btn).left, 
						btn.getBorder().getBorderInsets(btn).bottom, 
						btn.getBorder().getBorderInsets(btn).right)));
	}

	public void removeBorder(JButton btn)
	{
		btn.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						btn.getBorder().getBorderInsets(btn).top, 
						btn.getBorder().getBorderInsets(btn).left, 
						btn.getBorder().getBorderInsets(btn).bottom, 
						btn.getBorder().getBorderInsets(btn).right)));
	}
}