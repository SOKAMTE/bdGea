package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.compte;

public interface compteRepository extends JpaRepository<compte, Long> {
	
	@Query("select cpt from compte cpt where cpt.login like :x")
	public Page<compte> searchCompte(@Param("x")String mCpt, Pageable pageable);

}
