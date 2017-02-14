package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.TypeSanction;
import dtai.gp.util.HibernateUtil;

public class TypeSanctionDao implements DAO<TypeSanction, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	

	public void save(TypeSanction Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(Obj);
		session.flush();
		tx.commit();
	}

	public void delete(TypeSanction Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(Obj);
		session.flush();
		tx.commit();
	}

	public void update(TypeSanction Obj) {
		// TODO Auto-generated method stub
		tx=session.getTransaction();
		tx.begin();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	public TypeSanction find(Integer id) {
		// TODO Auto-generated method stub
		TypeSanction typesanction = new TypeSanction();
		typesanction = (TypeSanction) session.load(TypeSanction.class, id);
		return typesanction;
	}

	@SuppressWarnings("unchecked")
	public List<TypeSanction> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("TYPESANCTION.FINDALL").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
