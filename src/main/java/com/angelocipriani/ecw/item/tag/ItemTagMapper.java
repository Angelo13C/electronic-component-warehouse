package com.angelocipriani.ecw.item.tag;

import org.springframework.stereotype.Component;

@Component
public class ItemTagMapper {
    public ItemTag toItemTag(ItemTagDTO itemTagDTO) {
    	ItemTag tag = new ItemTag(itemTagDTO.label);
    	
        return tag;
    }
}
