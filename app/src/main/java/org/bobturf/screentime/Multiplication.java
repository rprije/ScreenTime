package org.bobturf.screentime;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rprije on 8/6/16.
 */
public abstract class Multiplication extends Problem {

    protected Integer xVal;
    protected Integer yVal;

    protected void initialise(Integer lowerBound, Integer upperBound) {
        xVal = Util.randInt(lowerBound, upperBound);
        yVal = Util.randInt(lowerBound, upperBound);
    }

    @Override
    boolean checkSolution(String solution) throws BadUserInputException {
        return parseIntegerSolution(solution) == xVal * yVal;
    }

    @Override
    View represent (Context context) {
        String text = String.format("%d x %d =", xVal, yVal);
        TextView view = new TextView(context);
        view.setText(text);
        return view;
    }

}
