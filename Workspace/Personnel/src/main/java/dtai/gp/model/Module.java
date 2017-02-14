package dtai.gp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Module implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmodule;
	private String libellemodule;
	
	@OneToMany(mappedBy = "module")
	private Set<DetailModule> detailmodule = new HashSet<DetailModule>();

	
	
	public Module(int idmodule, String libellemodule,
			Set<DetailModule> detailmodule) {
		super();
		this.idmodule = idmodule;
		this.libellemodule = libellemodule;
		this.detailmodule = detailmodule;
	}
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdmodule() {
		return idmodule;
	}
	public void setIdmodule(int idmodule) {
		this.idmodule = idmodule;
	}
	public String getLibellemodule() {
		return libellemodule;
	}
	public void setLibellemodule(String libellemodule) {
		this.libellemodule = libellemodule;
	}
	public Set<DetailModule> getDetailmodule() {
		return detailmodule;
	}
	public void setDetailmodule(Set<DetailModule> detailmodule) {
		this.detailmodule = detailmodule;
	}
	

}
