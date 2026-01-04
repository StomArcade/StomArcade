package net.bitbylogic.stomarcade.minigame;

import net.bitbylogic.stomarcade.minigame.state.GameState;
import net.bitbylogic.stomarcade.minigame.state.GameStateManager;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class StomMinigame implements Minigame {

    private final @NotNull String id;
    private final GameStateManager stateManager;

    protected final Logger logger;
    private final EventNode<Event> node;

    public StomMinigame(@NotNull String id, @NotNull List<GameState> states) {
        this.id = id;
        this.stateManager = new GameStateManager(this, states);

        this.logger = LoggerFactory.getLogger(id);
        this.node = EventNode.all(id);
    }

    @Override
    public @NotNull String id() {
        return id;
    }

    @Override
    public @NotNull EventNode<Event> node() {
        return node;
    }

    @Override
    public @NotNull GameStateManager stateManager() {
        return stateManager;
    }

}
