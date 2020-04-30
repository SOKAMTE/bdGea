package com.gea.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "ficheDeclaration")
@Data
public class ficheDeclaration implements Serializable{
	
	@Id @GeneratedValue
	private Long idFicheDeclaration;
	
	@Temporal(TemporalType.DATE) @Column(name = "date", nullable = false) 
	private Date date;
	
	@Column(nullable = false)
	private String agence;
	
	@Column(nullable = false)
	private String designation;
	
	@Temporal(TemporalType.DATE) @Column(name = "periode", nullable = false) 
	private Date periode;
	
	@Column(nullable = false)
	private Integer quantite;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private String observation;
	
	@OneToMany(mappedBy = "fkFd")
	private Set<archive> archive;

	public Long getIdFicheDeclaration() {
		return idFicheDeclaration;
	}

	public void setIdFicheDeclaration(Long idFicheDeclaration) {
		this.idFicheDeclaration = idFicheDeclaration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public String toString() {
		return "ficheDeclaration [idFicheDeclaration=" + idFicheDeclaration + ", date=" + date + ", agence=" + agence
				+ ", designation=" + designation + ", periode=" + periode + ", quantite=" + quantite + ", destination="
				+ destination + ", observation=" + observation + "]";
	}

	public ficheDeclaration(Long idFicheDeclaration, Date date, String agence, String designation, Date periode,
			Integer quantite, String destination, String observation) {
		super();
		this.idFicheDeclaration = idFicheDeclaration;
		this.date = date;
		this.agence = agence;
		this.designation = designation;
		this.periode = periode;
		this.quantite = quantite;
		this.destination = destination;
		this.observation = observation;
	}

	public ficheDeclaration() {
		super();
		// TODO Auto-generated constructor stub
	}

}
