package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.User;


@Local
public interface UserService {
	
	public void SaveUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public void updatePw(User user);
	
	public User findPasword(String psw);
	
	public User findByPassword(String psw);
	
	public List<User> FindAll();
	
	public User getUser(String login);
	
	
	public Boolean findByLogin(String login, String passwd);
	
	public Boolean findByIndice(int indice, String login);



}
