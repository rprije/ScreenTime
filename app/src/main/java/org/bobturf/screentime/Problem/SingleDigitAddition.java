package org.bobturf.screentime.Problem;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class SingleDigitAddition extends Addition {

    public SingleDigitAddition() {
        initialise(0,10);
    }

    @Override
    public String getProblemName() {
        return "Single Digit Addition";
    }

}
