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
import dtai.gp.model.DetailAbsence;
import dtai.gp.service.AbsenceService;
import dtai.gp.service.AgentService;
import dtai.gp.service.DetailAbsenceService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailAbsenceBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailAbsenceService dabService;
    @EJB
    private AbsenceService abService;
    @EJB
    private AgentService agService;
    
	private DetailAbsence dabs = new DetailAbsence();
	private DetailAbsence ddabs = new DetailAbsence();
	private List<DetailAbsence> dabsences = new ArrayList<DetailAbsence>();
    private List<Absence> absences = new ArrayList<Absence>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		Calendar calendar = new GregorianCalendar();
		int nbrjour = dabs.getNombreJour();
		calendar.setTime(dabs.getDateDebutAbsence());
		calendar.add(Calendar.DAY_OF_MONTH, nbrjour);
		java.util.Date dateFinAbsence = calendar.getTime();
		dabs.setDateFinAbsence(dateFinAbsence);
		dabService.SaveDetailAbsence(dabs);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Absence  ajouté", null));
		return "/faces/detailAbsence.xhtml";
	}

	public String delete(){
		dabService.deleteDetailAbsence(ddabs);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Absence  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		dabService.updateDetailAbsence(dabs);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Absence  mise à jour", null));
		return "/faces/detailAbsence.xhtml";
	}

	@PostConstruct
	public void init() {
		dabsences = dabService.FindAll();
		absences = abService.FindAll();
		agents = agService.listerAgents();
	}

	public DetailAbsenceService getDabService() {
		return dabService;
	}

	public void setDabService(DetailAbsenceService dabService) {
		this.dabService = dabService;
	}

	public AbsenceService getAbService() {
		return abService;
	}

	public void setAbService(AbsenceService abService) {
		this.abService = abService;
	}

	public AgentService getAgService() {
		return agService;
	}

	public void setAgService(AgentService agService) {
		this.agService = agService;
	}

	public DetailAbsence getDabs() {
		return dabs;
	}

	public void setDabs(DetailAbsence dabs) {
		this.dabs = dabs;
	}

	public DetailAbsence getDdabs() {
		return ddabs;
	}

	public void setDdabs(DetailAbsence ddabs) {
		this.ddabs = ddabs;
	}

	public List<DetailAbsence> getDabsences() {
		return dabsences;
	}

	public void setDabsences(List<DetailAbsence> dabsences) {
		this.dabsences = dabsences;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

}
