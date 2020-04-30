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
@Table(name = "bordereauTransfert")
@Data
public class bordereauTransfert implements Serializable {
	
	@Id @GeneratedValue
	private Long idBordereauTransfert;
	
	@Temporal(TemporalType.DATE) @Column(name = "date", nullable = false) 
	private Date date;
	
	@Column(nullable = false)
	private String agenceProvenanceService;
	
	@Column(nullable = false)
	private Integer nombreBoite;
	
	@Temporal(TemporalType.DATE) @Column(name = "periode", nullable = false) 
	private Date periode;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(nullable = false)
	private String nomrespCcialControleInterne;
	
	@Column(nullable = false)
	private String nomRespAgenceService;
	
	@Column(nullable = false)
	private String nomMagasinier;
	
	@OneToMany(mappedBy = "fkBt")
	private Set<archive> archive;

	public Long getIdBordereauTransfert() {
		return idBordereauTransfert;
	}

	public void setIdBordereauTransfert(Long idBordereauTransfert) {
		this.idBordereauTransfert = idBordereauTransfert;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAgenceProvenanceService() {
		return agenceProvenanceService;
	}

	public void setAgenceProvenanceService(String agenceProvenanceService) {
		this.agenceProvenanceService = agenceProvenanceService;
	}

	public Integer getNombreBoite() {
		return nombreBoite;
	}

	public void setNombreBoite(Integer nombreBoite) {
		this.nombreBoite = nombreBoite;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getNomrespCcialControleInterne() {
		return nomrespCcialControleInterne;
	}

	public void setNomrespCcialControleInterne(String nomrespCcialControleInterne) {
		this.nomrespCcialControleInterne = nomrespCcialControleInterne;
	}

	public String getNomRespAgenceService() {
		return nomRespAgenceService;
	}

	public void setNomRespAgenceService(String nomRespAgenceService) {
		this.nomRespAgenceService = nomRespAgenceService;
	}

	public String getNomMagasinier() {
		return nomMagasinier;
	}

	public void setNomMagasinier(String nomMagasinier) {
		this.nomMagasinier = nomMagasinier;
	}

	@Override
	public String toString() {
		return "bordereauTransfert [idBordereauTransfert=" + idBordereauTransfert + ", date=" + date
				+ ", agenceProvenanceService=" + agenceProvenanceService + ", nombreBoite=" + nombreBoite + ", periode="
				+ periode + ", destination=" + destination + ", nomrespCcialControleInterne="
				+ nomrespCcialControleInterne + ", nomRespAgenceService=" + nomRespAgenceService + ", nomMagasinier="
				+ nomMagasinier + "]";
	}

	public bordereauTransfert(Long idBordereauTransfert, Date date, String agenceProvenanceService, Integer nombreBoite,
			Date periode, String destination, String nomrespCcialControleInterne, String nomRespAgenceService,
			String nomMagasinier) {
		super();
		this.idBordereauTransfert = idBordereauTransfert;
		this.date = date;
		this.agenceProvenanceService = agenceProvenanceService;
		this.nombreBoite = nombreBoite;
		this.periode = periode;
		this.destination = destination;
		this.nomrespCcialControleInterne = nomrespCcialControleInterne;
		this.nomRespAgenceService = nomRespAgenceService;
		this.nomMagasinier = nomMagasinier;
	}

	public bordereauTransfert() {
		super();
		// TODO Auto-generated constructor stub
	}

}
