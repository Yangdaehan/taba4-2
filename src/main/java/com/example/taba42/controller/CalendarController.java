package com.example.taba42.controller;

import com.example.taba42.dto.response.CalendarResponse;
import com.example.taba42.dto.request.ScheduleAdd;
import com.example.taba42.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/scheduleAdd")
    ResponseEntity<String> scheduleAdd(@Valid @RequestBody ScheduleAdd request) {
        Long calendarId = calendarService.ScheduleAdd(request);
        return ResponseEntity.ok().body("일정이 추가되었습니다");
    }


    @GetMapping("{date}")
    ResponseEntity<CalendarResponse> calendarInfo(@PathVariable String date) {
        CalendarResponse calendarResponse = calendarService.calendarInfo(date);
        return ResponseEntity.ok().body(calendarResponse);
    }
}
