package com.gea.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gea.dao.archiveRepository;
import com.gea.entities.archive;

public class archiveRestService {
	
	@Autowired
	private archiveRepository archiveRepository;
	
	@RequestMapping(value = "/getAllArchive", method=RequestMethod.GET)
	public List<archive> getAllArchive() {
		return archiveRepository.findAll();
	}
	
	@RequestMapping(value = "/saveAgence", method=RequestMethod.POST)
	public archive saveArchive(@RequestBody archive arch){
		return archiveRepository.save(arch);
	}
	
	@RequestMapping(value = "/deleteArchive/{id}", method=RequestMethod.DELETE)
	public boolean deleteArchive(@PathVariable Long id){
		archiveRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateArchive/{id}", method=RequestMethod.PUT)
	public archive updateArchive(@PathVariable Long id, @RequestBody archive arch){
		return archiveRepository.save(arch);
	}
	
	@RequestMapping(value = "/searchArchive", method=RequestMethod.GET)
	public Page<archive> searchArchive(@RequestParam(name="mArch", defaultValue = "") String periodeVie, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return archiveRepository.searchArchive("%"+periodeVie+"%", PageRequest.of(page, size));
	}

}
