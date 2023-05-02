package controller;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JOptionPane;

import model.User;
import view.App;
import view.Connection;
import view.Inscription;

public class VerifUser
{
	/************** Méthodes **************/

	// Méthode pour la connection

	public static void verifConn(Connection view, String name, String password)
	{

		/****** Requete utilisé lors du select pour le test du pseudo déja utilisé *****/

		String queryUser = "SELECT userName, userPassword "
				+ "FROM user "
				+ "WHERE userName = '" + name + "';";

		/***** Instanciation de l'objet JDBC******/

		JDBC conn = new JDBC();
		ResultSet verifBdd = conn.select(queryUser);

		/**** Partie Test *******/

		try
		{
			if(verifBdd.next())
			{
				if(password.equals(verifBdd.getString("userPassword"))) // on test si le mdp est présent en bdd
				{
					String query = "SELECT userLevel,userPoints,userName,idAvatar "
							+ "FROM user "
							+ "WHERE userName ='" + name + "';";

					String queryExercise = "SELECT exercisedone.idExercise "
							+ "FROM exercisedone "
							+ "JOIN user "
							+ "USING (idUser) "
							+ "WHERE user.userName = '" + name + "';";

					ResultSet recupData = conn.select(query);

					if(recupData.next())
					{
						User user = new User(name,recupData.getInt("idAvatar"));
						user.setUserLevel(recupData.getInt("userLevel"));
						user.setUserPoints(recupData.getInt("userPoints"));

						ResultSet recupExerciseDone = conn.select(queryExercise);

						while(recupExerciseDone.next())
						{
							user.setExerciseDone(recupExerciseDone.getInt("idExercise"));
						}
						conn.closeConnection();
						JOptionPane.showMessageDialog(App.getApp(),"Vous êtes connectés");
						SwapPage.swapPage("Home", user);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"Utlisateur ou mot de passe incorrect");
					view.clear();
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(App.getApp(),"Utlisateur ou mot de passe incorrect");
				view.clear();
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

	// méthode pour l'inscription

	public static void verifSub(Inscription view, String name, String password, String passConf, String date)
	{

		/****** Requete utilisé lors du select pour le test du pseudo déja utilisé *****/

		String query = "SELECT userName "
				+ "FROM user "
				+ "WHERE userName = '" + name + "';";

		/***** Instanciation de l'objet JDBC******/

		JDBC conn = new JDBC();
		ResultSet verif = conn.select(query);

		/***** Partie Test *********/

		if(name.isBlank() || password.isBlank() || date.isBlank())
		{
			JOptionPane.showMessageDialog(App.getApp(),"Le(s) champ(s) sont vides");
			return;
		}
		try
		{
			if(!verif.next())
			{
				if(password.equals(passConf))
				{
					int avatar = new Random().nextInt((10 - 1) + 1) + 1;
					User user = new User(name, avatar);
					user.setUserLevel(1);
					user.setUserPoints(0);
					conn.insertUser(name, password, date, avatar);
					User.setNumberUsers(1);
					conn.closeConnection();
					SwapPage.swapPage("MainPage");
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"Les mots de passe ne sont pas identiques");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(App.getApp(),"Identifiant déja utilisé") ;
			}
		}
		catch(HeadlessException e){
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
	}

	//Méthode pour le mot de passe oublié 

	public static void forgetPassword(String date, String name, String password, String passConf)
	{

		// On vérifie avant si les champs sont vides 

		if(name.isBlank() || password.isBlank() || passConf.isBlank() || date.isBlank())
		{
			JOptionPane.showMessageDialog(App.getApp(),"Le(s) champ(s) sont vides");
			return;
		}

		String query = "SELECT userName,userPassword,userBirthDate "
				+ " FROM user "
				+ " WHERE userName = '" + name + "';";

		JDBC conn = new JDBC();
		ResultSet verif = conn.select(query);

		try
		{
			if(verif.next())
			{
				if(password.equals(passConf))
				{
					if(date.equals(verif.getString("userBirthDate")))
					{
						String insert = "UPDATE user "
								+ "SET userPassword = '" + password +"' "
								+ "WHERE userName = '" + name +"';";

						conn.updateDB(insert);
						JOptionPane.showMessageDialog(App.getApp(),"Votre mot de passe a été mis à jour");
						conn.closeConnection();
						SwapPage.swapPage("LogIn");
					}
					else
					{
						JOptionPane.showMessageDialog(App.getApp(),"La date de naissance saisie est érronée");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(App.getApp(),"Les mots de passe ne sont pas identiques");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(App.getApp(),"Votre identifiant n'est pas reconnu");
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

	// Met à jour le niveau de l'utilisateur

	public static void levelCalculation(User user)
	{
		if(user.getUserPoints() % 1000 == 0)
		{
			user.setUserLevel(user.getUserLevel() + 1);
		}
	}

	// Vérifie si tout les exercices de la difficulté choisie sont terminés

	public static void verifLevelDone(User user, int difficulty)
	{
		int exerciseDoneNumber = 0 ;
		int exerciseNumber = 0;
		String query = "SELECT exercise.idExercise "
				+ "FROM exercise "
				+ "JOIN difficulty "
				+ "USING (idDifficulty) "
				+ "WHERE idDifficulty = " + difficulty + ";";

		JDBC conn = new JDBC();
		ResultSet recupData = conn.select(query);

		try
		{
			while(recupData.next())
			{
				if(user.getExerciseDone().contains(recupData.getInt("idExercise")))
				{
					exerciseDoneNumber++;
				}
				exerciseNumber++;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();

		if(exerciseDoneNumber == exerciseNumber)
		{
			SwapPage.swapPage("LevelCompleted", user);
		}
		else
		{
			@SuppressWarnings("unused")
			ExerciseSelect exercise = new ExerciseSelect(user, difficulty);
		}
	}
}