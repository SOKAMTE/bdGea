package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.ficheTraçabilite;

public interface ficheTraçabiliteRepository extends JpaRepository<ficheTraçabilite, Long> {
	
	@Query("select ft from ficheTraçabilite ft where ft.agence like :x")
	public Page<ficheTraçabilite> searchFicheTraçabilite(@Param("x")String mFt, Pageable pageable);


}
