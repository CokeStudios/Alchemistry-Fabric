package com.smashingmods.alchemistry.common.block.reactor;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.sound.BlockSoundGroup;

public class ReactorGlassBlock extends AbstractGlassBlock {

    public ReactorGlassBlock() {
        super(FabricBlockSettings.create().strength(2.0f).nonOpaque().sounds(BlockSoundGroup.GLASS));
    }
}
