package net.bitbylogic.stomarcade.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

public class MessageUtil {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    public static Component miniDeserialize(@NotNull String message) {
        return MINI_MESSAGE.deserialize(message);
    }

}
