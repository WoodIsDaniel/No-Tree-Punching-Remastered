package woodisdaniel.notreepunchingremastered.datagen.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import woodisdaniel.notreepunchingremastered.NoTreePunchingRemastered;
import woodisdaniel.notreepunchingremastered.datagen.util.ModTags;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("add_tin_ore");

    public static final ResourceKey<BiomeModifier> ADD_LOOSE_STONE_ROCK = registerKey("add_loose_stone_rock");

    public static final ResourceKey<BiomeModifier> ADD_LOOSE_SANDSTONE_ROCK = registerKey("add_loose_sandstone_rock");

    public static final ResourceKey<BiomeModifier> ADD_LOOSE_RED_SANDSTONE_ROCK = registerKey("add_loose_red_sandstone_rock");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LOOSE_STONE_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Worldgen.Biomes.HAS_STONE_ROCK),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LOOSE_STONE_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_LOOSE_SANDSTONE_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Worldgen.Biomes.HAS_SANDSTONE_ROCK),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LOOSE_SANDSTONE_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_LOOSE_RED_SANDSTONE_ROCK, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.Worldgen.Biomes.HAS_RED_SANDSTONE_ROCK),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LOOSE_RED_SANDSTONE_ROCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(NoTreePunchingRemastered.MOD_ID, name));
    }
}
