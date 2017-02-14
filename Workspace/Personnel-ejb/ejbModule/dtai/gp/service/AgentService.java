package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Agent;

@Local
public interface AgentService {

	public void saveAgent(Agent agent);
	
	public void updateAgent(Agent agent);
	
	public void deleteAgent(Agent agent);

	public List<Agent> listerAgents();

	public Agent findByMatricule(String matricule);
	
	public Agent FindMail(String mail);
	
	public Agent FindByMail(String mail);
	
    public Agent FindTel(String tel);
	
	public Agent FindByTel(String tel);

	public boolean ValideMatricule(String matricule);
	
	public List<Agent> FindAll();

	

}
