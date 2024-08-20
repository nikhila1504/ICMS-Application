package com.icms.party.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.entity.Slot;
import com.icms.party.repository.SlotRepository;

@Service
public class SlotServiceImpl {
	
	@Autowired
	private SlotRepository slotRepository;
	
	public List<Slot> getAllSlotList() {
		return (List<Slot>) slotRepository.findAll();
	
	}
	
	public Slot saveSlot(Slot slot) {
		return slotRepository.save(slot);
	}
	
	public Slot getSlotById(int id) {
		return slotRepository.findById(id).orElse(null);
	}
	
	public Slot updateSlot(Slot slot) {
		return slotRepository.save(slot);
	}

	public void deleteSlotById(int id) {
		slotRepository.deleteById(id);
	}


}
