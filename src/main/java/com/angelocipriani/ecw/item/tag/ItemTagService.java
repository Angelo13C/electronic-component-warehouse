package com.angelocipriani.ecw.item.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTagService {
	private ItemTagRepository repository;
	
	@Autowired
	public ItemTagService(ItemTagRepository repository)
	{
		this.repository = repository;
	}
	
	public List<ItemTag> getItemTags()
	{
		return repository.findAll();
	}

	public void addItemTag(ItemTag tag)
	{
		System.out.println(tag);
		repository.save(tag);
	}
}
