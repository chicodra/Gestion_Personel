package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeAbsence implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtypeabsence;
	private String libelletypeabsence;
	public TypeAbsence(int idtypeabsence, String libelletypeabsence) {
		super();
		this.idtypeabsence = idtypeabsence;
		this.libelletypeabsence = libelletypeabsence;
	}
	public TypeAbsence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdtypeabsence() {
		return idtypeabsence;
	}
	public void setIdtypeabsence(int idtypeabsence) {
		this.idtypeabsence = idtypeabsence;
	}
	public String getLibelletypeabsence() {
		return libelletypeabsence;
	}
	public void setLibelletypeabsence(String libelletypeabsence) {
		this.libelletypeabsence = libelletypeabsence;
	}
	

}
