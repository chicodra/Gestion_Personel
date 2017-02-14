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
{@NamedQuery(name="CLASSE.FINDALL", query="select c from Classe c"),
@NamedQuery(name = "CLASSE.FINDBYCODE", query = "select cl from Classe cl where cl.idclasse=:cod")
})
public class Classe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclasse;
	private String libelleclasse;

	@OneToMany(mappedBy = "classe")
	private Set<DetailClasse> detailclasse = new HashSet<DetailClasse>();

	public Classe(int idclasse, String libelleclasse,
			Set<DetailClasse> detailclasse) {
		super();
		this.idclasse = idclasse;
		this.libelleclasse = libelleclasse;
		this.detailclasse = detailclasse;
	}

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}

	public String getLibelleclasse() {
		return libelleclasse;
	}

	public void setLibelleclasse(String libelleclasse) {
		this.libelleclasse = libelleclasse;
	}

	public Set<DetailClasse> getDetailclasse() {
		return detailclasse;
	}

	public void setDetailclasse(Set<DetailClasse> detailclasse) {
		this.detailclasse = detailclasse;
	}

}
