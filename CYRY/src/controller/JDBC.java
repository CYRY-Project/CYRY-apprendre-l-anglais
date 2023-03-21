package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import view.App;

public class JDBC
{
	/************** Attributs **************/

	private	String		driver = "com.mysql.cj.jdbc.Driver";
	private	String		dbUrl = "localhost:3306/";
	private	String		dbName = "cyry";
	private	String		dbLogin = "cyry";
	private	String		dbPassword = "cyry";
	private	String		connUrl = "jdbc:mysql://" + dbUrl + dbName + "?useSSL=false&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private	Statement	stBDD;
	private	Connection	connection;

	/************** Constructeurs **************/

	public JDBC()
	{
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(connUrl, dbLogin, dbPassword);
			stBDD = connection.createStatement();
		}
		catch(ClassNotFoundException e) 
		{  
			System.err.println("Driver non chargé !");
			e.printStackTrace();
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/************** Accesseurs **************/

	/********** Getters **********/

	Statement getStBDD()
	{
		return this.stBDD;
	}

	Connection getConnection()
	{
		return this.connection;
	}

	/************** Méthodes **************/

	public ResultSet select(String query)
	{
		ResultSet rsBDD = null;
		try
		{
			rsBDD = getStBDD().executeQuery(query);
			return rsBDD;
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return rsBDD;
	}

	public void insertExerciseDone(int idExercise, int idUser)
	{
		String query = "INSERT INTO exercisedone "
				+ "(idUser,idExercise) "
				+ "VALUES ('" + idUser + "'," + idExercise + ");";
		try
		{
			this.stBDD.executeUpdate(query);
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void insertUser(String name, String password, String birthDate, int avatar)
	{
		String query = "INSERT INTO user "
				+ "(userName,userPassword,userBirthDate,userLevel,userPoints,idAvatar) "
				+ "VALUES ('"+name+"', '"+password+"', '"+birthDate+"', '1', '0', '"+avatar+"');";	
		try
		{
			getStBDD().executeUpdate(query);
			JOptionPane.showMessageDialog(App.getApp(),"Nouvel utilisateur créé");
		}		
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void updateDB(String query)
	{
		try
		{
			this.stBDD.executeUpdate(query);
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void deleteUserDB(String userName)
	{

		String queryExerciseDone = "DELETE exercisedone "
				+ "FROM exercisedone "
				+ "JOIN user "
				+ "USING (idUser) "
				+ "WHERE user.userName = '" + userName + "';";

		String queryUser = "DELETE "
				+ "FROM user "
				+ "WHERE userName = '" + userName + "';";

		try
		{
			getStBDD().executeUpdate(queryExerciseDone);
			getStBDD().executeUpdate(queryUser);
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void closeConnection()
	{
		try
		{
			getConnection().close();
		}
		catch(SQLException e)
		{
			System.err.println("erreur sql"); e.printStackTrace();
		}
	}
}
