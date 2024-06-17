package com.example.csvfileupload.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Weekdays {

    @Id
    private String day;
    private String  shortday;
    private Integer num1;
    private Integer num2;

    public String getDay() {
        return day;
    }

    public String getShortday() {
        return shortday;
    }

    public Integer getNum1() {
        return num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setShortday(String shortday) {
        this.shortday = shortday;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Weekdays{" +
                "day='" + day + '\'' +
                ", shortday='" + shortday + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
