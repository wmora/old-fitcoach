package com.nispok.fitcoach.events;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class BusProviderTest {

    @Test
    public void testBusProviderShouldProvideInstanceOfFitCoachBus() {
        assertNotNull(BusProvider.bus());
    }

}
