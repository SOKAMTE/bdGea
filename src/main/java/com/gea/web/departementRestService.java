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

import com.gea.dao.departementRepository;
import com.gea.entities.departement;

@RestController
@CrossOrigin("*")
public class departementRestService {
	
	@Autowired
	private departementRepository departementRepository;
	
	@RequestMapping(value = "/getAllDepartement", method=RequestMethod.GET)
	public List<departement> getAllDepartement() {
		return departementRepository.findAll();
	}
	
	@RequestMapping(value = "/saveDepartement", method=RequestMethod.POST)
	public departement saveDepartement(@RequestBody departement dpt){
		return departementRepository.save(dpt);
	}
	
	@RequestMapping(value = "/deleteDepartement/{id}", method=RequestMethod.DELETE)
	public boolean deleteDepartement(@PathVariable Long id){
		departementRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateDepartement/{id}", method=RequestMethod.PUT)
	public departement updateDepartement(@PathVariable Long id, @RequestBody departement dpt){
		return departementRepository.save(dpt);
	}
	
	@RequestMapping(value = "/searchDepartement", method=RequestMethod.GET)
	public Page<departement> searchDepartement(@RequestParam(name="mDpt", defaultValue = "") String mDpt, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return departementRepository.searchDepartement("%"+mDpt+"%", PageRequest.of(page, size));
	}
	

}
