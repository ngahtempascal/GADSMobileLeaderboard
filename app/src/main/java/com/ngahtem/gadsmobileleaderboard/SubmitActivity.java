package com.ngahtem.gadsmobileleaderboard;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonElement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;

public class SubmitActivity extends AppCompatActivity implements AlertDialogClass.NoticeDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

//            getSupportActionBar().setLogo(R.drawable.gads);
//            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

    }

    @Override
    public void onSubmitProjectButtonClick(DialogFragment dialog) {
        API api = new API("https://docs.google.com/forms/d/e/");
        final FirstFragment firstFragment = (FirstFragment) dialog.getParentFragment();
        if(firstFragment != null){
            System.out.println("first name: " + firstFragment.getFirstName() + " lastname: " + firstFragment.getLastName() +
                    " email: " + firstFragment.getEmail() + " proj link: " + firstFragment.getSubmitProjectLink());
            api.submit(this, firstFragment.getFirstName(), firstFragment.getLastName(),
                    firstFragment.getEmail(), firstFragment.getSubmitProjectLink(),
                    new API.RequestListener<JsonElement>() {
                        @Override
                        public void onSuccess(JsonElement response) {
                            System.out.println("submission successful");
                            firstFragment.showProjectSubmitSuccessDialog();
                        }

                        @Override
                        public void onResponse() {

                        }

                        @Override
                        public void onError() {
                            System.out.println("failure on submission");
                            firstFragment.showProjectSubmitFailureDialog();
                        }
                    });
        }

    }
}
