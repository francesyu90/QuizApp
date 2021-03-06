package com.example.beijia.quizapp;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // view variables
    private TextView questionTextView;
    private RadioGroup choicesRadioGroup;
    private Button submitButton;
    private RadioButton optionAButton;
    private RadioButton optionBButton;
    private RadioButton optionCButton;

    private Question question;

    private void assignViewToVariables() {
        this.questionTextView = (TextView)this.findViewById(R.id.questionText);
        this.choicesRadioGroup = (RadioGroup)this.findViewById(R.id.choicesRadioGroup);
        this.submitButton = (Button)this.findViewById(R.id.submitButton);
        this.optionAButton = (RadioButton) this.findViewById(R.id.optionAButton);
        this.optionBButton = (RadioButton) this.findViewById(R.id.optionBButton);
        this.optionCButton = (RadioButton) this.findViewById(R.id.optionCButton);
    }

    private void updateColor() {
        View backgroundView = this.findViewById(R.id.backgroundView);
        int r = Utility.randomNumberGenerator(0, 255);
        int g = Utility.randomNumberGenerator(0, 255);
        int b = 255;
        int color = Color.argb(255, r, g, b);
        backgroundView.setBackgroundColor(color);
        this.submitButton.setTextColor(color);
    }

    private void updateQuestion() {
        this.question = new Question();
        String question = this.question.getQuestion();
        this.questionTextView.setText(question);
    }

    private void setOptionButtonText(RadioButton radioButton, int num) {
        radioButton.setText(String.format("%s", num));
    }

    private void updateChoices() {

        int sum = this.question.getSum();
        int possibleAnswer1 = Utility.randomNumberGenerator(100);
        int possibleAnswer2 = Utility.randomNumberGenerator(100);

        // determine which option has the correct sum
        int pos = Utility.randomNumberGenerator(0, 2);

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

    private void showResponse() {
        Context context = getApplicationContext();
        Integer selectedId = this.choicesRadioGroup.getCheckedRadioButtonId();
        this.choicesRadioGroup.clearCheck();
        RadioButton selectedRadioButton = (RadioButton) this.findViewById(selectedId);
        CharSequence userInput = selectedRadioButton.getText();
        int sum = Integer.parseInt(userInput.toString());
        int expectedSum = this.question.getSum();
        CharSequence text = (sum == expectedSum)? "Correct answer" : "Incorrect answer";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void render() {
        updateColor();
        updateQuestion();
        updateChoices();
    }

    private void setSubmitButtonListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResponse();
                render();
            }
        };
        this.submitButton.setOnClickListener(listener);
    }

    private void initialize() {
        int firstNum = 48;
        int secondNum = 12;
        this.question = new Question(firstNum, secondNum);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initialize();

        this.assignViewToVariables();
        this.setSubmitButtonListener();
    }
}
