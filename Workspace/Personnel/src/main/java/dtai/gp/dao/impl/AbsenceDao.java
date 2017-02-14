package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Absence;
import dtai.gp.util.HibernateUtil;


public class AbsenceDao implements DAO<Absence, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public AbsenceDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Absence obj) {
		// TODO Auto-generated method stub
				tx = session.getTransaction();
				tx.begin();
				session.save(obj);
				session.flush();
				tx.commit();
	}

	public void delete(Absence obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(Absence obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public Absence find(Integer id) {
		// TODO Auto-generated method stub
		Absence abs = new Absence();
		abs = (Absence) session.load(Absence.class, id);
		return abs;
	}
    
	public Absence findAbsence(Integer cod) {
		// TODO Auto-generated method stub
		Absence absence = new Absence();
		Query query = session
				.createQuery("select ab from Absence ab where ab.idAbsence=:code");
		query.setParameter("code", cod);
		absence = (Absence) query.uniqueResult();
		return absence;
	}
	
	public Absence findabsence(String abs) {
		// TODO Auto-generated method stub
		Absence a = new Absence();
		a = (Absence) session.load(Absence.class, abs);
		return a;
	}
	
	public Absence findAbsence(String abs) {
		// TODO Auto-generated method stub
		Absence absence=new Absence();
		Query query=session.createQuery("select absence from Absence absence where absence.libelleAbsence=:absc");
		query.setParameter("absc", abs);
		absence=(Absence) query.uniqueResult();
		return absence;
	}
	
	@SuppressWarnings("unchecked")
	public List<Absence> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("ABSENCE.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
