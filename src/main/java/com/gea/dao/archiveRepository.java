package com.gea.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gea.entities.archive;

public interface archiveRepository extends JpaRepository<archive, Long> {
	
	@Query("select arch from archive arch where arch.periodeVie like :x")
	public Page<archive> searchArchive(@Param("x")String mArch, Pageable pageable);

}
