package com.gea.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "archive")
@Data
public class archive implements Serializable {
	
	@Id @GeneratedValue
	private Long idArchive;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "periodeVie", nullable = false, insertable = false, updatable = false) 
	private Date periodeVie;
	
	@ManyToOne
	private employe fkEmpl;
	
	@ManyToOne
	private ficheDeclaration fkFd;
	
	@ManyToOne
	private bordereauTransfert fkBt;
	
	@ManyToOne
	private ficheTraçabilite fkFt;

	public Long getIdArchive() {
		return idArchive;
	}

	public void setIdArchive(Long idArchive) {
		this.idArchive = idArchive;
	}

	public Date getPeriodeVie() {
		return periodeVie;
	}

	public void setPeriodeVie(Date periodeVie) {
		this.periodeVie = periodeVie;
	}

	@Override
	public String toString() {
		return "archive [idArchive=" + idArchive + ", periodeVie=" + periodeVie + "]";
	}

	public archive(Long idArchive, Date periodeVie) {
		super();
		this.idArchive = idArchive;
		this.periodeVie = periodeVie;
	}

	public archive() {
		super();
		// TODO Auto-generated constructor stub
	}

}
