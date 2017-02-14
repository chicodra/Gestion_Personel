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
@NamedQueries({
		@NamedQuery(name = "DETAILABSENCE.FINDALL", query = "select dabs from DetailAbsence dabs"),
		@NamedQuery(name = "DETAILABSENCE.FINDBYCODE", query = "select dab from DetailAbsence dab where dab.idDetailAbsence=:cod")
		})
public class DetailAbsence implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetailAbsence;
	private int nombreJour;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutAbsence;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinAbsence;
	@ManyToOne
	@JoinColumn(name = "idAbsence")
	private Absence absence;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public DetailAbsence(int idDetailAbsence, int nombreJour,
			Date dateDebutAbsence, Date dateFinAbsence, Absence absence,
			Agent agent) {
		super();
		this.idDetailAbsence = idDetailAbsence;
		this.nombreJour = nombreJour;
		this.dateDebutAbsence = dateDebutAbsence;
		this.dateFinAbsence = dateFinAbsence;
		this.absence = absence;
		this.agent = agent;
	}

	public DetailAbsence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDetailAbsence() {
		return idDetailAbsence;
	}

	public void setIdDetailAbsence(int idDetailAbsence) {
		this.idDetailAbsence = idDetailAbsence;
	}

	public int getNombreJour() {
		return nombreJour;
	}

	public void setNombreJour(int nombreJour) {
		this.nombreJour = nombreJour;
	}

	public java.util.Date getDateDebutAbsence() {
		return dateDebutAbsence;
	}

	public void setDateDebutAbsence(java.util.Date dateDebutAbsence) {
		this.dateDebutAbsence = dateDebutAbsence;
	}

	public java.util.Date getDateFinAbsence() {
		return dateFinAbsence;
	}

	public void setDateFinAbsence(java.util.Date dateFinAbsence) {
		this.dateFinAbsence = dateFinAbsence;
	}

	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	

	

}
