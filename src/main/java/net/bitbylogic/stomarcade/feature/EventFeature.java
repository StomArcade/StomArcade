package net.bitbylogic.stomarcade.feature;

import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import org.jetbrains.annotations.NotNull;

public abstract class EventFeature extends SimpleFeature {

    private final EventNode<Event> node = EventNode.all(id());

    public EventFeature(@NotNull String id) {
        super(id);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public EventNode<Event> node() {
        return node;
    }

}
