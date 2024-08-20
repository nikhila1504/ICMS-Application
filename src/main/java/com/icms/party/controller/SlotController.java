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

import com.icms.party.entity.Slot;
import com.icms.party.service.SlotServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Slot Service", description = "Slot Details",produces ="application/json")
@CrossOrigin
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	private SlotServiceImpl slotService;
	
	@GetMapping("/slotList")
	@ApiOperation(value = "get all parties")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Slot> listparties() {
		return slotService.getAllSlotList();
	}
	
	@PostMapping("/saveSlot")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@ApiOperation(value = "save Slot details")
	public Slot saveSlot(@RequestBody Slot Slot) {
		return slotService.saveSlot(Slot);
	}
	
	@PutMapping("/updateSlot/{id}")
	@ApiOperation(value = "update Slot details")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Slot updateSlot(@RequestBody Slot slot) {
		// save updated Slot object
		return slotService.updateSlot(slot);
	}
	
	// handler method to handle delete Slot request
	
	@DeleteMapping("/deleteSlot/{id}")
	@ApiOperation(value = "delete Slot")
	@PreAuthorize("hasRole('ADMIN')or hasRole('ADMIN')")
	public void deleteSlotById(@PathVariable int id) {
		 slotService.deleteSlotById(id);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "get Slot by id")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public Slot getSlotById(@PathVariable int id) {
		return slotService.getSlotById(id);
	}
	
	


}
