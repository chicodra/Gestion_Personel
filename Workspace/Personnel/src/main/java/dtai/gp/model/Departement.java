package dtai.gp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddepartement;
	private String libelledepartement;

	@ManyToOne
	private Service service;

	@OneToMany(mappedBy = "departement")
	private Set<Affectation> affectation = new HashSet<Affectation>();

	public Departement(int iddepartement, String libelledepartement,
			Service service, Set<Affectation> affectation) {
		super();
		this.iddepartement = iddepartement;
		this.libelledepartement = libelledepartement;
		this.service = service;
		this.affectation = affectation;
	}

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIddepartement() {
		return iddepartement;
	}

	public void setIddepartement(int iddepartement) {
		this.iddepartement = iddepartement;
	}

	public String getLibelledepartement() {
		return libelledepartement;
	}

	public void setLibelledepartement(String libelledepartement) {
		this.libelledepartement = libelledepartement;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Set<Affectation> getAffectation() {
		return affectation;
	}

	public void setAffectation(Set<Affectation> affectation) {
		this.affectation = affectation;
	}

}
