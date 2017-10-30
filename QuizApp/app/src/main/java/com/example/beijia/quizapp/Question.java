package com.example.beijia.quizapp;

public class Question {

    private String question;
    private int firstNum;
    private int secondNum;
    private int sum;

    private static Utility utility;

    private static final String QUESTION_TEXT = "What is %s + %s?";
    private static final int MAX = 100;

    public Question() {
        generateQuestion();
    }

    private void generateQuestion() {
        this.firstNum = utility.randomNumberGenerator(MAX);
        this.secondNum = utility.randomNumberGenerator(MAX);
        this.sum = this.firstNum + this.secondNum;
        this.question = String.format(QUESTION_TEXT, this.firstNum, this.secondNum);
    }

    public String getQuestion() {
        return this.question;
    }

    public int getSum() {
        return this.sum;
    }

}
