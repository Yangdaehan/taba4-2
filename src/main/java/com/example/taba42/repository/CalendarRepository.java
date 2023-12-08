package com.example.taba42.repository;

import com.example.taba42.domain.Calendar;
import com.example.taba42.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {


    Optional<Calendar> findByDate(String date);
    // 선언만 한것
    // SELECT * FROM calendar WHERE DAYA = date
    //Optional -> null point exception 을 방지

}
