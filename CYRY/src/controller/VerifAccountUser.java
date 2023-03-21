package controller;

import java.awt.HeadlessException;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.User;

import view.AccountUser;
import view.App;

public class VerifAccountUser
{
	/************** Méthodes **************/
	
	public static void deleteUser(User user)
	{
		JDBC conn = new JDBC();
		conn.deleteUserDB(user.getUserName());
		conn.closeConnection();
		JOptionPane.showMessageDialog(App.getApp(),user.getUserName()+" supprimé avec succès");
		System.gc();
		SwapPage.swapPage("MainPage");
	}

	public static void updateUserName(AccountUser acc,User user,String name) 
	{
		/***** Partie Test *********/
		if(name.isBlank()) 
		{
			JOptionPane.showMessageDialog(App.getApp()," Le(s) champ(s) sont vides");
			return;
		}

		/****** Requete utilisé lors du select pour le test du pseudo déja utilisé *****/
		String querySelect = "SELECT userName "
				+"FROM user "
				+ "WHERE userName = '" + name + "';";

		/***** Instanciation de l'objet JDBC******/
		JDBC conn = new JDBC();
		ResultSet verif = conn.select(querySelect);

		/***** Partie Update ********/
		try
		{
			if(!verif.next())
			{
				String query = "UPDATE user "
						+ "SET userName = '" + name + "' "
						+ "WHERE userName = '" + user.getUserName() + "';";
				user.setUserName(name);
				conn.updateDB(query);
				JOptionPane.showMessageDialog(App.getApp(),"Compte modifiée") ;
				conn.closeConnection();
				SwapPage.swapPage("Home", user);
			}
			else
			{
				JOptionPane.showMessageDialog(App.getApp(),"Identifiant déja utilisé") ;
			}
		}
		catch(HeadlessException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
	}

	public static int returnNumberExercise(int type) 
	{
		int exerciseNumber = 0;
		String query = "SELECT COUNT(exercise.idExercise) "
				+ "FROM exercise "
				+ "JOIN type "
				+ "USING (idType) "
				+ "WHERE idType = " + type + ";";

		JDBC conn = new JDBC();
		ResultSet recupData = conn.select(query);

		try
		{
			while(recupData.next())
			{
				exerciseNumber = recupData.getInt("COUNT(exercise.idExercise)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
		return exerciseNumber;
	}

	public static int returnNumberExerciseDone(User user, int type) 
	{
		int exerciseDoneNumber = 0;
		String query = "SELECT COUNT(exercisedone.idExercise) "
				+ "FROM exercisedone "
				+ "JOIN user "
				+ "USING (idUser) "
				+ "JOIN exercise "
				+ "USING (idExercise) "
				+ "WHERE exercise.idType = "+ type + " AND user.userName = '" + user.getUserName() + "';";

		JDBC conn = new JDBC();
		ResultSet recupData = conn.select(query);

		try
		{
			if(recupData.next())
			{
				exerciseDoneNumber = recupData.getInt("COUNT(exercisedone.idExercise)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
		return exerciseDoneNumber;
	}

	public static int returnDifficultyExercise(int difficulty) 
	{
		int exerciseNumber = 0;
		String query = "SELECT COUNT(exercise.idExercise) "
				+ "FROM exercise "
				+ "JOIN difficulty "
				+ "USING (idDifficulty) "
				+ "WHERE idDifficulty = " + difficulty + ";";

		JDBC conn = new JDBC();
		ResultSet recupData = conn.select(query);

		try
		{
			if(recupData.next())
			{
				exerciseNumber = recupData.getInt("COUNT(exercise.idExercise)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
		return exerciseNumber;
	}

	public static int returnDifficultyExerciseDone(User user, int difficulty) 
	{
		int exerciseDoneNumber = 0;
		String query = "SELECT COUNT(exercisedone.idExercise) "
				+ "FROM exercisedone "
				+ "JOIN user "
				+ "USING (idUser) "
				+ "JOIN exercise "
				+ "USING (idExercise) "
				+ "WHERE exercise.idDifficulty = " + difficulty + " AND user.userName = '" + user.getUserName() + "';";

		JDBC conn = new JDBC();
		ResultSet recupData = conn.select(query);

		try
		{
			if(recupData.next())
			{
				exerciseDoneNumber = recupData.getInt("COUNT(exercisedone.idExercise)");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
		return exerciseDoneNumber;
	}
}