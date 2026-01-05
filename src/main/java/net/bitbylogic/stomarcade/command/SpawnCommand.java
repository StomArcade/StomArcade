package net.bitbylogic.stomarcade.command;

import net.bitbylogic.stomarcade.StomArcadeServer;
import net.bitbylogic.stomarcade.feature.Feature;
import net.bitbylogic.stomarcade.feature.ServerFeature;
import net.bitbylogic.stomarcade.feature.impl.SpawnFeature;
import net.bitbylogic.stomarcade.permission.command.PermissionedCommand;
import net.bitbylogic.stomarcade.util.message.MessageUtil;
import net.kyori.adventure.sound.Sound;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.entity.Player;
import net.minestom.server.sound.SoundEvent;

public class SpawnCommand extends PermissionedCommand {

    public SpawnCommand() {
        super("spawn");

        setPermission("stomarcade.spawn");

        setDefaultExecutor((sender, _) -> {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Console cannot run this command.");
                return;
            }

            Feature feature = StomArcadeServer.features().getFeature(ServerFeature.SPAWN.feature().id());

            if (!(feature instanceof SpawnFeature spawnFeature)) {
                sender.sendMessage(MessageUtil.error("Spawn feature is not enabled!"));
                return;
            }

            player.teleport(spawnFeature.spawnPosition(), Vec.ZERO);
            player.playSound(Sound.sound(SoundEvent.ENTITY_ENDERMAN_TELEPORT, Sound.Source.MASTER, 1, 1));

            player.sendMessage(MessageUtil.success("Teleported to spawn!"));
        });
    }

}
