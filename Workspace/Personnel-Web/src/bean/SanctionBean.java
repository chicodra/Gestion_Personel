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
import dtai.gp.model.DetailSanction;
import dtai.gp.model.TypeSanction;
import dtai.gp.service.AgentService;
import dtai.gp.service.SanctionService;
import dtai.gp.service.TypeSanctionService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class SanctionBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private SanctionService sservice;
	@EJB
	private TypeSanctionService typesanctionservice;
	@EJB
	private AgentService agentservice;
	
	private DetailSanction dtailsanction = new DetailSanction();
	private DetailSanction st = new DetailSanction();
	private DetailSanction sanc= new DetailSanction();
	private List<DetailSanction> sanctions = new ArrayList<DetailSanction>();
	private List<TypeSanction> typesanctions = new ArrayList<TypeSanction>();
	private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		sservice.SaveSanction(st);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sanction  ajouté", null));
		return "/faces/sanction.xhtml";
}
	public String delete(){
		sservice.delete(sanc);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sanction  Supprimé", null));
		return "/welcome.xhtml";
	}
	public String update(){
		sservice.updateSanction(st);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Sanction  mise à jour", null));
		return "/faces/sanction.xhtml";
	}

	@PostConstruct
	public void init() {
		sanctions = sservice.FindAll();
		typesanctions = typesanctionservice.FindAll();
		agents = agentservice.listerAgents();
	}
	public SanctionService getSservice() {
		return sservice;
	}
	public void setSservice(SanctionService sservice) {
		this.sservice = sservice;
	}
	
	public DetailSanction getSt() {
		return st;
	}
	public void setSt(DetailSanction st) {
		this.st = st;
	}
	public DetailSanction getSanc() {
		return sanc;
	}
	public void setSanc(DetailSanction sanc) {
		this.sanc = sanc;
	}
	public List<DetailSanction> getSanctions() {
		return sanctions;
	}
	public void setSanctions(List<DetailSanction> sanctions) {
		this.sanctions = sanctions;
	}
	public TypeSanctionService getTypesanctionservice() {
		return typesanctionservice;
	}
	public void setTypesanctionservice(TypeSanctionService typesanctionservice) {
		this.typesanctionservice = typesanctionservice;
	}
	public List<TypeSanction> getTypesanctions() {
		return typesanctions;
	}
	public void setTypesanctions(List<TypeSanction> typesanctions) {
		this.typesanctions = typesanctions;
	}

	public DetailSanction getDtailsanction() {
		return dtailsanction;
	}
	public void setDtailsanction(DetailSanction dtailsanction) {
		this.dtailsanction = dtailsanction;
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
	
	
}