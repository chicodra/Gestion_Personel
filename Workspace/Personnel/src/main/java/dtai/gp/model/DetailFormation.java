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
{@NamedQuery(name="DETAILFORMATION.FINDALL", query="select dfmt from DetailFormation dfmt"),
@NamedQuery(name="DETAILFORMATION.FINDBYCODE" , query="select df from DetailFormation df where df.iddetailformation=:cod")
})
public class DetailFormation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetailformation;
	private String lieuformation;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutFormation;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinFormation;
	@ManyToOne
	@JoinColumn(name = "idformation")
	private Formation formation;
	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	

	public DetailFormation(int iddetailformation, String lieuformation,
			Date dateDebutFormation, Date dateFinFormation,
			Formation formation, Agent agent) {
		super();
		this.iddetailformation = iddetailformation;
		this.lieuformation = lieuformation;
		this.dateDebutFormation = dateDebutFormation;
		this.dateFinFormation = dateFinFormation;
		this.formation = formation;
		this.agent = agent;
	}

	public DetailFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddetailformation() {
		return iddetailformation;
	}

	public void setIddetailformation(int iddetailformation) {
		this.iddetailformation = iddetailformation;
	}

	public java.util.Date getDateDebutFormation() {
		return dateDebutFormation;
	}

	public void setDateDebutFormation(java.util.Date dateDebutFormation) {
		this.dateDebutFormation = dateDebutFormation;
	}

	public java.util.Date getDateFinFormation() {
		return dateFinFormation;
	}

	public void setDateFinFormation(java.util.Date dateFinFormation) {
		this.dateFinFormation = dateFinFormation;
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

	public String getLieuformation() {
		return lieuformation;
	}

	public void setLieuformation(String lieuformation) {
		this.lieuformation = lieuformation;
	}

}
