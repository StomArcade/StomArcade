package net.bitbylogic.stomarcade.feature.impl;

import net.bitbylogic.stomarcade.StomArcadeServer;
import net.bitbylogic.stomarcade.command.SetSpawnCommand;
import net.bitbylogic.stomarcade.command.SpawnCommand;
import net.bitbylogic.stomarcade.feature.EventFeature;
import net.bitbylogic.stomarcade.util.position.PositionUtil;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.player.PlayerLoadedEvent;

public class SpawnFeature extends EventFeature {

    private final SpawnCommand spawnCommand = new SpawnCommand();
    private final SetSpawnCommand setSpawnCommand = new SetSpawnCommand();

    public SpawnFeature() {
        super("spawn");

        config().addDefault("Spawn-Position", PositionUtil.serialize(Pos.ZERO));
        saveConfig();

        node().addListener(PlayerLoadedEvent.class, event ->
                event.getPlayer().teleport(PositionUtil.deserialize(config().getString("Spawn-Position"))));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        MinecraftServer.getCommandManager().register(spawnCommand, setSpawnCommand);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        MinecraftServer.getCommandManager().unregister(spawnCommand);
        MinecraftServer.getCommandManager().unregister(setSpawnCommand);
    }

    public void setSpawnPosition(Pos pos) {
        config().set("Spawn-Position", PositionUtil.serialize(pos));
        saveConfig();
    }

    public Pos spawnPosition() {
        return PositionUtil.deserialize(config().getString("Spawn-Position"));
    }

}
