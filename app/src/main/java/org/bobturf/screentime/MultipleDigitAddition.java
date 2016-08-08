package org.bobturf.screentime;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class MultipleDigitAddition extends Addition {

    MultipleDigitAddition() {
        initialise(0,115);
    }

    @Override
    String getProblemName() {
        return "Multiple Digit Addition";
    }

    @Override
    Integer getValue() {
        return 10;
    }
}
