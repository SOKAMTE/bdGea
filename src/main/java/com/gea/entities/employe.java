package com.gea.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employe")
@Data
public class employe implements Serializable{
	
	@Id @GeneratedValue
	private Long idEmploye;
	
	@Column(nullable = false, unique = true)
	private String matricule;
	
	@Column(nullable = false)
	private String nomEmploye;
	
	@Column(nullable = false)
	private String prenomEmploye;
	
	@Column(nullable = false)
	private boolean user;

	
	@ManyToOne
	private agence fka;
	
	@ManyToOne
	private departement fkd;
	
	@OneToMany(mappedBy = "fkEmpl")
	private Set<compte> compte;
	
	@OneToMany(mappedBy = "fkEmpl")
	private Set<archive> archive;
	
	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public boolean isUser() {
		return user;
	}

	public void setUser(boolean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "employe [idEmploye=" + idEmploye + ", matricule=" + matricule + ", nomEmploye=" + nomEmploye
				+ ", prenomEmploye=" + prenomEmploye + ", user=" + user + "]";
	}

	public employe(Long idEmploye, String matricule, String nomEmploye, String prenomEmploye, boolean user) {
		super();
		this.idEmploye = idEmploye;
		this.matricule = matricule;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.user = user;
	}

	public employe() {
		super();
		// TODO Auto-generated constructor stub
	}

}
