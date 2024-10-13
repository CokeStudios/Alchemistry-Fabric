package com.smashingmods.alchemistry.registry;

import com.smashingmods.alchemistry.Alchemistry;
import com.smashingmods.alchemistry.common.block.atomizer.AtomizerBlock;
import com.smashingmods.alchemistry.common.block.combiner.CombinerBlock;
import com.smashingmods.alchemistry.common.block.compactor.CompactorBlock;
import com.smashingmods.alchemistry.common.block.dissolver.DissolverBlock;
import com.smashingmods.alchemistry.common.block.fission.FissionControllerBlock;
import com.smashingmods.alchemistry.common.block.fusion.FusionControllerBlock;
import com.smashingmods.alchemistry.common.block.liquifier.LiquifierBlock;
import com.smashingmods.alchemistry.common.block.reactor.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class BlockRegistry {

    public static final DissolverBlock DISSOLVER = new DissolverBlock();
    public static final LiquifierBlock LIQUIFIER = new LiquifierBlock();
    public static final AtomizerBlock ATOMIZER = new AtomizerBlock();
    public static final CompactorBlock COMPACTOR = new CompactorBlock();
    public static final CombinerBlock COMBINER = new CombinerBlock();
    public static final ReactorCoreBlock FUSION_CORE = new ReactorCoreBlock();
    public static final ReactorCoreBlock FISSION_CORE = new ReactorCoreBlock();
    public static final ReactorGlassBlock REACTOR_GLASS = new ReactorGlassBlock();
    public static final ReactorEnergyBlock REACTOR_ENERGY = new ReactorEnergyBlock();
    public static final ReactorInputBlock REACTOR_INPUT = new ReactorInputBlock();
    public static final ReactorOutputBlock REACTOR_OUTPUT = new ReactorOutputBlock();
    public static final Block REACTOR_CASING = new Block(FabricBlockSettings.create().strength(2.0f));
    public static final FissionControllerBlock FISSION_CONTROLLER = new FissionControllerBlock();
    public static final FusionControllerBlock FUSION_CONTROLLER = new FusionControllerBlock();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "dissolver"), DISSOLVER);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "liquifier"), LIQUIFIER);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "atomizer"), ATOMIZER);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "compactor"), COMPACTOR);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "combiner"), COMBINER);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "fission_core"), FISSION_CORE);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "fusion_core"), FUSION_CORE);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "reactor_glass"), REACTOR_GLASS);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "reactor_energy"), REACTOR_ENERGY);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "reactor_input"), REACTOR_INPUT);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "reactor_output"), REACTOR_OUTPUT);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "reactor_casing"), REACTOR_CASING);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "fission_chamber_controller"), FISSION_CONTROLLER);
        Registry.register(Registry.BLOCK, new Identifier(Alchemistry.MOD_ID, "fusion_chamber_controller"), FUSION_CONTROLLER);
    }
}
