package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeArretTravail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtypearret;
	private String libelletypearret;

	public TypeArretTravail(int idtypearret, String libelletypearret) {
		super();
		this.idtypearret = idtypearret;
		this.libelletypearret = libelletypearret;
	}

	public TypeArretTravail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdtypearret() {
		return idtypearret;
	}

	public void setIdtypearret(int idtypearret) {
		this.idtypearret = idtypearret;
	}

	public String getLibelletypearret() {
		return libelletypearret;
	}

	public void setLibelletypearret(String libelletypearret) {
		this.libelletypearret = libelletypearret;
	}

}
