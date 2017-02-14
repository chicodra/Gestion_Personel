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

import dtai.gp.model.Absence;
import dtai.gp.service.AbsenceService;


@javax.faces.bean.ManagedBean
@RequestScoped
public class AbsenceBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private AbsenceService absenceService;
    
    
	private Absence abs = new Absence();
    
	private Absence dabs = new Absence();
	
	private Absence absence = new Absence();


	private List<Absence> absences = new ArrayList<Absence>();
	
	public String save() {
		String libAbsence = abs.getLibelleAbsence();
		abs.setLibelleAbsence(libAbsence.toUpperCase());
		absenceService.SaveAbsence(abs);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Absence  ajouté", null));
		return "/faces/absence.xhtml";

	}
	public String delete(){
		absenceService.deleteAbsence(dabs);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL,
						"Absence  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		absenceService.updateAbsence(absence);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Absence mise à jour", null));
		return "/faces/absence.xhtml";
	}

	@PostConstruct
	public void init() {
		absences = absenceService.FindAll();
		
	}
	
	public void verifierLibbeleAbsence(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String libelleAbscence = (String) arg2;
		System.out.println("libelle Absence:" + libelleAbscence);
		Absence ab = new Absence();
		ab = absenceService.FindByAbsence(libelleAbscence);
		if (ab != null) {
			String msg = "Ce type d'absence existe déjà";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}
	public AbsenceService getAbsenceService() {
		return absenceService;
	}
	public void setAbsenceService(AbsenceService absenceService) {
		this.absenceService = absenceService;
	}
	public Absence getAbs() {
		return abs;
	}
	public void setAbs(Absence abs) {
		this.abs = abs;
	}
	public Absence getDabs() {
		return dabs;
	}
	public void setDabs(Absence dabs) {
		this.dabs = dabs;
	}
	public List<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public Absence getAbsence() {
		return absence;
	}
	public void setAbsence(Absence absence) {
		this.absence = absence;
	}
	
}
