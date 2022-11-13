package zoniic645.firmasdelight.common;

import net.dries007.tfc.common.blockentities.DecayingBlockEntity;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FarmersDelightBlockEntities{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, "tfc");

	public static final RegistryObject<BlockEntityType<DecayingBlockEntity>> DECAYING = register("decaying", DecayingBlockEntity::new, Stream.of(TFCBlocks.MELON, TFCBlocks.PUMPKIN,FarmersDelightBlocks.RICE_BAG));

	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> factory, Supplier<? extends Block> block){
		return RegistrationHelpers.register(BLOCK_ENTITIES, name, factory, block);
	}

	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> factory, Stream<? extends Supplier<? extends Block>> blocks){
		return RegistrationHelpers.register(BLOCK_ENTITIES, name, factory, blocks);
	}

}
