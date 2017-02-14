package dtai.gp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dtai.gp.dao.DAO;
import dtai.gp.model.User;
import dtai.gp.util.HibernateUtil;

public class UserDao implements DAO<User, Integer> {

	private Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(User Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.save(Obj);
		session.flush();
		tx.commit();
	}

	public void delete(User Obj) {
		// TODO Auto-generated method stub

	}

	public void update(User Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	public void updatePw(User Obj) {
		// TODO Auto-generated method stub
		tx = session.getTransaction();
		tx.begin();
		session.update(Obj);
		session.flush();
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return session.getNamedQuery("USER.FINDALL").list();
	}

	@SuppressWarnings("unchecked")
	public Boolean findByLogin(String login, String passwd) {
		Boolean res = false;
		org.hibernate.Query query = session.getNamedQuery("USER.FINDBYTOKEN");
		query.setString("login", login);
		query.setString("passwd", passwd);
		List<User> result = new ArrayList<User>();
		result = query.list();

		if (result.size() < 1) {
			res = false;
		} else
			res = true;
		return res;

	}

	public Boolean findByIndice(int indice, String login) {

		Boolean res = false;
		org.hibernate.Query query = session.getNamedQuery("USER.FINDBYINDICE");
		query.setString("login", login);
		query.setInteger("indice", indice);
		User result = new User();
		result = (User) query.uniqueResult();

		if (result != null && result.getTypeActe() != 1) {
			res = false;
		} else
			res = true;
		return res;
	}
	public User findPsw(String psw) {
		// TODO Auto-generated method stub
		User us = new User();
		us = (User) session.load(User.class, psw);
		return us;
	}
	

	public User findPasword(String pws) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			Query query = session
					.createQuery("select user from User user where user.password=:pws ");
			query.setParameter("pws", pws);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getUser(String login) {

		org.hibernate.Query query = session
				.createQuery("select u from User u where u.login=:login");
		query.setString("login", login);
		User result = new User();
		result = (User) query.uniqueResult();
		return result;

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public User find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
