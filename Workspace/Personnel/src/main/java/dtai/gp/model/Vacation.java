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
{@NamedQuery(name="VACATION.FINDALL", query="select vct from Vacation vct"),
@NamedQuery(name = "VACATION.FINDBYCODE", query = "select v from Vacation v where v.idVacation=:code")
})
public class Vacation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVacation;
	private String libelleVacation;
	
	/*@ManyToOne
	private TypeArretTravail typearrettravail;*/

	public Vacation(int idVacation, String libelleVacation) {
		super();
		this.idVacation = idVacation;
		this.libelleVacation = libelleVacation;
	}
	
	public Vacation() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getIdVacation() {
		return idVacation;
	}

	public void setIdVacation(int idVacation) {
		this.idVacation = idVacation;
	}

	public String getLibelleVacation() {
		return libelleVacation;
	}

	public void setLibelleVacation(String libelleVacation) {
		this.libelleVacation = libelleVacation;
	}

	

	
}
