package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dtai.gp.model.Service;
import dtai.gp.service.ServiceService;

@javax.faces.bean.ManagedBean
@RequestScoped
public class ServiceBean implements Serializable {
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		@EJB
		private ServiceService sservice;
		
		private Service svc = new Service();
		private Service dserv = new Service();
		private Service s =  new Service();
		private List<Service> services = new ArrayList<Service>();
		
		public String save() {
			sservice.SaveService(svc);;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Service  ajouté", null));
			return "/faces/service.xhtml";

		}
		public String delete(){
			sservice.deleteService(dserv);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Service  supprimé", null));
			return "/welcome.xhtml";
		}
		public String update(){
			sservice.updateService(svc);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Service  mise à jour", null));
			return "/faces/service.xhtml";
		}

		@PostConstruct
		public void init() {
			services = sservice.FindAll();
		}
	
		
		public ServiceService getSservice() {
			return sservice;
		}
		public void setSservice(ServiceService sservice) {
			this.sservice = sservice;
		}
		public Service getSvc() {
			return svc;
		}
		public void setSvc(Service svc) {
			this.svc = svc;
		}
		public Service getDserv() {
			return dserv;
		}
		public void setDserv(Service dserv) {
			this.dserv = dserv;
		}
		public Service getS() {
			return s;
		}
		public void setS(Service s) {
			this.s = s;
		}
		public List<Service> getServices() {
			return services;
		}
		public void setServices(List<Service> services) {
			this.services = services;
		}	
	
	

}
