package trinsdar.gtsp.data;

import muramasa.antimatter.util.TagUtils;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;



public class CustomTags {


    public static ITag.INamedTag<Item> getTag(String id){
        return TagUtils.getForgeItemTag(id);
    }
}
