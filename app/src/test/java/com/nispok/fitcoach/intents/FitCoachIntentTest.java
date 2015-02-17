package com.nispok.fitcoach.intents;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FitCoachIntentTest {

    @Test
    public void testWaterReminderRequestCodeShouldBe10000000() {
        assertEquals(FitCoachIntent.RequestCode.ADD_GOAL, 10000000);
    }

    @Test
    public void testGoalIdExtraShouldBeGOAL_ID() {
        assertEquals(FitCoachIntent.Extra.GOAL_ID, "GOAL_ID");
    }

}
