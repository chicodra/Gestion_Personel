package dtai.gp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Agent;
import dtai.gp.util.HibernateUtil;

public class AgentDao implements DAO<Agent, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public AgentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void save(Agent obj) {
		// TODO Auto-generated method stub
		tx = session.beginTransaction();
		session.save(obj);
		session.flush();
		tx.commit();
	}
	

	public void delete(Agent obj) {
		// TODO Auto-generated method stub
		tx=session.beginTransaction();
		session.delete(obj);
		tx.commit();
	}

	public void update(Agent obj) {
		// TODO Auto-generated method stub
		tx=session.beginTransaction();	
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public Agent find(Integer id) {
		// TODO Auto-generated method stub
		Agent Agent=(Agent) session.load(Agent.class,id);
		return Agent;
	}
	
	public Agent findAgent(String mat) {
		// TODO Auto-generated method stub
		Agent agent=new Agent();
		Query query=session.createQuery("select a from Agent a where a.matricule=:mat");
		query.setParameter("mat", mat);
		agent=(Agent) query.uniqueResult();
		return agent;
	}
	
	public Agent findmail(String mail) {
		// TODO Auto-generated method stub
		Agent a = new Agent();
		a = (Agent) session.load(Agent.class, mail);
		return a;
	}
	
	public Agent findMail(String mail) {
		// TODO Auto-generated method stub
		Agent agent=new Agent();
		Query query=session.createQuery("select agt from Agent agt where agt.mailofficiel=:mail");
		query.setParameter("mail", mail);
		agent=(Agent) query.uniqueResult();
		return agent;
	}
	public Agent findtel(String tel) {
		// TODO Auto-generated method stub
		Agent age = new Agent();
		age = (Agent) session.load(Agent.class, tel);
		return age;
}
	public Agent findTel(String tel) {
		// TODO Auto-generated method stub
		Agent agent=new Agent();
		Query query=session.createQuery("select age from Agent age where age.telofficiel=:tel");
		query.setParameter("tel", tel);
		agent=(Agent) query.uniqueResult();
		return agent;
	}
	@SuppressWarnings("unchecked")
	public List<Agent> findAll() {
		// TODO Auto-generated method stub
		List<Agent> lstAgents= new ArrayList<Agent>();
		Query query=session.getNamedQuery("Agent.FINDALL");
		lstAgents=query.list();
		//logger.info("Liste Agents  Dao :"+lstAgents.size());
		return lstAgents;	
		}
	

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	

}
