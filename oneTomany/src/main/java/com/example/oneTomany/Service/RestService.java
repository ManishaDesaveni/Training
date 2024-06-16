package com.example.oneTomany.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oneTomany.Model.Restaurant;
import com.example.oneTomany.Repository.ResRepository;

@Service
public class RestService implements ResInterface {

	@Autowired
	private ResRepository resrepo;

	@Override
	public Restaurant addRes(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return resrepo.save(restaurant);
	}

}
