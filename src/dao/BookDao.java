package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Kritik Garg
 *
 */
public class BookDao {

	/**
	 * Method to check is book ever issued or not by book title
	 * 
	 * @param name
	 *            title
	 * @return
	 */
	public boolean isBookIssued(String name) {
		Connection connection = DaoManager.getConnection();
		try {

			String query = "SELECT COUNT(*) AS count from books B "
					+ "INNER JOIN Titles T ON B.title_id = T.title_id "
					+ "LEFT JOIN book_issue I ON B.accession_no = I.accession_no "
					+ "where  T.title_nm = '" + name + "'" + " AND "
					+ "I.accession_no is NULL";

			PreparedStatement st = connection.prepareStatement(query);
			ResultSet resultset = st.executeQuery();

			if (resultset.next()) {
				int x = resultset.getInt("count");
				if (x > 0) {
					return true;
				} else {
					return false;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Method to delete books not used by 1 year
	 */
	public void deleteUnusedBooks() {

		Connection connection = DaoManager.getConnection();
		try {
			String query = "DELETE FROM books WHERE accession_no NOT IN ( "
					+ "SELECT DISTINCT accession_no FROM  book_issue WHERE issue_dt > DATE_SUB(NOW(),INTERVAL 1 YEAR) "
					+ " ) ";

			PreparedStatement st = connection.prepareStatement(query);
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
