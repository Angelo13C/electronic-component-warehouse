package com.angelocipriani.ecw.item.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/item-tag")
public class ItemTagController {
	private final ItemTagService service;
	private final ItemTagMapper mapper;

    @Autowired
	public ItemTagController(ItemTagService service, ItemTagMapper mapper)
	{
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ItemTag> getItemTags()
	{
		return service.getItemTags();
	}
	
	@PostMapping
	public void addItemTag(@RequestBody ItemTagDTO tagDTO)
	{
		ItemTag tag = this.mapper.toItemTag(tagDTO);
		service.addItemTag(tag);
	}

    @DeleteMapping
    public void deleteTag(@RequestBody ItemTagDTO tagDTO) {
		ItemTag tagToDelete = this.mapper.toItemTag(tagDTO);
		for(ItemTag tag : service.getItemTags())
		{
			if(tag.getLabel().equals(tagToDelete.getLabel()))
				service.deleteItemTag(tag);
		}		
    }
}
