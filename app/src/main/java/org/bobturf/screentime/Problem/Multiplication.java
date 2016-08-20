package org.bobturf.screentime.Problem;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import org.bobturf.screentime.Exception.BadUserInput;
import org.bobturf.screentime.Util;

/**
 * Created by rprije on 8/6/16.
 */
public abstract class Multiplication extends Problem {

    private Integer xVal;
    private Integer yVal;

    void initialise(Integer lowerBound, Integer upperBound) {
        xVal = Util.randInt(lowerBound, upperBound);
        yVal = Util.randInt(lowerBound, upperBound);
    }

    @Override
    public boolean checkSolution(String solution) throws BadUserInput {
        return parseIntegerSolution(solution) == xVal * yVal;
    }

    @Override
    public View represent (Context context) {
        String text = String.format("%d x %d =", xVal, yVal);
        TextView view = new TextView(context);
        view.setText(text);
        return view;
    }

}
