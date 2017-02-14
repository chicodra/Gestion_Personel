package dtai.gp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Affectation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idaffectation;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutAffectation;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinAffectation;

	@ManyToOne
	@JoinColumn(name = "iddepartement")
	private Departement departement;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public Affectation(int idaffectation, Date dateDebutAffectation,
			Date dateFinAffectation, Departement departement, Agent agent) {
		super();
		this.idaffectation = idaffectation;
		this.dateDebutAffectation = dateDebutAffectation;
		this.dateFinAffectation = dateFinAffectation;
		this.departement = departement;
		this.agent = agent;
	}

	public Affectation() {
		super();
	}

	public int getIdaffectation() {
		return idaffectation;
	}

	public void setIdaffectation(int idaffectation) {
		this.idaffectation = idaffectation;
	}

	public java.util.Date getDateDebutAffectation() {
		return dateDebutAffectation;
	}

	public void setDateDebutAffectation(java.util.Date dateDebutAffectation) {
		this.dateDebutAffectation = dateDebutAffectation;
	}

	public java.util.Date getDateFinAffectation() {
		return dateFinAffectation;
	}

	public void setDateFinAffectation(java.util.Date dateFinAffectation) {
		this.dateFinAffectation = dateFinAffectation;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
