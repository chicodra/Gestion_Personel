package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import dtai.gp.model.Affectation;
import dtai.gp.util.HibernateUtil;

public class AffectationDao implements dtai.gp.dao.DAOGeneric<Affectation, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public AffectationDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Affectation obj) {
		// TODO Auto-generated method stub

	}

	public void delete(Affectation obj) {
		// TODO Auto-generated method stub

	}

	public void update(Affectation obj) {
		// TODO Auto-generated method stub

	}

	public Affectation find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Affectation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
