package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
{@NamedQuery(name="DETAILDIPLOME.FINDALL", query="select ddiplo from DetailDiplome ddiplo"),
@NamedQuery(name="DETAILDIPLOME.FINDBYCODE" , query="select ddip from DetailDiplome ddip where ddip.iddetaildiplome=:cod")
})
public class DetailDiplome implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetaildiplome;
	private String anneeacademique;
	private String etablissement;

	@ManyToOne
	@JoinColumn(name = "iddiplome")
	private Diplome diplome;

	@ManyToOne
	@JoinColumn(name = "matricule")
	private Agent agent;

	public DetailDiplome(int iddetaildiplome, String anneeacademique,
			String etablissement, Diplome diplome, Agent agent) {
		super();
		this.iddetaildiplome = iddetaildiplome;
		this.anneeacademique = anneeacademique;
		this.etablissement = etablissement;
		this.diplome = diplome;
		this.agent = agent;
	}

	public DetailDiplome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddetaildiplome() {
		return iddetaildiplome;
	}

	public void setIddetaildiplome(int iddetaildiplome) {
		this.iddetaildiplome = iddetaildiplome;
	}

	public String getAnneeacademique() {
		return anneeacademique;
	}

	public void setAnneeacademique(String anneeacademique) {
		this.anneeacademique = anneeacademique;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public Diplome getDiplome() {
		return diplome;
	}

	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
