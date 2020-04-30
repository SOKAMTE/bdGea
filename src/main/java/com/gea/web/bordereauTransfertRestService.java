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

import com.gea.dao.bordereauTransfertRepository;
import com.gea.entities.bordereauTransfert;

@RestController
@CrossOrigin("*")
public class bordereauTransfertRestService {
	
	@Autowired
	private bordereauTransfertRepository bordereauTransfertRepository;
	
	@RequestMapping(value = "/getAllBordereauTransfert", method=RequestMethod.GET)
	public List<bordereauTransfert> getAllBordereauTransfert() {
		return bordereauTransfertRepository.findAll();
	}
	
	@RequestMapping(value = "/saveBordereauTransfert", method=RequestMethod.POST)
	public bordereauTransfert saveBordereauTransfert(@RequestBody bordereauTransfert bt){
		return bordereauTransfertRepository.save(bt);
	}
	
	@RequestMapping(value = "/deletBordereauTransfert/{id}", method=RequestMethod.DELETE)
	public boolean deleteBordereauTransfert(@PathVariable Long id){
		bordereauTransfertRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/updateBordereauTransfert/{id}", method=RequestMethod.PUT)
	public bordereauTransfert updateBordereauTransfert(@PathVariable Long id, @RequestBody bordereauTransfert bt){
		return bordereauTransfertRepository.save(bt);
	}
	
	@RequestMapping(value = "/searchBordereauTransfert", method=RequestMethod.GET)
	public Page<bordereauTransfert> searchBordereauTransfert(@RequestParam(name="mBt", defaultValue = "") String mBt, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size){
		return bordereauTransfertRepository.searchBordereauTransfert("%"+mBt+"%", PageRequest.of(page, size));
	}

}
