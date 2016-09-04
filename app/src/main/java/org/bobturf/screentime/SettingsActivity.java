package org.bobturf.screentime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;

// TODO: Everything reachable under here should know whether we're authenticated and if not, go back to the AuthActivity

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void changePasscode(@SuppressWarnings("UnusedParameters") View view) {
        Intent intent = new Intent(this, ChangePasscodeActivity.class);
        startActivity(intent);
    }
}
