package org.gtreimagined.gtspartan.data;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.gtreimagined.gtlib.util.TagUtils;


public class CustomTags {


    public static TagKey<Item> getTag(String id){
        return TagUtils.getForgelikeItemTag(id);
    }
}
