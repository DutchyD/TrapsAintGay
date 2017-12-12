package io.veron;

import io.veron.command.ModuleCommand;
import io.veron.messenger.Messenger;
import io.veron.messenger.Prefix;
import io.veron.module.ModuleLoader;
import io.veron.module.impl.EssentialsModule;
import org.bukkit.plugin.java.JavaPlugin;

public class Veron extends JavaPlugin {

    private ModuleLoader moduleLoader;
    private Messenger messenger;

    @Override
    public void onEnable() {
        this.messenger = new Messenger(this);
        this.moduleLoader = new ModuleLoader(this);

        this.getCommand("module").setExecutor(new ModuleCommand(this.moduleLoader, this.messenger));

        this.loadModules();
        this.moduleLoader.enable();
    }

    @Override
    public void onDisable() {
        this.moduleLoader.clear();
        this.moduleLoader = null;
        this.messenger = null;
    }

    private void loadModules() {
        this.messenger.broadcast(Prefix.MODULE, "Loading all modules...");
        this.moduleLoader.load(new EssentialsModule());
    }

    public ModuleLoader getModuleLoader() {
        return this.moduleLoader;
    }

    public Messenger getMessenger() {
        return this.messenger;
    }
}
