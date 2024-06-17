package com.example.csvfileupload.service;

import com.example.csvfileupload.Model.Weekdays;
import com.example.csvfileupload.repository.Weekrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class WeekService {

    @Autowired
    private Weekrepo weeks;

    public void saveData() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/weekday.csv"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    try {
                        Weekdays week = new Weekdays();
                        week.setDay(fields[0]);
                        week.setShortday(fields[1]);
                        week.setNum1(Integer.parseInt(fields[2].trim()));
                        week.setNum2(Integer.parseInt(fields[3].trim()));
                        weeks.save(week);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in line: " + line);
                        // Handle the invalid number format case
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                    // Handle the case where the line does not have enough fields
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Page<Weekdays> getWeekdays(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return weeks.findAll(pageable);
    }
}
