package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
{@NamedQuery(name="CORPS.FINDALL", query="select cps from Corps cps"),
@NamedQuery(name = "Corps.FINDBYCODE", query = "select c from Corps c where c.idCorps=:cod")
})
public class Corps implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCorps;
	private String libelleCorps;
	private int ageRetraite;

	public Corps(int idcorps, String libellecorps, int ageRetraite) {
		super();
		this.idCorps = idcorps;
		this.libelleCorps = libellecorps;
		this.ageRetraite = ageRetraite;
	}

	public Corps() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCorps() {
		return idCorps;
	}

	public void setIdCorps(int idCorps) {
		this.idCorps = idCorps;
	}

	public String getLibelleCorps() {
		return libelleCorps;
	}

	public void setLibelleCorps(String libelleCorps) {
		this.libelleCorps = libelleCorps;
	}

	public int getAgeRetraite() {
		return ageRetraite;
	}

	public void setAgeRetraite(int ageRetraite) {
		this.ageRetraite = ageRetraite;
	}

	

}
