package zoniic645.firmasdelight;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import zoniic645.firmasdelight.common.FarmersDelightBlockEntities;
import zoniic645.firmasdelight.common.FarmersDelightBlocks;
import zoniic645.firmasdelight.common.FarmersDelightItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("firmasdelight")
public class FirmasDelight{
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public FirmasDelight(){

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		FarmersDelightBlocks.BLOCKS.register(bus);
		FarmersDelightItems.ITEMS.register(bus);
		FarmersDelightBlockEntities.BLOCK_ENTITIES.register(bus);
	}
}
