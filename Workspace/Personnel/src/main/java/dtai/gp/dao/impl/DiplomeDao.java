package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Diplome;
import dtai.gp.util.HibernateUtil;

public class DiplomeDao implements DAO<Diplome, Integer> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	
	public DiplomeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Diplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void delete(Diplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void update(Diplome obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public Diplome find(Integer id) {
		// TODO Auto-generated method stub
		Diplome dip = new Diplome();
		dip = (Diplome) session.load(Diplome.class, id);
		return dip;
	}
	public Diplome finddiplome(String diplome) {
		// TODO Auto-generated method stub
		Diplome dip = new Diplome();
		dip = (Diplome) session.load(Diplome.class, diplome);
		return dip;
	}
	public Diplome findDiplome(String diplome) {
		// TODO Auto-generated method stub
		Diplome dip=new Diplome();
		Query query=session.createQuery("select dpm from Diplome dpm where dpm.libellediplome=:dip");
		query.setParameter("dip", diplome);
		dip=(Diplome) query.uniqueResult();
		return dip;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diplome> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DIPLOME.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
