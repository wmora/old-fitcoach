package com.nispok.fitcoach.events;

/**
 * Events to be used with {@link com.nispok.fitcoach.events.FitCoachBus}
 *
 * @param <T> type of object to be returned for this implementation
 */
public abstract class Event<T> {

    protected T result;

    public Event(T result) {
        this.result = result;
    }

    /**
     * @return instance of {@link T} provided as a result of this
     * {@link com.nispok.fitcoach.events.Event}
     */
    public T getResult() {
        return result;
    }

}
