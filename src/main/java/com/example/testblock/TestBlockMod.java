package com.example.testblock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestBlockMod implements ModInitializer {
    public static final String MOD_ID = "testblock";
    public static final Block TEST_BLOCK = Registry.register(Registries.BLOCK,
            Identifier.of(MOD_ID, "test_block"),
            new Block(AbstractBlock.Settings.create().strength(1.5f)));
    public static final Item TEST_BLOCK_ITEM = Registry.register(Registries.ITEM,
            Identifier.of(MOD_ID, "test_block"),
            new BlockItem(TEST_BLOCK, new Item.Settings()));

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(TEST_BLOCK_ITEM));
    }
}
