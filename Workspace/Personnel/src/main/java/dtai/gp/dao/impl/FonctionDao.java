package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Fonction;
import dtai.gp.util.HibernateUtil;

public class FonctionDao implements DAO<Fonction, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	

	public FonctionDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Fonction Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(Obj);
		session.flush();
		tx.commit();
	}

	public void delete(Fonction Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(Obj);
		session.flush();
		tx.commit();
	}

	public void update(Fonction Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	public Fonction find(Integer id) {
		// TODO Auto-generated method stub
		Fonction fct = new Fonction();
		fct = (Fonction) session.load(Fonction.class, id);
		return fct;
	}

	public Fonction findFonction(Integer cod) {
		// TODO Auto-generated method stub
		Fonction fonction = new Fonction();
		Query query = session
				.createQuery("select f from Fonction f where f.idFonction=:cod");
		query.setParameter("cod", cod);
		fonction = (Fonction) query.uniqueResult();
		return fonction;
	}

	@SuppressWarnings("unchecked")
	public List<Fonction> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("FONCTION.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
