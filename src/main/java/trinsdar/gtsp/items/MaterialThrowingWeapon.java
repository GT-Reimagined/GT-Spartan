package trinsdar.gtsp.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.oblivioussp.spartanweaponry.api.SpartanWeaponryAPI;
import com.oblivioussp.spartanweaponry.api.WeaponMaterial;
import com.oblivioussp.spartanweaponry.api.WeaponTraits;
import com.oblivioussp.spartanweaponry.api.trait.IMeleeTraitCallback;
import com.oblivioussp.spartanweaponry.api.trait.WeaponTrait;
import com.oblivioussp.spartanweaponry.item.ThrowingWeaponItem;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterItemModelProvider;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;
import muramasa.antimatter.tool.AntimatterToolType;
import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.ToolType;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.tool.GTSPToolType;
import trinsdar.gtsp.tool.GTSPWeaponMaterial;

import javax.annotation.Nonnull;
import java.util.Set;

public class MaterialThrowingWeapon extends ThrowingWeaponItem implements IAntimatterTool, IMaterialItemSpartan {
    GTSPToolType type;
    String domain;
    public MaterialThrowingWeapon(String domain, GTSPToolType type, Properties prop) {
        super(type.getId(), prop, GTSPWeaponMaterial.NULL, type.getBaseAttackDamage(), 1, type.getBaseAttackSpeed(), type.getWeaponTraits());
        this.type = type;
        this.domain = domain;
        AntimatterAPI.register(IAntimatterTool.class, getId(), this);
    }

    @Override
    public AntimatterToolType getAntimatterToolType() {
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
        if (this.hasWeaponTrait(WeaponTraits.THROWABLE)){
            String id = this.getId();
            ItemModelBuilder builder = prov.getBuilder(id +"_throwing");
            builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation(this.getParent() + "_throwing")));
            Texture[] textures = getTextures();
            for (int i = 0; i < textures.length; i++) {
                builder.texture("layer" + i, textures[i]);
            }
            prov.tex(item, getParent(), getTextures()).override().predicate(new ResourceLocation("throwing"), 1).model(new ModelFile.UncheckedModelFile(new ResourceLocation(Ref.ID, "item/" + id +"_throwing")));
            return;
        }
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

    public WeaponMaterial getMaterial(ItemStack stack) {
        return GTSPWeaponMaterial.getOrCreate(this.getPrimaryMaterial(stack), this.getSecondaryMaterial(stack));
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return getMaterial(stack).getMaxUses();
    }
}
