package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Slot;

@Repository
public interface SlotRepository extends CrudRepository<Slot,Integer>{

}
