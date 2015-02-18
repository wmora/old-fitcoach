package com.nispok.fitcoach.events;

/**
 * Holds the shared event bus used for this application
 */
public class BusProvider {

    private static FitCoachBus BUS = new FitCoachBus();

    /**
     * @return the instance of {@link com.nispok.fitcoach.events.FitCoachBus} that is shared across
     * this app
     */
    public static FitCoachBus bus() {
        return BUS;
    }

    private BusProvider() {
    }
}
