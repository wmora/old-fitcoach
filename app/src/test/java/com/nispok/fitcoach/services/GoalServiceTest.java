package com.nispok.fitcoach.services;

import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.GoalNotification;
import com.nispok.fitcoach.models.Time;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

@RunWith(RobolectricTestRunner.class)
public class GoalServiceTest {

    private Goal goalMock;

    @After
    public void tearDown() {
        if (goalMock != null) {
            goalMock.delete(false);
        }
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

        Goal goal = GoalService.getInstance().get(validId);

        assertNotNull(goal);
        assertEquals(goal.getId(), goalMock.getId());
        assertEquals(goal.getValue(), goalMock.getValue());
        assertEquals(goal.getName(), goalMock.getName());
        assertEquals(goal.getNotification(), goalMock.getNotification());
    }

    @Test
    public void testGetGoalWithInvalidIdShouldReturnNull() {
        assertNull(GoalService.getInstance().get(1l));
    }

}
