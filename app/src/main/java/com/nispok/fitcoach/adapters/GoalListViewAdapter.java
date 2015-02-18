package com.nispok.fitcoach.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.adapters.vh.GoalViewHolder;
import com.nispok.fitcoach.models.Goal;

import java.util.List;

public class GoalListViewAdapter extends RecyclerView.Adapter<GoalViewHolder> {

    private List<Goal> dataset;

    public GoalListViewAdapter(List<Goal> dataset) {
        super();
        this.dataset = dataset;
    }

    @Override
    public GoalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.vh_goal, viewGroup, false);
        return new GoalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoalViewHolder goalViewHolder, int i) {
        goalViewHolder.update(dataset.get(i));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
