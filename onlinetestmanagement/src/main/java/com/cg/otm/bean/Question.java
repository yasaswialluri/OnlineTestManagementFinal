package com.cg.otm.bean;

public class Question {
	// fields
	int questionId ; 
	String []questionOptions = new String[4];
	String questionTitle ;
	int questionAnswer ;
	double questionMarks ;
	int chosenAnswer ;
	double marksScored ;


	public Question(int questionId, String questionTitle, int questionAnswer,
			double questionMarks, int chosenAnswer, double marksScored) {
		super();
		this.questionId = questionId;

		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}


	public Question() {
		super();
	}


	// setters and getters

	public int getQuestionId() {
		return questionId;
	}
	public int setQuestionId(int questionId) {
		return this.questionId = questionId;
	}
	public String[] getQuestionOptions() {
		return questionOptions;
	}
	public String[] setQuestionOptions(String[] questionOptions) {
		return this.questionOptions = questionOptions;

	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public String setQuestionTitle(String questionTitle) {
		return this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public int setQuestionAnswer(int questionAnswer) {
		return this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public double setQuestionMarks(double mark) {
		return this.questionMarks = mark;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(float marksScored) {
		this.marksScored = marksScored;
	}
}
