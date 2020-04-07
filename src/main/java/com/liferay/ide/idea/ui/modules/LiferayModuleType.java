package com.liferay.ide.idea.ui.modules;

import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import icons.LiferayIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LiferayModuleType extends ModuleType<LiferayModuleBuilder> {


    private static final String ID = "LIFERAY_MODULE_TYPE";

    protected LiferayModuleType() {
        super(ID);
    }

    public static LiferayModuleType getInstance() {
        return (LiferayModuleType) ModuleTypeManager.getInstance().findByID(ID);
    }


    @NotNull
    @Override
    public LiferayModuleBuilder createModuleBuilder() {
        return new LiferayModuleBuilder();
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @NotNull
    @Override
    public String getName() {
        return "Liferay Module Type";
    }

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getDescription() {
        return "Example custom module type";
    }

    @NotNull
    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return LiferayIcons.LIFERAY_ICON;
    }

    @NotNull
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext,
                                                @NotNull LiferayModuleBuilder moduleBuilder,
                                                @NotNull ModulesProvider modulesProvider) {

        return new ModuleWizardStep[] {
                new LiferayProjectTypeStep(wizardContext)
        };
    }

    @Nullable
    @Override
    public ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep, @NotNull ModuleBuilder moduleBuilder) {

        return super.modifySettingsStep(settingsStep, moduleBuilder);
    }
}
