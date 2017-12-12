package io.veron.command.impl;

import io.veron.Veron;
import io.veron.command.PlayerCommand;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class EssentialsCommand extends PlayerCommand {

    public EssentialsCommand(Veron veron) {
        super(veron);
    }

    @Override
    public boolean onCommand(Player sender, Command command, String[] args) {

        return true;
    }
}
