package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailFonction;
import dtai.gp.util.HibernateUtil;

public class DetailFonctionDao implements DAO<DetailFonction, Integer> {
	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public void save(DetailFonction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(DetailFonction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public void update(DetailFonction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public DetailFonction find(Integer id) {
		// TODO Auto-generated method stub
		DetailFonction dfct = new DetailFonction();
		dfct = (DetailFonction) session.load(DetailFonction.class, id);
		return dfct;
	}
	public DetailFonction findDetailFonction(Integer code) {
		// TODO Auto-generated method stub
		DetailFonction detailfonction = new DetailFonction();
		Query query = session
				.createQuery("DETAILFONCTION.FINDBYCODE");
		query.setParameter("cod", code);
		detailfonction = (DetailFonction) query.uniqueResult();
		return detailfonction;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailFonction> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILFONCTION.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
