package com.icms.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icms.party.entity.Party;
import com.icms.party.repository.PartyRepository;

@Service
public class PartyServiceImpl {

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Party> getAllParties() {
		// TODO Auto-generated method stub
		List<Party> Partys = (List<Party>) partyRepository.findAll();
//		ResponseEntity<List<PartyDetail>> responseEntity = restTemplate.exchange(
//				"http://localhost:8080/getAllPartyDetails", HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<PartyDetail>>() {
//				});
//		List<PartyDetail> studetail = responseEntity.getBody();
//		Partys.stream().forEach(stu -> {
//			ArrayList<PartyDetail> list = new ArrayList<>();
//			studetail.stream().forEach(std -> {
//				if (stu.getId() == std.getId()) {
//					list.add(std);
//				}
//			});
//			//stu.setPartyDetail(list);
//		});
		return Partys;
	}

	public Party saveParty(Party party) {
		Party stu = partyRepository.save(party);
		return stu;
	}

	public Party getPartyById(int id) {
//		Party service = partyRepository.findById(id).orElse(null);
//
//		String res = "http://localhost:8080/savePartyDetail";
//
//		ResponseEntity<PartyDetail> response = restTemplate
//				.getForEntity("http://localhost:8080/getPartyDetail/" + "/" + id, PartyDetail.class);
//
//		PartyDetail st = response.getBody();
//		List<PartyDetail> Party = new ArrayList();
//		Party.add(st);
		//service.setPartyDetail(Party);
		// return partyRepository.findById(id).orElse(null);
		return partyRepository.findById(id).orElse(null);
	}

	public Party updateParty(Party party) {
		return partyRepository.save(party);
	}

	public void deletePartyById(int id) {
		partyRepository.deleteById(id);
	}

}
