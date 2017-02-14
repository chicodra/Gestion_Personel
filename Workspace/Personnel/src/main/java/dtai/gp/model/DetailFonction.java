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
{@NamedQuery(name="DETAILFONCTION.FINDALL", query="select dfct from DetailFonction dfct"),
@NamedQuery(name="DETAILFONCTION.FINDBYCODE" , query="select df from DetailFonction df where df.iddetailfonction=:cod")
})
public class DetailFonction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetailfonction;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutFonction;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinFonction;

	@ManyToOne
	@JoinColumn(name = "fonction")
	private Fonction fonction;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public DetailFonction(int iddetailfonction, Date dateDebutFonction,
			Date dateFinFonction, Fonction fonction, Agent agent) {
		super();
		this.iddetailfonction = iddetailfonction;
		this.dateDebutFonction = dateDebutFonction;
		this.dateFinFonction = dateFinFonction;
		this.fonction = fonction;
		this.agent = agent;
	}

	public DetailFonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddetailfonction() {
		return iddetailfonction;
	}

	public void setIddetailfonction(int iddetailfonction) {
		this.iddetailfonction = iddetailfonction;
	}

	public java.util.Date getDateDebutFonction() {
		return dateDebutFonction;
	}

	public void setDateDebutFonction(java.util.Date dateDebutFonction) {
		this.dateDebutFonction = dateDebutFonction;
	}

	public java.util.Date getDateFinFonction() {
		return dateFinFonction;
	}

	public void setDateFinFonction(java.util.Date dateFinFonction) {
		this.dateFinFonction = dateFinFonction;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
