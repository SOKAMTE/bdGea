package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.agence;

public interface agenceRepository extends JpaRepository<agence, Long> {
	
	@Query("select agc from agence agc where agc.codeAgence like :x")
	public Page<agence> searchAgence(@Param("x")String nAgt, Pageable pageable);

}
