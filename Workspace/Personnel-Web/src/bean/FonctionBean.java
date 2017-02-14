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
import dtai.gp.model.Fonction;
import dtai.gp.service.FonctionService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class FonctionBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	@EJB
	private FonctionService fservice;


	private Fonction ft = new Fonction();

	private Fonction fonc = new Fonction();

	private List<Fonction> fonctions = new ArrayList<Fonction>();
	
	public String save() {
		fservice.SaveFonction(ft);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction  ajouté", null));
		return "/faces/fonction.xhtml";

	}
	public String delete(){
		fservice.deleteFonction(fonc);	
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction  supprimé", null));
		return "/welcome.xhtml";
	}
	
	public String update(){
		fservice.updateFonction(ft);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Fonction mise à jour", null));
		return "/faces/fonction.xhtml";
	}

	@PostConstruct
	public void init() {
		fonctions = fservice.FindAll();
	}

	public void VerifierCode(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		Integer code = (Integer) arg2;
		System.out.println("Code:" + code);
		Fonction fonction = new Fonction();
		fonction = fservice.findByCode(code);
		if (fonction != null) {
			String msg = "Ce code existe déjà";
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, msg, null));
		}
	}

	public FonctionService getFservice() {
		return fservice;
	}

	public void setFservice(FonctionService fservice) {
		this.fservice = fservice;
	}

	public Fonction getFt() {

		return ft;
	}

	public void setFt(Fonction ft) {
		this.ft = ft;
	}

	public List<Fonction> getFonctions() {
		fonctions = fservice.FindAll();
		return fonctions;
	}

	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}

	public Fonction getFonc() {
		return fonc;
	}

	public void setFonc(Fonction fonc) {
		this.fonc = fonc;
	}

}
