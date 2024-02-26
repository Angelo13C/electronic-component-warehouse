package com.angelocipriani.ecw.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	private ItemRepository repository;
	
	@Autowired
	public ItemService(ItemRepository repository)
	{
		this.repository = repository;
	}
	
	public List<Item> getItems()
	{
		return repository.findAll();
	}

	public void addItem(Item item)
	{
		repository.save(item);
	}

	public void addTagOnItem(String tag, Item item)
	{

	}
	
	public void deleteItem(Item item)
	{
		repository.delete(item);
	}
}
