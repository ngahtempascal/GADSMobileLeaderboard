package com.ngahtem.gadsmobileleaderboard;

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

    public void setMlearnerHours(List<LearnerHourModel> mlearnerHours) {
        this.mlearnerHours = mlearnerHours;
//        this.mlearnerHours.sort(new Comparator<LearnerHourModel>() {
//            @Override
//            public int compare(LearnerHourModel o1, LearnerHourModel o2) {
//                return o1.getHours() - o2.getHours();
//            }
//        });
    }

    public List<SkillsModel> getSkillsModels() {
        return mSkillsModels;
    }

    public void setSkillsModels(List<SkillsModel> skillsModels) {
        mSkillsModels = skillsModels;
    }
}
