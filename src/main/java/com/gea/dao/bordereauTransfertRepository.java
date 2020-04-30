package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.bordereauTransfert;

public interface bordereauTransfertRepository extends JpaRepository<bordereauTransfert, Long> {
	
	@Query("select bt from bordereauTransfert bt where bt.agenceProvenanceService like :x")
	public Page<bordereauTransfert> searchBordereauTransfert(@Param("x")String mBt, Pageable pageable);

}
