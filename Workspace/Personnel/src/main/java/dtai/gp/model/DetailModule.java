package dtai.gp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(
{@NamedQuery(name="DETAILMODULE.FINDALL", query="select dmdl from DetailModule dmdl"),
@NamedQuery(name="DETAILMODULE.FINDBYCODE" , query="select dm from DetailModule dm where dm.idDetailModule=:cod")
})
public class DetailModule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetailModule;
	private String animateur;
	private String volumeHoraire;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutModule;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinModule;
	@ManyToOne
	@JoinColumn(name = "idformation")
	private Formation formation;
	@ManyToOne
	@JoinColumn(name = "idModule")
	private Module module;
	
	
	public DetailModule(int idDetailModule, String animateur,
			String volumeHoraire, Date dateDebutModule, Date dateFinModule,
			Formation formation, Module module) {
		super();
		this.idDetailModule = idDetailModule;
		this.animateur = animateur;
		this.volumeHoraire = volumeHoraire;
		this.dateDebutModule = dateDebutModule;
		this.dateFinModule = dateFinModule;
		this.formation = formation;
		this.module = module;
	}
	
	public DetailModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdDetailModule() {
		return idDetailModule;
	}
	public void setIdDetailModule(int idDetailModule) {
		this.idDetailModule = idDetailModule;
	}
	public String getAnimateur() {
		return animateur;
	}
	public void setAnimateur(String animateur) {
		this.animateur = animateur;
	}
	public String getVolumeHoraire() {
		return volumeHoraire;
	}
	public void setVolumeHoraire(String volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}
	public java.util.Date getDateDebutModule() {
		return dateDebutModule;
	}
	public void setDateDebutModule(java.util.Date dateDebutModule) {
		this.dateDebutModule = dateDebutModule;
	}
	public java.util.Date getDateFinModule() {
		return dateFinModule;
	}
	public void setDateFinModule(java.util.Date dateFinModule) {
		this.dateFinModule = dateFinModule;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
}
