package net.bitbylogic.stomarcade.feature;

import org.jetbrains.annotations.NotNull;

public abstract class SimpleFeature implements Feature {

    private final String id;

    public SimpleFeature(@NotNull String id) {
        this.id = id.toLowerCase();
    }

    @Override
    public @NotNull String id() {
        return id;
    }

}
