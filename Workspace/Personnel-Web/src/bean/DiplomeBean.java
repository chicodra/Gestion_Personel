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

import dtai.gp.model.Diplome;
import dtai.gp.service.DiplomeService;



@javax.faces.bean.ManagedBean
@RequestScoped
public class DiplomeBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		@EJB
		private DiplomeService dService;
		
		private Diplome dip = new Diplome();
		private Diplome ddip = new Diplome();
		private Diplome d =  new Diplome();
		private List<Diplome> diplomes = new ArrayList<Diplome>();
		
		public String save() {
			String libDiplome = dip.getLibellediplome();
			dip.setLibellediplome(libDiplome.toUpperCase());
			dService.SaveDiplome(dip);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Categorie  ajouté", null));
			return "/faces/diplome.xhtml";

		}
		public String delete(){
			dService.deleteDiplome(ddip);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Diplome  supprimé", null));
			return "/welcome.xhtml";
		}
		public String update(){
			dService.updateDiplome(d);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Diplome  mise à jour", null));
			return "/faces/diplome.xhtml";
		}
  
		public void verifierLibDip(FacesContext arg0, UIComponent arg1, Object arg2)
				throws ValidatorException {
			// TODO Auto-generated method stub
			String libelleDip = (String) arg2;
			//System.out.println("libelle Diplome:" + libelleDip);
			Diplome dip = new Diplome();
			dip = dService.FindByDiplome(libelleDip);
			if (dip != null) {
				String msg = "Ce type de Diplome existe déjà";
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
		@PostConstruct
		public void init() {
			diplomes = dService.FindAll();
		}
		
		public DiplomeService getdService() {
			return dService;
		}
		public void setdService(DiplomeService dService) {
			this.dService = dService;
		}
		public Diplome getDip() {
			return dip;
		}
		public void setDip(Diplome dip) {
			this.dip = dip;
		}
		public Diplome getDdip() {
			return ddip;
		}
		public void setDdip(Diplome ddip) {
			this.ddip = ddip;
		}
		public Diplome getD() {
			return d;
		}
		public void setD(Diplome d) {
			this.d = d;
		}
		public List<Diplome> getDiplomes() {
			return diplomes;
		}
		public void setDiplomes(List<Diplome> diplomes) {
			this.diplomes = diplomes;
		}

}
