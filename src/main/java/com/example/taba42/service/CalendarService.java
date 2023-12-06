package com.example.taba42.service;

import com.example.taba42.domain.Calendar;
import com.example.taba42.dto.response.CalendarResponse;
import com.example.taba42.dto.request.ScheduleAdd;
import com.example.taba42.exception.CalendarException;
import com.example.taba42.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Transactional
    public Long ScheduleAdd(ScheduleAdd request) {
        final Calendar calendar = Calendar.from(request);

//        if (scheduleRepository.existsByMid(request.getMid())) {
//            throw new MemberException("중복된 아이디입니다.");
//        }

        calendarRepository.save(calendar);
        return calendar.getId();
    }
    public CalendarResponse calendarInfo(Long CalendarId) {
        Calendar calendar = getToDoListById(CalendarId);
        return CalendarResponse.from(calendar);
    }

    private Calendar getToDoListById(Long calendarId) {
        System.out.println(calendarId);
        return calendarRepository.findById(calendarId).orElseThrow(
                () -> new CalendarException("해당 날짜에 스케줄 정보가 존재하지 않습니다.")
        );
    }
}
