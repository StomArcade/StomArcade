package net.bitbylogic.stomarcade.minigame.state;

import net.bitbylogic.stomarcade.minigame.Minigame;
import net.bitbylogic.stomarcade.minigame.state.impl.EndingState;
import net.bitbylogic.stomarcade.minigame.state.impl.InGameState;
import net.bitbylogic.stomarcade.minigame.state.impl.LobbyState;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;

public interface GameState {

    List<GameState> DEFAULTS = List.of(new LobbyState(Duration.ofSeconds(30)), new InGameState(Duration.ofMinutes(20)), new EndingState(Duration.ofSeconds(5)));
    Duration INFINITE = Duration.ofNanos(-1);

    String id();

    boolean isPaused();

    Duration stateDuration();

    void setPaused(boolean paused);

    void onStart(@NotNull Minigame minigame);

    void onTick(@NotNull Minigame minigame);

    void onEnd(@NotNull Minigame minigame);

}
