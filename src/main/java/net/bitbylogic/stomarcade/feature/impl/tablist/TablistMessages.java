package net.bitbylogic.stomarcade.feature.impl.tablist;

import net.bitbylogic.stomarcade.message.MessageGroup;
import net.bitbylogic.stomarcade.message.MessageKey;

public class TablistMessages extends MessageGroup {

    public static MessageKey HEADER;
    public static MessageKey FOOTER;

    public TablistMessages() {
        super("Tablist");
    }

    @Override
    public void register() {
        HEADER = register("Header", "<primary><bold>ꜱᴛᴏᴍ ᴀʀᴄᴀᴅᴇ<newline><reset><gray><italic><smallcaps><kardia_id><newline>");
        FOOTER = register("Footer", "<newline><highlight>           ʏᴇᴀʜ, ᴡᴇ ʜᴀᴠᴇ ᴍɪɴɪɢᴀᴍᴇꜱ.           ");
    }

}
