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

public class MCQ extends JPanel
{
	/************** Attributs **************/

	private static	int					xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean				menuOpened = false;
	private			boolean				accountOpened = false;

	private			boolean				flagA1 = false;
	private			boolean				flagA2 = false;
	private			boolean				flagA3 = false;
	private			boolean				flagA4 = false;

	private			ArrayList<Integer>	answerPicked = new ArrayList<Integer>();
	private			String				answer = "";

	/************** Constructeurs **************/

	public MCQ(User user,Exercise exercise)
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

		ImageIcon imageExercice  = new ImageIcon("src/image/exercise/"+exercise.getExerciseImage());
		JLabel	image = new JLabel(imageExercice);
		JLabel labelQuestion = new JLabel (exercise.getExerciseQuestions().get(0).get(1),SwingConstants.CENTER);
		JButton buttonAnswer1 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		JButton buttonAnswer2 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		JButton buttonAnswer3 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		JButton buttonAnswer4 = new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(this.answerPicked, exercise)).get(1));
		JButton buttonConfirm = new JButton ("Valider");
		JButton buttonQuit = new JButton ("Quitter");
		JButton buttonRules = new JButton("Règles");

		// Positionnement des éléments	

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		image.setBounds(xMiddle - 250, 0, 500, 400);
		labelQuestion.setBounds(0, 420, App.getWindowWidth(), 40);
		buttonAnswer1.setBounds(xMiddle - 360, 480, 350, 60);
		buttonAnswer2.setBounds(xMiddle + 10, 480, 350, 60);
		buttonAnswer3.setBounds(xMiddle - 360, 560, 350, 60);
		buttonAnswer4.setBounds(xMiddle + 10, 560, 350, 60);
		buttonConfirm.setBounds(xMiddle - 40, 640, 80, 30);
		buttonQuit.setBounds(App.getWindowWidth() - 110, 640, 80, 30);
		buttonRules.setBounds(30, 640, 80, 30);

		// Modification des polices

		name.setFont(	new Font("Dialog",Font.BOLD,16));
		level.setFont(	new Font("Dialog",Font.BOLD,14));
		points.setFont(	new Font("Dialog",Font.BOLD,14));

		labelQuestion.setFont(new Font("Dialog", Font.BOLD, 25));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		buttonAnswer1.setBackground(Color.white);
		buttonAnswer1.setForeground(new Color(235, 57, 78));
		buttonAnswer1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).top, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).left, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).bottom, 
						buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).right)));
		buttonAnswer2.setBackground(Color.white);
		buttonAnswer2.setForeground(new Color(235, 57, 78));
		buttonAnswer2.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).top, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).left, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).bottom, 
						buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).right)));
		buttonAnswer3.setBackground(Color.white);
		buttonAnswer3.setForeground(new Color(235, 57, 78));
		buttonAnswer3.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255,255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).top, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).left, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).bottom, 
						buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).right)));
		buttonAnswer4.setBackground(Color.white);
		buttonAnswer4.setForeground(new Color(235, 57, 78));
		buttonAnswer4.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
				BorderFactory.createEmptyBorder(
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).top, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).left, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).bottom, 
						buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).right)));
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

		this.add(image);
		this.add(labelQuestion);
		this.add(buttonAnswer1);
		this.add(buttonAnswer2);
		this.add(buttonAnswer3);
		this.add(buttonAnswer4);
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
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
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
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
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
					menuOpened = false;
				}
			}
		});

		buttonAnswer1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA1)
				{
					buttonAnswer1.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(235, 55, 78), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).top, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).left, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).bottom, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).right)));
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					answer = buttonAnswer1.getText();
					flagA1 = true;
				}
				else
				{
					buttonAnswer1.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).top, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).left, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).bottom, 
									buttonAnswer1.getBorder().getBorderInsets(buttonAnswer1).right)));
					buttonAnswer2.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					answer = "";
					flagA1 = false;
				}
			}
		});

		buttonAnswer2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				if(!flagA2)
				{
					buttonAnswer2.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(235, 55, 78), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).top, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).left, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).bottom, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).right)));
					buttonAnswer1.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					answer = buttonAnswer2.getText();
					flagA2 = true ;
				}
				else
				{
					buttonAnswer2.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).top, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).left, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).bottom, 
									buttonAnswer2.getBorder().getBorderInsets(buttonAnswer2).right)));
					buttonAnswer1.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					answer = "";
					flagA2 = false ;
				}				
			}	
		});

		buttonAnswer3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				if(!flagA3)
				{
					buttonAnswer3.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(235, 55, 78), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).top, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).left, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).bottom, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).right)));
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer4.setEnabled(false);
					answer = buttonAnswer3.getText();
					flagA3 = true;
				}
				else
				{
					buttonAnswer3.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).top, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).left, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).bottom, 
									buttonAnswer3.getBorder().getBorderInsets(buttonAnswer3).right)));
					buttonAnswer1.setEnabled(true);
					buttonAnswer2.setEnabled(true);
					buttonAnswer4.setEnabled(true);
					answer = "";
					flagA3 = false;
				}
			}
		});

		buttonAnswer4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!flagA4)
				{
					buttonAnswer4.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(235, 55, 78), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).top, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).left, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).bottom, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).right)));
					buttonAnswer1.setEnabled(false);
					buttonAnswer2.setEnabled(false);
					buttonAnswer3.setEnabled(false);
					answer = buttonAnswer4.getText();
					flagA4 = true;
				}
				else
				{
					buttonAnswer4.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createLineBorder(new Color(255, 255, 255), 2), 
							BorderFactory.createEmptyBorder(
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).top, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).left, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).bottom, 
									buttonAnswer4.getBorder().getBorderInsets(buttonAnswer4).right)));
					buttonAnswer1.setEnabled(true);
					buttonAnswer2.setEnabled(true);
					buttonAnswer3.setEnabled(true);
					answer = "";
					flagA4= false;
				}
			}
		});

		buttonConfirm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!answer.isBlank())
				{
					VerifExercise.verifAnswer(user, exercise, answer);
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
}