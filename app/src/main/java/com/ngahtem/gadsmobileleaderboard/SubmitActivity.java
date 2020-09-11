package com.ngahtem.gadsmobileleaderboard;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.view.View;

public class SubmitActivity extends AppCompatActivity implements AlertDialogClass.NoticeDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

//            getSupportActionBar().setLogo(R.drawable.gads);
//            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

    }

    @Override
    public void onSubmitProjectButtonClick(DialogFragment dialog) {

    }
}
