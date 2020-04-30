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
@Table(name = "departement")
@Data
public class departement implements Serializable{
	
	@Id @GeneratedValue
	private Long idDepartement;
	
	@Column(nullable = false)
	private String nomDepartement;
	
	@Column(nullable = false)
	private String chefDepartement;
	
	@Column(nullable = false)
	private Integer nombreEmploye;
	
	@OneToMany(mappedBy = "fkd")
	private Set<employe> employe;

	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public String getChefDepartement() {
		return chefDepartement;
	}

	public void setChefDepartement(String chefDepartement) {
		this.chefDepartement = chefDepartement;
	}

	public Integer getNombreEmploye() {
		return nombreEmploye;
	}

	public void setNombreEmploye(Integer nombreEmploye) {
		this.nombreEmploye = nombreEmploye;
	}

	@Override
	public String toString() {
		return "departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement
				+ ", chefDepartement=" + chefDepartement + ", nombreEmploye=" + nombreEmploye + "]";
	}

	public departement(Long idDepartement, String nomDepartement, String chefDepartement, Integer nombreEmploye) {
		super();
		this.idDepartement = idDepartement;
		this.nomDepartement = nomDepartement;
		this.chefDepartement = chefDepartement;
		this.nombreEmploye = nombreEmploye;
	}

	public departement() {
		super();
		// TODO Auto-generated constructor stub
	}

}
