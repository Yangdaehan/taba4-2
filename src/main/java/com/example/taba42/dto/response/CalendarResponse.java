package com.example.taba42.dto.response;

import com.example.taba42.domain.Calendar;
import lombok.Getter;

@Getter
public class CalendarResponse {

    private String toDoList;

    public CalendarResponse(String toDoList) {

        this.toDoList = toDoList;
    }

    public static CalendarResponse from(Calendar calendar) {
        return new CalendarResponse(

                calendar.getToDoList()

                );
    }
}
