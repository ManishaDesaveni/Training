package com.example.csvfileupload.repository;

import com.example.csvfileupload.Model.Weekdays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Weekrepo extends JpaRepository<Weekdays,String> {
}
