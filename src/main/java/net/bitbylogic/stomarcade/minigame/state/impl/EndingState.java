package net.bitbylogic.stomarcade.minigame.state.impl;

import net.bitbylogic.stomarcade.minigame.Minigame;
import net.bitbylogic.stomarcade.minigame.state.StomGameState;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class EndingState extends StomGameState {

    public EndingState(Duration duration) {
        super("ending", duration);
    }

    @Override
    public void onStart(@NotNull Minigame minigame) {

    }

    @Override
    public void onTick(@NotNull Minigame minigame) {

    }

    @Override
    public void onEnd(@NotNull Minigame minigame) {

    }

}
