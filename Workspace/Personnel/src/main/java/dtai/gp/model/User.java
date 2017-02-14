package dtai.gp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries(
{@NamedQuery(name="USER.FINDALL", query="select usr from User usr"),
@NamedQuery(name = "USER.FINDBYINDICE", query = "select us from User us  where us.login=:login and us.typeActe=:indice"),
@NamedQuery(name = "USER.FINDBYTOKEN", query = "select u from User u where u.login=:login and u.password=:passwd"),
@NamedQuery(name = "USER.FINDBYNOM", query = "select ur from User ur where ur.nom=:nom and ur.prenom=:prenom"),
@NamedQuery(name="USER.FINDBYPASSWORD", query= "select user.password from User user where user.password=:pws")
})
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	//@NotNull( message = "Veuillez saisir un nom" )
	private String nom;
	//@NotNull( message = "Veuillez saisir un prenom" )
	private String prenom;
	@Column(unique = true, nullable = false)
	@Size( min = 3, message = "Le login doit contenir au moins 3 caractères" )
	private String login;
	@Size( min = 6, message = "Le mot de passe doit contenir au moins 6 caractères" )
	//@Pattern(regexp = ".*(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*", message = "Le mot de passe saisi n'est pas assez sécurisé")
	private String password;
	private int typeActe;

	public User(int idUser, String nom, String prenom, String login,
			String password, int typeActe) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.typeActe = typeActe;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTypeActe() {
		return typeActe;
	}

	public void setTypeActe(int typeActe) {
		this.typeActe = typeActe;
	}

}
