package io.veron.module;

public class DefaultModuleValidator implements ModuleValidator {

    @Override
    public boolean isValid(Module module) {
        return !module.isBroken() && !module.getId().equals("") && !module.getId().contains(" ");
    }
}