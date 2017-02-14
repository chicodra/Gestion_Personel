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
{@NamedQuery(name="CATEGORIE.FINDALL", query="select cat from Categorie cat"),
@NamedQuery(name = "CATEGORIE.FINDBYLIBCAT", query = "select ctg from Categorie ctg where ctg.libellecategorie=:cat"),
@NamedQuery(name = "CATEGORIE.FINDBYCODE", query = "select c from Categorie c where c.idcategorie=:cod")
})
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategorie;
	private String libellecategorie;

	@OneToMany(mappedBy = "categorie")
	private Set<DetailCategorie> detailcategorie = new HashSet<DetailCategorie>();

	public Categorie(int idcategorie, String libellecategorie,
			Set<DetailCategorie> detailcategorie) {
		super();
		this.idcategorie = idcategorie;
		this.libellecategorie = libellecategorie;
		this.detailcategorie = detailcategorie;
	}

	public Categorie() {
		super();
	}

	public int getIdcategorie() {
		return idcategorie;
	}

	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getLibellecategorie() {
		return libellecategorie;
	}

	public void setLibellecategorie(String libellecategorie) {
		this.libellecategorie = libellecategorie;
	}

	public Set<DetailCategorie> getDetailcategorie() {
		return detailcategorie;
	}

	public void setDetailcategorie(Set<DetailCategorie> detailcategorie) {
		this.detailcategorie = detailcategorie;
	}

}
