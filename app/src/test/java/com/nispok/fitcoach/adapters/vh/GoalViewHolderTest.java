package com.nispok.fitcoach.adapters.vh;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.models.Goal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class GoalViewHolderTest {

    private TestGoalViewHolder goalViewHolder;

    /**
     * Extension of {@link com.nispok.fitcoach.adapters.vh.GoalViewHolder} with helper methods for
     * testing purposes
     */
    private static class TestGoalViewHolder extends GoalViewHolder {

        public TestGoalViewHolder(View itemView) {
            super(itemView);
        }

        public TextView getGoalName() {
            return goalName;
        }
    }

    @Before
    public void setUp() {
        createGoalViewHolder();
    }

    private void createGoalViewHolder() {
        View view = LayoutInflater.from(Robolectric.application).inflate(R.layout.vh_goal, null);
        goalViewHolder = new TestGoalViewHolder(view);
    }

    @Test
    public void testGoalViewHolderShouldSetGoalNameOnInitialization() {
        assertNotNull(goalViewHolder.getGoalName());
    }

    @Test
    public void testGoalViewHolderUpdateShouldSetGoalName() {
        Goal goalMock = new Goal();
        goalMock.setName("Test name");

        goalViewHolder.update(goalMock);

        TextView goalName = goalViewHolder.getGoalName();
        assertTrue(goalName.getText().toString().equals("Test name"));
    }
}
