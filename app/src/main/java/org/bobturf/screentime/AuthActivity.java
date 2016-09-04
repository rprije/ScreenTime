package org.bobturf.screentime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {

    private EditText passcodeEntry;
    private State state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        passcodeEntry = (EditText)findViewById(R.id.passcode_entry);

        ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
        state = app.getState();

        passcodeEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                checkPasscode(passcodeEntry);
                return false;
            }
        });


    }

    public void checkPasscode (@SuppressWarnings("UnusedParameters") View view) {
        String passcode = passcodeEntry.getText().toString();
        if (state.checkPasscode(passcode)) {
            launchSettings();
        }
        finish();
    }

    public void cancel (@SuppressWarnings("UnusedParameters") View view) {
        finish();
    }

    void launchSettings () {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
