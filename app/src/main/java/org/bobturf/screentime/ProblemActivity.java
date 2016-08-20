package org.bobturf.screentime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.bobturf.screentime.Exception.BadUserInput;
import org.bobturf.screentime.Exception.ProblemsAlreadyComplete;
import org.bobturf.screentime.Problem.Problem;

public class ProblemActivity extends AppCompatActivity {

    private Problem problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
        State state = app.getState();

        try {
            problem = state.nextProblem();

            View problemDescription = problem.represent(this);

            Integer numProblemsRemaining = state.numProblemsRemaining();

            String remainingProblemsText = String.format("You have %d problems remaining", numProblemsRemaining);
            TextView valueView = (TextView)findViewById(R.id.problem_status);
            valueView.setText(remainingProblemsText);

            FrameLayout problemFrame = (FrameLayout)findViewById(R.id.problem_frame);
            problemFrame.addView(problemDescription);

        } catch (ProblemsAlreadyComplete problemsAlreadyComplete) {
            this.finish();
        }

    }

    private void nextProblem() {
        Intent intent = new Intent(this, ProblemActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void checkAnswer(@SuppressWarnings("UnusedParameters") View view) {

        EditText answerView = (EditText)findViewById(R.id.answer_entry);


        try {

            if (problem.checkSolution(answerView.getText().toString())) {
                ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
                app.getState().problemCompleted();
                nextProblem();
            } else {
                TextView tryAgain = (TextView) findViewById(R.id.try_again);
                tryAgain.setText(R.string.try_again);
                answerView.getText().clear();
            }
        } catch (BadUserInput badUserInput) {
            // TODO: report to the user
        }
    }

    public void skipProblem(@SuppressWarnings("UnusedParameters") View view) {
        ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
        State state = app.getState();
        state.skipProblem();
        nextProblem();
    }
}
