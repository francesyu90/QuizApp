package com.example.beijia.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    private List<Question> questionList;

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return this.questionList;
    }

    public Question[] getQuestionArray() {
        return this.questionList.toArray(new Question[this.questionList.size()]);
    }

    public Boolean addNewQuestion(Question question) {
        if(this.questionList == null) {
            this.questionList = new ArrayList<>();
        }
        return this.questionList.add(question);
    }

    public Boolean removeQuestion(Question question) {
        return this.questionList.remove(question);
    }

    public int getQuestionSize() {
        return this.questionList.size();
    }

}
