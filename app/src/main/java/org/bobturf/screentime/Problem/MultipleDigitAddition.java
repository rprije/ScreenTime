package org.bobturf.screentime.Problem;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class MultipleDigitAddition extends Addition {

    public MultipleDigitAddition() {
        initialise(0,115);
    }

    @Override
    public String getProblemName() {
        return "Multiple Digit Addition";
    }

}
