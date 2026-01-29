package novanillaprogression.common.crafting.serializer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import novanillaprogression.common.crafting.DamageToolShapedRecipe;

public class DamageToolShapedSerializer implements RecipeSerializer<DamageToolShapedRecipe> {

    public static final MapCodec<DamageToolShapedRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(r -> r.getGroup()),
            CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(r -> r.category),
            ShapedRecipePattern.MAP_CODEC.forGetter(r -> r.pattern),
            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(r -> r.result),
            Codec.BOOL.optionalFieldOf("show_notification", true).forGetter(r -> r.showNotification)
    ).apply(inst, DamageToolShapedRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, DamageToolShapedRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, r -> r.getGroup(),
            CraftingBookCategory.STREAM_CODEC, r -> r.category,
            ShapedRecipePattern.STREAM_CODEC, r -> r.pattern,
            ItemStack.STREAM_CODEC, r -> r.result,
            ByteBufCodecs.BOOL, r -> r.showNotification,
            DamageToolShapedRecipe::new
    );

    @Override
    public MapCodec<DamageToolShapedRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, DamageToolShapedRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}