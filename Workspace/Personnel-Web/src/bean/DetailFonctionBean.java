package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dtai.gp.model.Agent;
import dtai.gp.model.DetailFonction;
import dtai.gp.model.Fonction;
import dtai.gp.service.AgentService;
import dtai.gp.service.DetailFonctionService;
import dtai.gp.service.FonctionService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailFonctionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailFonctionService dfservice;
    @EJB
    private FonctionService fservice;
    @EJB
    private AgentService aservice;
    
	private DetailFonction dft = new DetailFonction();
	private DetailFonction dfonc = new DetailFonction();
	private List<DetailFonction> dfonctions = new ArrayList<DetailFonction>();
    private List<Fonction> fonctions = new ArrayList<Fonction>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		dfservice.SaveDetailFonction(dft);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction  ajouté", null));
		return "/faces/detailFonction.xhtml";
	}

	public String delete(){
		dfservice.deleteDetailFonction(dfonc);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		dfservice.updateDetailFonction(dft);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction  mise à jour", null));
		return "/faces/detailFonction.xhtml";
	}

	@PostConstruct
	public void init() {
		dfonctions = dfservice.FindAll();
		fonctions = fservice.FindAll();
		agents = aservice.listerAgents();
	}
	public DetailFonctionService getDfservice() {
		return dfservice;
	}

	public void setDfservice(DetailFonctionService dfservice) {
		this.dfservice = dfservice;
	}

	public FonctionService getFservice() {
		return fservice;
	}

	public void setFservice(FonctionService fservice) {
		this.fservice = fservice;
	}

	public AgentService getAservice() {
		return aservice;
	}

	public void setAservice(AgentService aservice) {
		this.aservice = aservice;
	}

	public DetailFonction getDft() {
		return dft;
	}

	public void setDft(DetailFonction dft) {
		this.dft = dft;
	}

	public DetailFonction getDfonc() {
		return dfonc;
	}

	public void setDfonc(DetailFonction dfonc) {
		this.dfonc = dfonc;
	}

	public List<DetailFonction> getDfonctions() {
		return dfonctions;
	}

	public void setDfonctions(List<DetailFonction> dfonctions) {
		this.dfonctions = dfonctions;
	}

	public List<Fonction> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

}
