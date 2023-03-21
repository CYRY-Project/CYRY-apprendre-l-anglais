package view;

import controller.SwapPage;
import controller.VerifExercise;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Exercise;
import model.User;

public class GapFillText extends JPanel
{
	/************** Attributs **************/

	private static 		int										xMiddle = (int) (App.getWindowWidth() / 2);
	private	static 		String									imageStr = "src/image/gapfill.png";

	private				boolean									menuOpened = false;
	private				boolean									accountOpened = false;

	private				ArrayList<ArrayList<String>>			strQuestion;
	private				ArrayList<ArrayList<JLabel>>			labelQuestion;
	private				ArrayList<ArrayList<JComboBox<String>>>	comboBoxList = new ArrayList<ArrayList<JComboBox<String>>>();
	private				ArrayList<ArrayList<String>>			answerTab = new ArrayList<ArrayList<String>>();
	private				ArrayList<Integer>						tabRandAnswer= new ArrayList<Integer>();

	/************** Constructeurs **************/

	public GapFillText(User user, Exercise exercise)
	{
		setSize(App.getWindowWidth(),App.getWindowHeight());
		setLayout(null);

		// appel de la méthode

		this.gapCreation(exercise);

		// Déclaration et initialisation des éléments de la vue

		// partie user

		ImageIcon avatarStr = new ImageIcon(user.getUserAvatar());
		JButton avatar = new JButton(avatarStr);
		JLabel name = new JLabel(user.getUserName());
		JLabel level = new JLabel("Level : " + String.valueOf(user.getUserLevel()));
		JLabel points = new JLabel("Score : " + String.valueOf(user.getUserPoints()));
		JButton menu = new JButton("Menu");

		// partie exercice

		JLabel title = new JLabel (exercise.getExerciseTitle(), SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(imageStr);
		JLabel gapFillImage = new JLabel(imageIcon);
		JButton buttonConfirm = new JButton ("Valider");
		JButton buttonQuit = new JButton ("Quitter");
		JButton buttonRules = new JButton("Règles");

		// Positionnement des éléments	

		// partie user

		avatar.setBounds(30, 30, 60, 60);
		name.setBounds(100, 30, 180, 20);
		level.setBounds(100, 50, 80, 20);
		points.setBounds(100, 70, 100, 20);
		menu.setBounds(App.getWindowWidth() - 110, 30, 80, 30);

		// partie exercice

		
		gapFillImage.setBounds(xMiddle - 300, 40, 600, 250);
		title.setBounds(0, 300, App.getWindowWidth(), 30);
		this.gapPosition(exercise);
		buttonConfirm.setBounds(xMiddle + 20, 640, 80, 30);
		buttonQuit.setBounds(App.getWindowWidth() - 110, 640, 80, 30);
		buttonRules.setBounds(30, 640, 80, 30);

		// Modification des polices

		// partie user

		name.setFont(new Font("Dialog",Font.BOLD,16));
		level.setFont(new Font("Dialog",Font.BOLD,14));
		points.setFont(new Font("Dialog",Font.BOLD,14));

		// partie exercise

		title.setFont(new Font("Dialog",Font.BOLD,20));


		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure

		level.setForeground(new Color(183, 44, 51));
		points.setForeground(new Color(183, 44, 51));

		buttonRules.setBackground(new Color(255, 163, 50));
		buttonRules.setForeground(Color.white);
		buttonRules.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(255, 163, 50), 2), 
				BorderFactory.createEmptyBorder(
						buttonRules.getBorder().getBorderInsets(buttonRules).top, 
						buttonRules.getBorder().getBorderInsets(buttonRules).left, 
						buttonRules.getBorder().getBorderInsets(buttonRules).bottom, 
						buttonRules.getBorder().getBorderInsets(buttonRules).right)));
		buttonConfirm.setBackground(new Color(0, 176, 155));
		buttonConfirm.setForeground(Color.white);
		buttonConfirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).top, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).left, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).bottom, 
						buttonConfirm.getBorder().getBorderInsets(buttonConfirm).right)));
		buttonQuit.setBackground(new Color(235, 57, 78));
		buttonQuit.setForeground(Color.white);
		buttonQuit.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(235, 57, 78), 2), 
				BorderFactory.createEmptyBorder(
						buttonQuit.getBorder().getBorderInsets(buttonQuit).top, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).left, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).bottom, 
						buttonQuit.getBorder().getBorderInsets(buttonQuit).right)));

		// Retrait du fond du JPanel et de la CheckBox

		avatar.setOpaque(false);
		avatar.setContentAreaFilled(false);
		avatar.setBorderPainted(false);

		setOpaque(false);

		// Ajout des élements

		// partie user 

		this.add(avatar);
		this.add(name);
		this.add(level);
		this.add(points);
		this.add(menu);

		// partie exercice

		this.add(title);
		this.add(gapFillImage);
		this.add(buttonConfirm);
		this.add(buttonQuit);
		this.add(buttonRules);

		//************** Gestion des cliques*******************

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
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
					for(int i = 0 ; i < comboBoxList.size(); i++)
					{
						for(int j = 0 ;  j < comboBoxList.get(i).size() ; j++)
						{
							comboBoxList.get(i).get(j).setEnabled(false);
						}
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
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
					for(int i = 0 ; i < comboBoxList.size(); i++)
					{
						for(int j = 0 ;  j < comboBoxList.get(i).size() ; j++)
						{
							comboBoxList.get(i).get(j).setEnabled(true);
						}
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
					buttonConfirm.setEnabled(false);
					buttonQuit.setEnabled(false);
					buttonRules.setEnabled(false);
					for(int i = 0 ; i < comboBoxList.size(); i++)
					{
						for(int j = 0 ;  j < comboBoxList.get(i).size() ; j++)
						{
							comboBoxList.get(i).get(j).setEnabled(false);
						}
					}
					menuOpened = true ;
				}
				else
				{
					App.getApp().getLayeredPane().remove(Menu.getMenu());
					App.getApp().getLayeredPane().repaint(); 
					App.getApp().getLayeredPane().revalidate();
					avatar.setEnabled(true);
					buttonConfirm.setEnabled(true);
					buttonQuit.setEnabled(true);
					buttonRules.setEnabled(true);
					for(int i = 0 ; i < comboBoxList.size(); i++)
					{
						for(int j = 0 ;  j < comboBoxList.get(i).size() ; j++)
						{
							comboBoxList.get(i).get(j).setEnabled(true);
						}
					}
					menuOpened = false;
				}
			}
		});

		buttonConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0 ; i < comboBoxList.size(); i++)
				{
					answerTab.add(new ArrayList<String>());
					for(int j = 0 ; j < comboBoxList.get(i).size(); j++)
					{
						answerTab.get(i).add(comboBoxList.get(i).get(j).getSelectedItem().toString());
					}
				}
				VerifExercise.verifGapFillText(user, exercise, labelQuestion, answerTab);
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
				JOptionPane.showMessageDialog(App.getApp(), "Choisir les bons mots pour que les phrases soient correctes.\n\n"
						+ "Cliquer sur un menu déroulant pour sélectionner le mot correspondant à la phrase.\n\n"
						+ "Cliquer sur \"Valider\" une fois que tous les mots choisis sont sélectionnés.");
			}
		});
	}

	/************** Méthodes **************/

	private void gapCreation(Exercise exercise)
	{

		// découpes mes chaines de caractère récuperer en BDD pour ensuite les places dans mon arraylist

		this.strQuestion = new ArrayList<ArrayList<String>>();
		for(int i = 0 ; i < exercise.getExerciseQuestions().size() ; i++ )
		{
			String[] recupStr = exercise.getExerciseQuestions().get(i).get(1).split("//");
			this.strQuestion.add(new ArrayList<String>());
			for(int j = 0 ; j < recupStr.length ; j++)
			{
				this.strQuestion.get(i).add(recupStr[j]);
			}	
		}

		// ici je crée mes label contenant mes String et les place dans un Arraylist

		this.labelQuestion = new ArrayList<ArrayList<JLabel>>();
		for(int d = 0 ; d < this.strQuestion.size() ; d ++)
		{
			this.labelQuestion.add(new ArrayList<JLabel>());

			for(int k = 0 ; k < this.strQuestion.get(d).size() ; k++)
			{
				this.labelQuestion.get(d).add( new JLabel(this.strQuestion.get(d).get(k)));
				this.labelQuestion.get(d).get(k).setFont(new Font("Dialog",Font.BOLD,16));
			}
		}
		
		for(int i = 0 ; i < this.labelQuestion.size() ; i++)
		{
			this.comboBoxList.add(new ArrayList<JComboBox<String>>());
			for(int k = 0 ;  k < this.labelQuestion.get(i).size()-1 ; k++)
			{
				this.comboBoxList.get(i).add(new JComboBox<String>());
				for(int j = 0 ; j < exercise.getExerciseAnswers().size() ; j++)
				{
					this.comboBoxList.get(i).get(k).addItem(exercise.getExerciseAnswers().get(VerifExercise.randomAnswer(tabRandAnswer, exercise)).get(1));
					this.comboBoxList.get(i).get(k).setFont(new Font("Dialog",Font.BOLD,14));
				}
				tabRandAnswer.clear();
			}
		}
	}

	public void gapPosition(Exercise exercise)
	{
		int x1 = 300;
		int x2 =500;
		int y1 = 350;

		for( int i = 0 ; i < labelQuestion.size() ; i++)
		{
			for(int j = 0 ; j < labelQuestion.get(i).size() ; j++)
			{
				labelQuestion.get(i).get(j).setBounds(x1, y1, 300, 30);
				GapFillText.this.add(labelQuestion.get(i).get(j));
				for(int k =0 ; k < comboBoxList.get(i).size() ; k++)
				{
					comboBoxList.get(i).get(k).setBounds(x2, y1 + 5, 100, 20);
					GapFillText.this.add(comboBoxList.get(i).get(k));
				}
				x1 = x1 + 300;
			}
			x1=300;
			y1 = y1 + 60;
		}
		y1=300;
	}
}