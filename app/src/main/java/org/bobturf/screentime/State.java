package org.bobturf.screentime;

import android.support.annotation.NonNull;
import android.util.Log;

import org.bobturf.screentime.Exception.ProblemsAlreadyComplete;
import org.bobturf.screentime.Exception.AlreadyHaveProblems;
import org.bobturf.screentime.Problem.*;

import java.util.LinkedList;

// TODO: Add NonNull stuff

// TODO: Add logs and stats tracking

/**
 * Created by rprije on 8/7/16.
 */
public class State {
    private Integer tokensEarned = 0;
    @NonNull private LinkedList<Problem> problemQueue = new LinkedList<Problem>();
    private Integer problemSetValue = 100;

    public final static String STATE = "org.bobturf.ScreenTime.STATE";

    public State() {

    }

    public void earnTokens (Integer tokens) {
        tokensEarned += tokens;
    }

    public Integer getTokensEarned () {
        return tokensEarned;
    }

    public void reset () {
        tokensEarned = 0;
        problemQueue = new LinkedList<Problem>();
    }

    private Problem generateProblem() {
        Integer i = Util.randInt(0,3);

        switch (i) {
            case 0 :
                return new MultipleDigitAddition();
            case 1 :
                return new MultipleDigitSubtraction();
            case 2 :
                return new SingleDigitMultiplication();
        }
        assert false;
        return null;
    }

    public Problem nextProblem() throws ProblemsAlreadyComplete {
        Problem p = problemQueue.peek();
        if (p == null) {
            throw new ProblemsAlreadyComplete();
        } else {
            return p;
        }

    }

    public void skipProblem() {
        Problem p = problemQueue.poll();
        if (p != null) {
            problemQueue.add(p);
        }
    }

    public void problemCompleted() {
        Problem p = problemQueue.poll();
        if (p != null && numProblemsRemaining() == 0) {
            earnTokens(problemSetValue);
        }
    }

    public void generateProblems (int numProblems) throws AlreadyHaveProblems {
        if (problemQueue.isEmpty()) {
            for (int i = numProblems; i > 0; i--) {

            }
        } else {
            throw new AlreadyHaveProblems();
        }
    }

    public int numProblemsRemaining () {
        return problemQueue.size();
    }

    public Integer getProblemSetValue() {
        return problemSetValue;
    }
}
