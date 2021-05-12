package trinsdar.gtsp.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.trait.IMeleeTraitCallback;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.item.SwordBaseItem;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.tool.AntimatterItemTier;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import trinsdar.gtsp.tool.GTSPToolType;
import trinsdar.gtsp.tool.GTSPWeaponMaterial;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MaterialSwordBig extends SwordBaseItem implements IAntimatterTool, IMaterialItemSpartan {
    GTSPToolType type;
    String domain;
    public MaterialSwordBig(String domain, GTSPToolType type, Properties prop) {
        super(type.getId(), prop, GTSPWeaponMaterial.NULL, type.getBaseAttackDamage(), 1, type.getBaseAttackSpeed(), type.getWeaponTraits());
        this.type = type;
        this.domain = domain;
        AntimatterAPI.register(IAntimatterTool.class, getId(), this);
    }

    @Override
    public AntimatterToolType getType() {
        return type;
    }

    @Override
    public ItemStack asItemStack(Material primary, Material secondary) {
        return type.getToolStack(primary, secondary);
    }

    @Override
    public String getId() {
        return type.getId();
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Nonnull
    @Override
    public Set<ToolType> getToolTypes(ItemStack stack) {
        return getToolTypes();
    }

    @Override
    public void onItemModelBuild(IItemProvider item, AntimatterItemModelProvider prov) {
        prov.tex(item, getParent(), getTextures());
    }

    @Override
    public String getParent() {
        return SpartanWeaponryAPI.MOD_ID + ":item/" + getId() + "_wood";
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            modifiers.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", type.getBaseAttackDamage() + getTier(stack).getAttackDamage(), AttributeModifier.Operation.ADDITION));
            modifiers.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", type.getBaseAttackSpeed(), AttributeModifier.Operation.ADDITION));
            IMeleeTraitCallback callback;
            if (this.traits != null) {
                for (WeaponTrait property : this.traits){
                    callback = property.getMeleeCallback();
                    if (callback != null) {
                        callback.onModifyAttibutesMelee(modifiers);
                    }
                }
            }

            if (this.getMaterial(stack).hasAnyWeaponTrait()) {
                for (WeaponTrait property : this.getMaterial(stack).getAllWeaponTraits()){
                    callback = property.getMeleeCallback();
                    if (callback != null) {
                        callback.onModifyAttibutesMelee(modifiers);
                    }
                }
            }
        }

        return modifiers;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        boolean isShiftPressed = Screen.hasShiftDown();
        if (this.getMaterial(stack).hasAnyWeaponTrait()) {
            tooltip.add((new TranslationTextComponent(String.format("tooltip.%s.traits.material_bonus", "spartanweaponry"))).mergeStyle(TextFormatting.DARK_AQUA));
            for (WeaponTrait trait : this.getMaterial(stack).getAllWeaponTraits()){
                trait.addTooltip(stack, tooltip, isShiftPressed);
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMeleeTraitCallback callback;
        for (WeaponTrait trait : this.getMaterial(stack).getAllWeaponTraits()){
            callback = trait.getMeleeCallback();
            if (callback != null) {
                callback.onHitEntity(this.material, stack, target, attacker, (Entity)null);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }

    public WeaponMaterial getMaterial(ItemStack stack) {
        return GTSPWeaponMaterial.getOrCreate(this.getPrimaryMaterial(stack), this.getSecondaryMaterial(stack));
    }
}
