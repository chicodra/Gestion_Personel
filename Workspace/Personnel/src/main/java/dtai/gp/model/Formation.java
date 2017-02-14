package dtai.gp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
{@NamedQuery(name="FORMATION.FINDALL", query="select formt  from Formation formt"),
@NamedQuery(name="FORMATION.LIBELLEFORMATION", query="select for from Formation for where for.libelleformation=:form"),	
@NamedQuery(name = "FORMATION.FINDBYCODE", query = "select f from Formation f where f.idformation=:code")
})
public class Formation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idformation;
	private String libelleformation;
	
	@OneToMany(mappedBy = "formation")
	private Set<DetailFormation> detailformation = new HashSet<DetailFormation>();

	public Formation(int idformation, String libelleformation,
			Set<DetailFormation> detailformation) {
		super();
		this.idformation = idformation;
		this.libelleformation = libelleformation;
		this.detailformation = detailformation;
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdformation() {
		return idformation;
	}

	public void setIdformation(int idformation) {
		this.idformation = idformation;
	}

	public String getLibelleformation() {
		return libelleformation;
	}

	public void setLibelleformation(String libelleformation) {
		this.libelleformation = libelleformation;
	}


	public Set<DetailFormation> getDetailformation() {
		return detailformation;
	}

	public void setDetailformation(Set<DetailFormation> detailformation) {
		this.detailformation = detailformation;
	}

}
