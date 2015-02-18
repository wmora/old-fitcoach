package com.nispok.fitcoach.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.activities.GoalSetupActivity;
import com.nispok.fitcoach.adapters.GoalListViewAdapter;
import com.nispok.fitcoach.intents.FitCoachIntent;
import com.nispok.fitcoach.services.GoalService;
import com.nispok.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpGoalList(view);
        setUpAddButton();
    }

    private void setUpGoalList(View view) {
        RecyclerView goalListView = (RecyclerView) view.findViewById(R.id.goal_list);
        goalListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        GoalListViewAdapter adapter = new GoalListViewAdapter(GoalService.getInstance().getAll());
        goalListView.setAdapter(adapter);
    }

    private void setUpAddButton() {
        FloatingActionButton fab = new FloatingActionButton.Builder(getActivity())
                .withColor(getResources().getColor(R.color.accent))
                .withDrawable(getResources().getDrawable(R.mipmap.ic_add))
                .withSize(72)
                .withMargins(0, 0, 16, 16)
                .create();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGoalSetupActivity();
            }
        });
    }

    private void goToGoalSetupActivity() {
        Intent intent = new Intent(getActivity(), GoalSetupActivity.class);
        startActivityForResult(intent, FitCoachIntent.RequestCode.ADD_GOAL);
    }
}
