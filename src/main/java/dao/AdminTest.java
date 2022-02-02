package dao;


import Entities.Admin;
import org.junit.jupiter.api.Test;

public class AdminTest {

	@Test
	public void testsave() {
		AdminDao admindao = new AdminDao();
		Admin admin = new Admin( "gfgfg", "hhh", "hgg", "12345");
		admindao.saveUser(admin);
	}

}
