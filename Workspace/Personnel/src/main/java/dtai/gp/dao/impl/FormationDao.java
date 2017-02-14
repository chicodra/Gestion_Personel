package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Formation;
import dtai.gp.util.HibernateUtil;

public class FormationDao implements DAO<Formation, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	
	public FormationDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void save(Formation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}
	
	public void delete(Formation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}
	
	public void update(Formation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}
	@Override
	public Formation find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Formation findformation(String form) {
		// TODO Auto-generated method stub
		Formation f = new Formation();
		f = (Formation) session.load(Formation.class, form);
		return f;
	}
	
	public Formation findFormation(String form) {
		// TODO Auto-generated method stub
		Formation formation=new Formation();
		Query query=session.createQuery("select for from Formation for where for.libelleformation=:form");
		query.setParameter("form", form);
		formation=(Formation) query.uniqueResult();
		return formation;
	}
	
	@SuppressWarnings("unchecked")
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("FORMATION.FINDALL").list();
	}
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	

}
