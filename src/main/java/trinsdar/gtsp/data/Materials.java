package trinsdar.gtsp.data;

public class Materials {
    //public static Material Iron = new Material(GTSPRef.ID, "iron", 0xc8c8c8, TextureSet.NONE, Fe).asMetal(1811, 500, ORE, PLATE, ROD).asPlasma().addTools(IRON.getAttackDamage(), IRON.getEfficiency(), 256, IRON.getHarvestLevel());
    //public static Material TungstenSteel = new Material(GTSPRef.ID, "tungstensteel", 0x6464a0, TextureSet.NONE).asMetal(3000, 3000, PLATE, ROD, GEAR).addTools(6.0F, 10.0F, 5120, 4);
    //public static Material Flint = new Material(GTSPRef.ID, "flint", 0x002040, TextureSet.NONE).asDust(GEM).addTools(1.25F, 2.5F, 128, 1, of(Enchantments.FIRE_ASPECT, 1), PICKAXE, AXE, SHOVEL, SWORD, HOE, MORTAR, KNIFE);
    //public static Material Wood = new Material(GTSPRef.ID, "wood", 0x643200, TextureSet.NONE).asDust(PLATE).addHandleStat(12, 0.0F);
    //public static Material Netherite = new Material(GTSPRef.ID, "netherite", 0x504650, TextureSet.NONE).asMetal(2246,1300, PLATE, ROD).addTools(3.0F, 10, 500, NETHERITE.getHarvestLevel(), of(Enchantments.FIRE_ASPECT, 3)).addArmor(new int[]{0, 1, 1, 0}, 0.5F, 0.1F, 20);

    public static void init(){
        /*MaterialTags.HANDLE.all().forEach(m -> {
            if (m.getId().equals("wood") || m == Material.NULL) return;
            m.flags(HANDLE, POLE);
        });*/
    }
}
