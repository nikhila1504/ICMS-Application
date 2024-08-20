package com.icms.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icms.party.entity.Calendar;
import com.icms.party.service.CalendarServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Calendar Service", description = "Calendar Details",produces ="application/json")
@CrossOrigin
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarServiceImpl calendarService;
	
	@GetMapping("/calendarList")
	@ApiOperation(value = "get all parties")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Calendar> listparties() {
		return calendarService.getAllCalendarList();
	}
	
	@PostMapping("/saveCalendar")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ApiOperation(value = "save Calendar details")
	public Calendar saveCalendar(@RequestBody Calendar calendar) {
		return calendarService.saveCalendar(calendar);
	}
	
	@PutMapping("/updateCalendar/{id}")
	@ApiOperation(value = "update Calendar details")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Calendar updateCalendar(@RequestBody Calendar Calendar) {
		// save updated Calendar object
		return calendarService.updateCalendar(Calendar);
	}
	
	// handler method to handle delete Calendar request
	@DeleteMapping("/deleteCalendar/{id}")
	@ApiOperation(value = "delete Calendar")
	@PreAuthorize("hasRole('ADMIN')or hasRole('ADMIN')")
	public void deleteCalendarById(@PathVariable int id) {
		 calendarService.deleteCalendarById(id);
	}
	
	@GetMapping(value = "/{calendarId}")
	@ApiOperation(value = "get Calendar by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Calendar getCalendarById(@PathVariable int calendarId) {
		return calendarService.getCalendarById(calendarId);
	}
	
	

}
