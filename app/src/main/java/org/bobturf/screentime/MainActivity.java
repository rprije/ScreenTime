package org.bobturf.screentime;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.bobturf.screentime.Exception.AlreadyHaveProblems;
import org.bobturf.screentime.Exception.ShouldBeImpossible;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnDismissListener{

    private State state;

    private TextView main_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
        state = app.getState();
        state.load(this);

        main_summary = (TextView)findViewById(R.id.main_summary);

        showTokens();

        // Do I really want to list out all the problems?
        // Just define which problems get used myself.
        // Maybe later add support for tracking how regularly
        // they answer correctly and generate an inverse
        // relation between regular correctness and frequency asked
        // Maybe also make the value of the question inversely
        // related to how often they're asked.
        // Also, track logs of how they answered each question
        // so they can be reviewed, and generate statistics

    }

    @Override
    protected void onStart() {
        super.onStart();
        showTokens();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showTokens();
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        showTokens();
    }

    private void showTokens () {
        Integer tokens = state.getTokensEarned();

        main_summary.setText(String.format("You currently have %d tokens", tokens));
    }

    public void start(@SuppressWarnings("UnusedParameters") View view) {
        if (state.numProblemsRemaining() <= 0) {
            try {
                state.generateProblems(1);
            } catch (AlreadyHaveProblems alreadyHaveProblems) {
                throw new ShouldBeImpossible();
            }
        }

        Intent intent = new Intent(this, ProblemActivity.class);
        startActivity(intent);
    }

    public void reset(@SuppressWarnings("UnusedParameters") View view) {
        ResetDialog dialog = new ResetDialog();
        dialog.show(getSupportFragmentManager(), "reset");
    }

}
