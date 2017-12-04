package io.veron.messenger;

import org.bukkit.ChatColor;

public enum Prefix {
    EMPTY(""),
    PLUS("&7[&a+&7] &7"),
    MINUS("&7[&4-&7] &7");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String raw() {
        return this.prefix;
    }

    public String translated() {
        return ChatColor.translateAlternateColorCodes('&', this.prefix);
    }
}
