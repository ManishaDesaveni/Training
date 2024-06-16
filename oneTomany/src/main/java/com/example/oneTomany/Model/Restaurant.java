package com.example.oneTomany.Model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Restaurant {

	@Id
	@SequenceGenerator(name = "restaurant_seq_gen", sequenceName = "restaurant_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "restaurant_gener", strategy = GenerationType.AUTO)

	private int restid;
	private String restName;
	private String type;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rest_id")
	private Set<Items> items;

	public Restaurant() {
		super();
	}

	public Restaurant(String restName, String type, Set<Items> items) {
		super();
		this.restName = restName;
		this.type = type;
		this.items = items;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Restaurant [restid=" + restid + ", restName=" + restName + ", type=" + type + ", items=" + items + "]";
	}

}
