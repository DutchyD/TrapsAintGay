package io.veron.command.impl;

import io.veron.Veron;
import io.veron.messenger.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisabledCommand implements CommandExecutor {

    private final Veron veron;

    public DisabledCommand(Veron veron) {
        this.veron = veron;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        veron.getMessenger().sendMessage(sender, Prefix.DISABLED, "This command is disabled. Is the associated module enabled?");

        return false;
    }
}
