package io.veron.command;

import io.veron.Veron;
import io.veron.messenger.Messenger;
import io.veron.messenger.Prefix;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public abstract class PlayerCommand implements CommandExecutor {

    protected final Veron veron;
    protected final Messenger messenger;

    public PlayerCommand(Veron veron) {
        this.veron = veron;
        this.messenger = veron.getMessenger();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
            return this.onCommand((Player) sender, command, args);
        else
            this.messenger.sendMessage(sender, Prefix.EMPTY, "This command can only be used by a player");

        return false;
    }

    public abstract boolean onCommand(Player sender, Command command, String[] args);
}
