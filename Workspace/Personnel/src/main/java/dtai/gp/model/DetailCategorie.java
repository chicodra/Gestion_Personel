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
{@NamedQuery(name="DETAILCATEGORIE.FINDALL", query="select dctg from DetailCategorie dctg"),
@NamedQuery(name="DETAILCATEGORIE.FINDBYCODE" , query="select dc from DetailCategorie dc where dc.iddetailcategorie=:cod")
})
public class DetailCategorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetailcategorie;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutCategorie;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinCategorie;

	@ManyToOne
	@JoinColumn(name = "idcategorie")
	private Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public DetailCategorie(int iddetailcategorie, Date dateDebutCategorie,
			Date dateFinCategorie, Categorie categorie, Agent agent) {
		super();
		this.iddetailcategorie = iddetailcategorie;
		this.dateDebutCategorie = dateDebutCategorie;
		this.dateFinCategorie = dateFinCategorie;
		this.categorie = categorie;
		this.agent = agent;
	}

	public DetailCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddetailcategorie() {
		return iddetailcategorie;
	}

	public void setIddetailcategorie(int iddetailcategorie) {
		this.iddetailcategorie = iddetailcategorie;
	}

	public java.util.Date getDateDebutCategorie() {
		return dateDebutCategorie;
	}

	public void setDateDebutCategorie(java.util.Date dateDebutCategorie) {
		this.dateDebutCategorie = dateDebutCategorie;
	}

	public java.util.Date getDateFinCategorie() {
		return dateFinCategorie;
	}

	public void setDateFinCategorie(java.util.Date dateFinCategorie) {
		this.dateFinCategorie = dateFinCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
