package com.ngahtem.gadsmobileleaderboard;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataManager {

    private static DataManager mDataManager = null;
    private List<LearnerHourModel> mlearnerHours;
    private List<SkillsModel> mSkillsModels;

    private DataManager(){

    }

    public static DataManager getInstance(){
        if(mDataManager == null){
            mDataManager = new DataManager();
        }
        return mDataManager;
    }

    public List<LearnerHourModel> getMlearnerHours() {
        return mlearnerHours;
    }

    public void setMlearnerHours(List<LearnerHourModel> learnerHours) {
        this.mlearnerHours = learnerHours;
        Collections.sort(mlearnerHours, new Comparator<LearnerHourModel>() {
            @Override
            public int compare(LearnerHourModel o1, LearnerHourModel o2) {
                return o2.getHours() - o1.getHours();
            }
        });
    }

    public List<SkillsModel> getSkillsModels() {
        return mSkillsModels;
    }

    public void setSkillsModels(List<SkillsModel> skillsModels) {
        mSkillsModels = skillsModels;
        Collections.sort(mSkillsModels, new Comparator<SkillsModel>() {
            @Override
            public int compare(SkillsModel o1, SkillsModel o2) {
                return o2.getScore() - o1.getScore();
            }
        });
    }
}
