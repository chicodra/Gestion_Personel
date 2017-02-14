package dtai.gp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries(
{@NamedQuery(name="DEMANDE.FINDALL", query="select dmd from Demande dmd"),
@NamedQuery(name="DEMANDEVACATION.FINDALL", query="select lieuVacation, libelleObjetVacation, periodeVacation, dateDemande, dateVacation, vacation  from Demande  "),
@NamedQuery(name="DEMANDEABSENCE.FINDALL", query="select nombreJour, dateDemande, dateDebutAbsence, dateFinAbsence  from Demande "),
@NamedQuery(name = "DEMANDE.FINDBYCODE", query = "select d from Demande d where d.idDemande=:code")
})
public class Demande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDemande;
	private int nombreJour;
	private String lieuVacation;
	private String libelleObjetVacation;
	private String periodeVacation;
	private String lieuFormation;
	private String nombreHeureVacation;
	/*
	 * @OneToOne private Affectation affectation;
	 */
	@OneToOne
	private Vacation vacation;
	@OneToOne
	private Absence absence;
	@OneToOne
	private Formation formation;
	@ManyToOne
	private Agent agent;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDemande;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateVacation;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutAbsence;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinAbsence;


	public Demande(int idDemande, int nombreJour, String lieuVacation,
			String libelleObjetVacation, String periodeVacation,
			String lieuFormation, String nombreHeureVacation,
			Vacation vacation, Absence absence, Formation formation,
			Agent agent, Date dateDemande, Date dateVacation,
			Date dateDebutAbsence, Date dateFinAbsence) {
		super();
		this.idDemande = idDemande;
		this.nombreJour = nombreJour;
		this.lieuVacation = lieuVacation;
		this.libelleObjetVacation = libelleObjetVacation;
		this.periodeVacation = periodeVacation;
		this.lieuFormation = lieuFormation;
		this.nombreHeureVacation = nombreHeureVacation;
		this.vacation = vacation;
		this.absence = absence;
		this.formation = formation;
		this.agent = agent;
		this.dateDemande = dateDemande;
		this.dateVacation = dateVacation;
		this.dateDebutAbsence = dateDebutAbsence;
		this.dateFinAbsence = dateFinAbsence;
	}

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public int getNombreJour() {
		return nombreJour;
	}

	public void setNombreJour(int nombreJour) {
		this.nombreJour = nombreJour;
	}

	public String getLieuVacation() {
		return lieuVacation;
	}

	public void setLieuVacation(String lieuVacation) {
		this.lieuVacation = lieuVacation;
	}

	public String getLibelleObjetVacation() {
		return libelleObjetVacation;
	}

	public void setLibelleObjetVacation(String libelleObjetVacation) {
		this.libelleObjetVacation = libelleObjetVacation;
	}

	public String getPeriodeVacation() {
		return periodeVacation;
	}

	public void setPeriodeVacation(String periodeVacation) {
		this.periodeVacation = periodeVacation;
	}

	public Vacation getVacation() {
		return vacation;
	}

	public void setVacation(Vacation vacation) {
		this.vacation = vacation;
	}

	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public java.util.Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(java.util.Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public java.util.Date getDateVacation() {
		return dateVacation;
	}

	public void setDateVacation(java.util.Date dateVacation) {
		this.dateVacation = dateVacation;
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

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public String getNombreHeureVacation() {
		return nombreHeureVacation;
	}

	public void setNombreHeureVacation(String nombreHeureVacation) {
		this.nombreHeureVacation = nombreHeureVacation;
	}

}
