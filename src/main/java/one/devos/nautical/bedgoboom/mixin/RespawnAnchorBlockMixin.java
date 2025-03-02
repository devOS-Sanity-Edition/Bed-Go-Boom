package one.devos.nautical.bedgoboom.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import one.devos.nautical.bedgoboom.Boom;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RespawnAnchorBlock.class)
public class RespawnAnchorBlockMixin {
    @Inject(method = "canSetSpawn", at = @At(value = "HEAD"), cancellable = true)
    private static void youShallNotSet(Level level, CallbackInfoReturnable<Boolean> cir) {
        if (level.dimension() == Level.END && Boom.CONFIG.shouldAllowAnchorInEnd()) {
            cir.setReturnValue(true);
        }
    }
}
