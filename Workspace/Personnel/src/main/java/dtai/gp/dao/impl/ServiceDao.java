package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Service;
import dtai.gp.util.HibernateUtil;

public class ServiceDao implements DAO<Service, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	public void save(Service obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}
	public void delete(Service obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}
	public void update(Service obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}
	public Service find(Integer id) {
		// TODO Auto-generated method stub
		Service svc = new Service();
		svc = (Service) session.load(Service.class, id);
		return svc;
	}
	public Service findService(Integer cod) {
		// TODO Auto-generated method stub
		Service service = new Service();
		Query query = session
				.createQuery("select s from Service s where s.idservice=:cod");
		query.setParameter("cod", cod);
		service = (Service) query.uniqueResult();
		return service;
	}
	
	@SuppressWarnings("unchecked")
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("SERVICE.FINDALL").list();
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
}
