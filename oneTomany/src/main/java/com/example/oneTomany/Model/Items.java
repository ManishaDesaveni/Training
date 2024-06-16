package com.example.oneTomany.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Items {

	@Id
	@GeneratedValue(generator = "item_gener", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "item_seq_gen", sequenceName = "restaurant_sequence", initialValue = 1, allocationSize = 1)

	private int itemid;
	private String itemname;
	private String itemtype;

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(String itemname, String itemtype) {
		super();

		this.itemname = itemname;
		this.itemtype = itemtype;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	@Override
	public String toString() {
		return "Items [itemid=" + itemid + ", itemname=" + itemname + ", itemtype=" + itemtype + "]";
	}

}
