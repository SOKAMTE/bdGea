package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.ficheDeclaration;

public interface ficheDeclarationRepository extends JpaRepository<ficheDeclaration, Long>{
	
	@Query("select fd from ficheDeclaration fd where fd.agence like :x")
	public Page<ficheDeclaration> searchFicheDeclaration(@Param("x")String mFd, Pageable pageable);

}
