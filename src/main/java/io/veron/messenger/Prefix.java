package io.veron.messenger;

import org.bukkit.ChatColor;

public enum Prefix {
    EMPTY(""),
    PLUS("&7[&a+&7] &a"),
    MINUS("&7[&4-&7] &a"),
    MODULE("&7[&bModule&7] &a"),
    DISABLED("&7[&4Disabled&7] &a"),
    SUCCESS("&7[&aSuccess&7] &a"),
    FAILURE("&7[&4Failure&7] &a");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String raw() {
        return this.prefix;
    }

    public String translate() {
        return ChatColor.translateAlternateColorCodes('&', this.prefix);
    }
}
