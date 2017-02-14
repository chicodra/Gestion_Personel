package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dtai.gp.model.TypeSanction;
import dtai.gp.service.TypeSanctionService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class TypeSanctionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private TypeSanctionService typesanctionservice;
	private TypeSanction typesanction = new TypeSanction();
	private TypeSanction typesanc = new TypeSanction();
	private List<TypeSanction> typesanctions = new ArrayList<TypeSanction>();

	public String save() {
		typesanctionservice.SaveTypeSanction(typesanction);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Type de sanction  ajouté", null));
		return "/faces/typeSanction.xhtml";
	}

	public String delete() {
		typesanctionservice.DeleteTypeSanction(typesanc);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Type de sanction  supprimé", null));
		return "/welcome.xhtml";
	}

	public String update() {
		typesanctionservice.UpdateTypeSanction(typesanction);
		return "/faces/typeSanction.xhtml";
	}

	@PostConstruct
	public void init() {
		typesanctions = typesanctionservice.FindAll();
	}

	public TypeSanctionService getTypesanctionservice() {
		return typesanctionservice;
	}

	public void setTypesanctionservice(TypeSanctionService typesanctionservice) {
		this.typesanctionservice = typesanctionservice;
	}

	public TypeSanction getTypesanction() {
		return typesanction;
	}

	public void setTypesanction(TypeSanction typesanction) {
		this.typesanction = typesanction;
	}

	public TypeSanction getTypesanc() {
		return typesanc;
	}

	public void setTypesanc(TypeSanction typesanc) {
		this.typesanc = typesanc;
	}

	public List<TypeSanction> getTypesanctions() {
		return typesanctions;
	}

	public void setTypesanctions(List<TypeSanction> typesanctions) {
		this.typesanctions = typesanctions;
	}

}
