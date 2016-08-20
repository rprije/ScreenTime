package org.bobturf.screentime.Problem;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class MultipleDigitMultiplication extends Addition {

    public MultipleDigitMultiplication() {
        initialise(0,115);
    }

    @Override
    public String getProblemName() {
        return "Multiple Digit Multiplication";
    }

}
