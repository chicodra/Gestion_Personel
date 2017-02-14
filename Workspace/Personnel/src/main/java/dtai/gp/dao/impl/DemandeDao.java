package dtai.gp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.Demande;
import dtai.gp.util.HibernateUtil;

public class DemandeDao implements DAO<Demande, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public DemandeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Demande obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(obj);
		session.flush();
		tx.commit();
	}
	
	public void deleteVacation(Demande obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}
	
	public void deleteAbsence(Demande obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	@Override
	public void update(Demande obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(obj);
		session.flush();
		tx.commit();
	}

	public Demande find(Integer id) {
		// TODO Auto-generated method stub
		Demande dmd = new Demande();
		dmd = (Demande) session.load(Demande.class, id);
		return dmd;
	}
	
	public Demande findDemande(Integer cod) {
		// TODO Auto-generated method stub
		Demande demande = new Demande();
		Query query = session
				.createQuery("select d from Demande d where d.idDemande=:code");
		query.setParameter("code", cod);
		demande = (Demande) query.uniqueResult();
		return demande;
	}

	@SuppressWarnings("unchecked")
	public List<Demande> findAllVacation() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DEMANDEVACATION.FINDALL").list();
	}

	@SuppressWarnings("unchecked")
	public List<Demande> findAllAbsence() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DEMANDEABSENCE.FINDALL").list();
	}
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("DEMANDE.FINDALL").list();
	}

	@Override
	public void delete(Demande obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.delete(obj);
		session.flush();
		tx.commit();
	}

	

	

	
}
