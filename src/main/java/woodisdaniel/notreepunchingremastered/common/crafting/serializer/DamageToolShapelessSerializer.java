package woodisdaniel.notreepunchingremastered.common.crafting.serializer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import woodisdaniel.notreepunchingremastered.common.crafting.DamageToolShapelessRecipe;

public class DamageToolShapelessSerializer
        implements RecipeSerializer<DamageToolShapelessRecipe> {

    public static final MapCodec<DamageToolShapelessRecipe> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            Codec.STRING.optionalFieldOf("group", "")
                                    .forGetter(DamageToolShapelessRecipe::getGroup),

                            CraftingBookCategory.CODEC
                                    .optionalFieldOf("category",
                                            CraftingBookCategory.MISC)
                                    .forGetter(r -> r.category),

                            Ingredient.CODEC_NONEMPTY.listOf()
                                    .fieldOf("ingredients")
                                    .flatXmap(
                                            list -> {
                                                if (list.isEmpty()) {
                                                    return com.mojang.serialization.DataResult.error(
                                                            () -> "No ingredients");
                                                }

                                                return com.mojang.serialization.DataResult.success(
                                                        NonNullList.copyOf(list));
                                            },
                                            com.mojang.serialization.DataResult::success
                                    )
                                    .forGetter(r -> r.ingredients),

                            ItemStack.STRICT_CODEC.fieldOf("result")
                                    .forGetter(r -> r.result)
                    ).apply(instance, DamageToolShapelessRecipe::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf,
            DamageToolShapelessRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8,
                    DamageToolShapelessRecipe::getGroup,

                    CraftingBookCategory.STREAM_CODEC,
                    r -> r.category,

                    Ingredient.CONTENTS_STREAM_CODEC.apply(
                            ByteBufCodecs.list()),
                    r -> r.ingredients,

                    ItemStack.STREAM_CODEC,
                    r -> r.result,

                    (group, category, ingredients, result) ->
                            new DamageToolShapelessRecipe(
                                    group,
                                    category,
                                    NonNullList.copyOf(ingredients),
                                    result
                            )
            );

    @Override
    public MapCodec<DamageToolShapelessRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf,
            DamageToolShapelessRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}