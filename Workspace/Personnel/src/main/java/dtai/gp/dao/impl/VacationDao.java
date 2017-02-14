package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Vacation;
import dtai.gp.util.HibernateUtil;

public class VacationDao implements DAO<Vacation, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	
	public void save(Vacation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(Vacation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(Vacation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public Vacation find(Integer id) {
		// TODO Auto-generated method stub
		Vacation vct = new Vacation();
		vct = (Vacation) session.load(Vacation.class, id);
		return vct;
	}
	public Vacation findVacation(Integer cod) {
		// TODO Auto-generated method stub
		Vacation vacation = new Vacation();
		Query query = session
				.createQuery("select v from Vacation v where v.idVacation=:code");
		query.setParameter("code", cod);
		vacation = (Vacation) query.uniqueResult();
		return vacation;
	}


	@SuppressWarnings("unchecked")
	public List<Vacation> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("VACATION.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
