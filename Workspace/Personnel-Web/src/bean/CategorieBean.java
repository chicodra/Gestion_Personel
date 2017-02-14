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

import dtai.gp.model.Categorie;
import dtai.gp.service.CategorieService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class CategorieBean implements Serializable {
	
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		@EJB
		private CategorieService cservice;
		
		private Categorie cat = new Categorie();
		private Categorie dcat = new Categorie();
		private Categorie c =  new Categorie();
		private List<Categorie> categories = new ArrayList<Categorie>();
		
		public String save() {
			String libCategorie = cat.getLibellecategorie();
			cat.setLibellecategorie(libCategorie.toUpperCase());
			cservice.SaveCategorie(cat);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Categorie  ajouté", null));
			return "/faces/categorie.xhtml";

		}
		public String delete(){
			cservice.deleteCategorie(dcat);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Categorie  supprimé", null));
			return "/welcome.xhtml";
		}
		public String update(){
			cservice.updateCategorie(c);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Categorie  mise à jour", null));
			return "/faces/categorie.xhtml";
		}
  
		public void verifierLibCat(FacesContext arg0, UIComponent arg1, Object arg2)
				throws ValidatorException {
			// TODO Auto-generated method stub
			String libelleCat = (String) arg2;
			System.out.println("libelle Categorie:" + libelleCat);
			Categorie cat = new Categorie();
			cat = cservice.FindByCategorie(libelleCat);
			if (cat != null) {
				String msg = "Ce type de Categorie existe déjà";
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null));
			}
		}
		@PostConstruct
		public void init() {
			categories = cservice.FindAll();
		}
		
		public CategorieService getCservice() {
			return cservice;
		}
		public void setCservice(CategorieService cservice) {
			this.cservice = cservice;
		}
		public Categorie getCat() {
			return cat;
		}
		public void setCat(Categorie cat) {
			this.cat = cat;
		}
		public Categorie getDcat() {
			return dcat;
		}
		public void setDcat(Categorie dcat) {
			this.dcat = dcat;
		}
		public Categorie getC() {
			return c;
		}
		public void setC(Categorie c) {
			this.c = c;
		}
		public List<Categorie> getCategories() {
			return categories;
		}
		public void setCategories(List<Categorie> categories) {
			this.categories = categories;
		}
		
}
