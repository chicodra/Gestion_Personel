package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailCategorie;
import dtai.gp.util.HibernateUtil;

public class DetailCategorieDao implements DAO<DetailCategorie, Integer>{
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	
	public DetailCategorieDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(DetailCategorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void delete(DetailCategorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void update(DetailCategorie obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public DetailCategorie find(Integer id) {
		// TODO Auto-generated method stub
		DetailCategorie dctg = new DetailCategorie();
		dctg = (DetailCategorie) session.load(DetailCategorie.class, id);
		return dctg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailCategorie> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILCATEGORIE.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
