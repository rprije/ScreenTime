package org.bobturf.screentime;

/**
 * Created by rprije on 8/7/16.
 */
public class State {
    Integer tokensEarned = 0;
    public final static String STATE = "org.bobturf.ScreenTime.STATE";

    public State() {

    }

    public void earnTokens (Integer tokens) {
        tokensEarned += tokens;
    }

    public Integer getTokensEarned () {
        return tokensEarned;
    }

    public void reset () {
        tokensEarned = 0;
    }
}
