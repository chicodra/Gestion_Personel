package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dtai.gp.model.Corps;
import dtai.gp.service.CorpsService;

@ManagedBean
@RequestScoped
public class CorpsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CorpsService cpservice;

	private Corps cp = new Corps();

	private Corps corp = new Corps();

	private List<Corps> corps = new ArrayList<Corps>();

	public String save() {
		cpservice.SaveCorps(cp);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Corps  ajouté",
						null));
		return "/faces/corps.xhtml";

	}

	public String delete() {
		cpservice.deleteCorps(corp);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Corps  supprimé",
						null));
		return "/welcome.xhtml";
	}

	public String update() {
		cpservice.updateCorps(cp);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Corps  mise à jour",
						null));
		return "/faces/corps.xhtml";
	}

	@PostConstruct
	public void init() {
		 corps = cpservice.FindAll();
	}

	public CorpsService getCpservice() {
		return cpservice;
	}

	public void setCpservice(CorpsService cpservice) {
		this.cpservice = cpservice;
	}

	public Corps getCp() {
		return cp;
	}

	public void setCp(Corps cp) {
		this.cp = cp;
	}

	public Corps getCorp() {
		return corp;
	}

	public void setCorp(Corps corp) {
		this.corp = corp;
	}

	public List<Corps> getCorps() {
		return corps;
	}

	public void setCorps(List<Corps> corps) {
		this.corps = corps;
	}

}
