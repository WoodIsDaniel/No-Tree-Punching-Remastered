package novanillaprogression.common.crafting;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.crafting.RecipeSerializer;
import novanillaprogression.NoVanillaProgression;
import novanillaprogression.common.crafting.serializer.DamageToolShapedSerializer;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, NoVanillaProgression.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, NoVanillaProgression.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, DamageToolShapedSerializer> DAMAGE_TOOL_SHAPED_SERIALIZER =
            SERIALIZERS.register("damage_tool_shaped", DamageToolShapedSerializer::new);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}