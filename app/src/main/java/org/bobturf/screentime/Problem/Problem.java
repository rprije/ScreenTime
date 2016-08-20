package org.bobturf.screentime.Problem;

import android.content.Context;
import android.view.View;

import org.bobturf.screentime.Exception.BadUserInput;

/**
 * Created by rprije on 8/1/16.
 */
public abstract class Problem {

    public abstract String getProblemName();

    Integer parseIntegerSolution(String solution) throws BadUserInput {
        Integer parsedInt;
        try {
            parsedInt = Integer.parseInt(solution);
        }
        catch (NumberFormatException nfe) {
            throw new BadUserInput();
        }

        return parsedInt;
    }

    public abstract View represent (Context context);

    public abstract boolean checkSolution (String solution) throws BadUserInput;

}
