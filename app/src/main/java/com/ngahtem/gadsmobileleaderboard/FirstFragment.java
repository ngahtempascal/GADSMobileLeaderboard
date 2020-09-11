package com.ngahtem.gadsmobileleaderboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment{

    private TextView mFirstName;
    private TextView mLastName;
    private TextView mEmail;
    private TextView mGithubLink;
    private Button mSubmitButton;
    private static final String SUBMIT_PROJECT = "SUBMIT_PROJECT_DIALOG";
    private static final String PROJECT_SUBMISSION_SUCCESS = "PROJECT_SUBMISSION_SUCCESSFUL";
    private static final String PROJECT_SUBMISSION_FAILURE = "PROJECT_SUBMISSION_FAILED";
    private FragmentManager mFragmentManager;
    private AlertDialogClass mDialog;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mFragmentManager = getChildFragmentManager();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFirstName = view.findViewById(R.id.first_name);
        mFirstName.setPaintFlags(0);
        mLastName = view.findViewById(R.id.last_name);
        mLastName.setPaintFlags(0);
        mEmail = view.findViewById(R.id.email);
        mEmail.setPaintFlags(0);
        mGithubLink = view.findViewById(R.id.project_link);
        mGithubLink.setPaintFlags(0);
        mSubmitButton = view.findViewById(R.id.project_confirm_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog = new AlertDialogClass(SUBMIT_PROJECT);
                mDialog.show(mFragmentManager, SUBMIT_PROJECT);
            }
        });
//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }

    public String getFirstName(){
        return this.mFirstName.getText().toString();
    }

    public String getLastName(){
        return this.mLastName.getText().toString();
    }

    public String getEmail(){
        return (String)this.mEmail.getText().toString();
    }

    public String getSubmitProjectLink(){
        return (String)this.mGithubLink.getText().toString();
    }

    public void showProjectSubmitSuccessDialog(){
        this.mDialog.dismiss();
        this.mDialog = new AlertDialogClass(PROJECT_SUBMISSION_SUCCESS);
        this.mDialog.show(mFragmentManager, PROJECT_SUBMISSION_SUCCESS);

    }

    public void showProjectSubmitFailureDialog(){
        this.mDialog.dismiss();
        this.mDialog = new AlertDialogClass(PROJECT_SUBMISSION_FAILURE);
        this.mDialog.show(mFragmentManager, PROJECT_SUBMISSION_FAILURE);
    }
}
