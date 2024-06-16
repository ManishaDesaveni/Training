package com.example.Springframework_Game.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Webcontroller {
	@Autowired
	private Business business;

	public long returnval() {
		return business.calsum();
	}

}

@Component
class Business {
	@Autowired
	private Data data;

	public long calsum() {
		List<Integer> datas = data.listdata();
		return datas.stream().reduce(Integer::sum).get();

	}
}

@Component
class Data {
	public List<Integer> listdata() {
		return Arrays.asList(1, 2, 3, 4);
	}
}
