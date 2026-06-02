package woodisdaniel.notreepunchingremastered.datagen.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.common.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> LOOSE_STONE_ROCK_KEY = registerKey("loose_stone_rock");;

    public static final ResourceKey<ConfiguredFeature<?, ?>> LOOSE_SANDSTONE_ROCK_KEY = registerKey("loose_sandstone_rock");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LOOSE_RED_SANDSTONE_ROCK_KEY = registerKey("loose_red_sandstone_rock");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, LOOSE_STONE_ROCK_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STONE_ROCK.get())));

        register(context, LOOSE_SANDSTONE_ROCK_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SANDSTONE_ROCK.get())));

        register(context, LOOSE_RED_SANDSTONE_ROCK_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.RED_SANDSTONE_ROCK.get())));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}