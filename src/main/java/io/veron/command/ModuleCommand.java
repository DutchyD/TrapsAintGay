package io.veron.command;

import io.veron.messenger.Messenger;
import io.veron.messenger.Prefix;
import io.veron.module.ModuleLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ModuleCommand implements CommandExecutor {

    private final ModuleLoader loader;
    private final Messenger messenger;

    public ModuleCommand(ModuleLoader loader, Messenger messenger) {
        this.loader = loader;
        this.messenger = messenger;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 || args.length > 2) return false;

        if (args.length == 1) {
            if (args[0].equals("enable")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Enabling all disabled modules...");
                this.loader.enable();
                this.messenger.sendMessage(sender, Prefix.MODULE, "All disabled modules enabled.");

            } else if (args[0].equals("disable")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Disabling all enabled modules...");
                this.loader.disable();
                this.messenger.sendMessage(sender, Prefix.MODULE, "All enabled modules disabled.");

            } else if (args[0].equals("reload")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Reloading all modules...");
                this.loader.reload();
                this.messenger.sendMessage(sender, Prefix.MODULE, "All enabled modules reloaded");

            }
        } else {
            if (args[0].equals("enable")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Attempting to enable specified Module");

                if (!this.loader.enable(args[1]))
                    this.messenger.sendMessage(sender, Prefix.MODULE, "Module [" + args[1] + "] already enabled or not found.");

            } else if (args[0].equals("disable")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Attempting to disable specified Module");

                if (!this.loader.disable(args[1]))
                    this.messenger.sendMessage(sender, Prefix.MODULE, "Module [" + args[1] + "] already disabled or not found.");

            } else if (args[0].equals("reload")) {

                this.messenger.sendMessage(sender, Prefix.MODULE, "Attempting to reload specified Module");

                if (!this.loader.reload(args[1]))
                    this.messenger.sendMessage(sender, Prefix.MODULE, "Module [" + args[1] + "] was unable to reload and has been disabled");
            }
        }





        return true;
    }
}
