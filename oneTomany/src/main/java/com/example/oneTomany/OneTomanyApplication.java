package com.example.oneTomany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.oneTomany.Model.Items;
import com.example.oneTomany.Model.Restaurant;
import com.example.oneTomany.Service.RestService;

@SpringBootApplication
public class OneTomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneTomanyApplication.class, args);

	}

	@Autowired
	private RestService service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Items item1 = new Items("eggrice", "veg");
		Items item2 = new Items("friedrice", "veg");
		Items item3 = new Items("manchuria", "nonveg");

		Items item4 = new Items("biryani", "veg");
		Items item5 = new Items("rice", "veg");

		List<Items> itemsList1 = Arrays.asList(item1, item2, item3);
		Set<Items> itemsSet1 = new HashSet<>(itemsList1);

		List<Items> itemsList2 = Arrays.asList(item4, item5);
		Set<Items> itemsSet2 = new HashSet<>(itemsList2);

		Restaurant rest1 = new Restaurant("RB", "st", itemsSet1);
		Restaurant rest2 = new Restaurant("nasa", "nt", itemsSet2);

		service.addRes(rest1);
		service.addRes(rest2);

		// Rest of your code

	}

}
