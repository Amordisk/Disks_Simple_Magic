package com.disk.diskssimplemagic.init;

import com.disk.diskssimplemagic.DisksSimpleMagic;
import com.disk.diskssimplemagic.items.EnderStaff;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DisksSimpleMagic.MODID);

    public static final RegistryObject<Item> ENDER_STAFF_ITEM = ITEMS.register("ender_staff_item", () -> new EnderStaff(new Item.Properties().tab(ModCreativeTab.instance)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class ModCreativeTab extends CreativeModeTab {
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "diskssimplemagic");
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ENDER_STAFF_ITEM.get());
        }
    }
}
