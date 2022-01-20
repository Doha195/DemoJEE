package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;

import org.junit.Test;

import Entities.User;

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
