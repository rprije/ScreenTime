package org.bobturf.screentime;

import android.app.Application;

/**
 * Created by rprije on 8/7/16.
 */
public class ScreenTimeApplication extends Application {
    private State state;

    public ScreenTimeApplication() {
        super();
        state = new State();
    }

    public void putState(State newState) {
        state = newState;
    }

    public State getState() {
        return state;
    }
}
