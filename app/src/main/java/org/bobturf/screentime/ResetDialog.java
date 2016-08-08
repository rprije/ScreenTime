package org.bobturf.screentime;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by rprije on 8/7/16.
 */
public class ResetDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.reset_confirm_question)
                .setPositiveButton(R.string.reset_proceed, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ScreenTimeApplication app = (ScreenTimeApplication) getActivity().getApplicationContext();
                        app.getState().reset();
                    }
                })
                .setNegativeButton(R.string.reset_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }
}
