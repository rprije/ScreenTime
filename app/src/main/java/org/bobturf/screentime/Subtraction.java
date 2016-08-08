package org.bobturf.screentime;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rprije on 8/6/16.
 */
public abstract class Subtraction extends Problem {

    protected Integer xVal;
    protected Integer yVal;

    protected void initialise(Integer lowerBound, Integer upperBound) {
        xVal = Util.randInt(lowerBound, upperBound);
        yVal = Util.randInt(lowerBound, upperBound);
    }

    @Override
    boolean checkSolution(String solution) throws IllegalArgumentException {
        return Integer.parseInt(solution) == xVal - yVal;
    }

    @Override
    View represent (Context context) {
        String text = String.format("%d - %d =", xVal, yVal);
        TextView view = new TextView(context);
        view.setText(text);
        return view;
    }

}
