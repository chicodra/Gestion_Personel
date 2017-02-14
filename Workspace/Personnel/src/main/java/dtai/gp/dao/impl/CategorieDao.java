package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Categorie;
import dtai.gp.util.HibernateUtil;

public class CategorieDao implements DAO<Categorie, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public CategorieDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Categorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(Categorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(Categorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public Categorie find(Integer id) {
		// TODO Auto-generated method stub
		Categorie cat = new Categorie();
		cat = (Categorie) session.load(Categorie.class, id);
		return cat;
	}
	
	public Categorie findcategorie(String categorie) {
		// TODO Auto-generated method stub
		Categorie cat = new Categorie();
		cat = (Categorie) session.load(Categorie.class, categorie);
		return cat;
	}
	public Categorie findCategorie(String categorie) {
		// TODO Auto-generated method stub
		Categorie cat=new Categorie();
		Query query=session.createQuery("select ctg from Categorie ctg where ctg.libellecategorie=:cat");
		query.setParameter("cat", categorie);
		cat=(Categorie) query.uniqueResult();
		return cat;
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("CATEGORIE.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
