package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Party;

@Repository
public interface PartyRepository extends CrudRepository<Party,Integer>{

}
