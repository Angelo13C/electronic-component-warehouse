package com.angelocipriani.ecw.item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.angelocipriani.ecw.drawer.Drawer;
import com.angelocipriani.ecw.item.tag.ItemTag;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Item {
	@Id
	@SequenceGenerator(
			name = "item_sequence",
			sequenceName = "item_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "item_sequence"
	)
	public Long id;

    @ManyToMany
    @JoinTable(
        name = "tag_of_item",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    public Set<ItemTag> tags;

    @ManyToMany(mappedBy = "items")
    private Set<Drawer> drawers;

	public Item() {
		super();
		this.tags = new HashSet<ItemTag>();
		this.drawers = new HashSet<Drawer>();
	}
	
	@Override
	public String toString() {
		return "Item: ID = " + id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addTag(ItemTag tag)
	{
		this.tags.add(tag);
	}

	public String getTagsAsString(String separator)
	{
		String result = "";
		
		List<String> sortedTags = tags.stream().map(tag -> tag.getLabel())
									.sorted().collect(Collectors.toList());
		for(String tag : sortedTags)
			result += tag + separator;
		
		//Remove the last separator
		if(!result.isEmpty())
			result = result.substring(0, result.length() - separator.length());
		
		return result;
	}
}
