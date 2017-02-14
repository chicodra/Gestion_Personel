package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import dtai.gp.model.Formation;
import dtai.gp.service.FormationService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class FormationBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private FormationService formationService;
    
    
	private Formation form = new Formation();
    
	private Formation dfmt = new Formation();
	
	private Formation fmt = new Formation();

	private List<Formation> formations = new ArrayList<Formation>();
	
	public String save() {
		String libFormation = form.getLibelleformation();
		form.setLibelleformation(libFormation.toUpperCase());  
		formationService.SaveFormation(form);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Formation  ajouté", null));
		return "/faces/formation.xhtml";

	}
	public String delete(){
		formationService.deleteFormation(dfmt);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Formation  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		formationService.updateFormation(fmt);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Formation mise à jour", null));
		return "/faces/formation.xhtml";
	}

	@PostConstruct
	public void init() {
		formations = formationService.FindAll();
		
	}
	
	public void verifierLibbeleFormation(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String libelleFormation = (String) arg2;
		System.out.println("libelle Formation:" + libelleFormation);
		Formation f = new Formation();
		f = formationService.FindByFormation(libelleFormation);
		if (f != null) {
			String msg = "Ce type formation existe déjà";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}
	
	public FormationService getFormationService() {
		return formationService;
	}
	public void setFormationService(FormationService formationService) {
		this.formationService = formationService;
	}
	public Formation getForm() {
		return form;
	}
	public void setForm(Formation form) {
		this.form = form;
	}
	public Formation getDfmt() {
		return dfmt;
	}
	public void setDfmt(Formation dfmt) {
		this.dfmt = dfmt;
	}
	public Formation getFmt() {
		return fmt;
	}
	public void setFmt(Formation fmt) {
		this.fmt = fmt;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

}
