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
import javax.faces.context.FacesContext;

import dtai.gp.model.Absence;
import dtai.gp.model.Agent;
import dtai.gp.model.Demande;
import dtai.gp.model.Vacation;
import dtai.gp.service.AbsenceService;
import dtai.gp.service.AgentService;
import dtai.gp.service.DemandeService;
import dtai.gp.service.VacationService;


@javax.faces.bean.ManagedBean
@RequestScoped
public class DemandeBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private DemandeService demandeservice;
    @EJB
    private VacationService vservice;
    @EJB
    private AbsenceService absenceservice;
    @EJB
    private AgentService agentservice;
    
	private Demande dmd = new Demande();
    
	private Demande ddmdv = new Demande();
	
	private Demande ddmda = new Demande();
	
	private List<Demande> demandes = new ArrayList<Demande>();
	private List<Demande> demandesVacations = new ArrayList<Demande>();
	private List<Demande> demandesAbsences = new ArrayList<Demande>();
	private List<Vacation> vacations = new ArrayList<Vacation>();
	private List<Agent> agents = new ArrayList<Agent>();
	private List<Absence> absences = new ArrayList<Absence>();
	public String saveVacation() {
		//Date encours
		dmd.setDateDemande(Calendar.getInstance().getTime());
		demandeservice.SaveDemande(dmd);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Demande  ajouté", null));
		return "/faces/demandeVacation.xhtml";

	}
	public String saveAbsence() {
		//Date encours
		dmd.setDateDemande(Calendar.getInstance().getTime());
		Calendar calendar = new GregorianCalendar();
		int nbrjour = dmd.getNombreJour();
		calendar.setTime(dmd.getDateDebutAbsence());
		calendar.add(Calendar.DAY_OF_MONTH, nbrjour);
		java.util.Date dateFinAbsence = calendar.getTime();
		dmd.setDateFinAbsence(dateFinAbsence);
		demandeservice.SaveDemande(dmd);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Demande  ajouté", null));
		return "/faces/demandeAbsence.xhtml";

	}
	public String deleteVacation(){
		demandeservice.deleteVacation(ddmdv);	
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Demande  supprimé", null));
		return "/welcome.xhtml";
	}
	public String deleteAbsence(){
		demandeservice.deleteAbsence(ddmda);	
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Demande  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		demandeservice.updateDemande(dmd);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Demande mise à jour", null));
		return "/welcom.xhtml";
	}

	@PostConstruct
	public void init() {
		demandes = demandeservice.FindAll();
		demandesVacations = demandeservice.FindAllVacation();
		demandesAbsences = demandeservice.FindAllAbsence();
		vacations = vservice.FindAll();
		agents = agentservice.FindAll();
		absences= absenceservice.FindAll();
	}
	
	public DemandeService getDemandeservice() {
		return demandeservice;
	}
	public void setDemandeservice(DemandeService demandeservice) {
		this.demandeservice = demandeservice;
	}
	public Demande getDmd() {
		return dmd;
	}
	public void setDmd(Demande dmd) {
		this.dmd = dmd;
	}
	
	public Demande getDdmdv() {
		return ddmdv;
	}
	public void setDdmdv(Demande ddmdv) {
		this.ddmdv = ddmdv;
	}
	public Demande getDdmda() {
		return ddmda;
	}
	public void setDdmda(Demande ddmda) {
		this.ddmda = ddmda;
	}
	
	public List<Demande> getDemandesVacations() {
		return demandesVacations;
	}
	public void setDemandesVacations(List<Demande> demandesVacations) {
		this.demandesVacations = demandesVacations;
	}
	public List<Demande> getDemandesAbsences() {
		return demandesAbsences;
	}
	public void setDemandesAbsences(List<Demande> demandesAbsences) {
		this.demandesAbsences = demandesAbsences;
	}
	public VacationService getVservice() {
		return vservice;
	}
	public void setVservice(VacationService vservice) {
		this.vservice = vservice;
	}
	public List<Vacation> getVacations() {
		return vacations;
	}
	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}
	public AgentService getAgentservice() {
		return agentservice;
	}
	public void setAgentservice(AgentService agentservice) {
		this.agentservice = agentservice;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public AbsenceService getAbsenceservice() {
		return absenceservice;
	}
	public void setAbsenceservice(AbsenceService absenceservice) {
		this.absenceservice = absenceservice;
	}
	public List<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

}
