package com.example.oneTomany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oneTomany.Model.Restaurant;

@Repository
public interface ResRepository extends JpaRepository<Restaurant, Integer> {

}
