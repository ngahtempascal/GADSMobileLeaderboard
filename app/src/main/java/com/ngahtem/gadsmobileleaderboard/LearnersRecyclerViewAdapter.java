package com.ngahtem.gadsmobileleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LearnersRecyclerViewAdapter extends RecyclerView.Adapter<LearnersRecyclerViewAdapter.LearnersViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<LearnerHourModel> mLearners;

    public LearnersRecyclerViewAdapter(Context context, List<LearnerHourModel> learners){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.mLearners = learners;
    }

    @NonNull
    @Override
    public LearnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.learners_list_item, parent, false);
        return new LearnersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnersViewHolder holder, int position) {
        LearnerHourModel learnerHourModel = mLearners.get(position);
        holder.learningHours.setText(learnerHourModel.getHours() + " learning hours, "
                + learnerHourModel.getCountry());
        holder.learnersName.setText(learnerHourModel.getName());
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class LearnersViewHolder extends RecyclerView.ViewHolder{

        public TextView learnersName;
        public TextView learningHours;
        public LearnersViewHolder(@NonNull View itemView) {
            super(itemView);
            learnersName = itemView.findViewById(R.id.top_learner_name);
            learningHours = itemView.findViewById(R.id.text_learning_hours);
        }
    }
}
