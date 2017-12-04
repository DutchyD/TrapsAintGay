package io.veron.module;

import io.veron.messenger.Messenger;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Module {

    private boolean isEnabled = false;
    protected static JavaPlugin veron;
    protected static Messenger tools;

    public abstract void onLoad();
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract void onReload();

    void load(JavaPlugin veron) {
        this.veron = veron;
    }

    void enable() {
        this.isEnabled = true;
        this.onEnable();
    }

    void disable() {
        this.isEnabled = false;
        this.onDisable();
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    protected void reload() {
        this.disable();
        this.enable();
    }
}
