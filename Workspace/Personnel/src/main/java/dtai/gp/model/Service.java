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
{@NamedQuery(name="SERVICE.FINDALL", query="select serv from Service serv"),
@NamedQuery(name = "SERVICE.FINDBYCODE", query = "select s from Service s where s.idservice=:cod")
})
public class Service implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idservice;
	private String libelleservice;

	public Service(int idservice, String libelleservice) {
		super();
		this.idservice = idservice;
		this.libelleservice = libelleservice;
	}

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdservice() {
		return idservice;
	}

	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}

	public String getLibelleservice() {
		return libelleservice;
	}

	public void setLibelleservice(String libelleservice) {
		this.libelleservice = libelleservice;
	}

}
