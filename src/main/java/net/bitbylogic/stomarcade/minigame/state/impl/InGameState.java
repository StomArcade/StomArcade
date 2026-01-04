package net.bitbylogic.stomarcade.minigame.state.impl;

import net.bitbylogic.stomarcade.minigame.Minigame;
import net.bitbylogic.stomarcade.minigame.state.StomGameState;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

public class InGameState extends StomGameState {

    public InGameState(Duration duration) {
        super("in_game", duration);
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
