package com.disk.diskssimplemagic.init;

import com.disk.diskssimplemagic.DisksSimpleMagic;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DisksSimpleMagic.MODID);

    public static final RegistryObject<Item> ENDERSTAFFITEM = ITEMS.register("ender_staff_item", () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));


    public static class ModCreativeTab extends CreativeModeTab {
        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "diskssimplemagic");
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ENDERSTAFFITEM.get());
        }
    }
}
