package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailAbsence;
import dtai.gp.util.HibernateUtil;

public class DetailAbsenceDao implements DAO<DetailAbsence, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public DetailAbsenceDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(DetailAbsence obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(DetailAbsence obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(DetailAbsence obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	} 

	public DetailAbsence find(Integer id) {
		// TODO Auto-generated method stub
		DetailAbsence dabs = new DetailAbsence();
		dabs = (DetailAbsence) session.load(DetailAbsence.class, id);
		return dabs;
	}
	public DetailAbsence findDetailAbsence(Integer code) {
		// TODO Auto-generated method stub
		DetailAbsence detailabsence = new DetailAbsence();
		Query query = session
				.createQuery("DETAILABSENCE.FINDBYCODE");
		query.setParameter("cod", code);
		detailabsence = (DetailAbsence) query.uniqueResult();
		return detailabsence;
	}
	@SuppressWarnings("unchecked")
	public List<DetailAbsence> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILABSENCE.FINDALL").list();

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	

}
