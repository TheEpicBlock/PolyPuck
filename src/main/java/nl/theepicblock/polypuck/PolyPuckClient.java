package nl.theepicblock.polypuck;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;

public class PolyPuckClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (FabricLoader.getInstance().isModLoaded("polymc")) {
			System.out.println("[PolyPuck] warning: PolyMc should not be installed on the client");
		}
		ClientPlayNetworking.registerGlobalReceiver(PolyPuckServer.CHANNEL_ID, (client, handler, packet, sender) -> {
			//We're not handling the packet, only registering the channel so the server can pick it up.
		});
	}
}
