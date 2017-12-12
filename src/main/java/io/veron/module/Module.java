package io.veron.module;

import io.veron.exceptions.ModuleException;
import io.veron.messenger.Prefix;

public abstract class Module {

    private boolean isEnabled = false;
    private boolean isLoaded = false;
    private boolean isBroken = false;
    private final String id;

    public abstract void onLoad() throws ModuleException;

    public abstract void onEnable() throws ModuleException;

    public abstract void onDisable() throws ModuleException;

    public Module(String id) {
        this.id = id;
    }

    void load() throws ModuleException {
        this.onLoad();
        this.isLoaded = true;
    }

    void enable() throws ModuleException {
        if (!this.isLoaded)
            throw new ModuleException("Module [" + this.id + "] isn't loaded. Load before enabling.");

        if (this.isBroken)
            throw new ModuleException("Module [" + this.id + "] broke. > \nUnderstandable have a nice day.");

        if (this.isEnabled) return;

        this.isEnabled = true;
    }

    void disable() throws ModuleException {
        if (!this.isEnabled) return;

        try { this.onDisable(); }
        catch (ModuleException e) { e.printStackTrace(); this.isBroken = true; }
        finally { this.isEnabled = false; }
    }

    boolean isEnabled() {
        return this.isEnabled;
    }

    boolean isBroken() {
        return this.isBroken;
    }

    boolean isLoaded() {
        return this.isLoaded;
    }

    void reload() throws ModuleException {
        this.disable();
        this.enable();
    }

    String getId() {
        return this.id;
    }
}

