package nl.theepicblock.polypuck;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.impl.screenhandler.client.ClientNetworking;

public class PolyPuckClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(PolyPuck.CHANNEL_ID, (client,handler,packet,sender) -> {
			//We're not handling the packet, only registering the channel so the server can pick it up.
		});
	}
}
