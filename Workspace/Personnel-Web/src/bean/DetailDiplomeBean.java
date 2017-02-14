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
import dtai.gp.model.DetailDiplome;
import dtai.gp.model.Diplome;
import dtai.gp.service.AgentService;
import dtai.gp.service.DetailDiplomeService;
import dtai.gp.service.DiplomeService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailDiplomeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailDiplomeService ddService;
    @EJB
    private DiplomeService dService;
    @EJB
    private AgentService aService;
    
	private DetailDiplome ddplom = new DetailDiplome();
	private DetailDiplome ddpl = new DetailDiplome();
	private DetailDiplome dd = new DetailDiplome();
	private List<DetailDiplome> ddiplomes = new ArrayList<DetailDiplome>();
    private List<Diplome> diplomes = new ArrayList<Diplome>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		ddService.SaveDetailDiplome(dd);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Diplome  ajouté", null));
		return "/faces/detailDiplome.xhtml";
	}

	public String delete(){
		ddService.deleteDetailDiplome(ddpl);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Diplome  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		ddService.updateDetailDiplome(ddplom);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Diplome  mise à jour", null));
		return "/faces/detailDiplome.xhtml";
	}

	@PostConstruct
	public void init() {
		ddiplomes = ddService.FindAll();
		diplomes = dService.FindAll();
		agents = aService.listerAgents();
	}

	public DetailDiplomeService getDdService() {
		return ddService;
	}

	public void setDdService(DetailDiplomeService ddService) {
		this.ddService = ddService;
	}

	public DiplomeService getdService() {
		return dService;
	}

	public void setdService(DiplomeService dService) {
		this.dService = dService;
	}

	public AgentService getaService() {
		return aService;
	}

	public void setaService(AgentService aService) {
		this.aService = aService;
	}

	public DetailDiplome getDdplom() {
		return ddplom;
	}

	public void setDdplom(DetailDiplome ddplom) {
		this.ddplom = ddplom;
	}

	public DetailDiplome getDdpl() {
		return ddpl;
	}

	public void setDdpl(DetailDiplome ddpl) {
		this.ddpl = ddpl;
	}

	public DetailDiplome getDd() {
		return dd;
	}

	public void setDd(DetailDiplome dd) {
		this.dd = dd;
	}

	public List<DetailDiplome> getDdiplomes() {
		return ddiplomes;
	}

	public void setDdiplomes(List<DetailDiplome> ddiplomes) {
		this.ddiplomes = ddiplomes;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
}
