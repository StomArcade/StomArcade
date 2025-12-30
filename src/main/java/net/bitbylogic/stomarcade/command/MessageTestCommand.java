package net.bitbylogic.stomarcade.command;

import net.bitbylogic.stomarcade.permission.command.PermissionedCommand;
import net.bitbylogic.stomarcade.util.message.MessageUtil;
import net.kyori.adventure.text.Component;
import net.minestom.server.command.builder.arguments.Argument;
import net.minestom.server.command.builder.arguments.ArgumentLiteral;
import net.minestom.server.command.builder.arguments.ArgumentString;
import net.minestom.server.command.builder.arguments.ArgumentType;

public class MessageTestCommand extends PermissionedCommand {

    public MessageTestCommand() {
        super("messagetest");

        setPermission("stomarcade.messagetest");

        setDefaultExecutor((sender, _) -> sender.sendMessage(Component.text("Usage: /messagetest <message>")));

        ArgumentLiteral main = ArgumentType.Literal("main");
        ArgumentLiteral error = ArgumentType.Literal("error");
        ArgumentLiteral success = ArgumentType.Literal("success");

        Argument<String> message = new ArgumentString("message");

        addSyntax((sender, context) -> sender.sendMessage(MessageUtil.deserialize(context.get(message))), message);

        addSyntax((sender, context) -> sender.sendMessage(MessageUtil.primary(context.get(message))), main, message);
        addSyntax((sender, context) -> sender.sendMessage(MessageUtil.error(context.get(message))), error, message);
        addSyntax((sender, context) -> sender.sendMessage(MessageUtil.success(context.get(message))), success, message);
    }

}
