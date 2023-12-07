package com.example.taba42.service;

import com.example.taba42.domain.Calendar;
import com.example.taba42.dto.response.CalendarResponse;
import com.example.taba42.dto.request.ScheduleAdd;
import com.example.taba42.exception.CalendarException;
import com.example.taba42.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

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
    public CalendarResponse calendarInfo(String date) {
        Calendar calendar = getToDoListByDate(date);
        return CalendarResponse.from(calendar);
    }
    private Calendar getToDoListByDate(String date) {
        return calendarRepository.findByDate(date).orElseThrow(
                () -> new CalendarException("해당 날짜에 스케줄 정보가 존재하지 않습니다.")
        );
    }
}
