package com.ngahtem.gadsmobileleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private Context mContext = this;
    private boolean learnersDataLoaded = false;
    private boolean skillDataLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Controller controller = new Controller();
//        controller.start();

        API api = new API("https://gadsapi.herokuapp.com");
        api.getTopLearnersHours(this, new API.RequestListener<List<LearnerHourModel>>() {
            @Override
            public void onSuccess(List<LearnerHourModel> response) {
//                Log.i("RETROFIT",response.toString());
//                for(LearnerHourModel learnerHourModel: response){
//                    System.out.println("name: " + learnerHourModel.getName() +
//                            ", hours: " + learnerHourModel.getHours()
//                            + ", country: " + learnerHourModel.getCountry());
//                }
                DataManager dm = DataManager.getInstance();
                dm.setMlearnerHours(response);
                learnersDataLoaded = true;
                if(learnersDataLoaded && skillDataLoaded){
                    System.out.println("starting activity from learners request");
                    Intent intent = new Intent(mContext, MainActivity.class);
//                    intent.putExtra(LEARNERS_LIST, response.toString());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onResponse() {

            }

            @Override
            public void onError() {
                System.out.println("error on response");
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });

        api.getTopSkills(this, new API.RequestListener<List<SkillsModel>>() {
            @Override
            public void onSuccess(List<SkillsModel> response) {
                DataManager dm = DataManager.getInstance();
                dm.setSkillsModels(response);
                skillDataLoaded = true;
                if(learnersDataLoaded && skillDataLoaded){
                    System.out.println("starting activity from skills request");
                    Intent intent = new Intent(mContext, MainActivity.class);
//                    intent.putExtra(SKILL_LEARNERS_LIST, response.toString());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onResponse() {

            }

            @Override
            public void onError() {
                System.out.println("error on response");
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });
    }
}
