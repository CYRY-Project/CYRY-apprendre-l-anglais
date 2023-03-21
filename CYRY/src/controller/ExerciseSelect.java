package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import model.Exercise;
import model.User;

public class ExerciseSelect
{
	/************** Attributs **************/

	private	static	ArrayList<Integer>				exercises = new ArrayList<Integer>();
	private			ArrayList<ArrayList<String>>	questions;
	private 		ArrayList<ArrayList<String>>	answers;
	private			String							image;
	@SuppressWarnings("unused")
	private			int								exerciseDone;		// Permet de savoir si l’exercice est déjà validé ou pas. (faux par défaut)
	private			String							title;
	private			int								difficulty;
	private			int								type;
	private 		int								idExercise;

	/************** Constructeurs **************/	

	public ExerciseSelect(User user, int difficulty)
	{
		this.difficulty = difficulty;

		String queryExercise = "SELECT idExercise "
				+ "FROM exercise "
				+ "WHERE idDifficulty = " + this.difficulty + ";";

		JDBC conn = new JDBC();
		ResultSet rsExercise = conn.select(queryExercise);

		try
		{
			while(rsExercise.next())
			{
				exercises.add(rsExercise.getInt("idExercise"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		conn.closeConnection();
		
		this.idExercise = randomExercise(user, 0, (exercises.size() - 1));

		if(this.typeSelect(this.idExercise) == 1 || this.typeSelect(this.idExercise) == 3)
		{
			this.answerSelect(this.idExercise);
			this.questionSelect(this.idExercise);
			this.imageSelect(this.idExercise);
			this.titleSelect(this.idExercise);
			Exercise exercise = new Exercise(this.idExercise,this.questions,this.answers,this.image,this.title,this.type,this.difficulty);
			ExerciseLoader.typeSelect(user, exercise);
		}
		else
		{
			this.answerSelect(this.idExercise);
			this.questionSelect(this.idExercise);
			this.titleSelect(this.idExercise);

			Exercise exercise = new Exercise(this.idExercise,this.questions,this.answers,this.title,this.type,this.difficulty);
			ExerciseLoader.typeSelect(user, exercise);
		}
	}

	/************** Accesseurs **************/

	/********** Getters **********/

	public ArrayList<ArrayList<String>> getQuestions()
	{
		return this.questions;
	}

	public ArrayList<ArrayList<String>> getAnswers()
	{
		return this.answers;
	}

	public int getType()
	{
		return this.type;
	}

	public int getDifficulty()
	{
		return this.difficulty;
	}

	/********** Setters **********/

	public void setType(int newType)
	{
		this.type = newType;
	}

	public void setDifficulty(int newDifficulty)
	{
		this.difficulty = newDifficulty;
	}

	/************** Méthodes **************/

	public void questionSelect(int exercise)
	{
		String question = "SELECT idQuestion, question, goodAnswer "
				+ "FROM question "
				+ "WHERE idExercise = " + exercise + ";";

		JDBC conn = new JDBC();
		ResultSet rsQuestion = conn.select(question);

		this.questions = new ArrayList<ArrayList<String>>();

		try
		{
			while(rsQuestion.next())
			{
				this.questions.add(0, new ArrayList<String>());
				this.questions.get(0).add(String.valueOf(rsQuestion.getInt("idQuestion")));
				this.questions.get(0).add(rsQuestion.getString("question"));
				this.questions.get(0).add(String.valueOf(rsQuestion.getInt("goodAnswer")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		conn.closeConnection();
	}

	public void answerSelect(int exercise)
	{
		this.answers = new ArrayList<ArrayList<String>>();
		String answer = "SELECT idAnswer, answer "
				+ "FROM answer "
				+ "WHERE idExercise = " + exercise + ";";

		JDBC conn = new JDBC();
		ResultSet rsAnswer = conn.select(answer);

		try
		{
			while(rsAnswer.next())
			{
				this.answers.add(0, new ArrayList<String>());
				this.answers.get(0).add(String.valueOf(rsAnswer.getInt("idAnswer")));
				this.answers.get(0).add(rsAnswer.getString("answer"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		conn.closeConnection();
	}

	public void imageSelect(int exercise)
	{
		String image = "SELECT imageLink "
				+ "FROM image "
				+ "WHERE idExercise = " + exercise + ";";

		JDBC conn = new JDBC();
		ResultSet rsImage = conn.select(image);

		try
		{
			if(rsImage.next())
			{
				this.image = rsImage.getString("imageLink");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		conn.closeConnection();
	}

	public void titleSelect(int exercise)
	{
		String titre = "SELECT title "
				+ "FROM exercise "
				+ "WHERE idExercise = " + exercise + ";";

		JDBC conn = new JDBC();
		ResultSet rsTitle = conn.select(titre);

		try
		{
			if(rsTitle.next())
			{
				this.title = rsTitle.getString("title");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		conn.closeConnection();
	}

	public int typeSelect(int exercise)
	{
		String query = "SELECT idType "
				+ "FROM exercise "
				+ "WHERE idExercise = " + exercise + ";";

		JDBC conn = new JDBC();
		ResultSet rsType = conn.select(query);

		try
		{
			if(rsType.next())
			{
				this.type = rsType.getInt("idType");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		conn.closeConnection();
		return this.type;
	}

	public boolean exerciseDoneVerif(int exercise, ArrayList<Integer> exerciseDoneList)
	{
		if(exerciseDoneList.contains(exercise))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int randomExercise(User user,int min, int max)
	{
		int randomNumber = new Random().nextInt((max - min) + 1) + min;
		if(this.exerciseDoneVerif(exercises.get(randomNumber),user.getExerciseDone()))
		{
			return randomExercise(user,min,max);
		}
		else
		{
			return exercises.get(randomNumber);
		}
	}

	public String toString() 
	{
		return "id : " + idExercise + "\nTitre de l'exercice : " + this.title + "\nType de l'exercice : " + this.type + "\nDifficulté de l'exercice : " + this.difficulty + "\nImage : " + image;
	}
}