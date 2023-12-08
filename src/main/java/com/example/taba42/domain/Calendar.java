package com.example.taba42.domain;

import com.example.taba42.dto.request.ScheduleAdd;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "calendar")
@Entity
public class Calendar {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name="daya")
    @NotNull
    private String date;


    //@Column(name="aasdfajjjnjnkdsfasfaa")
    @NotNull
    private String toDoList;

    protected Calendar(){

    }
    public Calendar(String date, String toDoList) {
        this.date = date;
        this.toDoList = toDoList;
    }

    public static Calendar from(ScheduleAdd request) {
        return new Calendar(
                request.getDate(),
                request.getToDoList()
                );
    }
}
