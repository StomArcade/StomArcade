package net.bitbylogic.stomarcade.permission.database;

import net.bitbylogic.orm.BormAPI;
import net.bitbylogic.orm.data.BormTable;

public class PermissionPlayerTable extends BormTable<PermissionPlayer> {

    public PermissionPlayerTable(BormAPI bormAPI) {
        super(bormAPI, PermissionPlayer.class, "permission_players");
    }

}
