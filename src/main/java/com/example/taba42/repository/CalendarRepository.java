package com.example.taba42.repository;

import com.example.taba42.domain.Calendar;
import com.example.taba42.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
