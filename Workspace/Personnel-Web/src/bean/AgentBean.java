package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import utilitaires.UtilitaireSession;
import dtai.gp.model.Agent;
import dtai.gp.model.Corps;
import dtai.gp.model.Fonction;
import dtai.gp.model.Service;
import dtai.gp.model.User;
import dtai.gp.service.AgentService;
import dtai.gp.service.CorpsService;
import dtai.gp.service.FonctionService;
import dtai.gp.service.ServiceService;
import dtai.gp.service.UserService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class AgentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private AgentService agentService;
	@EJB
	private CorpsService corpsService;
	@EJB
	private FonctionService fonctionService;
	@EJB
	private UserService userService;
    @EJB
    private ServiceService serviceService;
    
	private Agent agent = new Agent();
	private Agent ag = new Agent();
	private Fonction ft= new Fonction();
	private List<Agent> agents= new ArrayList<Agent>();
	private List<Corps> corps= new ArrayList<Corps>();
	private List<Fonction> fonctions=new ArrayList<Fonction>();
	private List<Service> services= new ArrayList<Service>();
	private Agent agentEdit = new Agent();

	HttpSession session = UtilitaireSession.getSession();
	String userLogin = (String) session.getAttribute("userLogin");
	String passWd = (String) session.getAttribute("userPasse");
	User user = new User();

	// method d'enregistrement de l'agent
	public String SaveAgent() {

		// Formatage des donneés saisie en majuscile
		String nom = agent.getNom();
		String prenom = agent.getPrenom();
		agent.setPrenom(prenom.toUpperCase());
		agent.setNom(nom.toUpperCase());

		// Determination Sexe de l'agent en fonction du titre

		/*if (agent.getTitre().equals("MR")) {
			agent.setSexe(1);
		} else {
			agent.setSexe(2);
		}
*/
		// Calcul de la date retraite
		Calendar calendar = new GregorianCalendar();
		int ageRet = agent.getCorps().getAgeRetraite();
		calendar.setTime(agent.getDateNaissance());
		calendar.add(Calendar.YEAR, ageRet);
		java.util.Date dateRetraite = calendar.getTime();

		Calendar calendar1 = new GregorianCalendar();
		calendar1.setTime(dateRetraite);
		calendar1.add(Calendar.MONTH, 1);
		agent.setDateRetraite(dateRetraite);

		agentService.saveAgent(agent);

		user.setLogin(userLogin);
		user.setPassword(passWd);
		user = userService.getUser(userLogin);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Nouvel agent ajouté", null));
		agent = new Agent();
		return "/welcome.xhtml";
	}

	public String EditAgent() {
		Agent ag = new Agent();
		ag = agentService.findByMatricule(agentEdit.getMatricule());

		if (ag.getMatricule() != null) {
			return "/faces/agent.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Cet agent n'existe pas", null));
			return "/faces/searchAgent.xhtml";
		}
	}

	@PostConstruct
	public void init() {

		agents = agentService.listerAgents();
		fonctions = fonctionService.FindAll();
		corps = corpsService.FindAll();
        services = serviceService.FindAll();
	}
	public void verifiermail(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String mail = (String) arg2;
		System.out.println("mail:" + mail);
		Agent ag = new Agent();
		ag = agentService.FindByMail(mail);
		if (ag != null) {
			String msg = "Ce mail existe déjà";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}
	public void verifiertel(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String tel = (String) arg2;
		System.out.println("tel:" + tel);
		Agent agt = new Agent();
		agt = agentService.FindByTel(tel);
		if (agt != null) {
			String msg = "Ce Numero de telephone existe déjà";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}
	public void validateAgent(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String matricule = (String) arg2;
		System.out.println("Matricule:" + matricule);
		// Agent agent=new Agent();
		Agent agent2 = new Agent();
		String msg = "Matricule invalide.Lettre Cle non conforme";
		boolean valid = agentService.ValideMatricule(matricule);
		System.out.println("Valid" + valid);
		if (valid == false) {
			msg = "Matricule invalide.Lettre Cle non conforme";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
			// throw new ValidatorException
			// (FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_WARN,"Cet agent n'existe pas",
			// null)));
		} else {
			// Matricule valide. Recherche si l'agent existe déjà
			agent2 = agentService.findByMatricule(matricule);
			if (agent2 != null) {
				msg = "Cet matricule existe déjà";
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public Agent getAgentEdit() {
		return agentEdit;
	}

	public void setAgentEdit(Agent agentEdit) {
		this.agentEdit = agentEdit;
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

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CorpsService getCorpsService() {
		return corpsService;
	}

	public void setCorpsService(CorpsService corpsService) {
		this.corpsService = corpsService;
	}

	public List<Corps> getCorps() {
		return corps;
	}

	public void setCorps(List<Corps> corps) {
		this.corps = corps;
	}

	public FonctionService getFonctionService() {
		return fonctionService;
	}

	public void setFonctionService(FonctionService fonctionService) {
		this.fonctionService = fonctionService;
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	public Agent getAg() {
		return ag;
	}

	public void setAg(Agent ag) {
		this.ag = ag;
	}

	

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Fonction getFt() {
		return ft;
	}

	public void setFt(Fonction ft) {
		this.ft = ft;
	}

	public ServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}

}
