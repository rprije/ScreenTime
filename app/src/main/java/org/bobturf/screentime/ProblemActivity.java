package org.bobturf.screentime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ProblemActivity extends AppCompatActivity {

    private Problem problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        // The problem values need to be passed in.
        // The problems themselves need to be generated somehow

        Integer i = Util.randInt(0,3);

        Log.d("MyApp", String.format("Generated Randem Integer: %d", i));

        switch (i) {
            case 0 :
                Log.d("MyApp", "Case 0");
                problem = new MultipleDigitAddition();
                break;
            case 1 :
                Log.d("MyApp", "Case 1");
                problem = new MultipleDigitSubtraction();
                break;
            case 2 :
                Log.d("MyApp", "Case 2");
                problem = new SingleDigitMultiplication();
                break;
        }

        Integer problemVal1 = problem.getValue();
        View problemDescription= problem.represent(this);

        ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
        Integer currentTokens = app.getState().getTokensEarned();
        String currentTokensText = String.format("You currently have %d tokens", currentTokens);
        String valueText = String.format("This problem is worth %d points", (Integer)problemVal1);
        TextView valueView = (TextView)findViewById(R.id.problem_value);
        valueView.setText(currentTokensText + "\n" + valueText);

        FrameLayout problemFrame = (FrameLayout)findViewById(R.id.problem_frame);
        problemFrame.addView(problemDescription);

    }

    private void nextProblem() {
        Intent intent = new Intent(this, ProblemActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void checkAnswer(View view) {

        EditText answerView = (EditText)findViewById(R.id.answer_entry);


        try {

            if (problem.checkSolution(answerView.getText().toString())) {
                ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
                app.getState().earnTokens(problem.getValue());
                nextProblem();
            } else {
                TextView tryAgain = (TextView) findViewById(R.id.try_again);
                tryAgain.setText(R.string.try_again);
                answerView.getText().clear();
            }
        } catch (BadUserInputException buie) {

        }
    }

    public void skipProblem(View view) {
        nextProblem();
    }
}
