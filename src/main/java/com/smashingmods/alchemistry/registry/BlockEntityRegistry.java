package com.smashingmods.alchemistry.registry;

import com.smashingmods.alchemistry.Alchemistry;
import com.smashingmods.alchemistry.common.block.atomizer.AtomizerBlockEntity;
import com.smashingmods.alchemistry.common.block.combiner.CombinerBlockEntity;
import com.smashingmods.alchemistry.common.block.compactor.CompactorBlockEntity;
import com.smashingmods.alchemistry.common.block.dissolver.DissolverBlockEntity;
import com.smashingmods.alchemistry.common.block.fission.FissionControllerBlockEntity;
import com.smashingmods.alchemistry.common.block.fusion.FusionControllerBlockEntity;
import com.smashingmods.alchemistry.common.block.liquifier.LiquifierBlockEntity;
import com.smashingmods.alchemistry.common.block.reactor.ReactorEnergyBlockEntity;
import com.smashingmods.alchemistry.common.block.reactor.ReactorInputBlockEntity;
import com.smashingmods.alchemistry.common.block.reactor.ReactorOutputBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class BlockEntityRegistry {

    public static final BlockEntityType<DissolverBlockEntity> DISSOLVER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(DissolverBlockEntity::new, BlockRegistry.DISSOLVER).build(null);
    public static final BlockEntityType<LiquifierBlockEntity> LIQUIFIER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(LiquifierBlockEntity::new, BlockRegistry.LIQUIFIER).build(null);
    public static final BlockEntityType<AtomizerBlockEntity> ATOMIZER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(AtomizerBlockEntity::new, BlockRegistry.ATOMIZER).build(null);
    public static final BlockEntityType<CompactorBlockEntity> COMPACTOR_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(CompactorBlockEntity::new, BlockRegistry.COMPACTOR).build(null);
    public static final BlockEntityType<CombinerBlockEntity> COMBINER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(CombinerBlockEntity::new, BlockRegistry.COMBINER).build(null);
    public static final BlockEntityType<ReactorEnergyBlockEntity> REACTOR_ENERGY_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(ReactorEnergyBlockEntity::new, BlockRegistry.REACTOR_ENERGY).build(null);
    public static final BlockEntityType<ReactorInputBlockEntity> REACTOR_INPUT_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(ReactorInputBlockEntity::new, BlockRegistry.REACTOR_INPUT).build(null);
    public static final BlockEntityType<ReactorOutputBlockEntity> REACTOR_OUTPUT_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(ReactorOutputBlockEntity::new, BlockRegistry.REACTOR_OUTPUT).build(null);
    public static final BlockEntityType<FissionControllerBlockEntity> FISSION_CONTROLLER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(FissionControllerBlockEntity::new, BlockRegistry.FISSION_CONTROLLER).build(null);
    public static final BlockEntityType<FusionControllerBlockEntity> FUSION_CONTROLLER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(FusionControllerBlockEntity::new, BlockRegistry.FUSION_CONTROLLER).build(null);

    public static void registerBlockEntities() {
        // Register block entity
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "dissolver_block_entity"), DISSOLVER_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "liquifier_block_entity"), LIQUIFIER_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "atomizer_block_entity"), ATOMIZER_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "compactor_block_entity"), COMPACTOR_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "combiner_block_entity"), COMBINER_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "reactor_energy_block_entity"), REACTOR_ENERGY_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "reactor_input_block_entity"), REACTOR_INPUT_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "reactor_output_block_entity"), REACTOR_OUTPUT_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "fission_controller_block_entity"), FISSION_CONTROLLER_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Alchemistry.MOD_ID, "fusion_controller_block_entity"), FUSION_CONTROLLER_BLOCK_ENTITY);

        // Register energy storage for block entity
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), DISSOLVER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), LIQUIFIER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), ATOMIZER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), COMPACTOR_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), COMBINER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), FISSION_CONTROLLER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), FUSION_CONTROLLER_BLOCK_ENTITY);
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.getEnergyStorage(), REACTOR_ENERGY_BLOCK_ENTITY);

        // Register fluid storage for block entity
        FluidStorage.SIDED.registerForBlockEntity((myTank, direction) -> myTank.getFluidStorage(), LIQUIFIER_BLOCK_ENTITY);
        FluidStorage.SIDED.registerForBlockEntity((myTank, direction) -> myTank.getFluidStorage(), ATOMIZER_BLOCK_ENTITY);
    }
}
