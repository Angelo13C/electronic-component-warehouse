package com.angelocipriani.ecw.item;

import org.springframework.stereotype.Component;

import com.angelocipriani.ecw.item.tag.ItemTag;

@Component
public class ItemMapper {
    public Item toItem(ItemDTO itemDTO) {
    	Item item = new Item();
    	
    	for (String tag : itemDTO.tags)
    	{    		
    		item.addTag(new ItemTag(tag));
    	}
        
        return item;
    }
}
