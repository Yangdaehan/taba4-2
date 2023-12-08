package com.example.taba42.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ScheduleAdd {

    // 형식을 11-13 이런식으로 통일
    @NotNull
    private String date;


    @NotNull
    private String  toDoList;

    public ScheduleAdd() {
    }
    public ScheduleAdd(String date, String toDoList) {
        this.date = date;
        this.toDoList = toDoList;
    }

}
