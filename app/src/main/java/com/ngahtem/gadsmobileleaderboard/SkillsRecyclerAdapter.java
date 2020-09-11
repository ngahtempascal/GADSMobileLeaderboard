package com.ngahtem.gadsmobileleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<SkillsModel> mSkillsModelList;

    public SkillsRecyclerAdapter(Context context, List<SkillsModel> skillsList){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mSkillsModelList = skillsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.skills_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillsModel skillsModel = mSkillsModelList.get(position);
        holder.skillIQ.setText(skillsModel.getScore() + " skill IQ score, " + skillsModel.getCountry());
        holder.skillLearnerName.setText(skillsModel.getName());
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView skillLearnerName;
        public final TextView skillIQ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            skillLearnerName = itemView.findViewById(R.id.skill_learner_name);
            skillIQ = itemView.findViewById(R.id.text_skill_iq);
        }
    }
}
