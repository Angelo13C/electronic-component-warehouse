package com.angelocipriani.ecw.drawer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelocipriani.ecw.item.Item;
import com.angelocipriani.ecw.item.ItemRepository;

@Service
public class DrawerService {
	private DrawerRepository drawerRepository;
	private ItemRepository itemRepository;
	
	@Autowired
	public DrawerService(DrawerRepository drawerRepository, ItemRepository itemRepository)
	{
		this.drawerRepository = drawerRepository;
		this.itemRepository = itemRepository;
	}
	
	public List<Drawer> getDrawers()
	{
		return drawerRepository.findAll();
	}

	public void addDrawer(Drawer drawer)
	{
		drawerRepository.save(drawer);
	}
	
	public void addItemToDrawer(Long drawerId, Long itemId)
	{
		Optional<Drawer> optionalDrawer = drawerRepository.findById(drawerId);
		if(optionalDrawer.isPresent())
		{
			Drawer drawer = optionalDrawer.get();
			Optional<Item> optionalItem = itemRepository.findById(itemId);
			if(optionalItem.isPresent())
			{
				drawer.addItem(optionalItem.get());
				drawerRepository.save(drawer);
			}
		}
	}
}
