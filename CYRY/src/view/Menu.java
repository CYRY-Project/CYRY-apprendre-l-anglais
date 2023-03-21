package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.VerifUser;

import model.User;

public class Menu extends JPanel
{
	/************** Attributs **************/

	private	static	Menu	menu;

	/************** Constructeurs **************/

	public Menu(User user)
	{
		setVisible(true);
		setBackground(new Color(255, 234, 147));
		setOpaque(true);
		setLayout(null);
		setBounds(0,0,400,App.getWindowHeight());

		// Déclaration et initialisation des éléments de la vue

		JLabel labelPage = new JLabel("Niveau de difficulté", SwingConstants.LEFT);
		JLabel locked1 = new JLabel("Vous n'avez pas le niveau nécessaire pour choisir cette difficulté.", SwingConstants.CENTER);
		JLabel locked2 = new JLabel("Vous n'avez pas le niveau nécessaire pour choisir cette difficulté.", SwingConstants.CENTER);
		JLabel WIP = new JLabel("Cette fonctionnalité n'est pas encore disponible.", SwingConstants.CENTER);
		JButton buttonBeginner = new JButton("Débutant");
		JButton buttonIntermediate = new JButton("Intermédiaire");
		JButton buttonAdvanced = new JButton("Avancé");
		JButton buttonList = new JButton("Liste personnalisée");

		// Positionnement des éléments

		labelPage.setBounds(100, 30, 200, 30);
		buttonBeginner.setBounds(-2, 100, 404, 30);
		locked1.setBounds(10, 170, 380, 30);
		buttonIntermediate.setBounds(-2, 200, 404, 30);
		locked2.setBounds(10, 270, 380, 30);
		buttonAdvanced.setBounds(-2, 300, 404, 30);
		WIP.setBounds(10, 370, 380, 30);
		buttonList.setBounds(-2, 400, 404, 30);

		// Modification des polices

		labelPage.setFont(new Font("Dialog", Font.BOLD, 20));
		locked1.setFont(new Font("Dialog", Font.BOLD, 12));
		locked1.setFont(new Font("Dialog", Font.BOLD, 12));
		locked1.setVisible(false);
		locked2.setFont(new Font("Dialog", Font.BOLD, 12));
		locked2.setFont(new Font("Dialog", Font.BOLD, 12));
		locked2.setVisible(false);
		WIP.setFont(new Font("Dialog", Font.BOLD, 12));
		WIP.setFont(new Font("Dialog", Font.BOLD, 12));
		WIP.setVisible(false);

		// Modification des couleurs des boutons
		// Couleur de fond
		// Couleur de police
		// Couleur de bordure

		buttonBeginner.setBackground(Color.white);
		buttonBeginner.setForeground(new Color(0, 176, 155));
		buttonBeginner.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(0, 176, 155), 2), 
				BorderFactory.createEmptyBorder(
						buttonBeginner.getBorder().getBorderInsets(buttonBeginner).top, 
						buttonBeginner.getBorder().getBorderInsets(buttonBeginner).left, 
						buttonBeginner.getBorder().getBorderInsets(buttonBeginner).bottom, 
						buttonBeginner.getBorder().getBorderInsets(buttonBeginner).right)));
		locked1.setForeground(new Color(235, 57, 78));
		buttonIntermediate.setBackground(Color.white);
		buttonIntermediate.setForeground(new Color(99, 87, 242));
		buttonIntermediate.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(99, 87, 242), 2), 
				BorderFactory.createEmptyBorder(
						buttonIntermediate.getBorder().getBorderInsets(buttonIntermediate).top, 
						buttonIntermediate.getBorder().getBorderInsets(buttonIntermediate).left, 
						buttonIntermediate.getBorder().getBorderInsets(buttonIntermediate).bottom, 
						buttonIntermediate.getBorder().getBorderInsets(buttonIntermediate).right)));
		locked2.setForeground(new Color(235, 57, 78));
		buttonAdvanced.setBackground(Color.white);
		buttonAdvanced.setForeground(new Color(234, 57, 77));
		buttonAdvanced.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(234, 57, 77), 2), 
				BorderFactory.createEmptyBorder(
						buttonAdvanced.getBorder().getBorderInsets(buttonAdvanced).top, 
						buttonAdvanced.getBorder().getBorderInsets(buttonAdvanced).left, 
						buttonAdvanced.getBorder().getBorderInsets(buttonAdvanced).bottom, 
						buttonAdvanced.getBorder().getBorderInsets(buttonAdvanced).right)));
		WIP.setForeground(new Color(235, 57, 78));
		buttonList.setBackground(Color.white);
		buttonList.setForeground(Color.darkGray);
		buttonList.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.darkGray, 2), 
				BorderFactory.createEmptyBorder(
						buttonList.getBorder().getBorderInsets(buttonList).top, 
						buttonList.getBorder().getBorderInsets(buttonList).left, 
						buttonList.getBorder().getBorderInsets(buttonList).bottom, 
						buttonList.getBorder().getBorderInsets(buttonList).right)));

		// Ajout des éléments dans le JPanel

		this.add(labelPage);
		this.add(buttonBeginner);
		this.add(locked1);
		this.add(buttonIntermediate);
		this.add(locked2);
		this.add(buttonAdvanced);
		this.add(WIP);
		this.add(buttonList);
		// Action à l'appuit sur les boutons

		buttonBeginner.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						VerifUser.verifLevelDone(user, 1);

					}
				});
		
		buttonIntermediate.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						VerifUser.verifLevelDone(user, 2);
					}
				});

		buttonAdvanced.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						VerifUser.verifLevelDone(user, 3);
					}
				});

		buttonList.setEnabled(false);

		buttonList.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				WIP.setVisible(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt)
			{
				WIP.setVisible(false);
			}
		});

		if(user.getUserLevel() < 5)
		{
			buttonIntermediate.addMouseListener(new java.awt.event.MouseAdapter()
			{
				public void mouseEntered(java.awt.event.MouseEvent evt)
				{
					locked1.setVisible(true);
				}

				public void mouseExited(java.awt.event.MouseEvent evt)
				{
					locked1.setVisible(false);
				}
			});
			
			buttonAdvanced.addMouseListener(new java.awt.event.MouseAdapter()
			{
				public void mouseEntered(java.awt.event.MouseEvent evt)
				{
					locked2.setVisible(true);
				}

				public void mouseExited(java.awt.event.MouseEvent evt)
				{
					locked2.setVisible(false);
				}
			});
			
			buttonIntermediate.setEnabled(false);
			buttonAdvanced.setEnabled(false);
		}
		else if(user.getUserLevel() < 10)
		{
			buttonAdvanced.addMouseListener(new java.awt.event.MouseAdapter()
			{
				public void mouseEntered(java.awt.event.MouseEvent evt)
				{
					locked2.setVisible(true);
				}

				public void mouseExited(java.awt.event.MouseEvent evt)
				{
					locked2.setVisible(false);
				}
			});
			
			buttonIntermediate.setEnabled(true);
			buttonAdvanced.setEnabled(false);
		}
		else
		{
			buttonIntermediate.setEnabled(true);
			buttonAdvanced.setEnabled(true);
		}
	}
	
	/************** Accesseurs **************/

	/********** Getters **********/

	public static Menu getMenu()
	{
		return menu;
	}

	/********** Setters **********/

	public static void setMenu(Menu newMenu)
	{
		menu = newMenu;
	}
}