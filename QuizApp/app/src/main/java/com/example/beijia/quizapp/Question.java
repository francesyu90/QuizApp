package com.example.beijia.quizapp;

public class Question {

    private String question;
    private int firstNum;
    private int secondNum;

    private static final String QUESTION_TEXT = "What is %s + %s?";
    private static final int MAX = 100;

    public Question() {
        this.firstNum = Utility.randomNumberGenerator(MAX);
        this.secondNum = Utility.randomNumberGenerator(MAX);
        this.generateQuestion();
    }

    public Question(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.generateQuestion();
    }

    private void generateQuestion() {
        this.question = String.format(QUESTION_TEXT, this.firstNum, this.secondNum);
    }

    public String getQuestion() {
        return this.question;
    }

    public int getSum() {
        return this.firstNum + this.secondNum;
    }

}
