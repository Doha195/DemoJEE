package dao;

import static org.junit.Assert.*;
import Entities.User;

import org.junit.Test;

public class UserTest {

	@Test
	public void testsaveUser() {
		UserDao userdao = new UserDao();
		//User user = new User( "moroc", "dojjha@gmail.com", "hgjhg");
		//userdao.saveUser(user);
		
	}
	
	@Test 
	public void testupdateuser() {
		UserDao userdao = new UserDao();
		//User user = new User(1, "moroc", "dohaferiadi@gmail.com", "doha");
		//userdao.updateUser(user);
	}
	
	@Test 
	public void testgetuser() {
		UserDao userdao = new UserDao();
		//System.out.println(userdao.getUser(1));
	}
	
	@Test 
	public void testgetAllUser() {
		UserDao userdao = new UserDao();
		System.out.println(userdao.getAllUser());
	}

}
