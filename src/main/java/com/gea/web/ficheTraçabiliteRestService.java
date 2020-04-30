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

import com.gea.dao.ficheTraçabiliteRepository;
import com.gea.entities.ficheTraçabilite;

@RestController
@CrossOrigin("*")
public class ficheTraçabiliteRestService {
	
	@Autowired
	private ficheTraçabiliteRepository ficheTraçabiliteRepository;
	
	@RequestMapping(value = "/getAllFicheTraçabilite", method=RequestMethod.GET)
	public List<ficheTraçabilite> getAllFicheTraçabilite() {
		return ficheTraçabiliteRepository.findAll();
	}
	
	@RequestMapping(value = "/saveFicheTraçabilite", method=RequestMethod.POST)
	public ficheTraçabilite saveFicheTraçabilite(@RequestBody ficheTraçabilite ft){
		return ficheTraçabiliteRepository.save(ft);
	}
	
	@RequestMapping(value = "/deleteFicheTraçabilite/{id}", method=RequestMethod.DELETE)
	public boolean deleteFicheTraçabilite(@PathVariable Long id){
		ficheTraçabiliteRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateFicheTraçabilite/{id}", method=RequestMethod.PUT)
	public ficheTraçabilite updateFicheTraçabilite(@PathVariable Long id, @RequestBody ficheTraçabilite ft){
		return ficheTraçabiliteRepository.save(ft);
	}
	
	@RequestMapping(value = "/searchFicheTraçabilite", method=RequestMethod.GET)
	public Page<ficheTraçabilite> searchFicheTraçabilite(@RequestParam(name="mFt", defaultValue = "") String mFt, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return ficheTraçabiliteRepository.searchFicheTraçabilite("%"+mFt+"%", PageRequest.of(page, size));
	}

}
