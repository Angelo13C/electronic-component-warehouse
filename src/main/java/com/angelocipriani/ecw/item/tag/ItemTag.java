package com.angelocipriani.ecw.item.tag;

import java.util.Set;

import com.angelocipriani.ecw.item.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class ItemTag {
	@Id
	public String label;

    @ManyToMany(mappedBy = "tags")
    private Set<Item> items;

	public ItemTag() {
		super();
	}

	public ItemTag(String label) {
		super();
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "ItemTag: " + label;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
