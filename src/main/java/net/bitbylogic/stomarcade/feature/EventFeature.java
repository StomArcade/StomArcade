package net.bitbylogic.stomarcade.feature;

import net.minestom.server.MinecraftServer;
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
        MinecraftServer.getGlobalEventHandler().addChild(node);
    }

    @Override
    public void onDisable() {
        MinecraftServer.getGlobalEventHandler().removeChild(node);
    }

    public EventNode<Event> node() {
        return node;
    }

}
