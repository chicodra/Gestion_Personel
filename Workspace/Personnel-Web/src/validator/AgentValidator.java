package validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import dtai.gp.model.Agent;
import dtai.gp.service.AgentService;



@FacesValidator("agentValidator")
public class AgentValidator implements Validator{

	@EJB
	AgentService agentService;
	
	public AgentService getAgentService() {
		return agentService;
	}
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String matricule=(String) arg2;
		System.out.println("Matricule:"+matricule);
		//Agent agent=new Agent();
		Agent agent2=new Agent();
		
		boolean valid=agentService.ValideMatricule(matricule);
		
		if(valid){
			 FacesMessage msg =
		              new FacesMessage("Matricule invalide.Lettre Cle non conforme");
		      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		    
		      throw new ValidatorException(msg);
		}
		else{
			//Matricule valide. Recherche si l'agent existe déjà
			agent2=agentService.findByMatricule(matricule);
			if(agent2!=null){
				FacesMessage msg =
			              new FacesMessage("Cet agent existe déjà");
			      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			    
			      throw new ValidatorException(msg);
			}
		}
	}

}
