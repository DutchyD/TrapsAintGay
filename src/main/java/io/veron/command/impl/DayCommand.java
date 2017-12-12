package io.veron.command.impl;

import io.veron.Veron;
import io.veron.command.PlayerCommand;
import io.veron.messenger.Prefix;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class DayCommand extends PlayerCommand {

    public DayCommand(Veron veron) {
        super(veron);
    }

    @Override
    public boolean onCommand(Player sender, Command command, String[] args) {

        if (args.length == 0) {

            World world = sender.getWorld();

            world.setTime(0);
            this.veron.getMessenger().broadcast(Prefix.SUCCESS, "Time set to day in world [" + world.getName() + "]");
        } else if (args.length == 1) {
            World world = sender.getServer().getWorld(args[0]);

            if (world == null) {
                this.veron.getMessenger().sendMessage(sender, Prefix.FAILURE, "World doesn't exist");
                return false;
            }

            world.setTime(0);
            this.veron.getMessenger().broadcast(Prefix.SUCCESS, "Time set to day in world [" + world.getName() + "]");

        } else {
            this.veron.getMessenger().sendMessage(sender, Prefix.FAILURE, "Too many arguments");
            return false;
        }

        return true;
    }

    @Override
    public boolean onCommand(ConsoleCommandSender sender, Command command, String[] args) {

        return false;
    }
}
