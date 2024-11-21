package com.disk.diskssimplemagic.datageneration;

import com.disk.diskssimplemagic.DisksSimpleMagic;
import com.disk.diskssimplemagic.items.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageProviderEN_US extends LanguageProvider {
    public LanguageProviderEN_US(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        DisksSimpleMagic.LOGGER.info("DSM03 - Starting Language File Generation");
        this.addItem(ModItems.ENDER_STAFF_ITEM, "Ender Staff");
        this.add("itemGroup.diskssimplemagic", "Disks Simple Magic");
    }
}
