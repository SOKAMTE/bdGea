package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.departement;

public interface departementRepository extends JpaRepository<departement, Long> {
	
	@Query("select dpt from departement dpt where dpt.nomDepartement like :x")
	public Page<departement> searchDepartement(@Param("x")String mDpt, Pageable pageable);

}
