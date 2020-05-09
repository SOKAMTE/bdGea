package com.gea.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gea.dao.agenceRepository;
import com.gea.entities.agence;

@RestController
@CrossOrigin("*")
public class agenceRestService {
	
	@Autowired
	private agenceRepository agenceRepository;
	
	@RequestMapping(value = "/getAllAgence", method=RequestMethod.GET)
	public Page<agence> getAllAgence(@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size) {
		return agenceRepository.findAll(PageRequest.of(page, size));
	}
	
	@RequestMapping(value = "/saveAgence", method=RequestMethod.POST)
	public agence saveAgence(@RequestBody agence agc){
		return agenceRepository.save(agc);
	}
	
	@RequestMapping(value = "/deleteAgence/{id}", method=RequestMethod.DELETE)
	public boolean deleteAgence(@PathVariable Long id){
		agenceRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateAgence/{id}", method=RequestMethod.PUT)
	public agence updateAgence(@PathVariable Long id, @RequestBody agence agc){
		return agenceRepository.save(agc);
	}
	
	@RequestMapping(value = "/searchAgence", method=RequestMethod.GET)
	public Page<agence> searchAgence(@RequestParam(name="nAgc", defaultValue = "") String cAgc, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return agenceRepository.searchAgence("%"+cAgc+"%", PageRequest.of(page, size));
	}
	

}
