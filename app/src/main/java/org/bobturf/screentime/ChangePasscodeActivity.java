package org.bobturf.screentime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasscodeActivity extends AppCompatActivity {

    private Button changePasswordButton;
    private EditText passcodeEntry;
    private EditText passcodeConfirmEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passcode);

        changePasswordButton = (Button) findViewById(R.id.change_passcode_button);
        passcodeEntry = (EditText) findViewById(R.id.passcode_entry);
        passcodeConfirmEntry = (EditText) findViewById(R.id.passcode_confirm_entry);

        passcodeConfirmEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(@SuppressWarnings("UnusedParameters") Editable editable) {
                if (passcodeMatches()) {
                    changePasswordButton.setEnabled(true);
                } else {
                    changePasswordButton.setEnabled(false);
                }
            }
        });
    }

    public void changePasscode(@SuppressWarnings("UnusedParameters") View view) {
        if (passcodeMatches()) {
            ScreenTimeApplication app = (ScreenTimeApplication) getApplicationContext();
            State state = app.getState();
            state.changePasscode(passcodeEntry.getText().toString());
            finish();
        } else {
            changePasswordButton.setEnabled(false);
            passcodeConfirmEntry.setText("");
        }
    }

    public void cancel (@SuppressWarnings("UnusedParameters") View view) {
        finish();
    }

    private boolean passcodeMatches () {
        String passcode = passcodeEntry.getText().toString();
        String passcodeConfirm = passcodeConfirmEntry.getText().toString();
        return (passcode.length() > 0 && passcode.equals(passcodeConfirm));
    }
}
