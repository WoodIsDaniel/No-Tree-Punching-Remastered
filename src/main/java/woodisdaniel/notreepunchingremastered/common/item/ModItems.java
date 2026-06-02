package woodisdaniel.notreepunchingremastered.common.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import net.minecraft.world.item.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NoTreePunchingRemastered.MOD_ID);

    public static final DeferredItem<Item> GRASS_FIBER = ITEMS.register("grass_fiber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLANT_STRING = ITEMS.register("plant_string",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLINT_SHARD = ITEMS.register("flint_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CLAY_VESSEL = ITEMS.register("clay_vessel",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)));
    public static final DeferredItem<Item> CERAMIC_VESSEL = ITEMS.register("ceramic_vessel",
            () -> new VesselItem(new Item.Properties()));

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
                    .attributes(HoeItem.createAttributes(ModToolTiers.FLINT, 1.0F, -2.2f))));

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
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 1.0F, -2.2f))));
    public static final DeferredItem<HoeItem> COPPER_SAW = ITEMS.register("copper_saw",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, 2.0F, -3.2f))));

    public static final DeferredItem<AxeItem> GOLDEN_KNIFE = ITEMS.register("golden_knife",
            () -> new AxeItem(Tiers.GOLD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.GOLD, 0.5F, -2.2f))));
    public static final DeferredItem<HoeItem> GOLDEN_SAW = ITEMS.register("golden_saw",
            () -> new HoeItem(Tiers.GOLD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.GOLD, 2.0F, -3.2f))));

    public static final DeferredItem<AxeItem> IRON_KNIFE = ITEMS.register("iron_knife",
            () -> new AxeItem(Tiers.IRON, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.IRON, 0.5F, -2.2f))));
    public static final DeferredItem<HoeItem> IRON_SAW = ITEMS.register("iron_saw",
            () -> new HoeItem(Tiers.IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.IRON, 2.0F, -3.2f))));

    public static final DeferredItem<AxeItem> STEEL_KNIFE = ITEMS.register("steel_knife",
            () -> new AxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STEEL, 1.0F, -2.2f))));
    public static final DeferredItem<HoeItem> STEEL_SAW = ITEMS.register("steel_saw",
            () -> new HoeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STEEL, 2.5F, -3.2f))));

    public static final DeferredItem<AxeItem> DIAMOND_KNIFE = ITEMS.register("diamond_knife",
            () -> new AxeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.DIAMOND, 1.0F, -2.2f))));
    public static final DeferredItem<HoeItem> DIAMOND_SAW = ITEMS.register("diamond_saw",
            () -> new HoeItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.DIAMOND, 2.0F, -3.2f))));

    public static final DeferredItem<AxeItem> NETHERITE_KNIFE = ITEMS.register("netherite_knife",
            () -> new AxeItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(Tiers.NETHERITE, 1.0F, -2.2f))));
    public static final DeferredItem<HoeItem> NETHERITE_SAW = ITEMS.register("netherite_saw",
            () -> new HoeItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(Tiers.NETHERITE, 2.0F, -3.2f))));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
