package com.icms.party.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "calendar")
public class Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calendar_id")
	private int calendarId;
	
	 
	@OneToOne
	 private Party party;
	 
	@JsonManagedReference
	@OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Slot> slot;
	
	@Column(name = "slot_id")
	private int slotId;
	
	@Column(name = "calender_date")
	private LocalDateTime calenderDate;
	
	@Column(name = "deactive_date")
	private LocalDateTime deactiveDate;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "last_updated_date")
	private LocalDateTime lastUpdatedDate;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	
	
	
	
	public Calendar() {
		super();
	}
	

	public int getCalendarId() {
		return calendarId;
	}


	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}


	public int getSlotId() {
		return slotId;
	}


	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}


	public LocalDateTime getCalenderDate() {
		return calenderDate;
	}


	public void setCalenderDate(LocalDateTime calenderDate) {
		this.calenderDate = calenderDate;
	}


	public LocalDateTime getDeactiveDate() {
		return deactiveDate;
	}


	public void setDeactiveDate(LocalDateTime deactiveDate) {
		this.deactiveDate = deactiveDate;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}




	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}


	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Set<Slot> getSlot() {
		return slot;
	}


	public void setSlot(Set<Slot> slot) {
		this.slot = slot;
	}


	public Party getParty() {
		return party;
	}


	public void setParty(Party party) {
		this.party = party;
	}




}
