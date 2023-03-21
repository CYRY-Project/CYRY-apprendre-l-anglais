package model;

import java.util.ArrayList;

public class User
{
	/************** Attributs **************/

	private			String				userName;
	private			int					userLevel;
	private			int					userPoints;
	private			ArrayList<Integer>	exerciseDone = new ArrayList<Integer>();
	private			String				userAvatar;

	public	static	int					numberUsers = 0;

	/************** Constructeurs **************/

	public User(String name, int avatar)
	{
		this.userName = name;
		this.userAvatar = "src/image/avatar/" +  avatar + ".png";
	}

	/************** Accesseurs **************/

	/********** Getters **********/

	public String getUserName()
	{
		return this.userName;
	}

	public int getUserLevel()
	{
		return this.userLevel;
	}

	public int getUserPoints()
	{
		return this.userPoints;
	}

	public ArrayList<Integer> getExerciseDone()
	{
		return this.exerciseDone;
	}

	public String getUserAvatar()
	{
		return this.userAvatar;
	}

	/********** Setters **********/

	public void setUserName(String name)
	{
		this.userName = name;
	}

	public void setUserLevel(int level)
	{
		this.userLevel = level;
	}

	public void setUserPoints(int points)
	{
		this.userPoints = points;
	}

	public void setExerciseDone(int idExercise)
	{
		this.exerciseDone.add(idExercise);
	}

	public void setUserAvatar(String avatar)
	{
		this.userAvatar = avatar;
	}

	public static void setNumberUsers(int number)
	{
		numberUsers = numberUsers + number;
	}

	/************** Méthodes **************/

	public String toString()
	{
		return "Nom d'utilisateur : " + this.userName
				+ "\nNiveau : " + this.userLevel
				+ "\nPoints : " + this.userPoints
				+ "\nAvatar : " + this.userAvatar
				+ "\nExercices terminés : " + this.exerciseDone;
	}
}