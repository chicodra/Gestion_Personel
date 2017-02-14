package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.UserDao;
import dtai.gp.model.User;

/**
 * Session Bean implementation class UserServiceBean
 */
@Stateless
@LocalBean
public class UserServiceBean implements UserService {
	
	@Inject
	 private UserDao userDao=new UserDao();
   
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
    public UserServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void SaveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub	
		userDao.update(user);
	}
	@Override
	public void updatePw(User user) {
		// TODO Auto-generated method stub	
		userDao.updatePw(user);
	}
	@Override
	public User findPasword(String psw) {
		// TODO Auto-generated method stub
		return  userDao.findPsw(psw);
	}
	@Override
	public User findByPassword(String psw) {
		// TODO Auto-generated method stub
		return userDao.findPasword(psw);
	}
	
	@Override
	public List<User> FindAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	

	@Override
	public Boolean findByLogin(String login, String passwd) {
		// TODO Auto-generated method stub		
		boolean res=userDao.findByLogin(login, passwd);
		return res;
	}

	@Override
	public User getUser(String login) {
		// TODO Auto-generated method stub
		return userDao.getUser(login);
	}

	public Boolean findByIndice(int indice, String login) {
		// TODO Auto-generated method stub
		boolean res=userDao.findByIndice(indice, login);

		return res;
	}

	


}
