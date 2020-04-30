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

import com.gea.dao.ficheDeclarationRepository;
import com.gea.entities.ficheDeclaration;

@RestController
@CrossOrigin("*")
public class ficheDeclarationRestService {
	
	@Autowired
	private ficheDeclarationRepository ficheDeclarationRepository;
	
	@RequestMapping(value = "/getAllFicheDeclaration", method=RequestMethod.GET)
	public List<ficheDeclaration> getAllFicheDeclaration() {
		return ficheDeclarationRepository.findAll();
	}
	
	@RequestMapping(value = "/saveFicheDeclaration", method=RequestMethod.POST)
	public ficheDeclaration saveAgence(@RequestBody ficheDeclaration fd){
		return ficheDeclarationRepository.save(fd);
	}
	
	@RequestMapping(value = "/deleteFicheDeclaration/{id}", method=RequestMethod.DELETE)
	public boolean deleteFicheDeclaration(@PathVariable Long id){
		ficheDeclarationRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateFicheDeclaration/{id}", method=RequestMethod.PUT)
	public ficheDeclaration updateFicheDeclaration(@PathVariable Long id, @RequestBody ficheDeclaration fd){
		return ficheDeclarationRepository.save(fd);
	}
	
	@RequestMapping(value = "/searchFicheDeclaration", method=RequestMethod.GET)
	public Page<ficheDeclaration> searchFicheDeclaration(@RequestParam(name="mFd", defaultValue = "") String mFd, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return ficheDeclarationRepository.searchFicheDeclaration("%"+mFd+"%", PageRequest.of(page, size));
	}

}
