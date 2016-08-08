package org.bobturf.screentime;

import android.content.Context;
import android.view.View;

import java.util.Random;

/**
 * Created by rprije on 8/1/16.
 */
public abstract class Problem {

    abstract String getProblemName();

    abstract View represent (Context context);

    abstract boolean checkSolution (String solution) throws IllegalArgumentException;

    abstract Integer getValue();

}
