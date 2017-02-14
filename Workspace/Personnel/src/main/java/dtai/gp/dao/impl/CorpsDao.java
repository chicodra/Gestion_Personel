package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Corps;
import dtai.gp.util.HibernateUtil;

public class CorpsDao implements DAO<Corps, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public CorpsDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Corps Obj) {
		// TODO Auto-generated method stub
		tx = session.beginTransaction();
		session.save(Obj);
		session.flush();
		tx.commit();
	}

	public void delete(Corps Obj) {
		// TODO Auto-generated method stub
		tx = session.beginTransaction();
		session.delete(Obj);
		tx.commit();
	}

	public void update(Corps Obj) {
		// TODO Auto-generated method stub
		tx = session.beginTransaction();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	public Corps find(Integer id) {
		// TODO Auto-generated method stub
		Corps cps = new Corps();
		cps = (Corps) session.load(Corps.class, id);
		return cps;
	}

	public Corps findCorps(Integer cod) {
		// TODO Auto-generated method stub
		Corps corps = new Corps();
		Query query = session
				.createQuery("select c from Corps c where c.idCorps=:cod");
		query.setParameter("cod", cod);
		corps = (Corps) query.uniqueResult();
		return corps;
	}

	@SuppressWarnings("unchecked")
	public List<Corps> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("CORPS.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
