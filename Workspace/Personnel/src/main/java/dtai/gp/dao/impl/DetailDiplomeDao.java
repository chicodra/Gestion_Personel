package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailDiplome;
import dtai.gp.util.HibernateUtil;

public class DetailDiplomeDao implements DAO<DetailDiplome, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	public DetailDiplomeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(DetailDiplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void delete(DetailDiplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
		
	}

	@Override
	public void update(DetailDiplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public DetailDiplome find(Integer id) {
		// TODO Auto-generated method stub
		DetailDiplome ddplm = new DetailDiplome();
		ddplm = (DetailDiplome) session.load(DetailDiplome.class, id);
		return ddplm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailDiplome> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILDIPLOME.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
