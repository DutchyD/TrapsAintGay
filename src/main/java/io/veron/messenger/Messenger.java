package io.veron.messenger;

import org.bukkit.entity.Player;

public class Messenger {

    public void sendMessage(Player player, Prefix prefix, String raw) {
        String message = prefix.raw() + " " + raw;
        this.sendRawMessage(player, message);
    }

    public void log(String log) {
        System.out.println("[Veron] " + log);
    }

    private void sendRawMessage(Player player, String message) {
        player.sendMessage(message);
    }
}
