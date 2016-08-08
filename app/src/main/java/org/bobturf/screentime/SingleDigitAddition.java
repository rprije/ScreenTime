package org.bobturf.screentime;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class SingleDigitAddition extends Addition {

    SingleDigitAddition() {
        initialise(0,10);
    }

    @Override
    String getProblemName() {
        return "Single Digit Addition";
    }

    @Override
    Integer getValue() {
        return 1;
    }
}
