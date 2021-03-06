package org.bobturf.screentime;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import org.bobturf.screentime.Exception.ProblemsAlreadyComplete;
import org.bobturf.screentime.Exception.AlreadyHaveProblems;
import org.bobturf.screentime.Exception.ShouldBeImpossible;
import org.bobturf.screentime.Problem.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

// TODO: Add NonNull stuff

// TODO: Add logs and stats tracking

/**
 * Created by rprije on 8/7/16.
 *
 * State accessible throughout the app
 */
class State {
    SharedPreferences preferences;

    private Integer tokensEarned;
    private Constructor problemConstructors[];

    private String passcode;

    private final String tokensEarnedKey = "TOKENS_EARNED";
    private final String passcodeKey = "PASSCODE";

    @NonNull private LinkedList<Problem> problemQueue = new LinkedList<>();
    private final Integer problemSetValue = 1;

    State() {
        try {
            Class emptyParams[] = new Class[] {};
            problemConstructors = new Constructor[] {
                    MultipleDigitAddition.class.getConstructor(emptyParams),
                    MultipleDigitSubtraction.class.getConstructor(emptyParams),
                    SingleDigitMultiplication.class.getConstructor(emptyParams)
            };
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new ShouldBeImpossible();
        }

    }

    void load(Context context) {
        preferences = context.getSharedPreferences(context.getString(R.string.preferences_file), Context.MODE_PRIVATE);
        tokensEarned = preferences.getInt(tokensEarnedKey, 0);
        passcode = preferences.getString(passcodeKey, "");
    }

    private void savePreference (String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void savePreference (String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private void saveTokens() {
        savePreference(tokensEarnedKey,tokensEarned);
    }

    private void earnTokens (Integer tokens) {
        tokensEarned += tokens;
        saveTokens ();
    }

    Integer getTokensEarned () {
        return tokensEarned;
    }

    void reset () {
        tokensEarned = 0;
        saveTokens();
        problemQueue = new LinkedList<>();
    }

    private Problem generateProblem() {
        Integer i = Util.randInt(0, problemConstructors.length);

        try {
            return (Problem)problemConstructors[i].newInstance();
        } catch (InvocationTargetException|InstantiationException|IllegalAccessException ex) {
            throw new ShouldBeImpossible();
        }
    }

    Problem nextProblem() throws ProblemsAlreadyComplete {
        Problem p = problemQueue.peek();
        if (p == null) {
            throw new ProblemsAlreadyComplete();
        } else {
            return p;
        }

    }

    void skipProblem() {
        Problem p = problemQueue.poll();
        if (p != null) {
            problemQueue.add(p);
        }
    }

    void problemCompleted() {
        Problem p = problemQueue.poll();
        if (p != null && numProblemsRemaining() == 0) {
            earnTokens(problemSetValue);
        }
    }

    void generateProblems (int numProblems) throws AlreadyHaveProblems {
        if (problemQueue.isEmpty()) {
            for (int i = numProblems; i > 0; i--) {
                problemQueue.add(generateProblem());
            }
        } else {
            throw new AlreadyHaveProblems();
        }
    }

    int numProblemsRemaining () {
        return problemQueue.size();
    }

    boolean passcodeIsSet () {
        return (passcode != null && passcode.length() > 0);
    }

    boolean checkPasscode (String passcodeAttempt) {
        return (passcode.equals(passcodeAttempt));
    }

    void changePasscode (String newPassCode) {
        passcode = newPassCode;
        savePreference(passcodeKey,passcode);
    }

}
