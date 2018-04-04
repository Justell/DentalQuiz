package com.example.android.dentaliquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * When "See score" button is clicked, shows the result with the toast message and sets correct answers to green
     */
    public void submitScore(View view) {

        int points = 0;
        String toastText;

        /**
         * Evaluating if the rights answers are checked and calculating the points
         */
        RadioButton firstQuestionButton = (RadioButton) findViewById(R.id.enamel_button);
        firstQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean firstQuestionTrue = firstQuestionButton.isChecked();
        if (firstQuestionTrue) {
            points++;
        }

        RadioButton secondQuestionButton = (RadioButton) findViewById(R.id.twice_button);
        secondQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean secondQuestionTrue = secondQuestionButton.isChecked();
        if (secondQuestionTrue) {
            points++;
        }

        RadioButton thirdQuestionButton = (RadioButton) findViewById(R.id.three_fiction_button);
        thirdQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean thirdQuestionTrue = thirdQuestionButton.isChecked();
        if (thirdQuestionTrue) {
            points++;
        }

        RadioButton fourthQuestionButton = (RadioButton) findViewById(R.id.four_fiction_button);
        fourthQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean fourthQuestionTrue = fourthQuestionButton.isChecked();
        if (fourthQuestionTrue) {
            points++;
        }

        RadioButton fifthQuestionButton = (RadioButton) findViewById(R.id.five_fiction_button);
        fifthQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean fifthQuestionTrue = fifthQuestionButton.isChecked();
        if (fifthQuestionTrue) {
            points++;
        }

        RadioButton sixthQuestionButton = (RadioButton) findViewById(R.id.six_fiction_button);
        sixthQuestionButton.setTextColor(getResources().getColor(R.color.green));
        boolean sixthQuestionTrue = sixthQuestionButton.isChecked();
        if (sixthQuestionTrue) {
            points++;
        }


        /**
         * In order to get a point in Question 7, user has to check three particular boxes
         */
        CheckBox seventhThreeMonths = (CheckBox) findViewById(R.id.three_months_checkbox);
        seventhThreeMonths.setTextColor(getResources().getColor(R.color.green));
        boolean seventhThree = seventhThreeMonths.isChecked();
        CheckBox seventhInfectious = (CheckBox) findViewById(R.id.infectious_checkbox);
        seventhInfectious.setTextColor(getResources().getColor(R.color.green));
        boolean seventhInf = seventhInfectious.isChecked();
        CheckBox seventhBristlesFrayed = (CheckBox) findViewById(R.id.bristles_checkbox);
        seventhBristlesFrayed.setTextColor(getResources().getColor(R.color.green));
        boolean seventhBristles = seventhBristlesFrayed.isChecked();
        CheckBox seventhOnceAYear = (CheckBox) findViewById(R.id.once_checkbox);
        boolean seventhOnce = seventhOnceAYear.isChecked();

        if (seventhThree && seventhInf && seventhBristles && !seventhOnce) {
            points++;
        }

        RadioButton eightQuestionButton = (RadioButton) findViewById(R.id.paste_ok);
        boolean eightQuestionTrue = eightQuestionButton.isChecked();
        RadioButton eightQuestionBadButton = (RadioButton) findViewById(R.id.paste);
        boolean eightQuestionFalse = eightQuestionBadButton.isChecked();

        if (eightQuestionTrue) {
            points++;
        }

        /**
         * Evaluate text input, if it`s 20 - add one point
         */
        EditText ninthNumber = (EditText) findViewById(R.id.number_of_teeth);
        String ninthQ = ninthNumber.getText().toString();
        if (ninthQ.equals("")) {
            Toast.makeText(getApplicationContext(), getString(R.string.NineFill), Toast.LENGTH_LONG).show();
            return;
        }

        int ninthNumberOfTeeth = Integer.parseInt(ninthQ);
        if (ninthNumberOfTeeth == 20) {
            ninthNumber.setTextColor(getResources().getColor(R.color.green));
            points++;
        }
        if (ninthNumberOfTeeth != 20) {
            ninthNumber.setTextColor(getResources().getColor(R.color.red));
        }


        /**
         * Creating toast messages according points counted
         */

        if (points <= 1) {
            toastText = "Your score is: " + points + " " + getString(R.string.toastZero);
            DisplayText(toastText);
        } else if (points < 5) {
            toastText = "Your score is: " + points + " " + getString(R.string.toastFour);
            DisplayText(toastText);
        } else {
            toastText = "Your score is: " + points + " " + getString(R.string.toastNine);
            DisplayText(toastText);
        }

    }

    /**
     * When "Recommendations" button is clicked, sends intent to recommendations activity
     */
    public void recommendations(View view) {

        Intent recommendationsAct = new Intent(MainActivity.this, Recommendations.class);
        startActivity(recommendationsAct);
    }

    public void DisplayText(String message) {

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }


}
