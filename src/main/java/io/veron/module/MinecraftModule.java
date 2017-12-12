package io.veron.module;

import io.veron.Veron;
import io.veron.exceptions.ModuleException;

public class MinecraftModule extends Module {

    private final Veron veron;

    public MinecraftModule(String id, Veron veron) {
        super(id);
        this.veron = veron;
    }

    @Override
    public void onLoad() throws ModuleException {

    }

    @Override
    public void onEnable() throws ModuleException {

    }

    @Override
    public void onDisable() throws ModuleException {

    }
}
