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
{@NamedQuery(name="DETAILCLASSE.FINDALL", query="select dcl from DetailClasse dcl"),
@NamedQuery(name="DETAILCLASSE.FINDBYCODE" , query="select dc from DetailClasse dc where dc.iddetailclasse=:cod")
})
public class DetailClasse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetailclasse;
	private String echelon;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDebutClasse;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateFinClasse;

	@ManyToOne
	@JoinColumn(name = "idclasse")
	private Classe classe;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public DetailClasse(int iddetailclasse, String echelon,
			Date dateDebutClasse, Date dateFinClasse, Classe classe, Agent agent) {
		super();
		this.iddetailclasse = iddetailclasse;
		this.echelon = echelon;
		this.dateDebutClasse = dateDebutClasse;
		this.dateFinClasse = dateFinClasse;
		this.classe = classe;
		this.agent = agent;
	}

	public DetailClasse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddetailclasse() {
		return iddetailclasse;
	}

	public void setIddetailclasse(int iddetailclasse) {
		this.iddetailclasse = iddetailclasse;
	}

	public String getEchelon() {
		return echelon;
	}

	public void setEchelon(String echelon) {
		this.echelon = echelon;
	}

	public java.util.Date getDateDebutClasse() {
		return dateDebutClasse;
	}

	public void setDateDebutClasse(java.util.Date dateDebutClasse) {
		this.dateDebutClasse = dateDebutClasse;
	}

	public java.util.Date getDateFinClasse() {
		return dateFinClasse;
	}

	public void setDateFinClasse(java.util.Date dateFinClasse) {
		this.dateFinClasse = dateFinClasse;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
