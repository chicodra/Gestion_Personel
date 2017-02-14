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
{@NamedQuery(name="DIPLOME.FINDALL", query="select dip from Diplome dip"),
@NamedQuery(name = "DIPLOME.FINDBYLIBCAT", query = "select dpm from Diplome dpm where dpm.libellediplome=:dip"),
@NamedQuery(name = "DIPLOME.FINDBYCODE", query = "select d from Diplome d where d.iddiplome=:cod")
})
public class Diplome implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddiplome;
	private String libellediplome;
	@OneToMany(mappedBy = "diplome")
	private Set<DetailDiplome> detaildiplome = new HashSet<DetailDiplome>();
	
	public Diplome(int iddiplome, String libellediplome,
			Set<DetailDiplome> detaildiplome) {
		super();
		this.iddiplome = iddiplome;
		this.libellediplome = libellediplome;
		this.detaildiplome = detaildiplome;
	}
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIddiplome() {
		return iddiplome;
	}
	public void setIddiplome(int iddiplome) {
		this.iddiplome = iddiplome;
	}
	public String getLibellediplome() {
		return libellediplome;
	}
	public void setLibellediplome(String libellediplome) {
		this.libellediplome = libellediplome;
	}
	public Set<DetailDiplome> getDetaildiplome() {
		return detaildiplome;
	}
	public void setDetaildiplome(Set<DetailDiplome> detaildiplome) {
		this.detaildiplome = detaildiplome;
	}

}
