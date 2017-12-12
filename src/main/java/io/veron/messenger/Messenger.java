package io.veron.messenger;

import io.veron.Veron;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messenger {

    private final Veron veron;

    public Messenger(Veron veron) {
        this.veron = veron;
    }

    public void sendMessage(Player player, Prefix prefix, String raw) {
        player.sendMessage(prefix.translate() + raw);
    }

    public void sendMessage(CommandSender sender, Prefix prefix, String raw) {
        sender.sendMessage(prefix.translate() + raw);
    }

    public void broadcast(Prefix prefix, String raw) {
        this.veron.getServer().broadcastMessage(prefix.translate() + " " + raw);
    }

    public void log(String log) {
        veron.getLogger().info(log);
    }

    private void sendRawMessage(Player player, String message) {
        player.sendMessage(message);
    }
}
