package com.ngahtem.gadsmobileleaderboard;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AlertDialogClass extends DialogFragment {

    private String dialogToShow;
    private DialogFragment mDialog = this;

    public String getDialogToShow() {
        return dialogToShow;
    }

    public void setDialogToShow(String dialogToShow) {
        this.dialogToShow = dialogToShow;
    }

    public AlertDialogClass(String dialogToShow) {
        super();
        this.dialogToShow = dialogToShow;
    }

    public interface NoticeDialogListener {
        public void onSubmitProjectButtonClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener listener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view;
        switch (dialogToShow) {
            case "SUBMIT_PROJECT_DIALOG":
                view = inflater.inflate(R.layout.confirm_poject_submission_dialog, null);
                break;
            case "PROJECT_SUBMISSION_SUCCESSFUL":
                view = inflater.inflate(R.layout.project_submit_success, null);
                break;

            case "PROJECT_SUBMISSION_FAILED":
                view = inflater.inflate(R.layout.project_submit_failure, null);
                break;
            default:
                view = null;
        }

        if (dialogToShow == "SUBMIT_PROJECT_DIALOG") {
            Button button = view.findViewById(R.id.button_confirm_project_submission);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSubmitProjectButtonClick(mDialog);
                }
            });
        }
        builder.setView(view);
        return builder.create();
    }

}
