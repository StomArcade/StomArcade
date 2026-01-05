package net.bitbylogic.stomarcade.feature.impl;

import net.bitbylogic.stomarcade.feature.EventFeature;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerPickBlockEvent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;

public class PickBlockFeature extends EventFeature {

    public PickBlockFeature() {
        super("pick_block");

        node().addListener(PlayerPickBlockEvent.class, event -> {
            Player player = event.getPlayer();

            if (player.getGameMode() != GameMode.CREATIVE) {
                return;
            }

            Material material = event.getBlock().registry().material();

            if (material == null) {
                return;
            }

            player.getInventory().setItemStack(player.getHeldSlot(), ItemStack.of(material));
        });
    }

}
