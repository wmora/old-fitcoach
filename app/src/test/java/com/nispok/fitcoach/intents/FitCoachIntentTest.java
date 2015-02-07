package com.nispok.fitcoach.intents;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FitCoachIntentTest {

    @Test
    public void testWaterReminderRequestCodeShouldBe1000() {
        assertEquals(FitCoachIntent.RequestCode.WATER_REMINDER, 1000);
    }

    @Test
    public void testGoalExtraShouldBeGOAL() {
        assertEquals(FitCoachIntent.Extra.GOAL, "GOAL");
    }

}
