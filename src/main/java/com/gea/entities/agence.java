package com.gea.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "agence")
@Data
public class agence implements Serializable {

	@Id @GeneratedValue
	private Long idAgence;
	
	@Column(nullable = false)
	private String nomAgence;
	
	@Column(nullable = false, unique = true)
	private String codeAgence;
	
	@Column(nullable = false)
	private String chefAgence;
	
	@Column(nullable = false)
	private Integer nombreEmploye;
	
	@OneToMany(mappedBy = "fka")
	private Set<employe> employe;

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getChefAgence() {
		return chefAgence;
	}

	public void setChefAgence(String chefAgence) {
		this.chefAgence = chefAgence;
	}

	public Integer getNombreEmploye() {
		return nombreEmploye;
	}

	public void setNombreEmploye(Integer nombreEmploye) {
		this.nombreEmploye = nombreEmploye;
	}

	@Override
	public String toString() {
		return "agence [idAgence=" + idAgence + ", nomAgence=" + nomAgence + ", codeAgence=" + codeAgence
				+ ", chefAgence=" + chefAgence + ", nombreEmploye=" + nombreEmploye + "]";
	}

	public agence(Long idAgence, String nomAgence, String codeAgence, String chefAgence, Integer nombreEmploye) {
		super();
		this.idAgence = idAgence;
		this.nomAgence = nomAgence;
		this.codeAgence = codeAgence;
		this.chefAgence = chefAgence;
		this.nombreEmploye = nombreEmploye;
	}

	public agence() {
		super();
		// TODO Auto-generated constructor stub
	}

}
