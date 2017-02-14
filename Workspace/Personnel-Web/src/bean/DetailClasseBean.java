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
import dtai.gp.model.Classe;
import dtai.gp.model.DetailClasse;
import dtai.gp.service.AgentService;
import dtai.gp.service.ClasseService;
import dtai.gp.service.DetailClasseService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailClasseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailClasseService dclservice;
    @EJB
    private ClasseService clservice;
    @EJB
    private AgentService aservice;
    
	private DetailClasse dcl = new DetailClasse();
	private DetailClasse dclas = new DetailClasse();
	private List<DetailClasse> dclasses = new ArrayList<DetailClasse>();
    private List<Classe> classes = new ArrayList<Classe>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		dclservice.SaveDetailClasse(dcl);;
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  ajouté", null));
		return "/faces/detailClasse.xhtml";
	}

	public String delete(){
		dclservice.deleteDetailClasse(dclas);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		dclservice.updateDetailClasse(dcl);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  mise à jour", null));
		return "/faces/detailClasse.xhtml";
	}

	@PostConstruct
	public void init() {
		dclasses = dclservice.FindAll();
		classes = clservice.FindAll();
		agents = aservice.listerAgents();
	}

	public DetailClasseService getDclservice() {
		return dclservice;
	}

	public void setDclservice(DetailClasseService dclservice) {
		this.dclservice = dclservice;
	}

	public ClasseService getClservice() {
		return clservice;
	}

	public void setClservice(ClasseService clservice) {
		this.clservice = clservice;
	}

	public AgentService getAservice() {
		return aservice;
	}

	public void setAservice(AgentService aservice) {
		this.aservice = aservice;
	}

	public DetailClasse getDcl() {
		return dcl;
	}

	public void setDcl(DetailClasse dcl) {
		this.dcl = dcl;
	}

	

	public DetailClasse getDclas() {
		return dclas;
	}

	public void setDclas(DetailClasse dclas) {
		this.dclas = dclas;
	}

	public List<DetailClasse> getDclasses() {
		return dclasses;
	}

	public void setDclasses(List<DetailClasse> dclasses) {
		this.dclasses = dclasses;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
}
