package trinsdar.gtsp.data;

import com.oblivioussp.spartanweaponry.init.ModItems;
import muramasa.antimatter.Data;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.material.MaterialTag;
import muramasa.antimatter.material.MaterialType;
import muramasa.antimatter.material.MaterialTypeItem;
import muramasa.antimatter.material.TextureSet;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.items.MaterialItemToolPart;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.Data.KNIFE;
import static muramasa.antimatter.Data.MORTAR;
import static muramasa.antimatter.Data.PLATE;
import static muramasa.antimatter.material.Element.Fe;
import static net.minecraft.item.ItemTier.IRON;

public class Materials {
    public static MaterialTypeItem<?> POLE = new MaterialTypeItem<>("pole", 1, true, muramasa.antimatter.Ref.U * 2, new MaterialTypeItem.ItemSupplier() {
        @Override
        public MaterialItem supply(String domain, MaterialType<?> type, Material material) {
            return new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS));
        }
    });
    public static MaterialTypeItem<?> HANDLE = new MaterialTypeItem<>("handle_sp", 1, true, muramasa.antimatter.Ref.U * 2, new MaterialTypeItem.ItemSupplier() {
        @Override
        public MaterialItem supply(String domain, MaterialType<?> type, Material material) {
            return new MaterialItemToolPart(Ref.ID, type, material, new Item.Properties().group(muramasa.antimatter.Ref.TAB_MATERIALS));
        }

        @SuppressWarnings("unchecked")
        public ITag.INamedTag<Item> getMaterialTag(Material m) {
            return (ITag.INamedTag<Item>) this.tagFromString(String.join("", "handle", "/", m.getId()));
        }

        protected ITag.INamedTag<?> tagFromString(String name) {
            return TagUtils.getForgeItemTag(name);
        }
    });

    public static Material Iron = new Material(Ref.ID, "iron", 0xc8c8c8, TextureSet.NONE, Fe).asMetal(1811, 500, ORE, PLATE, ROD).asPlasma().addTools(IRON.getAttackDamage(), IRON.getEfficiency(), 256, IRON.getHarvestLevel(),  of(Enchantments.SHARPNESS, 1));
    public static Material Flint = new Material(Ref.ID, "flint", 0x002040, TextureSet.NONE).asDust(GEM).addTools(1.25F, 2.5F, 128, 1, of(Enchantments.FIRE_ASPECT, 1), PICKAXE, AXE, SHOVEL, SWORD, HOE, MORTAR, KNIFE);
    public static Material Wood = new Material(Ref.ID, "wood", 0x643200, TextureSet.NONE).asDust(PLATE).addHandleStat(12, 0.0F);


    public static void init(){
        Material wood = Material.get("wood");
        if (wood != Data.NULL){
            HANDLE.forceOverride(wood, ModItems.handle);
            POLE.forceOverride(wood, ModItems.pole);
        }
        Data.Stone.flags(HANDLE, POLE);
        MaterialTag.HANDLE.all().forEach(m -> {
            if (m.getId().equals("wood")) return;
            m.flags(HANDLE, POLE);
        });
    }
}
