package com.nispok.fitcoach.intents;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RequestCodeTest {

    @Test
    public void testWaterReminderRequestCodeShouldBe1000() {
        assertEquals(RequestCode.WATER_REMINDER, 1000);
    }

}
