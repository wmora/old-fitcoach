package com.nispok.fitcoach.services;

import com.nispok.fitcoach.databases.FitCoachDatabase;
import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.GoalNotification;
import com.nispok.fitcoach.models.Time;
import com.raizlabs.android.dbflow.config.FlowManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class GoalServiceTest {

    private Goal goalMock;

    @Before
    public void setUp() {
        FlowManager.init(Robolectric.application);
        FlowManager.getDatabase(FitCoachDatabase.NAME).getWritableDatabase().acquireReference();
    }

    @After
    public void tearDown() {
        FlowManager.getDatabase(FitCoachDatabase.NAME).getWritableDatabase().releaseReference();
        FlowManager.getDatabase(FitCoachDatabase.NAME).reset(Robolectric.application);
        FlowManager.destroy();
    }

    private void createGoalMock() {
        Time time = new Time();
        time.setMinute(0);
        time.setHour(12);
        GoalNotification notification = new GoalNotification();
        notification.setTitle("Notification title");
        notification.setMessage("Notification message");
        notification.setTime(time);
        goalMock = new Goal();
        goalMock.setName("Test name");
        goalMock.setValue(10.0);
        goalMock.setNotification(notification);
        goalMock.save(false);
    }

    @Test
    public void testGetGoalWithValidIdShouldReturnGoal() {
        createGoalMock();

        long validId = goalMock.getId();

        Goal goal = GoalService.get(validId);

        assertNotNull(goal);
        assertEquals(goal.getId(), goalMock.getId());
        assertEquals(goal.getValue(), goalMock.getValue());
        assertEquals(goal.getName(), goalMock.getName());
        assertEquals(goal.getNotification(), goalMock.getNotification());
    }

    @Test
    public void testGetGoalWithInvalidIdShouldReturnNull() {
        assertNull(GoalService.get(1l));
    }

    public void testGetAllShouldReturnAllStoredGoals() {
        int numberOfGoals = 3;

        for (int i = 0; i < numberOfGoals; i++) {
            createGoalMock();
        }

        List<Goal> goals = GoalService.getAll();

        assertEquals(goals.size(), numberOfGoals);
    }

    public void testGetAllWithoutStoredGoalsShouldReturnEmptyList() {
        List<Goal> goals = GoalService.getAll();

        assertNotNull(goals);
        assertTrue(goals.isEmpty());
    }

}
