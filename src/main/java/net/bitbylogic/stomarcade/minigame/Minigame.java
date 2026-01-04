package net.bitbylogic.stomarcade.minigame;

import net.bitbylogic.stomarcade.minigame.state.GameStateManager;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import org.jetbrains.annotations.NotNull;

public interface Minigame {

    @NotNull String id();

    void onLoad();

    void onStart();

    void onEnd();

    @NotNull EventNode<Event> node();

    @NotNull GameStateManager stateManager();

}
