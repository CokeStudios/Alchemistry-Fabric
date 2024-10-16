package com.smashingmods.alchemistry.registry;

import com.smashingmods.alchemistry.Alchemistry;
import com.smashingmods.alchemistry.common.recipe.atomizer.AtomizerRecipe;
import com.smashingmods.alchemistry.common.recipe.atomizer.AtomizerRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.combiner.CombinerRecipe;
import com.smashingmods.alchemistry.common.recipe.combiner.CombinerRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.compactor.CompactorRecipe;
import com.smashingmods.alchemistry.common.recipe.compactor.CompactorRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.dissolver.DissolverRecipe;
import com.smashingmods.alchemistry.common.recipe.dissolver.DissolverRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.fission.FissionRecipe;
import com.smashingmods.alchemistry.common.recipe.fission.FissionRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.fusion.FusionRecipe;
import com.smashingmods.alchemistry.common.recipe.fusion.FusionRecipeSerializer;
import com.smashingmods.alchemistry.common.recipe.liquifier.LiquifierRecipe;
import com.smashingmods.alchemistry.common.recipe.liquifier.LiquifierRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class RecipeRegistry {

    public static void registerRecipes() {
        // Dissolver
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, DissolverRecipeSerializer.ID), DissolverRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, DissolverRecipe.Type.ID), DissolverRecipe.Type.INSTANCE);

        // Liquifier
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, LiquifierRecipeSerializer.ID), LiquifierRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, LiquifierRecipe.Type.ID), LiquifierRecipe.Type.INSTANCE);

        // Atomizer
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, AtomizerRecipeSerializer.ID), AtomizerRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, AtomizerRecipe.Type.ID), AtomizerRecipe.Type.INSTANCE);

        // Compactor
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, CompactorRecipeSerializer.ID), CompactorRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, CompactorRecipe.Type.ID), CompactorRecipe.Type.INSTANCE);

        // Combiner
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, CombinerRecipeSerializer.ID), CombinerRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, CombinerRecipe.Type.ID), CombinerRecipe.Type.INSTANCE);

        // Fission
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, FissionRecipeSerializer.ID), FissionRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, FissionRecipe.Type.ID), FissionRecipe.Type.INSTANCE);

        // Fusion
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Alchemistry.MOD_ID, FusionRecipeSerializer.ID), FusionRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Alchemistry.MOD_ID, FusionRecipe.Type.ID), FusionRecipe.Type.INSTANCE);
    }
}
