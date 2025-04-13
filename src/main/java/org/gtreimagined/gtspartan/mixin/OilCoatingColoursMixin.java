package org.gtreimagined.gtspartan.mixin;

import com.oblivioussp.spartanweaponry.client.OilCoatingColours;
import net.minecraft.world.item.ItemStack;
import org.gtreimagined.gtlib.tool.IGTTool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OilCoatingColours.class)
public abstract class OilCoatingColoursMixin {

    @Inject(method = "lambda$static$0", at = @At("HEAD"), cancellable = true)
    private static void injectColorCheck(ItemStack stack, int idx, CallbackInfoReturnable<Integer> cir){
        if (idx != 100 && stack.getItem() instanceof IGTTool tool){
            cir.setReturnValue(tool.getItemColor(stack, null, idx));
        }
    }
}
