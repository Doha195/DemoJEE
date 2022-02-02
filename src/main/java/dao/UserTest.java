package dao;


import Entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {

	@Test
	public void testsaveUser() {
		UserDao userdao = new UserDao();
		User user = new User( "moroco", "dojjha@gmail.com", "hgjhg");
	    //userdao.saveUser(user);

		 //assertEquals("hgjhg", user.getName());
		
	}
	
	@Test 
	public void testupdateuser() {
		UserDao userdao = new UserDao();
		User user = new User(21, "moroc", "dohaferiadi@gmail.com", "doha");
		//userdao.updateUser(user);
		//assertEquals("doha", user.getName());
	}
	
	@Test 
	public void testgetuser() {
		UserDao userdao = new UserDao();
		userdao.getUser(1);
		assertEquals("doha",userdao.getUser(1).getName());
	}
	
	@Test 
	public void testgetAllUser() {
		UserDao userdao = new UserDao();
		assertFalse(userdao.getAllUser().isEmpty());
	}
	

}
