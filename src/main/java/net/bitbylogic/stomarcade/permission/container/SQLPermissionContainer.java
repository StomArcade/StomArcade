package net.bitbylogic.stomarcade.permission.container;

import net.bitbylogic.stomarcade.permission.database.PermissionPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class SQLPermissionContainer implements PermissionContainer {

    private final PermissionPlayer permissionPlayer;

    public SQLPermissionContainer(@NotNull PermissionPlayer permissionPlayer) {
        this.permissionPlayer = permissionPlayer;
    }

    @Override
    public boolean has(@NotNull String permission) {
        if (!permissionPlayer.permissions().containsKey(permission)) {
            return false;
        }

        return permissionPlayer.permissions().get(permission);
    }

    @Override
    public void set(@NotNull String permission, boolean value) {
        permissionPlayer.permissions().put(permission.toLowerCase(), value);
    }

    @Override
    public void unset(@NotNull String permission) {
        permissionPlayer.permissions().remove(permission.toLowerCase());
    }

    @Override
    public Set<String> all() {
        return Set.copyOf(permissionPlayer.permissions().keySet());
    }

}
