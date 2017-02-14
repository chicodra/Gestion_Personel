package dtai.gp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
{@NamedQuery(name="FONCTION.FINDALL", query="select fct from Fonction fct"),
@NamedQuery(name = "Fonction.FINDBYCODE", query = "select f from Fonction f where f.idFonction=:cod")
})
public class Fonction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idFonction;
	private String libelleFonction;

	@OneToMany(mappedBy = "fonction")
	private Set<DetailFonction> detailfonction = new HashSet<DetailFonction>();

	public Fonction(int idFonction, String libelleFonction,
			Set<DetailFonction> detailfonction) {
		super();
		this.idFonction = idFonction;
		this.libelleFonction = libelleFonction;
		this.detailfonction = detailfonction;
	}

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(int idFonction) {
		this.idFonction = idFonction;
	}

	public String getLibelleFonction() {
		return libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	public Set<DetailFonction> getDetailfonction() {
		return detailfonction;
	}

	public void setDetailfonction(Set<DetailFonction> detailfonction) {
		this.detailfonction = detailfonction;
	}

}
