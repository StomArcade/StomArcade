package net.bitbylogic.stomarcade.util;

import net.bitbylogic.stomarcade.permission.container.PermissionContainer;
import net.minestom.server.command.CommandSender;
import net.minestom.server.entity.Player;
import net.minestom.server.tag.Tag;
import org.jetbrains.annotations.NotNull;

public class PermissionUtil {

    public static final Tag<PermissionContainer> PERMISSION_CONTAINER_TAG = Tag.Transient("permission_container");

    public PermissionUtil() {}

    public static boolean has(@NotNull CommandSender sender, @NotNull String permission) {
        if (!sender.hasTag(PERMISSION_CONTAINER_TAG)) {
            return false;
        }

        PermissionContainer container = sender.getTag(PERMISSION_CONTAINER_TAG);
        return container.has(permission);
    }

    public static void set(@NotNull Player player, @NotNull String permission, boolean value) {
        if (!player.hasTag(PERMISSION_CONTAINER_TAG)) {
            return;
        }

        PermissionContainer container = player.getTag(PERMISSION_CONTAINER_TAG);
        container.set(permission, value);
    }

    public static void unset(@NotNull Player player, @NotNull String permission) {
        if (!player.hasTag(PERMISSION_CONTAINER_TAG)) {
            return;
        }

        PermissionContainer container = player.getTag(PERMISSION_CONTAINER_TAG);
        container.unset(permission);
    }

}
