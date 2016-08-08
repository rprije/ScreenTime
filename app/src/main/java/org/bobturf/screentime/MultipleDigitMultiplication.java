package org.bobturf.screentime;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class MultipleDigitMultiplication extends Addition {

    MultipleDigitMultiplication() {
        initialise(0,115);
    }

    @Override
    String getProblemName() {
        return "Multiple Digit Multiplication";
    }

    @Override
    Integer getValue() {
        return 30;
    }
}
