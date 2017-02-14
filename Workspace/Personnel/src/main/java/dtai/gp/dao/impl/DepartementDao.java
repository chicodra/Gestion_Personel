package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAOGeneric;
import dtai.gp.model.Departement;
import dtai.gp.util.HibernateUtil;

public class DepartementDao implements DAOGeneric<Departement, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public DepartementDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Departement obj) {
		// TODO Auto-generated method stub

	}

	public void delete(Departement obj) {
		// TODO Auto-generated method stub

	}

	public void update(Departement obj) {
		// TODO Auto-generated method stub

	}

	public Departement find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Departement> findAll() {
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
