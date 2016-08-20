package org.bobturf.screentime.Exception;

/**
 * Created by rprije on 8/20/16.
 *
 * Used effectively as an assertion. Throw this when we expect to never reach this code.
 */

public class ShouldBeImpossible extends RuntimeException {
    public ShouldBeImpossible() {}
}
