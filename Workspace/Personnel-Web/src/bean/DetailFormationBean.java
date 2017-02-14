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
import dtai.gp.model.Formation;
import dtai.gp.model.DetailFormation;
import dtai.gp.service.AgentService;
import dtai.gp.service.FormationService;
import dtai.gp.service.DetailFormationService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailFormationBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailFormationService dfService;
    @EJB
    private FormationService fService;
    @EJB
    private AgentService aService;
    
	private DetailFormation dfmt = new DetailFormation();
	private DetailFormation ddfmt = new DetailFormation();
	private DetailFormation dformt = new DetailFormation();
	private List<DetailFormation> dformations = new ArrayList<DetailFormation>();
    private List<Formation> formations = new ArrayList<Formation>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		dfService.SaveDetailFormation(dfmt);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Formation  ajouté", null));
		return "/faces/detailFormation.xhtml";
	}

	public String delete(){
		dfService.deleteDetailFormation(ddfmt);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Formation  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		dfService.updateDetailFormation(dformt);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Formation  mise à jour", null));
		return "/faces/detailFormation.xhtml";
	}

	@PostConstruct
	public void init() {
		dformations = dfService.FindAll();
		formations = fService.FindAll();
		agents = aService.listerAgents();
	}

	public DetailFormationService getDfService() {
		return dfService;
	}

	public void setDfService(DetailFormationService dfService) {
		this.dfService = dfService;
	}

	public FormationService getfService() {
		return fService;
	}

	public void setfService(FormationService fService) {
		this.fService = fService;
	}

	public AgentService getaService() {
		return aService;
	}

	public void setaService(AgentService aService) {
		this.aService = aService;
	}

	public DetailFormation getDfmt() {
		return dfmt;
	}

	public void setDfmt(DetailFormation dfmt) {
		this.dfmt = dfmt;
	}

	public DetailFormation getDdfmt() {
		return ddfmt;
	}

	public void setDdfmt(DetailFormation ddfmt) {
		this.ddfmt = ddfmt;
	}

	public List<DetailFormation> getDformations() {
		return dformations;
	}

	public void setDformations(List<DetailFormation> dformations) {
		this.dformations = dformations;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public DetailFormation getDformt() {
		return dformt;
	}

	public void setDformt(DetailFormation dformt) {
		this.dformt = dformt;
	}
	
}
