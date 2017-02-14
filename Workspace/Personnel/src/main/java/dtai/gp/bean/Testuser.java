package dtai.gp.bean;


import org.junit.Test;

import dtai.gp.dao.impl.UserDao;
import dtai.gp.model.User;


public class Testuser {
	UserDao Udao = new UserDao();

	@Test
	public  void TestsaveUser() {

		User user = new User();
		user.setLogin("chico");;
		user.setPassword("passer@1");
		user.setTypeActe(1);;

			Udao.save(user);
			org.junit.Assert.assertEquals("c'est bon !!!",user.getLogin());;

	}
}
