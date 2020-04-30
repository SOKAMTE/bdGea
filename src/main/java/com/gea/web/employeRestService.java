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

import com.gea.dao.employeRepository;
import com.gea.entities.employe;

@RestController
@CrossOrigin("*")
public class employeRestService {
	
	@Autowired
	private employeRepository employeRepository;
	
	@RequestMapping(value = "/getAllEmploye", method=RequestMethod.GET)
	public List<employe> getAllEmploye() {
		return employeRepository.findAll();
	}
	
	@RequestMapping(value = "/saveEmploye", method=RequestMethod.POST)
	public employe saveEmploye(@RequestBody employe empl){
		return employeRepository.save(empl);
	}
	
	@RequestMapping(value = "/deleteEmploye/{id}", method=RequestMethod.DELETE)
	public boolean deleteEmploye(@PathVariable Long id){
		employeRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateEmploye/{id}", method=RequestMethod.PUT)
	public employe updateEmploye(@PathVariable Long id, @RequestBody employe empl){
		return employeRepository.save(empl);
	}
	
	@RequestMapping(value = "/searchEmploye", method=RequestMethod.GET)
	public Page<employe> searchEmploye(@RequestParam(name="mEmpl", defaultValue = "") String mEmpl, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return employeRepository.searchEmploye("%"+mEmpl+"%", PageRequest.of(page, size));
	}

}
