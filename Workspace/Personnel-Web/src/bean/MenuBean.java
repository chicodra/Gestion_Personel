package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class MenuBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String page="index";
	
	public String nouvelAgent(){
		
		return "/faces/agents.xhtml";
	}
	public String aceuil(){
		
		return "acceuil.xhtml";
	}
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
