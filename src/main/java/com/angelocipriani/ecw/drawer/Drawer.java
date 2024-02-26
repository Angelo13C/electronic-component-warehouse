package com.angelocipriani.ecw.drawer;

import java.util.HashSet;
import java.util.Set;

import com.angelocipriani.ecw.item.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Drawer {
	@Id
	@SequenceGenerator(
			name = "drawer_sequence",
			sequenceName = "drawer_sequence"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "drawer_sequence"
	)
	public Long id;

	public Integer x;
	public Integer y;

    @ManyToMany
    @JoinTable(
        name = "item_in_drawer",
        joinColumns = @JoinColumn(name = "drawer_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    public Set<Item> items;
	
	public Drawer() {
		super();
	}

	public Drawer(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
		this.items = new HashSet<Item>();
	}

	@Override
	public String toString() {
		return "Drawer: ID = " + id + "\nX = " + x + "    Y = " + y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void addItem(Item item)
	{
		this.items.add(item);
	}
}
