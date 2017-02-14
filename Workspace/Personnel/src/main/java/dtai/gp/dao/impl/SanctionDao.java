package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailSanction;
import dtai.gp.util.HibernateUtil;

public class SanctionDao implements DAO<DetailSanction, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public void save(DetailSanction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(DetailSanction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(DetailSanction obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public DetailSanction find(Integer id) {
		// TODO Auto-generated method stub
		DetailSanction sanc = new DetailSanction();
		sanc = (DetailSanction) session.load(DetailSanction.class, id);
		return sanc;
	}
	
	public DetailSanction findSanction(Integer code) {
		// TODO Auto-generated method stub
		DetailSanction sanction = new DetailSanction();
		Query query = session
				.createQuery("select s from DetailSanction s where s.iddetailsanction=:cod");
		query.setParameter("cod", code);
		sanction = (DetailSanction) query.uniqueResult();
		return sanction;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailSanction> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("SANCTION.FINDALL").list();
	}
}
