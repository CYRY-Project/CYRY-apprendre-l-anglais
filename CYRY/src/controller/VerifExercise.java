package controller;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Exercise;
import model.User;
import view.App;

public class VerifExercise
{
	/************** Méthodes **************/
	
	public static int randomAnswer(ArrayList<Integer> tabAnswers, Exercise exercise)
	{
		int randomAnswer = new Random().nextInt(((exercise.getExerciseAnswers().size() - 1) - 0) + 1) + 0;

		if(tabAnswers.contains(randomAnswer))
		{
			return randomAnswer(tabAnswers, exercise);
		}
		else
		{
			tabAnswers.add(randomAnswer);
			return randomAnswer;
		}
	}

	public static void verifAnswer(User user,Exercise exercise, String answer)
	{
		String goodAnswer = exercise.getExerciseQuestions().get(0).get(2);		
		for(int i = 0 ; i < exercise.getExerciseAnswers().size() ; i++)
		{	
			if(exercise.getExerciseAnswers().get(i).get(0).equals(goodAnswer))
			{
				if(exercise.getExerciseAnswers().get(i).get(1).equals(answer))
				{
					JOptionPane.showMessageDialog(App.getApp(),"Well Done !\n\nExercice réussi !");
					user.setUserPoints(user.getUserPoints() + 500);
					VerifUser.levelCalculation(user);

					String queryUpdateUser = "UPDATE user " 
							+ "SET userLevel = " + user.getUserLevel() + ", userPoints = " + user.getUserPoints() + " "
							+ "WHERE userName = '" + user.getUserName() + "';";

					String queryUpdate = "INSERT INTO exercisedone "
							+ "(idUser, idExercise) "
							+ "VALUES ((SELECT idUser FROM user WHERE userName = '" + user.getUserName() + "'), " + exercise.getIdExercise() + ");";

					JDBC conn = new JDBC();
					conn.updateDB(queryUpdateUser);
					conn.updateDB(queryUpdate);
					conn.closeConnection();

					user.setExerciseDone(exercise.getIdExercise());
					VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"You lost !\n\nExercice raté !\n\nVous pourrez le retenter plus tard !");
					VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
				}
			}
		}
	}

	public static void verifAnswerTranslation(User user, Exercise exercise, ArrayList<ArrayList<String>> userAnswers)
	{
		int goodAnswerNumber = 0;
		for(int i = 0; i < userAnswers.size(); i++)
		{
			String question = userAnswers.get(i).get(0);
			for(int j = 0; j < exercise.getExerciseQuestions().size(); j++)
			{
				if(exercise.getExerciseQuestions().get(j).get(1).equals(question))
				{
					String goodAnswer = exercise.getExerciseQuestions().get(j).get(2);
					for(int k = 0; k < exercise.getExerciseAnswers().size(); k++)
					{
						if(exercise.getExerciseAnswers().get(k).get(0).equals(goodAnswer))
						{
							if(exercise.getExerciseAnswers().get(k).get(1).equals(userAnswers.get(i).get(1)))
							{
								goodAnswerNumber++;
							}
						}
					}
				}
			}
		}
		if(goodAnswerNumber == userAnswers.size())
		{
			JOptionPane.showMessageDialog(App.getApp(),"Good job !\n\nExercice réussi !");
			user.setUserPoints(user.getUserPoints() + 500);
			VerifUser.levelCalculation(user);

			String queryUpdateUser = "UPDATE user " 
					+ "SET userLevel = " + user.getUserLevel() + ", userPoints = " + user.getUserPoints() + " "
					+ "WHERE userName = '" + user.getUserName() + "';";

			String queryUpdateExerciseDone = "INSERT INTO exercisedone " 
					+ "(idUser, idExercise) "
					+ "VALUES ((SELECT idUser FROM user WHERE userName = '" + user.getUserName() + "'), " + exercise.getIdExercise() + ");";

			JDBC conn = new JDBC();
			conn.updateDB(queryUpdateUser);
			conn.updateDB(queryUpdateExerciseDone);
			conn.closeConnection();

			user.setExerciseDone(exercise.getIdExercise());
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
		else
		{
			JOptionPane.showMessageDialog(App.getApp(),"Too bad !\n\nExercice raté !\n\nVous pourrez le retenter plus tard !");
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
	}

	public static void verifAnswerSentence(User user, Exercise exercise, String goodAnswer, String[] userAnswer)
	{
		if(String.join(" ", userAnswer).equals(goodAnswer))
		{
			JOptionPane.showMessageDialog(App.getApp(),"Nice job !\n\nExercice réussi !");
			user.setUserPoints(user.getUserPoints() + 500);
			VerifUser.levelCalculation(user);

			String queryUpdateUser = "UPDATE user " 
					+ "SET userLevel = " + user.getUserLevel() + ", userPoints = " + user.getUserPoints() + " "
					+ "WHERE userName = '" + user.getUserName() + "';";

			String queryUpdateExerciseDone = "INSERT INTO exercisedone " 
					+ "(idUser, idExercise) "
					+ "VALUES ((SELECT idUser FROM user WHERE userName = '" + user.getUserName() + "'), " + exercise.getIdExercise() + ");";

			JDBC conn = new JDBC();
			conn.updateDB(queryUpdateUser);
			conn.updateDB(queryUpdateExerciseDone);
			conn.closeConnection();

			user.setExerciseDone(exercise.getIdExercise());
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
		else
		{
			JOptionPane.showMessageDialog(App.getApp(),"It's Lost !\n\nExercice raté !\n\nVous pourrez le retenter plus tard !");
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
	}

	public static void verifGapFillText(User user, Exercise exercise,ArrayList<ArrayList<JLabel>> labelQuestion,ArrayList<ArrayList<String>> answerTab)
	{
		// Je construis a partir de la Bdd les string qui correspondent aux bonnes réponse et les place dans un ArrayList

		ArrayList<String> goodAnswer = new ArrayList<String>();
		for(int i = 0 ; i < exercise.getExerciseQuestions().size(); i++)
		{
			for(int j = 0 ; j < exercise.getExerciseAnswers().size(); j++)
			{	
				if(exercise.getExerciseQuestions().get(i).get(2).equals(exercise.getExerciseAnswers().get(j).get(0)))
				{
					goodAnswer.add(exercise.getExerciseQuestions().get(i).get(1).replace("//", exercise.getExerciseAnswers().get(j).get(1)));
				}
			}	
		}

		// Je construis les string de réponse de l'utilisateur et les place dans un ArrayList

		ArrayList<String> userAnswer = new ArrayList<String>();
		for(int i = 0 ; i < labelQuestion.size(); i++)
		{
			for(int j = 0 ; j < labelQuestion.get(i).size()-1 ; j++)
			{
				for(int k = 0 ; k < answerTab.size(); k++)
				{
					userAnswer.add(labelQuestion.get(i).get(j).getText() + answerTab.get(k).get(0) + labelQuestion.get(i).get(j+1).getText());
				}
			}
		}

		// ici je compare mes 2 arraylist créées coté bdd et utilisateur, et j'incremente le compteur dès qu'une string est correcte
		// si le nombre de bonne réponse est égal au nombre de bonne réponse coté Bdd alors l'exercice est validé
		int goodAnswerUser = 0;
		for(int i = 0 ; i < userAnswer.size() ; i++)
		{
			for(int j = 0 ; j < goodAnswer.size() ; j++)
			{
				if(userAnswer.get(i).contains(goodAnswer.get(j)))
				{
					goodAnswerUser++;
				}
			}
		}
		if(goodAnswerUser == goodAnswer.size())
		{
			JOptionPane.showMessageDialog(App.getApp(),"Nice job !\n\nExercice réussi !");
			user.setUserPoints(user.getUserPoints() + 500);
			VerifUser.levelCalculation(user);

			String queryUpdateUser = "UPDATE user " 
					+ "SET userLevel = " + user.getUserLevel() + ", userPoints = " + user.getUserPoints() + " "
					+ "WHERE userName = '" + user.getUserName() + "';";

			String queryUpdateExerciseDone = "INSERT INTO exercisedone " 
					+ "(idUser, idExercise) "
					+ "VALUES ((SELECT idUser FROM user WHERE userName = '" + user.getUserName() + "'), " + exercise.getIdExercise() + ");";

			JDBC conn = new JDBC();
			conn.updateDB(queryUpdateUser);
			conn.updateDB(queryUpdateExerciseDone);
			conn.closeConnection();

			user.setExerciseDone(exercise.getIdExercise());
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
		else
		{
			JOptionPane.showMessageDialog(App.getApp(),"It's Lost !\n\nExercice raté !\n\nVous pourrez le retenter plus tard !");
			VerifUser.verifLevelDone(user, exercise.getExerciseDifficulty());
		}
	}
}