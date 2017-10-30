package com.example.beijia.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // view variables
    private TextView questionTextView;
    private RadioGroup choicesRadioGroup;
    private Button submitButton;
    private RadioButton optionAButton;
    private RadioButton optionBButton;
    private RadioButton optionCButton;

    private Random random;
    private int firstNum;
    private int secondNum;

    private static final int MAX = 100;

    // string format templates
    private static final String QUESTION_TEXT = "What is %s + %s?";

    private Integer randomNumberGenerator() {
        return this.random.nextInt(MAX);
    }
    private Integer randomNumberGenerator(int min, int max) {
        return this.random.nextInt(max - min + 1) + min;
    }

    private void assignViewToVariables() {
        this.questionTextView = (TextView)this.findViewById(R.id.questionText);
        this.choicesRadioGroup = (RadioGroup)this.findViewById(R.id.choicesRadioGroup);
        this.submitButton = (Button)this.findViewById(R.id.submitButton);
        this.optionAButton = (RadioButton) this.findViewById(R.id.optionAButton);
        this.optionBButton = (RadioButton) this.findViewById(R.id.optionBButton);
        this.optionCButton = (RadioButton) this.findViewById(R.id.optionCButton);
    }

    private void updateQuestion() {
        this.firstNum = this.randomNumberGenerator();
        this.secondNum = this.randomNumberGenerator();
        String question = String.format(QUESTION_TEXT, this.firstNum, this.secondNum);
        this.questionTextView.setText(question);
    }

    private void setOptionButtonText(RadioButton radioButton, int num) {
        radioButton.setText(Integer.toString(num));
    }

    private void updateChoices() {

        int sum = this.firstNum + this.secondNum;
        int possibleAnswer1 = this.randomNumberGenerator();
        int possibleAnswer2 = this.randomNumberGenerator();

        // determine which option has the correct sum
        int pos = this.randomNumberGenerator(0, 2);

        switch (pos) {
            case 0:
                this.setOptionButtonText(this.optionAButton, sum);
                this.setOptionButtonText(this.optionBButton, possibleAnswer1);
                this.setOptionButtonText(this.optionCButton, possibleAnswer2);
                break;
            case 1:
                this.setOptionButtonText(this.optionAButton, possibleAnswer1);
                this.setOptionButtonText(this.optionBButton, sum);
                this.setOptionButtonText(this.optionCButton, possibleAnswer2);
                break;
            default:
                this.setOptionButtonText(this.optionAButton, possibleAnswer1);
                this.setOptionButtonText(this.optionBButton, possibleAnswer2);
                this.setOptionButtonText(this.optionCButton, sum);
        }

    }

    private void setSubmitButtonListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
                updateChoices();
            }
        };
        this.submitButton.setOnClickListener(listener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.random = new Random();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.assignViewToVariables();
        this.setSubmitButtonListener();
    }
}
