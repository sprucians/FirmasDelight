package zoniic645.firmasdelight.common;

import net.dries007.tfc.common.TFCItemGroup;
import net.dries007.tfc.common.blockentities.DecayingBlockEntity;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.crop.DecayingBlock;
import net.dries007.tfc.common.items.DecayingBlockItem;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public class FarmersDelightBlocks{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "farmersdelight");

	public static final RegistryObject<Block> ROTTEN_RICE_BAG = register("rotten_rice_bag", () -> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD)), TFCItemGroup.FLORA);
	public static final RegistryObject<Block> RICE_BAG = register("rice_bag", () -> new DecayingBlock(ExtendedProperties.of(Material.VEGETABLE, MaterialColor.WOOL).sound(SoundType.WOOL).blockEntity(FarmersDelightBlockEntities.DECAYING).serverTicks(DecayingBlockEntity::serverTick), ROTTEN_RICE_BAG), b -> new DecayingBlockItem(b, new Item.Properties().tab(TFCItemGroup.FLORA)));

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier){
		return register(name, blockSupplier, (Function<T, ? extends BlockItem>)null);
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, CreativeModeTab group){
		return register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties().tab(group)));
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, Item.Properties blockItemProperties){
		return register(name, blockSupplier, block -> new BlockItem(block, blockItemProperties));
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, @Nullable Function<T, ? extends BlockItem> blockItemFactory){
		return RegistrationHelpers.registerBlock(FarmersDelightBlocks.BLOCKS, FarmersDelightItems.ITEMS, name, blockSupplier, blockItemFactory);
	}
}
