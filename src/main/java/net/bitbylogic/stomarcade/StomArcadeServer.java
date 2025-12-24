package net.bitbylogic.stomarcade;

import net.minestom.server.Auth;
import net.minestom.server.MinecraftServer;

public class StomArcadeServer {

    public static void main(String[] args) {
        MinecraftServer.setCompressionThreshold(0);

        String velocitySecret = System.getenv("VELOCITY_SECRET");
        MinecraftServer minecraftServer = MinecraftServer.init(new Auth.Velocity(velocitySecret));

        String serverAddress = System.getenv("SERVER_ADDRESS");

        int serverPort = 25565;

        try {
            serverPort = Integer.parseInt(System.getenv("SERVER_PORT"));
        } catch (NumberFormatException e) {
            // Ignored
        }

        minecraftServer.start(serverAddress, serverPort);
    }

}
