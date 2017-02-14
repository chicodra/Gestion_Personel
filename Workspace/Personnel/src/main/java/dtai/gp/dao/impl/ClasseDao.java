package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Classe;
import dtai.gp.util.HibernateUtil;

public class ClasseDao implements DAO<Classe, Integer> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public ClasseDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Classe Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(Obj);
		session.flush();
		tx.commit();
	}

	public void delete(Classe Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(Obj);
		session.flush();
		tx.commit();
	}

	public void update(Classe Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	public Classe find(Integer id) {
		// TODO Auto-generated method stub
		Classe cl = new Classe();
		cl = (Classe) session.load(Classe.class, id);
		return cl;
	}

	public Classe findClasse(Integer cod) {
		// TODO Auto-generated method stub
		Classe classe = new Classe();
		Query query = session
				.createQuery("CLASSE.FINDBYCODE");
		query.setParameter("cod", cod);
		classe = (Classe) query.uniqueResult();
		return classe;
	}
	
	@SuppressWarnings("unchecked")
	public List<Classe> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("CLASSE.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}
