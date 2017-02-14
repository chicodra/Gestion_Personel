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
{@NamedQuery(name="TYPESANCTION.FINDALL", query="select tsanction from TypeSanction tsanction"),
@NamedQuery(name = "TYPESANCTION.FINDBYCODE", query = "select typesanc from TypeSanction typesanc where typesanc.idtypesanction=:cod")
})
public class TypeSanction implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtypesanction;
	private String libelletype;
	private int nbrjour;
	
	@OneToMany(mappedBy = "typesanction")
	private Set<DetailSanction> detailsanction = new HashSet<DetailSanction>();

	public TypeSanction(int idtypesanction, String libelletype, int nbrjour,
			Set<DetailSanction> detailsanction) {
		super();
		this.idtypesanction = idtypesanction;
		this.libelletype = libelletype;
		this.nbrjour = nbrjour;
		this.detailsanction = detailsanction;
	}
	public TypeSanction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdtypesanction() {
		return idtypesanction;
	}
	public void setIdtypesanction(int idtypesanction) {
		this.idtypesanction = idtypesanction;
	}
	public String getLibelletype() {
		return libelletype;
	}
	public void setLibelletype(String libelletype) {
		this.libelletype = libelletype;
	}

	public Set<DetailSanction> getDetailsanction() {
		return detailsanction;
	}

	public void setDetailsanction(Set<DetailSanction> detailsanction) {
		this.detailsanction = detailsanction;
	}
	public int getNbrjour() {
		return nbrjour;
	}
	public void setNbrjour(int nbrjour) {
		this.nbrjour = nbrjour;
	}
	
	

}
