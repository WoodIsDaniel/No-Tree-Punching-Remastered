package woodisdaniel.notreepunchingremastered.datagen.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LOOSE_STONE_ROCK_PLACED_KEY = registerKey("loose_stone_rock_placed");

    public static final ResourceKey<PlacedFeature> LOOSE_SANDSTONE_ROCK_PLACED_KEY = registerKey("loose_sandstone_rock_placed");

    public static final ResourceKey<PlacedFeature> LOOSE_RED_SANDSTONE_ROCK_PLACED_KEY = registerKey("loose_red_sandstone_rock_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LOOSE_STONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LOOSE_STONE_ROCK_KEY),
                List.of(
                        CountPlacement.of(7),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.solid(new BlockPos(0, -1, 0))
                                )
                        ),
                        BiomeFilter.biome()
                ));

        register(context, LOOSE_SANDSTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LOOSE_SANDSTONE_ROCK_KEY),
                List.of(
                        CountPlacement.of(5),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.solid(new BlockPos(0, -1, 0))
                                )
                        ),
                        BiomeFilter.biome()
                ));

        register(context, LOOSE_RED_SANDSTONE_ROCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LOOSE_RED_SANDSTONE_ROCK_KEY),
                List.of(
                        CountPlacement.of(5),
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                        BlockPredicate.solid(new BlockPos(0, -1, 0))
                                )
                        ),
                        BiomeFilter.biome()
                ));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}