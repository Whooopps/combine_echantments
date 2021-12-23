package suhail.combine.enchantments.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

@Mixin(ProtectionEnchantment.class)
public class CombineProtectionEnchantMixin extends Enchantment {
    protected CombineProtectionEnchantMixin(Enchantment.Rarity weight, EnchantmentTarget protectionType,
            EquipmentSlot... slotTypes) {
        super(weight, protectionType, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack);
    }

    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if (other instanceof ProtectionEnchantment) {
            cir.setReturnValue(true);
        }
    }

}
