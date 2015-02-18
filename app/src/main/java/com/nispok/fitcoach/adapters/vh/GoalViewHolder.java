package com.nispok.fitcoach.adapters.vh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.models.Goal;

public class GoalViewHolder extends RecyclerView.ViewHolder {

    protected TextView goalName;

    public GoalViewHolder(View itemView) {
        super(itemView);
        goalName = (TextView) itemView.findViewById(R.id.goal_name);
    }

    public void update(Goal goal) {
        goalName.setText(goal.getName());
    }
}
