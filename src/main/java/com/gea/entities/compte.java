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
@Table(name = "compte")
@Data
public class compte implements Serializable {
	
	@Id @GeneratedValue
	private Long idCompte;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String niveau;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "dateCreation", nullable = false, insertable = false, updatable = false) 
	private Date dateCreation;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "dateDerniereConnexion", nullable = false, insertable = false, updatable = false) 
	private Date dateDerniereConnexion;
	
	@ManyToOne
	private employe fkEmpl;

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	public void setDateDerniereConnexion(Date dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	@Override
	public String toString() {
		return "compte [idCompte=" + idCompte + ", login=" + login + ", password=" + password + ", niveau=" + niveau
				+ ", dateCreation=" + dateCreation + ", dateDerniereConnexion=" + dateDerniereConnexion + "]";
	}

	public compte(Long idCompte, String login, String password, String niveau, Date dateCreation,
			Date dateDerniereConnexion) {
		super();
		this.idCompte = idCompte;
		this.login = login;
		this.password = password;
		this.niveau = niveau;
		this.dateCreation = dateCreation;
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	public compte() {
		super();
		// TODO Auto-generated constructor stub
	}

}
