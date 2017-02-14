package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailFormation;
import dtai.gp.util.HibernateUtil;

public class DetailFormationDao implements DAO<DetailFormation, Integer> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	
	
	public DetailFormationDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(DetailFormation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}


	@Override
	public void delete(DetailFormation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}


	@Override
	public void update(DetailFormation obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}


	@Override
	public DetailFormation find(Integer id) {
		// TODO Auto-generated method stub
		DetailFormation dfmt = new DetailFormation();
		dfmt = (DetailFormation) session.load(DetailFormation.class, id);
		return dfmt;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DetailFormation> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILFORMATION.FINDALL").list();
	}


	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}

}
