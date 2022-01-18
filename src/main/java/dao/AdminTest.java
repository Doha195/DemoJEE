package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import Entities.Admin;

public class AdminTest {

	@Test
	public void testsave() {
		AdminDao admindao = new AdminDao();
		Admin admin = new Admin( "gfgfg", "hhh", "hgg", "12345");
		admindao.saveUser(admin);
	}

}
