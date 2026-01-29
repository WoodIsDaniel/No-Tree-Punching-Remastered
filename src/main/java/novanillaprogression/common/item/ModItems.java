package novanillaprogression.common.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import novanillaprogression.NoVanillaProgression;
import net.minecraft.world.item.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NoVanillaProgression.MOD_ID);

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRASS_FIBER = ITEMS.register("grass_fiber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLANT_STRING = ITEMS.register("plant_string",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLINT_SHARD = ITEMS.register("flint_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<PickaxeItem> FLINT_PICKAXE = ITEMS.register("flint_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FLINT, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> FLINT_SHOVEL = ITEMS.register("flint_shovel",
            () -> new ShovelItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FLINT, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> FLINT_AXE = ITEMS.register("flint_axe",
            () -> new AxeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.FLINT, 6.0F, -3.4f))));
    public static final DeferredItem<HoeItem> FLINT_HOE = ITEMS.register("flint_hoe",
            () -> new HoeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FLINT, 0F, -3.0f))));

    public static final DeferredItem<HoeItem> FLINT_KNIFE = ITEMS.register("flint_knife",
            () -> new HoeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FLINT, 1F, -0.8f))));

    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6.0F, -3.3f))));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -1.0F, -2.0f))));

    public static final DeferredItem<AxeItem> COPPER_KNIFE = ITEMS.register("copper_knife",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 0.5F, -0.8f))));
    public static final DeferredItem<HoeItem> COPPER_SAW = ITEMS.register("copper_saw",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, 6.0F, -3.7f))));

    public static final DeferredItem<SwordItem> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BRONZE, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BRONZE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BRONZE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BRONZE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BRONZE, -1.5F, -1.5f))));

    public static final DeferredItem<AxeItem> BRONZE_KNIFE = ITEMS.register("bronze_knife",
            () -> new AxeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BRONZE, 0.2F, -0.8f))));
    public static final DeferredItem<HoeItem> BRONZE_SAW = ITEMS.register("bronze_saw",
            () -> new HoeItem(ModToolTiers.BRONZE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BRONZE, 6.0F, -3.6f))));

    public static final DeferredItem<AxeItem> IRON_KNIFE = ITEMS.register("iron_knife",
            () -> new AxeItem(Tiers.IRON, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.IRON, 0F, -0.8f))));
    public static final DeferredItem<HoeItem> IRON_SAW = ITEMS.register("iron_saw",
            () -> new HoeItem(Tiers.IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.IRON, 6.0F, -3.5f))));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
