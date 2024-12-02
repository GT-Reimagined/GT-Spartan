package trinsdar.gtsp.data;

import muramasa.antimatter.util.TagUtils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class CustomTags {


    public static TagKey<Item> getTag(String id){
        return TagUtils.getForgelikeItemTag(id);
    }
}
