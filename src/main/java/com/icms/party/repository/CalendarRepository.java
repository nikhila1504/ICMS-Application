package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Calendar;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar,Integer>{

}