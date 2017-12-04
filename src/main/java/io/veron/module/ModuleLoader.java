package io.veron.module;

import io.veron.module.Module;
import io.veron.module.ModuleInformation;
import io.veron.utility.Toolkit;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ModuleLoader {

    private HashMap<String, Module> modules = new HashMap<>();
    private final JavaPlugin veron;

    public ModuleLoader(JavaPlugin veron, Toolkit tools) {
        this.veron = veron;
        Module.tools = tools;
    }

    public void load(Module module) {
        Validate.notNull(module);

        if (!module.getClass().isAnnotationPresent(ModuleInformation.class))
            return;

        this.modules.put(module.getClass().getAnnotation(ModuleInformation.class).id(), module);

        module.load(veron);
    }

    public void enable() {
        modules.values().forEach(Module::enable);
    }

    public void disable() {
        modules.values().forEach(Module::enable);
    }

    public void flush() {
        this.disable();
        this.modules.clear();
        this.modules = null;
    }

    public void reload() {
        this.disable();
        this.enable();
    }
}
