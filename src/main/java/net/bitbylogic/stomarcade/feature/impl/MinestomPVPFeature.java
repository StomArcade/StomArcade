package net.bitbylogic.stomarcade.feature.impl;

import io.github.togar2.pvp.feature.CombatFeatureSet;
import io.github.togar2.pvp.feature.CombatFeatures;
import io.github.togar2.pvp.feature.config.DefinedFeature;
import net.bitbylogic.stomarcade.feature.SimpleFeature;
import net.minestom.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public class MinestomPVPFeature extends SimpleFeature {

    private final CombatFeatureSet featureSet;

    public MinestomPVPFeature(@NotNull String id, @NotNull DefinedFeature<?> feature) {
        super(id);

        featureSet = CombatFeatures.empty().add(feature).build();
    }

    public MinestomPVPFeature(@NotNull String id, @NotNull CombatFeatureSet featureSet) {
        super(id);

        this.featureSet = featureSet;
    }

    @Override
    public void onEnable() {
        MinecraftServer.getGlobalEventHandler().addChild(featureSet.createNode());
    }

    @Override
    public void onDisable() {
        MinecraftServer.getGlobalEventHandler().removeChild(featureSet.createNode());
    }

    protected CombatFeatureSet getFeatureSet() {
        return featureSet;
    }

}
