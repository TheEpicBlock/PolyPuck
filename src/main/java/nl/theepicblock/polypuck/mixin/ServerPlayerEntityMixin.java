package nl.theepicblock.polypuck.mixin;

import io.github.theepicblock.polymc.api.misc.PolyMapProvider;
import io.github.theepicblock.polymc.impl.NOPPolyMap;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
	@Inject(method = "sendResourcePackUrl", at = @At("HEAD"), cancellable = true)
	private void resourcePackInject(String url, String hash, CallbackInfo ci) {
		if (PolyMapProvider.getPolyMap((ServerPlayerEntity)(Object)this) instanceof NOPPolyMap) {
			ci.cancel();
		}
	}
}
