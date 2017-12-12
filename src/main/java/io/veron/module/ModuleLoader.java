package io.veron.module;

import io.veron.Veron;
import io.veron.exceptions.ModuleException;
import org.apache.commons.lang.Validate;

import java.util.HashMap;

public class ModuleLoader {

    private HashMap<String, Module> modules = new HashMap<>();
    private final Veron veron;

    public ModuleLoader(Veron veron) {
        this.veron = veron;
    }

    public void load(Module module) {
        Validate.notNull(module);

        ModuleValidator validator = new DefaultModuleValidator();
        validator.isValid(module);

        if (module.isLoaded())
            this.modules.put(module.getId().toLowerCase(), module);
    }

    public void enable() {
        try {
            for (Module module : modules.values()) {
                if (!module.isEnabled()) {
                    module.enable();
                }
            }
        } catch (ModuleException e) { e.printStackTrace(); }
    }

    public boolean enable(String name) {

        String nameLC = name.toLowerCase();

        if (!modules.containsKey(nameLC)) return false;

        Module module = this.modules.get(nameLC);

        if (module.isEnabled()) return false;

        try { module.enable(); }
        catch (ModuleException e) { e.printStackTrace(); }

        return module.isEnabled();
    }

    public void disable() {
        try {
            for (Module module : modules.values()) {
                if (module.isEnabled()) {
                    module.disable();
                }
            }
        } catch (ModuleException e) { e.printStackTrace(); }
    }

    public boolean disable(String name) {

        String nameLC = name.toLowerCase();

        if (!modules.containsKey(nameLC)) return false;

        Module module = this.modules.get(nameLC);

        if (!module.isEnabled()) return false;

        try { module.disable(); }
        catch (ModuleException e) { e.printStackTrace(); }

        return !module.isEnabled();
    }

    public void clear() {
        this.disable();
        this.modules.clear();
        this.modules = null;
    }

    public void reload() {
        this.disable();
        this.enable();
    }

    public boolean reload(String name) {

        String nameLC = name.toLowerCase();

        if (!modules.containsKey(nameLC)) return false;

        Module module = this.modules.get(nameLC);

        try { module.reload(); }
        catch (ModuleException e) {

            e.printStackTrace();

            try { module.disable(); }
            catch (ModuleException ex) { ex.printStackTrace(); }
        }

        return module.isEnabled();
    }
}


