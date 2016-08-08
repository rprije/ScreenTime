package org.bobturf.screentime;

/**
 * Created by rprije on 8/1/16.
 *
 * A problem representing simple addition of two integers within bounds
 */
public class SingleDigitMultiplication extends Multiplication {

    SingleDigitMultiplication() {
        initialise(0,10);
    }

    @Override
    String getProblemName() {
        return "Single Digit Multiplication";
    }

    @Override
    Integer getValue() {
        return 5;
    }
}
