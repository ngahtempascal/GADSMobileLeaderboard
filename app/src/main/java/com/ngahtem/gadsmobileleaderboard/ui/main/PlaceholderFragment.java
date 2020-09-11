package com.ngahtem.gadsmobileleaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ngahtem.gadsmobileleaderboard.DataManager;
import com.ngahtem.gadsmobileleaderboard.LearnersRecyclerViewAdapter;
import com.ngahtem.gadsmobileleaderboard.R;
import com.ngahtem.gadsmobileleaderboard.SkillsRecyclerAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private RecyclerView mRecyclerView;
    private int mIndex;
    private DataManager dm;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        mIndex = 1;
        if (getArguments() != null) {
            mIndex = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(mIndex);
        dm = DataManager.getInstance();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
//        final TextView textView = root.findViewById(R.id.section_label);
//        pageViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        initializeDisplayContent(root, mIndex);
        return root;
    }

    private void initializeDisplayContent(View root, int position){
        if(position == 1){
            LearnersRecyclerViewAdapter learnersRecyclerViewAdapter
                    = new LearnersRecyclerViewAdapter(this.getContext(), dm.getMlearnerHours());
            mRecyclerView = root.findViewById(R.id.top_learners_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setAdapter(learnersRecyclerViewAdapter);
        }
        else{
            SkillsRecyclerAdapter recyclerAdapter
                    = new SkillsRecyclerAdapter(this.getContext(), dm.getSkillsModels());
            mRecyclerView = root.findViewById(R.id.top_learners_list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            mRecyclerView.setAdapter(recyclerAdapter);
            mRecyclerView.setLayoutManager(layoutManager);
        }
    }
}