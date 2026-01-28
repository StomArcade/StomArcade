package net.bitbylogic.stomarcade.permission.manager;

import net.bitbylogic.orm.BormAPI;
import net.bitbylogic.stomarcade.permission.container.PermissionContainer;
import net.bitbylogic.stomarcade.permission.container.PermissionContainerType;
import net.bitbylogic.stomarcade.permission.container.SQLPermissionContainer;
import net.bitbylogic.stomarcade.permission.container.SimplePermissionContainer;
import net.bitbylogic.stomarcade.permission.database.PermissionPlayer;
import net.bitbylogic.stomarcade.permission.database.PermissionPlayerTable;
import net.bitbylogic.stomarcade.util.PermissionUtil;
import net.bitbylogic.utils.EnumUtil;
import net.minestom.server.entity.Player;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerLoadedEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PermissionManager {

    private static final Set<String> REGISTERED_PERMISSIONS = ConcurrentHashMap.newKeySet();

    private final EventNode<Event> node = EventNode.all("permission");

    private final PermissionContainerType containerType;

    private @Nullable PermissionPlayerTable playerTable;

    public PermissionManager(@NotNull BormAPI bormAPI) {
        node.addListener(AsyncPlayerConfigurationEvent.class, this::containerApply)
                .addListener(PlayerLoadedEvent.class, this::loaded);

        containerType = EnumUtil.getValue(PermissionContainerType.class, System.getenv("PERMISSION_CONTAINER_TYPE"), PermissionContainerType.MEMORY);

        if(containerType != PermissionContainerType.SQL) {
            return;
        }

        bormAPI.registerTable(PermissionPlayerTable.class, table -> playerTable = table);
    }

    private void containerApply(AsyncPlayerConfigurationEvent event) {
        Player player = event.getPlayer();

        PermissionContainer container;

        switch (containerType) {
            case SQL -> {
                PermissionPlayer permissionPlayer = playerTable.getDataById(player.getUuid()).orElse(null);

                if(permissionPlayer == null) {
                    permissionPlayer = new PermissionPlayer(player.getUuid(), new HashMap<>());
                    playerTable.add(permissionPlayer);
                }

                container = new SQLPermissionContainer(permissionPlayer);
            }
            default -> container = new SimplePermissionContainer();
        }

        player.setTag(PermissionUtil.PERMISSION_CONTAINER_TAG, container);
    }

    private void loaded(PlayerLoadedEvent event) {
        Player player = event.getPlayer();

        if (player.getPermissionLevel() < 4) {
            return;
        }

        PermissionUtil.set(player, "stomarcade.permission", true);
    }

    public boolean registerPermission(@NotNull String permission) {
        return REGISTERED_PERMISSIONS.add(permission);
    }

    public boolean unregisterPermission(@NotNull String permission) {
        return REGISTERED_PERMISSIONS.remove(permission);
    }

    public Set<String> registeredPermissions() {
        return Set.copyOf(REGISTERED_PERMISSIONS);
    }

    public EventNode<Event> node() {
        return node;
    }

}
