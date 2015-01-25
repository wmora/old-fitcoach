package com.nispok.fitcoach.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.models.Goal;

public class GoalDialogFragment extends DialogFragment {

    public static final String TAG = GoalDialogFragment.class.getSimpleName();

    private static final String EXTRA_GOAL = "EXTRA_GOAL";

    private EditText goalInput;
    private View okButton;
    private Goal goal;

    private GoalDialogFragmentInterface listener;

    public interface GoalDialogFragmentInterface {
        public void onGoalChanged(Goal goal);
    }

    /**
     * Builds a {@link com.nispok.fitcoach.dialogs.GoalDialogFragment} with a
     * {@link com.nispok.fitcoach.models.Goal}. All instances of this class should be created with
     * this method
     *
     * @param goal {@link com.nispok.fitcoach.models.Goal} to be edited
     * @return an instance of {@link com.nispok.fitcoach.dialogs.GoalDialogFragment}
     */
    public static GoalDialogFragment newInstance(Goal goal) {
        GoalDialogFragment fragment = new GoalDialogFragment();

        Bundle args = new Bundle();
        args.putSerializable(EXTRA_GOAL, goal);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (GoalDialogFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + GoalDialogFragmentInterface.class.getSimpleName());
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_goal, null);

        if (getArguments() != null) {
            goal = (Goal) getArguments().getSerializable(EXTRA_GOAL);
        }

        setUpButtons(view);
        setUpGoalInput(view);

        builder.setView(view);

        return builder.create();
    }

    private void setUpGoalInput(View view) {
        goalInput = (EditText) view.findViewById(R.id.goal_input);
        goalInput.addTextChangedListener(new GoalInputTextWatcher());

        goalInput.setText(goal.getValue() > 0 ? String.valueOf(goal.getValue()) : "");
    }

    private void setUpButtons(View view) {
        setUpOkButton(view);
        setUpCancelButton(view);
    }

    private void setUpOkButton(View view) {
        okButton = view.findViewById(R.id.dialog_ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goal.setValue(Integer.parseInt(goalInput.getText().toString()));
                listener.onGoalChanged(goal);
                GoalDialogFragment.this.dismiss();
            }
        });
    }

    private void setUpCancelButton(View view) {
        TextView cancel = (TextView) view.findViewById(R.id.dialog_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoalDialogFragment.this.dismiss();
            }
        });
    }

    /**
     * Basic {@link android.text.TextWatcher} that validates if the input value is not empty and
     * greater than zero
     */
    private class GoalInputTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Nothing to do here
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Nothing to do here
        }

        @Override
        public void afterTextChanged(Editable s) {
            String value = s.toString();
            okButton.setEnabled(!value.isEmpty() && Integer.parseInt(value) > 0);
        }
    }

}
