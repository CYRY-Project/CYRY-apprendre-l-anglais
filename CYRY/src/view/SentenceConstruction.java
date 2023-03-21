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

public class SentenceConstruction extends JPanel 
{
	/************** Attributs **************/
	
	private	static	int								xMiddle = (int) (App.getWindowWidth() / 2);

	private			boolean							menuOpened = false;
	private			boolean							accountOpened = false;

	private			ArrayList<JLabel>				labelAnswers = new ArrayList<JLabel>();
	private			ArrayList<JButton>				buttonAnswers = new ArrayList<JButton>();

	private			ArrayList<ArrayList<String>>	newAnswers = new ArrayList<ArrayList<String>>();
	private			ArrayList<Integer>				answersDisplayed = new ArrayList<Integer>();
	private			String							goodAnswer;
	private			String[]						answers;
	private			String[]						userAnswer;

	private boolean flagAnswer = false;

	/************** Constructeurs **************/
	
	public SentenceConstruction(User user, Exercise exercise)
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		transformAnswers(exercise);
		userAnswer = new String[exercise.getExerciseAnswers().size()];
		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			labelAnswers.add(i, new JLabel("", SwingConstants.CENTER));
			buttonAnswers.add(i, new JButton(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(answersDisplayed, exercise)).get(0)));
		}

		// Déclaration et initialisation des éléments de la vue

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JButton avatar = new JButton(avatarStr);
		JLabel name = new JLabel(user.getUserName());
		JLabel level = new JLabel("Level : " + String.valueOf(user.getUserLevel()));
		JLabel points = new JLabel("Score : " + String.valueOf(user.getUserPoints()));
		JButton menu = new JButton("Menu");

		JLabel question = new JLabel(exercise.getExerciseQuestions().get(0).get(1), SwingConstants.CENTER);
		JButton reset = new JButton("Recommencer");
		JButton cancel = new JButton("Corriger");
		JButton confirm = new JButton("Valider");
		JButton quit = new JButton ("Quitter");
		JButton buttonRules = new JButton("Règles");

		// Positionnement des éléments

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		question.setBounds(xMiddle - 450, 150, 900, 30);
		int j = 0;
		int k = 0;
		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			labelAnswers.get(i).setBounds(xMiddle - 545 + j, 350, 100, 30);
			buttonAnswers.get(i).setBounds(xMiddle - 590 + k, 500, 100, 30);
			j += 110;
			k += 120;
		}
		cancel.setBounds(xMiddle - 245, 640, 150, 30);
		reset.setBounds(xMiddle - 75, 640, 150, 30);
		confirm.setBounds(xMiddle + 95, 640, 150, 30);
		quit.setBounds(App.getWindowWidth() - 110, 640, 80, 30);
		buttonRules.setBounds(30, 640, 80, 30);

		// Modification des polices

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		question.setFont(new Font("Dialog", Font.BOLD, 25));

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure	

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			labelAnswers.get(i).setBackground(Color.white);
			labelAnswers.get(i).setForeground(new Color(103, 91, 243));
			labelAnswers.get(i).setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		}
		cancel.setBackground(Color.white);
		cancel.setForeground(new Color(235, 57, 78));
		cancel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.white), 
				BorderFactory.createEmptyBorder(
						cancel.getBorder().getBorderInsets(cancel).top, 
						cancel.getBorder().getBorderInsets(cancel).left, 
						cancel.getBorder().getBorderInsets(cancel).bottom, 
						cancel.getBorder().getBorderInsets(cancel).right)));
		reset.setBackground(new Color(235, 57, 78));
		reset.setForeground(Color.white);
		reset.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						reset.getBorder().getBorderInsets(reset).top, 
						reset.getBorder().getBorderInsets(reset).left, 
						reset.getBorder().getBorderInsets(reset).bottom, 
						reset.getBorder().getBorderInsets(reset).right)));
		confirm.setBackground(new Color(0, 176, 155));
		confirm.setForeground(Color.white);
		confirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						confirm.getBorder().getBorderInsets(confirm).top, 
						confirm.getBorder().getBorderInsets(confirm).left, 
						confirm.getBorder().getBorderInsets(confirm).bottom, 
						confirm.getBorder().getBorderInsets(confirm).right)));
		quit.setBackground(Color.white);
		quit.setForeground(new Color(235, 57, 78));
		quit.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						quit.getBorder().getBorderInsets(quit).top, 
						quit.getBorder().getBorderInsets(quit).left, 
						quit.getBorder().getBorderInsets(quit).bottom, 
						quit.getBorder().getBorderInsets(quit).right)));
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

		this.add(question);
		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			this.add(labelAnswers.get(i));
			this.add(buttonAnswers.get(i));
		}
		this.add(cancel);
		this.add(reset);
		this.add(confirm);
		this.add(quit);
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
					cancel.setEnabled(false);
					reset.setEnabled(false);
					confirm.setEnabled(false);
					quit.setEnabled(false);
					buttonRules.setEnabled(false);
					for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
					{
						buttonAnswers.get(i).setEnabled(false);
					}
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
					cancel.setEnabled(true);
					reset.setEnabled(true);
					confirm.setEnabled(true);
					quit.setEnabled(true);
					buttonRules.setEnabled(true);
					for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
					{
						for(int j = 0; j < exercise.getExerciseAnswers().size(); j++)
						{
							if(labelAnswers.get(j).getText()==buttonAnswers.get(i).getText())
							{
								flagAnswer = true;
							}
						}
						if(!flagAnswer)
						{
							buttonAnswers.get(i).setEnabled(true);
						}
						flagAnswer = false;
					}
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
					cancel.setEnabled(false);
					reset.setEnabled(false);
					confirm.setEnabled(false);
					quit.setEnabled(false);
					buttonRules.setEnabled(false);
					for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
					{
						buttonAnswers.get(i).setEnabled(false);
					}
					menuOpened = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					cancel.setEnabled(true);
					reset.setEnabled(true);
					confirm.setEnabled(true);
					quit.setEnabled(true);
					buttonRules.setEnabled(true);
					for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
					{
						for(int j = 0; j < exercise.getExerciseAnswers().size(); j++)
						{
							if(labelAnswers.get(j).getText()==buttonAnswers.get(i).getText())
							{
								flagAnswer = true;
							}
						}
						if(!flagAnswer)
						{
							buttonAnswers.get(i).setEnabled(true);
						}
						flagAnswer = false;
					}
					menuOpened = false;
				}
			}
		});

		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			addActionButton(exercise, i);
		}

		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clearLastAnswerField(exercise);
			}
		});

		reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clearAllAnswerField(exercise);
			}
		});

		confirm.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!(labelAnswers.get(exercise.getExerciseAnswers().size() - 1)).getText().isBlank())
				{
					for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
					{
						userAnswer[i]=labelAnswers.get(i).getText();
					}
					VerifExercise.verifAnswerSentence(user, exercise, goodAnswer, userAnswer);
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"Veuillez ajouter tous les mots.");
				}
			}
		});

		quit.addActionListener(new ActionListener() 
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
				JOptionPane.showMessageDialog(App.getApp(), "Créer, à partir des mots présents, une phrase gramaticalement correcte.\n\n"
						+ "Cliquer sur un mot pour l'ajouter à la phrase.\n"
						+ "Cliquer sur \"Corriger\" pour retirer le dernier mot ajouté à la phrase.\n"
						+ "Cliquer sur \"Recommencer\" pour réinitialiser l'exercice à zéro.\n\n"
						+ "Cliquer sur \"Valider\" une fois la phrase terminée.");
			}
		});
	}
	
	/************** Méthodes **************/

	public void addActionButton(Exercise exercise, int i)
	{
		buttonAnswers.get(i).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fillAnswerField(exercise, buttonAnswers.get(i));
				buttonAnswers.get(i).setEnabled(false);
			}
		});
	}

	public void fillAnswerField(Exercise exercise, JButton button)
	{
		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			if(labelAnswers.get(i).getText().isBlank())
			{
				labelAnswers.get(i).setText(button.getText());
				return;
			}
		}
	}

	public void clearLastAnswerField(Exercise exercise)
	{
		for(int i = exercise.getExerciseAnswers().size(); i > 0; i--)
		{
			if(!labelAnswers.get(i-1).getText().isBlank())
			{
				for(int j = 0; j < exercise.getExerciseAnswers().size(); j++)
				{
					if(buttonAnswers.get(j).getText()==labelAnswers.get(i-1).getText())
					{
						buttonAnswers.get(j).setEnabled(true);
					}
				}
				labelAnswers.get(i-1).setText("");
				return;
			}
		}
	}

	public void clearAllAnswerField(Exercise exercise)
	{
		for(int i = 0; i < exercise.getExerciseAnswers().size(); i++)
		{
			labelAnswers.get(i).setText("");
			buttonAnswers.get(i).setEnabled(true);
		}
	}

	public void transformAnswers(Exercise exercise)
	{
		goodAnswer = exercise.getExerciseAnswers().get(0).get(1);
		answers = exercise.getExerciseAnswers().get(0).get(1).split(" ");
		for(int i = 0; i < answers.length; i++)
		{
			newAnswers.add(i, new ArrayList<String>());
			newAnswers.get(i).add(0, answers[i]);
		}
		exercise.setExerciseAnswers(newAnswers);
	}
}