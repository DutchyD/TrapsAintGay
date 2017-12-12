package io.veron.module.impl;

import io.veron.Veron;
import io.veron.command.impl.DayCommand;
import io.veron.command.impl.DisabledCommand;
import io.veron.module.Module;
import io.veron.command.impl.EssentialsCommand;

public class EssentialsModule extends Module {

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {

        Veron veron = this.getVeron();

        veron.getCommand("essentials").setExecutor(new EssentialsCommand(veron));
        veron.getCommand("day").setExecutor(new DayCommand(veron));
    }

    @Override
    public void onDisable() {

        Veron veron = this.getVeron();
        DisabledCommand cmd = new DisabledCommand(veron);

        veron.getCommand("essentials").setExecutor(cmd);
        veron.getCommand("day").setExecutor(cmd);
        veron.getCommand("night").setExecutor(cmd);

    }
}
