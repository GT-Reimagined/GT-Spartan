package trinsdar.gtsp.datagen;


import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.block.BlockStone;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import muramasa.antimatter.item.ItemFluidCell;
import muramasa.antimatter.machine.BlockMachine;
import muramasa.antimatter.material.MaterialItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import trinsdar.gtsp.Ref;
import trinsdar.gtsp.block.BlockCasing;
import trinsdar.gtsp.block.BlockCasingMachine;
import trinsdar.gtsp.block.BlockTurbineCasing;
import trinsdar.gtsp.data.GT4RData;
import trinsdar.gtsp.data.Machines;
import trinsdar.gtsp.items.ItemIntCircuit;
import net.minecraft.data.DataGenerator;
import trinsdar.gtsp.items.ItemMatch;

import static muramasa.antimatter.machine.Tier.MV;
import static muramasa.antimatter.util.Utils.lowerUnderscoreToUpperSpaced;
import static muramasa.antimatter.util.Utils.lowerUnderscoreToUpperSpacedRotated;

public class GT4RLocalizations {

    public static class en_US extends AntimatterLanguageProvider {

        public en_US(DataGenerator gen) {
            super(Ref.ID, Ref.NAME + " en_us Localization", "en_us", gen);
        }

        @Override
        protected void addTranslations() {
            super.addTranslations();
            add(Ref.ID + ".advancements.gtsp", "GT4 Renewed");
            add(Ref.ID + ".advancements.gtsp.desc", "Getting familiar with your surroundings");
            add(Ref.ID + ".tooltip.occurrence", "Indicates occurrence of ");
            add("block.gtsp.rubber_leaves", "Rubber Leaves");
            add("block.gtsp.rubber_log", "Rubber Log");
            add("block.gtsp.rubber_sapling", "Rubber Sapling");
            add("attribute.name.generic.gtsp.attackReach", "Attack Reach");;
        }

        @Override
        protected void processTranslations(String domain, String locale) {
            super.processTranslations(domain, locale);
            AntimatterAPI.all(BlockCasing.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(ItemMatch.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(ItemIntCircuit.class, domain).forEach(i -> add(i, "Integrated Circuit (" + i.circuitId + ")"));
            add(GT4RData.MixedMetal, lowerUnderscoreToUpperSpaced(GT4RData.MixedMetal.getId()));
            add(GT4RData.SAP_BAG, lowerUnderscoreToUpperSpaced(GT4RData.SAP_BAG.getId()));
        }

        @Override
        public void add(Item key, String name) {
            if (key instanceof ItemFluidCell){
                add(key.getTranslationKey(), lowerUnderscoreToUpperSpacedRotated(((ItemFluidCell)key).getId()));
                return;
            }
            if (key instanceof MaterialItem && name.contains("Gem")){
                super.add(key, name.replace(" Gem", ""));
                return;
            }
            super.add(key, name);
        }

        @Override
        public void add(Block key, String name) {
            if (key instanceof BlockStone){
                super.add(key, name.replace("Stone ", ""));
                return;
            }
            super.add(key, name);
        }

        @Override
        public void add(String key, String value) {
            if (key.contains("machine")){
                String id = key.contains("macerator.mv") ? "universal_macerator" : key.contains("electrolyzer") ? key.contains("lv") ? "basic_electrolyzer" : "industrial_electrolyzer" : "";
                super.add(key,  value.contains("Infinite") || value.contains("Transformer") || value.contains("Battery") ? value : (id.isEmpty() ? value.replace("Mv ", "").replace("Lv ", "").replace("Ulv ", "").replace("Hv ", "").replace("Ev ", "") : lowerUnderscoreToUpperSpaced(id)));
                return;
            }
            super.add(key, value);
        }
    }

}
