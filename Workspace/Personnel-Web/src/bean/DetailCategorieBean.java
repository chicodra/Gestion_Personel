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
import dtai.gp.model.Categorie;
import dtai.gp.model.DetailCategorie;
import dtai.gp.service.AgentService;
import dtai.gp.service.CategorieService;
import dtai.gp.service.DetailCategorieService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class DetailCategorieBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private DetailCategorieService dcService;
    @EJB
    private CategorieService cService;
    @EJB
    private AgentService aService;
    
	private DetailCategorie dctg = new DetailCategorie();
	private DetailCategorie ddctg = new DetailCategorie();
	private List<DetailCategorie> dcategories = new ArrayList<DetailCategorie>();
    private List<Categorie> categories = new ArrayList<Categorie>();
    private List<Agent> agents = new ArrayList<Agent>();
	public String save() {
		dcService.SaveDetailCategorie(dctg);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categorie  ajouté", null));
		return "/faces/detailCategorie.xhtml";
	}

	public String delete(){
		dcService.deleteDetailCategorie(ddctg);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categorie  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		dcService.updateDetailCategorie(dctg);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categorie  mise à jour", null));
		return "/faces/detailCategorie.xhtml";
	}

	@PostConstruct
	public void init() {
		dcategories = dcService.FindAll();
		categories = cService.FindAll();
		agents = aService.listerAgents();
	}

	public DetailCategorieService getDcService() {
		return dcService;
	}

	public void setDcService(DetailCategorieService dcService) {
		this.dcService = dcService;
	}

	public CategorieService getcService() {
		return cService;
	}

	public void setcService(CategorieService cService) {
		this.cService = cService;
	}

	public AgentService getaService() {
		return aService;
	}

	public void setaService(AgentService aService) {
		this.aService = aService;
	}

	public DetailCategorie getDctg() {
		return dctg;
	}

	public void setDctg(DetailCategorie dctg) {
		this.dctg = dctg;
	}

	public DetailCategorie getDdctg() {
		return ddctg;
	}

	public void setDdctg(DetailCategorie ddctg) {
		this.ddctg = ddctg;
	}

	public List<DetailCategorie> getDcategories() {
		return dcategories;
	}

	public void setDcategories(List<DetailCategorie> dcategories) {
		this.dcategories = dcategories;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
}
