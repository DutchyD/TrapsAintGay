package io.veron;

import io.veron.messenger.Messenger;
import io.veron.module.ModuleLoader;
import io.veron.utility.Toolkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Veron extends JavaPlugin {

    private ModuleLoader moduleLoader;

    @Override
    public void onEnable() {
        this.moduleLoader = new ModuleLoader(this);
        Toolkit tools = new Toolkit(new Messenger());
    }

    @Override
    public void onDisable() {
        this.moduleLoader.flush();
        this.moduleLoader = null;
    }
}
