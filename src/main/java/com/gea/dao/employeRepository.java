package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.employe;

public interface employeRepository extends JpaRepository<employe, Long> {
	
	@Query("select empl from employe empl where empl.matricule like :x")
	public Page<employe> searchEmploye(@Param("x")String mEmpl, Pageable pageable);

}
