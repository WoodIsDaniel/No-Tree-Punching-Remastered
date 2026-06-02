package woodisdaniel.notreepunchingremastered;

import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue ROCK_GENERATION = BUILDER
            .comment("If false, this will disable surface rock world gen.")
            .define("looseRocksGeneration", true);

    public static final ModConfigSpec.IntValue ROCK_SPAWN_RATE = BUILDER
            .comment("Frequency of loose rocks in the world")
            .defineInRange("looseRocksFrequency", 10, 0, Integer.MAX_VALUE);

    // a list of strings that are treated as resource locations for items
    //public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
    //        .comment("A list of items to log on common setup.")
    //        .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);

    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }
}
