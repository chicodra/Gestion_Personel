package dtai.gp.bean;

import dtai.gp.dao.impl.AgentDao;
import dtai.gp.model.Agent;


public class testHibernate {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out
				.println("Trying to create a test connection with the database.");
		AgentDao dao = new AgentDao();

		Agent agent = new Agent();
		agent.setMatricule("619501H");
		agent.setNom("Fall");
		agent.setPrenom("Aliou");
		agent.setTitre("Mr");
	
		agent.setDateNaissance(new java.util.Date(2015, 01, 01));
			dao.save(agent);
		System.out.println(agent.toString());

	}

}
