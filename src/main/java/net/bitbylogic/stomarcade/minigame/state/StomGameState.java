package net.bitbylogic.stomarcade.minigame.state;

import java.time.Duration;

public abstract class StomGameState implements GameState {

    private final String id;
    private final Duration duration;

    private boolean paused;

    public StomGameState(String id, Duration duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean isPaused() {
        return paused;
    }

    @Override
    public Duration stateDuration() {
        return duration;
    }

    @Override
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

}
