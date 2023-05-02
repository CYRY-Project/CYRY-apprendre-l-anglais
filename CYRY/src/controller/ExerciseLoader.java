package controller;

import javax.swing.JLayeredPane;

import model.Exercise;
import model.User;
import view.App;
import view.GapFillText;
import view.MCQ;
import view.SentenceConstruction;
import view.Situation;
import view.Translation;

/**
 * Choisir la vue d'un exercice en fonction de son type.
 *
 * @author Yoann Jeauneau
 */
public class ExerciseLoader
{
	/************** Méthodes **************/

	/**
	 * Une fois les panneaux vides, ajoute la vue souhaitée au panneau en fonction du type de l'exercice.
	 * 
	 * @param user L'instance de User
	 * @param exercise L'instance de Exercise
	 */
	public static void typeSelect(User user, Exercise exercise)
	{
		switch (exercise.getExerciseType())
		{
		case 1:
			SwapPage.clearLayer();
			App.getApp().getLayeredPane().add(new MCQ(user, exercise), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;

		case 2:
			SwapPage.clearLayer();
			App.getApp().getLayeredPane().add(new Situation(user, exercise), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;

		case 3:
			SwapPage.clearLayer();
			App.getApp().getLayeredPane().add(new GapFillText(user, exercise), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;

		case 4:
			SwapPage.clearLayer();
			App.getApp().getLayeredPane().add(new Translation(user, exercise), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;

		case 5:
			SwapPage.clearLayer();
			App.getApp().getLayeredPane().add(new SentenceConstruction(user, exercise), JLayeredPane.DEFAULT_LAYER);
			App.getApp().getContentPane().repaint(); 
			App.getApp().getContentPane().revalidate();
			break;
		}
	}
}