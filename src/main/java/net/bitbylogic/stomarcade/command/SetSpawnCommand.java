package net.bitbylogic.stomarcade.command;

import net.bitbylogic.stomarcade.StomArcadeServer;
import net.bitbylogic.stomarcade.feature.Feature;
import net.bitbylogic.stomarcade.feature.ServerFeature;
import net.bitbylogic.stomarcade.feature.impl.SpawnFeature;
import net.bitbylogic.stomarcade.permission.command.PermissionedCommand;
import net.bitbylogic.stomarcade.util.message.MessageUtil;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand extends PermissionedCommand {

    public SetSpawnCommand() {
        super("setspawn");

        setPermission("stomarcade.setspawn");

        setDefaultExecutor(((sender, context) -> {
            if (!(sender instanceof Player player)) {
                sender.sendMessage("Console cannot use this command.");
                return;
            }

            Feature feature = StomArcadeServer.features().getFeature(ServerFeature.SPAWN.feature().id());

            if (!(feature instanceof SpawnFeature spawnFeature)) {
                player.sendMessage(MessageUtil.error("Spawn feature is not enabled!"));
                return;
            }

            spawnFeature.setSpawnPosition(player.getPosition());
            player.sendMessage(MessageUtil.success("Spawn position set!"));
        }));
    }

}
