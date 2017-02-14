package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.DetailClasse;
import dtai.gp.util.HibernateUtil;

public class DetailClasseDao implements DAO<DetailClasse, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	public void save(DetailClasse obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}

	public void delete(DetailClasse obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	public void update(DetailClasse obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public DetailClasse find(Integer id) {
		// TODO Auto-generated method stub
		DetailClasse dcl = new DetailClasse();
		dcl = (DetailClasse) session.load(DetailClasse.class, id);
		return dcl;
	}
	public DetailClasse findDetailClasse(Integer code) {
		// TODO Auto-generated method stub
		DetailClasse detailclasse = new DetailClasse();
		Query query = session
				.createQuery("DETAILCLASSE.FINDBYCODE");
		query.setParameter("cod", code);
		detailclasse = (DetailClasse) query.uniqueResult();
		return detailclasse;
	}
	
	@SuppressWarnings("unchecked")
	public List<DetailClasse> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DETAILCLASSE.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
