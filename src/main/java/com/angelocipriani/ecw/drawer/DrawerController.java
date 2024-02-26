package com.angelocipriani.ecw.drawer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/drawer")
public class DrawerController {
	private final DrawerService service;
    private final DrawerMapper mapper;
	
    @Autowired
	public DrawerController(DrawerService service, DrawerMapper mapper)
	{
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<Drawer> getDrawers()
	{
		return service.getDrawers();
	}
	
	@PostMapping
	public void addDrawer(@RequestBody DrawerDTO drawerDTO)
	{
		Drawer drawer = mapper.toDrawer(drawerDTO);
		service.addDrawer(drawer);
	}
	
	@PostMapping("add-item")
	public void addItemToDrawer(@RequestBody ItemInDrawerDTO itemInDrawerDTO)
	{
		System.out.println("Item ID: " + itemInDrawerDTO.itemId + "    Drawer ID: " + itemInDrawerDTO.drawerId);
		service.addItemToDrawer(itemInDrawerDTO.drawerId, itemInDrawerDTO.itemId);
	}
}
