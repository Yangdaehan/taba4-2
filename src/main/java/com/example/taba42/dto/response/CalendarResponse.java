package com.example.taba42.dto.response;

import com.example.taba42.domain.Calendar;
import lombok.Getter;

@Getter
public class CalendarResponse {

    private Long id;

    private String date;

    private String toDoList;

//    private String mid;

    public CalendarResponse(Long id, String date, String toDoList) {
        this.id = id;
        this.date = date;
        this.toDoList = toDoList;
    }
//
//    private String phoneNumber;

//    public CalendarResponse(Long id, String name, int age, String mid, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.mid = mid;
//        this.phoneNumber = phoneNumber;
//    }

    public static CalendarResponse from(Calendar calendar) {
        return new CalendarResponse(
                calendar.getId(),
                calendar.getDate(),
                calendar.getToDoList()
                );
    }
}
