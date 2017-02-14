package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeFormation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtypeformation;
	private String libelletypeformation;

	public TypeFormation(int idtypeformation, String libelletypeformation) {
		super();
		this.idtypeformation = idtypeformation;
		this.libelletypeformation = libelletypeformation;
	}

	public TypeFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdtypeformation() {
		return idtypeformation;
	}

	public void setIdtypeformation(int idtypeformation) {
		this.idtypeformation = idtypeformation;
	}

	public String getLibelletypeformation() {
		return libelletypeformation;
	}

	public void setLibelletypeformation(String libelletypeformation) {
		this.libelletypeformation = libelletypeformation;
	}

}
