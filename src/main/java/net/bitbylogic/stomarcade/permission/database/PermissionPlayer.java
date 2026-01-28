package net.bitbylogic.stomarcade.permission.database;

import net.bitbylogic.orm.annotation.Column;
import net.bitbylogic.orm.data.BormObject;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PermissionPlayer extends BormObject {

    @Column(primaryKey = true)
    private UUID playerId;

    @Column
    private HashMap<String, Boolean> permissions = new HashMap<>();

    public PermissionPlayer() {}

    public PermissionPlayer(UUID playerId, HashMap<String, Boolean> permissions) {
        this.playerId = playerId;
        this.permissions = permissions;
    }

    public UUID playerId() {
        return playerId;
    }

    public Map<String, Boolean> permissions() {
        return permissions;
    }

}
