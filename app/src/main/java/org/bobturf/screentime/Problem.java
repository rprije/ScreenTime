package org.bobturf.screentime;

import android.content.Context;
import android.view.View;

import java.util.Random;

/**
 * Created by rprije on 8/1/16.
 */
public abstract class Problem {

    abstract String getProblemName();

    protected Integer parseIntegerSolution(String solution) throws BadUserInputException {
        Integer parsedInt;
        try {
            parsedInt = Integer.parseInt(solution);
        }
        catch (NumberFormatException nfe) {
            throw new BadUserInputException();
        }

        return parsedInt;
    }

    abstract View represent (Context context);

    abstract boolean checkSolution (String solution) throws BadUserInputException;

    abstract Integer getValue();

}
