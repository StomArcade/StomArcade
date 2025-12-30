package net.bitbylogic.stomarcade.feature.impl.tablist;

import net.bitbylogic.stomarcade.StomArcadeServer;
import net.bitbylogic.stomarcade.feature.EventFeature;
import net.bitbylogic.stomarcade.message.event.MessagesReloadedEvent;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.player.PlayerLoadedEvent;
import net.minestom.server.instance.Instance;

public class TablistFeature extends EventFeature {

    public TablistFeature() {
        super("tablist");

        node().addListener(PlayerLoadedEvent.class, event -> {
            Player player = event.getPlayer();

            player.sendPlayerListHeaderAndFooter(TablistMessages.HEADER.get(player), TablistMessages.FOOTER.get(player));
        }).addListener(MessagesReloadedEvent.class, _ -> {
            for (Instance instance : MinecraftServer.getInstanceManager().getInstances()) {
                for (Player player : instance.getPlayers()) {
                    player.sendPlayerListHeaderAndFooter(TablistMessages.HEADER.get(player), TablistMessages.FOOTER.get(player));
                }
            }
        });
    }

    @Override
    public void onEnable() {
        StomArcadeServer.messages().registerGroup(new TablistMessages());
    }

}
