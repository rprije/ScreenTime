package org.bobturf.screentime;

import java.util.Random;

/**
 * Created by rprije on 8/7/16.
 */
public class Util {


    protected static int randInt(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }
}
