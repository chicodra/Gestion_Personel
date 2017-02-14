package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dtai.gp.model.Vacation;
import dtai.gp.service.VacationService;


@javax.faces.bean.ManagedBean
@RequestScoped
public class VacationBean  implements Serializable{
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private VacationService vservice;


	private Vacation vc = new Vacation();

	private Vacation dvact = new Vacation();

	private List<Vacation> vacations = new ArrayList<Vacation>();
	
	public String save() {
		vservice.SaveVacation(vc);;
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Vacation  ajouté", null));
		return "/faces/vacation.xhtml";

	}
	public String delete(){
		vservice.deleteVacation(dvact);;	
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Vacation  supprimé", null));
		return "/faces/welcome.xhtml";
	}
	
	public String update(){
		vservice.updateVacation(vc);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Vacation mise à jour", null));
		return "/faces/vacation.xhtml";
	}

	@PostConstruct
	public void init() {
		vacations = vservice.FindAll();
	}
	
	public VacationService getVservice() {
		return vservice;
	}
	public void setVservice(VacationService vservice) {
		this.vservice = vservice;
	}
	public Vacation getVc() {
		return vc;
	}
	public void setVc(Vacation vc) {
		this.vc = vc;
	}
	public Vacation getDvact() {
		return dvact;
	}
	public void setDvact(Vacation dvact) {
		this.dvact = dvact;
	}
	public List<Vacation> getVacations() {
		return vacations;
	}
	public void setVacations(List<Vacation> vacations) {
		this.vacations = vacations;
	}

}
