package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import utilitaires.UtilitaireSession;
import dtai.gp.model.User;
import dtai.gp.service.UserService;

@FacesValidator(value = "userBean")
@javax.faces.bean.ManagedBean
@RequestScoped
public class UserBean implements Serializable, Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@EJB
	private UserService userService;
	
	HttpSession session = UtilitaireSession.getSession();
	String userLogin = (String) session.getAttribute("userLogin");
	String usernom = (String) session.getAttribute("usernom");
	String userprenom = (String) session.getAttribute("userprenom");
	private User user = new User();
	
	private User us = new User();

	private List<User> users = new ArrayList<User>();

	public String save() {
		
		user.setPassword(generedpw());
		user.setTypeActe(0);
		userService.SaveUser(user);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User  ajouté",
						null));

		 return "/faces/user.xhtml";

	}

	public String delete() {
		userService.deleteUser(user);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User  supprimé",
						null));
		return "/welcome.xhtml";
	}

	public String update() {
		userService.updateUser(user);
		return "/faces/user.xhtml";
	}

	public String updatePsw() {
		HttpSession session = UtilitaireSession.getSession();
		session.setAttribute("usernom", user.getNom());
		session.setAttribute("userprenom", user.getPrenom());
		session.setAttribute("userlogin", user.getLogin());
		session.setAttribute("userid", user.getIdUser());
		user.setPassword(encrypt(user.getPassword()));
		user.setTypeActe(1);
		user.setNom(usernom);
		user.setPrenom(userprenom);
		user.setLogin(userLogin);
		userService.updatePw(user);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Mot de passe modifié",
						null));
		return "/login.xhtml";
	}

	@PostConstruct
	public void init() {
		users = userService.FindAll();
	}

	public String login() {
		// int test=0;
		String val = "";
		Boolean res = false;
		Boolean res2 = false;
		res = userService.findByLogin(user.getLogin(), user.getPassword());
		res2 = userService.findByIndice(user.getTypeActe(), user.getLogin());
		if (res == true) {
			if (res2 == true) {
				val = "succesLogin";
				HttpSession session = UtilitaireSession.getSession();
				session.setAttribute("userLogin", user.getLogin());
				session.setAttribute("userPasse", user.getPassword());
				session.setAttribute("userTypeActe",
						String.valueOf(user.getTypeActe()));
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										FacesMessage.SEVERITY_INFO,
										"Bienvenu "
												+ session
														.getAttribute("userLogin"),
										null));
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Changer le mot de passe", null));
				return "/faces/password.xhtml";
			}
		} else {
			val = "faildLogin";
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Login ou mot de passe Incorect", null));
			/*
			 * test++; if(test==3){
			 * FacesContext.getCurrentInstance().addMessage(null, new
			 * FacesMessage(FacesMessage.SEVERITY_INFO,"test !!!", null));
			 * //System.exit(0);
			 * 
			 * }
			 */
		}
		return val;

	}

	public String generedpw() {
		Random r = new Random();
		String monpwd = "";
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "v", "w",
				"x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "V",
				"W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "0" };
		int c = 8;
		// opposer du nombre
		int c2 = c / 2;
		int nc2 = 0 - c2;// opposer de la moitie du nombre saisi
		for (int x = nc2; x < 0; x++) {
			int alphanum = r.nextInt(20);
			int numnum = r.nextInt(10);
			monpwd = monpwd + alphabet[alphanum] + "" + numnum;
		}

		return monpwd;
	}

	public String encrypt(String password) {
		String crypte = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			crypte = crypte + (char) c;
		}
		return crypte;
	}

	public String decrypt(String password) {
		String aCrypter = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			aCrypter = aCrypter + (char) c;
		}
		return aCrypter;
	}

	public void VerifierPws(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String pws = (String) arg2;
		System.out.println("Password:" + pws);
		User user = new User();
		user = userService.findByPassword(pws);
		if ( user==null ) {
			String msg = "Le mot de passe est incorrect";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
		
	}
    private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée";

	private static final String CHAMP_MOT_DE_PASSE = "composantMotDePasse";
	private static final String MOTS_DE_PASSE_DIFFERENTS = "Le nouveau mot de passe et la confirmation doivent être identiques.";

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		/*
		 * Récupération de l'attribut mot de passe parmi la liste des attributs
		 * du composant confirmation
		 */
		UIInput composantMotDePasse = (UIInput) component.getAttributes().get(
				CHAMP_MOT_DE_PASSE);
		/*
		 * Récupération de la valeur du champ, c'est-à-dire le mot de passe
		 * saisi
		 */
		String nouvmotdepasse = (String) composantMotDePasse.getValue();
		/* Récupération de la valeur du champ confirmation */
		String confirmation = (String) value;

		if (confirmation != null && !confirmation.equals(nouvmotdepasse)) {
			/*
			 * Envoi d'une exception contenant une erreur de validation JSF
			 * initialisée avec le message destiné à l'utilisateur, si les mots
			 * de passe sont différents
			 */
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							MOTS_DE_PASSE_DIFFERENTS, null));

		}
	}
	

	
	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static String getChampMotDePasse() {
		return CHAMP_MOT_DE_PASSE;
	}

	public static String getMotsDePasseDifferents() {
		return MOTS_DE_PASSE_DIFFERENTS;
	}

	public static String getEmailExisteDeja() {
		return EMAIL_EXISTE_DEJA;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUsernom() {
		return usernom;
	}

	public void setUsernom(String usernom) {
		this.usernom = usernom;
	}

	public String getUserprenom() {
		return userprenom;
	}

	public void setUserprenom(String userprenom) {
		this.userprenom = userprenom;
	}

	

	




}
