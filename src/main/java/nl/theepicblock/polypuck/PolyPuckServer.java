package nl.theepicblock.polypuck;

import io.github.theepicblock.polymc.api.PolyMap;
import io.github.theepicblock.polymc.api.misc.PolyMapProvider;
import io.github.theepicblock.polymc.impl.NOPPolyMap;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

public class PolyPuckServer implements DedicatedServerModInitializer {
	private final static PolyMap NOPMAP = new NOPPolyMap();

	@Override
	public void onInitializeServer() {
		if (!FabricLoader.getInstance().isModLoaded("polymc")) {
			throw new IllegalStateException("PolyPuck must be used together with PolyMc on the server");
		}
		PolyMapProvider.EVENT.register(player -> ServerPlayNetworking.canSend(player, PolyPuck.CHANNEL_ID) ? NOPMAP : null);
	}
}
