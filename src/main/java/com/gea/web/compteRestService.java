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

import com.gea.dao.compteRepository;
import com.gea.entities.compte;

@RestController
@CrossOrigin("*")
public class compteRestService {
	
	@Autowired
	private compteRepository compteRepository;
	
	@RequestMapping(value = "/getAllCompte", method=RequestMethod.GET)
	public List<compte> getAllCompte() {
		return compteRepository.findAll();
	}
	
	@RequestMapping(value = "/saveCompte", method=RequestMethod.POST)
	public compte saveAgence(@RequestBody compte cpt){
		return compteRepository.save(cpt);
	}
	
	@RequestMapping(value = "/deleteCompte/{id}", method=RequestMethod.DELETE)
	public boolean deleteCompte(@PathVariable Long id){
		compteRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/modifyCompte/{id}", method=RequestMethod.PUT)
	public compte modifyCompte(@PathVariable Long id, @RequestBody compte cpt){
		return compteRepository.save(cpt);
	}
	
	@RequestMapping(value = "/searchCompte", method=RequestMethod.GET)
	public Page<compte> searchCompte(@RequestParam(name="mCpt", defaultValue = "") String mCpt, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return compteRepository.searchCompte("%"+mCpt+"%", PageRequest.of(page, size));
	}
	

}
