package dtai.gp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.AgentDao;
import dtai.gp.model.Agent;

@Stateless
@LocalBean
public class AgentServiceBean implements AgentService {

	@Inject
	private AgentDao agentDao = new AgentDao();

	public AgentDao getAgentDao() {
		return agentDao;
	}

	public void setAgentDao(AgentDao agentDao) {
		this.agentDao = agentDao;
	}

	public AgentServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveAgent(Agent agent) {
		// TODO Auto-generated method stub
		agentDao.save(agent);
	}
	
	@Override
	public void updateAgent(Agent agent) {
		// TODO Auto-generated method stub
		agentDao.update(agent);

	}

	@Override
	public List<Agent> FindAll() {
		// TODO Auto-generated method stub
		return agentDao.findAll();
	}

	@Override
	public void deleteAgent(Agent agent) {
		// TODO Auto-generated method stub
		agentDao.delete(agent);
	}

	@Override
	public List<Agent> listerAgents() {
		// TODO Auto-generated method stub
				List<Agent> lstAgents= new ArrayList<Agent>();
				lstAgents=agentDao.findAll();
				return lstAgents;	
		}

	@Override
	public Agent findByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return agentDao.findAgent(matricule);
	}

	@Override
	public Agent FindMail(String mail) {
		// TODO Auto-generated method stub
		return agentDao.findmail(mail);
	}
	@Override
	public Agent FindByMail(String mail) {
		// TODO Auto-generated method stub
		return agentDao.findMail(mail);
	}
	
	@Override
	public Agent FindTel(String tel) {
		// TODO Auto-generated method stub
		return agentDao.findtel(tel);
	}

	@Override
	public Agent FindByTel(String tel) {
		// TODO Auto-generated method stub
		return agentDao.findTel(tel);
	}

	@Override
	public boolean ValideMatricule(String matricule) {
		// TODO Auto-generated method stub
		boolean  retour=false;
		String mat=matricule.substring(0, 6);
		String caractMat= matricule.substring(6);
		caractMat.toUpperCase();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		 System.out.println("mat: "+caractMat);
		 int pair=0;
		 int impair=0;
		 int i=0;
		 int j=1;
		 
		 while(i <= 4){
			 String car=mat.substring(i,i+1);
			 int chiffre=Integer.parseInt(car);
			 impair=impair+chiffre;
			 System.out.println("i--car--chiffre--impair :"+i+"--"+car+"--"+chiffre+"--"+impair);
			 i=i+2;
		 }
		 
		 while(j <= 5){
			 String car=mat.substring(j,j+1);
			 int chiffre=Integer.parseInt(car);
			 pair=pair+chiffre;
			 System.out.println("j--car--chiffre--impair :"+j+"--"+car+"--"+chiffre+"--"+pair);
			 j=j+2;
		 }
		 System.out.println("pair:"+pair+" impair: "+impair);
		int pos=pair-impair;
		 int chiffreMat=Math.abs(pos);
		 //int chiffreMat=pair-impair;
		 System.out.println("ChiffreMat :"+chiffreMat);
		 //int position=alphabet.indexOf( caractMat )+1;
		 int position=alphabet.indexOf( caractMat )+1;
		 System.out.println("position: "+position);
		 if(position ==chiffreMat){
			 retour=true;
		 }
		 else if(position ==26 && chiffreMat==0){
			 retour=true;
		 }
		 else{
			 retour=false;
		 }
		return retour;
			}

	
	

	

}
