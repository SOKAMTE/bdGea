package com.gea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gea.dao.agenceRepository;
import com.gea.entities.agence;

//En cas de problème voir dans le pom.xml

@SpringBootApplication
public class GeaApplication implements CommandLineRunner {
	
	@Autowired
	agenceRepository agenceRepository;

	public static void main(String[] args) {
		SpringApplication.run(GeaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*agenceRepository.save(new agence((long) 1, "dsfd", "16F393", "cooper", 3));
		agenceRepository.save(new agence((long) 2, "youssouf", "14F56", "harold", 7));
		agenceRepository.save(new agence((long) 3, "sokamte", "56F75", "red", 5));
		agenceRepository.save(new agence((long) 4, "ngounou", "96F442", "raymond", 10));
		agenceRepository.findAll().forEach(agences->{
			System.out.println("................");
		});*/
		System.out.println("................");
	}

}
