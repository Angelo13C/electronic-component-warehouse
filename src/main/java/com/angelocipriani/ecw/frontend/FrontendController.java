package com.angelocipriani.ecw.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.angelocipriani.ecw.drawer.Drawer;
import com.angelocipriani.ecw.drawer.DrawerService;
import com.angelocipriani.ecw.item.Item;
import com.angelocipriani.ecw.item.ItemService;
import com.angelocipriani.ecw.item.tag.ItemTagService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class FrontendController {
	final int NUMBER_OF_ROWS = 7;
	final int NUMBER_OF_COLUMNS = 7;

	private final DrawerService drawerService;
	private final ItemService itemService;
	private final ItemTagService tagsService;
	
    @Autowired
	public FrontendController(DrawerService drawerService, ItemService itemService, ItemTagService tagsService)
	{
		this.drawerService = drawerService;
		this.tagsService = tagsService;
		this.itemService = itemService;
	}

    @GetMapping("/drawers")
    public String drawersTable(Model model) {
    	// Default the cells to TableRow.EMPTY_CELL
        String[][] cells = new String[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];
        for(int y = 0; y < NUMBER_OF_ROWS; y++)
        {
        	for(int x = 0; x < NUMBER_OF_COLUMNS; x++)
        		cells[x][y] = TableRow.EMPTY_CELL;
        }

    	// Change the value of the cells that have an item in them from the default value to the one
        // contained in the cell
        List<Drawer> drawers = drawerService.getDrawers();
        for(Drawer drawer : drawers)
        {
        	if(!drawer.items.isEmpty())
        	{
            	String cellContent = "";
            	
            	for(Item item : drawer.items)
            		cellContent += item.getTagsAsString(", ") + "\n";

        		//Remove the last "\n"
        		if(!cellContent.isEmpty())
        			cellContent = cellContent.substring(0, cellContent.length() - 1);
        		
            	cells[drawer.getX()][drawer.getY()] = cellContent;
        	}
        }

        List<TableRow> rows = new ArrayList<>();
        for(int i = 0; i < NUMBER_OF_ROWS; i++)
        {
        	rows.add(new TableRow(Integer.toString(i + 1), cells[0][i], cells[1][i], cells[2][i], cells[3][i], cells[4][i], cells[5][i], cells[6][i]));        	
        }
        model.addAttribute("rows", rows);
        
        model.addAttribute("items", getItemList(", "));
        
        return "drawers";
    }

    @PostMapping("/click-drawer")
    public String  clickDrawer(@RequestBody Cell cell, Model model) {
		System.out.println("Cell: " + cell.x + ", " + cell.y);
		
		return drawersTable(model);
    }
    
    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("items", getItemList(" - "));
        
        List<String> tags = tagsService.getItemTags().stream()
        						.map(itemTag -> itemTag.getLabel()).collect(Collectors.toList());
        model.addAttribute("tags", tags);
        
        return "items";
    }
    
    private List<String> getItemList(String separator)
    {
    	return itemService.getItems().stream()
        			.map(item -> item.getTagsAsString(separator))
        			.collect(Collectors.toList());	
    }
    
    @GetMapping("/tags")
    public String tags(Model model) {        
        List<String> tags = tagsService.getItemTags().stream()
        						.map(itemTag -> itemTag.getLabel()).collect(Collectors.toList());
        model.addAttribute("tags", tags);
        
        return "tags";
    }
}
