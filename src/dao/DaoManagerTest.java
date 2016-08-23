package dao;
/**
 * Test class for DaoManager
 */
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DaoManagerTest {

	@Test
	public void testGetConnection() {
		
		Connection con1 =  DaoManager.getConnection();

		try {
			con1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
