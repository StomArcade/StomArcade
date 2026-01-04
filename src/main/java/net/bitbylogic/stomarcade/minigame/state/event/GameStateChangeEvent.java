package net.bitbylogic.stomarcade.minigame.state.event;

import net.bitbylogic.stomarcade.minigame.Minigame;
import net.bitbylogic.stomarcade.minigame.state.GameState;
import net.minestom.server.event.trait.AsyncEvent;

public class GameStateChangeEvent implements AsyncEvent {

    private final Minigame minigame;
    private final GameState previousState;
    private final GameState newState;

    public GameStateChangeEvent(Minigame minigame, GameState previousState, GameState newState) {
        this.minigame = minigame;
        this.previousState = previousState;
        this.newState = newState;
    }

    public Minigame minigame() {
        return minigame;
    }

    public GameState previousState() {
        return previousState;
    }

    public GameState newState() {
        return newState;
    }

}
