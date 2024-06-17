package com.example.csvfileupload.Controller;

import com.example.csvfileupload.Model.Weekdays;
import com.example.csvfileupload.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
public class WeekController {

    @Autowired
    private WeekService weekservice;
    @RequestMapping(path="/weekdays")
    public void weekdays() throws FileNotFoundException {
        weekservice.saveData();

    }
    @GetMapping("/pagedweekdays/{page}/{size}/{sortBy}")
    public Page<Weekdays> getWeekdays(@PathVariable Integer page,
                                      @PathVariable Integer size,
                                      @PathVariable String sortBy) {
        return weekservice.getWeekdays(page, size, sortBy);
    }
}
