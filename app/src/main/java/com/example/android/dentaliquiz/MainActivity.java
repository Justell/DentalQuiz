package com.example.android.dentaliquiz;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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
     *  When "See score" button is clicked, shows the result with the toast message
     */
    public void submitScore (View view){

        int points = 0;

        /**
         * Evaluating if the rights answers are checked and calculating the points
         */
        RadioButton firstQuestionButton = (RadioButton) findViewById(R.id.enamel_button);
        boolean firstQuestionTrue = firstQuestionButton.isChecked();
        if (firstQuestionTrue) {
            points = points + 1;
        }

        RadioButton secondQuestionButton = (RadioButton) findViewById(R.id.twice_button);
        boolean secondQuestionTrue = secondQuestionButton.isChecked();
        if (secondQuestionTrue) {
            points = points + 1;
        }

        RadioButton thirdQuestionButton = (RadioButton) findViewById(R.id.three_fiction_button);
        boolean thirdQuestionTrue = thirdQuestionButton.isChecked();
        if (thirdQuestionTrue) {
            points = points + 1;
        }

        RadioButton fourthQuestionButton = (RadioButton) findViewById(R.id.four_fiction_button);
        boolean fourthQuestionTrue = fourthQuestionButton.isChecked();
        if (fourthQuestionTrue) {
            points = points + 1;
        }

        RadioButton fifthQuestionButton = (RadioButton) findViewById(R.id.five_fiction_button);
        boolean fifthQuestionTrue = fifthQuestionButton.isChecked();
        if (fifthQuestionTrue) {
            points = points + 1;
        }

        RadioButton sixthQuestionButton = (RadioButton) findViewById(R.id.six_fiction_button);
        boolean sixthQuestionTrue = sixthQuestionButton.isChecked();
        if (sixthQuestionTrue) {
            points = points + 1;
        }


        /**
         * In order to get a point in Question 7, user has to check three particular boxes
         */
        CheckBox seventhThreeMonths = (CheckBox) findViewById(R.id.three_months_checkbox);
        boolean seventhThree = seventhThreeMonths.isChecked();
        CheckBox seventhInfectious = (CheckBox) findViewById(R.id.infectious_checkbox);
        boolean seventhInf = seventhInfectious.isChecked();
        CheckBox seventhBristlesFrayed = (CheckBox) findViewById(R.id.bristles_checkbox);
        boolean seventhBristles = seventhBristlesFrayed.isChecked();
        CheckBox seventhOnceAYear = (CheckBox) findViewById(R.id.once_checkbox);
        boolean seventhOnce = seventhOnceAYear.isChecked();

        if (seventhThree && seventhInf && seventhBristles && !seventhOnce) {
            points = points + 1;
        }

        RadioButton eightQuestionButton = (RadioButton) findViewById(R.id.paste_ok);
        boolean eightQuestionTrue = eightQuestionButton.isChecked();
        RadioButton eightQuestionBadButton = (RadioButton) findViewById(R.id.paste);
        boolean eightQuestionFalse = eightQuestionBadButton.isChecked();

        if (eightQuestionTrue) {
            points = points + 1;
        }

        /**
         * Evaluate text input, if it`s 20 - add one point
         */
        EditText ninthNumber = (EditText) findViewById(R.id.number_of_teeth);
        String ninthQ= ninthNumber.getText().toString();
        if (ninthQ.equals("")){
            Toast.makeText(getApplicationContext(),"Please enter a guess at Question 9!", Toast.LENGTH_LONG).show();
            return;
        }

        int ninthNumberOfTeeth = Integer.parseInt(ninthQ);
        if (ninthNumberOfTeeth == 20){
            points = points+1;
        }


        /**
         * Creating toast messages according points counted
         */
        if (points <= 1) {
            Context context = getApplicationContext();
            CharSequence text = "Your score: " + points + " " + getString(R.string.toastZero);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (points>1 && points<5){
            Context context = getApplicationContext();
            CharSequence text = "Your score: " + points + " " + getString(R.string.toastFour);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (points>4 && points<8){
            Context context = getApplicationContext();
            CharSequence text = "Your score: " + points + " " + getString(R.string.toastSeven);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (points>=8){
            Context context = getApplicationContext();
            CharSequence text = "Your score: " + points + " " + getString(R.string.toastNine);
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

    }

    /**
     *When "Recommendations" button is clicked, shows longer toast message with recommendations
     */
    public void recommendations (View view){

        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toastRecommendations);
        int duration = Toast.LENGTH_LONG;

        final Toast message = Toast.makeText(context, text, duration);
        message.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {message.show();}
            public void onFinish() {message.show();}

        }.start();
    }

}
