package me.ssq.item.tool;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    // 1. 创建物品实例
    public static final PickaxeItem DARK_PICKAXE =
            new PickaxeItem(ModToolMaterial.DARK_PICKAXE, new Item.Settings());

    public static final AxeItem DARK_AXE =
            new AxeItem(ModToolMaterial.DARK_AXE, new Item.Settings());

    public static final SwordItem DARK_SWORD =
            new SwordItem(ModToolMaterial.DARK_SWORD, new Item.Settings());

    public static final ShovelItem DARK_SHOVEL=
            new ShovelItem(ModToolMaterial.DARK_SHOVEL,new Item.Settings());

    public static final HoeItem DARK_HOE=
            new HoeItem(ModToolMaterial.DARK_HOE,new Item.Settings());

    public static final Item DARK_GEM=
            new Item(new Item.Settings());

    public static final Item DARK_SHARD=
            new Item(new Item.Settings());

    // 2. 注册所有物品
    public static void registerAll() {
        Registry.register(
                Registries.ITEM,
                Identifier.of("new", "dark_pickaxe"),
                DARK_PICKAXE
        );
        Registry.register(
                Registries.ITEM,
                Identifier.of("new", "dark_axe"),
                DARK_AXE
        );
        Registry.register(
                Registries.ITEM,
                Identifier.of("new", "dark_sword"),
                DARK_SWORD
        );
        Registry.register(
                Registries.ITEM,
                Identifier.of("new", "dark_gem"),
                DARK_GEM
        );

        Registry.register(Registries.ITEM, Identifier.of("new", "dark_shard"), DARK_SHARD);
        Registry.register(Registries.ITEM, Identifier.of("new", "dark_shovel"), DARK_SHOVEL);
        Registry.register(Registries.ITEM, Identifier.of("new", "dark_hoe"), DARK_HOE);

    }
    public static void registerCreativeTab() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> {
                    entries.addAfter(Items.NETHERITE_HOE,DARK_SHOVEL);
                    entries.addAfter(DARK_SHOVEL,DARK_PICKAXE);
                    entries.addAfter(DARK_PICKAXE,DARK_AXE);
                    entries.addAfter(DARK_AXE,DARK_HOE);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> {
                    entries.addAfter(Items.NETHERITE_SWORD,DARK_SWORD);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> {
                    entries.add(DARK_GEM);
                    entries.add(DARK_SHARD);

                });
    }


    // 3. 初始化方法（在主类 onInitialize 里调用）
    public static void initialize() {
        registerAll();
    }
}
