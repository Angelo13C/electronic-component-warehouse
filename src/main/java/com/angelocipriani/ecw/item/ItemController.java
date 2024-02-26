package com.angelocipriani.ecw.item;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {
	private final ItemService service;
    private final ItemMapper mapper;

    @Autowired
	public ItemController(ItemService service, ItemMapper mapper)
	{
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<Item> getItems()
	{
		return service.getItems();
	}
	
	@PostMapping
	public void addItem(@RequestBody ItemDTO itemDTO)
	{
		Item item = mapper.toItem(itemDTO);
		service.addItem(item);
	}

    @DeleteMapping
    public void deleteItem(@RequestBody ItemDTO itemTags) {
		HashSet<String> tagsOfItemToDelete = new HashSet<String>(Arrays.asList(itemTags.tags));
		for(Item item : service.getItems())
		{
			HashSet<String> tagsOfItem = new HashSet<String>(
					item.tags.stream().map(itemTag -> itemTag.getLabel()).collect(Collectors.toList()));

			if(tagsOfItem.equals(tagsOfItemToDelete))
				service.deleteItem(item);
		}
    }
}
