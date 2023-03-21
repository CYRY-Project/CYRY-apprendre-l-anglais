package model;

import java.util.ArrayList;

public class Exercise
{
	/************** Attributs **************/

	private			int								idExercise;
	private			String							title;
	private			int								type;						// int type : 1 = MCQ, 2 = Situation, 3 = Gap-fill Text, 4 = Translation, 5 = Sentence Construction
	private			int								difficulty;
	private			String							image;
	private			ArrayList<ArrayList<String>>	questions;
	private			ArrayList<ArrayList<String>>	answers;

	public	static	int								numberExercise = 0;

	/************** Constructeurs **************/

	public Exercise(int idExerciseDB, ArrayList<ArrayList<String>> questionsDB, ArrayList<ArrayList<String>> answersDB, String titleDB, int typeDB, int difficultyDB)
	{
		this.idExercise = idExerciseDB;
		this.title = titleDB;
		this.type = typeDB;
		this.difficulty = difficultyDB;
		this.questions = questionsDB;
		this.answers = answersDB;
	}

	public Exercise(int idExerciseDB, ArrayList<ArrayList<String>> questionsDB, ArrayList<ArrayList<String>> answersDB, String imageDB, String titleDB, int typeDB, int difficultyDB)
	{
		this.idExercise = idExerciseDB;
		this.title = titleDB;
		this.type = typeDB;
		this.difficulty = difficultyDB;
		this.image = imageDB;
		this.questions = questionsDB;
		this.answers = answersDB;
	}

	/************** Accesseurs **************/

	/********** Getters **********/

	public int getIdExercise()
	{
		return this.idExercise;
	}

	public String getExerciseTitle()
	{
		return this.title;
	}

	public int getExerciseType()
	{
		return this.type;
	}

	public int getExerciseDifficulty()
	{
		return this.difficulty;
	}

	public String getExerciseImage()
	{
		return this.image;
	}

	public ArrayList<ArrayList<String>> getExerciseQuestions()
	{
		return this.questions;
	}

	public ArrayList<ArrayList<String>> getExerciseAnswers()
	{
		return this.answers;
	}

	/********** Setters **********/

	public void setExerciseAnswers(ArrayList<ArrayList<String>> newAnswers)
	{
		this.answers = newAnswers;
	}

	/************** Méthodes **************/

	public String toString()
	{
		return "Exercice numéro : " + this.idExercise
				+ "\nDifficulté : " + this.difficulty
				+ "\nType : " + this.type
				+ "\nTitre : " + this.title
				+ "\nQuestions : " + this.questions
				+ "\nRéponses : " + this.answers;
	}
}