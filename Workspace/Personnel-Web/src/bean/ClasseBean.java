package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dtai.gp.model.Classe;
import dtai.gp.service.ClasseService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class ClasseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ClasseService clservice;

	private Classe cl = new Classe();
	private Classe dclass = new Classe();
	private List<Classe> classes = new ArrayList<Classe>();

	public String save() {
		clservice.SaveClasse(cl);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  ajouté", null));
		return "/faces/classe.xhtml";

	}

	public String delete() {
		clservice.deleteClasse(dclass);;
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  supprimé", null));
		return "/welcome.xhtml";
	}

	public String update() {
		clservice.updateClasse(cl);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Classe  mise à jour", null));
		return "/faces/classe.xhtml";
	}

	@PostConstruct
	public void init() {
		classes = clservice.FindAll();
	}

	public ClasseService getClservice() {
		return clservice;
	}

	public void setClservice(ClasseService clservice) {
		this.clservice = clservice;
	}

	public Classe getCl() {
		return cl;
	}

	public void setCl(Classe cl) {
		this.cl = cl;
	}

	public Classe getDclass() {
		return dclass;
	}

	public void setDclass(Classe dclass) {
		this.dclass = dclass;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

}
